package com.talend.tac.cases.rolesRights;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestCheckRoleAdminPrivilege extends Login {

	@Test(description="can be improved ")
	public void testCheckRoleAdminPrivilege() {
		waitForElementPresent("idLeftMenuTreeLogoutButton",WAIT_TIME );
		assertTrue(selenium.isElementPresent("idMenuUserElement"));//user
		
		assertTrue(selenium.isElementPresent("!!!menu.project.element!!!"));//projects
		assertTrue(selenium.isElementPresent("!!!menu.projectsauthorizations.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.refprojects.element!!!"));
		assertTrue(selenium.isElementPresent("idMenuLicenseElement"));//license
		assertTrue(selenium.isElementPresent("idMenuConfigElement"));//configurations
		assertTrue(selenium.isElementPresent("idMenuChangePasswordElement"));//user Settings
		
		

	}
}
