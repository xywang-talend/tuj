package com.talend.tac.cases.user;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;
@Test(dependsOnGroups={"two"})
public class TestAddUserNotChooseActive extends Login {
    
	@Test
	@Parameters({"userName","LoginNameNotChooseActive","FirstName","LastName","PassWord","SvnLogin","SvnPassWord","LoginNameNotChooseActive"})
	public void testAddUserNotChooseActive(String userName,String LoginNameNotChooseActive,String FirstName,String LastName,String PassWord,String SvnLogin,String SvnPassWord,String LoginNameNotChooseActive1) throws Exception {
		this.clickWaitForElementPresent("idMenuUserElement");
//		selenium.click("idMenuUserElement");
//		
//		selenium.setSpeed(Base.MIN_SPEED);
		
		Assert.assertTrue(selenium.isTextPresent(userName));
		selenium.click("idSubModuleAddButton");
		Assert.assertTrue(selenium.isElementPresent("//img[@class='gwt-Image x-component ']"));
		selenium.type("idUserLoginInput", LoginNameNotChooseActive);
		selenium.fireEvent("idUserLoginInput", "blur");
		selenium.type("idUserFirstNameInput", FirstName);
		selenium.fireEvent("idUserFirstNameInput", "blur");
		selenium.type("idUserLastNameInput", LastName);
		selenium.fireEvent("idUserLastNameInput", "blur");
		selenium.type("idUserPasswordInput", PassWord);
		selenium.fireEvent("idUserPasswordInput", "blur");
		selenium.type("//input[@name='authenticationLogin']", SvnLogin);
		selenium.fireEvent("//input[@name='authenticationLogin']", "blur");
		selenium.type("//input[@name='authenticationPassword']", SvnPassWord);
		selenium.fireEvent("//input[@name='authenticationPassword']", "blur");
		selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.mouseDown("//div[text()='"+ rb.getString("menu.role.viewer")+"']");
		selenium.click("idValidateButton");
		
		selenium.click("//input[@name='active']");
		Assert.assertFalse(selenium.isChecked("//input[@name='active']"));


		selenium.click("idFormSaveButton");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+LoginNameNotChooseActive1+"']"));
		selenium.setSpeed(MIN_SPEED);
	}
	
}
