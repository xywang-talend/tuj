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
        for (TalendItemType itemType : TalendItemType.values()) {
            String itemVersion = " 0.1";
            if ("TOSDI".equals(TalendSwtBotForTos.getBuildType())) {
                if (Utilities.getTISItemTypes().contains(itemType))
                    continue; // if TOSDI, pass TIS items
            }
            if ("TOSBD".equals(TalendSwtBotForTos.getBuildType())) {
                if (!Utilities.getTOSBDItemTypes().contains(itemType))
                    continue; // if TOSBD, pass items except TOSBD
                itemVersion = "";
            }
            SWTBotTreeItem treeNode = Utilities.getTalendItemNode(itemType);
            if (TalendItemType.SQL_TEMPLATES.equals(itemType))
                treeNode = treeNode.expandNode("Hive", "UserDefined"); // focus on specific sql template type
            if (TalendItemType.DOCUMENTATION.equals(itemType) || TalendItemType.RECYCLE_BIN.equals(itemType))
                continue; // undo with documentation and recycle bin
            if (treeNode.rowCount() != 0) {
                SWTBotTreeItem newTreeItem = treeNode.select(itemType.toString() + itemVersion);
                Assert.assertNotNull(itemType.toString() + " item not exist", newTreeItem);
            }
        }
    }

}
