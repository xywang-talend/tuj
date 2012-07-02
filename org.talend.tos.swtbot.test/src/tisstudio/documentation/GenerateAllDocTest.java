// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
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

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendJobletItem;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class GenerateAllDocTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendJobletItem jobletItem;

    private SWTBotTreeItem docNode;

    private static final String JOBNAME = "job1"; //$NON-NLS-1$

    private static final String JOBLETNAME = "joblet1"; //$NON-NLS-1$

    @Before
    public void initialisePrivateFields() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.JOBLET);
        repositories.add(ERepositoryObjectType.DOCUMENTATION);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
        jobletItem = new TalendJobletItem(JOBLETNAME);
        jobletItem.create();
    }

    @Test
    public void generateAllDoc() {
        docNode = Utilities.getTalendItemNode(Utilities.TalendItemType.DOCUMENTATION);
        docNode.getNode("generated").contextMenu("Generate all projects documentation").click();
        gefBot.waitUntil(Conditions.shellIsActive("Progress Information"), 10000);
        gefBot.waitUntil(Conditions.shellCloses(gefBot.shell("Progress Information")), 30000);
        gefBot.waitUntil(Conditions.shellIsActive("Talend Open Studio"));
        gefBot.button("OK").click();

        SWTBotTreeItem newDocItemForJob = null;
        SWTBotTreeItem newDocItemForJoblet = null;
        try {
            docNode.expand();
            newDocItemForJob = docNode.expandNode("generated", "jobs").select(JOBNAME + " 0.1");
            newDocItemForJoblet = docNode.expandNode("generated", "joblets").select(JOBLETNAME + " 0.1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("documentation item for job is not created", newDocItemForJob);
            Assert.assertNotNull("documentation item for joblet is not created", newDocItemForJoblet);
        }
    }

}
