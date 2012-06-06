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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
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

    @Before
    public void initialisePrivateFields() throws IOException, URISyntaxException {
        repositories = Utilities.getERepositoryObjectTypes();
        Utilities.importItems("items_" + getBuildType() + ".zip");
    }

    @Test
    public void changeAllItemsToAFixedVersion() {
        gefBot.toolbarButtonWithTooltip("Project settings").click();
        SWTBotShell shell = gefBot.shell("Project Settings").activate();
        gefBot.tree().expandNode("General").select("Version Management").click();

        List<TalendItemType> itemTypes = new ArrayList<TalendItemType>();
        if ("TIS".equals(getBuildType()))
            itemTypes = Utilities.getTISItemTypes();
        else if ("TOSDI".equals(getBuildType()))
            itemTypes = Utilities.getTOSDIItemTypes();
        // undo assert for under items, cause did not import these items
        itemTypes.remove(TalendItemType.SERVICES);
        itemTypes.remove(TalendItemType.SAP_CONNECTIONS);
        itemTypes.remove(TalendItemType.TALEND_MDM);
        itemTypes.remove(TalendItemType.BRMS);
        itemTypes.remove(TalendItemType.SURVIVORSHIP_RULES);
        itemTypes.remove(TalendItemType.VALIDATION_RULES);
        itemTypes.remove(TalendItemType.DOCUMENTATION);
        itemTypes.remove(TalendItemType.RECYCLE_BIN);

        shell.setFocus();
        for (TalendItemType itemType : itemTypes) {
            SWTBotTreeItem treeNode = Utilities.getTalendItemNode(gefBot.tree(1), itemType);
            treeNode.check();
        }
        gefBot.button("m").click();
        gefBot.button("OK").click();
        gefBot.shell("Confirm").activate();
        gefBot.button("OK").click();

        String errorMsg = "";
        for (TalendItemType itemType : itemTypes) {
            errorMsg += assertItemVersion(itemType);
        }
        if (!"".equals(errorMsg))
            Assert.fail(errorMsg);
    }

    private String assertItemVersion(final TalendItemType itemType) {
        SWTBotTreeItem itemNode = Utilities.getTalendItemNode(itemType);
        if (itemType == TalendItemType.SQL_TEMPLATES)
            itemNode = Utilities.getTalendItemNode(itemType).expandNode("Hive", "UserDefined");

        try {
            final SWTBotTreeItem node = itemNode;
            gefBot.waitUntil(new DefaultCondition() {

                public boolean test() throws Exception {
                    return node.expand().getNode(itemType.toString() + " 0.2").isVisible();
                }

                public String getFailureMessage() {
                    return null;
                }
            });
        } catch (TimeoutException e) {
            return "item '" + itemType.toString() + " 0.1' did not change to new version\n";
        }
        return "";
    }
}
