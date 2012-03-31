package org.talend.tdq.swtbot.test.report;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportDBType;

public class NewReportMenuAItemTest extends TalendSwtbotForTdq {

	@Before
	public void beforeClass() {
		TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.MySQL);
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createAnalysis(bot,
				TalendAnalysisTypeEnum.CATALOG, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendAnalysisTypeEnum.CATALOG.toString() + " 0.1")
				.close();
	}

	@Test
	public void newReportMenuAItem() {
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class),bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Data Profiling").getNode(0).expand()
				.select(TalendAnalysisTypeEnum.CATALOG.toString() + " 0.1");
		ContextMenuHelper.clickContextMenu(tree, "New Report");
		bot.sleep(10000);
		bot.editorByTitle(TalendAnalysisTypeEnum.CATALOG.toString() + " 0.1")
		.close();
		SWTBotTree tree1 = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class),bot.viewByTitle("DQ Repository").getWidget()));
		tree1.expandNode("Data Profiling").getNode(1).expand()
				.select(TalendAnalysisTypeEnum.CATALOG.toString() + " 0.1");
		ContextMenuHelper.clickContextMenu(tree, "Open Report");
		bot.toolbarButtonWithTooltip("Generate Report File").click();
		bot.waitUntil(
				Conditions.shellCloses(bot.shell("Generate Report File")),
				90000);
		bot.waitUntil(Conditions.shellCloses(bot.shell("refresh")));
		bot.editorByTitle(TalendAnalysisTypeEnum.CATALOG.toString() + " 0.1")
				.close();
	}

//	@After
//	public void cleanSource() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.REPORT,
//				TalendAnalysisTypeEnum.CATALOG.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.CATALOG.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//
//	}

}
