package org.talend.top.swtbot.test.analysis.cataloganalysis;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTableItem;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class RunACatalogAnalysisPostgresqlTest extends TalendSwtbotForTdq{
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.POSTGRESQL);
		bot.editorByTitle(TalendMetadataTypeEnum.POSTGRESQL.toString()+" 0.1").close();
	}
	
	@Test
	public void RunACatalogAnalysisPostgresql(){
		TalendSwtbotTdqCommon.createAnalysis(bot,
				TalendAnalysisTypeEnum.CATALOG, TalendMetadataTypeEnum.POSTGRESQL);
		bot.toolbarButtonWithTooltip("Refresh").click();
		bot.viewByTitle("DQ Repository").setFocus();
		bot.toolbarButtonWithTooltip("Refresh").click();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		SWTBotTreeItem analysisItem = tree.expandNode("Data Profiling")
				.getNode(0).expand()
				.select(TalendAnalysisTypeEnum.CATALOG.toString() + " 0.1");
		Assert.assertNotNull(analysisItem);
		
		bot.editorByTitle(TalendAnalysisTypeEnum.CATALOG.toString() + " 0.1").show();
        bot.toolbarButtonWithTooltip("Run").click();

//        try {
//        	SWTBotShell shell = bot.shell("Run Analysis");
//        	bot.waitUntil(Conditions.shellCloses(shell));
//        } catch (TimeoutException e) {
//        }	
//        formBot.section("Statistical information").setFocus();
        formBot.table().getTableItem(0).select();
        formBot.table(1).getTableItem(0).select();
        SWTBotTableItem tableItem = formBot.table(1).getTableItem(1).select();
        Assert.assertNotNull(tableItem);
        SWTBotTableItem tableItem2 = formBot.table(2).getTableItem(0).click();
        Assert.assertNotNull(tableItem2);
		bot.editorByTitle(TalendAnalysisTypeEnum.CATALOG.toString()+" 0.1").close();
		
	}
	
	@After
	public void afterClass(){
		
	}

}
