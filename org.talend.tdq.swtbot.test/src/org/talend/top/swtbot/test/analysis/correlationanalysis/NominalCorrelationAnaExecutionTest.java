package org.talend.top.swtbot.test.analysis.correlationanalysis;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
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
public class NominalCorrelationAnaExecutionTest extends TalendSwtbotForTdq {

	@Before
	public void beforeRunning() {
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
	}

	@Test
	public void nominalCorrelationAnaExecution() {
		TalendSwtbotTdqCommon.createAnalysis(bot,
				TalendAnalysisTypeEnum.NOMINAL_CORRELATION);
		bot.editorByTitle(TalendAnalysisTypeEnum.NOMINAL_CORRELATION + " 0.1")
				.show();
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		String column = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "city")[0];
		bot.table().getTableItem(column).check();
		bot.button("OK").click();
		if (bot.editorByTitle(
				TalendAnalysisTypeEnum.NOMINAL_CORRELATION + " 0.1").isDirty())
			bot.editorByTitle(
					TalendAnalysisTypeEnum.NOMINAL_CORRELATION + " 0.1").save();
		bot.toolbarButtonWithTooltip("Run").click();
		bot.editorByTitle(TalendAnalysisTypeEnum.NOMINAL_CORRELATION + " 0.1")
				.close();
	}

//	@After
//	public void cleanSource() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.NOMINAL_CORRELATION.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//	}
}
