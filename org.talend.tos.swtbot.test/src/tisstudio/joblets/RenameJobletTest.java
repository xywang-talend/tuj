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
package tisstudio.joblets;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendJobletItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class RenameJobletTest extends TalendSwtBotForTos {

    private TalendJobletItem jobletItem;

    private static final String JOBLET_NAME = "jobletTest";

    private static final String NEW_JOBLET_NAME = "re_jobletTest";

    @Before
    public void initialisePrivateFields() {
    	repositories.add(ERepositoryObjectType.JOBLET);
        jobletItem = new TalendJobletItem(JOBLET_NAME);
        jobletItem.create();
        jobletItem.getEditor().saveAndClose();
    }

    @Test
    public void renameJoblet() {
        jobletItem.rename(NEW_JOBLET_NAME);
    }

}
