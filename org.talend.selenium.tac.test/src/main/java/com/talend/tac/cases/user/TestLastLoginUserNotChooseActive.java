package com.talend.tac.cases.user;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;
@Test(groups={"one"})
public class TestLastLoginUserNotChooseActive extends Login {
	

	@Test
	@Parameters({"userName","userName"})
	public void testLastLoginUserNotChooseActive(String userName,String userName1) throws Exception {
		this.clickWaitForElementPresent("idMenuUserElement");
//		selenium.click("idMenuUserElement");
//		
//		selenium.setSpeed(Base.MIN_SPEED);
		
		Assert.assertTrue(selenium.isTextPresent(userName));
        selenium.mouseDown("//div[text()='"+userName1+"']");
		selenium.click("//input[@name='active']");
		Assert.assertFalse(selenium.isChecked("//input[@name='active']"));
		selenium.click("idFormSaveButton");
		selenium.setSpeed("3000");
		org.testng.Assert.assertTrue(selenium.isTextPresent(rb.getString("user.error.lastActiveAdmin")));
	    selenium.click("//button[text()='" +other.getString("modify.lastUserAdministrator.role.fail")+"']");
	    
	}
	
}