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
package tosstudio.businessmodels;

import junit.framework.Assert;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendBusinessModelItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class SaveAsForBusinessModelTest extends TalendSwtBotForTos {

    private TalendBusinessModelItem bmItem1;

    private TalendBusinessModelItem bmItem2;

    private static final String BM_NAME1 = "businessModel1";

    private static final String BM_NAME2 = "businessModel2";

    @Before
    public void initialisePrivateFields() {
        repositories.add(ERepositoryObjectType.BUSINESS_PROCESS);
        bmItem1 = new TalendBusinessModelItem(BM_NAME1);
        bmItem1.create();
    }

    @Test
    public void saveAsForBusinessModelTest() {
        SWTBotGefEditor editor = bmItem1.getEditor();
        String toolName = "test";
        Utilities.dndPaletteToolOntoBusinessModel(editor, "Data", new Point(100, 100), toolName);
        gefBot.menu("File").menu("Save As...").click();
        gefBot.shell("Save As").activate();
        gefBot.textWithLabel("Name").setText(BM_NAME2);
        gefBot.button("Finish").click();
        bmItem2 = new TalendBusinessModelItem(BM_NAME2);
        SWTBotTreeItem item = bmItem1.getParentNode().getNode(BM_NAME2 + " 0.1");
        Assert.assertNotNull("new business model didn't save as", item);
        bmItem2.setItem(item);
        SWTBotGefEditPart editPart = bmItem2.getEditor().getEditPart(toolName);
        Assert.assertNotNull("components didn't save in new business model", editPart);
    }

}
