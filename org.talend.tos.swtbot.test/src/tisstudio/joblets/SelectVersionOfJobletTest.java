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

import java.util.Arrays;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class SelectVersionOfJobletTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private static final String JOB_NAME = "jobTest";

    private static final String JOBLET_NAME = "joblet_Test";

    @Before
    public void initialisePrivateField() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.JOBLET);

        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();
    }

    @Test
    public void testSelectVersionOfJoblet() {
        // use component in job
        SWTBotGefEditor jobEditor = jobItem.getEditor();
        Utilities.dndPaletteToolOntoJob(jobEditor, "tJava", new Point(100, 100));
        SWTBotGefEditPart tJava_1 = getTalendComponentPart(jobEditor, "tJava_1");
        Assert.assertNotNull("could not find component 'tJava_1'", tJava_1);

        // refactor job to joblet
        tJava_1.select();
        jobEditor.clickContextMenu("Refactor to Joblet");
        gefBot.shell("New Joblet").activate();
        gefBot.textWithLabel("Name").setText(JOBLET_NAME);
        gefBot.button("Finish").click();
        SWTBotGefEditor jobletEditor = gefBot.gefEditor("Joblet " + JOBLET_NAME + " 0.1");

        // add new version of joblet
        Utilities.dndPaletteToolOntoJoblet(jobletEditor, "tJava", new Point(300, 100));
        SWTBotGefEditPart tJava_2 = getTalendComponentPart(jobletEditor, "tJava_2");
        Assert.assertNotNull("could not find component 'tJava_2'", tJava_2);
        gefBot.menu("File").menu("Save As...").click();
        gefBot.shell("Save As").activate();
        gefBot.button("m").click();
        gefBot.button("Finish").click();

        // assert could select all version of joblet in job
        jobEditor.show();
        SWTBotGefEditPart joblet = getTalendComponentPart(jobEditor, JOBLET_NAME + "_1");
        Assert.assertNotNull("could not find component '" + JOBLET_NAME + "_1'", joblet);
        joblet.select();
        gefBot.viewByTitle("Component").show();
        selecteAllTalendTabbedPropertyListIndex(0);
        String[] expecteds = { "Latest", "0.1", "0.2" };
        String[] actuals = gefBot.ccomboBox(0).items();
        Assert.assertArrayEquals("get wrong version list of joblet {expected is " + Arrays.asList(expecteds) + ", actual is "
                + Arrays.asList(actuals) + "}", expecteds, actuals);
    }

    @After
    public void cleanup() {
        gefBot.closeAllShells();
        gefBot.menu("File").menu("Save All").click();
        try {
            gefBot.waitUntil(Conditions.shellIsActive("Update Detection"), 10000);
            gefBot.button("OK").click();
        } catch (TimeoutException e) {
            // pass exception if shell not found
        }
    }
}
