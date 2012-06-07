package org.talend.tac.cases.userSettings;

import java.awt.Event;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class TestUserSettings extends Login {
	@Test
	@Parameters( { "userName" ,"userSettingCurrentUserNewSvnLogin","userSettingCurrentUserNewSvnPasswd","svnConfServerUser","svnConfServerPassword"})
	public void testChangeSVNaCCOUNT(String CurrentLoginName,String newSvnLogin,String newSvnPasswd,String svnConfUser,String svnConfPass) {

		this.clickWaitForElementPresent("idMenuChangePasswordElement");
		selenium.type("idChangePwdSvnLoginInput", newSvnLogin);
		selenium.type("idChangePwdSvnPasswdInput", newSvnPasswd);
		selenium.click("idChangePwdSaveButton");
		this.waitForTextPresent("Svn account change", WAIT_TIME);
		selenium.click("idMenuUserElement");
		this.waitForElementPresent("//div[text()='"+ CurrentLoginName + "']", WAIT_TIME);
		selenium.mouseDown("//div[text()='"+ CurrentLoginName + "']");
		assertEquals(selenium.getValue("idSvnLogin"), newSvnLogin);
		
		this.clickWaitForElementPresent("idMenuChangePasswordElement");
		selenium.type("idChangePwdSvnLoginInput", svnConfUser);
		selenium.type("idChangePwdSvnPasswdInput", svnConfPass);
		selenium.click("idChangePwdSaveButton");
		this.waitForTextPresent("Svn account change", WAIT_TIME);
		selenium.click("idMenuUserElement");
		selenium.refresh();
		this.waitForElementPresent("//div[text()='"+ CurrentLoginName + "']", WAIT_TIME);
		selenium.mouseDown("//div[text()='"+ CurrentLoginName + "']");
		assertEquals(selenium.getValue("idSvnLogin"), svnConfUser);
		
	}

	@Test
	@Parameters( {"userName","userPassword", "userSettingCurrentUserNewPasswd" })
	public void testChangePasswdOfCurrentUser(String user,String pass,String newPasswd) {

		doModify(newPasswd);
		selenium.click("idLeftMenuTreeLogoutButton");
		this.waitForElementPresent("idLoginButton", MAX_WAIT_TIME);
		this.waitForElementPresent("idLoginInput", WAIT_TIME);
		selenium.type("idLoginInput", user);
		
		String pwValue = selenium.getValue("idLoginPasswordInput");
		selenium.typeKeys("idLoginPasswordInput", newPasswd);
		selenium.type("idLoginPasswordInput", newPasswd);
		selenium.keyPressNative(Event.TAB +"");
		this.waitForElementPresent("idLoginInput", Base.WAIT_TIME);
		selenium.click("idLoginButton");
		selenium.setSpeed(MID_SPEED);
		if (selenium
				.isTextPresent("Failed to log on: user admin@company.com already logged on to webapp")) {
			selenium.click("idLoginForceLogoutButton");
			selenium.click("idLoginButton");
		}
		selenium.setSpeed(MIN_SPEED);
		this.waitForElementPresent("idMenuChangePasswordElement",WAIT_TIME);
		// change password back to avoid conflict with other cases
		doModify(pass);
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
		assertTrue(this.waitForTextPresent(rb.getString("password.ok"),WAIT_TIME));
	}
}