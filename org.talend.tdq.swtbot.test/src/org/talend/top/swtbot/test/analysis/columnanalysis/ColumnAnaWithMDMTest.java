package org.talend.top.swtbot.test.analysis.columnanalysis;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

@RunWith(SWTBotJunit4ClassRunner.class)
public class ColumnAnaWithMDMTest extends TalendSwtbotForTdq {

	private final String CONNECTIONNAME = "MDM";

	@Before
	public void beforeRunning() {
		TalendSwtbotTdqCommon.createMDMConnection(bot, CONNECTIONNAME);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon
				.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);
	}

	@Test
	public void columnAnaWithMDM() {
//		String column = TalendSwtbotTdqCommon.getColumns(bot,
//				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "address1")[0];
		
		if (bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1") != null)
			bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
					.setFocus();
		formBot.section("Analyzed Columns").setFocus();
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		SWTBotTree tree = new SWTBotTree((Tree)bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("DStar").getNode(1).select();
		bot.table().getTableItem(1).check();
		bot.table().getTableItem(2).check();
		bot.button("OK").click();
		formBot.hyperlink("Select indicators for each column").click();
		bot.waitUntil(Conditions.shellIsActive("Indicator Selection"));

		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.getTreeItem("Simple Statistics").click(1);
		bot.checkBox().click();
		bot.button("OK").click();
		bot.toolbarButtonWithTooltip("Save").click();
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			SWTBotShell shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (TimeoutException e) {
		}
		bot.sleep(2000);

		bot.cTabItem("Analysis Results").activate();
		bot.sleep(2000);
		bot.captureScreenshot(System
				.getProperty("tdq.analysis.result.screenshot.path")
				+ "MDMAnaysis.jpeg");
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").close();

	}

//	@After
//	public void cleanSource() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.COLUMN.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.MDM,
//				CONNECTIONNAME);
//	}
}
