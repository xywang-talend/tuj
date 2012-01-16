package com.talend.tac.cases.rolesRights;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestCheckRoleDesignerPrivilege extends Login {

	@Test(description="can be improved ")
	public void testCheckRoleDesignerPrivilege() {
		waitForElementPresent("idLeftMenuTreeLogoutButton",WAIT_TIME );
		assertTrue(selenium.isElementPresent("!!!menu.project.element!!!"));//projects
		assertTrue(selenium.isElementPresent("!!!menu.projectsauthorizations.element!!!"));//authorization
		assertTrue(selenium.isElementPresent("!!!menu.refprojects.element!!!"));//reference
		assertTrue(selenium.isElementPresent("idMenuConfigElement"));//configurations
		assertTrue(selenium.isElementPresent("idMenuChangePasswordElement"));//user Settings
		assertTrue(selenium.isElementPresent("!!!menu.executionTasks.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.executionPlan.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.executionServers.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.virtual_server.element!!!"));
//		assertTrue(selenium.isElementPresent("!!!menu.soamanager.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.businessModeler.browser.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.dashjobs.element!!!"));
//		assertTrue(selenium.isElementPresent("!!!menu.soamanager.dashboard.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.commandline.dashboard.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.grid_task_executions_history.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.graphic_task_executions_history.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.audit.element!!!"));

	}
}
