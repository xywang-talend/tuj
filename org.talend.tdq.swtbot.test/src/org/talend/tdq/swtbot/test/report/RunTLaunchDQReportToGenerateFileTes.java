package org.talend.tdq.swtbot.test.report;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.forms.finder.finders.SWTFormsBot;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.SWTBotUtils;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportDBType;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportTemplate;

public class RunTLaunchDQReportToGenerateFileTes extends TalendSwtbotForTdq {

	private final String REPORTLABEL = "rep";

	@Before
	public void beforeClass() {
		TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.MySQL);
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon
				.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);

	}

	@Test
	public void runTLaunchDQReportToGenerateFile() {
		String address1= TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "address1")[0];
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
				.show();
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		SWTBotShell shell = bot.shell("Column Selection");
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		//tree.expandNode("tbi", "T ables").select("customer");
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		bot.table().getTableItem(address1).check();
		bot.button("OK").click();
		bot.waitUntil(Conditions.shellCloses(shell));
		formBot.ccomboBox(1).setSelection("Nominal");
		if (bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
				.isDirty())
			bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
					.save();
		formBot.hyperlink("Select indicators for each column").click();
		bot.waitUntil(Conditions.shellIsActive("Indicator Selection"));
		shell = bot.shell("Indicator Selection");
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Simple Statistics").select("Row Count").click(1);
		bot.checkBox().click();
		bot.button("OK").click();
		if (bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
				.isDirty())
			bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
					.save();
		bot.toolbarButtonWithTooltip("Run").click();
//		try {
//			shell = bot.shell("Run Analysis");
//			bot.waitUntil(Conditions.shellCloses(shell));
//		} catch (TimeoutException e) {
//		}
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createReport(bot, REPORTLABEL);
		generateReport(bot, formBot, REPORTLABEL,
				TalendReportTemplate.Evolution,
				TalendAnalysisTypeEnum.COLUMN.toString());

	}

//	@After
//	public void afterClass() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.REPORT, REPORTLABEL);
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS, TalendAnalysisTypeEnum.COLUMN.toString());
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
		ContextMenuHelper.clickContextMenu(tree, "Open");
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
		System.out.println("aaabbbbb");
		// bot.editorByTitle(label+" 0.1").save();
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
			bot.waitUntil(Conditions.shellCloses(bot.shell("refresh")), 10000);
		} catch (TimeoutException e) {
		}
		bot.editorByTitle(label + " 0.1").close();
		System.out.println("aaafffff");
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		System.out.println(i + "aaa");
		SWTBotTreeItem item=tree.expandNode("Data Profiling").getNode(1).expand()
				.getNode(label + " 0.1").select();
		SWTBotUtils.clickContextMenu(item, "Launch a report");
		System.out.println("aaa");
		bot.waitUntil(Conditions.shellIsActive("Confirm"));
		bot.button("No").click();
		bot.sleep(10000);
		
		bot.viewByTitle("Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("Repository").getWidget()));
		tree.expandNode("Job Designs").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree, "Run job");
		bot.sleep(10000);
	}

}
