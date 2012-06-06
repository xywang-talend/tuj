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

import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendBusinessModelItem extends TalendItem {

    public TalendBusinessModelItem() {
        super(Utilities.TalendItemType.BUSINESS_MODEL);
    }

    public TalendBusinessModelItem(String itemName) {
        super(itemName, Utilities.TalendItemType.BUSINESS_MODEL);
    }

    @Override
    public void create() {
        SWTBotShell shell = beginCreationWizard("Create Business Model", "New Business Model");
        finishCreationWizard(shell);
    }

    public SWTBotGefEditor getEditor() {
        return gefBot.gefEditor(itemName);
    }
}
