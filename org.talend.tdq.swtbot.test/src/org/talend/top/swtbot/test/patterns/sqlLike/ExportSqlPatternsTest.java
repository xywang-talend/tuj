package org.talend.top.swtbot.test.patterns.sqlLike;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;

public class ExportSqlPatternsTest extends TalendSwtbotForTdq{
	
	@Test
	public void ExportSqlPatterns(){
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Patterns","SQL").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree, "Export Patterns");
		bot.waitUntil(Conditions.shellIsActive("Export Patterns"));
		bot.textWithLabel("Select File (csv):").setText("F:\\tmp\\SQLPatterns.csv");
		tree = new SWTBotTree(bot.widget(WidgetOfType.widgetOfType(Tree.class)));
		tree.getTreeItem("Email Yahoo 0.1").check();
		 bot.button("Finish").click();
		
	}

}
