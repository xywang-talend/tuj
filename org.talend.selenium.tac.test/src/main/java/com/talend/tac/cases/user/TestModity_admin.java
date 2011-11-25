package com.talend.tac.cases.user;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.talend.tac.cases.Login;
@Test(groups={"one"})
public class TestModity_admin extends Login {
    
	@Test
	@Parameters({"userName","userName","_FristName","_LastName"})
	public void testModity_admin(String userName,String userName1, String FirstName,String LastName) throws Exception {
		this.clickWaitForElementPresent("idMenuUserElement");
//		selenium.click("idMenuUserElement");
//		
//		
//		selenium.setSpeed(Base.MIN_SPEED);
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent(userName));
		selenium.mouseDown("//div[text()='"+userName1+"']");
		selenium.type("idUserFirstNameInput", FirstName);
		selenium.fireEvent("idUserFirstNameInput", "blur");
	
		selenium.type("idUserLastNameInput", LastName);
		selenium.fireEvent("idUserLastNameInput", "blur");
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MIN_SPEED);
	}
    
}
