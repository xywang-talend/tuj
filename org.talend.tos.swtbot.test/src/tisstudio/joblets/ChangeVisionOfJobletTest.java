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

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendJobletItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ChangeVisionOfJobletTest extends TalendSwtBotForTos {

    private TalendJobletItem jobletItem;

    private static final String JOBLETNAME = "jobletTest";

    @Before
    public void createJoblet() {
        repositories.add(ERepositoryObjectType.JOBLET);
        jobletItem = new TalendJobletItem(JOBLETNAME);
        jobletItem.create();
        jobletItem.getEditor().saveAndClose();
    }

    @Test
    public void testChangeVisionOfJoblet() {
        jobletItem.getItem().contextMenu("Open an other version").click();
        gefBot.shell("New joblet").activate();
        gefBot.checkBox("Create new version and open it?").select();
        gefBot.button("M").click();
        gefBot.button("m").click();
        gefBot.button("Finish").click();
        Assert.assertNotNull("the new vision joblet is not opened ", gefBot.cTabItem("Joblet " + JOBLETNAME + " 1.1"));

        gefBot.waitUntil(new DefaultCondition() {

            @Override
            public boolean test() throws Exception {
                return jobletItem.getParentNode().getNode(JOBLETNAME + " 1.1").isVisible();
            }

            @Override
            public String getFailureMessage() {
                return "new version of joblet not found in the tree";
            }
        });
        jobletItem.setItem(jobletItem.getParentNode().getNode(JOBLETNAME + " 1.1"));

    }

}
