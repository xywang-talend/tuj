package org.talend.tdq.swtbot.test.report;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
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

public class PreviewLatestGeneratedReportTest extends TalendSwtbotForTdq{
	private final String REPORTLABEL = "report_previewLatest";
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.MySQL);
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createAnalysis(bot, TalendAnalysisTypeEnum.CONNECTION, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendAnalysisTypeEnum.CONNECTION.toString()+" 0.1").close();
		
	}
	@Test
	public void previewLatestGeneratedReport(){
		TalendSwtbotTdqCommon.createReport(bot, REPORTLABEL);
		TalendSwtbotTdqCommon.generateReport(bot, formBot, REPORTLABEL, TalendReportTemplate.Basic, 
				TalendAnalysisTypeEnum.CONNECTION.toString());
		bot.sleep(20000);
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Data Profiling").getNode(1).expand()
				.select(REPORTLABEL + " 0.1");
		ContextMenuHelper.clickContextMenu(tree, "Open Report");
		bot.editorByTitle(REPORTLABEL + " 0.1").show();
		bot.toolbarButtonWithTooltip("Preview").click();
		bot.sleep(10000);
		bot.captureScreenshot(System
				.getProperty("tdq.analysis.result.screenshot.path")
				+ "report_Preview_Latest.jpeg");
		bot.editorByTitle(REPORTLABEL+" 0.1").close();
		
	}
//	@After
//	public void afterClass(){
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.REPORT,
//				REPORTLABEL);
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.CONNECTION.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//		
//	}

}
