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
import org.talend.swtbot.SWTBotTreeItemExt;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendContextItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ValuesAsTableTabOfContextTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendContextItem contextItem;

    private final static String jobName = "job1"; //$NON-NLS-1$

    private final static String contextName = "context1"; //$NON-NLS-1$

    private final static String newContextName = "context2"; //$NON-NLS-1$

    private final static String builtValue = "value4"; //$NON-NLS-1$

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
    public void valuesOfTableOfContext() {
        SWTBotGefEditor gefEditor = jobItem.getEditor();
        Utilities.dndMetadataOntoJob(gefEditor, contextItem.getItem(), null, new Point(20, 20));
        gefBot.viewByTitle("Contexts(" + jobItem.getEditor().getTitle() + ")").setFocus();

        // test if is able to set one of context is default
        gefBot.cTabItem("Values as table").activate();
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
        gefBot.table(0).getTableItem(newContextName).check();
        boolean buttonIsEnable = gefBot.button("OK").isEnabled();
        if (buttonIsEnable) {
            gefBot.button("OK").click();
        } else {
            contextShell.close();
            Assert.assertTrue("is unable to set one of context is default", buttonIsEnable);
        }
        // test fixed the data of built-in type context
        gefBot.cTabItem("Variables").activate();
        gefBot.button(0).click();
        gefBot.cTabItem("Values as table").activate();
        SWTBotTreeItemExt treeItemExt = new SWTBotTreeItemExt(gefBot.tree(0).getTreeItem("new1").select());
        treeItemExt.click(1);
        gefBot.text().setText(builtValue);
        treeItemExt.click(0);
        String value = treeItemExt.cell(1);
        Assert.assertEquals("is unable to fixed the data of built-in type context", builtValue, value);
    }

}
