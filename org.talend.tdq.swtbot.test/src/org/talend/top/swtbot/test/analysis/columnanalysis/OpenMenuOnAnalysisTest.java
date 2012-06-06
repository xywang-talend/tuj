package org.talend.top.swtbot.test.analysis.columnanalysis;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;

@RunWith(SWTBotJunit4ClassRunner.class)
public class OpenMenuOnAnalysisTest extends TalendSwtbotForTdq {

	@Before
	public void beforeRunning() {
		TalendSwtbotTdqCommon
				.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);
			bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
					.close();
	}

	@Test
	public void openMenuOnAnlysis() {
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Data Profiling").getNode(0).expand()
				.select(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1");
		ContextMenuHelper.clickContextMenu(tree, "Open");
		Assert.assertNotNull(bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN
				.toString() + " 0.1"));
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
				.close();
	}

//	@After
//	public void cleanSource() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.COLUMN.toString());
//	}
}
