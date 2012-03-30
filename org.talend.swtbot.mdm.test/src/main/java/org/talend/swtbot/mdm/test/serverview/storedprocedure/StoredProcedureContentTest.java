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
package org.talend.swtbot.mdm.test.serverview.storedprocedure;

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
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class StoredProcedureContentTest extends SWTBotForMDMServiewView {

    private SWTBotTreeItem spParentItem;

    private SWTBotTreeItem spItem;

    @Before
    public void runBeforeEveryTest() {
        spParentItem = serverItem.getNode("Stored Procedure [HEAD]");
        spParentItem.expand();

    }

    private void init() {
        spParentItem.contextMenu("New").click();
        SWTBotShell newspShell = bot.shell("New Stored Procedure");
        newspShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a Name for the New Instance");
        text.setText("TestStoredProcedure");
        bot.button("OK").click();
        bot.activeEditor().save();
        sleep();
        spParentItem.expand();
        spItem = spParentItem.getNode("TestStoredProcedure");
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
    public void setProcedureTest() {
        String pro = "";
        bot.styledText().setText(pro);
        Assert.assertEquals(pro, bot.styledText().getText());
    }

    @Test
    public void executeProcedureTest() {
        String pro = "";
        bot.comboBox().setSelection("SearchTemplate");
        bot.button("Execute Procedure").click();
        spParentItem.expand();
        spParentItem.getNode("TestStoredProcedure").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }
}
