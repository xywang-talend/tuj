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

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendContextItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class VariablesTabTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendContextItem contextItem;

    private static final String JOBNAME = "jobTest"; //$NON-NLS-1$

    private static final String CONTEXT_NAME = "contextTest"; //$NON-NLS-1$

    @Before
    public void initialisePrivateFields() {
        repositories.add(ERepositoryObjectType.CONTEXT);
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
        contextItem = new TalendContextItem(CONTEXT_NAME);
        contextItem.create();
    }

    @Test
    public void variablesTabTest() {
        gefBot.viewByTitle("Contexts(" + jobItem.getEditor().getTitle() + ")").setFocus();
        gefBot.cTabItem("Variables").activate();
        SWTBotTree varTree = gefBot.tree(0);
        SWTBotButton addBtn = gefBot.button(0);
        SWTBotButton deleteBtn = gefBot.button(1);
        SWTBotButton moveUpBtn = gefBot.button(2);
        SWTBotButton moveDownBtn = gefBot.button(3);
        SWTBotButton importVarBtn = gefBot.button(4);

        // test add variables
        addBtn.click();
        varTree.getTreeItem("new1").select();
        addBtn.click();
        varTree.getTreeItem("new2").select();
        addBtn.click();
        varTree.getTreeItem("new3").select();

        // test delete variables
        deleteBtn.click();
        SWTBotTreeItem var3 = null;
        long defaultTimeout = SWTBotPreferences.TIMEOUT;
        SWTBotPreferences.TIMEOUT = 100;
        try {
            var3 = varTree.getTreeItem("new3");
        } catch (WidgetNotFoundException e) {
            // do nothing
        } finally {
            SWTBotPreferences.TIMEOUT = defaultTimeout;
            Assert.assertNull("variable did not delete", var3);
        }

        // test moving up variables
        gefBot.checkBox("Original order").select();
        varTree.getTreeItem("new2").select();
        moveUpBtn.click();
        Assert.assertEquals("variable did not move up", "new2", varTree.cell(0, "Name"));

        // test moving down variables
        varTree.getTreeItem("new2").select();
        moveDownBtn.click();
        Assert.assertEquals("variable did not move down", "new2", varTree.cell(1, "Name"));
        gefBot.checkBox("Original order").deselect();

        // test import variables from repository
        importVarBtn.click();
        gefBot.shell("Select Context Variables").activate();
        gefBot.tree(0).getTreeItem("Context: " + CONTEXT_NAME).check();
        gefBot.button("OK").click();
        varTree.getTreeItem(CONTEXT_NAME).click();
    }

}
