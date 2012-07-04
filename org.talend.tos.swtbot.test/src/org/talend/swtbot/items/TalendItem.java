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

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Assert;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.Utilities.BuildType;
import org.talend.swtbot.Utilities.TalendItemType;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendItem implements Cloneable {

    protected final Logger log = Logger.getLogger(getClass());

    protected SWTBotTreeItem item;

    protected String itemFullName;

    protected String itemName;

    protected String itemVersion;

    protected String folderPath;

    protected String status;

    protected TalendItemType itemType;

    protected SWTBotTreeItem parentNode;

    protected SWTGefBot gefBot = new SWTGefBot();

    public TalendItem() {
    }

    public TalendItem(TalendItemType itemType) {
        initialise(itemType);
    }

    public TalendItem(String itemName, TalendItemType itemType) {
        setItemName(itemName);
        setItemVersion("0.1");
        initialise(itemType);
    }

    public SWTBotTreeItem getItem() {
        if (item == null)
            return null;
        if (item.widget.isDisposed())
            setItem(getParentNode().expand().getNode(getItemFullName()));
        return item;
    }

    public void setItem(SWTBotTreeItem item) {
        this.item = item;
        if (item == null)
            return;
        if (getItemFullName() == item.getText())
            return;
        if (item.getText().indexOf(" ") == -1) {
            setItemName(item.getText());
        } else {
            String[] temp = item.getText().split(" ");
            setItemName(temp[0]);
            setItemVersion(temp[1]);
        }
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
        if ((BuildType.TOSBD == TalendSwtBotForTos.getBuildType()) || getItemVersion() == null) {
            setItemFullName(this.itemName);
        } else {
            setItemFullName(this.itemName + " " + getItemVersion());
        }
    }

    public TalendItemType getItemType() {
        return this.itemType;
    }

    protected void setItemType(TalendItemType itemType) {
        this.itemType = itemType;
    }

    public SWTBotTreeItem getParentNode() {
        if (parentNode == null)
            return null;
        if (parentNode.widget.isDisposed())
            setParentNode(Utilities.getTalendItemNode(getItemType()));
        return parentNode;
    }

    protected void setParentNode(SWTBotTreeItem parentNode) {
        this.parentNode = parentNode;
    }

    public String getItemFullName() {
        return itemFullName;
    }

    protected void setItemFullName(String itemFullName) {
        this.itemFullName = itemFullName;
    }

    public String getItemVersion() {
        return itemVersion;
    }

    public void setItemVersion(String itemVersion) {
        if (BuildType.TOSBD != TalendSwtBotForTos.getBuildType()) {
            this.itemVersion = itemVersion;
            setItemFullName(getItemName() + " " + this.itemVersion);
        }
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        if ("".equals(folderPath) || folderPath == null)
            return;
        this.folderPath = folderPath;
        String[] folders = folderPath.split("/");
        for (int i = 0; i < folders.length; i++) {
            setParentNode(getParentNode().expandNode(folders[i]));
        }
    }

    public String getStatus() {
        SWTBotShell shell = beginEditWizard();
        String str = gefBot.ccomboBoxWithLabel("Status").getText();
        shell.close();
        return str;
    }

    public void setStatus(String status) {
        SWTBotShell shell = beginEditWizard();
        gefBot.ccomboBoxWithLabel("Status").setSelection(status);
        gefBot.button("Finish").click();
        gefBot.waitUntil(Conditions.shellCloses(shell));
        this.status = status;
    }

    protected void initialise(TalendItemType itemType) {
        setItemType(itemType);
        setParentNode(Utilities.getTalendItemNode(itemType));
    }

    public void create() {
    }

    public TalendItem copyAndPaste() {
        List<String> nodes = getParentNode().expand().getNodes();
        String version = "";
        if (getItemVersion() != null)
            version = " " + getItemVersion();
        String copiedName = "Copy_of_" + getItemName() + version;
        if (nodes.contains(copiedName)) {
            for (int i = 0; i < 26; i++) {
                char _char = (char) ('a' + i);
                String str = "Copy_of_" + getItemName() + "_" + _char + version;
                if (!nodes.contains(str)) {
                    copiedName = str;
                    break;
                }
            }
        }

        // getItem().contextMenu("Copy").click();
        getParentNode().getNode(getItemFullName()).contextMenu("Copy").click();
        getParentNode().contextMenu("Paste").click();

        TalendItem copyItem = (TalendItem) this.clone();
        SWTBotTreeItem newItem = null;
        try {
            newItem = getParentNode().getNode(copiedName);
        } catch (WidgetNotFoundException e) {
            Assert.fail("copy item '" + copiedName + "' does not exist");
        }
        copyItem.setItem(newItem);

        return copyItem;
    }

    public void delete() {
        getParentNode().expand().getNode(getItemFullName()).contextMenu("Delete").click();
        SWTBotTreeItem newItem = null;
        String path = "";
        try {
            if (getFolderPath() != null)
                path = getFolderPath();
            if (!(getClass().newInstance() instanceof TalendSchemaItem))
                path = " (" + path + ")";
            newItem = Utilities.getRepositoryTree().expandNode("Recycle bin").select(getItemFullName() + path);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("item is not deleted to recycle bin", newItem);
        }
    }

    public TalendItem duplicate(String newItemName) {
        getItem().contextMenu("Duplicate").click();
        gefBot.shell("Please input new name ").activate();
        gefBot.textWithLabel("Input new name").setText(newItemName);
        gefBot.button("OK").click();

        TalendItem duplicateItem = (TalendItem) this.clone();
        SWTBotTreeItem newItem = null;
        try {
            duplicateItem.setItemName(newItemName);
            newItem = getParentNode().getNode(duplicateItem.getItemFullName());
        } catch (WidgetNotFoundException e) {
            Assert.fail("duplicate of item '" + getItemFullName() + "' does not exist");
        }
        duplicateItem.setItem(newItem);

        return duplicateItem;
    }

    public void rename(String newItemName) {
        SWTBotShell shell = beginEditWizard();
        gefBot.text(getItemName()).setText(newItemName);
        setItemName(newItemName);
        finishEditWizard(shell);
    }

    public SWTBotShell beginEditWizard() {
        return beginEditWizard("Edit properties", "Edit properties");
    }

    public SWTBotShell beginEditWizard(String contextMenu, String shellTitle) {
        getParentNode().getNode(getItemFullName()).contextMenu(contextMenu).click();
        SWTBotShell shell = null;
        if (shellTitle == null)
            shell = gefBot.activeShell();
        else
            shell = gefBot.shell(shellTitle).activate();
        return shell;
    }

    public void finishEditWizard(SWTBotShell shell) {
        finishCreationWizard(shell);
    }

    /**
     * Open creation wizard and configure first step of the wizard.
     * 
     * @param contextMenu context menu to open creation wizard
     * @param shellTitle title of the wizard, set as <code>null</code> if without title name.
     * @return the shell widget
     */
    public SWTBotShell beginCreationWizard(String contextMenu, String shellTitle) {
        getParentNode().contextMenu(contextMenu).click();

        SWTBotShell shell = gefBot.activeShell();
        if (shellTitle != null) {
            gefBot.waitUntil(Conditions.shellIsActive(shellTitle));
            shell = gefBot.shell(shellTitle);
            shell.activate();
        }

        // gefBot.textWithLabel("Name").setText(getItemName());
        SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
        gefBot.textWithLabel("Name").typeText(getItemName(), 0);
        return shell;
    }

    public void finishCreationWizard(final SWTBotShell shell) {
        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {
                return gefBot.button("Finish").isEnabled();
            }

            public String getFailureMessage() {
                shell.close();
                return "finish button is not enabled, item created fail. Maybe the item name already exist";
            }

        });
        gefBot.button("Finish").click();

        long defaultTimeout = SWTBotPreferences.TIMEOUT;
        SWTBotPreferences.TIMEOUT = 100;
        try {
            gefBot.shell("Problem Executing Operation").activate();
            String errorLog = gefBot.label(1).getText();
            gefBot.button("OK").click();
            Assert.fail(errorLog);
        } catch (WidgetNotFoundException e) {
            // ignore this exception, means error dialog didn't pop up, creating item successfully
        } finally {
            SWTBotPreferences.TIMEOUT = defaultTimeout;
        }

        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {
                return !shell.isOpen();
            }

            public String getFailureMessage() {
                return "shell did not close automatically";
            }

        }, 30000);

        if (gefBot.toolbarButtonWithTooltip("Save (Ctrl+S)").isEnabled()) {
            gefBot.toolbarButtonWithTooltip("Save (Ctrl+S)").click();
        }

        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {
                return getParentNode().expand().getNode(getItemFullName()).isVisible();
            }

            public String getFailureMessage() {
                return "item '" + getItemFullName() + "' did not create";
            }
        });

        setItem(getParentNode().getNode(getItemFullName()));
    }

    protected Object clone() {
        TalendItem item = null;
        try {
            item = (TalendItem) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return item;
    }
}
