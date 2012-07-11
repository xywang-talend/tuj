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
import org.talend.swtbot.items.TalendJobletItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class JobletWith1TriggerOutputTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendJobletItem jobletItem;

    private static final String JOBNAME = "jobTest";

    private static final String JOBLETNAME = "jobletTest";

    @Before
    public void createJobandJoblet() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.JOBLET);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();

        jobletItem = new TalendJobletItem(JOBLETNAME);
        jobletItem.create();
    }

    @Test
    public void testJobletWith1TriggerOutput() {
        SWTBotGefEditor jobEditor = jobItem.getEditor();
        SWTBotGefEditor jobletEditor = jobletItem.getEditor();

        // drag tJava and Trigger output to joblet
        jobletItem.clearInputandOutput();
        String text = "System.out.println(\"output\");";
        SWTBotGefEditPart tJava_1 = Utilities.useTJavaAndSetText(jobletEditor, text);
        Utilities.dndPaletteToolOntoJoblet(jobletEditor, "Trigger Output", new Point(300, 100));
        SWTBotGefEditPart triggerOutput = getTalendComponentPart(jobletEditor, "TRIGGER_OUTPUT_1");
        Assert.assertNotNull("cann't get component Trigger output", triggerOutput);
        JobHelper.connect(jobletEditor, tJava_1, triggerOutput, "Trigger", "On Subjob Ok");
        jobletEditor.saveAndClose();

        // drag tJava and joblet into job,and run job
        String text2 = "System.out.println(\"hello\");";
        SWTBotGefEditPart tJava_2 = Utilities.useTJavaAndSetText(jobEditor, text2);
        Utilities.dndMetadataOntoJob(jobEditor, jobletItem.getItem(), null, new Point(300, 100));
        SWTBotGefEditPart joblet = getTalendComponentPart(jobEditor, JOBLETNAME);
        Assert.assertNotNull("cann't drag joblet from repository to job", joblet);
        JobHelper.connect(jobEditor, joblet, tJava_2, "Trigger", "On Subjob Ok (TRIGGER_OUTPUT_1)");

        JobHelper.runJob(JOBNAME);
        String result = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertEquals("output\nhello", result);

    }

}
