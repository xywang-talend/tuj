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

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities.DbConnectionType;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.helpers.MetadataHelper;
import org.talend.swtbot.items.TalendDBItem;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendSchemaItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class UseCDCComponentInJobTest extends TalendSwtBotForTos {

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
    public void useCDCComponentInJobTest() throws IOException, URISyntaxException {
        isCDCCreated = dbItem.createCDCWith(copy_of_dbItem);
        isCDCAdded = dbItem.addCDCFor(TABLE_NAME);

        String sql_i = "insert into " + TABLE_NAME + " values(1, 'a');\n";
        String sql_u = "update " + TABLE_NAME + " set name='b' where id=1;\n";
        String sql_d = "delete from " + TABLE_NAME + " where id=1;\n";
        dbItem.executeSQL(sql_i + sql_u + sql_d);

        jobItem.create();
        TalendSchemaItem schema = dbItem.getSchema(TABLE_NAME);
        schema.setComponentType("tMysqlCDC");
        MetadataHelper.output2Console(jobItem.getEditor(), schema);
        String actualResult = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertTrue("did not print out all changed rows - [" + actualResult + "]", actualResult.contains("I")
                && actualResult.contains("U") && actualResult.contains("D"));

        // After the first run of the job, all changed rows affected to this subscriber must be deleted
        JobHelper.runJob(jobItem.getEditor());
        actualResult = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertEquals("after the first run of the job, all changed rows affected to this subscriber haven't been deleted",
                "", actualResult);
    }

    @After
    public void cleanUp() {
        if ("Execute SQL Statement".equals(gefBot.activeShell().getText())) {
            if ("OK".equals(gefBot.button(0).getText()))
                gefBot.button("OK").click();
            else
                gefBot.button("Cancel").click();
        }

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
