package org.talend.top.swtbot.test.cheatsheets;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;

public class RegexPatternCheatSheetTest extends TalendSwtbotForTdq{
	@Test
	public void regexPatternCheatSheet(){
		bot.menu("Help").menu("Cheat Sheets...").click();
		bot.waitUntil(Conditions.shellIsActive("Cheat Sheet Selection"));
		bot.radio("Select a cheat sheet from the list:").click();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Talend - Cheat Sheets").getNode(4).expand().getNode(0).select();
		bot.button("OK").click();
		bot.sleep(10000);
		bot.cTabItem("Cheat Sheets").setFocus();
		formBot.imageHyperlink("Click to Begin").click();
		formBot.imageHyperlink("Click to perform").click();
		bot.textWithLabel("Name").setText("RegexPattern");
		bot.button("Next >").click();
		bot.textWithLabel("Regular expression:").setText("'^(m|M|male|Male|f|F|female|Female)$'");
		bot.button("Finish").click();
		
		
	}
	@After
	public void afterClass(){
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Patterns","Regex").select("RegexPattern 0.1");
		ContextMenuHelper.clickContextMenu(tree, "Delete");
		try {
			SWTBotShell shell = bot.shell("refresh");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		
		}
		Assert.assertNotNull(tree.expandNode("Recycle Bin").select("RegexPattern"));
		tree.expandNode("Recycle Bin").select("RegexPattern");
		ContextMenuHelper.clickContextMenu(tree, "Delete");
		bot.waitUntil(Conditions.shellIsActive("Delete forever"));
		SWTBotShell shell = bot.shell("Delete forever");
		bot.button("Yes").click();
		bot.waitUntil(Conditions.shellCloses(shell));
		
	}
	

}
