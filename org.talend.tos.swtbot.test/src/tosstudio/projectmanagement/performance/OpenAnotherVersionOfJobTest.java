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
package tosstudio.projectmanagement.performance;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotCTabItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class OpenAnotherVersionOfJobTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private static final String JOBNAME = "test01"; //$NON-NLS-1$

    @Before
    public void createAJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
    }

    @Test
    public void openAnotherVersionOfJob() {
        jobItem.getEditor().saveAndClose();
        jobItem.getItem().contextMenu("Open an other version").click();

        gefBot.shell("Job version").activate();
        gefBot.checkBox("Create new version and open it?").click();
        gefBot.button("M").click();
        gefBot.button("m").click();
        gefBot.button("Finish").click();

        SWTBotCTabItem newJobTabItem1 = gefBot.cTabItem("Job " + JOBNAME + " 1.1");
        Assert.assertNotNull("job tab is not opened", newJobTabItem1);

        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {
                return jobItem.getParentNode().expand().getNode(JOBNAME + " 1.1").isVisible();
            }

            public String getFailureMessage() {
                return "new version of job not found";
            }
        });
        jobItem.setItem(jobItem.getParentNode().expand().getNode(JOBNAME + " 1.1"));
        jobItem.getItem().contextMenu("Open an other version").click();
        gefBot.shell("Job version").activate();
        gefBot.table().select(0);
        gefBot.button("Finish").click();

        SWTBotCTabItem newJobTabItem2 = gefBot.cTabItem("Job " + JOBNAME + " 0.1");
        Assert.assertNotNull("job tab is not opened", newJobTabItem2);
    }

}
