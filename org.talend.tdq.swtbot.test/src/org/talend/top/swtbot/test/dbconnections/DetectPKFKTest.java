package org.talend.top.swtbot.test.dbconnections;

import junit.framework.Assert;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

@RunWith(SWTBotJunit4ClassRunner.class)
public class DetectPKFKTest extends TalendSwtbotForTdq {

	@Before
	public void beforeRunning() {
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString() + " 0.1")
				.close();
	}

	@Test
	public void detectPKFK() {
		/**
		 * PK detect
		 */
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		
		tree.expandNode("Metadata", "DB connections",
				TalendMetadataTypeEnum.MYSQL.toString(), "tbi").getNode(0)
				.expand().getNode("customer").expand().select();
		
//		tree.expandNode("Metadata", "DB connections",
//				TalendMetadataTypeEnum.MYSQL.toString(), "tbi", "Tables")
//				.select("customer");
		bot.viewByTitle("Detail View").setFocus();
		String tmp = bot.textWithLabel("Primary keys: ").getText();
		Assert.assertEquals("PRIMARY(1)", tmp);

		/**
		 * FK detect
		 */
		bot.viewByTitle("DQ Repository").setFocus();
		
		tree.expandNode("Metadata", "DB connections",
				TalendMetadataTypeEnum.MYSQL.toString(), "tbi").getNode(0)
				.expand().getNode("sales_fact").expand().select();
		
//		tree.expandNode("Metadata", "DB connections",
//				TalendMetadataTypeEnum.MYSQL.toString(), "tbi", "Tables")
//				.select("sales_fact");
		bot.viewByTitle("Detail View").setFocus();
		tmp = bot.textWithLabel("Foreign keys: ").getText();
		Assert.assertEquals("sales_fact_ibfk_1(1)", tmp);
		tmp = bot.textInGroup("General", 4).getText();
		Assert.assertEquals("sales_fact_ibfk_2(1)", tmp);
	}

//	@After
//	public void afterMethod() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//	}

}
