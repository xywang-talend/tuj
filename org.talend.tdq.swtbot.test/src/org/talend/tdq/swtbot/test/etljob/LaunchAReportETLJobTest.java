package org.talend.tdq.swtbot.test.etljob;

import org.eclipse.swt.widgets.Tree;
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
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportDBType;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportTemplate;

public class LaunchAReportETLJobTest extends TalendSwtbotForTdq{
	
	private final String REPORTLABEL = "launch_report_ETLJob";
	
	@Before 
	public void beforeClass(){
		TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.MySQL);
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);
		
	}
	@Test
	public void launchAReportETLJob(){
		
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
		.show();
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		SWTBotShell shell = bot.shell("Column Selection");
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		bot.table().getTableItem("address1(varchar)").check();
		bot.button("OK").click();
		bot.waitUntil(Conditions.shellCloses(shell));
		formBot.ccomboBox(2).setSelection("Nominal");
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
		try {
			shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (TimeoutException e) {
		}
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createReport(bot, REPORTLABEL);
		TalendSwtbotTdqCommon.generateReport(bot, formBot, REPORTLABEL, 
				TalendReportTemplate.Basic, TalendAnalysisTypeEnum.COLUMN.toString());
		bot.viewByTitle("DQ Repository").setFocus();
		tree =new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class)));
		SWTBotTreeItem item = tree.expandNode("Data Profiling").getNode(1).expand().getNode(0).select();
		SWTBotUtils.clickContextMenu(item, "Launch a report");
		try {
			bot.waitUntil(Conditions.shellIsActive("Confirm"));
			bot.button("No").click();
		} catch (TimeoutException e) {
			
		}
		bot.sleep(10000);
		bot.viewByTitle("Repository").setFocus();
		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("Repository").getWidget()));
		tree.expandNode("Job Designs").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree,"Run job");
		bot.sleep(15000);
    	bot.editorByTitle("Job "+tree.expandNode("Job Designs").getNode(0).getText()).close();
    	System.out.println("Job "+tree.expandNode("Job Designs").getNode(0).getText());
		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("Repository").getWidget()));
		tree.expandNode("Job Designs").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree,"Delete");
		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("Repository").getWidget()));
		tree.expandNode("Recycle bin").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree,"Delete forever");
		try {
		bot.waitUntil(Conditions.shellIsActive("Delete forever"));
		shell = bot.shell("Delete forever");
		bot.button("Yes").click();
		
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		}
		bot.menu("Window").menu("Perspective").menu("Data Profiler").click();
		bot.sleep(2000);
		
	}
		
	
	@After
	public void afterClass(){
		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.REPORT,
				REPORTLABEL);
		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
				TalendAnalysisTypeEnum.COLUMN.toString());
		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
				TalendMetadataTypeEnum.MYSQL.toString());
		
	}
	

}
