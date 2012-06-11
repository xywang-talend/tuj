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
public class CreateNewVersionOfJobTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private static final String JOBNAME = "test01"; //$NON-NLS-1$

    @Before
    public void createAJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
    }

    @Test
    public void createNewVersionOfJob() {
        jobItem.getEditor().saveAndClose();
        jobItem.getItem().contextMenu("Edit properties").click();

        gefBot.shell("Edit properties").activate();
        gefBot.button("M").click();
        gefBot.button("m").click();
        gefBot.button("Finish").click();

        gefBot.waitUntil(new DefaultCondition() {

            @Override
            public boolean test() throws Exception {
                return jobItem.getParentNode().expand().getNode(JOBNAME + " 1.1").isVisible();
            }

            @Override
            public String getFailureMessage() {
                return "new version of job not found";
            }
        });
        jobItem.setItem(jobItem.getParentNode().expand().getNode(JOBNAME + " 1.1"));
    }
}
