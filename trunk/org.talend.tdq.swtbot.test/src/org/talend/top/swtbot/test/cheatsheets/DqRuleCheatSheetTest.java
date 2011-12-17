package org.talend.top.swtbot.test.cheatsheets;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.After;
import org.junit.Test;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;

public class DqRuleCheatSheetTest extends TalendSwtbotForTdq{
	@Test
	public void regexPatternCheatSheet(){
		bot.menu("Help").menu("Cheat Sheets...").click();
		bot.waitUntil(Conditions.shellIsActive("Cheat Sheet Selection"));
		bot.radio("Select a cheat sheet from the list:").click();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Talend - Cheat Sheets").getNode(6).expand().getNode(0).select();
		bot.button("OK").click();
		bot.sleep(10000);
		bot.cTabItem("Cheat Sheets").setFocus();
		formBot.imageHyperlink("Click to Begin").click();
		formBot.imageHyperlink("Click to perform").click();
		bot.textWithLabel("Name").setText("dqrule");
		bot.button("Next >").click();
		bot.textWithLabel("Where clause").setText("customer_id > 500");
		bot.button("Finish").click();
		
		
	}
	@After
	public void afterClass(){
		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.LIBRARY_DQRULE, "dqrule");
		
	}

}
