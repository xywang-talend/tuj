package org.talend.top.swtbot.test.analysis;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendAnalysisTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;

@RunWith(SWTBotJunit4ClassRunner.class)
public class DeleteMenuOnAnaTest extends TalendSwtbotForTdq {

	@Before
	public void beforeRunning() {
		TalendSwtbotTdqCommon
				.createAnalysis(bot, TalendAnalysisTypeEnum.COLUMN);
		bot.editorByTitle(TalendAnalysisTypeEnum.COLUMN.toString() + " 0.1")
				.close();
	}

//	@Test
//	public void deleteAnalysis() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.ANALYSIS,
//				TalendAnalysisTypeEnum.COLUMN.toString());
//	}

}
