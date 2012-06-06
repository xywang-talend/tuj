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
package tosstudio.businessmodels;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
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

    private TalendFolderItem folder;

    private static final String FOLDERNAME = "folderTest";

    private static final String BUSINESS_MODEL_NAME = "businessTest";

    @Before
    public void initialisePrivateField() {
        List<String> folders = new ArrayList<String>();
        folders.add(FOLDERNAME);
        repositories.add(ERepositoryObjectType.BUSINESS_PROCESS);
        repositoriesFolders.put(ERepositoryObjectType.BUSINESS_PROCESS, folders);

        businessModelItem = new TalendBusinessModelItem(BUSINESS_MODEL_NAME);
        folder = new TalendFolderItem(FOLDERNAME);
        folder = folder.createUnder(businessModelItem.getItemType());
        businessModelItem.setFolderPath(folder.getFolderPath());
        businessModelItem.create();
        businessModelItem.getEditor().saveAndClose();
        folder.delete();
    }

    @Test
    public void createNewItemInRecycleBin() {
        SWTBotTreeItem recycleBinNode = Utilities.getTalendItemNode(Utilities.TalendItemType.RECYCLE_BIN);

        boolean isCreateEnable = false;
        long defaultTimeout = SWTBotPreferences.TIMEOUT;
        try {
            SWTBotPreferences.TIMEOUT = 500;
            isCreateEnable = recycleBinNode.getNode(FOLDERNAME + " ()").contextMenu("Create Business Model").isEnabled();
        } catch (Exception e) {
            // means could not find the menu, could not create item, so test is ok.
        } finally {
            SWTBotPreferences.TIMEOUT = defaultTimeout;
            Assert.assertFalse("should not create new item in recycle bin", isCreateEnable);
        }
    }

}
