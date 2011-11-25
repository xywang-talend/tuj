package org.talend.tac.cases.userSettings;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import com.talend.tac.cases.Login;

public class TestUserSettings extends Login {
	@Test
	@Parameters( { "userName" ,"userSetting.CurrentUser.newSvnLogin","userSetting.CurrentUser.newSvnPasswd"})
	public void testChangeSVNaCCOUNT(String CurrentLoginName,String newSvnLogin,String newSvnPasswd) {

		this.clickWaitForElementPresent("idMenuChangePasswordElement");
		selenium.type("idChangePwdSvnLoginInput", newSvnLogin);
		selenium.type("idChangePwdSvnPasswdInput", newSvnPasswd);
		selenium.click("idChangePwdSaveButton");
		selenium.click("idMenuUserElement");
		this.waitForElementPresent("//div[text()='"+ CurrentLoginName + "']", WAIT_TIME);
		selenium.mouseDown("//div[text()='"+ CurrentLoginName + "']");
		assertEquals(selenium.getValue("idSvnLogin"), newSvnLogin);
		
	}

	@Test
	@Parameters( { "userSetting.currentUser.newPasswd" })
	public void testChangePasswdOfCurrentUser(String newPasswd) {

		doModify(newPasswd);
		// change password back to avoid conflict with other cases
		doModify("admin");
	}

	public void doModify(String newPasswd) {
		this.waitForElementPresent("idMenuChangePasswordElement", 30);
		assertTrue(selenium.isElementPresent("idMenuChangePasswordElement"));
		selenium.click("idMenuChangePasswordElement");
		this.waitForElementPresent("idChangePwdNewPwdInput", 30);
		selenium.type("idChangePwdNewPwdInput", newPasswd);
		this.waitForElementPresent("idChangePwdConfirmPwdInput", 30);
		selenium.type("idChangePwdConfirmPwdInput", newPasswd);
		// simulate pressing ENTER to enable button "validate"
		selenium.keyDown("idChangePwdNewPwdInput", "\\13");
		selenium.keyUp("idChangePwdNewPwdInput", "\\13");
		this.waitForElementPresent("idChangePwdValidateButton", 30);
		selenium.click("idChangePwdValidateButton");
//		assertTrue(selenium.isTextPresent(rb.getString("password.ok")));
	}
}