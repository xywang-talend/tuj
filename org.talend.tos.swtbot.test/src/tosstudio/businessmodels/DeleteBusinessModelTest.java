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

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendBusinessModelItem;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DeleteBusinessModelTest extends TalendSwtBotForTos {

    private TalendBusinessModelItem businessModelItem;

    private static final String BUSINESSMODELNAME = "businessModel1"; //$NON-NLS-1$

    @Before
    public void initialisePrivateFields() {
        repositories.add(ERepositoryObjectType.BUSINESS_PROCESS);
        businessModelItem = new TalendBusinessModelItem(BUSINESSMODELNAME);
        businessModelItem.create();
    }

    @Test
    public void deleteBusinessModel() {
        businessModelItem.getEditor().saveAndClose();
        businessModelItem.delete();
    }
}
