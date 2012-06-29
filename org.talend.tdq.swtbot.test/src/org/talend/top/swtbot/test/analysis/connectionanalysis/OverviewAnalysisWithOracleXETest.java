package org.talend.top.swtbot.test.analysis.connectionanalysis;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class OverviewAnalysisWithOracleXETest extends TalendSwtbotForTdq{
	
	private static final String ANALYSISLABEL = "connection";
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.ORACLE);
		bot.editorByTitle(TalendMetadataTypeEnum.ORACLE.toString()+" 0.1").close();
		
	}
	
	@Test
	public void OverviewAnalysisWithOracleXE(){
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Metadata", "DB connections").select(
				TalendMetadataTypeEnum.ORACLE.toString());
		ContextMenuHelper.clickContextMenu(tree, "Overview analysis");
		bot.textWithLabel("Name").setText(ANALYSISLABEL);
		bot.button("Next >").click();
		bot.button("Finish").click();
		bot.toolbarButtonWithTooltip("Refresh").click();
		SWTBotTreeItem analysisItem = tree.expandNode("Data Profiling")
				.getNode(0).expand().select(ANALYSISLABEL + " 0.1");
		Assert.assertNotNull(analysisItem);
//		bot.toolbarButtonWithTooltip("Run").click();
//
//		try {
//			SWTBotShell shell = bot.shell("Run Analysis");
//			bot.waitUntil(Conditions.shellCloses(shell),180000);
//		} catch (TimeoutException e) {
//		}
		bot.editorByTitle(ANALYSISLABEL + " 0.1").close();
		
	}
	
	@After
	public void afterClass(){
		
	}

}
