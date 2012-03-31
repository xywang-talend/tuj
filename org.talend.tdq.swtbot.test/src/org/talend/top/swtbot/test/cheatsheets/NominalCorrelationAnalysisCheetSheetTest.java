package org.talend.top.swtbot.test.cheatsheets;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class NominalCorrelationAnalysisCheetSheetTest extends TalendSwtbotForTdq{
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		
	}
	
	@Test
	public void NominalCorrelationAnalysisCheetSheet(){
		
		bot.menu("Help").menu("Cheat Sheets...").click();
		bot.waitUntil(Conditions.shellIsActive("Cheat Sheet Selection"));
		bot.radio("Select a cheat sheet from the list:").click();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Talend - Cheat Sheets").getNode(0).expand().getNode(7).select();
		bot.button("OK").click();
		formBot.imageHyperlink("Click to Begin").click();
		formBot.imageHyperlink("Click to perform").click();
		bot.textWithLabel("Name").setText(TalendAnalysisTypeEnum.NOMINAL_CORRELATION.toString());
		bot.button("Finish").click();
		formBot.imageHyperlink("Click when complete").click();
		formBot.imageHyperlink("Click to perform").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		String column = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "city")[0];
		bot.table().getTableItem(column).check();
		bot.button("OK").click();
		if (bot.editorByTitle(
				TalendAnalysisTypeEnum.NOMINAL_CORRELATION + " 0.1").isDirty())
			bot.editorByTitle(
					TalendAnalysisTypeEnum.NOMINAL_CORRELATION + " 0.1").save();
		formBot.imageHyperlink("Click when complete").click();
		formBot.imageHyperlink("Click to perform").click();
		formBot.imageHyperlink("Click to perform").click();
		bot.editorByTitle(TalendAnalysisTypeEnum.NOMINAL_CORRELATION+" 0.1").close();
		try {
			bot.cTabItem("Cheat Sheets").close();
		} catch (WidgetNotFoundException e) {
			System.out.println("Haven't found Cheat Sheets");
		}
	}
	
//	@After 
//	public void afterClass(){
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.NOMINAL_CORRELATION.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//		
//	}

}
