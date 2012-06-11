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
package tisstudio.documentation;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
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
public class DoumentationForJobTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private SWTBotTreeItem docNode;

    private static final String JOBNAME = "jobTest";

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
    }

    @Test
    public void testDocumentation() {
        String buitdTitle = getBuildTitle();
        Utilities.dndPaletteToolOntoJob(jobItem.getEditor(), "tRowGenerator", new Point(100, 100));
        SWTBotGefEditPart trowGenerator = getTalendComponentPart(jobItem.getEditor(), "tRowGenerator_1");
        Assert.assertNotNull("cann't get component tRowGenerator_1", trowGenerator);

        trowGenerator.doubleClick();
        gefBot.shell(buitdTitle + " - tRowGenerator - tRowGenerator_1").setFocus();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.button("OK").click();

        JobHelper.connect2TLogRow(jobItem.getEditor(), trowGenerator, new Point(100, 200));

        JobHelper.runJob(JOBNAME);
        String result1 = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertNotNull("the bug for job cann't execute", result1);

        jobItem.getEditor().saveAndClose();

        docNode = Utilities.getTalendItemNode(Utilities.TalendItemType.DOCUMENTATION);

        jobItem.getItem().contextMenu("View documentation").click();
        gefBot.cTabItem(JOBNAME + "_0.1.html").activate();

        SWTBotTreeItem newDocItemForJob = null;
        try {
            docNode.expand();
            newDocItemForJob = docNode.expandNode("generated", "jobs").select(JOBNAME + " 0.1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("documentation item for job is not created", newDocItemForJob);
        }

    }
}
