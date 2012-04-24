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
package tosstudio.projectmanagement.statusmanagement;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.Utilities.TalendItemType;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ChangeAllTechnicalItemsTest extends TalendSwtBotForTos {

    private static final String SAMPLE_RELATIVE_FILEPATH = "items.zip"; //$NON-NLS-1$

    private String[] treeNodes = { "Business Models", "Job Designs", "Contexts", "Code", "SQL Templates", "Metadata",
            "Documentation" };

    private String[] treeItems = { "BUSINESS_MODEL", "JOB_DESIGNS", "CONTEXTS", "ROUTINES", "SQL_TEMPLATES", "DB_CONNECTIONS",
            "FILE_DELIMITED", "FILE_POSITIONAL", "FILE_REGEX", "FILE_XML", "FILE_EXCEL", "FILE_LDIF", "LDAP", "SALESFORCE",
            "GENERIC_SCHEMAS", "WEB_SERVICE", "FTP" };

    private String[] codeNodes = { "Routines" };

    private String[] sqlTemplatePath = { "Generic", "UserDefined" };

    private String[] metadataNodes = { "Db Connections", "File delimited", "File positional", "File regex", "File xml",
            "File Excel", "File ldif", "LDAP", "Salesforce", "Generic schemas", "Web Service", "FTP" };

    private String[] metadataContextMenu = { "connection", "file delimited", "file positional", "file regex", "file xml",
            "file Excel", "file ldif", "LDAP schema", "Salesforce Connection", "generic schema", "WSDL schema", "FTP" };

    private String[] metadataShellTitle = { "Database Connection", "Edit an existing Delimited File",
            "Edit an existing Positional File", "Edit an existing RegEx File", "Edit an existing Xml File",
            "Edit an existing Excel File", "Edit an existing Ldif File", "Update LDAP schema", "Edit an exist Salesforce",
            "Update generic schema", "Update WSDL schema", "" };

    // private Map<String, String> map = new HashMap<String, String>();

    @Before
    public void initialisePrivateFields() throws IOException, URISyntaxException {
        Utilities.importItems(SAMPLE_RELATIVE_FILEPATH);
    }

    @Test
    public void changeAllTechnicalItems() {
        gefBot.toolbarButtonWithTooltip("Project settings").click();
        gefBot.shell("Project Settings").activate();
        gefBot.tree().expandNode("General").select("Status Management").click();
        for (TalendItemType itemType : TalendItemType.values()) {
            if (Utilities.getTISItemTypes().contains(itemType) || Utilities.TalendItemType.RECYCLE_BIN.equals(itemType))
                continue;
            SWTBotTreeItem treeNode = Utilities.getTalendItemNode(gefBot.tree(1), itemType);
            treeNode.check();
        }
        gefBot.comboBox().setSelection("testing");
        gefBot.button("OK").click();
        gefBot.shell("Confirm").activate();
        gefBot.button("OK").click();

        int i;
        // Assert business models, i=0
        i = 0;
        assertItemStatus(treeItems[i], "properties", "Edit properties", "", treeNodes[i]);
        // Assert job designs, i=1
        i = 1;
        assertItemStatus(treeItems[i], "properties", "Edit properties", "testing", treeNodes[i]);
        // Assert contexts, i=2
        i = 2;
        assertItemStatus(treeItems[i], "context group", "Create / Edit a context group", "testing", treeNodes[i]);
        // Assert code - routine, i=3
        i = 3;
        assertItemStatus(treeItems[i], "properties", "Edit properties", "testing", treeNodes[i], codeNodes[0]);
        // Assert sql template, i=4
        i = 4;
        assertItemStatus(treeItems[i], "properties", "Edit properties", "testing", treeNodes[i], sqlTemplatePath[0],
                sqlTemplatePath[1]);
        // Assert metadata, i=5
        i = 5;
        for (int k2 = 0; k2 < metadataNodes.length; k2++) {
            assertItemStatus(treeItems[i + k2], metadataContextMenu[k2], metadataShellTitle[k2], "testing", treeNodes[i],
                    metadataNodes[k2]);
        }
    }

    @After
    public void cleanup() {
        Utilities.resetActivePerspective();
    }

    private void assertItemStatus(String itemName, String contextMenu, String shellTitle, String assertExpect, String... nodes) {
        Utilities.getRepositoryTree().expandNode(nodes).getNode(itemName + " 0.1").contextMenu("Edit " + contextMenu).click();
        try {
            if (!"".equals(shellTitle))
                gefBot.shell(shellTitle).activate();
            Assert.assertEquals(itemName + " status", assertExpect, gefBot.ccomboBoxWithLabel("Status").getText());
            gefBot.button("Cancel").click();
        } catch (WidgetNotFoundException wnfe) {
            if (gefBot.shell("Message").isActive())
                gefBot.shell("Message").close();
            Assert.assertTrue(itemName + " widget not open", false);
        }
    }
}
