package org.talend.top.swtbot.test.analysis.columnanalysis;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.DndUtil;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendIndicatorLanguage;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

@RunWith(SWTBotJunit4ClassRunner.class)
public class ColumnAnaWithUDITest extends TalendSwtbotForTdq {

	private final String UDINAME = "UserDefine1";

	private final String TEMPLATEEXPRESSION = "SELECT COUNT(*) FROM <%=__TABLE_NAME__%> <%=__WHERE_CLAUSE__%>";

	@Before
	public void beforeRunning() {
		bot.sleep(10000);
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon.createUDI(bot, TalendIndicatorLanguage.Default,
				UDINAME, TEMPLATEEXPRESSION);
		bot.editorByTitle("User Defined Indicators/UserDefine1").close();
		TalendSwtbotTdqCommon
				.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);
	}

	@Test
	public void columnAnaWithUDI() {
		String column = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "address1")[0];
		 String col = column.substring(0, column.indexOf("(")) + " "
		    + column.substring(column.indexOf("("));
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
				.show();
		formBot.section("Analyzed Columns").setFocus();
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		bot.table().getTableItem(column).check();
		bot.button("OK").click();
		
		bot.ccomboBox(1).setSelection("Nominal");
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.editorByTitle(
						TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
						.getWidget()));
		SWTBotTreeItem targetItem = tree.getTreeItem(col).click(2);
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		SWTBotView view = bot.viewByTitle("DQ Repository");
		SWTBotTreeItem source = tree.expandNode("Libraries","Indicators").getNode(1).expand()
		.getNode(0).select();
		DndUtil dndUtil = new DndUtil(view.getWidget().getDisplay());
		dndUtil.dragAndDrop(source, targetItem);
		source.click();
		targetItem.click();
		dndUtil.dragAndDrop(source, targetItem);
	
		bot.sleep(2000);
		bot.captureScreenshot(System
				.getProperty("tdq.analysis.result.screenshot.path")
				+ "dragudiagain.jpeg");
		try {
			bot.waitUntil(Conditions.shellIsActive("Warning"));
		} catch (Exception e) {
			
		}
		SWTBotShell shell = bot.shell("Warning");
		bot.button("OK").click();
		try {
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		}
		
		
		bot.toolbarButtonWithTooltip("Save").click();
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
			
		}
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").close();
		
//		if (bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
//				.isDirty())
//			bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
//					.save();
		/*
		
		SWTBotTreeItem source = tree.expandNode("Libraries","Indicators").getNode(1).expand()
		.getNode(0).select();
		DndUtil dndUtil = new DndUtil(view.getWidget().getDisplay());
		dndUtil.dragAndDrop(source, targetItem);
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			shell = bot.shell("Run Analysis");
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
			
		}
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").close();
		
		

  String col = column.substring(0, column.indexOf("(")) + " "
    + column.substring(column.indexOf("("));
  tree.getTreeItem(col).click(3);
  if (bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
    .isDirty())
   bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
     .save();
		 */
	}

//	@After
//	public void cleanSource() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.COLUMN.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.LIBRARY_UDI,
//				UDINAME);
//		
////		bot.viewByTitle("DQ Repository").setFocus();
////		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
////				WidgetOfType.widgetOfType(Tree.class),
////				bot.viewByTitle("DQ Repository").getWidget()));
////		tree.expandNode("Libraries","Indicators").getNode(1).expand()
////		.getNode(0).select();
////		ContextMenuHelper.clickContextMenu(tree, "Delete");
////		try {
////			SWTBotShell shell = bot.shell("refresh");
////			bot.waitUntil(Conditions.shellCloses(shell));
////		} catch (Exception e) {
////		
////		}
////		Assert.assertNotNull(tree.expandNode("Recycle Bin").select(UDINAME));
////		tree.expandNode("Recycle Bin").select(UDINAME);
////		ContextMenuHelper.clickContextMenu(tree, "Delete");
////		try {
////			bot.waitUntil(Conditions.shellIsActive("Delete forever"));
////		} catch (Exception e) {
////			
////		}
////		SWTBotShell shell = bot.shell("Delete forever");
////		bot.button("Yes").click();
////		try {
////			bot.waitUntil(Conditions.shellCloses(shell));
////		} catch (Exception e) {
////		}
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//	}
}
