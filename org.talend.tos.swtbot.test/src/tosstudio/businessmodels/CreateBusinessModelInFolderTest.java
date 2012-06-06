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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendBusinessModelItem;
import org.talend.swtbot.items.TalendFolderItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CreateBusinessModelInFolderTest extends TalendSwtBotForTos {

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
    }

    @Test
    public void createBusinessModelInFolder() {
        businessModelItem.create();
    }

}
