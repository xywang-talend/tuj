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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Assert;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendSalesforceItem extends TalendMetadataItem {

    private String proxyType;

    private static final String HTTP_PROXY = "HTTP";

    private static final String SOCKS_PROXY = "SOCKS";

    public TalendSalesforceItem() {
        super(Utilities.TalendItemType.SALESFORCE);
    }

    public TalendSalesforceItem(String itemName) {
        super(itemName, Utilities.TalendItemType.SALESFORCE);
    }

    public String getProxyType() {
        return proxyType;
    }

    public void setProxyTypeAsHttp() {
        this.proxyType = HTTP_PROXY;
    }

    public void setProxyTypeAsSocks() {
        this.proxyType = SOCKS_PROXY;
    }

    public Map<String, TalendSalesforceItem> retrieveModules(String... moduleName) {
        getItem().contextMenu("Retrieve Salesforce Modules").click();
        gefBot.waitUntil(Conditions.shellIsActive("Schema"), 60000);
        SWTBotShell tempShell = gefBot.shell("Schema");
        Map<String, TalendSalesforceItem> moduleItems = new HashMap<String, TalendSalesforceItem>();

        try {
            List<String> modules = new ArrayList<String>(Arrays.asList(moduleName));
            for (String module : modules) {
                gefBot.table(0).getTableItem(module).check();
            }
            // gefBot.waitUntil(Conditions.shellCloses(gefBot.shell("Progress Information")), 60000);
            gefBot.button("Finish").click();

            for (String module : modules) {
                TalendSalesforceItem tempItem = new TalendSalesforceItem();
                tempItem.setParentNode(getItem());
                tempItem.setItem(getItem().getNode(module).select());
                moduleItems.put(module, tempItem);
            }
        } catch (WidgetNotFoundException wnfe) {
            tempShell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            tempShell.close();
            Assert.fail(e.getMessage());
        }
        return moduleItems;
    }

    @Override
    public void create() {
        SWTBotShell shell = beginCreationWizard("Create Salesforce Connection", "New Salesforce ");
        /* step 2 of 4 */
        gefBot.textWithLabel("User name").setText(System.getProperty("salesforce.username"));
        gefBot.textWithLabel("Password ").setText(System.getProperty("salesforce.password"));

        if (HTTP_PROXY.equals(proxyType)) {
            gefBot.checkBox("Enable Http proxy").click();
            gefBot.button("OK").click();
        } else if (SOCKS_PROXY.equals(proxyType)) {
            gefBot.checkBox("Enable Socks proxy").click();
        }
        if (proxyType != null && !proxyType.equals("")) {
            gefBot.textWithLabel("Host").setText(System.getProperty("salesforce.proxy.host"));
            gefBot.textWithLabel("Port").setText(System.getProperty("salesforce.proxy.port"));
            gefBot.textWithLabel("Username").setText(System.getProperty("salesforce.proxy.username"));
            gefBot.textWithLabel("Password").setText(System.getProperty("salesforce.proxy.password"));
        }

        gefBot.button("Check login").click();

        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {
                return gefBot.shell("Check Connection ").isActive();
            }

            public String getFailureMessage() {
                gefBot.shell("New Salesforce ").close();
                return "connection failure";
            }
        }, 30000);
        gefBot.button("OK").click();
        finishCreationWizard(shell);
    }

    public SWTBotShell beginEditWizard() {
        return beginEditWizard("Edit Salesforce Connection", "Edit an exist Salesforce");
    }
}
