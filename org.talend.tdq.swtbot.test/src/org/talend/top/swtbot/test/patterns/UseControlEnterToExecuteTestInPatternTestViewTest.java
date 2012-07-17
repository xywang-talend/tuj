package org.talend.top.swtbot.test.patterns;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.keyboard.Keystrokes;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class UseControlEnterToExecuteTestInPatternTestViewTest extends TalendSwtbotForTdq{
	
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		
	}
	@Test
	public void UseControlEnterToExecuteTestInPatternTestView(){
		
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Patterns","Regex","address").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree, "Open");
		bot.editorByTitle("BE Code postal 0.1").show();
		formBot.button("Test").click();
		bot.viewByTitle("Pattern Test").show();
		bot.textWithLabel("Test Area").setText("art");
		SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
//		bot.styledText().pressShortcut(Keystrokes.CTRL, Keystrokes.SPACE);
		bot.textWithLabel("Test Area").pressShortcut(SWT.CTRL,SWT.LF); // press button Enter

		assertEquals("that is to say  non-matches", "non-matches", bot.label(1).getText());
		bot.viewByTitle("Pattern Test").close();
		bot.editorByTitle("BE Code postal 0.1").close();
		
			
		
		
	}

}
