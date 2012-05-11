package org.talend.top.swtbot.test.filedelimited;

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
public class CreateFileDelimitedConnectionTest extends TalendSwtbotForTdq {

	private static final String FILENAME = "delimitedFile";

	@Test
	public void createDelimitedFileConnection() {
		TalendSwtbotTdqCommon.createFileDelimitedConnection(bot, FILENAME);
		bot.viewByTitle("DQ Repository").setFocus();
		bot.toolbarButtonWithTooltip("Refresh").click();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		SWTBotTreeItem delimitedFile = tree.expandNode("Metadata",
				"FileDelimited connections").getNode(FILENAME);
		Assert.assertNotNull(delimitedFile);
	}

//	@After
//	public void cleanSource() {
//		TalendSwtbotTdqCommon.deleteSource(bot,
//				TalendItemTypeEnum.FILE_DELIMITED, FILENAME);
//	}

}
