package com.talend.tac.cases.user;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;
@Test(dependsOnGroups={"two"})
public class TestMysqlAddUserActive extends Login {
    
	
	@Test
	@Parameters({"userName","LoginName","FirstName","LastName","PassWordww","SvnLogin","SvnPassWord","LoginName"})
	public void testMysqlAddUserActive(String userName,String LoginName,String FirstName,String LastName,String PassWordww,String SvnLogin,String SvnPassWord,String LoginName1) throws Exception {
		this.clickWaitForElementPresent("idMenuUserElement");
//		selenium.click("idMenuUserElement");
//		
//		selenium.setSpeed(Base.MIN_SPEED);
		
		Assert.assertTrue(selenium.isTextPresent(userName));
		selenium.click("idSubModuleAddButton");//add a user/Mysql
		Assert.assertTrue(selenium.isElementPresent("//img[@class='gwt-Image x-component ']"));
		selenium.type("idUserLoginInput", LoginName);//user name
		selenium.fireEvent("idUserLoginInput", "blur");
		selenium.type("idUserFirstNameInput", FirstName);
		selenium.fireEvent("idUserFirstNameInput", "blur");
		selenium.type("idUserLastNameInput", LastName);
		selenium.fireEvent("idUserLastNameInput", "blur");
		selenium.type("idUserPasswordInput", PassWordww);
		selenium.fireEvent("idUserPasswordInput", "blur");
		selenium.type("//input[@name='authenticationLogin']", SvnLogin);
		selenium.fireEvent("//input[@name='authenticationLogin']", "blur");
		selenium.type("//input[@name='authenticationPassword']", SvnPassWord);
		selenium.fireEvent("//input[@name='authenticationPassword']", "blur");
		selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.mouseDown("//div[text()='"+  rb.getString("menu.role.designer")+"']");//choose a  role
		selenium.click("idValidateButton");
		selenium.click("idFormSaveButton");
		selenium.setSpeed("3000");
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+LoginName1+"']"));
	}
}
