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
package org.talend.swtbot.items;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendSqlTemplateItem extends TalendItem {

    public TalendSqlTemplateItem() {
        super(Utilities.TalendItemType.SQL_TEMPLATES);
    }

    public TalendSqlTemplateItem(String itemName) {
        super(itemName, Utilities.TalendItemType.SQL_TEMPLATES);
    }

    @Override
    public void create() {
        SWTBotShell shell = beginCreationWizard("Create SQLTemplate", "New SQLTemplate");
        finishCreationWizard(shell);
    }

    public SWTBotEditor getEditor() {
        return gefBot.editorByTitle(itemFullName);
    }
}
