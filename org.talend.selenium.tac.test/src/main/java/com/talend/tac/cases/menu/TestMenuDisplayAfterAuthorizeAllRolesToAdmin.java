package com.talend.tac.cases.menu;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.talend.tac.cases.Login;

public class TestMenuDisplayAfterAuthorizeAllRolesToAdmin extends Login {
	public void waitForElementDispear(String element, int timeout) {
		this.sleep(8000);
		if (selenium.isElementPresent(element)) {
			for (int second = 0;; second++) {
				if (second >= timeout)
					Assert.assertFalse(selenium.isElementPresent(element));
				try {
					if ((!selenium.isElementPresent(element))) {
						break;
					} else {
						this.sleep(1000);
					}
				} catch (Exception e) {
				}

			}
		}

	}



	@Test
	public void testMenuJobConductorExpend() {
		this.waitForElementPresent(
				"//div[@id='!!!menu.jobConductor.element!!!']//img[@class=' x-tree3-node-joint']",
				WAIT_TIME);
		selenium.click("//div[@id='!!!menu.jobConductor.element!!!']//img[@class=' x-tree3-node-joint']");
		this.sleep(5000);
		Assert.assertFalse(selenium
				.isVisible("!!!menu.executionPlan.element!!!"));
		Assert.assertFalse(selenium
				.isVisible("!!!menu.executionTasks.element!!!"));
		Assert.assertFalse(selenium
				.isVisible("!!!menu.executionServers.element!!!"));
		Assert.assertFalse(selenium
				.isVisible("!!!menu.virtual_server.element!!!"));
		this.clickWaitForElementPresent("//div[@id='!!!menu.jobConductor.element!!!']//img[@class=' x-tree3-node-joint']");
		this.sleep(5000);
		Assert.assertTrue(selenium
				.isVisible("!!!menu.executionPlan.element!!!"));
		Assert.assertTrue(selenium
				.isVisible("!!!menu.executionTasks.element!!!"));
		Assert.assertTrue(selenium
				.isVisible("!!!menu.executionServers.element!!!"));
		Assert.assertTrue(selenium
				.isVisible("!!!menu.virtual_server.element!!!"));
	}

	@Test
	public void testMenuExcutionTask() {

		// check menu execution task
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		this.waitForElementDispear("//div[@class='header-title' and text()='Job Conductor']//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader" +
				" x-panel-body-noborder x-border-layout-ct')]//div[text()='Loading...']", WAIT_TIME);
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"
				+ rb.getString("menu.jobConductor") + "']"));
		selenium.setSpeed(MIN_SPEED);
		selenium.refresh();
		this.sleep(5000);
		this.waitForElementDispear("//div[@class='header-title' and text()='Job Conductor']//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader" +
				" x-panel-body-noborder x-border-layout-ct')]//div[text()='Loading...']", WAIT_TIME);
	}

	@Test
	public void testMenuExecutionPlan() {
		this.waitForElementPresent("!!!menu.executionPlan.element!!!", WAIT_TIME);
		// check menu execution plan
		selenium.click("!!!menu.executionPlan.element!!!");
		this.waitForElementDispear("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader" +
				" x-panel-body-noborder x-border-layout-ct')]//div[text()='Loading...']", WAIT_TIME);
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Execution Plan']",
				WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
		selenium.refresh();
		this.sleep(5000);
		this.waitForElementDispear("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader" +
				" x-panel-body-noborder x-border-layout-ct')]//div[text()='Loading...']", WAIT_TIME);
	}

	@Test
	public void testMenuExecutionServer() {

		// check menu execution server
		this.clickWaitForElementPresent("!!!menu.executionServers.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Servers']//ancestor::div[@class=' x-viewport x-component x-border-layout-ct']//span[@class='x-fieldset-header-text' and text()='Execution server']",
				WAIT_TIME);
		// div[@class='header-title' and text()='Servers']
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Servers']", WAIT_TIME);
		this.sleep(5000);
		this.waitForElementDispear(
				"//div[@class='header-title' and text()='Servers']//ancestor::div[@class=' x-viewport x-component x-border-layout-ct']//div[text()='Loading...']",
				WAIT_TIME);
		selenium.refresh();
		this.sleep(5000);
		this.waitForElementDispear("//div[text()='Loading...']", WAIT_TIME);
	}

	@Test
	public void testMenuVirtualServers() {

		// check menu virtual servers
		this.clickWaitForElementPresent("!!!menu.virtual_server.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Virtual servers']//ancestor::div[@class=' x-viewport x-component x-border-layout-ct']//span[@class='x-panel-header-text' and text()='Job servers']",
				WAIT_TIME);
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Virtual servers']//ancestor::div[@class=' x-viewport x-component x-border-layout-ct']//span[@class='x-panel-header-text' and text()='Virtual servers']",
				WAIT_TIME);

	}

	@Test
	public void testMenuNotification() {
		this.waitForElementPresent("!!!menu.notification.element!!!", WAIT_TIME);
		selenium.click("!!!menu.notification.element!!!");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-event' and text()='On creation mailTo itself']",
				WAIT_TIME);
	}

	@Test
	public void testMenuAudit() {
		this.waitForElementPresent("!!!menu.audit.element!!!", WAIT_TIME);
		selenium.click("!!!menu.audit.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Audit']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-panel-header-text' and text()='Audits list']",
				WAIT_TIME);
		selenium.refresh();
		this.sleep(3000);
		this.waitForElementDispear(
				"//div[@class='header-title' and text()='Audit']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[text()='Loading...']",
				WAIT_TIME);
		this.waitForElementPresent("//button[text()='Audit DB Configuration']", WAIT_TIME);
		
	}

