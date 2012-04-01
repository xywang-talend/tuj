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
package tosstudio.metadata.databaseoperation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendFolderItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CreateFolderForDbConnTest extends TalendSwtBotForTos {

    private TalendFolderItem folderItem;

    private static final String FOLDERNAME = "folder_db";

    @Before
    public void initialisePrivateFields() {
        List<String> folders = new ArrayList<String>();
        folders.add(FOLDERNAME);
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        repositoriesFolders.put(ERepositoryObjectType.METADATA_CONNECTIONS, folders);

        folderItem = new TalendFolderItem(FOLDERNAME);
    }

    @Test
    public void createFolderForDbConn() {
        folderItem.createUnder(Utilities.TalendItemType.DB_CONNECTIONS);
    }
}
