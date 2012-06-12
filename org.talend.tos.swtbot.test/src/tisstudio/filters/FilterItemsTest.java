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
package tisstudio.filters;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withTooltip;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotLabel;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.SWTBotLabelExt;
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

    private SWTBotLabelExt filterLabel;

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

        Matcher matcher = withTooltip("Filters...\nRight click to set up");
        SWTBotLabel label = new SWTBotLabel((Label) gefBot.widget(matcher, view.getWidget()));
        filterLabel = new SWTBotLabelExt(label);
        filterLabel.rightClick();

        SWTBotShell shell = gefBot.shell("Repository Filter").activate();
        for (TalendItemType itemType : TalendItemType.values()) {
            if (TalendItemType.RECYCLE_BIN.equals(itemType))
                continue; // undo with routine and recycle bin
            tempTreeNode = Utilities.getTalendItemNode(gefBot.tree(0), itemType);
            tempTreeNode.uncheck();
        }
        gefBot.button("OK").click();
        gefBot.waitUntil(Conditions.shellCloses(shell));

        filterLabel.click();
        rowCount = tree.rowCount();

        Assert.assertEquals("items did not filter", 1, rowCount);
    }

    @After
    public void removePreviouslyCreateItems() {
        filterLabel.rightClick();
        SWTBotShell shell = gefBot.shell("Repository Filter").activate();
        for (TalendItemType itemType : TalendItemType.values()) {
            if (TalendItemType.ROUTINES.equals(itemType) || TalendItemType.RECYCLE_BIN.equals(itemType))
                continue; // undo with routine and recycle bin
            Utilities.getTalendItemNode(gefBot.tree(0), itemType).check();
        }
        gefBot.button("OK").click();
        gefBot.waitUntil(Conditions.shellCloses(shell));
        filterLabel.click();
    }
}
