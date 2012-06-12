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
package tosstudio.components.basicelements;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.SWTBotTableExt;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.helpers.MetadataHelper;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class TAggregateRowTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private static final String JOBNAME = "jobTest"; //$NON-NLS-1$

    private static final String FILENAME = "test2.csv"; //$NON-NLS-1$

    @Before
    public void createJob() throws IOException, URISyntaxException {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();

        Utilities.dndPaletteToolOntoJob(jobItem.getEditor(), "tFileInputDelimited", new Point(100, 100));
        SWTBotGefEditPart tFileInputDelimited = getTalendComponentPart(jobItem.getEditor(), "tFileInputDelimited_1");
        Assert.assertNotNull("can not get component 'tFileInputDelimited_1'", tFileInputDelimited);
        tFileInputDelimited.doubleClick();
        gefBot.viewByTitle("Component").setFocus();
        // setting file path
        SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
        gefBot.text(0)
                .selectAll()
                .typeText(
                        "\"" + Utilities.getFileFromCurrentPluginSampleFolder(FILENAME).getAbsolutePath().replace("\\", "/")
                                + "\"", 0);
        // setting header
        gefBot.text(3).selectAll().typeText("1");
        // setting schema
        gefBot.button(4).click();
        gefBot.shell("Schema of tFileInputDelimited_1").activate();
        SWTBotTableExt table = new SWTBotTableExt(gefBot.table(0));
        gefBot.buttonWithTooltip("Add").click();
        table.click(0, "Column");
        gefBot.text("newColumn").setText("name");
        table.select(0);
        gefBot.buttonWithTooltip("Add").click();
        table.click(1, "Column");
        gefBot.text("newColumn").setText("point");
        table.click(1, "Type");
        gefBot.ccomboBox("String").setSelection("int | Integer");
        table.select(1);
        gefBot.button("OK").click();
    }

    @Test
    public void tAggregateRowTest() throws IOException, URISyntaxException {
        SWTBotGefEditor jobEditor = jobItem.getEditor();

        SWTBotGefEditPart tFileInputDelimited = getTalendComponentPart(jobEditor, "tFileInputDelimited_1");
        Utilities.dndPaletteToolOntoJob(jobEditor, "tAggregateRow", new Point(250, 100));
        SWTBotGefEditPart tAggregateRow = getTalendComponentPart(jobEditor, "tAggregateRow_1");
        Assert.assertNotNull("can not get component 'tAggregateRow_1'", tAggregateRow);
        JobHelper.connect(jobEditor, tFileInputDelimited, tAggregateRow);

        tAggregateRow.doubleClick();
        gefBot.viewByTitle("Component").setFocus();
        // edit schema of tAggregateRow
        gefBot.button("Sync columns").click();
        gefBot.button(2).click();
        SWTBotShell shell = gefBot.shell("Schema of tAggregateRow_1").activate();

        SWTBotTableExt outputSchemas = new SWTBotTableExt(gefBot.tableWithLabel("tAggregateRow_1 (Output)"));
        outputSchemas.select(1);
        gefBot.buttonWithTooltip("Remove selected items", 1).click();
        String[] columnNames = { "avg", "max", "min" };
        for (int i = 0; i < columnNames.length; i++) {
            int row = 1 + i;
            gefBot.buttonWithTooltip("Add", 1).click();
            outputSchemas.click(row, "Column");
            gefBot.text("newColumn").setText(columnNames[i]);
            outputSchemas.click(row, "Type");
            gefBot.ccomboBox("String").setSelection("int | Integer");
            outputSchemas.select(row);
        }
        gefBot.button("OK").click();
        gefBot.waitUntil(Conditions.shellCloses(shell));

        // define the columns in Group By
        gefBot.buttonWithTooltip("Add", 0).click();
        // define the columns in Operations
        SWTBotTableExt operationsTable = new SWTBotTableExt(gefBot.table(1));
        for (int i = 0; i < columnNames.length; i++) {
            int row = i;
            gefBot.buttonWithTooltip("Add", 1).click();
            operationsTable.click(row, "Output column");
            gefBot.ccomboBox("name").setSelection(columnNames[i]);
            operationsTable.click(row, "Function");
            gefBot.ccomboBox("count").setSelection(columnNames[i]);
            operationsTable.click(row, "Input column position");
            gefBot.ccomboBox("name").setSelection("point");
            operationsTable.click(row, 4);
            gefBot.checkBox().select();
        }

        JobHelper.connect2TLogRow(jobEditor, tAggregateRow, new Point(450, 100));
        JobHelper.runJob(jobEditor);

        String actualResult = JobHelper.getExecutionResult();
        MetadataHelper.assertResult(actualResult, JobHelper.getExpectResultFromFile("tAggregateRowTest.result"));
    }
}
