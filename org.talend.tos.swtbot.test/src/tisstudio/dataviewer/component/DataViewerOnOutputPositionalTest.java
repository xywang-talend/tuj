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

import junit.framework.Assert;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.SWTBotTableExt;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataViewerOnOutputPositionalTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private static final String JOBNAME = "job1"; //$NON-NLS-1$

    private static final String FILEPATH = "output_positional.txt"; //$NON-NLS-1$

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();

    }

    @Test
    public void testDataViewer() throws IOException, URISyntaxException {
        // drag output component to job
        Utilities.dndPaletteToolOntoJob(jobItem.getEditor(), "tFileOutputPositional", new Point(100, 100));
        SWTBotGefEditPart output = getTalendComponentPart(jobItem.getEditor(), "tFileOutputPositional_1");
        Assert.assertNotNull("can not get component 'tFileOutputPositional_1'", output);
        output.click();
        gefBot.viewByTitle("Component").setFocus();
        // set the filepath
        SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
        String folderPath = Utilities.getFileFromCurrentPluginSampleFolder(FILEPATH).getAbsolutePath();
        folderPath = "\"" + folderPath.replace("\\", "/") + "\"";
        gefBot.sleep(1000);
        gefBot.text(0).selectAll().typeText(folderPath);

        // edit schema of file
        gefBot.button(4).click();
        gefBot.shell("Schema of tFileOutputPositional_1").activate();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.button("OK").click();
        gefBot.shell("Confirm").activate();
        gefBot.button("OK").click();

        new SWTBotTableExt(gefBot.table(0)).click(0, "Size");
        gefBot.text(2).typeText("6");
        gefBot.table(0).select(0);
        new SWTBotTableExt(gefBot.table(0)).click(1, "Size");
        gefBot.text(2).typeText("6");
        gefBot.table(0).select(1);

        // drag trowGenenrator to job
        Utilities.dndPaletteToolOntoJob(jobItem.getEditor(), "tRowGenerator", new Point(100, 200));
        SWTBotGefEditPart tRowGenerator = getTalendComponentPart(jobItem.getEditor(), "tRowGenerator_1");
        Assert.assertNotNull("can not get component 'tRowGenerator_1'", tRowGenerator);

        JobHelper.connect(jobItem.getEditor(), tRowGenerator, output);
        gefBot.button("Yes").click();

        // set edit schema of tRowGenerator
        tRowGenerator.doubleClick();

        gefBot.shell(getBuildTitle() + " - tRowGenerator - tRowGenerator_1").activate();

        gefBot.tableWithLabel("Schema").click(0, 11);

        gefBot.tableWithLabel("Set your own expression.").click(0, 2);
        gefBot.text(1).setText("\"a\"");
        gefBot.tableWithLabel("Set your own expression.").select(0);

        gefBot.tableWithLabel("Schema").click(1, 11);
        gefBot.tableWithLabel("Set your own expression.").click(0, 2);
        gefBot.text(1).setText("\"b\"");
        gefBot.tableWithLabel("Set your own expression.").select(0);

        gefBot.textWithLabel("Number of Rows for RowGenerator").setText("1");

        gefBot.button("OK").click();

        // run job
        JobHelper.runJob(JOBNAME);

        // data viewer
        Utilities.dataView(jobItem, output, "tFileOutputPositional");
        String result1 = gefBot.tree().cell(0, 1);
        String result2 = gefBot.tree().cell(0, 2);
        Assert.assertEquals("the result is not the expected result", "ab", result1 + result2);
        gefBot.button("Close").click();

    }

}
