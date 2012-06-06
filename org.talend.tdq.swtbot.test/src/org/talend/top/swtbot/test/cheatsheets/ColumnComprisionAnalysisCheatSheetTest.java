package org.talend.top.swtbot.test.cheatsheets;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
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
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;
@RunWith(SWTBotJunit4ClassRunner.class)
public class ColumnComprisionAnalysisCheatSheetTest extends TalendSwtbotForTdq{
	
	@Before
	public void beforeClass(){
		
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		
	}
	@Test
	public void ColumnComprisionAnalysisCheatSheet(){
		bot.menu("Help").menu("Cheat Sheets...").click();
		bot.waitUntil(Conditions.shellIsActive("Cheat Sheet Selection"));
		bot.radio("Select a cheat sheet from the list:").click();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Talend - Cheat Sheets").getNode(0).expand().getNode(2).select();
		bot.button("OK").click();
		bot.cTabItem("Cheat Sheets").setFocus();
		formBot.imageHyperlink("Click to Begin").click();
		formBot.imageHyperlink("Click to perform").click();
		bot.textWithLabel("Name").setText("ComprisionAnalysis");
		bot.button("Finish").click();
		formBot.imageHyperlink("Click to perform").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		String colLeft = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "address1")[0];
		bot.table().getTableItem(colLeft).check();
		bot.button("OK").click();
		bot.cTabItem("Cheat Sheets").setFocus();
		formBot.imageHyperlink("Click to perform").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("employee");
		String colRight = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "employee", "first_name")[0];
		bot.table().getTableItem(colRight).check();
		bot.button("OK").click();
		formBot.imageHyperlink("Click to perform").click();
		
		try {
			bot.waitUntil(Conditions.shellIsActive("Confirm your operation"));
			SWTBotShell shell = bot.shell("Confirm your operation");
			bot.button("OK").click();
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (TimeoutException e) {
			System.out.println("Haven't found Confirm your operation");
		}
		try {
			SWTBotShell shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell),180000);
		} catch (Exception e) {
		}
		bot.cTabItem("Analysis Results").activate();
		bot.sleep(2000);
		bot.captureScreenshot(System
				.getProperty("tdq.analysis.result.screenshot.path")
				+ "businessAnalysis.jpeg");		
		bot.editorByTitle("ComprisionAnalysis 0.1").close();
 
		try {
			bot.cTabItem("Cheat Sheets").close();
		} catch (WidgetNotFoundException e) {
			System.out.println("Haven't found Cheat Sheets");
		}
	}
//	@After
//	public void afterClass(){
//  //  	SWTWorkbenchBot bot = new SWTWorkbenchBot();
//    	bot.closeAllShells();
//    	bot.saveAllEditors();
//    	bot.closeAllEditors();
////    	TalendSwtbotTdqCommon.cleanUpRepository();
////    	bot.resetActivePerspective();
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS, "ComprisionAnalysis");
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA, TalendMetadataTypeEnum.MYSQL.toString());
//		
//		
//	}
	

}
