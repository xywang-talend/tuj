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
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportDBType;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportTemplate;

public class HistorizeAnalysisWhenModeIndicatorIsUsedTes extends TalendSwtbotForTdq{
	
	public final String REPORTLABEL="report";
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.MySQL);
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		
		
	}
	@Test
	public void historizeAnalysisWhenModeIndicatorIsUsed(){
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree(bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Indicators").select("User Defined Indicators");
		ContextMenuHelper.clickContextMenu(tree, "Import Indicators");
		bot.waitUntil(Conditions.shellIsActive("Import Indicators"));
		bot.textWithLabel("Select File :").setText("F:\\mode_udi.csv");
		bot.sleep(30000);
		bot.button("Finish").click();
		bot.sleep(30000);
		bot.waitUntil(Conditions.shellIsActive("Information"));
		SWTBotShell shell = bot.shell("Information");
		bot.button("OK");
		bot.waitUntil(Conditions.shellCloses(shell), 30000);
		bot.sleep(10000);
		TalendSwtbotTdqCommon.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").show();
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		tree= new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		bot.table().getTableItem("address1(varchar)").check();
		bot.button("OK").click();
		formBot.ccomboBox(2).setSelection("Nominal");
		bot.toolbarButtonWithTooltip("Save").click();
		formBot.hyperlink("Select indicators for each column").click();
		bot.waitUntil(Conditions.shellIsActive("Indicator Selection"));
		tree = new SWTBotTree(bot.widget(WidgetOfType.widgetOfType(Tree.class)));
		tree.getTreeItem("").click(1);
		bot.checkBox().click();
		bot.button("OK").click();
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (TimeoutException e) {
		}
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createReport(bot, REPORTLABEL);
		TalendSwtbotTdqCommon.generateReport(bot, formBot, REPORTLABEL,
				TalendReportTemplate.Evolution,
				TalendAnalysisTypeEnum.COLUMN.toString());
		
	}
	@After
	public void afterClass(){
		
	}

}
