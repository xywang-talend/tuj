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
package tisstudio.metadata.embeddedrules;

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
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DuplicateEmbeddedRulesTest extends TalendSwtBotForTos {

    private SWTBotView view;

    private SWTBotTree tree;

    private SWTBotTreeItem treeNode;

    private static final String EMBEDDED_RULES_NAME = "rulesTest";

    private static final String NEW_EMBEDDED_RULES_NAME = "dup_rulesTest";

    private static final String TYPE_OF_RULE_RESOURCE = "DRL";

    @Before
    public void createDrlEmbeddedRules() throws IOException, URISyntaxException {
        view = Utilities.getRepositoryView();
        tree = new SWTBotTree((Tree) gefBot.widget(WidgetOfType.widgetOfType(Tree.class), view.getWidget()));
        treeNode = Utilities.getTalendItemNode(Utilities.TalendItemType.EMBEDDED_RULES);
        Utilities.createEmbeddedRules(TYPE_OF_RULE_RESOURCE, EMBEDDED_RULES_NAME, treeNode);
        gefBot.cTabItem(EMBEDDED_RULES_NAME + " 0.1").close();
    }

    @Test
    public void duplicateEmbeddedRules() {
        Utilities.duplicate(treeNode, EMBEDDED_RULES_NAME, "0.1", NEW_EMBEDDED_RULES_NAME);
    }

    @After
    public void removePreviouslyCreateItems() {
        Utilities.cleanUpRepository(treeNode);
        Utilities.emptyRecycleBin();
    }
}
