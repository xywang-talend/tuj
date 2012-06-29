package org.talend.top.swtbot.test.patterns;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.Assert;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;

public class OpenDuplicateAPatternTest extends TalendSwtbotForTdq{
	

	@Test
	public void openDuplicateAPattern(){
		
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Patterns","Regex","address").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree, "Open");
		bot.editorByTitle("BE_Code_postal 0.1").close();
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Patterns","Regex","address").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree, "Duplicate");
		bot.waitUntil(Conditions.shellIsActive("Input Dialog"));
		SWTBotShell shell = bot.shell("Input Dialog");
		bot.button("OK").click();
		try {
			bot.waitUntil(Conditions.shellCloses(shell));
			shell = bot.shell("refresh");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		
		}
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Patterns","Regex","address").select("Copy_of_BE Code postal 0.1");
		ContextMenuHelper.clickContextMenu(tree, "Delete");
		try {
			shell = bot.shell("refresh");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		
		}
		Assert.assertNotNull(tree.expandNode("Recycle Bin").select("Copy_of_BE_Code_postal"));
		tree.expandNode("Recycle Bin").select("Copy_of_BE_Code_postal");
		ContextMenuHelper.clickContextMenu(tree, "Delete");
		bot.waitUntil(Conditions.shellIsActive("Delete forever"));
		shell = bot.shell("Delete forever");
		bot.button("Yes").click();
		bot.waitUntil(Conditions.shellCloses(shell));
		
		/*
		 * 	bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Indicators").getNode(1).select();
		ContextMenuHelper.clickContextMenu(tree, "New Indicator");
		bot.waitUntil(Conditions.shellIsActive("New Indicator"));
		SWTBotShell shell = bot.shell("New Indicator");
		 */
		
	}


}
