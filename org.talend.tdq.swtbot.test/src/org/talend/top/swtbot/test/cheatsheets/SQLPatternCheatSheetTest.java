package org.talend.top.swtbot.test.cheatsheets;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;

public class SQLPatternCheatSheetTest extends TalendSwtbotForTdq{
	@Test
	public void sQLPatternCheatSheet(){
		bot.sleep(10000);
		bot.menu("Help").menu("Cheat Sheets...").click();
		bot.waitUntil(Conditions.shellIsActive("Cheat Sheet Selection"));
		bot.radio("Select a cheat sheet from the list:").click();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Talend - Cheat Sheets").getNode("Pattern").expand().getNode(1).select();
		bot.button("OK").click();
		bot.sleep(2000);
		bot.cTabItem("Cheat Sheets").setFocus();
		formBot.imageHyperlink("Click to Begin").click();
		formBot.imageHyperlink("Click to perform").click();
		bot.textWithLabel("Name").setText("SQLPattern");
		bot.button("Next >").click();
		bot.textWithLabel("SQL Like expression:").setText("'%@yahoo.%'");
		bot.button("Finish").click();
		bot.editorByTitle("SQLPattern 0.1").close();
		try {
		bot.cTabItem("Cheat Sheets").close();
	} catch (WidgetNotFoundException e) {
		System.out.println("Haven't found Cheat Sheets");
	}
		
		
	}
//	@After
//	public void afterClass(){
//		bot.viewByTitle("DQ Repository").setFocus();
//		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
//				WidgetOfType.widgetOfType(Tree.class),
//				bot.viewByTitle("DQ Repository").getWidget()));
//		tree.expandNode("Libraries","Patterns","SQL").select("SQLPattern 0.1");
//		ContextMenuHelper.clickContextMenu(tree, "Delete");
//		try {
//			SWTBotShell shell = bot.shell("refresh");
//			bot.waitUntil(Conditions.shellCloses(shell));
//		} catch (Exception e) {
//		
//		}
//		Assert.assertNotNull(tree.expandNode("Recycle Bin").select("SQLPattern"));
//		tree.expandNode("Recycle Bin").select("SQLPattern");
//		ContextMenuHelper.clickContextMenu(tree, "Delete");
//		bot.waitUntil(Conditions.shellIsActive("Delete forever"));
//		SWTBotShell shell = bot.shell("Delete forever");
//		bot.button("Yes").click();
//		bot.waitUntil(Conditions.shellCloses(shell));
//		try {
//			bot.cTabItem("Cheat Sheets").close();
//		} catch (WidgetNotFoundException e) {
//			System.out.println("Haven't found Cheat Sheets");
//		}
//	}
//	

}