//	@Test
	public void testMenuSoaManager() {
		this.waitForElementPresent("!!!menu.soamanager.element!!!", WAIT_TIME);
		selenium.click("!!!menu.soamanager.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='SOA Manager']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-fieldset-header-text' and text()='Metadata']",
				WAIT_TIME);
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='SOA Manager']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-fieldset-header-text' and text()='Binding']",
				WAIT_TIME);
		selenium.refresh();
		this.sleep(3000);
		this.waitForElementDispear(
				"//div[@class='header-title' and text()='SOA Manager']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[text()='Loading...']",
				WAIT_TIME);
	}

//	@Test
	public void testMenuBMExpend() {
		this.waitForElementPresent("!!!menu.businessModeler.element!!!", WAIT_TIME);
		this.waitForElementPresent(
				"//div[@id='!!!menu.businessModeler.element!!!']//img[@class=' x-tree3-node-joint']",
				WAIT_TIME);
		selenium.click("//div[@id='!!!menu.businessModeler.element!!!']//img[@class=' x-tree3-node-joint']");
		this.sleep(5000);
		Assert.assertFalse(selenium.isVisible("!!!menu.businessModeler.designer.element!!!"));
		Assert.assertFalse(selenium.isVisible("!!!menu.businessModeler.browser.element!!!"));
		this.clickWaitForElementPresent("//div[@id='!!!menu.businessModeler.element!!!']//img[@class=' x-tree3-node-joint']");
		this.sleep(5000);
		Assert.assertTrue(selenium.isVisible("!!!menu.businessModeler.designer.element!!!"));
		Assert.assertTrue(selenium.isVisible("!!!menu.businessModeler.browser.element!!!"));
	}	
	
