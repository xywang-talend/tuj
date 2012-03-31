package org.talend.top.swtbot.test.cheatsheets;


import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.After;
import org.junit.Test;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;

public class DatabaseConnectionCheatSheetTest extends TalendSwtbotForTdq{
	@Test
	public void databaseConnectionCheatSheet(){
		bot.sleep(10000);
		bot.menu("Help").menu("Cheat Sheets...").click();
		bot.waitUntil(Conditions.shellIsActive("Cheat Sheet Selection"));
		bot.radio("Select a cheat sheet from the list:").click();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Talend - Cheat Sheets").getNode(1).expand().getNode(0).select();
		bot.button("OK").click();
		bot.sleep(2000);
		bot.cTabItem("Cheat Sheets").setFocus();
		formBot.imageHyperlink("Click to Begin").click();
		formBot.imageHyperlink("Click to perform").click();
		bot.waitUntil(Conditions.shellIsActive("Database Connection"));
		TalendSwtbotTdqCommon.createConn(bot, TalendMetadataTypeEnum.MYSQL);
		formBot.imageHyperlink("Click when complete").click();
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL+" 0.1").close();
		
		try {
			bot.cTabItem("Cheat Sheets").close();
		} catch (WidgetNotFoundException e) {
			System.out.println("Haven't found Cheat Sheets");
		}
	}
//	@After
//	public void afterClass(){
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA, TalendMetadataTypeEnum.MYSQL.toString());
//	
//		
//	}

}
