package com.talend.tac.cases.users;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class ClearUser extends Login{
  
	@Test
//	(dependsOnGroups={"ModifyUser"})
	@Parameters({"userName","_FirstName","_LastName"})
	public void clearUsers(String userName,String FirstName,String LastName) throws Exception {
   
		 this.clickWaitForElementPresent("idMenuUserElement");
			    
	     selenium.mouseDown("//div[text()='"+userName+"']");//Select Login user
		 selenium.setSpeed(MAX_SPEED);
		 selenium.type("idUserFirstNameInput", FirstName);
		 selenium.fireEvent("idUserFirstNameInput", "blur");
		 selenium.type("idUserLastNameInput", LastName);
		 selenium.fireEvent("idUserLastNameInput", "blur");
		 selenium.setSpeed(MAX_SPEED);
		 selenium.click("idFormSaveButton");
	     selenium.setSpeed(MIN_SPEED);
	
	}
	
	
}

