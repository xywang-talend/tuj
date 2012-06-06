package org.talend.top.swtbot.test.dbconnections;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
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
public class ReloadSybaseConnTest extends TalendSwtbotForTdq {

	@Before
	public void beforeRunning() {
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.SYBASE);
		bot.editorByTitle(TalendMetadataTypeEnum.SYBASE.toString() + " 0.1")
				.close();
	}

	@Test
	public void reloadSybaseConn() {
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Metadata", "DB connections").select(
				TalendMetadataTypeEnum.SYBASE.toString());
		ContextMenuHelper.clickContextMenu(tree, "Reload database list");
		bot.waitUntil(Conditions.shellIsActive("Confirm reload"));
		bot.button("OK").click();
		try {
			bot.waitUntil(Conditions.shellCloses(bot.shell("Progress Information")));
		} catch (Exception e) {
			
		}
		
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		SWTBotTreeItem pkfk = tree.expandNode("Metadata", "DB connections",
				TalendMetadataTypeEnum.SYBASE.toString(),"test","shenze")
	           .getNode(0).expand().select("havePkAndFK");
        Assert.assertNotNull(pkfk);
		
		
	}

//	@After
//	public void cleanSource() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.SYBASE.toString());
//	}

}
