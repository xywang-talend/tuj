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
package tisstudio.dataviewer.component;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.items.TalendDBItem;
import org.talend.swtbot.items.TalendDelimitedFileItem;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendSchemaItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataViewerOnDatabasesComponentsTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem1;

    private TalendJobItem jobItem2;

    private TalendDBItem dbItem;

    private TalendDelimitedFileItem metadataItem;

    private static final String OUTPUTJOBNAME = "output"; //$NON-NLS-1$

    private static final String INPUTJOBNAME = "input"; //$NON-NLS-1$

    private static final String METADATA_NAME = "delimitedFile"; //$NON-NLS-1$

    private static final String DB_NAME = "testDB"; //$NON-NLS-1$

    private static final String FILENAME = "test.csv.result"; //$NON-NLS-1$

    @Before
    public void createJob() throws IOException, URISyntaxException {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        repositories.add(ERepositoryObjectType.METADATA_FILE_DELIMITED);
        dbItem = new TalendDBItem(DB_NAME, Utilities.DbConnectionType.MYSQL);
        dbItem.create();
        String sql = "create table dataviwer(age int, name varchar(12));\n";
        dbItem.executeSQL(sql);
        dbItem.retrieveDbSchema("dataviwer");

        metadataItem = new TalendDelimitedFileItem(METADATA_NAME);
        metadataItem.create();

        jobItem1 = new TalendJobItem(OUTPUTJOBNAME);
        jobItem1.create();

    }

    @Test
    public void testComponent() {
        // test tMysqlOutput component
        SWTBotGefEditor jobEditor1 = jobItem1.getEditor();

        metadataItem.setComponentType("tFileInputDelimited");
        Utilities.dndMetadataOntoJob(jobEditor1, metadataItem.getItem(), metadataItem.getComponentType(), new Point(100, 100));
        SWTBotGefEditPart dfile = getTalendComponentPart(jobEditor1, metadataItem.getItemName());
        Assert.assertNotNull("can not get component '" + metadataItem.getComponentType() + "'", dfile);

        TalendSchemaItem schema = dbItem.getSchema("dataviwer");
        schema.setComponentType("tMysqlOutput");
        Utilities.dndMetadataOntoJob(jobEditor1, schema.getItem(), schema.getComponentType(), new Point(200, 100));
        SWTBotGefEditPart table = getTalendComponentPart(jobEditor1, schema.getItemName());
        Assert.assertNotNull("can not get component '" + schema.getComponentType() + "'", table);

        JobHelper.connect(jobEditor1, dfile, table);
        gefBot.button("Yes").click();
        JobHelper.runJob(OUTPUTJOBNAME);
        jobEditor1.select(table).setFocus();
        table.click();
        jobEditor1.clickContextMenu("Data viewer");
        gefBot.waitUntil(Conditions.shellIsActive("Data Preview: tMysqlOutput_1"), 20000);
        gefBot.shell("Data Preview: tMysqlOutput_1").activate();
        int out = gefBot.tree().rowCount();
        Assert.assertEquals("didn't show the data viewer", 12, out);
        gefBot.button("Close").click();

        // test tMysqlInput component
        jobItem2 = new TalendJobItem(INPUTJOBNAME);
        jobItem2.create();
        schema.setComponentType("tMysqlInput");
        Utilities.dndMetadataOntoJob(jobItem2.getEditor(), schema.getItem(), schema.getComponentType(), new Point(100, 100));
        SWTBotGefEditPart tab = getTalendComponentPart(jobItem2.getEditor(), schema.getItemName());
        JobHelper.connect2TLogRow(jobItem2.getEditor(), tab, new Point(200, 100));
        JobHelper.runJob(INPUTJOBNAME);
        String result = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertEquals("the result is not the expected", JobHelper.getExpectResultFromFile(FILENAME), result);
        jobItem2.getEditor().select(tab).setFocus();
        tab.click();
        jobEditor1.clickContextMenu("Data viewer");
        gefBot.waitUntil(Conditions.shellIsActive("Data Preview: tMysqlOutput_1"), 20000);
        gefBot.shell("Data Preview: tMysqlInput_1").activate();
        int in = gefBot.tree().rowCount();
        Assert.assertEquals("didn't show the data viewer", 12, in);
        gefBot.button("Close").click();

    }

    @After
    public void removePreviousCreateItems() {
        String sql = "drop table dataviwer;\n";
        dbItem.executeSQL(sql);
    }

}
