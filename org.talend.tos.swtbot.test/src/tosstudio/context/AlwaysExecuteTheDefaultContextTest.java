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
package tosstudio.context;

import junit.framework.Assert;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.SWTBotTreeItemExt;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.items.TalendContextItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class AlwaysExecuteTheDefaultContextTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem1;

    private TalendJobItem jobItem2;

    private TalendContextItem contextItem;

    private static final String CONTEXTNAME1 = "context1"; //$NON-NLS-1$

    private static final String CONTEXTNAME2 = "context2"; //$NON-NLS-1$

    private static final String JOBNAME1 = "childJob"; //$NON-NLS-1$

    private static final String JOBNAME2 = "fatherJob"; //$NON-NLS-1$

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.CONTEXT);
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem1 = new TalendJobItem(JOBNAME1);
        jobItem1.create();
        contextItem = new TalendContextItem(CONTEXTNAME1);

        contextItem.create();

    }

    @Test
    public void ifExecuteDefaultContext() {

        createNewContext();

        // drag context to job
        Utilities.dndMetadataOntoJob(jobItem1.getEditor(), contextItem.getItem(), null, new Point(100, 100));

        // drag tJava to job
        Utilities.dndPaletteToolOntoJob(jobItem1.getEditor(), "tJava", new Point(200, 200));
        SWTBotGefEditPart tJava = getTalendComponentPart(jobItem1.getEditor(), "tJava_1");
        Assert.assertNotNull("cann't get component tJava", tJava);
        tJava.click();
        gefBot.viewByTitle("Component").setFocus();
        SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
        gefBot.sleep(1000);
        gefBot.styledText().selectCurrentLine();
        String text = "System.out.println(context.var0+context.var1+context.var2);";
        gefBot.styledText().typeText(text);

        // run the job with the default context(context1)
        JobHelper.runJob(JOBNAME1);
        String result = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertEquals("the result is not the expected,maybe the context is not  being drag to the job", "1anull", result);

        jobItem1.getEditor().saveAndClose();

        // create the father job
        jobItem2 = createFatherJob();

        // change the default context to context2 and delete context1
        jobItem1.getItem().contextMenu("Edit job").click();
        gefBot.viewByTitle("Contexts(" + jobItem1.getEditor().getTitle() + ")").setFocus();
        gefBot.cTabItem("Values as table").activate();
        gefBot.toolbarButtonWithTooltip("Configure Contexts...").click();
        gefBot.table(0).getTableItem(CONTEXTNAME2).check();
        gefBot.table(0).select(0);
        gefBot.button("Remove").click();
        gefBot.button("OK").click();
        jobItem1.getEditor().saveAndClose();

        // run the father job
        jobItem2.getItem().contextMenu("Edit job").click();
        JobHelper.runJob(JOBNAME2);
        result = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertEquals("the result is not the expected result,maybe the context is not change to the default one",
                "nullvar1null", result);

    }

    private void createNewContext() {
        // create a new context group
        contextItem.getItem().contextMenu("Edit context group").click();
        gefBot.shell("Create / Edit a context group").activate();
        gefBot.button("Next >").click();
        gefBot.cTabItem("Values as table").activate();
        gefBot.toolbarButtonWithTooltip("Configure Contexts...").click();
        gefBot.shell("Configure Contexts");
        gefBot.button("New...").click();
        SWTBotShell contextShell = gefBot.shell("New Context");
        gefBot.text().setText(CONTEXTNAME2);
        boolean okButtonIsEnable = gefBot.button("OK").isEnabled();
        if (okButtonIsEnable) {
            gefBot.button("OK").click();
        } else {
            contextShell.close();
            Assert.assertTrue("the ok button is uneable,maybe becasue the context name is exist,", okButtonIsEnable);
        }
        gefBot.button("OK").click();

        // set the value of new context
        gefBot.cTabItem("Values as tree").activate();
        for (int j = 0; j < 3; j++) {
            SWTBotTreeItem treeItem = gefBot.tree(0).expandNode(System.getProperty("context.variable" + j)).getNode(0).select()
                    .click();
            SWTBotTreeItemExt treeItemExt = new SWTBotTreeItemExt(treeItem);
            treeItemExt.click(4);
            gefBot.text().setText(System.getProperty("context.variable" + j));
        }

        gefBot.button("Finish").click();
        gefBot.button("Yes").click();
        gefBot.button("OK").click();
    }

    private TalendJobItem createFatherJob() {
        jobItem2 = new TalendJobItem(JOBNAME2);
        jobItem2.create();

        Utilities.dndPaletteToolOntoJob(jobItem2.getEditor(), "tRunJob", new Point(100, 100));
        SWTBotGefEditPart tRunjob = getTalendComponentPart(jobItem2.getEditor(), "tRunJob_1");
        Assert.assertNotNull("cann't get component tRunjob", tRunjob);
        tRunjob.click();
        gefBot.viewByTitle("Component").setFocus();
        gefBot.button(4).click();
        gefBot.shell("Find a Job").activate();
        Utilities.getTalendItemNode(gefBot.tree(), jobItem1.getItemType()).getNode(jobItem1.getItemFullName()).select();
        gefBot.button("OK").click();
        jobItem2.getEditor().saveAndClose();
        return jobItem2;
    }

}
