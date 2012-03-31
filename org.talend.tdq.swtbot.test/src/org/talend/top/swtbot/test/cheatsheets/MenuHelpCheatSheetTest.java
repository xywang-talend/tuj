package org.talend.top.swtbot.test.cheatsheets;

import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Assert;
import org.junit.Test;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;

public class MenuHelpCheatSheetTest extends TalendSwtbotForTdq{
	
	
	@Test
	public void MenuHelpCheatSheet(){
		bot.menu("Help").menu("Cheat Sheets...").click();
		bot.waitUntil(Conditions.shellIsActive("Cheat Sheet Selection"));
		SWTBotShell shell = bot.shell("Cheat Sheet Selection");
		Assert.assertNotNull(shell);
		bot.button("Cancel").click();
		
	}
	
}
