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

@RunWith(SWTBotJunit4ClassRunner.class)
public class JobletCircularReferenceTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private static final String JOB_NAME = "jobTest";

    @Before
    public void initialisePrivateField() {
        repositories.add(ERepositoryObjectType.JOBLET);
        repositories.add(ERepositoryObjectType.PROCESS);

        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();
    }

    @Test
    public void testJobletCircularReference() {
        // use a component in job
        SWTBotGefEditor jobEditor = jobItem.getEditor();
        Utilities.dndPaletteToolOntoJob(jobEditor, "tJava", new Point(100, 100));

        // refactor job to joblet1
        SWTBotGefEditPart tJava = getTalendComponentPart(jobEditor, "tJava_1");
        Assert.assertNotNull("could not get component 'tJava'", tJava);
        tJava.select();
        jobEditor.clickContextMenu("Refactor to Joblet");
        gefBot.shell("New Joblet").activate();
        String jobletName1 = "jobletTest1";
        gefBot.textWithLabel("Name").setText(jobletName1);
        gefBot.button("Finish").click();
        SWTBotGefEditor jobletEditor1 = gefBot.gefEditor("Joblet " + jobletName1 + " 0.1");

        // refactor joblet1 to joblet2
        tJava = getTalendComponentPart(jobletEditor1, "tJava_1");
        Assert.assertNotNull("could not get component 'tJava'", tJava);
        tJava.select();
        jobletEditor1.clickContextMenu("Refactor to Joblet");
        gefBot.shell("New Joblet").activate();
        String jobletName2 = "jobletTest2";
        gefBot.textWithLabel("Name").setText(jobletName2);
        gefBot.button("Finish").click();
        SWTBotGefEditor jobletEditor2 = gefBot.gefEditor("Joblet " + jobletName2 + " 0.1");

        // test could not use joblet1 in joblet2
        Utilities.dndPaletteToolOntoJoblet(jobletEditor2, jobletName1, new Point(300, 100));
        Assert.assertNull("joblet should not circular reference", getTalendComponentPart(jobletEditor2, jobletName1 + "_1"));
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
