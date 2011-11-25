package com.talend.tac.cases.users;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestDuplicateUser extends Login {
    
	@Test
	@Parameters({"userName","DulicateUser","PassWord","DulicatedUser"})
	public void testDuplicateUser(String userName,String DulicateUser,String Password,String DulicatedUser) throws Exception {
	    
		this.clickWaitForElementPresent("idMenuUserElement");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent(userName));
		
		if(selenium.isTextPresent("Copy_of_aaa@gmail.com")) {
			System.out.println("Copy_of_aaa@gmail.com is exist");
			selenium.setSpeed(MIN_SPEED);
		} else {
            
			selenium.mouseDown(DulicateUser);//Select an existing user
			selenium.setSpeed(MIN_SPEED);
			selenium.click("idSubModuleDuplicateButton");
			selenium.type("idUserPasswordInput", Password);
			selenium.fireEvent("idUserPasswordInput", "blur");
			selenium.click("idUserPasswordInput");

			selenium.click("idFirstAdminConnInput");
			selenium.setSpeed(MID_SPEED);
			selenium.click("idFormSaveButton");
			Assert.assertTrue(selenium.isElementPresent(DulicatedUser));
			selenium.setSpeed(MIN_SPEED);

		}
		
	}
	
}
