package org.talend.top.swtbot.test.dbconnections;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendItemTypeEnum;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon.TalendMetadataTypeEnum;

@RunWith(SWTBotJunit4ClassRunner.class)
public class EditConnectionInfoTest extends TalendSwtbotForTdq {

	@Before
	public void beforeRunning() {
		TalendSwtbotTdqCommon.createConnection(bot,
				TalendMetadataTypeEnum.MYSQL);
	}

	@Test
	public void editConnectionInfo() {
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString() + " 0.1")
				.show();
		bot.button("Edit...").click();
		bot.waitUntil(Conditions.shellIsActive("Database Connection"));
		bot.button("Next >").click();
		bot.textWithLabel("Login").setText("wrong_login");
		bot.textWithLabel("Password").setText("wrong_pwd");
		bot.textWithLabel("Server").setText("111111111111111");
		bot.button("Check").click();
		bot.sleep(2000);
		bot.captureScreenshot(System
				.getProperty("tdq.analysis.result.screenshot.path")
				+ "editConnectionInfo.jpeg");
		try {
			bot.button("Cancel").click();
		} catch (TimeoutException e) {
		}
		bot.editorByTitle(TalendMetadataTypeEnum.MYSQL.toString() + " 0.1").close();
	}

//	@After
//	public void cleanSource() {
//		TalendSwtbotTdqCommon.deleteSource(bot, TalendItemTypeEnum.METADATA,
//				TalendMetadataTypeEnum.MYSQL.toString());
//	}

}
