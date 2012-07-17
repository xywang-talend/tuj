package org.talend.top.swtbot.test.analysis.columnanalysis;

import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class ColumnAnlaysisAboutOracleDbconnectionTest extends TalendSwtbotForTdq{
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.ORACLE);
		
		bot.editorByTitle(TalendMetadataTypeEnum.ORACLE.toString() + " 0.1")
				.close();
		TalendSwtbotTdqCommon
		.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);
		
	}
	
	@Test
	public void ColumnAnlaysisAboutOracleDbconnection(){
		
		
		
	}
}
