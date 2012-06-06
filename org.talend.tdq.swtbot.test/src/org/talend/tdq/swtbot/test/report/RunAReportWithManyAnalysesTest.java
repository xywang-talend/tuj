package org.talend.tdq.swtbot.test.report;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportDBType;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportTemplate;

public class RunAReportWithManyAnalysesTest extends TalendSwtbotForTdq{
	private final String REPORTLABEL = "report_manyAnalyses";
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.MySQL);
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);
		TalendSwtbotTdqCommon.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMNSET);
	}
	@Test
	public void runAReportWithManyAnalyses(){
		String birthdate= TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "birthdate")[0];
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1").show();
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		bot.table().getTableItem(birthdate).check();
		bot.button("OK").click();
		formBot.ccomboBox(1).setSelection("Interval");
		bot.toolbarButtonWithTooltip("Save").click();
		formBot.hyperlink("Select indicators for each column").click();
		bot.waitUntil(Conditions.shellIsActive("Indicator Selection"));

		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Advanced Statistics").select("Frequency Table")
			.click();
		bot.checkBox(33).click();
		bot.button("OK").click();
		bot.toolbarButtonWithTooltip("Run").click();
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").close();
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMNSET.toString() + " 0.1").show();
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		bot.table().getTableItem(birthdate).check();
		bot.button("OK").click();
		formBot.ccomboBox(1).setSelection("Nominal");
		bot.toolbarButtonWithTooltip("Save").click();
		bot.toolbarButtonWithTooltip("Run").click();
//		try {
//			SWTBotShell shell = bot.shell("Run Analysis");
//			bot.waitUntil(Conditions.shellCloses(shell),50000);
//		} catch (TimeoutException e) {
//		}
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMNSET.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createReport(bot, REPORTLABEL);
		TalendSwtbotTdqCommon.generateReport(bot, formBot, REPORTLABEL, 
				TalendReportTemplate.Basic, TalendAnalysisTypeEnum.COLUMN.toString(),TalendAnalysisTypeEnum.COLUMNSET.toString());
		
		
		}
//	@After
//	public void afterClass(){
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.REPORT,
//				REPORTLABEL);
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.COLUMN.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.COLUMNSET.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//		
//	}

}
