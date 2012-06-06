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
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportDBType;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportTemplate;

public class GenerateUserDefineReportMatchEvolutionMysqlTest extends TalendSwtbotForTdq{
	
	private final String REPORTLABEL = "REPORT_Userdefine_match_e_mysql";
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.MySQL);
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.ImportJRXMLTemplate(bot);
		TalendSwtbotTdqCommon.createAnalysis(bot,
				TalendAnalysisTypeEnum.REDUNDANCY);
	}
	@Test
	public void GenerateUserDefineReportMatchEvolutionMysql(){
		String column = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "address1")[0];
		String fname = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "fname")[0];
		bot.editorByTitle(TalendAnalysisTypeEnum.REDUNDANCY.toString() + " 0.1")
				.show();
		formBot.hyperlink("Select columns for A Set").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		bot.table().getTableItem(column).check();
		
		bot.button("OK").click();

		formBot.hyperlink("Select columns for B Set").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		bot.table().getTableItem(fname).check();
		bot.button("OK").click();
		if (bot.editorByTitle(
				TalendAnalysisTypeEnum.REDUNDANCY.toString() + " 0.1")
				.isDirty())
			bot.editorByTitle(
					TalendAnalysisTypeEnum.REDUNDANCY.toString() + " 0.1")
					.save();
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			bot.waitUntil(Conditions.shellIsActive("Confirm your operation"));
		} catch (Exception e1) {
			bot.shell("Confirm your operation").close();
			
		}
		bot.button("OK").click();
		try {
			SWTBotShell shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell), 60000);
		} catch (TimeoutException e) {
		}
		bot.editorByTitle(TalendAnalysisTypeEnum.REDUNDANCY.toString() + " 0.1")
				.close();
		TalendSwtbotTdqCommon.createReport(bot, REPORTLABEL);
		TalendSwtbotTdqCommon.generateReport(bot, formBot, REPORTLABEL,
				"match","b06_match_evolution", TalendReportTemplate.User_defined, TalendAnalysisTypeEnum.REDUNDANCY.toString());
		
	}
//	@After
//	public void afterClass(){
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.REPORT,
//				REPORTLABEL);
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.REDUNDANCY.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//		
//	}

}
