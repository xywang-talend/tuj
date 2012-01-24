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
package tisstudio.metadata.copybook;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DeleteCopybookTest extends TalendSwtBotForTos {

    private SWTBotTree tree;

    private SWTBotView view;

    private SWTBotTreeItem treeNode;

    private static final String COPYBOOKNAME = "copybook1"; //$NON-NLS-1$

    @Before
    public void createCopybook() throws IOException, URISyntaxException {
        view = Utilities.getRepositoryView();
        view.setFocus();
        tree = new SWTBotTree((Tree) gefBot.widget(WidgetOfType.widgetOfType(Tree.class), view.getWidget()));
        treeNode = Utilities.getTalendItemNode(Utilities.TalendItemType.COPYBOOK);
        Utilities.createCopybook(COPYBOOKNAME, treeNode);
    }

    @Test
    public void deleteCopybookTest() {
        Utilities.delete(treeNode, COPYBOOKNAME, "0.1", null);
    }

    @After
    public void removePreviousCreateItems() {
        Utilities.emptyRecycleBin();
    }
}
