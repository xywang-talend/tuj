package org.talend.top.swtbot.test.cheatsheets;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class NumbericalColumnCorrelationAnalysisCheatSheetTest extends TalendSwtbotForTdq{
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		
	}
	@Test
	public void NumbericalColumnCorrelationAnalysisCheatSheet(){
		bot.menu("Help").menu("Cheat Sheets...").click();
		bot.waitUntil(Conditions.shellIsActive("Cheat Sheet Selection"));
		bot.radio("Select a cheat sheet from the list:").click();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Talend - Cheat Sheets").getNode(0).expand().getNode(8).select();
		bot.button("OK").click();
		bot.cTabItem("Cheat Sheets").setFocus();
		formBot.imageHyperlink("Click to Begin").click();
		formBot.imageHyperlink("Click to perform").click();
		bot.textWithLabel("Name").setText("NumbericalAnalysis");
		bot.button("Finish").click();
		formBot.imageHyperlink("Click to perform").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		String[] columns = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "address4",
				"customer_region_id");
		bot.table().getTableItem(columns[0]).check();
		bot.table().getTableItem(columns[1]).check();
		bot.button("OK").click();
		long defaultTimeout = SWTBotPreferences.TIMEOUT;
		try {
			SWTBotPreferences.TIMEOUT = 500;
			if(bot.shell("Save Analysis").isActive())
				Assert.fail("nnnnn");
		} catch (Exception e1) {
			// ignore
		}finally{
			SWTBotPreferences.TIMEOUT = defaultTimeout;
		}
		
		formBot.ccomboBox(2).setSelection("Interval");
		if (bot.editorByTitle(
				 "NumbericalAnalysis 0.1")
				.isDirty())
			bot.editorByTitle( "NumbericalAnalysis 0.1")
					.save();
		formBot.imageHyperlink("Click when complete").click();
		formBot.imageHyperlink("Click to perform").click();
		formBot.imageHyperlink("Click to perform").click();
		bot.editorByTitle("NumbericalAnalysis 0.1").close();
		try {
			bot.cTabItem("Cheat Sheets").close();
		} catch (WidgetNotFoundException e) {
			System.out.println("Haven't found Cheat Sheets");
		}
	}
//	@After
//	public void afterClass(){
//		bot.closeAllShells();
//    	bot.saveAllEditors();
//    	bot.closeAllEditors();
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS, "NumbericalAnalysis");
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA, TalendMetadataTypeEnum.MYSQL.toString());
//		
//		
//	}

}
