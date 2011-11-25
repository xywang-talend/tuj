package com.talend.tac.cases.user;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;
@Test(groups={"two"},dependsOnGroups={"one"})
public class TestAddNewUserRoleAdministrator extends Login {
    
	@Test
	@Parameters({"userName","LoginNameChooseAdministratorRole","FirstName","LastName","PassWord","SvnLogin","SvnPassWord","LoginNameChooseAdministratorRole"})
	public void testAddNewUserRoleAdministrator(String userName,String LoginNameChooseAdministratorRole,String FirstName,String LastName,String PassWord,String SvnLogin,String SvnPassWord,String LoginNameChooseAdministratorRole1) throws Exception {
		
		this.clickWaitForElementPresent("idMenuUserElement");
		
		Assert.assertTrue(selenium.isTextPresent(userName));
		selenium.click("idSubModuleAddButton");
		Assert.assertTrue(selenium.isElementPresent("//img[@class='gwt-Image x-component ']"));
		selenium.type("idUserLoginInput", LoginNameChooseAdministratorRole1);
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
		selenium.mouseDown("//div[text()='"+ rb.getString("menu.role.administrator")+"']");
		selenium.click("idValidateButton");

		selenium.setSpeed("3000");
		selenium.click("idFormSaveButton");
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+LoginNameChooseAdministratorRole1+"']"));
	}
	
}
