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
package tosstudio.projectmanagement.versioning;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
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
public class ChangeAllItemsToAFixedVersionTest extends TalendSwtBotForTos {

    private SWTBotView view;

    private SWTBotTree tree;

    private SWTBotShell shell;

    private static final String SAMPLE_RELATIVE_FILEPATH = "items.zip"; //$NON-NLS-1$

    private String[] treeNodes = { "Business Models", "Job Designs", "Contexts", "Code", "SQL Templates", "Metadata" };

    private String[] treeItems = { "BUSINESS_MODEL", "JOB_DESIGNS", "CONTEXTS", "ROUTINES", "SQL_TEMPLATES", "DB_CONNECTIONS",
            "FILE_DELIMITED", "FILE_POSITIONAL", "FILE_REGEX", "FILE_XML", "FILE_EXCEL", "FILE_LDIF", "LDAP", "SALESFORCE",
            "GENERIC_SCHEMAS", "WEB_SERVICE", "FTP" };

    private String[] codeNodes = { "Routines" };

    private String[] sqlTemplatePath = { "Generic", "UserDefined" };

    private String[] metadataNodes = { "Db Connections", "File delimited", "File positional", "File regex", "File xml",
            "File Excel", "File ldif", "LDAP", "Salesforce", "Generic schemas", "Web Service", "FTP" };

    @Before
    public void initialisePrivateFields() throws IOException, URISyntaxException {
        view = Utilities.getRepositoryView();
        tree = new SWTBotTree((Tree) gefBot.widget(WidgetOfType.widgetOfType(Tree.class), view.getWidget()));
        gefBot.toolbarButtonWithTooltip("Import Items").click();

        shell = gefBot.shell("Import items").activate();
        gefBot.radio("Select archive file:").click();
        gefBot.text(1).setText(Utilities.getFileFromCurrentPluginSampleFolder(SAMPLE_RELATIVE_FILEPATH).getAbsolutePath());
        gefBot.tree().setFocus();
        gefBot.button("Select All").click();
        gefBot.button("Finish").click();
        gefBot.waitUntil(Conditions.shellCloses(gefBot.shell("Progress Information")));
    }

    @Test
    public void changeAllItemsToAFixedVersion() {
        gefBot.toolbarButtonWithTooltip("Project settings").click();
        gefBot.shell("Project Settings").activate();
        gefBot.tree().expandNode("General").select("Version Management").click();
        for (TalendItemType itemType : TalendItemType.values()) {
            if (Utilities.getTISItemTypes().contains(itemType) || Utilities.TalendItemType.RECYCLE_BIN.equals(itemType))
                continue;
            SWTBotTreeItem treeNode = Utilities.getTalendItemNode(gefBot.tree(1), itemType);
            treeNode.check();
        }
        gefBot.button("m").click();
        gefBot.button("OK").click();
        gefBot.shell("Confirm").activate();
        gefBot.button("OK").click();

        for (int i = 0; i < treeNodes.length; i++) {
            if (i >= 0 && i <= 2) {
                assertItemVersion(treeItems[i] + " 0.2", treeNodes[i]);
            } else if (i == 3) {
                assertItemVersion(treeItems[i] + " 0.2", treeNodes[i], codeNodes[0]);
            } else if (i == 4) {
                assertItemVersion(treeItems[i] + " 0.2", treeNodes[i], sqlTemplatePath[0], sqlTemplatePath[1]);
            } else if (i == 5) {
                for (int j = 0; j < metadataNodes.length; j++) {
                    assertItemVersion(treeItems[i + j] + " 0.2", treeNodes[i], metadataNodes[j]);
                }
            }
        }
    }

    @After
    public void removePreviouslyCreateItems() {
        shell.close();
        Utilities.cleanUpRepository(tree, System.getProperty("buildType"));
        Utilities.emptyRecycleBin();
    }

    private void assertItemVersion(String itemName, String... nodes) {
        SWTBotTreeItem newTreeItem = null;
        try {
            newTreeItem = tree.expandNode(nodes).select(itemName);
        } finally {
            Assert.assertNotNull(itemName + " does not exist", newTreeItem);
            newTreeItem = null;
        }
    }
}
