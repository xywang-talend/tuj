package com.talend.tac.cases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;

public class TestForgetPassword extends Base {

	@Test(description = "test changePassword using adminRole user created before.")
	@Parameters( { "user.admin.login", "user.admin.passwd" })
	public void testForgetPassword(String userName,String userPassword){
		selenium.windowMaximize();
		this.waitForElementPresent("idForgetButton", WAIT_TIME);
		//no login typed,click "forget your password" button
		selenium.click("idForgetButton");
		this.waitForElementPresent("//div[text()='"+other.getString("login.forgetPasswd.changePasswdFailed") +"']", WAIT_TIME);
		//type login, then click "forget your password" button
		selenium.type("idLoginInput", userName);
		selenium.typeKeys("idLoginPasswordInput", userPassword);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.click("idForgetButton");
		this.waitForElementPresent("//div[text()='" +other.getString("login.forgetPasswd.changePasswdSuccessfully") + "']", WAIT_TIME);
		selenium.click("idLoginButton");
		this.waitForElementPresent("//div[text()='"+ rb.getString("login.error.badPassword") + "']", WAIT_TIME);//Incorrect password
	}

	@AfterTest
	public void killBrowser() {
		selenium.stop();
	}

}
