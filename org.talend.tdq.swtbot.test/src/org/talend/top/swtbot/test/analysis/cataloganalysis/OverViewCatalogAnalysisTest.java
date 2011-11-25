package org.talend.top.swtbot.test.analysis.cataloganalysis;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
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
public class OverViewCatalogAnalysisTest extends TalendSwtbotForTdq {

	private static final String ANALYSISLABEL = "catalog";

	@Before
	public void beforeRunning() {
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
	}

	@Test
	public void overviewCatalogAnalysis() {
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Metadata", "DB connections",
				TalendMetadataTypeEnum.MYSQL.toString()).select("tbi");
		ContextMenuHelper.clickContextMenu(tree, "Overview analysis");
		bot.textWithLabel("Name").setText(ANALYSISLABEL);
		bot.button("Next >").click();
		bot.button("Finish").click();
		SWTBotTreeItem analysisItem = tree.expandNode("Data Profiling")
				.getNode(0).expand().select(ANALYSISLABEL + " 0.1");
		Assert.assertNotNull(analysisItem);
	}

	@After
	public void cleanSource() {
		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
				ANALYSISLABEL);
		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
				TalendMetadataTypeEnum.MYSQL.toString());
	}

}
