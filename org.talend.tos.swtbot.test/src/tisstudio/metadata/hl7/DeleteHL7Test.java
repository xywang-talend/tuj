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
package tisstudio.metadata.hl7;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendHL7Item;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DeleteHL7Test extends TalendSwtBotForTos {

    private TalendHL7Item hl7Item;

    private static final String HL7NAME = "hl7_1"; //$NON-NLS-1$ 

    @Before
    public void initialisePrivateFields() {
        repositories.add(ERepositoryObjectType.METADATA_FILE_HL7);

        hl7Item = new TalendHL7Item(HL7NAME);
        hl7Item.setTypeAsInput();
        hl7Item.create();
    }

    @Test
    public void deleteHL7() {
        hl7Item.delete();
    }

}
