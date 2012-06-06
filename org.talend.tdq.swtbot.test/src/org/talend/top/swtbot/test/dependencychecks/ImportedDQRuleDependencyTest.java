package org.talend.top.swtbot.test.dependencychecks;

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
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;

public class ImportedDQRuleDependencyTest extends TalendSwtbotForTdq{
	
	@Test
	public void importedDQRuleDependency(){
		 bot.waitUntil(Conditions.widgetIsEnabled(bot.toolbarButtonWithTooltip("import items")), 10000);
		 bot.toolbarButtonWithTooltip("import items").click();
		 bot.waitUntil(Conditions.shellIsActive("Import Item"));
		 bot.radio("Select archive file:").click();
		 bot.text(1).setText("F:\\B.zip");
		 
		 try {
			 SWTBotShell  shell = bot.shell("Progress Information");
			bot.waitUntil(Conditions.shellCloses(shell),180000);
		} catch (Exception e1) {
		
		}
		
		SWTBotTree tree = new SWTBotTree(bot.widget(WidgetOfType.widgetOfType(Tree.class)));
		tree.getTreeItem("TDQ_Libraries").getNode(0).uncheck();
		tree.getTreeItem("TDQ_Libraries").getNode(1).uncheck();
	//	bot.checkBox(mnemonicText)
		 bot.button("Finish").click();
		 try {
			 SWTBotShell  shell = bot.shell("Progress Information");
			bot.waitUntil(Conditions.shellCloses(shell),180000);
		} catch (Exception e1) {
		
		}
		
//		 try {
//			 SWTBotShell shell = bot.shell("Import Item");
//			bot.waitUntil(Conditions.shellCloses(shell));
//		} catch (Exception e) {
//		
//		}
		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.LIBRARY_DQRULE, "RuleUnDependency");
		
		
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries", "Rules", "SQL").select("RuleDependency 0.1");
		ContextMenuHelper.clickContextMenu(tree, "Delete");
		
		try {
			SWTBotShell shell = bot.shell("refresh");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		
		}
		bot.viewByTitle("DQ Repository").setFocus();
		
		
		Assert.assertNotNull(tree.expandNode("Recycle Bin").select("RuleDependency"));
		tree.expandNode("Recycle Bin").select("RuleDependency");
		ContextMenuHelper.clickContextMenu(tree, "Delete");
		bot.waitUntil(Conditions.shellIsActive("Confirm Resource Delete"));
		Assert.assertNotNull(bot.shell("Confirm Resource Delete"));
		bot.button("OK");
		SWTBotShell shell =bot.shell("Confirm Resource Delete");
		shell.close();

		
		try {
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		}
		
		
		
		
		tree.expandNode("Recycle Bin").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree, "Restore");
		try {
			shell = bot.shell("refresh");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		}
		
		
		
	}
//	@After
//	public void afterClass(){
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS, "dqrule");
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.LIBRARY_DQRULE, "RuleDependency");
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA, "mysql");
//		
//		
//		
//	}
	

}
