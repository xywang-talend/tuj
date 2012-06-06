package org.talend.tdq.swtbot.test.reportwithoracle;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportDBType;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportTemplate;
@RunWith(SWTBotJunit4ClassRunner.class)
public class BasicTypeReportForFunctionalDependencyAnalysisOnORACLETest extends TalendSwtbotForTdq{
	private final String REPORTLABEL = "functional_analysis_basic_report";

	@Before
	public void beforeClass() {
		TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.Oracle_with_SID);
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createAnalysis(bot,
				TalendAnalysisTypeEnum.FUNCTIONAL);
		TalendSwtbotTdqCommon.createReport(bot, REPORTLABEL);
	}

	@Test
	public void reportForFunctionalDependencyAnalysis() {
		String column = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "address1")[0];
		String column2 = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "address3")[0];
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Data Profiling").getNode(0).expand()
				.select(TalendAnalysisTypeEnum.FUNCTIONAL.toString() + " 0.1");
		ContextMenuHelper.clickContextMenu(tree, "Open");
		bot.editorByTitle(TalendAnalysisTypeEnum.FUNCTIONAL.toString() + " 0.1")
				.setFocus();

		formBot.section("Left Columns").setFocus();
		formBot.hyperlink("Determinant columns: Select columns from A set")
				.click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		bot.table().getTableItem(column).check();
		bot.button("OK").click();

		formBot.section("Right Columns").setFocus();
		formBot.hyperlink("Dependent columns: Select columns from B set")
				.click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		bot.table().getTableItem(column2).check();
		bot.button("OK").click();

		bot.toolbarButtonWithTooltip("Save").click();
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			SWTBotShell shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
			bot.sleep(20000);
		}
		

		bot.editorByTitle(TalendAnalysisTypeEnum.FUNCTIONAL.toString() + " 0.1")
				.close();

		TalendSwtbotTdqCommon.generateReport(bot, formBot, REPORTLABEL,
				TalendReportTemplate.Basic,
				TalendAnalysisTypeEnum.FUNCTIONAL.toString());
	}

//	@After
//	public void cleanSource() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.REPORT,
//				REPORTLABEL);
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.FUNCTIONAL.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//	}


}
