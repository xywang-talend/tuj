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

import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendBusinessModelItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ReadBusinessModelTest extends TalendSwtBotForTos {

    private TalendBusinessModelItem businessModelItem;

    private static final String BUSINESS_MODEL_NAME = "businessTest";

    @Before
    public void createBusinessModel() {
        repositories.add(ERepositoryObjectType.BUSINESS_PROCESS);
        businessModelItem = new TalendBusinessModelItem(BUSINESS_MODEL_NAME);
        businessModelItem.create();
        businessModelItem.getEditor().close();
    }

    @Test
    public void readBusinessModel() {
        businessModelItem.getItem().contextMenu("Read Business Model").click();

        SWTBotGefEditor editor = null;
        try {
            editor = businessModelItem.getEditor();
        } catch (WidgetNotFoundException wnfe) {
            wnfe.printStackTrace();
        } finally {
            Assert.assertNotNull("business model did not open", editor);
        }
    }

}
