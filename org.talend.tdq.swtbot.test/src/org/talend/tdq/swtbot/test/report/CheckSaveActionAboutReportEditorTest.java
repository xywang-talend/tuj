package org.talend.tdq.swtbot.test.report;

import junit.framework.Assert;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportDBType;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportTemplate;

public class CheckSaveActionAboutReportEditorTest extends TalendSwtbotForTdq {
	private final String REPORTLABEL = "report_CheckSaveAction";

	@Before
	public void beforeClass() {
		bot.menu("Window").menu("Show view...").click();
		bot.waitUntil(Conditions.shellIsActive("Show View"));
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("General").select("Error Log");
		bot.button("OK").click();
		TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.MySQL);
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString() + " 0.1")
				.close();
		TalendSwtbotTdqCommon
				.createAnalysis(bot, TalendAnalysisTypeEnum.CONNECTION,
						TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendAnalysisTypeEnum.CONNECTION.toString() + " 0.1")
				.close();

	}

	@Test
	public void checkSaveActionAboutReportEditor() {
		TalendSwtbotTdqCommon.createReport(bot, REPORTLABEL);
		TalendSwtbotTdqCommon.generateReport(bot, formBot, REPORTLABEL,
				TalendReportTemplate.Basic,
				TalendAnalysisTypeEnum.CONNECTION.toString());
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		
			tree.expandNode("Data Profiling").getNode(1).expand().getNode(0).select();
	//				.select(REPORTLABEL + " 0.1");
			ContextMenuHelper.clickContextMenu(tree, "Open Report");
		
		bot.editorByTitle(REPORTLABEL + " 0.1").show();
		formBot.textWithLabel("Name:").setText("movename");
		formBot.textWithLabel("Purpose:").setText("modify");
		bot.editorByTitle(REPORTLABEL + " 0.1").close();
	//	bot.sleep(10000);
	//	bot.button("No").click();
		//formBot.button("No").click();
	//	bot.sleep(10000);
	// bot.waitUntil(Conditions.shellCloses(shell));
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		
			tree.expandNode("Data Profiling").getNode(1).expand()
					.select(REPORTLABEL + " 0.1");
			ContextMenuHelper.clickContextMenu(tree, "Open Report");
		bot.sleep(5000);
		bot.editorByTitle(REPORTLABEL + " 0.1").show();
		Assert.assertEquals(REPORTLABEL, formBot.textWithLabel("Name:")
				.getText());
		Assert.assertEquals("", formBot.textWithLabel("Purpose:").getText());
		bot.editorByTitle(REPORTLABEL + " 0.1").close();

	}

//	@After
//	public void afterClass() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.REPORT,
//				REPORTLABEL);
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.CONNECTION.toString());
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//
//	}

}
