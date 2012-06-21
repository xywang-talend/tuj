package com.talend.tac.cases;

import java.awt.Event;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.talend.tac.base.Base;

public class Login extends Base {

	@BeforeMethod
	@Parameters( { "userName", "userPassword" })
	public void login(String user, String password) {

//		selenium.setSpeed(MID_SPEED);
		
		selenium.windowMaximize();
		this.waitForElementPresent("idLoginInput", WAIT_TIME);
		selenium.type("idLoginInput", user);
		
		String pwValue = selenium.getValue("idLoginPasswordInput");
		if( pwValue==null || "".equals(pwValue) ) {
			selenium.typeKeys("idLoginPasswordInput", password);
			selenium.type("idLoginPasswordInput", password);
		} 
		selenium.click("idLoginPasswordInput");
		selenium.keyPressNative(Event.TAB +"");
		selenium.keyUpNative(Event.TAB +"");
		this.waitForElementPresent("idLoginInput", Base.WAIT_TIME);
		selenium.click("idLoginButton");
		selenium.setSpeed(MID_SPEED);
		if (selenium
				.isTextPresent("Failed to log on: user admin@company.com already logged on to webapp")) {
			selenium.click("idLoginForceLogoutButton");
			selenium.click("idLoginButton");
		}
		selenium.setSpeed(MIN_SPEED);
		// selenium.waitForPageToLoad("30000");// no need
	}

	@AfterMethod
	public void logout() {
		selenium.click("idLeftMenuTreeLogoutButton");
		this.waitForElementPresent("idLoginButton", MAX_WAIT_TIME);
		// selenium.stop();
	}

	@AfterClass
	public void killBroswer() {
		selenium.stop();
	}

}
