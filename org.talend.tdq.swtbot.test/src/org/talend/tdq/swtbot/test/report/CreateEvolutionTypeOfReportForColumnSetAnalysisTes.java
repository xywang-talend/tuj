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
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportDBType;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportTemplate;

public class CreateEvolutionTypeOfReportForColumnSetAnalysisTes extends TalendSwtbotForTdq{
	
	private final String REPORTLABEL = "report";

	@Before
	public void beforeClass(){
		bot.menu("Window").menu("Show view...").click();
		bot.waitUntil(Conditions.shellIsActive("Show View"));
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("General").select("Error Log");
		bot.button("OK").click();
		TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.HSQL);
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);
	}
	@Test
	public void createEvolutionTypeOfReportForColumnSetAnalysis(){
		String address1= TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "address1")[0];
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").show();
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		SWTBotShell  shell=bot.shell("Column Selection");
		SWTBotTree tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		bot.table().getTableItem(address1).check();
		bot.button("OK").click();
		bot.waitUntil(Conditions.shellCloses(shell));
		formBot.ccomboBox(1).setSelection("Nominal");
		if(bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").isDirty())
			bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").save();
		formBot.hyperlink("Select indicators for each column").click();
//		bot.waitUntil(Conditions.shellIsActive("Indicator Selection"));
//		shell = bot.shell("Indicator Selection");
		tree = new SWTBotTree(bot.widget(WidgetOfType.widgetOfType(Tree.class)));
		tree.expandNode("Simple Statistics").select("Row Count").click(1);
		bot.checkBox().click();
		bot.button("OK").click();
		if(bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").isDirty())
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").save();
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (TimeoutException e) {
		}
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN+" 0.1").close();
		TalendSwtbotTdqCommon.createReport(bot, REPORTLABEL);
		TalendSwtbotTdqCommon.generateReport(bot, formBot, REPORTLABEL, TalendReportTemplate.Evolution, TalendAnalysisTypeEnum.COLUMN.toString());
		
	}
//	@After
//	public void afterClass(){
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.REPORT, REPORTLABEL);
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS, TalendAnalysisTypeEnum.COLUMN.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA, TalendMetadataTypeEnum.MYSQL.toString());
//		
//		
//	}

}
