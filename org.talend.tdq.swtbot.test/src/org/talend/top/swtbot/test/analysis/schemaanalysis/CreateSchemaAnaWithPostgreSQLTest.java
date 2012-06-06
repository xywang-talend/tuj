package org.talend.top.swtbot.test.analysis.schemaanalysis;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTableItem;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

@RunWith(SWTBotJunit4ClassRunner.class)
public class CreateSchemaAnaWithPostgreSQLTest extends TalendSwtbotForTdq {

	@Before
	public void beforeRunning() {
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.POSTGRESQL);
		bot.editorByTitle(TalendMetadataTypeEnum.POSTGRESQL.toString()+" 0.1").close();
	}

	@Test
	public void createSchemaAnalysis() {
		TalendSwtbotTdqCommon.createAnalysis(bot,
				TalendAnalysisTypeEnum.SCHEMA,
				TalendMetadataTypeEnum.POSTGRESQL);
		bot.viewByTitle("DQ Repository").setFocus();
		bot.toolbarButtonWithTooltip("Refresh").click();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		SWTBotTreeItem analysisItem = tree.expandNode("Data Profiling")
				.getNode(0).expand()
				.select(TalendAnalysisTypeEnum.SCHEMA.toString() + " 0.1");
		Assert.assertNotNull(analysisItem);
		bot.editorByTitle(TalendAnalysisTypeEnum.SCHEMA.toString() + " 0.1").show();
        bot.toolbarButtonWithTooltip("Run").click();

//        try {
//        	SWTBotShell shell = bot.shell("Run Analysis");
//        	bot.waitUntil(Conditions.shellCloses(shell));
//        } catch (TimeoutException e) {
//        }	
        formBot.section("Statistical information").setFocus();
        formBot.table().getTableItem(0).select();
        formBot.table(1).getTableItem(0).select();
        SWTBotTableItem tableItem = formBot.table(1).getTableItem(1).select();
        Assert.assertNotNull(tableItem);
        SWTBotTableItem tableItem2 = formBot.table(2).getTableItem(0).click();
        Assert.assertNotNull(tableItem2);
		bot.editorByTitle(TalendAnalysisTypeEnum.SCHEMA.toString() + " 0.1")
				.close();
	}

//	@After
//	public void cleanSource() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.SCHEMA.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.POSTGRESQL.toString());
//	}
}
