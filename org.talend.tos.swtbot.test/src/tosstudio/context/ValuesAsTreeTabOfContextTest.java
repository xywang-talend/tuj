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

import junit.framework.Assert;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.SWTBotTreeExt;
import org.talend.swtbot.SWTBotTreeItemExt;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendContextItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ValuesAsTreeTabOfContextTest extends TalendSwtBotForTos {

    private TalendContextItem contextItem;

    private TalendJobItem jobItem;

    private final static String jobName = "job1"; //$NON-NLS-1$

    private final static String contextName = "context1"; //$NON-NLS-1$

    private final static String newContextName = "context2"; //$NON-NLS-1$

    private final static String newValue = "value4"; //$NON-NLS-1$

    @Before
    public void initialisePrivateFields() {
        repositories.add(ERepositoryObjectType.CONTEXT);
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(jobName);
        jobItem.create();
        contextItem = new TalendContextItem(contextName);
        contextItem.create();
    }

    @Test
    public void valueTreeOfContext() {
        SWTBotGefEditor jobEditor = jobItem.getEditor();
        Utilities.dndMetadataOntoJob(jobEditor, contextItem.getItem(), null, new Point(20, 20));
        gefBot.viewByTitle("Contexts(" + jobItem.getEditor().getTitle() + ")").setFocus();
        gefBot.cTabItem("Values as tree").activate();

        // test if order by variable
        SWTBotTreeExt treeExt = new SWTBotTreeExt(gefBot.tree(0));
        treeExt.header("Variable").click();
        String actual = gefBot.tree(0).cell(0, "Variable");
        Assert.assertEquals("cann't order by variable ", "var2", actual);

        // test if order by context
        gefBot.toolbarButtonWithTooltip("Configure Contexts...").click();
        gefBot.shell("Configure Contexts");
        gefBot.button("New...").click();
        SWTBotShell contextShell = gefBot.shell("New Context");
        gefBot.text().setText(newContextName);
        boolean okButtonIsEnable = gefBot.button("OK").isEnabled();
        if (okButtonIsEnable) {
            gefBot.button("OK").click();
        } else {
            contextShell.close();
            Assert.assertTrue("the ok button is uneable,maybe becasue the context name is exist,", okButtonIsEnable);
        }
        gefBot.button("OK").click();

        treeExt.header("Context").click();
        treeExt.header("Context").click();
        String result = gefBot.tree(0).getTreeItem(System.getProperty("context.variable0")).getNode(0).cell(1);
        Assert.assertEquals("can't order by context", newContextName, result);

        // test if edit the value of built-in type
        gefBot.cTabItem("Variables").activate();
        gefBot.button(0).click();
        gefBot.cTabItem("Values as tree").activate();
        SWTBotTreeItemExt treeItemExt = new SWTBotTreeItemExt(gefBot.tree(0).expandNode("new1").getNode(0).select().click());
        treeItemExt.click(4);
        gefBot.text().setText(newValue);
        treeItemExt.click(3);
        String value = gefBot.tree(0).getTreeItem("new1").getNode(0).cell(4);
        Assert.assertEquals("cann't edit the value of built-in type", newValue, value);

    }

}
