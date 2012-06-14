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
package tosstudio.context;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.SWTBotTreeItemExt;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.Utilities.TalendItemType;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.items.TalendContextItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class UseContextGloballyTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem1;

    private TalendJobItem jobItem2;

    private static final String JOB_NAME1 = "jobTest1";

    private static final String JOB_NAME2 = "jobTest2";

    @Before
    public void initialisePrivateFields() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.CONTEXT);

        jobItem1 = new TalendJobItem(JOB_NAME1);
        jobItem1.create();
        jobItem2 = new TalendJobItem(JOB_NAME2);
        jobItem2.create();
    }

    @Test
    public void useContextGloballyTest() {
        SWTBotGefEditor jobEditor1 = jobItem1.getEditor();
        SWTBotGefEditor jobEditor2 = jobItem2.getEditor();
        String contextName = "context";
        String variableValue = "test";

        // create context variables for job
        jobEditor1.show();
        gefBot.viewByTitle("Contexts(" + jobEditor1.getTitle() + ")").show();
        gefBot.cTabItem("Variables").activate();
        gefBot.button(0).click(); // click add variable button
        gefBot.cTabItem("Values as table").activate();
        SWTBotTreeItemExt var = new SWTBotTreeItemExt(gefBot.tree(0).getTreeItem("new1").select());
        var.click("Default");
        gefBot.text().setText(variableValue);
        var.select();
        // add context variables to repository
        gefBot.cTabItem("Variables").activate();
        new SWTBotTreeItemExt(gefBot.tree(0).getTreeItem("new1").select()).contextMenu("Add to repository context").click();
        gefBot.shell("Repository Content").activate();
        gefBot.checkBox("Create new context group?").select();
        gefBot.textWithLabel("Group Name").setText(contextName);
        gefBot.button("OK").click();
        TalendContextItem context = new TalendContextItem("context");
        context.setItem(Utilities.getTalendItemNode(TalendItemType.CONTEXTS).getNode(context.getItemFullName()));
        // use context grobally in another job
        jobEditor2.show();
        Utilities.dndMetadataOntoJob(jobEditor2, context.getItem(), null, new Point(100, 100));
        Utilities.dndPaletteToolOntoJob(jobEditor2, "tJava", new Point(100, 100));
        SWTBotGefEditPart tJava = getTalendComponentPart(jobEditor2, "tJava_1");
        tJava.doubleClick();
        gefBot.viewByTitle("Component").setFocus();
        SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
        gefBot.sleep(1000);
        gefBot.styledText().selectCurrentLine();
        String text = "System.out.println(context.new1);";
        gefBot.styledText().typeText(text, 0);
        JobHelper.runJob(jobEditor2);
        String result = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertEquals("result is not the expeected result", variableValue, result);
    }
}
