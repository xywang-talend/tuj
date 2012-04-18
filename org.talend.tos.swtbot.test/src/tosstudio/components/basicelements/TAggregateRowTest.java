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
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.helpers.MetadataHelper;
import org.talend.swtbot.items.TalendDelimitedFileItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class TAggregateRowTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendDelimitedFileItem fileItem;

    private static final String JOBNAME = "jobTest"; //$NON-NLS-1$

    private static final String FILENAME = "fileTest"; //$NON-NLS-1$

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_FILE_DELIMITED);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
        fileItem = new TalendDelimitedFileItem(FILENAME);
        fileItem.setFilePath("test2.csv");
        fileItem.setExpectResultFromFile("tAggregateRowTest.result");
        fileItem.setHeadingRowAsColumnName();
        fileItem.create();
    }

    @Test
    public void tAggregateRowTest() throws IOException, URISyntaxException {
        SWTBotGefEditor jobEditor = jobItem.getEditor();

        Utilities.dndMetadataOntoJob(jobEditor, fileItem.getItem(), "tFileInputDelimited", new Point(50, 100));
        SWTBotGefEditPart tFileInputDelimited = getTalendComponentPart(jobEditor, fileItem.getItemName());
        Assert.assertNotNull("can not get component '" + fileItem.getItemName() + "'", tFileInputDelimited);
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
        try {
            gefBot.tableWithLabel(fileItem.getItemName() + " (Input - Main)").click(1, 4);
            gefBot.ccomboBox("String").setSelection("int | Integer");

            SWTBotTable outputSchemas = gefBot.tableWithLabel("tAggregateRow_1 (Output)");
            outputSchemas.select(1);
            gefBot.buttonWithTooltip("Remove selected items", 1).click();
            String[] columnNames = { "avg", "max", "min" };
            for (int i = 0; i < columnNames.length; i++) {
                int row = 1 + i;
                gefBot.buttonWithTooltip("Add", 1).click();
                outputSchemas.click(row, 2);
                gefBot.text("newColumn").setText(columnNames[i]);
                outputSchemas.click(row, 4);
                gefBot.ccomboBox("String").setSelection("int | Integer");
                outputSchemas.select(row);
            }
            gefBot.button("OK").click();
        } catch (WidgetNotFoundException wnfe) {
            shell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            shell.close();
            Assert.fail(e.getMessage());
        }
        // define the sets holding the operations in the Group By area
        gefBot.buttonWithTooltip("Add", 0).click();
        // define the various operations in the Operations area
        SWTBotTable operationsTable = gefBot.table(1);
        String[] columnNames = { "avg", "max", "min" };
        for (int i = 0; i < columnNames.length; i++) {
            int row = i;
            gefBot.buttonWithTooltip("Add", 1).click();
            // operationsTable.click(row, 1);
            // gefBot.ccomboBox("name").setSelection(columnNames[i]);
            // operationsTable.click(row, 2);
            // gefBot.ccomboBox("count").setSelection(columnNames[i]);
            operationsTable.click(row, 3);
            gefBot.ccomboBox("name").setSelection("point");
            operationsTable.click(row, 4);
            gefBot.checkBox().select();
        }

        JobHelper.connect2TLogRow(jobEditor, tAggregateRow, new Point(450, 100));
        JobHelper.runJob(jobEditor);

        String actualResult = JobHelper.getExecutionResult();
        MetadataHelper.assertResult(actualResult, fileItem);
    }

}
