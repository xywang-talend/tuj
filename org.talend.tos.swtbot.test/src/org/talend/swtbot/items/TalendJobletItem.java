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

import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendJobletItem extends TalendItem {

    public TalendJobletItem() {
        super(Utilities.TalendItemType.JOBLET_DESIGNS);
    }

    public TalendJobletItem(String itemName) {
        super(itemName, Utilities.TalendItemType.JOBLET_DESIGNS);
    }

    @Override
    public void create() {
        SWTBotShell shell = beginCreationWizard("Create Joblet", "New Joblet");
        finishCreationWizard(shell);
    }

    @Override
    public SWTBotShell beginEditWizard() {
        return beginEditWizard("Edit Properties", "Edit properties");
    }

    public SWTBotGefEditor getEditor() {
        return gefBot.gefEditor("Joblet " + itemFullName);
    }

    public void clearInputandOutput() {
        TalendSwtBotForTos tos = new TalendSwtBotForTos();
        SWTBotGefEditPart input = tos.getTalendComponentPart(getEditor(), "INPUT_1");
        deleteComponentInJoblet(input);
        SWTBotGefEditPart output = tos.getTalendComponentPart(getEditor(), "OUTPUT_1");
        deleteComponentInJoblet(output);
    }

    public void deleteComponentInJoblet(SWTBotGefEditPart gefEditpart) {
        getEditor().select(gefEditpart).setFocus();
        gefEditpart.click();
        getEditor().clickContextMenu("Delete");
    }
}
