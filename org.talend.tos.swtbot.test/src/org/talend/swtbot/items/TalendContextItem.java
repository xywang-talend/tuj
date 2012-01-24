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
package org.talend.swtbot.items;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Assert;
import org.talend.swtbot.SWTBotTreeItemExt;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendContextItem extends TalendItem {

    public TalendContextItem() {
        super(Utilities.TalendItemType.CONTEXTS);
    }

    public TalendContextItem(String itemName) {
        super(itemName, Utilities.TalendItemType.CONTEXTS);
    }

    @Override
    public void create() {
        SWTBotShell shell = beginCreationWizard("Create context group", "Create / Edit a context group");
        boolean nextButtonIsEnabled = gefBot.button("Next >").isEnabled();
        if (nextButtonIsEnabled) {
            gefBot.button("Next >").click();
        } else {
            shell.close();
            Assert.assertTrue("next button is not enabled, maybe the item name is exist,", nextButtonIsEnabled);
        }

        SWTBotTreeItem treeItem;
        SWTBotTreeItemExt treeItemExt;
        for (int i = 0; i < 3; i++) {
            gefBot.button(0).click();
            treeItem = gefBot.tree(0).getTreeItem("new1").click();
            treeItemExt = new SWTBotTreeItemExt(treeItem);
            treeItemExt.click(0);
            gefBot.text("new1").setText(System.getProperty("context.variable" + i));
            treeItemExt.click(1);
            gefBot.ccomboBox("String").setSelection(System.getProperty("context.type" + i));
            treeItemExt.click(2);
        }

        gefBot.cTabItem("Values as tree").activate();

        for (int j = 0; j < 3; j++) {
            treeItem = gefBot.tree(0).expandNode(System.getProperty("context.variable" + j)).getNode(0).select().click();
            treeItemExt = new SWTBotTreeItemExt(treeItem);
            treeItemExt.click(4);
            gefBot.text().setText(System.getProperty("context.value" + j));
        }
        finishCreationWizard(shell);
    }

    @Override
    public SWTBotShell beginEditWizard() {
        return beginEditWizard("Edit context group", "Create / Edit a context group");
    }
}
