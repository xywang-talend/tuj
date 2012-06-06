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
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

@RunWith(SWTBotJunit4ClassRunner.class)
public class CreatePostgreConnectionTest extends TalendSwtbotForTdq {

	private SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
			WidgetOfType.widgetOfType(Tree.class),
			bot.viewByTitle("DQ Repository").getWidget()));

	@Test
	public void createPostgreConnection() {
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.POSTGRESQL);
		bot.viewByTitle("DQ Repository").setFocus();
		bot.toolbarButtonWithTooltip("Refresh").click();
		SWTBotTreeItem connectionItem = tree.expandNode("Metadata",
				"DB connections").select(
				TalendMetadataTypeEnum.POSTGRESQL.toString());
		Assert.assertNotNull(connectionItem);
		bot.editorByTitle(TalendMetadataTypeEnum.POSTGRESQL.toString() + " 0.1")
				.close();
	}

//	@After
//	public void cleanSource() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.POSTGRESQL.toString());
//	}
}
