package org.talend.tdq.swtbot.test.etljob;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.After;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.SWTBotUtils;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;

public class GetPatternsETLJobTest extends TalendSwtbotForTdq{

	@Test
	public void getPatternsETLJob(){
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree =new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class)));
		SWTBotTreeItem item = tree.expandNode("Libraries").getNode(3).expand().getNode(0).select();
		SWTBotUtils.clickContextMenu(item, "Get Patterns");
		try {
			bot.waitUntil(Conditions.shellIsActive("Confirm"));
			bot.button("No").click();
		} catch (TimeoutException e) {
			
		}
		bot.sleep(10000);
		bot.viewByTitle("Repository").setFocus();
		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("Repository").getWidget()));
		tree.expandNode("Job Designs").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree,"Run job");
		bot.sleep(20000);
    	bot.editorByTitle("Job "+tree.expandNode("Job Designs").getNode(0).getText()).close();
    	System.out.println("Job "+tree.expandNode("Job Designs").getNode(0).getText());
		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("Repository").getWidget()));
		tree.expandNode("Job Designs").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree,"Delete");
		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("Repository").getWidget()));
		tree.expandNode("Recycle bin").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree,"Delete forever");
		bot.waitUntil(Conditions.shellIsActive("Delete forever"));
		SWTBotShell shell = bot.shell("Delete forever");
		bot.button("Yes").click();
		try {
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		}
		bot.menu("Window").menu("Perspective").menu("Data Profiler").click();
		
	}
	@After
	public void afterClass(){
	
		
	}

}
