package org.talend.top.swtbot.test.dbconnections;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;

@RunWith(SWTBotJunit4ClassRunner.class)
public class CreateMDMConnectionTest extends TalendSwtbotForTdq {

	private static final String MDM_CONNECTION_NAME = "mdm_connection";

	@Test
	public void createMDMConnection() {
		TalendSwtbotTdqCommon.createMDMConnection(bot, MDM_CONNECTION_NAME);
		bot.viewByTitle("DQ Repository").setFocus();
		bot.toolbarButtonWithTooltip("Refresh").click();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		SWTBotTreeItem mdm = tree.expandNode("Metadata", "MDM connections")
				.getNode(MDM_CONNECTION_NAME);
		Assert.assertNotNull(mdm);
		bot.editorByTitle(MDM_CONNECTION_NAME + " 0.1").close();
	}

//	@After
//	public void cleanSource() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.MDM,
//				MDM_CONNECTION_NAME);
//	}
}
