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
package tisstudio.joblets;

import junit.framework.Assert;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.SWTBotTableExt;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendJobletItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class JobletWithInputOutputTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendJobletItem jobletItem;

    private static final String JOB_NAME = "jobTest";

    private static final String JOBLET_NAME = "jobletTest";

    @Before
    public void initialisePrivateField() {
        repositories.add(ERepositoryObjectType.JOBLET);
        repositories.add(ERepositoryObjectType.PROCESS);

        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();
        jobletItem = new TalendJobletItem(JOBLET_NAME);
        jobletItem.create();
    }

    @Test
    public void testWithInputOutput() {
        // config joblet with input output
        SWTBotGefEditor jobletEditor = jobletItem.getEditor();
        jobletEditor.show();
        SWTBotGefEditPart input = getTalendComponentPart(jobletEditor, "INPUT_1");
        SWTBotGefEditPart output = getTalendComponentPart(jobletEditor, "OUTPUT_1");

        // config schema of input
        input.doubleClick();
        gefBot.viewByTitle("Component").show();
        gefBot.button(2).click(); // click button with label 'Edit schema'
        gefBot.shell("Schema of INPUT_1").activate();
        /* Add column "name" */
        SWTBotTableExt schemaTable = new SWTBotTableExt(gefBot.table(0));
        gefBot.buttonWithTooltip("Add").click();
        schemaTable.click(0, "Column");
        gefBot.text("newColumn").setText("name");
        schemaTable.select(0);
        gefBot.button("OK").click();

        // connet to output
        JobHelper.connect(jobletEditor, input, output);

        jobletEditor.saveAndClose();

        // use joblet in job
        SWTBotGefEditor jobEditor = jobItem.getEditor();
        jobEditor.show();
        Utilities.dndMetadataOntoJob(jobEditor, jobletItem.getItem(), null, new Point(300, 100));
        SWTBotGefEditPart joblet = getTalendComponentPart(jobEditor, jobletItem.getItemName());

        // use a tRowGenerator as input
        Utilities.dndPaletteToolOntoJob(jobEditor, "tRowGenerator", new Point(100, 100));
        SWTBotGefEditPart tRowGenerator = getTalendComponentPart(jobEditor, "tRowGenerator_1");

        // use a tLogRow as output
        Utilities.dndPaletteToolOntoJob(jobEditor, "tLogRow", new Point(500, 100));
        SWTBotGefEditPart tLogRow = getTalendComponentPart(jobEditor, "tLogRow_1");

        // config tRowGenerator
        tRowGenerator.doubleClick();
        SWTBotShell shell = gefBot.shell(getBuildTitle() + " - tRowGenerator - tRowGenerator_1").activate();
        /* Add column "name" */
        schemaTable = new SWTBotTableExt(gefBot.table(0));
        gefBot.buttonWithTooltip("Add").click();
        schemaTable.click(0, "Column");
        gefBot.text("newColumn").setText("name");
        schemaTable.click(0, "Functions");
        gefBot.ccomboBox().setSelection("...");
        schemaTable.select(0);
        /* Set value to schema */
        SWTBotTableExt functionTable = new SWTBotTableExt(gefBot.tableWithLabel("Set your own expression."));
        functionTable.click(0, "Value");
        gefBot.text(1).setText("\"Test OK\"");
        functionTable.select(0);
        /* Set number of rows */
        gefBot.textWithLabel("Number of Rows for RowGenerator").setText("1");

        gefBot.button("OK").click();
        gefBot.waitUntil(Conditions.shellCloses(shell));

        // connect tRowGenerator and joblet
        JobHelper.connect(jobEditor, tRowGenerator, joblet);

        // connect joblet and tLogRow
        JobHelper.connect(jobEditor, joblet, tLogRow, "Joblet OUTPUT_1");

        JobHelper.runJob(jobEditor);

        String actualResult = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertEquals("running job fail with joblet", "Test OK", actualResult);
    }
}
