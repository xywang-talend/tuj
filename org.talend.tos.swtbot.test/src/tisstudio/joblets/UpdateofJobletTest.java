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
public class UpdateofJobletTest extends TalendSwtBotForTos {

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
    public void testUpdateOfJoblet() {
        SWTBotGefEditor jobEditor = jobItem.getEditor();
        SWTBotGefEditor jobletEditor = jobletItem.getEditor();

        // clear joblet and drag tJava to joblet
        jobletEditor.show();
        jobletItem.clearInputandOutput();
        jobletEditor.save();

        // drag joblet from repository to job
        jobEditor.show();
        Utilities.dndMetadataOntoJob(jobEditor, jobletItem.getItem(), null, new Point(100, 100));
        SWTBotGefEditPart joblet = getTalendComponentPart(jobEditor, JOBLETNAME);
        Assert.assertNotNull("cann't drag joblet from repository to job", joblet);

        // run job
        JobHelper.runJob(JOBNAME);
        String result = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertEquals("the result is not the expected result", "", result);

        // update joblet
        String text = "System.out.println(\"hello\");";
        Utilities.useTJavaAndSetText(jobletEditor, text);
        gefBot.toolbarButtonWithTooltip("Save (Ctrl+S)").click();
        gefBot.shell("Update Detection").activate();
        gefBot.button("OK").click();

        // run job again to check if updated
        jobEditor.show();
        JobHelper.runJob(JOBNAME);
        String result2 = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertEquals("the result is not the expected result,maybe the joblet is unchanged", "hello", result2);

    }
}
