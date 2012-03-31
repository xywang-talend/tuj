package org.talend.top.swtbot.test.analysis.redundancyanalysis;

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
public class ComparisonAnaExecutionTest extends TalendSwtbotForTdq {

	@Before
	public void beforeRunning() {
		bot.sleep(10000);
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createAnalysis(bot,
				TalendAnalysisTypeEnum.REDUNDANCY);
	}

	@Test
	public void comparisonAnaExecution() {
		bot.editorByTitle(TalendAnalysisTypeEnum.REDUNDANCY.toString() + " 0.1")
				.show();
		formBot.hyperlink("Select columns for A Set").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		String colLeft = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "address1")[0];
		bot.table().getTableItem(colLeft).check();
		bot.button("OK").click();

		formBot.hyperlink("Select columns for B Set").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("employee");
		String colRight = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "employee", "first_name")[0];
		bot.table().getTableItem(colRight).check();
		bot.button("OK").click();
		if (bot.editorByTitle(
				TalendAnalysisTypeEnum.REDUNDANCY.toString() + " 0.1")
				.isDirty())
			bot.editorByTitle(
					TalendAnalysisTypeEnum.REDUNDANCY.toString() + " 0.1")
					.save();
		bot.toolbarButtonWithTooltip("Run").click();
		bot.waitUntil(Conditions.shellIsActive("Confirm your operation"));
		bot.button("OK").click();
		try {
			SWTBotShell shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell), 60000);
		} catch (TimeoutException e) {
		}
		bot.editorByTitle(TalendAnalysisTypeEnum.REDUNDANCY.toString() + " 0.1")
				.close();
	}

//	@After
//	public void cleanSource() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.REDUNDANCY.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//	}
}
