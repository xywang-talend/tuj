package org.talend.top.swtbot.test.dbconnections;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

@RunWith(SWTBotJunit4ClassRunner.class)
public class DuplicateMenuOnConnectionTest extends TalendSwtbotForTdq {

	private static final String DUPLICATEDLABEL = "DUPLICATED_CONNECTION";

	@Before
	public void beforeRunning() {
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString() + " 0.1")
				.close();
	}

	@Test
	public void duplicateMenuOnConnection() {
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Metadata", "DB connections").select(
				TalendMetadataTypeEnum.MYSQL.toString());
		ContextMenuHelper.clickContextMenu(tree, "Duplicate");
		bot.waitUntil(Conditions.shellIsActive("Input Dialog"));
		SWTBotShell shell = bot.shell("Input Dialog");
		bot.text(0).setText(DUPLICATEDLABEL);
		bot.button("OK").click();
		bot.waitUntil(Conditions.shellCloses(shell));
		SWTBotTreeItem connectionItem = tree.expandNode("Metadata",
				"DB connections").getNode(DUPLICATEDLABEL);
		Assert.assertNotNull(connectionItem);
	}

//	@After
//	public void cleanSource() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				DUPLICATEDLABEL);
//	}
}
