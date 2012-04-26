package org.talend.top.swtbot.test.analysis.connectionanalysis;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class RunConnectionAnalysisTest extends TalendSwtbotForTdq{
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
	}
	
	@Test
	public void RunConnectionAnalysis(){
		TalendSwtbotTdqCommon
		.createAnalysis(bot, TalendAnalysisTypeEnum.CONNECTION,
				TalendMetadataTypeEnum.MYSQL);
		bot.toolbarButtonWithTooltip("Run").click();

		try {
			SWTBotShell shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell),180000);
		} catch (TimeoutException e) {
		}
		bot.viewByTitle("DQ Repository").setFocus();
		bot.toolbarButtonWithTooltip("Refresh").click();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		SWTBotTreeItem analysisItem = tree.expandNode("Data Profiling")
			.getNode(0).expand()
			.select(TalendAnalysisTypeEnum.CONNECTION.toString() + " 0.1");
		Assert.assertNotNull(analysisItem);
		bot.editorByTitle(TalendAnalysisTypeEnum.CONNECTION.toString()+" 0.1").close();
		
	}

}
