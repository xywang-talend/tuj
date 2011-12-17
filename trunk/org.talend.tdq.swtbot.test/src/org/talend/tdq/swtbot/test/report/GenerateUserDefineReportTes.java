package org.talend.tdq.swtbot.test.report;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportDBType;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

public class GenerateUserDefineReportTes extends TalendSwtbotForTdq{
//	private final String REPORTLABEL = "REPORT_Userdefine";
	
	@Before
	public void beforeClass(){
		TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.MySQL);
		TalendSwtbotTdqCommon.createConnection(bot, TalendMetadataTypeEnum.MYSQL);
		
		//TalendSwtbotTdqCommon.createAnalysis(bot, analysisType)
		
	}
    @Test
    public void generateUserDefineReport(){
    	
    }
    @After
    public void afterClass(){
    	
    }
}
