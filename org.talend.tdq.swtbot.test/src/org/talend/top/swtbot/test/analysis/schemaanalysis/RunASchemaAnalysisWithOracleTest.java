package org.talend.top.swtbot.test.analysis.schemaanalysis;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class RunASchemaAnalysisWithOracleTest extends TalendSwtbotForTdq{
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.ORACLE);	
	}
	@Test
	public void RunASchemaAnalysisWithOracle(){
		TalendSwtbotTdqCommon.createAnalysis(bot,
				TalendAnalysisTypeEnum.SCHEMA, TalendMetadataTypeEnum.ORACLE);
		bot.editorByTitle(TalendMetadataTypeEnum.ORACLE.toString()+" 0.1").close();

		bot.viewByTitle("DQ Repository").setFocus();
		bot.toolbarButtonWithTooltip("Refresh").click();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		SWTBotTreeItem analysisItem = tree.expandNode("Data Profiling")
				.getNode(0).expand()
				.select(TalendAnalysisTypeEnum.SCHEMA.toString() + " 0.1");
		Assert.assertNotNull(analysisItem);
		bot.editorByTitle(TalendAnalysisTypeEnum.SCHEMA.toString()+" 0.1").close();
		
	}
	

}
