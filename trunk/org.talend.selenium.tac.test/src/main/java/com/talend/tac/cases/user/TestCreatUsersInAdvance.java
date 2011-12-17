package com.talend.tac.cases.user;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestCreatUsersInAdvance extends Login {
	@Test
	@Parameters( { "user.admin.login", "user.admin.firstName",
			"user.admin.lastName", "user.admin.passwd",
			"user.allRole.svnLogin", "user.allRole.svnPasswd",
			"user.admin.userRole" })
	public void testCreateRoleAdministrator(String LoginName, String FirstName,
			String LastName, String Passwd, String SvnLogin, String SvnPasswd,
			String UserRole) {

		creatUserProcess(LoginName, FirstName, LastName, Passwd, SvnLogin,
				SvnPasswd, UserRole);

	}

	@Test
	@Parameters( { "user.operationManager.login",
			"user.operationManager.firstName",
			"user.operationManager.lastName", "user.operationManager.passwd",
			"user.allRole.svnLogin", "user.allRole.svnPasswd",
			"user.operationManager.userRole" })
	public void testCreateRoleOperationManager(String LoginName,
			String FirstName, String LastName, String Passwd, String SvnLogin,
			String SvnPasswd, String UserRole) {

		creatUserProcess(LoginName, FirstName, LastName, Passwd, SvnLogin,
				SvnPasswd, UserRole);

	}

	@Test
	@Parameters( { "user.designer.login", "user.designer.firstName",
			"user.designer.lastName", "user.designer.passwd",
			"user.allRole.svnLogin", "user.allRole.svnPasswd",
			"user.designer.userRole" })
	public void testCreateRoleDesigner(String LoginName, String FirstName,
			String LastName, String Passwd, String SvnLogin, String SvnPasswd,
			String UserRole) {

		creatUserProcess(LoginName, FirstName, LastName, Passwd, SvnLogin,
				SvnPasswd, UserRole);

	}

	@Test
	@Parameters( { "user.viewer.login", "user.viewer.firstName",
			"user.viewer.lastName", "user.viewer.passwd",
			"user.allRole.svnLogin", "user.allRole.svnPasswd",
			"user.viewer.userRole" })
	public void testCreateRoleviewer(String LoginName, String FirstName,
			String LastName, String Passwd, String SvnLogin, String SvnPasswd,
			String UserRole) {

		creatUserProcess(LoginName, FirstName, LastName, Passwd, SvnLogin,
				SvnPasswd, UserRole);

	}

	/*
	 * The steps to create a normal account/user.
	 */
	public void creatUserProcess(String LoginName, String FirstName,
			String LastName, String Passwd, String SvnLogin, String SvnPasswd,
			String UserRole) {
		this.clickWaitForElementPresent("idMenuUserElement");
		List<String> users = new ArrayList<String>();
		users = this.findSpecialMachedStrings(LoginName);
		// no need to create if there is already an user existed.
		if (users.size() != 0) {
		} else {
			selenium.click("idSubModuleAddButton");
			Assert
					.assertTrue(selenium
							.isElementPresent("//img[@class='gwt-Image x-component ']"));
			selenium.type("idUserLoginInput", LoginName);
			selenium.fireEvent("idUserLoginInput", "blur");
			selenium.type("idUserFirstNameInput", FirstName);
			selenium.fireEvent("idUserFirstNameInput", "blur");
			selenium.type("idUserLastNameInput", LastName);
			selenium.fireEvent("idUserLastNameInput", "blur");
			selenium.type("idUserPasswordInput", Passwd);
			selenium.fireEvent("idUserPasswordInput", "blur");
			selenium.type("//input[@name='authenticationLogin']", SvnLogin);
			selenium.fireEvent("//input[@name='authenticationLogin']", "blur");
			selenium.type("//input[@name='authenticationPassword']", SvnPasswd);
			selenium.fireEvent("//input[@name='authenticationPassword']",
					"blur");
			// select type
			waitForElementPresent("//input[@id='idTypeInput']/following-sibling::div",WAIT_TIME);
			selenium.click("//input[@id='idTypeInput']/following-sibling::div");
			waitForElementPresent("//div[@role='listitem' and text()='Data Integration']",WAIT_TIME);
			selenium.mouseDown("//div[@role='listitem' and text()='Data Integration']");
			
			selenium.click("idRoleButton");
			Assert.assertTrue(selenium.isTextPresent(rb
					.getString("user.roles.title")));
			/*
			 * 1. The Role columns also contains the text(),but with the attribute:
			 * style="*;display:none ".
			 * 2. using the xpath and mouseDown(),mouseUp() can select more than one roles at the same time. multi-role
			 */
			waitForElementPresent("//td[not(contains(@style,'display: none'))]/div[text()='" + rb.getString(UserRole) + "']/parent::td/preceding-sibling::td//div[@class='x-grid3-row-checker']", WAIT_TIME);
			selenium.mouseDown("//td[not(contains(@style,'display: none'))]/div[text()='"+ rb.getString(UserRole) + "']/parent::td/preceding-sibling::td//div[@class='x-grid3-row-checker']");
			selenium.mouseUp("//td[not(contains(@style,'display: none'))]/div[text()='"+ rb.getString(UserRole) + "']/parent::td/preceding-sibling::td//div[@class='x-grid3-row-checker']");
			
			selenium.click("idValidateButton");
			selenium.setSpeed("3000");
			selenium.click("idFormSaveButton");
			waitForElementPresent("//div[text()='" + LoginName + "']" ,WAIT_TIME);
			selenium.setSpeed("0");
		}
	}
	
	//grant all roles to admin@company.com
	@Test
	public void testModifyAdminAccountWithAllRoles() {
		this.clickWaitForElementPresent("idMenuUserElement");
		this.waitForElementPresent("//div[text()='admin@company.com']", WAIT_TIME);
		selenium.mouseDown("//div[text()='admin@company.com']");
		selenium.click("idRoleButton");
		selenium.click("//span[text()='Role']/ancestor::td/preceding-sibling::td/div");
		selenium.click("idValidateButton");
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MAX_SPEED);
		selenium.refresh();
		selenium.setSpeed(MIN_SPEED);
		this.waitForElementPresent("!!!menu.jobConductor.element!!!", WAIT_TIME);
	}
	
}
