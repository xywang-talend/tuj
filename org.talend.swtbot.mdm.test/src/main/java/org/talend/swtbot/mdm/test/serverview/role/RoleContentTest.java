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
package org.talend.swtbot.mdm.test.serverview.role;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.mdm.test.serverview.SWTBotForMDMServiewView;

/**
 * 
 * DOC rhou class global comment. Detailled comment
 * 
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class RoleContentTest extends SWTBotForMDMServiewView {

    private SWTBotTreeItem roleParentItem;

    private SWTBotTreeItem roleItem;

    @Before
    public void runBeforeEveryTest() {
        roleParentItem = serverItem.getNode("Role [HEAD]");
        roleParentItem.expand();
        roleItem = roleParentItem.getNode("Manager_MWest");
        roleItem.doubleClick();
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
    	bot.activeEditor().close();
    }

    private void init() {
        roleParentItem.contextMenu("New Role").click();
        SWTBotShell newroleShell = bot.shell("New Role");
        newroleShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the Role:");
        text.setText("TestRole");
        sleep();
        bot.buttonWithTooltip("Add").click();
        sleep();
        bot.button(IDialogConstants.NEXT_LABEL).click();
        sleep();

        bot.comboBoxWithLabel("Administrator").selection();
        bot.button(IDialogConstants.FINISH_LABEL).click();
        bot.activeEditor().save();
        bot.activeEditor().close();
        roleItem = roleParentItem.getNode("TestRole");
        Assert.assertNotNull(roleItem);
        roleItem.doubleClick();
        sleep(2);
    }

    @Test
    public void setDescriptionTest() {
        bot.buttonWithTooltip("Set the Descriptions").click();
        bot.shell("Set the Description of the Role").activate();
        bot.comboBox().setSelection("English");
        String des = "Administrator";
        bot.text().setText(des);
        bot.buttonWithTooltip("Add").click();
        bot.button("OK").click();
    }

    @Test
    public void setPermissionTest() {
        String type = "Object Type";
        String instance = "Read and Write Permissins On Specific Instances";

        bot.comboBoxWithLabel(type).setSelection("Data Container");
        bot.comboBox(1).setSelection("CONF");
        bot.buttonWithTooltip("Add").click();
        sleep();

        bot.comboBoxWithLabel(type).setSelection("Data Model");
        bot.comboBox(1).setSelection("SearchTemplate");
        bot.comboBox("Read Only").setSelection("Read & Write");
        bot.buttonWithTooltip("Add").click();
        sleep();
    }
}
