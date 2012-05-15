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
package org.talend.swtbot.items;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendHL7Item extends TalendFileItem {

    public TalendHL7Item() {
        super(Utilities.TalendItemType.HL7, System.getProperty("hl7.filepath"));
    }

    public TalendHL7Item(String itemName) {
        super(itemName, Utilities.TalendItemType.HL7, System.getProperty("hl7.filepath"));
    }

    public SWTBotShell beginEditWizard() {
        return beginEditWizard("Edit HL7", "New HL7 File");
    }
}
