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
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
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
public class FilterDBDataByConditionTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendDBItem dbItem;

    private static final String JOBNAME = "job1";

    private static final String DBNAME = "mysql";

    private static final String TABLENAME = "dataviewer";

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();

        dbItem = new TalendDBItem(DBNAME, Utilities.DbConnectionType.MYSQL);
        dbItem.create();

        String sql = "create table " + TABLENAME + "(age int, name varchar(12));\n " + "insert into " + TABLENAME
                + " values(1, 'a');\n" + "insert into " + TABLENAME + " values(2, 'b');\n";
        dbItem.executeSQL(sql);

    }

    @Test
    public void testFilterByConditiion() {
        // retrive schema
        dbItem.retrieveDbSchema(TABLENAME);
        TalendSchemaItem schema = dbItem.getSchema(TABLENAME);

        TalendSwtBotForTos swtbot = new TalendSwtBotForTos();
        // test drag db2 input component to workspace
        schema.setComponentType("tMysqlInput");
        Utilities.dndMetadataOntoJob(jobItem.getEditor(), schema.getItem(), schema.getComponentType(), new Point(100, 100));
        SWTBotGefEditPart mysql = swtbot.getTalendComponentPart(jobItem.getEditor(), schema.getComponentLabel());
        Assert.assertNotNull("cann't get component " + schema.getComponentType() + "", mysql);

        // dataviewer
        Utilities.dataView(jobItem, mysql, schema.getComponentType());
        gefBot.textWithLabel("Condition").selectAll().setText("1");
        String result1 = gefBot.tree().cell(0, 1);
        String result2 = gefBot.tree().cell(0, 2);
        Assert.assertEquals("the result is not the expected result", "1a", result1 + result2);
        gefBot.activeShell().close();
    }

    @After
    public void dropTable() {
        String sql = "drop table " + TABLENAME + ";";
        dbItem.executeSQL(sql);
    }

}
