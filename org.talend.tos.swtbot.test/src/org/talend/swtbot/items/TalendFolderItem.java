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

import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Assert;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.Utilities.TalendItemType;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendFolderItem {

    private String itemName;

    private String itemPath; // folder path not include itself

    private String folderPath; // folder path include itself

    private SWTBotTreeItem item;

    private SWTBotTreeItem parentNode;

    private SWTGefBot gefBot = new SWTGefBot();

    public TalendFolderItem(String folderName) {
        setItemName(folderName);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Get the path of folder item, not include itself.
     * 
     * @return item path
     */
    public String getItemPath() {
        return itemPath;
    }

    /**
     * Set the path of folder item, not include itself.
     * 
     * @return item path
     */
    public void setItemPath(String itemPath) {
        this.itemPath = itemPath;
    }

    /**
     * Get the path of folder item, include itself.
     * 
     * @return folder path
     */
    public String getFolderPath() {
        return folderPath;
    }

    /**
     * Set the path of folder item, include itself.
     * 
     * @return folder path
     */
    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    public SWTBotTreeItem getItem() {
        return item;
    }

    public void setItem(SWTBotTreeItem item) {
        this.item = item;
    }

    public SWTBotTreeItem getParentNode() {
        return parentNode;
    }

    public void setParentNode(SWTBotTreeItem parentNode) {
        this.parentNode = parentNode;
    }

    private void create() {
        parentNode.contextMenu("Create folder").click();
        gefBot.waitUntil(Conditions.shellIsActive("New folder"));
        SWTBotShell shell = gefBot.shell("New folder");
        shell.activate();

        gefBot.textWithLabel("Label").setText(getItemName());

        boolean finishButtonIsEnabled = gefBot.button("Finish").isEnabled();
        if (finishButtonIsEnabled) {
            gefBot.button("Finish").click();
        } else {
            shell.close();
            Assert.assertTrue("finish button is not enabled, folder created fail, maybe the item is exist", finishButtonIsEnabled);
        }
        gefBot.waitUntil(Conditions.shellCloses(shell));

        SWTBotTreeItem newFolderItem = null;
        try {
            newFolderItem = parentNode.expand().select(itemName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("folder is not created", newFolderItem);
        }

        setItem(newFolderItem);
    }

    public TalendFolderItem createUnder(TalendItemType itemType) {
        setParentNode(Utilities.getTalendItemNode(itemType));
        create();
        setItemPath("");
        setFolderPath(itemName);
        return this;
    }

    public TalendFolderItem createUnder(TalendFolderItem parentFolder) {
        setParentNode(parentFolder.getItem());
        create();
        setItemPath(parentFolder.getFolderPath());
        setFolderPath(parentFolder.getFolderPath() + "/" + itemName);
        return this;
    }

    public void rename(String newFolderName) {
        parentNode.expandNode(itemName).contextMenu("Rename folder").click();
        SWTBotShell shell = gefBot.shell("New folder").activate();
        gefBot.textWithLabel("Label").setText(newFolderName);
        boolean isFinishButtonEnable = gefBot.button("Finish").isEnabled();
        if (!isFinishButtonEnable) {
            shell.close();
            Assert.assertTrue("folder name already exist", isFinishButtonEnable);
        }
        gefBot.button("Finish").click();

        SWTBotTreeItem newFolderItem = null;
        try {
            newFolderItem = parentNode.expand().select(newFolderName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("folder is renamed", newFolderItem);
        }
    }

    public void delete() {
        parentNode.expand().getNode(itemName).contextMenu("Delete").click();
        SWTBotTreeItem newItem = null;
        String path = "";
        try {
            if (itemPath != null)
                path = itemPath;
            path = " (" + path + ")";
            newItem = Utilities.getTalendItemNode(TalendItemType.RECYCLE_BIN).getNode(itemName + path);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("item is not deleted to recycle bin", newItem);
        }
    }
}
