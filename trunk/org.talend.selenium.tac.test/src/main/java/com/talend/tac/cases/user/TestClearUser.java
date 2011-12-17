package com.talend.tac.cases.user;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;
@Test(dependsOnGroups={"two"},dependsOnMethods={"testMysqlAddUserActive"})
public class TestClearUser extends Login{
    
	@Test
	@Parameters({"userName","LoginName","ModifiyUserName","DulicatedUser","userName"})
	public void testClearUser(String userName,String LoginName,String ModifiyUserName,String DulicatedUser,String userName1) throws Exception {
		this.clickWaitForElementPresent("idMenuUserElement");
//		selenium.click("idMenuUserElement");
//		
//		selenium.setSpeed(Base.MIN_SPEED);
		
		Assert.assertTrue(selenium.isTextPresent(userName));
		selenium.mouseDown("//div[text()='"+LoginName+"']");//Select an existing user
		selenium.chooseOkOnNextConfirmation();
		selenium.click("idSubModuleDeleteButton");
		selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.getConfirmation().matches("^"+other.getString("delete.User.confirmation")+" [\\s\\S]$"));

	    selenium.mouseDown("//div[text()='"+ModifiyUserName+"']");//Select an existing user
		selenium.chooseOkOnNextConfirmation();
		selenium.click("idSubModuleDeleteButton");
		selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.getConfirmation().matches("^"+other.getString("delete.User.confirmation")+" [\\s\\S]$"));

	    selenium.mouseDown(DulicatedUser);//Select an existing user
		selenium.chooseOkOnNextConfirmation();
		selenium.click("idSubModuleDeleteButton");
		selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.getConfirmation().matches("^"+other.getString("delete.User.confirmation")+" [\\s\\S]$"));
	    selenium.setSpeed(MID_SPEED);
	    
	    selenium.mouseDown("//div[text()='"+userName1+"']");//Select Login user
		selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.setSpeed(MID_SPEED);
		selenium.click("//div[text()='"+ rb.getString("menu.role.administrator")+"']");
		selenium.click("idValidateButton");
		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
	    selenium.setSpeed(MIN_SPEED);
	}
}
