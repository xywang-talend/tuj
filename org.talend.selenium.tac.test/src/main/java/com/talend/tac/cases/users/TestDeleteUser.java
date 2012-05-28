package com.talend.tac.cases.users;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDeleteUser extends Users {
    
	
	@Test
	@Parameters({"userName","LoginNameChooseAdministratorRole"})
	public void testCancleDeleteUser(String userName,String deleteUser) throws Exception {
		this.clickWaitForElementPresent("idMenuUserElement");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent(userName));
		selenium.setSpeed(MIN_SPEED);
		selenium.mouseDown("//div[text()='"+deleteUser+"']");//Select an existing user
		selenium.chooseCancelOnNextConfirmation();
		selenium.click("idSubModuleDeleteButton");
		selenium.getConfirmation().contains("you sure you want to remove the selected user");
		selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[text()='"+deleteUser+"']"));
		selenium.setSpeed(MIN_SPEED);
	    
	}
	
	@Test
	@Parameters({"userName","LoginNameChooseAdministratorRole"})
	public void testDeleteUser(String userName,String deleteUser) throws Exception {
		deleteUser(userName, deleteUser);
		selenium.setSpeed(MID_SPEED);
	    Assert.assertFalse(selenium.isElementPresent("//div[text()='"+deleteUser+"']"));
        selenium.setSpeed(MIN_SPEED);  
	    
	}
    
	
	@Test
	@Parameters({"userName","userNameAllRoles"})
	public void testDeleteAllRoleUser(String userName,String deleteUser) throws Exception {
		deleteUser(userName, deleteUser);
		selenium.setSpeed(MID_SPEED);
	    Assert.assertFalse(selenium.isElementPresent("//div[text()='"+deleteUser+"']"));
        selenium.setSpeed(MIN_SPEED);  
	    
	}
	
	@Test
	@Parameters({"userName"})
	public void testDeleteLoginUser(String userName) throws Exception {
		this.clickWaitForElementPresent("idMenuUserElement");
		this.waitForElementPresent("//div[text()='"+userName+"']", WAIT_TIME);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(selenium.isElementPresent("//div[text()='"+userName+"']")) {
			
			selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isTextPresent(userName));
			selenium.setSpeed(MIN_SPEED);
			selenium.mouseDown("//div[text()='"+userName+"']");//Select an existing user
			selenium.chooseOkOnNextConfirmation();
			selenium.click("idSubModuleDeleteButton");
			selenium.getConfirmation().contains("you sure you want to remove the selected user");
		
        selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.error.deleteCurrentLoggedUser")));
        selenium.setSpeed(MIN_SPEED);  	
        
		}
		
	}
}
