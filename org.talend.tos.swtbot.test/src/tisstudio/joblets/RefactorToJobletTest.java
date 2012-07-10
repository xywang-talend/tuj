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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class RefactorToJobletTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem, jobItem2;

    private static final String JOBNAME = "jobTest";

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();

    }

    @Test
    public void testRefactorToJoblet() {
        SWTBotGefEditor jobEditor = jobItem.getEditor();
        // drag tjava to job and refactor it
        String text = "System.out.println(\"hello\");";
        SWTBotGefEditPart tJava_1 = Utilities.useTJavaAndSetText(jobEditor, text);
        jobEditor.save();

        jobEditor.select(tJava_1).setFocus();
        tJava_1.click();
        jobEditor.clickContextMenu("Refactor to Joblet");
        gefBot.shell("New Joblet").activate();
        gefBot.textWithLabel("Name").typeText(JOBNAME);
        gefBot.button("Finish").click();

        // drag the created joblet to a new job,and run the new job
        jobItem2 = new TalendJobItem("jobTest2");
        jobItem2.create();
        Utilities.dndPaletteToolOntoJob(jobItem2.getEditor(), JOBNAME, new Point(100, 100));
        SWTBotGefEditPart joblet = getTalendComponentPart(jobItem2.getEditor(), JOBNAME + "_1");
        Assert.assertNotNull("cann't get joblet,maybe the job is  refactor failed to joblet ", joblet);

        JobHelper.runJob(jobItem2.getEditor());
        String result = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertEquals("it's not the expected result", "hello", result);

    }
}
