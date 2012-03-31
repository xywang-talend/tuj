package org.talend.top.swtbot.test.cheatsheets;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
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

public class ReportCreationCheatSheetTest extends TalendSwtbotForTdq{
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.MySQL);
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createAnalysis(bot,
				TalendAnalysisTypeEnum.CATALOG, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendAnalysisTypeEnum.CATALOG.toString()+" 0.1").close();
		try {
			bot.cTabItem("Cheat Sheets").close();
		} catch (WidgetNotFoundException e) {
			System.out.println("Haven't found Cheat Sheets");
		}
	}
	@Test
	public void ReportCreationCheatSheet(){
		
		bot.menu("Help").menu("Cheat Sheets...").click();
		bot.waitUntil(Conditions.shellIsActive("Cheat Sheet Selection"));
		bot.radio("Select a cheat sheet from the list:").click();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Talend - Cheat Sheets").getNode(6).expand().getNode(0).select();
		bot.button("OK").click();
		formBot.imageHyperlink("Click to Begin").click();
		formBot.imageHyperlink("Click to perform").click();
		try {
			bot.textWithLabel("Name").setText(TalendAnalysisTypeEnum.COLUMN.toString());
			bot.button("Finish").click();
		} catch (Exception e) {
			
		}
		formBot.imageHyperlink("Click to perform").click();
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode(TalendAnalysisTypeEnum.CATALOG+" 0.1").check();
		bot.button("OK").click();
		formBot.imageHyperlink("Click when complete").click();
		formBot.imageHyperlink("Click when complete").click();
		formBot.imageHyperlink("Click to perform").click();
		try {
			bot.waitUntil(
					Conditions.shellCloses(bot.shell("Generate Report File")),
					60000);
		} catch (TimeoutException e) {
		}
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN+" 0.1").close();
		
	}
//	@After
//	public void afterClass(){
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.REPORT, TalendAnalysisTypeEnum.COLUMN.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS, TalendAnalysisTypeEnum.CATALOG.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA, TalendMetadataTypeEnum.MYSQL.toString());
//		
//	}

}
