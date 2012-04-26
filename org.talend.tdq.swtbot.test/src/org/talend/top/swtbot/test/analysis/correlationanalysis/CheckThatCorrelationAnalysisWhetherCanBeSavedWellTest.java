package org.talend.top.swtbot.test.analysis.correlationanalysis;

import static org.junit.Assert.assertEquals;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class CheckThatCorrelationAnalysisWhetherCanBeSavedWellTest extends TalendSwtbotForTdq{
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
	}
	
	@Test
	public void CheckThatCorrelationAnalysisWhetherCanBeSavedWell(){
		
		TalendSwtbotTdqCommon.createAnalysis(bot,
				TalendAnalysisTypeEnum.TIME_CORRELATION);
		bot.editorByTitle(TalendAnalysisTypeEnum.TIME_CORRELATION + " 0.1")
				.show();
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		String[] columns = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "birthdate",
				"address4");
		bot.table().getTableItem(columns[0]).check();
		bot.table().getTableItem(columns[1]).check();
		bot.button("OK").click();
		if (bot.editorByTitle(TalendAnalysisTypeEnum.TIME_CORRELATION + " 0.1")
				.isDirty())
			bot.editorByTitle(TalendAnalysisTypeEnum.TIME_CORRELATION + " 0.1")
					.save();
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			SWTBotShell shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (TimeoutException e) {
		}
		formBot.section("Analyzed Columns").setFocus();
		tree = new SWTBotTree((Tree)bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.editorByTitle(
				TalendAnalysisTypeEnum.TIME_CORRELATION.toString() + " 0.1")
				.getWidget()));
		System.out.println("((((((("+tree.getAllItems()[0].getText()+"))))))))");
		tree.expandNode(tree.getAllItems()[0].getText()).select();
		ContextMenuHelper.clickContextMenu(tree, "Remove elements");
		tree.expandNode(tree.getAllItems()[0].getText()).select();
		ContextMenuHelper.clickContextMenu(tree, "Remove elements");
		bot.editorByTitle(TalendAnalysisTypeEnum.TIME_CORRELATION + " 0.1")
		.save();
		bot.editorByTitle(TalendAnalysisTypeEnum.TIME_CORRELATION + " 0.1")
				.close();
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Data Profiling").getNode(0).expand().getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree, "Open");
		bot.editorByTitle(TalendAnalysisTypeEnum.TIME_CORRELATION + " 0.1").setFocus();
		String analysisName = formBot.textWithLabel("Name:").getText();
		System.out.println(analysisName);
		assertEquals(analysisName, TalendAnalysisTypeEnum.TIME_CORRELATION.toString());
		bot.editorByTitle(TalendAnalysisTypeEnum.TIME_CORRELATION + " 0.1").close();
		
		
		
		
		
	}

}
