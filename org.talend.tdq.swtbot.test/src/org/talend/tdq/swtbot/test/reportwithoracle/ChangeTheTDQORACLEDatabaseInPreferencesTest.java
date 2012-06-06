package org.talend.tdq.swtbot.test.reportwithoracle;

import org.junit.Test;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendReportDBType;

public class ChangeTheTDQORACLEDatabaseInPreferencesTest extends TalendSwtbotForTdq{
	
	@Test
	public void ChangeTheTDQORACLEDatabaseInPreferences(){
		TalendSwtbotTdqCommon.setReportDB(bot, TalendReportDBType.Oracle_with_SID);
		
	}

}
