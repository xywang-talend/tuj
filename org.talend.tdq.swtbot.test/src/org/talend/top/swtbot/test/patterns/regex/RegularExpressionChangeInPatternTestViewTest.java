package org.talend.top.swtbot.test.patterns.regex;

import static org.junit.Assert.assertEquals;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class RegularExpressionChangeInPatternTestViewTest extends TalendSwtbotForTdq{
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
	}
	
	@Test
	public void RegularExpressionChangeInPatternTestView(){
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Patterns").getNode("Regex").select();
		ContextMenuHelper.clickContextMenu(tree, "New Regular Pattern");
		bot.waitUntil(Conditions.shellIsActive("New Regular Pattern"));
		bot.textWithLabel("Name").setText("toto");
		bot.button("Next >").click();
		bot.textWithLabel("Regular expression:").setText("'r'");
		bot.button("Finish").click();
		bot.editorByTitle("toto 0.1").show();
		formBot.button("Test").click();
		bot.viewByTitle("Pattern Test").show();
//		bot.radio("DB Connections").click();
//		bot.ccomboBox(0).setText(TalendMetadataTypeEnum.MYSQL.toString());
		bot.textWithLabel("Test Area").setText("art");
		bot.button("Test").click();
		assertEquals("that is to say  matches", "matches", bot.label(1).getText());
		bot.textWithLabel("Regex").setText("'br'");
		bot.button("Test").click();
		assertEquals("that is to say  non-matches", "non-matches", bot.label(1).getText());
		bot.button("Save").click();
		bot.waitUntil(Conditions.shellIsActive("Warning"));
		SWTBotShell shell = bot.shell("Warning");
		bot.button("Yes").click();
		bot.waitUntil(Conditions.shellCloses(shell));
		bot.viewByTitle("Pattern Test").close();
		bot.editorByTitle("toto 0.1").close();
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Patterns","Regex").getNode("toto 0.1").select();
		ContextMenuHelper.clickContextMenu(tree, "Delete");
		TalendSwtbotTdqCommon.cleanUpRepository();
			
		
		
		
		
		
		
	}

}
