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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Assert;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendSapItem extends TalendMetadataItem {

    public TalendSapItem() {
        super(Utilities.TalendItemType.SAP_CONNECTIONS);
    }

    public TalendSapItem(String itemName) {
        super(itemName, Utilities.TalendItemType.SAP_CONNECTIONS);
    }

    @Override
    public void create() {
        SWTBotShell shell = beginCreationWizard("Create SAP connection", "SAP Connection");
        try {
            /* step 2 of 2 */
            gefBot.textWithLabel("Client").setText(System.getProperty("sap.client"));
            gefBot.textWithLabel("Host").setText(System.getProperty("sap.host"));
            gefBot.textWithLabel("User").setText(System.getProperty("sap.user"));
            gefBot.textWithLabel("Password").setText(System.getProperty("sap.password"));
            gefBot.textWithLabel("System Number").setText(System.getProperty("sap.systemNumber"));
            gefBot.textWithLabel("Language").setText(System.getProperty("sap.language"));
            int i = 0;
            while (i < 3) {
                gefBot.button("Check").click();
                if (gefBot.activeShell().getText().equals("Check SAP Connection ")) {
                    gefBot.button("OK").click();
                    break;
                }
                gefBot.button("OK").click();
                i++;
            }
            if (i == 3) {
                shell.close();
                Assert.fail("connection failure");
            }
        } catch (WidgetNotFoundException wnfe) {
            shell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            shell.close();
            Assert.fail(e.getMessage());
        }
        finishCreationWizard(shell);
    }

    public void retrieveSapFunction(String... functionName) {
        SWTGefBot gefBot = new SWTGefBot();
        getItem().contextMenu("Retrieve SAP Function").click();
        SWTBotShell shell = gefBot.shell("SAP Function wizard").activate();
        try {
            for (int i = 0; i < 5; i++) {
                gefBot.button("Search").click();
                if (gefBot.activeShell().getText().equals("SAP"))
                    gefBot.button("OK").click();
                else
                    break;
            }
            List<String> functionList = new ArrayList<String>(Arrays.asList(functionName));
            for (String function : functionList)
                gefBot.tableInGroup("Functions").getTableItem(function).click();
            gefBot.cTabItem("Test it").show();
            gefBot.table(0).select(1, 4, 5, 6, 7, 8, 9, 10, 11);
            gefBot.button("Remove", 0).click();
            gefBot.table(0).click(0, 5);
            gefBot.text().setText("|");
            gefBot.table(0).click(1, 5);
            gefBot.text().setText("SFLIGHT");
            gefBot.table(0).click(2, 5);
            gefBot.text().setText("20");
            gefBot.button("Finish").click();
        } catch (WidgetNotFoundException wnfe) {
            shell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            shell.close();
            Assert.fail(e.getMessage());
        }

    }

    public TalendSapItem getSapFunction(String functionName) {
        TalendSapItem sapItem = new TalendSapItem();
        SWTBotTreeItem functionNode = getParentNode().expandNode("SAP Functions");
        sapItem.setItem(functionNode.getNode(functionName));
        sapItem.setParentNode(functionNode);
        return sapItem;
    }

    public void retrieveSchema(String... schemaName) {
        SWTGefBot gefBot = new SWTGefBot();
        getItem().contextMenu("Retrieve Schema").click();
        try {
            List<String> schemas = new ArrayList<String>(Arrays.asList(schemaName));
            for (String schema : schemas)
                gefBot.tableInGroup("Select schema to create").getTableItem(schema).check();
            gefBot.button("Next >").click();
            gefBot.button("Finish").click();
        } catch (WidgetNotFoundException wnfe) {
            gefBot.activeShell().close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            gefBot.activeShell().close();
            Assert.fail(e.getMessage());
        }
    }

    public TalendSchemaItem getSchema(String schemaName) {
        TalendSchemaItem schemaItem = new TalendSchemaItem(this.getItemType());
        schemaItem.setItem(getItem().expand().getNode(schemaName));
        schemaItem.setParentNode(getItem());
        return schemaItem;
    }

    @Override
    public SWTBotShell beginEditWizard() {
        return beginEditWizard("Edit SAP connection", "SAP Connection");
    }
}
