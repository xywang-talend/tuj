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
import org.junit.After;
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
public class CreateBusinessModelInFolderTest extends TalendSwtBotForTos {

    private TalendBusinessModelItem businessModelItem;

    private static final String FOLDERNAME = "folderTest";

    private static final String BUSINESS_MODEL_NAME = "businessTest";

    @Before
    public void initialisePrivateField() {
        businessModelItem = new TalendBusinessModelItem(BUSINESS_MODEL_NAME);
        TalendFolderItem folder = Utilities.createFolder(FOLDERNAME, businessModelItem.getItemType());
        businessModelItem.setFolderPath(folder.getFolderPath());
    }

    @Test
    public void createBusinessModelInFolder() {
        businessModelItem.create();
    }

    @After
    public void removePreviouslyCreateItems() {
        businessModelItem.getEditor().saveAndClose();
        Utilities.cleanUpRepository(businessModelItem.getParentNode());
        Utilities.emptyRecycleBin();
    }
}
