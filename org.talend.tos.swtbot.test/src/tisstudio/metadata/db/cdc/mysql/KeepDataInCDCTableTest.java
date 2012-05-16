// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package tisstudio.metadata.db.cdc.mysql;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.Utilities.DbConnectionType;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.items.TalendDBItem;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendSchemaItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class KeepDataInCDCTableTest extends TalendSwtBotForTos {

    private TalendDBItem dbItem, copy_of_dbItem;

    private TalendJobItem jobItem;

    private static final String DB_NAME = "mysql";

    private static final String JOB_NAME = "jobTest";

    private static final String TABLE_NAME = "autotest";

    private boolean isTableCreated = false;

    private boolean isCDCCreated = false;

    private boolean isCDCAdded = false;

    @Before
    public void createDb() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        dbItem = new TalendDBItem(DB_NAME, DbConnectionType.MYSQL);
        dbItem.create();
        copy_of_dbItem = (TalendDBItem) dbItem.copyAndPaste();
        isTableCreated = dbItem.executeSQL("create table " + TABLE_NAME + "(id int, name varchar(20), primary key(id));");
        dbItem.retrieveDbSchema(TABLE_NAME);

        jobItem = new TalendJobItem(JOB_NAME);
    }

    @Test
    public void keepDataInCDCTableTest() throws IOException, URISyntaxException {
        isCDCCreated = dbItem.createCDCWith(copy_of_dbItem);
        isCDCAdded = dbItem.addCDCFor(TABLE_NAME);

        String sql_i = "insert into " + TABLE_NAME + " values(1, 'a');\n";
        String sql_u = "update " + TABLE_NAME + " set name='b' where id=1;\n";
        String sql_d = "delete from " + TABLE_NAME + " where id=1;\n";
        dbItem.executeSQL(sql_i + sql_u + sql_d);

        jobItem.create();
        TalendSchemaItem schema = dbItem.getSchema(TABLE_NAME);
        schema.setComponentType("tMysqlCDC");
        Utilities.dndMetadataOntoJob(jobItem.getEditor(), schema.getItem(), schema.getComponentType(), new Point(100, 100));
        SWTBotGefEditPart tMysqlCDC = getTalendComponentPart(jobItem.getEditor(), schema.getComponentLabel());
        JobHelper.connect2TLogRow(jobItem.getEditor(), tMysqlCDC, new Point(300, 100));

        // setting component 'tMysqlCDC' to keep data in CDC table
        tMysqlCDC.doubleClick();
        gefBot.viewByTitle("Component").setFocus();
        selecteAllTalendTabbedPropertyListIndex(1);
        gefBot.checkBox("Keep data in CDC Table").click();
        jobItem.getEditor().save();

        JobHelper.runJob(jobItem.getEditor());
        String actualResult = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertTrue("did not print out all changed rows - [" + actualResult + "]", actualResult.contains("I")
                && actualResult.contains("U") && actualResult.contains("D"));

        // If tCDCxxx component catch the event and printed, in 'View All Changes' window , corresponding
        // TALEND_CDC_STATE show as 'x'.
        SWTBotShell shell = dbItem.viewAllChangesFor(TABLE_NAME);
        SWTBotTable table = gefBot.table();
        for (int i = 0; i < table.rowCount(); i++) {
            if (!"x".equals(table.cell(i, "TALEND_CDC_STATE"))) {
                shell.close();
                Assert.fail("did not keep data in CDC table");
            }
        }
        shell.close();
    }

    @After
    public void cleanUp() {
        if (isCDCAdded)
            dbItem.deactivateCDCFor(TABLE_NAME);
        if (isCDCCreated)
            dbItem.deleteCDC();
        String sql = "";
        if (isTableCreated)
            sql = sql + "drop table " + TABLE_NAME + ";\n";
        dbItem.executeSQL(sql);
    }
}
