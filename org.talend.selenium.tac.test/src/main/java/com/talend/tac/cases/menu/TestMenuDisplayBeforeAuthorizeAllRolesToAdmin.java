package com.talend.tac.cases.menu;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.talend.tac.cases.Login;

public class TestMenuDisplayBeforeAuthorizeAllRolesToAdmin extends Login {


	@Test
	public void testMenuBeforeAuthorizeAllRolesToAdmin() {
		// menu settings
		this.waitForElementPresent("!!!menu.settings.element!!!", WAIT_TIME);
		// menu users
		this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		// menu projects
		this.waitForElementPresent("!!!menu.project.element!!!", WAIT_TIME);
		// menu Projects authorizations
		this.waitForElementPresent("!!!menu.projectsauthorizations.element!!!",
				WAIT_TIME);
		// menu Projects references
		this.waitForElementPresent("!!!menu.refprojects.element!!!", WAIT_TIME);
		// menu license
		this.waitForElementPresent("idMenuLicenseElement", WAIT_TIME);
		// menu Configuration
		this.waitForElementPresent("idMenuConfigElement", WAIT_TIME);
		// menu user setting
		this.waitForElementPresent("idMenuChangePasswordElement", WAIT_TIME);
		// check menus that should not presents
		Assert.assertFalse(selenium
				.isElementPresent("//div[@id='!!!menu.notification.element!!!']"));
		Assert.assertFalse(selenium
				.isElementPresent("//div[@id='!!!menu.jobConductor.element!!!']"));
		Assert.assertFalse(selenium
				.isElementPresent("!!!menu.executionPlan.element!!!"));
		Assert.assertFalse(selenium
				.isElementPresent("!!!menu.executionTasks.element!!!"));
		Assert.assertFalse(selenium
				.isElementPresent("!!!menu.executionServers.element!!!"));
		Assert.assertFalse(selenium
				.isElementPresent("!!!menu.virtual_server.element!!!"));
		Assert.assertFalse(selenium
				.isElementPresent("!!!menu.soamanager.element!!!"));
		Assert.assertFalse(selenium
				.isElementPresent("!!!menu.businessModeler.element!!!"));
		Assert.assertFalse(selenium
				.isElementPresent("!!!menu.dashboard.element!!!"));
		Assert.assertFalse(selenium
				.isElementPresent("!!!menu.dashjobs.element!!!"));
		Assert.assertFalse(selenium
				.isElementPresent("!!!menu.soamanager.dashboard.element!!!"));
		Assert.assertFalse(selenium
				.isElementPresent("!!!menu.commandline.dashboard.element!!!"));
		Assert.assertFalse(selenium
				.isElementPresent("!!!menu.task_executions_history.element!!!"));
		Assert.assertFalse(selenium
				.isElementPresent("!!!menu.grid_task_executions_history.element!!!"));
		Assert.assertFalse(selenium
				.isElementPresent("!!!menu.graphic_task_executions_history.element!!!"));
		Assert.assertFalse(selenium
				.isElementPresent("!!!menu.audit.element!!!"));
		// check setting expend and close
		selenium.click("//div[@id='!!!menu.settings.element!!!']//img[@class=' x-tree3-node-joint']");
		this.sleep(5000);
		// menu users
		Assert.assertFalse(selenium.isVisible("idMenuUserElement"));
		// menu projects
		Assert.assertFalse(selenium.isVisible("!!!menu.project.element!!!"));
		// menu Projects authorizations
		Assert.assertFalse(selenium
				.isVisible("!!!menu.projectsauthorizations.element!!!"));
		// menu Projects references
		Assert.assertFalse(selenium.isVisible("!!!menu.refprojects.element!!!"));
		// menu license
		Assert.assertFalse(selenium.isVisible("idMenuLicenseElement"));
		// menu Configuration
		Assert.assertFalse(selenium.isVisible("idMenuConfigElement"));
		selenium.click("//div[@id='!!!menu.settings.element!!!']//img[@class=' x-tree3-node-joint']");
		this.sleep(5000);
		// menu users
		Assert.assertTrue(selenium.isVisible("idMenuUserElement"));
		// menu projects
		Assert.assertTrue(selenium.isVisible("!!!menu.project.element!!!"));
		// menu Projects authorizations
		Assert.assertTrue(selenium
				.isVisible("!!!menu.projectsauthorizations.element!!!"));
		// menu Projects references
		Assert.assertTrue(selenium.isVisible("!!!menu.refprojects.element!!!"));
		// menu license
		Assert.assertTrue(selenium.isVisible("idMenuLicenseElement"));
		// menu Configuration
		Assert.assertTrue(selenium.isVisible("idMenuConfigElement"));
		// menu user setting
		this.waitForElementPresent("idMenuChangePasswordElement", WAIT_TIME);
	}

