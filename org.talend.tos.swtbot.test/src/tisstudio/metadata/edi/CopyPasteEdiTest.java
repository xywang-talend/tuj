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
package tisstudio.metadata.edi;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendEdiItem;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CopyPasteEdiTest extends TalendSwtBotForTos {

    private TalendEdiItem ediItem;

    private static final String EDINAME = "ediTest";

    private static final String STANDARD = "WASDIS";

    private static final String RELEASE = "d00a";

    private static final String[] SCHEMAS = { "Document_name_code", "Code_list_identification_code",
            "Code_list_responsible_agency_code", "Document_name" };

    @Before
    public void createEdi() {
        repositories.add(ERepositoryObjectType.METADATA_EDIFACT);
        ediItem = new TalendEdiItem(EDINAME, STANDARD, RELEASE, SCHEMAS);
        ediItem.create();
    }

    @Test
    public void copyAndPasteEdi() {
        ediItem.copyAndPaste();
    }

}
