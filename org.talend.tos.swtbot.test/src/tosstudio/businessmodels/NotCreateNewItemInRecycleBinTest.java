// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package tosstudio.businessmodels;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendBusinessModelItem;
import org.talend.swtbot.items.TalendFolderItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class NotCreateNewItemInRecycleBinTest extends TalendSwtBotForTos {

    private TalendBusinessModelItem businessModelItem;

    private static final String FOLDERNAME = "folderTest";

    private static final String BUSINESS_MODEL_NAME = "businessTest";

    @Before
    public void initialisePrivateField() {
        businessModelItem = new TalendBusinessModelItem(BUSINESS_MODEL_NAME);
        TalendFolderItem folder = Utilities.createFolder(FOLDERNAME, businessModelItem.getItemType());
        businessModelItem.setFolderPath(folder.getFolderPath());
        businessModelItem.create();
        businessModelItem.getModelEditor().saveAndClose();
        businessModelItem.delete();
    }

    @Test
    public void createNewItemInRecycleBin() {
        SWTBotTreeItem recycleBinNode = Utilities.getTalendItemNode(Utilities.TalendItemType.RECYCLE_BIN);

        boolean isCreateEnable = false;
        try {
            recycleBinNode.getNode(FOLDERNAME + " ()").contextMenu("Create Business Model").isEnabled();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertFalse("can create new item in recycle bin", isCreateEnable);
        }
    }

    @After
    public void removePreviouslyCreateItems() {
        Utilities.emptyRecycleBin();
    }
}