	@Test
	public void testMenuUsers() {
		// test for user page contents
		this.clickWaitForElementPresent("idMenuUserElement");
				this.waitForElementPresent(
				"//div[@class='x-grid-group-div' and text()='Role: Administrator (1 Member)']",
				WAIT_TIME);
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']",
				WAIT_TIME);
	}

	@Test
	public void testMenuConfiguration() {
		// test for configuration page contents
		this.clickWaitForElementPresent("idMenuConfigElement");
		this.sleep(3000);
		//svn parameters
		this.waitForElementPresent(
				"//div[contains(text(),'Svn (3 Parameters')]", WAIT_TIME);
		this.waitForElementPresent(
				"//div[contains(text(),'CommandLine/primary')]", WAIT_TIME);
		this.waitForElementPresent(
				"//div[contains(text(),'CommandLine/secondary (4 Parameters')]", WAIT_TIME);
		this.waitForElementPresent(
				"//div[contains(text(),'Database (5 Parameters')]", WAIT_TIME);
		this.waitForElementPresent(
				"//div[contains(text(),'ESB (2 Parameter')]", WAIT_TIME);
//		this.waitForElementPresent(
//				"//div[contains(text(),'Extended configuration (1 Parameter')]", WAIT_TIME);
		this.waitForElementPresent(
				"//div[contains(text(),'LDAP (11 Parameters')]", WAIT_TIME);
		this.waitForElementPresent(
				"//div[contains(text(),'Log4j (3 Parameters')]", WAIT_TIME);
		this.waitForElementPresent(
				"//div[contains(text(),'SMTP (6 Parameters')]", WAIT_TIME);
//					this.waitForElementPresent(
//				"//div[contains(text(),'Conductor (7 Parameters')]", WAIT_TIME);
		this.waitForElementPresent(
				"//div[contains(text(),'Soa manager (4 Parameters')]", WAIT_TIME);
		this.waitForElementPresent(
				"//div[contains(text(),'Talend suite (3 Parameters')]", WAIT_TIME);
		this.waitForElementPresent("//div[contains(text(),'Audit (6 Parameters')]", WAIT_TIME);
		this.waitForElementPresent("//div[contains(text(),' Dashboard (1 Parameter')]", WAIT_TIME);
		this.waitForElementPresent("//div[contains(text(),'General (3 Parameters)')]", WAIT_TIME);
		
	}

	@Test
	public void testMenuLicense() {
		// check for license page contents
		this.clickWaitForElementPresent("idMenuLicenseElement");
		this.waitForElementPresent(
				"//span[@class='x-panel-header-text' and text()='License Parameters'] ",
				WAIT_TIME);
		this.waitForElementPresent("idLicenseUploadButton", WAIT_TIME);
	}

	@Test
	public void testMenuProject() {
		// check for project page contents
		this.clickWaitForElementPresent("!!!menu.project.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Projects']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-fieldset-header-text' and text()='Project'] ",
				WAIT_TIME);

	}

	@Test
	public void testMenuProjectAuthorization() {

		// check for project authorization page contents
		this.clickWaitForElementPresent("!!!menu.projectsauthorizations.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Projects authorizations']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-panel-header-text' and text()='Users']",
				WAIT_TIME);
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Projects authorizations']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-panel-header-text' and text()='Projects']",
				WAIT_TIME);
		Assert.assertFalse(
				selenium.isElementPresent("//div[@class='header-title' and text()='Projects authorizations']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']"),
				"admin user should not display here,only designers!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Projects authorizations']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-panel-header-text' and text()='Projects']//ancestor::div[contains(@class,'x-panel x-component x-border-panel')]//span[@class='x-tree3-node-text' and text()='Data Integration']",
				WAIT_TIME);
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Projects authorizations']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-panel-header-text' and text()='Projects']//ancestor::div[contains(@class,'x-panel x-component x-border-panel')]//span[@class='x-tree3-node-text' and text()='Data Quality']",
				WAIT_TIME);
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Projects authorizations']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-panel-header-text' and text()='Projects']//ancestor::div[contains(@class,'x-panel x-component x-border-panel')]//span[contains(text(),'Master Data Management')]",
				WAIT_TIME);
	}


	@Test
	public void testMenuProjectReferences() {
		// check for project references page contents
		this.clickWaitForElementPresent("!!!menu.refprojects.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Projects references']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-panel-header-text' and text()='Projects available as reference']",
				WAIT_TIME);
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Projects references']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-panel-header-text' and text()='Projects']",
				WAIT_TIME);
	}

	@Test
	public void testMenuUserSetting() {
		// check for user setting page contents
		this.clickWaitForElementPresent("idMenuChangePasswordElement");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='User settings']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-fieldset-header-text' and text()='Svn Account']",
				WAIT_TIME);
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='User settings']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-fieldset-header-text' and text()='User Password']",
				WAIT_TIME);
	}

}
