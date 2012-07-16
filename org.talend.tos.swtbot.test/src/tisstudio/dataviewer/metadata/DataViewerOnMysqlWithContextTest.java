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
package tisstudio.dataviewer.metadata;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendDBItem;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendSchemaItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataViewerOnMysqlWithContextTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendDBItem dbItem;

    private static final String JOBNAME = "job1";

    private static final String DBNAME = "mysql";

    private static final String TABLENAME = "autotest";

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        repositories.add(ERepositoryObjectType.CONTEXT);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();

        dbItem = new TalendDBItem(DBNAME, Utilities.DbConnectionType.MYSQL);
        dbItem.create();
        String sql = "create table " + TABLENAME + "(age int, name varchar(12));\n " + "insert into " + TABLENAME
                + " values(1, 'a');\n";
        dbItem.executeSQL(sql);
    }

    @Test
    public void testDataViwer() {
        SWTBotShell tempShell = null;
        try {
            dbItem.getItem().doubleClick();
            tempShell = gefBot.shell("Database Connection").activate();
            gefBot.button("Next >").click();
            gefBot.button("Export as context").click();
            gefBot.shell("Create / Edit a context group").activate();
            gefBot.button("Finish").click();
            gefBot.button("Finish").click();
            gefBot.shell("Modification").activate();
            gefBot.button("No").click();
        } catch (WidgetNotFoundException wnfe) {
            tempShell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            tempShell.close();
            Assert.fail(e.getMessage());
        }
        dbItem.retrieveDbSchema(TABLENAME);
        TalendSchemaItem schema = dbItem.getSchema(TABLENAME);

        schema.setComponentType("tMysqlInput");
        Utilities.dndMetadataOntoJob(jobItem.getEditor(), schema.getItem(), schema.getComponentType(), new Point(100, 100));
        SWTBotGefEditPart mysql = getTalendComponentPart(jobItem.getEditor(), "\"" + schema.getItemName() + "\"");
        Assert.assertNotNull("cann't get component " + schema.getComponentType() + "", mysql);

        // dataviewer
        Utilities.dataView(jobItem, mysql, schema.getComponentType());
        int number = gefBot.tree().rowCount();
        Assert.assertEquals("the result is not the expected result", 1, number);
        gefBot.activeShell().close();
    }

    @After
    public void dropTable() {
        String sql = "drop table " + TABLENAME + ";";
        dbItem.executeSQL(sql);
    }

}
