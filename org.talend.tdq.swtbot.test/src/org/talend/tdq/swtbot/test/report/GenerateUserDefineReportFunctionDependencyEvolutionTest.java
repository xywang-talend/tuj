package org.talend.tdq.swtbot.test.report;

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
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportDBType;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportTemplate;

public class GenerateUserDefineReportFunctionDependencyEvolutionTest extends TalendSwtbotForTdq{

	private final String REPORTLABEL = "REPORT_Userdefine_functionalDepend_e";
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.MySQL);
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.ImportJRXMLTemplate(bot);
		TalendSwtbotTdqCommon.createAnalysis(bot,
				TalendAnalysisTypeEnum.FUNCTIONAL);
		TalendSwtbotTdqCommon.createReport(bot, REPORTLABEL);
		
	}
	@Test
	public void GenerateUserDefineReportFunctionDependencyEvolution(){
		String address1= TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "address1")[0];
		String address3= TalendSwtbotTdqCommon.getColumns(bot,
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
		bot.table().getTableItem(address1).check();
		bot.button("OK").click();

		formBot.section("Right Columns").setFocus();
		formBot.hyperlink("Dependent columns: Select columns from B set")
				.click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
	//	tree.expandNode("tbi", "Tables").select("customer");
		bot.table().getTableItem(address3).check();
		bot.button("OK").click();

		bot.toolbarButtonWithTooltip("Save").click();
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			SWTBotShell shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell),50000);
		} catch (TimeoutException e) {
		}

		bot.editorByTitle(TalendAnalysisTypeEnum.FUNCTIONAL.toString() + " 0.1")
				.close();

		TalendSwtbotTdqCommon.generateReport(bot, formBot, REPORTLABEL,
				"match","functionalDependencyEvolution", TalendReportTemplate.User_defined,
				TalendAnalysisTypeEnum.FUNCTIONAL.toString());
		
	}
//	@After
//	public void afterClass(){
//		
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.REPORT,
//				REPORTLABEL);
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.FUNCTIONAL.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//	}
}
