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

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withLabel;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.DndUtil;
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
public class TMapErrorRejectInJobletTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendJobletItem jobletItem;

    private static final String JOB_NAME = "jobTest";

    private static final String JOBLET_NAME = "jobletTest";

    @Before
    public void initialisePrivateField() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.JOBLET);

        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();
        jobletItem = new TalendJobletItem(JOBLET_NAME);
        jobletItem.create();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testTMapErrorRejectInJoblet() {
        // config schema of input in joblet
        SWTBotGefEditor jobletEditor = jobletItem.getEditor();
        SWTBotGefEditPart input = getTalendComponentPart(jobletEditor, "INPUT_1");
        Assert.assertNotNull("could not get component 'INPUT_1'", input);
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

        // add tMap to joblet and connect input
        Utilities.dndPaletteToolOntoJoblet(jobletEditor, "tMap", new Point(200, 50));
        SWTBotGefEditPart tMap_1 = getTalendComponentPart(jobletEditor, "tMap_1");
        Assert.assertNotNull("could not get component 'tMap_1'", tMap_1);
        JobHelper.connect(jobletEditor, input, tMap_1);

        // config tMap
        tMap_1.doubleClick();
        SWTBotShell shell = gefBot.shell(getBuildTitle() + " - tMap - tMap_1");
        DndUtil dndUtil = new DndUtil(shell.display);
        try {
            /* add a output and drag input schema to output */
            gefBot.toolbarButtonWithTooltip("Add output table").click();
            gefBot.shell("Add a output").activate();
            gefBot.button("OK").click();
            gefBot.waitUntil(Conditions.waitForWidget(allOf(widgetOfType(Table.class), withLabel("out1")), shell.widget), 60000);
            dndUtil.dragAndDrop(gefBot.tableWithLabel("row1").getTableItem(0), gefBot.tableWithLabel("out1"));
            gefBot.waitUntil(Conditions.tableHasRows(gefBot.tableWithLabel("out1"), 1), 60000);
            gefBot.tableWithLabel("out1").doubleClick(0, 1);
            gefBot.text("row1.name ").setText("Float.valueOf(row1.name).toString()");
        } catch (Exception e) {
            gefBot.button("Apply").click();
            gefBot.button("Cancel").click();
            Assert.fail(e.getMessage() + " Cause: " + e.getCause().getMessage());
        }
        /* deselect 'Die on error' */
        gefBot.toolbarButtonWithTooltip("Setup the configurations of tMap").click();
        gefBot.shell("Property Settings").activate();
        gefBot.checkBox("Die on error").deselect();
        gefBot.button("OK").click();
        gefBot.button("Apply").click();
        gefBot.button("Ok").click();

        // connect tMap out1 to output1
        SWTBotGefEditPart output_1 = getTalendComponentPart(jobletEditor, "OUTPUT_1");
        Assert.assertNotNull("could not get component 'OUTPUT_1'", output_1);
        JobHelper.connect(jobletEditor, tMap_1, output_1, "out1");

        // use another output for tMap error reject
        Utilities.dndPaletteToolOntoJoblet(jobletEditor, "Output", new Point(400, 50));
        SWTBotGefEditPart output_2 = getTalendComponentPart(jobletEditor, "OUTPUT_2");
        Assert.assertNotNull("could not get component 'OUTPUT_2'", output_2);
        JobHelper.connect(jobletEditor, tMap_1, output_2, "ErrorReject");

        jobletEditor.saveAndClose();

        // config tRowGenerator in job
        SWTBotGefEditor jobEditor = jobItem.getEditor();
        jobEditor.show();
        Utilities.dndPaletteToolOntoJob(jobEditor, "tRowGenerator", new Point(100, 100));
        SWTBotGefEditPart tRowGenerator = getTalendComponentPart(jobEditor, "tRowGenerator_1");

        // config tRowGenerator
        tRowGenerator.doubleClick();
        gefBot.shell(getBuildTitle() + " - tRowGenerator - tRowGenerator_1").activate();
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

        // use joblet in job and connect to tRowGenerator
        Utilities.dndMetadataOntoJob(jobEditor, jobletItem.getItem(), null, new Point(300, 100));
        SWTBotGefEditPart joblet = getTalendComponentPart(jobEditor, jobletItem.getItemName());
        JobHelper.connect(jobEditor, tRowGenerator, joblet);

        // use tLogRow for output
        JobHelper.connect2TLogRow(jobEditor, joblet, "Joblet OUTPUT_1", new Point(500, 50), "tLogRow_1");
        JobHelper.connect2TLogRow(jobEditor, joblet, "Joblet OUTPUT_2", new Point(500, 250), "tLogRow_2");

        // run job and assert job running result
        JobHelper.runJob(jobEditor);
        String expected = "For input string: \"Test OK\"|java.lang.NumberFormatException: For input string: \"Test OK\"\n\t"
                + "at sun.misc.FloatingDecimal.readJavaFormatString(Unknown Source)\n\t"
                + "at java.lang.Float.valueOf(Unknown Source)";
        String actual = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertTrue("get wrong error reject for tMap", actual.contains(expected));
    }
}
