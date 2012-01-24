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

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendRoutineItem extends TalendItem {

    public TalendRoutineItem() {
        super(Utilities.TalendItemType.ROUTINES);
    }

    public TalendRoutineItem(String itemName) {
        super(itemName, Utilities.TalendItemType.ROUTINES);
    }

    @Override
    public void create() {
        SWTBotShell shell = beginCreationWizard("Create routine", "New routine");
        finishCreationWizard(shell);
    }

    public SWTBotEditor getEditor() {
        return gefBot.editorByTitle(itemFullName);
    }
}
