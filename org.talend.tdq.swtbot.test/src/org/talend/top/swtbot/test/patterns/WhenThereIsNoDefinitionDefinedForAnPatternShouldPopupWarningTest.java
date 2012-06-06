package org.talend.top.swtbot.test.patterns;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotCCombo;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.DndUtil;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class WhenThereIsNoDefinitionDefinedForAnPatternShouldPopupWarningTest extends TalendSwtbotForTdq{
	
	@Before
	public void beforeClass(){
		bot.sleep(10000);
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		bot.sleep(1000);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Patterns","Regex").getNode(3).expand().getNode(3).select();
		ContextMenuHelper.clickContextMenu(tree, "Open");
		bot.editorByTitle("Gender 0.1").setFocus();
		formBot.ccomboBox(1).setSelection("MySQL");
		bot.editorByTitle("Gender 0.1").setFocus();
		bot.toolbarButtonWithTooltip("Save").click();
		try {
			SWTBotShell shell = bot.shell("refresh");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
			
		}
		bot.editorByTitle("Gender 0.1").close();
		
		
	}
	@Test
	public void whenThereIsNoDefinitionDefinedForAnPatternShouldPopupWarning(){
		String column = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "customer_id")[0];
		String col1 = column.substring(0, column.indexOf("(")) + " "
		+ column.substring(column.indexOf("("));
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").show();
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		SWTBotTree tree= new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		bot.table().getTableItem(column).check();
		bot.button("OK").click();
		formBot.ccomboBox(1).setSelection("Interval");
		bot.toolbarButtonWithTooltip("Save").click();
		formBot.hyperlink("Select indicators for each column").click();
		bot.waitUntil(Conditions.shellIsActive("Indicator Selection"));
		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class)));
		tree.getTreeItem("Advanced Statistics").click(1);
		bot.checkBox(30).click();
		bot.button("OK").click();
		//target
		formBot.section("Analyzed Columns").setFocus();
		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").getWidget()));
		//System.out.println(tree.getAllItems()[0].getText());
		SWTBotTreeItem targetItem = tree.expandNode(col1).select();
		//source
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		SWTBotView view = bot.viewByTitle("DQ Repository");
		SWTBotTreeItem source = tree.expandNode("Libraries","Patterns","Regex").getNode(3).expand().getNode(3).select();
		DndUtil dndUtil = new DndUtil(view.getWidget().getDisplay());
		dndUtil.dragAndDrop(source, targetItem);
		try {
			bot.waitUntil(Conditions.shellIsActive("Warning"));
			bot.button("No").click();
		} catch (Exception e1) {
		
		}
		try {
			SWTBotShell shell = bot.shell("Warning");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
			
		}
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Patterns","Regex").getNode(3).expand().getNode(3).select();
		ContextMenuHelper.clickContextMenu(tree, "Open");
	//	formBot.ccomboBox(1).setSelection("Default ");
		SWTBotCCombo cCombo = formBot.ccomboBox(1);
		cCombo = formBot.ccomboBox(1);
		TalendSwtbotTdqCommon.CComboSelectContainTextItem(cCombo, "Default");
		bot.toolbarButtonWithTooltip("Save").click();
		try {
			SWTBotShell shell = bot.shell("refresh");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
			
		}
		bot.editorByTitle("Gender 0.1").close();
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").show();
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			SWTBotShell shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell),60000);
		} catch (Exception e) {
			
		}
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").close();
	
		
	}
//	@After
//	public void afterClass(){
//		
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,TalendAnalysisTypeEnum.COLUMN.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA, TalendMetadataTypeEnum.MYSQL.toString());
//		
//	}

}
