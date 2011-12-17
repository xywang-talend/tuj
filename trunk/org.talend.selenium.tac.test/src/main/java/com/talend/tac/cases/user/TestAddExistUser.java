package com.talend.tac.cases.user;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;
@Test(groups={"one"})
public class TestAddExistUser extends Login {
	
	@Test
	@Parameters({"userName","userName","FirstName","LastName","PassWord","SvnLogin","SvnPassWord"})
	public void testAddExistUser(String userName,String userName1,String FirstName,String LastName,String PassWord,String SvnLogin,String SvnPassWord) throws Exception {
		waitForElementPresent("idMenuUserElement", 20);
		
		selenium.click("idMenuUserElement");
		
		Assert.assertTrue(selenium.isTextPresent(userName));
		selenium.click("idSubModuleAddButton");
		Assert.assertTrue(selenium.isElementPresent("//img[@class='gwt-Image x-component ']"));
		selenium.type("idUserLoginInput", userName1);
		selenium.fireEvent("idUserLoginInput", "blur");
		selenium.type("idUserFirstNameInput", FirstName);
		selenium.fireEvent("idUserFirstNameInput", "blur");
		selenium.type("idUserLastNameInput", LastName);
		selenium.fireEvent("idUserLastNameInput", "blur");
		selenium.type("idUserPasswordInput", PassWord);
		selenium.fireEvent("idUserPasswordInput", "blur");
		selenium.type("//input[@name='authenticationLogin']", SvnLogin);//svnUserName
		selenium.fireEvent("//input[@name='authenticationLogin']", "blur");
		selenium.type("//input[@name='authenticationPassword']", SvnPassWord);//svnPassWord
		selenium.fireEvent("//input[@name='authenticationPassword']", "blur");
		selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.mouseDown("//div[text()='"+ rb.getString("menu.role.operationManager")+"']");
//		Assert.assertTrue(selenium.isChecked("//div[text()='"+ rb.getString("menu.role.operationManager")+"']"));
		selenium.click("idValidateButton");
		

		selenium.setSpeed("3000");
		selenium.click("idFormSaveButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.error.uniqueLogin")));
		selenium.setSpeed("3000");
        selenium.click("//button[text()='" +other.getString("add.ExistUser.fail")+"']");
    
	}

}