package com.talend.tac.cases.menu;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.talend.tac.cases.Login;

public class TestAuthorizeAllRolesToAdmin extends Login {
	public void sleep(int times) {
		try {
			Thread.sleep(times);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		@Test
		public void testAuthorizeAllRoles(){
		//authorize all roles to admin
		this.clickWaitForElementPresent("idMenuUserElement");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']",
				WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']");
	    this.sleep(2000);
	    selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.setSpeed(MID_SPEED);
		selenium.click("//div[@class=' x-grid3-hd-inner x-grid3-hd-checker x-component']");
		selenium.click("idValidateButton");
		selenium.click("idFormSaveButton");
        selenium.setSpeed(MIN_SPEED);
        this.waitForElementPresent("//div[@class='x-grid-group-div' and text()='Role: Administrator/Viewer/Operation manager/Designer (1 Member)']", WAIT_TIME);
        
	}


}
