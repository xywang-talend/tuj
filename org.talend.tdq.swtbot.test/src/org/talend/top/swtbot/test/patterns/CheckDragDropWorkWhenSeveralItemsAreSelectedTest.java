package org.talend.top.swtbot.test.patterns;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.keyboard.Keystrokes;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.DndUtil;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class CheckDragDropWorkWhenSeveralItemsAreSelectedTest extends TalendSwtbotForTdq{
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);
		
	}
	
	@Test
	public void CheckDragDropWorkWhenSeveralItemsAreSelected(){
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
		SWTBotTreeItem targetItem =tree.expandNode(col1).select();
	    bot.viewByTitle("DQ Repository").setFocus();
	    //source
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		SWTBotView view = bot.viewByTitle("DQ Repository");
		SWTBotTreeItem source = tree.expandNode("Libraries","Patterns","Regex").getNode(0).expand();
		SWTBotTreeItem sourceTarget = source.getNode("BE Code postal 0.1");
		source.select("BE Code postal 0.1","FR Code postal 0.1");
		DndUtil dndUtil = new DndUtil(view.getWidget().getDisplay());
		dndUtil.dragAndDrop(sourceTarget, targetItem);
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			SWTBotShell shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
			
		}
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").close();
	
		
		
	}

}
