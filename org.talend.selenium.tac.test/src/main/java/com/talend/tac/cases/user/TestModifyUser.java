package com.talend.tac.cases.user;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.talend.tac.cases.Login;
@Test(dependsOnGroups={"two"},dependsOnMethods={"testDuplicateUser"})
public class TestModifyUser extends Login {
    
	@Test
	@Parameters({"userName","DulicateUser","ModifiyUserName"})
	public void testModifyUser(String userName,String DulicateUser,String ModifiyUserName) throws Exception {
		this.clickWaitForElementPresent("idMenuUserElement");
//		selenium.click("idMenuUserElement");
//		
//		
//		selenium.setSpeed(Base.MIN_SPEED);
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent(userName));
		selenium.mouseDown(DulicateUser);
		selenium.type("idUserLoginInput", ModifiyUserName);
		selenium.fireEvent("idUserLoginInput", "blur");
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MIN_SPEED);
	}
    
}
