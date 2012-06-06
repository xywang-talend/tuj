package org.talend.top.swtbot.test.analysis.tableanalysis;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class CreateColumnAnalysisFormTableAnalysisTest extends
		TalendSwtbotForTdq {

	private final String DQRULENAME = "dqrule1";

	private final String RULEEXPRESSION = "customer_id>500";

	@Before
	public void beforeClass() {
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon
				.createAnalysis(bot, TalendAnalysisTypeEnum.DQRULE);
		TalendSwtbotTdqCommon.createDQRule(bot, DQRULENAME, RULEEXPRESSION);

	}

	@Test
	public void createColumnAnalysisFormTableAnalysis() {
		bot.editorByTitle(TalendAnalysisTypeEnum.DQRULE.toString() + " 0.1")
				.show();
		formBot.hyperlink("Select tables/views to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Table/view Selection"));
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("DB connections",
				TalendMetadataTypeEnum.MYSQL.toString(), "tbi").getNode(0)
				.select();
		bot.table().getTableItem("customer").check();
		bot.button("OK").click();
		bot.editorByTitle(TalendAnalysisTypeEnum.DQRULE.toString() + " 0.1")
				.setFocus();
		formBot.section("Analyzed Tables and views").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.editorByTitle(
						TalendAnalysisTypeEnum.DQRULE.toString() + " 0.1")
						.getWidget()));
		tree.getTreeItem("customer").doubleClick();
		try {
			bot.waitUntil(Conditions.shellIsActive("DQ Rule Selector"));
		} catch (TimeoutException e) {
		}
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Rules", "SQL").getNode(DQRULENAME).check();
		bot.button("OK").click();
		bot.editorByTitle(TalendAnalysisTypeEnum.DQRULE.toString() + " 0.1")
				.save();
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			SWTBotShell shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		}
		tree = new SWTBotTree(bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.editorByTitle(
						TalendAnalysisTypeEnum.DQRULE.toString() + " 0.1")
						.getWidget()));
		tree.expandNode("customer").select();
		ContextMenuHelper.clickContextMenu(tree, "Column analysis");
		bot.textWithLabel("Name").setText("column");
		bot.button("Finish").click();
		bot.editorByTitle("column 0.1").show();
		
		String column = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "address1")[0];
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		bot.table().getTableItem(column).check();
		bot.button("OK").click();
		formBot.ccomboBox(1).setSelection("Nominal");
		bot.toolbarButtonWithTooltip("Save").click();
		formBot.hyperlink("Select indicators for each column").click();
		bot.waitUntil(Conditions.shellIsActive("Indicator Selection"));

		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.getTreeItem("Simple Statistics").click(1);
		bot.checkBox().click();
		bot.button("OK").click();
		
		
		
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			SWTBotShell shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		}
		bot.cTabItem("Analysis Results").activate();
		bot.sleep(2000);
		bot.captureScreenshot(System
				.getProperty("tdq.analysis.result.screenshot.path")
				+ "dqrule_column.jpeg");
		bot.editorByTitle("column 0.1").close();
		bot.editorByTitle(TalendAnalysisTypeEnum.DQRULE.toString()+" 0.1").close();

	}

//	@After
//	public void afterClass() {
//
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				"column");
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.DQRULE.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot,
//				TalendItemTypeEnum.LIBRARY_DQRULE, DQRULENAME);
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//
//	}
}
