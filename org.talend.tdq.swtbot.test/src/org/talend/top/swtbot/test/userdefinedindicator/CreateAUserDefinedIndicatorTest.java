package org.talend.top.swtbot.test.userdefinedindicator;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.Assert;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;

public class CreateAUserDefinedIndicatorTest extends TalendSwtbotForTdq{
	
	@Test
	public void createAUserDefinedIndicator(){
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Indicators").getNode(1).select();
		ContextMenuHelper.clickContextMenu(tree, "New Indicator");
		bot.waitUntil(Conditions.shellIsActive("New Indicator"));
		SWTBotShell shell = bot.shell("New Indicator");
		bot.textWithLabel("Name").setText("newAUserDefinedIndicator");
		bot.button("&Next >").click();
		bot.textWithLabel("SQL Template:").setText("select * from customer");
		bot.button("Finish").click();
		try {
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		
		}
		formBot.ccomboBox(1).setSelection("MySQL");
		bot.toolbarButtonWithTooltip("Save").click();
		bot.editorByTitle("newAUserDefinedIndicator 0.1").close();

		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Indicators").getNode(1).expand()
		.getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree, "Open");
		bot.sleep(2000);
		bot.captureScreenshot(System
				.getProperty("tdq.analysis.result.screenshot.path")
				+ "indicator_description_modify.jpeg");		
		bot.editorByTitle("User Defined Indicators/newAUserDefinedIndicator").close();
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Indicators").getNode(1).expand()
		.getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree, "Delete");
		try {
			shell = bot.shell("Refresh");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		
		}
		Assert.assertNotNull(tree.expandNode("Recycle Bin").select("newAUserDefinedIndicator"));
		tree.expandNode("Recycle Bin").select("newAUserDefinedIndicator");
		ContextMenuHelper.clickContextMenu(tree, "Delete");
		bot.waitUntil(Conditions.shellIsActive("Delete forever"));
		shell = bot.shell("Delete forever");
		bot.button("Yes").click();
		bot.waitUntil(Conditions.shellCloses(shell));
		
	}
		
		
		
		
		
	}
