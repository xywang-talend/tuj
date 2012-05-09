package org.talend.swtbot.items;

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.talend.swtbot.Utilities;

public class TalendLdapItem extends TalendMetadataItem {

    public TalendLdapItem() {
        super(Utilities.TalendItemType.LDAP);
    }

    public TalendLdapItem(String itemName) {
        super(itemName, Utilities.TalendItemType.LDAP);
    }

    @Override
    public void create() {
        SWTBotShell shell = beginCreationWizard("Create LDAP schema", "Create new LDAP schema");
        /* step 2 of 5 */
        gefBot.comboBoxWithLabel("Hostname:").setText(System.getProperty("ldap.hostname"));
        gefBot.comboBoxWithLabel("Port:").setText(System.getProperty("ldap.port"));
        gefBot.button("Check Network Parameter").click();

        gefBot.waitUntil(Conditions.shellIsActive("Check Network Parameter"), 20000);
        SWTBotShell tempShell = gefBot.shell("Check Network Parameter");
        gefBot.button("OK").click();
        gefBot.waitUntil(Conditions.shellCloses(tempShell));
        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {
                return gefBot.button("Next >").isEnabled();
            }

            public String getFailureMessage() {
                gefBot.shell("Create new LDAP schema").close();
                return "connection failure";
            }
        });
        gefBot.button("Next >").click();

        /* step 3 of 5 */
        gefBot.comboBoxWithLabel("Bind DN or user:").setText(System.getProperty("ldap.dn_or_user"));
        gefBot.textWithLabel("Bind password:").setText(System.getProperty("ldap.password"));
        gefBot.button("Check Authentication").click();

        gefBot.waitUntil(Conditions.shellIsActive("Check Authentication Parameter"), 20000);
        tempShell = gefBot.shell("Check Authentication Parameter").activate();
        String checkMsg = gefBot.label(1).getText();
        gefBot.button("OK").click();
        gefBot.waitUntil(Conditions.shellCloses(tempShell));
        if ("The authentication check failed.".equals(checkMsg)) {
            shell.close();
            Assert.fail(checkMsg);
        }
        gefBot.button("Fetch Base DNs").click();
        gefBot.waitUntil(Conditions.shellIsActive("Fetch base DNs"));
        tempShell = gefBot.shell("Fetch base DNs");
        gefBot.button("OK").click();
        gefBot.waitUntil(Conditions.shellCloses(tempShell));
        gefBot.button("Next >").click();

        /* step 4 of 5 */
        for (int i = 0; i < 5; i++) {
            gefBot.tableInGroup("List attributes of LDAP Schema").getTableItem(i).check();
        }
        gefBot.button("Refresh Preview").click();
        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {
                return gefBot.button("Next >").isEnabled();
            }

            public String getFailureMessage() {
                gefBot.shell("Create new LDAP schema").close();
                return "next button was never enabled";
            }
        }, 60000);
        gefBot.button("Next >").click();
        finishCreationWizard(shell);
    }

    public SWTBotShell beginEditWizard() {
        return beginEditWizard("Edit LDAP schema", "Update LDAP schema");
    }
}
