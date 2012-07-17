package org.talend.top.swtbot.test.patterns;

import static org.junit.Assert.assertEquals;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class ExpressionTestBasedOnPostgreSQLDatabaseForIPTest extends TalendSwtbotForTdq{
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.POSTGRESQL);
		bot.editorByTitle(TalendMetadataTypeEnum.POSTGRESQL.toString()+" 0.1").close();
		
	}
	@Test
	public void ExpressionTestBasedOnPostgreSQLDatabase(){
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Patterns","Regex","internet").getNode(1).select();
		ContextMenuHelper.clickContextMenu(tree, "Open");
		bot.editorByTitle("IP Address 0.1").show();
		formBot.ccomboBox(1).setSelection("PostgreSQL");
		bot.toolbarButtonWithTooltip("Save").click();
		formBot.button("Test").click();
		bot.viewByTitle("Pattern Test").show();
		bot.ccomboBox(0).setSelection("POSTGRESQL");
		bot.button("Test").click();
		assertEquals("that is to say  non-matches", "non-matches", bot.label(1).getText());
		bot.textWithLabel("Test Area").setText("192.168.10.4");
		bot.button("Test").click();
		assertEquals("that is to say  matches", "matches", bot.label(1).getText());
		bot.viewByTitle("Pattern Test").close();
		bot.editorByTitle("IP Address 0.1").close();
		
		
	}
	

}
