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
package tosstudio.projectmanagement.performance;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendFolderItem;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CreateFolderForJobTest extends TalendSwtBotForTos {

    private TalendFolderItem folderItem;

    private static final String FOLDERNAME = "folder1"; //$NON-NLS-1$

    @Before
    public void initialisePrivateFields() {
    }

    @Test
    public void createFolderForJob() {
        folderItem = Utilities.createFolder(FOLDERNAME, Utilities.TalendItemType.JOB_DESIGNS);
    }

    @After
    public void removePreviouslyCreateItems() {
        Utilities.cleanUpRepository(folderItem.getParentNode());
        Utilities.emptyRecycleBin();
    }
}
