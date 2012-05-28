package com.talend.tac.cases.users;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class ClearUser extends Users {
	@Test
//	(dependsOnGroups={"ModifyUser"})
	@Parameters({"userName","_FirstName","_LastName", "LoginNameChooseTypeDataQuality"
		, "ModifiyUserName", "UncheckActiveUser", "importUserName"})
	public void clearUsers(String userName,String FirstName,String LastName, 
			String loginNameChooseTypeDataQuality, String modifiyUserName,
			String UncheckActiveUser, String importUserName) throws Exception {
   
		 this.clickWaitForElementPresent("idMenuUserElement");
		 
		 this.waitForElementPresent("//div[text()='"+userName+"']", WAIT_TIME);	    
	     selenium.mouseDown("//div[text()='"+userName+"']");//Select Login user
		 selenium.setSpeed(MAX_SPEED);
		 selenium.type("idUserFirstNameInput", FirstName);
		 selenium.fireEvent("idUserFirstNameInput", "blur");
		 selenium.type("idUserLastNameInput", LastName);
		 selenium.fireEvent("idUserLastNameInput", "blur");
		 selenium.setSpeed(MAX_SPEED);
		 selenium.click("idFormSaveButton");
	     selenium.setSpeed(MIN_SPEED);
	     
	     this.deleteUser(userName, loginNameChooseTypeDataQuality);
	     this.deleteUser(userName, modifiyUserName);
	     this.deleteUser(userName, UncheckActiveUser);
	     this.deleteUser(userName, importUserName);
	
	}
	
	
}

