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
package tisstudio.metadata.webservice;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendWebServiceItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CopyPasteWebServiceTest extends TalendSwtBotForTos {

    private TalendWebServiceItem webserviceItem;

    private static final String WEBSERVICENAME = "webService1"; //$NON-NLS-1$

    @Before
    public void initialisePrivateFields() {
        repositories.add(ERepositoryObjectType.METADATA_WSDL_SCHEMA);

        webserviceItem = new TalendWebServiceItem(WEBSERVICENAME);
        webserviceItem.setTypeAsSimple();
        webserviceItem.create();
    }

    @Test
    public void copyAndPasteWebService() {
        webserviceItem.copyAndPaste();
    }

}
