package org.talend.top.swtbot.test.systemindicators;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.Assert;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;

public class EditAsystemIndicatorTest extends TalendSwtbotForTdq{

	@Test
	public void editAsystemIndicator (){
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Indicators","System Indicators","Simple Statistics")
		.getNode(3).select();
		ContextMenuHelper.clickContextMenu(tree, "Open");
		String beforeModify = formBot.textWithLabel("Description:").getText();
		formBot.textWithLabel("Description:").setText("counts the number of distinct rows");
		bot.toolbarButtonWithTooltip("Save").click();
		bot.editorByTitle("Distinct Count 0.1").close();
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Indicators","System Indicators","Simple Statistics")
		.getNode(3).select();
		ContextMenuHelper.clickContextMenu(tree, "Open");
		String Aftermodify = formBot.textWithLabel("Description:").getText();
		Assert.assertNotSame(beforeModify,Aftermodify);
		bot.sleep(2000);
		bot.captureScreenshot(System
				.getProperty("tdq.analysis.result.screenshot.path")
				+ "indicator_description_modify.jpeg");		
		bot.editorByTitle("System Indicators/Simple Statistics/Distinct Count").close();
		
		
		
		
	}


}
