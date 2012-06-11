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
package tosstudio.projectmanagement.statusmanagement;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendBusinessModelItem;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ChangeAllDocumentationItemsTest extends TalendSwtBotForTos {

    private TalendBusinessModelItem businessModelItem;

    private static final String BUSINESSMODELNAME = "businessModel1"; //$NON-NLS-1$

    @Before
    public void initialisePrivateFields() throws IOException, URISyntaxException {
        repositories.add(ERepositoryObjectType.BUSINESS_PROCESS);
        businessModelItem = new TalendBusinessModelItem(BUSINESSMODELNAME);
        businessModelItem.create();
        businessModelItem.getEditor().saveAndClose();
    }

    @Test
    public void changeAllDocumentationItems() {
        gefBot.toolbarButtonWithTooltip("Project settings").click();
        SWTBotShell shell = gefBot.shell("Project Settings").activate();
        gefBot.tree().expandNode("General").select("Status Management").click();
        Utilities.deselectDefaultSelection("Change all techinal items to a fixed status.");
        gefBot.radio("Change all documentation items to a fixed status.").click();

        gefBot.tree(1).getTreeItem("Business Models").check();
        gefBot.comboBox().setSelection("checked");
        gefBot.button("OK").click();
        gefBot.shell("Confirm").activate();
        gefBot.button("OK").click();
        gefBot.waitUntil(Conditions.shellCloses(shell));

        Assert.assertEquals("Business Models status", "checked", businessModelItem.getStatus());
    }

}
