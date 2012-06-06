package org.talend.swtbot.items;

import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;

public class TalendJobItem extends TalendItem {

    public TalendJobItem() {
        super(Utilities.TalendItemType.JOB_DESIGNS);
    }

    public TalendJobItem(String itemName) {
        super(itemName, Utilities.TalendItemType.JOB_DESIGNS);
    }

    @Override
    public void create() {
        SWTBotShell shell = beginCreationWizard("Create job", "Job version");
        finishCreationWizard(shell);
    }

    public SWTBotGefEditor getEditor() {
        if ("TOSBD".equals(TalendSwtBotForTos.getBuildType()))
            return gefBot.gefEditor("Job " + itemFullName + " ");
        return gefBot.gefEditor("Job " + itemFullName);
    }
}
