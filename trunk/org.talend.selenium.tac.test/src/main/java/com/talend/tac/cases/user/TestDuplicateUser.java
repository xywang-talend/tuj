package com.talend.tac.cases.user;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;
@Test(dependsOnGroups={"two"},dependsOnMethods={"testAddUserNotChooseActive"})
public class TestDuplicateUser extends Login {
     
	@Test
	@Parameters({"userName","DulicateUser","PassWord"})
	public void testDuplicateUser(String userName,String DulicateUser,String Password) throws Exception {
		this.clickWaitForElementPresent("idMenuUserElement");
//		selenium.click("idMenuUserElement");
//		
//		selenium.setSpeed(Base.MIN_SPEED);
//		
		Assert.assertTrue(selenium.isTextPresent(userName));
		selenium.mouseDown(DulicateUser);//Select an existing user
		selenium.click("idSubModuleDuplicateButton");
		selenium.type("idUserPasswordInput", Password);
		selenium.fireEvent("idUserPasswordInput", "blur");
		selenium.click("idUserPasswordInput");
		selenium.click("idFormSaveButton");
		selenium.setSpeed("3000");
	}
	
}
