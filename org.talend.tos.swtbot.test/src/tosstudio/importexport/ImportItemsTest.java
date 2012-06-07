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
package tosstudio.importexport;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
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
public class ImportItemsTest extends TalendSwtBotForTos {

    @Before
    public void initialisePrivateFields() {
        repositories = Utilities.getERepositoryObjectTypes();
    }

    @Test
    public void importItems() throws IOException, URISyntaxException {
        Utilities.importItems("items_" + getBuildType() + ".zip");

        Utilities.getRepositoryTree().setFocus();
        List<TalendItemType> itemTypes = new ArrayList<TalendItemType>();
        String itemVersion = " 0.1";
        if ("TIS".equals(TalendSwtBotForTos.getBuildType()))
            itemTypes = Utilities.getTISItemTypes();
        else if ("TOSDI".equals(TalendSwtBotForTos.getBuildType()))
            itemTypes = Utilities.getTOSDIItemTypes();
        else if ("TOSBD".equals(TalendSwtBotForTos.getBuildType())) {
            itemTypes = Utilities.getTOSBDItemTypes();
            itemVersion = "";
        }
        // undo assert for under items, cause did not import these items
        itemTypes.remove(TalendItemType.SAP_CONNECTIONS);
        itemTypes.remove(TalendItemType.TALEND_MDM);
        itemTypes.remove(TalendItemType.BRMS);
        itemTypes.remove(TalendItemType.SURVIVORSHIP_RULES);
        itemTypes.remove(TalendItemType.DOCUMENTATION);
        itemTypes.remove(TalendItemType.RECYCLE_BIN);

        String errorMsg = "";
        for (TalendItemType itemType : itemTypes) {
            errorMsg += assertItemExist(itemType, itemType.toString() + itemVersion);
        }
        if (!"".equals(errorMsg))
            Assert.fail(errorMsg);
    }

    private String assertItemExist(TalendItemType itemType, String itemFullName) {
        SWTBotTreeItem treeNode = Utilities.getTalendItemNode(itemType);
        if (TalendItemType.SQL_TEMPLATES.equals(itemType))
            treeNode = treeNode.expandNode("Hive", "UserDefined"); // focus on specific sql template type
        if (!treeNode.getNodes().contains(itemFullName))
            return "item '" + itemFullName + "' did not import\n";
        return "";
    }

}
