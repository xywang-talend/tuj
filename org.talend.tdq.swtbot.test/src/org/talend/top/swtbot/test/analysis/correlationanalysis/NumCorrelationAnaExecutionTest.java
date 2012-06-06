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
public class NumCorrelationAnaExecutionTest extends TalendSwtbotForTdq {

	@Before
	public void beforeRunning() {
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
	}

	@Test
	public void numCorrelationAnaExecution() {
		TalendSwtbotTdqCommon.createAnalysis(bot,
				TalendAnalysisTypeEnum.NUMERICAL_CORRELATION);
		bot.editorByTitle(TalendAnalysisTypeEnum.NUMERICAL_CORRELATION + " 0.1")
				.show();
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		String[] columns = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "customer_id",
				"address4");
		bot.table().getTableItem(columns[0]).check();
		bot.table().getTableItem(columns[1]).check();
		bot.button("OK").click();
		formBot.ccomboBox(1).setSelection("Interval");
		if (bot.editorByTitle(
				TalendAnalysisTypeEnum.NUMERICAL_CORRELATION + " 0.1")
				.isDirty())
			bot.editorByTitle(
					TalendAnalysisTypeEnum.NUMERICAL_CORRELATION + " 0.1")
					.save();
		bot.toolbarButtonWithTooltip("Run").click();
		bot.editorByTitle(TalendAnalysisTypeEnum.NUMERICAL_CORRELATION + " 0.1")
				.close();
	}

//	@After
//	public void cleanSource() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.NUMERICAL_CORRELATION.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//	}
}