//	@Test
	public void testMenuBMDesigner(){
		this.waitForElementPresent("!!!menu.businessModeler.designer.element!!!",
				WAIT_TIME);
		this.sleep(2000);
		selenium.click("!!!menu.businessModeler.designer.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Business modeler designer']",
				WAIT_TIME);
		this.waitForElementPresent("idProjectListBox", WAIT_TIME);
		this.waitForElementPresent("idBranchListBox", WAIT_TIME);
		this.waitForElementPresent("idBusinessListBox", WAIT_TIME);
		this.waitForElementPresent("idBusinessConnectionsListBox", WAIT_TIME);
		this.waitForElementPresent("//div[@class='ext-el-mask']", WAIT_TIME);
	}
	
	@Test
	public void testMenuBMBroswer(){
		this.waitForElementPresent("!!!menu.businessModeler.browser.element!!!",
				WAIT_TIME);
		this.sleep(2000);
		selenium.click("!!!menu.businessModeler.browser.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Repository browser']",
				WAIT_TIME);
		this.waitForTextPresent("Select a Project", WAIT_TIME);
		this.waitForTextPresent("Select a Branch", WAIT_TIME);
	}

	@Test
	public void testMenuDashboardExpend() {
		this.waitForElementPresent("!!!menu.dashboard.element!!!", WAIT_TIME);
		this.waitForElementPresent(
				"//div[@id='!!!menu.dashboard.element!!!']//img[@class=' x-tree3-node-joint']",
				WAIT_TIME);
		selenium.click("//div[@id='!!!menu.dashboard.element!!!']//img[@class=' x-tree3-node-joint']");
		this.sleep(5000);
		Assert.assertFalse(selenium.isVisible("!!!menu.connections.element!!!"));
		Assert.assertFalse(selenium.isVisible("!!!menu.dashjobs.element!!!"));
//		Assert.assertFalse(selenium
//				.isVisible("!!!menu.soamanager.dashboard.element!!!"));
		Assert.assertFalse(selenium
				.isVisible("!!!menu.commandline.dashboard.element!!!"));
		Assert.assertFalse(selenium
				.isVisible("!!!menu.task_executions_history.element!!!"));
		Assert.assertFalse(selenium
				.isVisible("!!!menu.grid_task_executions_history.element!!!"));
		Assert.assertFalse(selenium
				.isVisible("!!!menu.graphic_task_executions_history.element!!!"));
		this.clickWaitForElementPresent("//div[@id='!!!menu.dashboard.element!!!']//img[@class=' x-tree3-node-joint']");
		this.sleep(5000);
		Assert.assertTrue(selenium.isVisible("!!!menu.connections.element!!!"));
		Assert.assertTrue(selenium.isVisible("!!!menu.dashjobs.element!!!"));
//		Assert.assertTrue(selenium
//				.isVisible("!!!menu.soamanager.dashboard.element!!!"));
		Assert.assertTrue(selenium
				.isVisible("!!!menu.commandline.dashboard.element!!!"));
		Assert.assertTrue(selenium
				.isVisible("!!!menu.task_executions_history.element!!!"));
		Assert.assertTrue(selenium
				.isVisible("!!!menu.grid_task_executions_history.element!!!"));
		Assert.assertTrue(selenium
				.isVisible("!!!menu.graphic_task_executions_history.element!!!"));
		this.clickWaitForElementPresent("//div[@id='!!!menu.task_executions_history.element!!!']//div[@aria-level='2']//img[contains(@class,'x-tree3-node-joint')]");
		this.sleep(5000);
		Assert.assertFalse(selenium
				.isVisible("!!!menu.grid_task_executions_history.element!!!"));
		Assert.assertFalse(selenium
				.isVisible("!!!menu.graphic_task_executions_history.element!!!"));
		this.clickWaitForElementPresent("//div[@id='!!!menu.task_executions_history.element!!!']//img[@class=' x-tree3-node-joint']");
		this.sleep(5000);
		Assert.assertTrue(selenium
				.isVisible("!!!menu.grid_task_executions_history.element!!!"));
		Assert.assertTrue(selenium
				.isVisible("!!!menu.graphic_task_executions_history.element!!!"));
	}

	@Test
	public void testMenuConnection() {
		// check menu connection
		this.clickWaitForElementPresent("!!!menu.connections.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Connections']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-fieldset-header-text' and text()='Database connection']",
				WAIT_TIME);
		selenium.refresh();
		this.sleep(3000);
		this.waitForElementDispear(
				"//div[@class='header-title' and text()='Connections']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[text()='Loading...']",
				WAIT_TIME);
	}

	@Test
	public void testMenuCommondline() {

		// check menu commondline
		this.clickWaitForElementPresent("!!!menu.commandline.dashboard.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='CommandLine']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-fieldset-header-text' and text()='CommandLine']",
				WAIT_TIME);
		selenium.refresh();
		this.sleep(3000);
		this.waitForElementDispear(
				"//div[@class='header-title' and text()='CommandLine']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[text()='Loading...']",
				WAIT_TIME);
	}

	@Test
	public void testMenuGrid() {
		// check menu grid
		this.clickWaitForElementPresent("!!!menu.grid_task_executions_history.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-fieldset-header-text' and text()='Execution infos']",
				WAIT_TIME);
		selenium.refresh();
		this.sleep(3000);
		this.waitForElementDispear(
				"//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[text()='Loading...']",
				WAIT_TIME);
	}

	@Test
	public void testMenuGraphic() {
		// check menu graphic
		this.clickWaitForElementPresent("!!!menu.graphic_task_executions_history.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Graphic']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[text()='apply']",
				WAIT_TIME);
		selenium.refresh();
		this.sleep(3000);
		this.waitForElementDispear(
				"//div[@class='header-title' and text()='Graphic']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[text()='Loading...']",
				WAIT_TIME);
	}

//	@Test
	public void testMenuSoaDashboard() {
		// check menu soa
		this.clickWaitForElementPresent("!!!menu.soamanager.dashboard.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='SOA']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class=' x-component' and text()='Service']",
				WAIT_TIME);
		selenium.refresh();
		this.sleep(3000);
		this.waitForElementDispear(
				"//div[@class='header-title' and text()='SOA']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[text()='Loading...']",
				WAIT_TIME);
	}

	@Test
	public void testMenuJobAnalyses() {

		// check menu job analysis
		this.clickWaitForElementPresent("!!!menu.dashjobs.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Jobs analyses']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[text()='Job execution analysis']",
				WAIT_TIME);
		selenium.refresh();
		this.sleep(3000);
		this.waitForElementDispear(
				"//div[@class='header-title' and text()='Jobs analyses']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[text()='Loading...']",
				WAIT_TIME);

	}

}
