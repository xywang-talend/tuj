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
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
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
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class JobletWithoutInputOutputTest extends TalendSwtBotForTos {

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
    public void testJobletWithoutInputOutput() {
        // config joblet without input output
        SWTBotGefEditor jobletEditor = jobletItem.getEditor();
        jobletEditor.show();
        jobletItem.clearInputandOutput();
        Utilities.useTJavaAndSetText(jobletEditor, "System.out.println(\"Test OK\");");
        jobletEditor.saveAndClose();

        // use joblet in job
        SWTBotGefEditor jobEditor = jobItem.getEditor();
        jobEditor.show();
        Utilities.dndPaletteToolOntoJob(jobEditor, JOBLET_NAME, new Point(100, 100));
        JobHelper.runJob(jobEditor);

        String actualResult = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertEquals("running job fail with joblet", "Test OK", actualResult);
    }
}
