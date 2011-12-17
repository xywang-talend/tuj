package com.talend.tac.cases.user;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.talend.tac.cases.Login;


@Test(groups={"one"})
public class TestUserChooseAllRole extends Login {
    
	@Test
	@Parameters({"userName","userName"})
	public void testUserChooseAllRole(String userName,String userName1) throws Exception {
		
		this.clickWaitForElementPresent("idMenuUserElement");
		
		Assert.assertTrue(selenium.isTextPresent(userName));
		selenium.mouseDown("//div[text()='"+userName1+"']");//Select Login user
		selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.setSpeed(MID_SPEED);
		selenium.click("//div[@class=' x-grid3-hd-inner x-grid3-hd-checker x-component']");
		selenium.click("idValidateButton");
		selenium.click("idFormSaveButton");
        selenium.setSpeed(MIN_SPEED);
        
	}
	
}
