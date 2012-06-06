package org.talend.top.swtbot.test.dependencychecks;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.DndUtil;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class DependencyBetweenPatternsAndAnalysesTest extends TalendSwtbotForTdq{
	
	public static  SWTBotTree tree;
	public static SWTBotShell shell;
	
	@Before 
	public void beforeClass(){
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Patterns","SQL").getNode(0).select().expand();
		ContextMenuHelper.clickContextMenu(tree, "New SQL Pattern");
		bot.waitUntil(Conditions.shellIsActive("New SQL Pattern"));
		SWTBotShell shell = bot.shell("New SQL Pattern");
		bot.textWithLabel("Name").setText("newsqlpattern");
		bot.button("&Next >").click();
		bot.textWithLabel("SQL Like expression:").setText("'%@yahoo.%'");
		bot.button("Finish").click();
		try {
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		
		}

		bot.editorByTitle("newsqlpattern 0.1").close();
		TalendSwtbotTdqCommon.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);
		
	}
	
	@Test
	public void dependencyBetweenPatternsAndAnalysesTest(){
		String column = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "customer_id")[0];
		String col1 = column.substring(0, column.indexOf("(")) + " "
		+ column.substring(column.indexOf("("));
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").show();
		formBot.hyperlink("Select columns to analyze").click();
		try {
			bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		} catch (Exception e1) {
			
		}
		SWTBotTree tree= new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		bot.table().getTableItem(column).check();
		bot.button("OK").click();
		formBot.ccomboBox(1).setSelection("Interval");
		bot.toolbarButtonWithTooltip("Save").click();
		formBot.hyperlink("Select indicators for each column").click();
		bot.waitUntil(Conditions.shellIsActive("Indicator Selection"));
		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class)));
		tree.getTreeItem("Advanced Statistics").click();
		bot.checkBox(30).click();
		bot.button("OK").click();
		//target
		formBot.section("Analyzed Columns").setFocus();
		tree = new SWTBotTree((Tree)bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.editorByTitle(
				TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
				.getWidget()));
		System.out.println("((((((("+tree.getAllItems()[0].getText()+"))(address1 (VARCHAR)))))))");
		SWTBotTreeItem targetItem =tree.expandNode(col1).select();
		System.out.println("############3"+tree.expandNode(col1).getNode(0).getText()+"##########");
	    bot.viewByTitle("DQ Repository").setFocus();
	    //source
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		SWTBotView view = bot.viewByTitle("DQ Repository");
		SWTBotTreeItem source = tree.expandNode("Libraries","Patterns","SQL").getNode(0).expand()
		.getNode(2).select();
		DndUtil dndUtil = new DndUtil(view.getWidget().getDisplay());
		dndUtil.dragAndDrop(source, targetItem);
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
			
		}
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").close();
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Patterns","SQL").getNode(0).expand()
		.getNode(2).select();
		ContextMenuHelper.clickContextMenu(tree, "Delete");
		try {
			shell = bot.shell("refresh");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		
		}
		Assert.assertNotNull(tree.expandNode("Recycle Bin").select("newsqlpattern"));
		tree.expandNode("Recycle Bin").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree, "Delete");
		bot.waitUntil(Conditions.shellIsActive("Confirm Resource Delete"));
		Assert.assertNotNull(bot.shell("Confirm Resource Delete"));
		bot.button("OK");
		shell =bot.shell("Confirm Resource Delete");
		shell.close();
		try {
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		}
		tree.expandNode("Recycle Bin").select("newsqlpattern");
		ContextMenuHelper.clickContextMenu(tree, "Restore");
		try {
			shell = bot.shell("refresh");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		}
		
	}
	
//	@After
//	public void afterClass(){
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS, TalendAnalysisTypeEnum.COLUMN.toString());
//		bot.viewByTitle("DQ Repository").setFocus();
//		tree = new SWTBotTree((Tree) bot.widget(
//				WidgetOfType.widgetOfType(Tree.class),
//				bot.viewByTitle("DQ Repository").getWidget()));
//		tree.expandNode("Libraries","Patterns","SQL").getNode(0).expand()
//		.getNode(2).select();
//		ContextMenuHelper.clickContextMenu(tree, "Delete");
//		try {
//			shell = bot.shell("refresh");
//			bot.waitUntil(Conditions.shellCloses(shell));
//		} catch (Exception e) {
//		
//		}
//		Assert.assertNotNull(tree.expandNode("Recycle Bin").select("newsqlpattern"));
//		tree.expandNode("Recycle Bin").select("newsqlpattern");
//		ContextMenuHelper.clickContextMenu(tree, "Delete");
//		try {
//			bot.waitUntil(Conditions.shellIsActive("Delete forever"));
//		
//		shell = bot.shell("Delete forever");
//		bot.button("Yes").click();
//		bot.waitUntil(Conditions.shellCloses(shell));
//		} catch (Exception e) {
//			
//		}
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA, TalendMetadataTypeEnum.MYSQL.toString());
//		
//	}

}
