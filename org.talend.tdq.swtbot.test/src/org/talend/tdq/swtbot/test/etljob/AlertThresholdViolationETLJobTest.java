package org.talend.tdq.swtbot.test.etljob;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTableItem;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.JobHelper;
import org.talend.swtbot.test.commons.SWTBotUtils;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportDBType;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportTemplate;

public class AlertThresholdViolationETLJobTest extends TalendSwtbotForTdq{
	
	private final String REPORTLABEL = "launch_report_ETLJob";

	@Before
	
		public void beforeClass(){
			TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.MySQL);
			TalendSwtbotTdqCommon.createConnection(bot,
					TalendMetadataTypeEnum.MYSQL);
			bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
			TalendSwtbotTdqCommon
					.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);
			
		}
	
	
	@Test
	public void AlertThresholdViolationETLJob(){
		String column = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "address1")[0];
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
		.show();
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		SWTBotShell shell = bot.shell("Column Selection");
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		bot.table().getTableItem(column).check();
		bot.button("OK").click();
		bot.waitUntil(Conditions.shellCloses(shell));
//		formBot.ccomboBox(2).setSelection("Nominal");
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
		TalendSwtbotTdqCommon.generateReport(bot, formBot, REPORTLABEL, 
				TalendReportTemplate.Basic, TalendAnalysisTypeEnum.COLUMN.toString());
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		SWTBotTreeItem item = tree.expandNode("Data Profiling").getNode(1).expand().getNode(0).select();
		SWTBotUtils.clickContextMenu(item, "Alert threshold violation (MySQL)");
	
			bot.waitUntil(Conditions.shellIsActive("Propagate"),180000);
			bot.shell("Propagate").activate();
			bot.button("Yes").click();
		
		
    	bot.cTabItem("Repository").setFocus();
		tree= new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),bot.viewByTitle("Repository").getWidget()));
		String jobname = tree.expandNode("Job Designs").getNode(0).getText();
		System.out.println(jobname);
		 SWTBotGefEditor jobEditor=gefBot.gefEditor("Job "+jobname);
		 SWTBotGefEditPart tSendMail1 = getTalendComponentPart(jobEditor, "tSendMail_1");
		 tSendMail1.click();
	        gefBot.viewByTitle("Component").setFocus();
	        SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
	        gefBot.text(0).selectAll().typeText("\""+System.getProperty("sendMail.to")+"\"",0);
	        gefBot.text(1).selectAll().typeText(" \""+System.getProperty("sendMail.from")+"\"",0);
	        gefBot.text(7).selectAll().typeText("\""+System.getProperty("sendMail.name")+"\"",0);
	        gefBot.text(8).selectAll().typeText("\""+System.getProperty("sendMail.password")+"\"",0);
	        gefBot.text(5).selectAll().typeText("\""+System.getProperty("sendMail.SMTPhost")+"\"",1);
		 JobHelper.runJob(6000);
	    String result = JobHelper.execResultFilter(JobHelper.getExecutionResult());
	    if(result != null &&  !"".equals(result))
	        	Assert.fail("this job can't run correctly"+result+"**********");
	  
		
	}
	
	@After
	public void afterClass(){
		  JobHelper.deletleJob();
			bot.menu("Window").menu("Perspective").menu("Profiler").click();
			bot.sleep(2000);
		
	}
}
