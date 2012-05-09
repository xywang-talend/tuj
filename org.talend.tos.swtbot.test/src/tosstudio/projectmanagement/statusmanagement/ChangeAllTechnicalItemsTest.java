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
import java.util.ArrayList;
import java.util.List;

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
import org.talend.swtbot.items.TalendItem;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ChangeAllTechnicalItemsTest extends TalendSwtBotForTos {

    @Before
    public void initialisePrivateFields() throws IOException, URISyntaxException {
        Utilities.importItems("items_" + getBuildType() + ".zip");
    }

    @Test
    public void changeAllTechnicalItems() {
        gefBot.toolbarButtonWithTooltip("Project settings").click();
        gefBot.shell("Project Settings").activate();
        gefBot.tree().expandNode("General").select("Status Management").click();
        List<TalendItemType> itemTypes = new ArrayList<TalendItemType>();
        if ("TIS".equals(getBuildType()))
            itemTypes = Utilities.getTISItemTypes();
        else if ("TOSDI".equals(getBuildType()))
            itemTypes = Utilities.getTOSDIItemTypes();
        else if ("TOSBD".equals(getBuildType()))
            itemTypes = Utilities.getTOSBDItemTypes();
        // undo assert for under items, cause did not import these items
        itemTypes.remove(TalendItemType.SERVICES);
        itemTypes.remove(TalendItemType.TALEND_MDM);
        itemTypes.remove(TalendItemType.BRMS);
        itemTypes.remove(TalendItemType.SURVIVORSHIP_RULES);
        itemTypes.remove(TalendItemType.VALIDATION_RULES);
        itemTypes.remove(TalendItemType.DOCUMENTATION);
        itemTypes.remove(TalendItemType.RECYCLE_BIN);

        for (TalendItemType itemType : itemTypes) {
            SWTBotTreeItem treeNode = Utilities.getTalendItemNode(gefBot.tree(1), itemType);
            treeNode.check();
        }
        gefBot.comboBox().setSelection("testing");
        gefBot.button("OK").click();
        gefBot.shell("Confirm").activate();
        gefBot.button("OK").click();

        String errorMsg = "";
        for (TalendItemType itemType : itemTypes) {
            String assertExpect = "testing";
            if (TalendItemType.BUSINESS_MODEL.equals(itemType))
                assertExpect = "";
            errorMsg += assertItemStatus(itemType, assertExpect);
        }
        if (!"".equals(errorMsg))
            Assert.fail(errorMsg);
    }

    @After
    public void cleanup() {
        Utilities.resetActivePerspective();
    }

    private String assertItemStatus(TalendItemType itemType, String assertExpect) {
        SWTBotTreeItem treeNode = null;
        if (itemType == TalendItemType.SQL_TEMPLATES)
            treeNode = Utilities.getTalendItemNode(itemType).expandNode("Hive", "UserDefined");
        else
            treeNode = Utilities.getTalendItemNode(itemType);

        String itemName = itemType.toString() + " 0.1";
        if ("TOSBD".equals(getBuildType()))
            itemName = itemType.toString();
        if (!treeNode.getNodes().contains(itemName))
            return "item '" + itemName + "' did not import\n";

        TalendItem item = Utilities.getInstanceOfType(itemType);
        if (itemType == TalendItemType.SQL_TEMPLATES)
            item.setFolderPath("Hive/UserDefined");
        item.setItem(treeNode.getNode(itemName));
        if (!assertExpect.equals(item.getStatus()))
            return "status of item '" + itemName + "' did not change\n";

        return "";
    }
}
