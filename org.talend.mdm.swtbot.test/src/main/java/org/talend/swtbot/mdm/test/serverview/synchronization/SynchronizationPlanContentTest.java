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
package org.talend.swtbot.mdm.test.serverview.synchronization;

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
public class SynchronizationPlanContentTest extends SWTBotForMDMServiewView {

    private SWTBotTreeItem spParentItem;

    private SWTBotTreeItem spItem;

    @Before
    public void runBeforeEveryTest() {
        spParentItem = serverItem.getNode("Synchronization Plan [HEAD]");
        spParentItem.expand();

    }

    private void init() {
        spParentItem.contextMenu("New").click();
        SWTBotShell newspShell = bot.shell("New Synchronization Plan");
        newspShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a Name for the New Instance");
        text.setText("TestSynchronizationPlan");
        sleep();
        bot.button("OK").click();
        bot.activeEditor().save();
        sleep();
        spItem = spParentItem.getNode("TestSynchronizationPlan");
        Assert.assertNotNull(spItem);
        spItem.doubleClick();
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {

    }

    @Test
    public void setDescriptionTest() {
        init();
        String des = "This is a stored procedure";
        bot.textWithLabel("Description").setText(des);
        Assert.assertEquals(des, bot.textWithLabel("Description").getText());
    }

    @Test
    public void checkServerTest() {
        bot.textWithLabel("Name").setText("Test");
        bot.textWithLabel("URL").setText("http://localhost:8080/talend/TalendPort");
        bot.textWithLabel("Username").setText("admin");
        bot.textWithLabel("Password").setText("talend");
        bot.button("Check").click();
    }

    @Test
    public void addRecordsSPTest() {
        // TODO:need more detailed test codes with version after the version is created.
    }

    @Test
    public void checkActionTest() {
    	bot.activeEditor().save();
        bot.buttonWithTooltip("Start Full").click();
        // TODO:need assertion;
        spParentItem.getNode("TestSynchronizationPlan").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

    }
}
