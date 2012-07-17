package org.talend.top.swtbot.test.patterns.regex;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTableItem;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.DndUtil;
import org.talend.swtbot.test.commons.SWTBotTableItemExt;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class DatePatternIndicatorGenerateRegularPatternMenuTest extends TalendSwtbotForTdq{
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon
				.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);
	}
	@Test
	public void DatePatternIndicatorGenerateRegularPatternMenu(){
		String column = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "birthdate")[0];
		String col1 = column.substring(0, column.indexOf("(")) + " "
		+ column.substring(column.indexOf("("));
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
				.show();
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		bot.table().getTableItem(column).check();
		bot.button("OK").click();
		formBot.ccomboBox(1).setSelection("Nominal");
		formBot.ccomboBox(2).setSelection("Java");
		formBot.hyperlink("Select indicators for each column").click();
		bot.waitUntil(Conditions.shellIsActive("Indicator Selection"));

		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Pattern Frequency Statistics").select("Date Pattern Frequency Table")
		.click();
		bot.checkBox(49).click();
		bot.button("OK").click();
		bot.toolbarButtonWithTooltip("Save").click();
		bot.toolbarButtonWithTooltip("Run").click();

		try {
			SWTBotShell shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (TimeoutException e) {
		}
		bot.cTabItem("Analysis Results").activate();
		formBot.section("Analysis Results").setFocus();
		formBot.expandableComposite("Column:customer.birthdate").setFocus();
		formBot.expandableComposite("Date Pattern Frequency Statistics").setFocus();

		SWTBotTableItem tableItem = bot.tableWithLabel("Date Pattern Frequency Statistics").getTableItem("yyyy dd MM");
		new SWTBotTableItemExt(tableItem).contextMenu("Generate Regular Pattern").click();
		//tableItem.contextMenu("Generate Regular Pattern").click();
		bot.waitUntil(Conditions.shellIsActive("New Regular Pattern"));
		bot.textWithLabel("Name").setText("toto");
		bot.button("Next >").click();
		bot.button("Finish").click();
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
		.show();
		bot.cTabItem("Analysis Settings").activate();
//		formBot.section("Analysis Results").setFocus();
		
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
		SWTBotTreeItem source = tree.expandNode("Libraries","Indicators").getNode(0).expand()
		.getNode("toto 0.1").select();
		DndUtil dndUtil = new DndUtil(view.getWidget().getDisplay());
		dndUtil.dragAndDrop(source, targetItem);
		bot.toolbarButtonWithTooltip("Run").click();
		
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").close();
		
	}

}
