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
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportDBType;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportTemplate;

@RunWith(SWTBotJunit4ClassRunner.class)

public class BasicTypeReportForRedundancyAnalysisOnORACLETest extends TalendSwtbotForTdq{
	private final String REPORTLABEL = "report_basic_oracle";
	@Before
	public void beforeRunning() {
		TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.Oracle_with_SID);
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createAnalysis(bot,
				TalendAnalysisTypeEnum.REDUNDANCY);
		
	}

	@Test
	public void basicTypeReportForRedundancyAnalysisOnORACLE() {
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
		TalendSwtbotTdqCommon.generateReport(bot, formBot, REPORTLABEL, TalendReportTemplate.Basic, 
				TalendAnalysisTypeEnum.REDUNDANCY.toString());
	}

//	@After
//	public void cleanSource() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.REPORT,
//				REPORTLABEL);
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.REDUNDANCY.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//	}

}
