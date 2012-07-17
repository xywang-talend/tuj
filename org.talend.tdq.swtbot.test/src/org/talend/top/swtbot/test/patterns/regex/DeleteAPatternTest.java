package org.talend.top.swtbot.test.patterns.regex;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.Assert;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;

public class DeleteAPatternTest extends TalendSwtbotForTdq{
	@Test
	public void deleteAPattern(){
		
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Patterns","Regex","address").getNode(3).select();
		ContextMenuHelper.clickContextMenu(tree, "Delete");
		try {
			SWTBotShell shell = bot.shell("refresh");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		
		}
		Assert.assertNotNull(tree.expandNode("Recycle Bin").select("FR Code postal"));
		tree.expandNode("Recycle Bin").select("FR Code postal");
		ContextMenuHelper.clickContextMenu(tree, "Delete");
		bot.waitUntil(Conditions.shellIsActive("Delete forever"));
		SWTBotShell shell = bot.shell("Delete forever");
		bot.button("Yes").click();
		bot.waitUntil(Conditions.shellCloses(shell));
	
		
	}


}
