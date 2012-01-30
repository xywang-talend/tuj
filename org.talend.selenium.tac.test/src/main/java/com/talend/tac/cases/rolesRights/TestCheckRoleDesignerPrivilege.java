package com.talend.tac.cases.rolesRights;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestCheckRoleDesignerPrivilege extends Login {

	@Test
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
		assertTrue(selenium.isElementPresent("!!!menu.dashamc.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.commandline.dashboard.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.grid_task_executions_history.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.graphic_task_executions_history.element!!!"));
		assertTrue(selenium.isElementPresent("!!!menu.audit.element!!!"));

	}
	
	
	
	@Test
	@Parameters({ "ServerForUseAvailable", "ServerForUseUnavailable","ServerForUseDownlabel",
			"ServeravailableHost" })
	public void testDesignerReadForServer(String lableavailable, String labelunactive,String downlabel,
			String availablehost) {
		waitForElementPresent("idLeftMenuTreeLogoutButton",WAIT_TIME );
		assertTrue(selenium.isElementPresent("!!!menu.executionServers.element!!!"));
		this.waitForElementPresent("!!!menu.executionServers.element!!!",
				WAIT_TIME);
		selenium.click("!!!menu.executionServers.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Servers']//ancestor::div[@class=' x-viewport x-component x-border-layout-ct']//span[@class='x-fieldset-header-text' and text()='Execution server']",
				WAIT_TIME);
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Servers']", WAIT_TIME);
		this.waitForElementPresent("//div[@class='header-title' and text()='Servers']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleRefreshButton']", WAIT_TIME);
		
		assertFalse(selenium.isVisible("//div[@class='header-title' and text()='Servers']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleAddButton']"));
		this.waitForElementPresent("//div[text()='" + lableavailable + "']",
				WAIT_TIME);
		selenium.mouseDown("//div[text()='" + lableavailable + "']");
		this.sleep(3000);
		Assert.assertTrue(selenium.getValue((other.getString("inputname.id.server.add.host"))).equals(availablehost)) ;
		String testlabel=lableavailable+"testModify";
		this.typeString(other.getString("inputname.id.server.add.label"),
				testlabel);
		selenium.click("//div[@class='header-title' and text()='Servers']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-border-layout-ct']//button[@id='idFormSaveButton']");
	    assertFalse(this.waitElement("//div[text()='" + testlabel + "']", WAIT_TIME));
		
	}
	
	@Test
	public void testDesignerReadForVirtualServers() {
		waitForElementPresent("idLeftMenuTreeLogoutButton",WAIT_TIME );
		assertTrue(selenium.isElementPresent("!!!menu.virtual_server.element!!!"));
		
		selenium.click("!!!menu.virtual_server.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Virtual servers']", WAIT_TIME);
		this.waitForElementPresent("//div[@class='header-title' and text()='Virtual servers']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[text()='use_server_available']",WAIT_TIME);
		assertFalse(this.waitElement("//button[@class='x-btn-text ' and text()='Add a virtual server']", WAIT_TIME));
		
	}
	
}
