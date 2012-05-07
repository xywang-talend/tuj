package org.talend.top.swtbot.test.analysis.columnsetanalysis;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withMnemonic;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotLabel;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.DndUtil;
import org.talend.swtbot.test.commons.SWTBotLabelExt;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class DataFilterOnTheColumnSetAnalysisTest extends TalendSwtbotForTdq {

	@Before
	public void beforeClass() {
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString() + " 0.1")
				.close();
		TalendSwtbotTdqCommon.createAnalysis(bot,
				TalendAnalysisTypeEnum.COLUMNSET);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void dataFilterOnTheColumnSetAnalysis() {
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMNSET.toString() + " 0.1")
				.show();
		formBot.ccomboBox(2).setSelection("Java");
		bot.toolbarButtonWithTooltip("Save").click();
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("tbi").getNode(0).expand().select("customer");
		String[] columns = TalendSwtbotTdqCommon.getColumns(bot,
				TalendMetadataTypeEnum.MYSQL, "tbi", "customer", "birthdate",
				"lname");
		bot.table().getTableItem(columns[0]).check();
		bot.table().getTableItem(columns[1]).check();
		bot.button("OK").click();
		formBot.ccomboBox(1).setSelection("Interval");
		formBot.ccomboBox(2).setSelection("Nominal");
		// target
		formBot.section("Analyzed Columns").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.editorByTitle(
						TalendAnalysisTypeEnum.COLUMNSET.toString() + " 0.1")
						.getWidget()));
		// System.out.println(tree.getAllItems()[0].getText());
		System.out.println(tree.getAllItems()[0].getText());
		System.out.println(tree.getAllItems()[1].getText());
		// bot.sleep(20000);
		String col1 = columns[0].substring(0, columns[0].indexOf("(")) + " "
				+ columns[0].substring(columns[0].indexOf("("));
		String col2 = columns[1].substring(0, columns[1].indexOf("(")) + " "
				+ columns[1].substring(columns[1].indexOf("("));
		SWTBotTreeItem targetItem = tree.expandNode(col1).select();
		SWTBotTreeItem targetItem2 = tree.expandNode(col2).select();
		// source
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		SWTBotView view = bot.viewByTitle("DQ Repository");
		SWTBotTreeItem source = tree
				.expandNode("Libraries", "Patterns", "Regex").getNode(3)
				.expand().getNode(3).select();
		SWTBotTreeItem source2 = tree
				.expandNode("Libraries", "Patterns", "Regex").getNode(3)
				.expand().getNode(2).select();
		DndUtil dndUtil = new DndUtil(view.getWidget().getDisplay());
		dndUtil.dragAndDrop(source, targetItem);
		bot.sleep(5000);
		dndUtil.dragAndDrop(source, targetItem2);
		bot.sleep(5000);
		dndUtil.dragAndDrop(source2, targetItem);
		bot.sleep(5000);
		dndUtil.dragAndDrop(source2, targetItem2);
		bot.sleep(5000);
		bot.toolbarButtonWithTooltip("Save").click();
		bot.toolbarButtonWithTooltip("Run").click();
		bot.cTabItem("Analysis Results").activate();
		formBot.section("Analysis Result").setFocus();
		// Matcher matcher = withMnemonic("Data");
		bot.sleep(10000);
		SWTBotEditor ed = bot.editorByTitle(TalendAnalysisTypeEnum.COLUMNSET
				.toString() + " 0.1");
		Matcher matcher = allOf(withMnemonic("Data"),WidgetOfType.widgetOfType(Label.class));
		SWTBotLabel label = new SWTBotLabel((Label) formBot.widget(
				matcher, ed.getWidget()));
		SWTBotLabelExt Label1 = new SWTBotLabelExt(label);
		Label1.click();
		formBot.button("Filter Data").click();
		bot.waitUntil(Conditions
				.shellIsActive("Select pattern to filter the data of table"));
		// SWTBotShell shell =
		// bot.shell("Select pattern to filter the data of table");
		// shell.getText();
		// bot.table().getTableItem(0).check();
		// GridLayout grid = new GridLayout();
		// grid.numColumns=1;

		Display display = new Display();
		Shell shello = new Shell(display);
		shello.getLayout();
		System.out.println("aaaaaaaaaaa" + shello.getLayoutData().toString()
				+ "bbbbbb");
		GridLayout gridLayout = new GridLayout();
		// shello.setLayout(gridLayout);

		// shello.getTabList();

		// bot.checkBox(0).click();
		// bot.table().cell(row, column)
		bot.button("All data").click();
		bot.button("Finish").click();
		SWTBotShell shell = bot
				.shell("Select pattern to filter the data of table");
		try {
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		}

		bot.sleep(10000);

		/*
		 * Matcher matcher = withMnemonic("Name"); SWTBotLabel label = new
		 * SWTBotLabel((Label) gefBot.widget(matcher, view.getWidget()));
		 * filterLabel = new SWTBotLabelExt(label); filterLabel.rightClick()
		 */
		// formBot.expandBarWithLabel("Analysis Result").expandItem("Data").setFocus();
		// formBot.expandBar(1).expandItem("Data").setFocus();

		// formBot.
		// bot.sleep(20000);
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMNSET.toString() + " 0.1")
				.close();

	}

//	@After
//	public void afterClass() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.COLUMNSET.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//
//	}

}
