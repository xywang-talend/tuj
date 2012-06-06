package org.talend.top.swtbot.test.cheatsheets;


import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
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
public class BusinessRuleAnalysisCheatSheetTest extends TalendSwtbotForTdq{
	private final String DQRULENAME = "dqrule1";

	private final String RULEEXPRESSION = "customer_id>2500";
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createDQRule(bot, DQRULENAME, RULEEXPRESSION);
	}
	@Test
	public void businessRuleAnalysisCheatSheet(){
//		bot.cTabItem("Cheat Sheets").setFocus();
//		//SWTBotView view = bot.viewByTitle("Cheat Sheets");
//		SWTBotView view = bot.viewByTitle("DQ Repository");
//		List<SWTBotViewMenu> menus = view.menus();
//		System.out.println(view.getTitle()+"********"+menus.size());
//		for(SWTBotViewMenu menu : menus){
//			System.out.println("****"+menu.getText());
//		}
//		view.menu("Business Rule Analysis").click();
		bot.menu("Help").menu("Cheat Sheets...").click();
		bot.waitUntil(Conditions.shellIsActive("Cheat Sheet Selection"));
		bot.radio("Select a cheat sheet from the list:").click();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Talend - Cheat Sheets").getNode(0).expand().getNode(0).select();
		bot.button("OK").click();
		bot.cTabItem("Cheat Sheets").setFocus();
		formBot.imageHyperlink("Click to Begin").click();
		formBot.imageHyperlink("Click to perform").click();
		bot.textWithLabel("Name").setText("businessAnalysis");
		bot.button("Finish").click();
		formBot.imageHyperlink("Click to perform").click();
		bot.waitUntil(Conditions.shellIsActive("Table/view Selection"));
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("DB connections",
				TalendMetadataTypeEnum.MYSQL.toString(), "tbi").getNode(0).select();
		bot.table().getTableItem("customer").check();
		bot.button("OK").click();
		bot.editorByTitle("businessAnalysis 0.1").setFocus();
		formBot.section("Analyzed Tables and views").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
		WidgetOfType.widgetOfType(Tree.class),
		bot.editorByTitle("businessAnalysis 0.1").getWidget()));
		tree.getTreeItem("customer").doubleClick();
		try {
			bot.waitUntil(Conditions.shellIsActive("DQ Rule Selector"));
		} catch (TimeoutException e) {
		}
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Rules", "SQL").getNode(DQRULENAME).check();
		bot.button("OK").click();
		bot.cTabItem("Cheat Sheets").setFocus();
		formBot.imageHyperlink("Click when complete").click();
		formBot.imageHyperlink("Click to perform").click();
		bot.cTabItem("Analysis Results").activate();
		bot.sleep(2000);
		bot.captureScreenshot(System
				.getProperty("tdq.analysis.result.screenshot.path")
				+ "businessAnalysis.jpeg");		
		bot.editorByTitle("businessAnalysis 0.1").close();
 
		
		try {
			bot.cTabItem("Cheat Sheets").close();
		} catch (WidgetNotFoundException e) {
			System.out.println("Haven't found Cheat Sheets");
		}
		
	}
//	@After
//	public void afterClass(){
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS, "businessAnalysis");
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.LIBRARY_DQRULE, DQRULENAME);
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA, TalendMetadataTypeEnum.MYSQL.toString());
//		
//	}
}
