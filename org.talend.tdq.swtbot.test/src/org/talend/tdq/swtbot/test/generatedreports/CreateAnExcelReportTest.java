package org.talend.tdq.swtbot.test.generatedreports;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.forms.finder.finders.SWTFormsBot;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
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

public class CreateAnExcelReportTest extends TalendSwtbotForTdq{
	private final String REPORTLABEL = "generate_report_excel";
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.MySQL);
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createAnalysis(bot, TalendAnalysisTypeEnum.CONNECTION, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendAnalysisTypeEnum.CONNECTION.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createAnalysis(bot, TalendAnalysisTypeEnum.CATALOG, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendAnalysisTypeEnum.CATALOG.toString()+" 0.1").close();
	}
	@Test
	public void createAnExcelReport(){
		TalendSwtbotTdqCommon.createReport(bot, REPORTLABEL);
		generateReport(bot,formBot,REPORTLABEL,TalendReportTemplate.Basic,TalendAnalysisTypeEnum.CONNECTION.toString(),TalendAnalysisTypeEnum.CATALOG.toString());
		
		
	}
//	@After
//	public void afterClass(){
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.REPORT, REPORTLABEL);
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS, TalendAnalysisTypeEnum.CONNECTION.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS, TalendAnalysisTypeEnum.CATALOG.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA, TalendMetadataTypeEnum.MYSQL.toString());
//		
//	}
	
	public static void generateReport(SWTWorkbenchBot bot, SWTFormsBot formBot,
			String label, TalendReportTemplate template, String... analyses) {
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Data Profiling").getNode(1).expand()
				.select(label + " 0.1");
		ContextMenuHelper.clickContextMenu(tree, "Open Report");
		formBot.hyperlink("Select analyses").click();
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));

		for (int i = 0; i < analyses.length; i++) {
			tree.expandNode(analyses[i] + " 0.1").check();
		}
		bot.button("OK").click();
		int i = 0;
		for (i = 1; i <= analyses.length; i++) {
			if (template == TalendReportTemplate.User_defined) {
				String tmp = template.toString().replace("_", " ");
				formBot.ccomboBox(i).setSelection(tmp);

				/**
			 * 
			 */
			} else {
				formBot.ccomboBox(i).setSelection(template.toString());
			}
		}
		i = i + 1;

		formBot.section("Generated Report Settings").setFocus();
		formBot.textWithLabel("Output Folder").setText(
				System.getProperty("tdq.analysis.result.screenshot.path"));
		formBot.textWithLabel("Output FileName").setText(label+"aa");
		formBot.ccomboBoxWithLabel("File Type").setSelection("xls");
		bot.toolbarButtonWithTooltip("Save").click();
		System.out.println("aaabbbbbccccc");
		try {
			bot.waitUntil(Conditions.shellCloses(bot.shell("refresh")));
		} catch (TimeoutException e) {
		}
		bot.toolbarButtonWithTooltip("Generate Report File").click();
		try {
			bot.waitUntil(
					Conditions.shellCloses(bot.shell("Generate Report File")),
					30000);
		//	bot.waitUntil(Conditions.shellCloses(bot.shell("refresh")), 10000);
		} catch (TimeoutException e) {
		}
		bot.sleep(20000);
		bot.editorByTitle(label + " 0.1").close();
		

	}

}
