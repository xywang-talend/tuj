package com.talend.tac.cases.user;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;
@Test(groups={"one"})
public class TestDeleteLoginUser extends Login{
   
	@Test
	@Parameters({"userName","userName"})
	public void testDeleteLoginUser(String userName,String userName1) throws Exception {
		this.clickWaitForElementPresent("idMenuUserElement");
//		selenium.click("idMenuUserElement");
//		
//		selenium.setSpeed(Base.MIN_SPEED);
		
		Assert.assertTrue(selenium.isTextPresent(userName));
		selenium.mouseDown("//div[text()='"+userName1+"']");//Select Login user
		selenium.chooseOkOnNextConfirmation();
		selenium.click("idSubModuleDeleteButton");
		Assert.assertTrue(selenium.getConfirmation().matches("^"+other.getString("delete.User.confirmation")+" [\\s\\S]$"));
		
		selenium.setSpeed(MID_SPEED);
		
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.error.deleteCurrentLoggedUser")));
		selenium.click("//button[text()='" +other.getString("delete.LoginUser.fail")+"']");
		
		selenium.setSpeed(MIN_SPEED);

	}
}
