package org.talend.top.swtbot.test.analysis.columnanalysis;

import junit.framework.Assert;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
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
public class ColumnMoveUpDownRemoveTest extends TalendSwtbotForTdq {

	@Before
	public void beforeRunning() {
		bot.sleep(20000);
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon
				.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);
	}

	@Test
	public void columnMoveUpDownRemove() {
		String[] columns = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "address1",
				"address2", "address3", "address4", "city");
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
				.show();
		formBot.section("Analyzed Columns").setFocus();
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		bot.table().getTableItem(columns[0]).check();
		bot.table().getTableItem(columns[1]).check();
		bot.table().getTableItem(columns[2]).check();
		bot.table().getTableItem(columns[3]).check();
		bot.table().getTableItem(columns[4]).check();
		bot.button("OK").click();
		if (bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
				.isDirty())
			bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
					.save();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.editorByTitle(
						TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
						.getWidget()));
		String col1 = columns[0].substring(0, columns[0].indexOf("(")) + " "
				+ columns[0].substring(columns[0].indexOf("("));
		String col2 = columns[1].substring(0, columns[1].indexOf("(")) + " "
				+ columns[1].substring(columns[1].indexOf("("));
		String col3 = columns[2].substring(0, columns[2].indexOf("(")) + " "
				+ columns[2].substring(columns[2].indexOf("("));
		String col4 = columns[3].substring(0, columns[3].indexOf("(")) + " "
				+ columns[3].substring(columns[3].indexOf("("));
		String col5 = columns[4].substring(0, columns[4].indexOf("(")) + " "
				+ columns[4].substring(columns[4].indexOf("("));
		tree.select(col1);
		bot.button("Move Down").click();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.editorByTitle(
						TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
						.getWidget()));
		tree.select(col4);
		bot.button("Move Up").click();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.editorByTitle(
						TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
						.getWidget()));
		tree.select(col5);
		formBot.button(0).click();
//		formBot.button(2).click();
		if (bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
				.isDirty())
			bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
					.save();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.editorByTitle(
						TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
						.getWidget()));
		SWTBotTreeItem[] items = tree.getAllItems();
		Assert.assertEquals(4, items.length);
		Assert.assertTrue(items[0].getText().equals(col2));
		Assert.assertTrue(items[1].getText().equals(col1));
		Assert.assertTrue(items[2].getText().equals(col4));
		Assert.assertTrue(items[3].getText().equals(col3));
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").close();
	}

//	@After
//	public void cleanSource() {
////		TalendSwtbotTdqCommon.deleteAndCleanCycleBin(bot, TalendItemTypeEnum.ANALYSIS,
////				TalendAnalysisTypeEnum.COLUMN.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//			TalendAnalysisTypeEnum.COLUMN.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//	}
}
