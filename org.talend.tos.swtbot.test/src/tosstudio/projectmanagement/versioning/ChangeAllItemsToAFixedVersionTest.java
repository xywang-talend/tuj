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

    @Before
    public void initialisePrivateFields() throws IOException, URISyntaxException {
        Utilities.importItems("items_" + getBuildType() + ".zip");
    }

    @Test
    public void changeAllItemsToAFixedVersion() {
        gefBot.toolbarButtonWithTooltip("Project settings").click();
        gefBot.shell("Project Settings").activate();
        gefBot.tree().expandNode("General").select("Version Management").click();

        List<TalendItemType> itemTypes = new ArrayList<TalendItemType>();
        for (TalendItemType itemType : TalendItemType.values())
            itemTypes.add(itemType);
        if ("TOSDI".equals(TalendSwtBotForTos.getBuildType()))
            itemTypes.removeAll(Utilities.getTISItemTypes());
        // undo assert for under items, cause did not import these items
        itemTypes.remove(TalendItemType.SERVICES);
        itemTypes.remove(TalendItemType.TALEND_MDM);
        itemTypes.remove(TalendItemType.BRMS);
        itemTypes.remove(TalendItemType.EMBEDDED_RULES);
        itemTypes.remove(TalendItemType.SURVIVORSHIP_RULES);
        itemTypes.remove(TalendItemType.COPYBOOK);
        itemTypes.remove(TalendItemType.VALIDATION_RULES);
        itemTypes.remove(TalendItemType.HL7);
        itemTypes.remove(TalendItemType.EDI);
        itemTypes.remove(TalendItemType.DOCUMENTATION);
        itemTypes.remove(TalendItemType.RECYCLE_BIN);

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

    @After
    public void cleanup() {
        Utilities.resetActivePerspective();
    }

    private String assertItemVersion(TalendItemType itemType) {
        List<String> nodes = new ArrayList<String>();
        if (itemType == TalendItemType.SQL_TEMPLATES)
            nodes = Utilities.getTalendItemNode(itemType).expandNode("Generic", "UserDefined").getNodes();
        else
            nodes = Utilities.getTalendItemNode(itemType).getNodes();

        if (!nodes.contains(itemType.toString() + " 0.2"))
            return "item '" + itemType.toString() + " 0.1' did not change to new version\n";
        return "";
    }
}
