package org.talend.top.swtbot.test.userdefinedindicator;

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
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.DndUtil;

public class RemoveUDIFromAColumnTest extends TalendSwtbotForTdq{
	
	public static  SWTBotTree tree;
	public static SWTBotShell shell;
	
	@Before 
	public void beforeClass(){
		bot.sleep(10000);
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Indicators").getNode(1).select();
		ContextMenuHelper.clickContextMenu(tree, "New Indicator");
		bot.waitUntil(Conditions.shellIsActive("New Indicator"));
		SWTBotShell shell = bot.shell("New Indicator");
		bot.textWithLabel("Name").setText("newAUserDefinedIndicator");
		bot.button("&Next >").click();
		bot.textWithLabel("SQL Template:").setText("SELECT COUNT(*) FROM <%=__TABLE_NAME__%> <%=__WHERE_CLAUSE__%>");
		bot.button("Finish").click();
		try {
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		
		}
		formBot.ccomboBox(1).setSelection("MySQL");
		bot.toolbarButtonWithTooltip("Save").click();
		bot.editorByTitle("newAUserDefinedIndicator 0.1").close();
		TalendSwtbotTdqCommon.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);
		
	}
	
	@Test
	public void removeUDIFromAColumn(){
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
		formBot.section("Analyzed Columns").setFocus();
		tree = new SWTBotTree((Tree)bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.editorByTitle(
				TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
				.getWidget()));
		System.out.println("((((((("+tree.getAllItems()[0].getText()+"))))))))");
		SWTBotTreeItem targetItem =tree.expandNode(col1).select();
		System.out.println("############3"+tree.expandNode(col1).getNode(0).getText()+"##########");
	    bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		SWTBotView view = bot.viewByTitle("DQ Repository");
		SWTBotTreeItem source = tree.expandNode("Libraries","Indicators").getNode(1).expand()
		.getNode(0).select();
		DndUtil dndUtil = new DndUtil(view.getWidget().getDisplay());
		dndUtil.dragAndDrop(source, targetItem);
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
			
		}
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").close();
		
	}
	
//	@After
//	public void afterClass(){
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS, TalendAnalysisTypeEnum.COLUMN.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.LIBRARY_UDI, "newAUserDefinedIndicator");
////		bot.viewByTitle("DQ Repository").setFocus();
////		tree = new SWTBotTree((Tree) bot.widget(
////				WidgetOfType.widgetOfType(Tree.class),
////				bot.viewByTitle("DQ Repository").getWidget()));
////		tree.expandNode("Libraries","Indicators").getNode(1).expand().select("newAUserDefinedIndicator 0.1");
////		ContextMenuHelper.clickContextMenu(tree, "Delete");
////		try {
////			shell = bot.shell("refresh");
////			bot.waitUntil(Conditions.shellCloses(shell));
////		} catch (Exception e) {
////		
////		}
////		Assert.assertNotNull(tree.expandNode("Recycle Bin").select("newAUserDefinedIndicator"));
////		tree.expandNode("Recycle Bin").select("newAUserDefinedIndicator");
////		ContextMenuHelper.clickContextMenu(tree, "Delete");
////		try {
////			bot.waitUntil(Conditions.shellIsActive("Delete forever"));
////		} catch (Exception e) {
////			
////		}
////		shell = bot.shell("Delete forever");
////		bot.button("Yes").click();
////		try {
////			bot.waitUntil(Conditions.shellCloses(shell));
////		} catch (Exception e) {
////		}
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA, TalendMetadataTypeEnum.MYSQL.toString());
//		
//	}

}
