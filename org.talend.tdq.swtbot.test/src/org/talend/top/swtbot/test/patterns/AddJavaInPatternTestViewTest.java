package org.talend.top.swtbot.test.patterns;

import static org.junit.Assert.assertEquals;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.keyboard.Keystrokes;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;

public class AddJavaInPatternTestViewTest extends TalendSwtbotForTdq{
	
	@Test
	public void AddJavaInPatternTestView(){
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries","Patterns","Regex","address").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree, "Open");
		bot.editorByTitle("BE Code postal 0.1").show();
		formBot.ccomboBox(1).setSelection("Java");
		formBot.button("Test").click();
		bot.viewByTitle("Pattern Test").show();
		assertEquals("select Java automatically","Java",bot.radio(0).getText());
		bot.button("Test").click();
		assertEquals("that is to say  non-matches", "non-matches", bot.label(1).getText());
		bot.viewByTitle("Pattern Test").close();
		bot.editorByTitle("BE Code postal 0.1").close();
		
	}

}
