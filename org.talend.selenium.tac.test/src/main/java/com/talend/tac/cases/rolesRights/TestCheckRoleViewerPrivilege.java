package com.talend.tac.cases.rolesRights;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestCheckRoleViewerPrivilege extends Login {

	@Test(description="can be improved ")
	public void testCheckRoleViewerPrivilege() {
		waitForElementPresent("idLeftMenuTreeLogoutButton",WAIT_TIME );
		
		assertTrue(selenium.isElementPresent("!!!menu.executionTasks.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.executionPlan.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.executionServers.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.virtual_server.element!!!"));
//		assertTrue(selenium.isElementPresent("!!!menu.soamanager.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.audit.element!!!"));
		assertTrue(selenium.isElementPresent("idMenuChangePasswordElement"));//user Settings
		

	}
}
