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
public class TRunJobTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem1;

    private TalendJobItem jobItem2;

    private final static String JOBNAME1 = "fatherJob"; //$NON-NLS-1$

    private final static String JOBNAME2 = "sonJob"; //$NON-NLS-1$

    @Before
    public void createJobs() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem1 = new TalendJobItem(JOBNAME1);
        jobItem1.create();
    }

    @Test
    public void testTRunJob() {
        String buitdTitle = getBuildTitle();
        SWTBotGefEditor jobEditor1 = jobItem1.getEditor();

        Utilities.dndPaletteToolOntoJob(jobEditor1, "tRowGenerator", new Point(100, 100));
        SWTBotGefEditPart tRowGenerator = getTalendComponentPart(jobEditor1, "tRowGenerator_1");
        Assert.assertNotNull("can not get component 'tRowGenerator'", tRowGenerator);

        tRowGenerator.doubleClick();

        gefBot.shell(buitdTitle + " - tRowGenerator - tRowGenerator_1").setFocus();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.button("OK").click();
        JobHelper.connect2TLogRow(jobEditor1, tRowGenerator, new Point(200, 100));

        JobHelper.runJob(jobItem1.getItemName());

        jobItem2 = new TalendJobItem(JOBNAME2);
        jobItem2.create();
        SWTBotGefEditor jobEditor2 = jobItem2.getEditor();
        Utilities.dndPaletteToolOntoJob(jobEditor2, "tRunJob", new Point(200, 200));
        SWTBotGefEditPart tRunJob = getTalendComponentPart(jobEditor2, "tRunJob_1");
        tRunJob.doubleClick();
        gefBot.viewByTitle("Component").setFocus();
        gefBot.button(4).click();
        gefBot.shell("Find a Job").setFocus();
        Utilities.getTalendItemNode(gefBot.tree(), jobItem1.getItemType()).getNode(jobItem1.getItemFullName()).select();
        gefBot.button("OK").click();
        JobHelper.runJob(jobItem2.getItemName());
        String result1 = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertNotNull("the bug for job cann't execute", result1);

    }
}
