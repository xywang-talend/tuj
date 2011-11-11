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
package tosstudio.projectmanagement.statusmanagement;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendBusinessModelItem;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class UpdateTheStatusOfEachItemTest extends TalendSwtBotForTos {

    private SWTBotShell shell;

    private TalendBusinessModelItem businessModelItem;

    private static final String BUSINESSMODELNAME = "businessModel1"; //$NON-NLS-1$

    @Before
    public void initialisePrivateFields() throws IOException, URISyntaxException {
        businessModelItem = new TalendBusinessModelItem(BUSINESSMODELNAME);
        businessModelItem.create();
        businessModelItem.getEditor().saveAndClose();
    }

    @Test
    public void updateTheStatusOfEachItem() {
        gefBot.toolbarButtonWithTooltip("Project settings").click();
        shell = gefBot.shell("Project Settings");
        shell.activate();
        try {
            gefBot.tree().expandNode("General").select("Status Management").click();
            Utilities.deselectDefaultSelection("Change all techinal items to a fixed status.");
            gefBot.radio("Update the Status of each item.").click();

            gefBot.tree(1).getTreeItem("Business Models").check();
            gefBot.table().click(0, 2);
            gefBot.ccomboBox("unchecked").setSelection("checked");
            gefBot.button("OK").click();
            gefBot.shell("Confirm the new version of items").activate();
            gefBot.button("Confirm").click();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shell.close();
        }

        businessModelItem.getItem().contextMenu("Edit properties").click();
        shell = gefBot.shell("Edit properties");
        shell.activate();
        Assert.assertEquals("Business Models status", "checked", gefBot.ccomboBoxWithLabel("Status").getText());
        shell.close();
    }

    @After
    public void removePreviouslyCreateItems() {
        shell.close();
        Utilities.cleanUpRepository(businessModelItem.getParentNode());
        Utilities.emptyRecycleBin();
    }
}
