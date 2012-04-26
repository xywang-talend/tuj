package org.talend.top.swtbot.test.recyclebin;

import junit.framework.Assert;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;

public class CleanRecycleBinOnTOSPerspectiveTest extends TalendSwtbotForTdq{
	
	@Test
	public void CcleanRecycleBinOnTOSPerspective(){
		bot.sleep(10000);
		try {
			bot.menu("Window").menu("Perspective").menu("Integration").click();
		} catch (WidgetNotFoundException e2) {
			System.out.println("Haven't found Service Builder!");
		}
		try {
			bot.viewByTitle("Repository").setFocus();
		} catch (Exception e2) {
			System.out.println("Haven't found Repository!");
		}
		SWTBotTree tree= new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("Repository").getWidget()));
		tree.expandNode("Metadata").getNode(1).select();
		ContextMenuHelper.clickContextMenu(tree, "Create connection");
		SWTBotShell shell=bot.shell("Database Connection");
		bot.waitUntil(Conditions.shellIsActive("Database Connection"));
		bot.textWithLabel("Name").setText("Mysql");
		bot.button("&Next >").click();
		bot.comboBoxWithLabel("DB Type").setSelection("MySQL");
		bot.textWithLabel("Login").setText("root");
		bot.textWithLabel("Password").setText("root");
		bot.textWithLabel("Server").setText("localhost");
		bot.button("Check").click();
		try {
			bot.waitUntil(Conditions.shellIsActive("Check Connection"));
		} catch (Exception e1) {
			
		}
		bot.button("OK").click();
		bot.button("Finish").click();
		bot.waitUntil(Conditions.shellCloses(shell));
		bot.viewByTitle("Repository").setFocus();
		tree= new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("Repository").getWidget()));
		tree.expandNode("Metadata","Db Connections").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree, "Delete");
		bot.viewByTitle("Repository").setFocus();
		tree= new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("Repository").getWidget()));
		tree.expandNode("Recycle bin").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree, "Delete forever");
		bot.waitUntil(Conditions.shellIsActive("Delete forever"));
		bot.button("Yes").click();
		try {
			shell = bot.shell("Delete forever");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		
		}
		try {
			bot.menu("Window").menu("Perspective").menu("Profiler")
			.click();
		} catch (WidgetNotFoundException e) {
			System.out.println("can't find the menu Profiler");
		}
		bot.viewByTitle("DQ Repository").setFocus();
		tree= new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		SWTBotTreeItem[] arraylist = tree.expandNode("Recycle Bin").getItems();
		Assert.assertEquals(0, arraylist.length);
		
		
	}

}
