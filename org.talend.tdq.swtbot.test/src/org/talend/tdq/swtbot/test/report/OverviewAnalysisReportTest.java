package org.talend.tdq.swtbot.test.report;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportDBType;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class OverviewAnalysisReportTest extends TalendSwtbotForTdq{
	private final String CONLABEL = "analysis_connection";
	private final String CATALOGELABEL = "analysis_catalog";
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.MySQL);
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		
	}
	@Test
	public void overviewAnalysisReport(){
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Metadata","DB connections")
				.select(TalendMetadataTypeEnum.MYSQL.toString());
		ContextMenuHelper.clickContextMenu(tree, "Overview analysis");
		bot.textWithLabel("Name").setText(CONLABEL);
		bot.button("Next >").click();
		bot.button("Finish").click();
		bot.editorByTitle(CONLABEL + " 0.1").show();
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			SWTBotShell shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell),50000);
		} catch (TimeoutException e) {
		}
		bot.editorByTitle(CONLABEL+" 0.1").close();
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Metadata","DB connections").getNode(0).expand()
				.select("tbi");
		ContextMenuHelper.clickContextMenu(tree, "Overview analysis");
		bot.textWithLabel("Name").setText(CATALOGELABEL);
		bot.button("Next >").click();
		bot.button("Finish").click();
		bot.editorByTitle(CATALOGELABEL + " 0.1").show();
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			SWTBotShell shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell),50000);
		} catch (TimeoutException e) {
		}
		bot.editorByTitle(CATALOGELABEL+" 0.1").close();
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Data Profiling").getNode(0).expand()
				.select(CONLABEL+" 0.1");
		ContextMenuHelper.clickContextMenu(tree, "New Report");
		bot.editorByTitle(CONLABEL + " 0.1").show();
		bot.toolbarButtonWithTooltip("Generate Report File").click();
		try {
			bot.waitUntil(
					Conditions.shellCloses(bot.shell("Generate Report File")),
					50000);
			bot.waitUntil(Conditions.shellCloses(bot.shell("refresh")));
		} catch (TimeoutException e) {
		}
		bot.sleep(10000);
		bot.editorByTitle(CONLABEL+" 0.1").close();
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Data Profiling").getNode(0).expand()
				.select(CATALOGELABEL+" 0.1");
		ContextMenuHelper.clickContextMenu(tree, "New Report");
		bot.editorByTitle(CATALOGELABEL + " 0.1").show();
		bot.toolbarButtonWithTooltip("Generate Report File").click();
		try {
			bot.waitUntil(
					Conditions.shellCloses(bot.shell("Generate Report File")),
					30000);
			bot.waitUntil(Conditions.shellCloses(bot.shell("refresh")));
		} catch (TimeoutException e) {
		}
		bot.editorByTitle(CATALOGELABEL+" 0.1").close();
		

		
		
		
	}
//	@After
//	public void afterClass(){
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.REPORT,CATALOGELABEL);
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.REPORT,CONLABEL);
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				CATALOGELABEL);
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				CONLABEL);
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//		
//		
//	}

}
