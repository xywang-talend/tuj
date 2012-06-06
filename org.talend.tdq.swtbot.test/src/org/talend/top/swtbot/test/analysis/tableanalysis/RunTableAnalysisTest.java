package org.talend.top.swtbot.test.analysis.tableanalysis;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withMnemonic;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withTooltip;

import java.util.ArrayList;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotLabel;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.SWTBotLabelExt;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class RunTableAnalysisTest extends TalendSwtbotForTdq{
	
	private final String DQRULENAME = "dqrule1";

	private final String RULEEXPRESSION = "customer_id>2500";
	
	@Before
	public void beforeClass(){
		
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString()+" 0.1").close();
		TalendSwtbotTdqCommon
				.createAnalysis(bot, TalendAnalysisTypeEnum.DQRULE);
		TalendSwtbotTdqCommon.createDQRule(bot, DQRULENAME, RULEEXPRESSION);
		
		
	}
	@SuppressWarnings("unchecked")
	@Test
	public void RunTableAnalysis(){
		bot.editorByTitle(TalendAnalysisTypeEnum.DQRULE.toString() + " 0.1")
		.show();
		formBot.hyperlink("Select tables/views to analyze").click();
		bot.waitUntil(Conditions.shellIsActive("Table/view Selection"));
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("DB connections",
		TalendMetadataTypeEnum.MYSQL.toString(), "tbi").getNode(0)
			.select();
		bot.table().getTableItem("customer").check();
		bot.button("OK").click();
		bot.editorByTitle(TalendAnalysisTypeEnum.DQRULE.toString() + " 0.1")
			.setFocus();
		formBot.section("Analyzed Tables and views").setFocus();		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		Matcher matcher = allOf(widgetOfType(Label.class), withTooltip("add dq rule"));
//		ArrayList l =(ArrayList) formBot.widgets(matcher);	
		new SWTBotLabelExt(new SWTBotLabel((Label)formBot.widget(matcher))).click();
		try {
			bot.waitUntil(Conditions.shellIsActive("DQ Rule Selector"));
		} catch (TimeoutException e) {
		}
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Rules", "SQL").getNode(DQRULENAME).check();
		bot.button("OK").click();
		bot.editorByTitle(TalendAnalysisTypeEnum.DQRULE.toString() + " 0.1")
			.save();
		bot.toolbarButtonWithTooltip("Run").click();
		try {
			bot.waitUntil(Conditions.shellCloses(bot.shell("Run Analysis")));
		} catch (TimeoutException e) {
		}

		bot.editorByTitle(TalendAnalysisTypeEnum.DQRULE.toString()+" 0.1").close();
		
		
	}

}
