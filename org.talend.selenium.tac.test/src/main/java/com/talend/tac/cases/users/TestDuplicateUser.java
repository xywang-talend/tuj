package com.talend.tac.cases.users;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestDuplicateUser extends Login {
    
	@Test
	@Parameters({"userName","dulicateUser","passWord","dulicatedUser"})
	public void testDuplicateUser(String userName,String dulicateUser,String password,String dulicatedUser) throws Exception {
	    
		this.clickWaitForElementPresent("idMenuUserElement");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent(userName));
		
		if(selenium.isTextPresent("Copy_of_aaa@gmail.com")) {
			System.out.println("Copy_of_aaa@gmail.com is exist");
			selenium.setSpeed(MIN_SPEED);
		} else {
            
			selenium.mouseDown(dulicateUser);//Select an existing user
			selenium.setSpeed(MIN_SPEED);
			selenium.click("idSubModuleDuplicateButton");
			selenium.type("idUserPasswordInput", password);
			selenium.fireEvent("idUserPasswordInput", "blur");
			selenium.click("idUserPasswordInput");

			selenium.click("idFirstAdminConnInput");
			selenium.setSpeed(MID_SPEED);
			selenium.click("idFormSaveButton");
			Assert.assertTrue(selenium.isElementPresent(dulicatedUser));
			selenium.setSpeed(MIN_SPEED);

		}
		
	}
	
}
