package org.talend.top.swtbot.test.analysis.columnanalysis;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
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
public class DefaultValueOnMsSQLTest extends TalendSwtbotForTdq {

	@Before
	public void beforeRunning() {
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MSSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MSSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon
				.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);
	}

	@Test
	public void defaultValueOnMssql() {
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));

		String defValTable = "";
		String defValColumn = "";
		String defColumn = "";
		SWTBotTreeItem itemTables = tree.expandNode("Metadata",
				"DB connections", TalendMetadataTypeEnum.MSSQL.toString(),
				System.getProperty("mssql.dbname"), "dbo").getNode(0);
		itemTables.expand();
		int tableCount = itemTables.getItems().length;
		if (tableCount != 0) {
			boolean defValFound = false;
			if (!defValFound) {
				for (int i = 0; i < tableCount; i++) {
					SWTBotTreeItem table = itemTables.getNode(i);
					System.out.println("Table - " + table.getText());
					SWTBotTreeItem itemColumns = table.expand().getNode(0);
					System.out.println("Column - " + itemColumns.getText());

					SWTBotTreeItem[] columns = itemColumns.expand().getItems();
					
					for(SWTBotTreeItem column : columns) {
						System.out.println(" columns sss - : " + column.getText());
					}
					
					
					for (int j = 0; j < columns.length; j++) {
						System.out.println(" - " + j + ": " + columns[j].getText());
						itemColumns.select(columns[j].getText());
						bot.viewByTitle("Detail View").setFocus();
						String defVal = bot.textWithLabel("Default value:")
								.getText();
						if (!defVal.equals("none")) {
							defValColumn = defVal;
							defValTable = itemTables.getNode(i).getText();
							defColumn = columns[j].getText();
							defValFound = true;
							break;
						}
						bot.viewByTitle("DQ Repository").setFocus();
					}
				}
			}
		}

		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
				.show();
		formBot.hyperlink("Select columns to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Column Selection"));
		SWTBotShell shell = bot.shell("Column Selection");
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		
		System.out.println("defaultTable = " + defValTable);
		System.out.println("defaultColumn = " + defValColumn);
		System.out.println("defaultColumn = " + defColumn);
		
		tree.expandNode(System.getProperty("mssql.dbname")).expand().getNode("dbo").expand().getNode(0).expand()
				.select(defValTable);
//		bot.table().getTableItem(defValColumn).check();
		bot.table().getTableItem(defColumn).check();
		bot.button("OK").click();
		bot.waitUntil(Conditions.shellCloses(shell));
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
				.save();
		formBot.hyperlink("Select indicators for each column").click();
		bot.waitUntil(Conditions.shellIsActive("Indicator Selection"));
		shell = bot.shell("Indicator Selection");
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Simple Statistics").select("Default Value Count")
				.click(1);
		bot.checkBox(7).click();
		bot.button("OK").click();
		bot.waitUntil(Conditions.shellCloses(shell));
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
				.save();
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			bot.waitUntil(Conditions.shellCloses(bot.shell("Run Analysis")));
		} catch (Exception e) {
		}
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString()+" 0.1").close();
		// need assert the default value of column
		
	}

//	@After
//	public void cleanSource() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.COLUMN.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MSSQL.toString());
//	}

}
