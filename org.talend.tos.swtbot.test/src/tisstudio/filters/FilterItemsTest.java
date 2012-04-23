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
package tisstudio.filters;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotViewMenu;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotToolbarButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.Utilities.TalendItemType;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class FilterItemsTest extends TalendSwtBotForTos {

    private SWTBotView view;

    private SWTBotTree tree;

    private SWTBotViewMenu menu;

    private SWTBotToolbarButton button;

    private SWTBotShell tempShell;

    @Before
    public void initialisePrivateField() {
        repositories.add(ERepositoryObjectType.PROCESS);
        view = Utilities.getRepositoryView();
        tree = new SWTBotTree((Tree) gefBot.widget(WidgetOfType.widgetOfType(Tree.class), view.getWidget()));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Test
    public void filterItems() {
        SWTBotTreeItem tempTreeNode = null;
        int rowCount = 0;

        button = gefBot.viewByTitle("Repository").toolbarButton("Activte Filter \n(filter settings available in the view menu)");
        button.click();
        menu = gefBot.viewByTitle("Repository").menu("Filter Setting...");
        menu.click();

        tempShell = gefBot.shell("Repository Filter Setting").activate();
        try {
            for (TalendItemType itemType : TalendItemType.values()) {
                if (TalendItemType.RECYCLE_BIN.equals(itemType))
                    continue; // undo wrecycle bin
                tempTreeNode = Utilities.getTalendItemNode(gefBot.tree(0), itemType);
                tempTreeNode.uncheck();
            }
            gefBot.button("OK").click();

            rowCount = tree.rowCount();
        } catch (WidgetNotFoundException wnfe) {
            tempShell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            tempShell.close();
            Assert.fail(e.getMessage());
        }

        Assert.assertEquals("items did not filter", 1, rowCount);
    }

    @After
    public void removePreviouslyCreateItems() {
        menu.click();
        SWTBotTreeItem tempTreeNode = null;
        try {
            for (TalendItemType itemType : TalendItemType.values()) {
                if (TalendItemType.ROUTINES.equals(itemType) || TalendItemType.RECYCLE_BIN.equals(itemType))
                    continue; // undo with routine and recycle bin
                tempTreeNode = Utilities.getTalendItemNode(gefBot.tree(0), itemType);
                tempTreeNode.check();
            }
            gefBot.button("OK").click();
        } catch (WidgetNotFoundException wnfe) {
            tempShell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            tempShell.close();
            Assert.fail(e.getMessage());
        }
        button.click();
    }
}
