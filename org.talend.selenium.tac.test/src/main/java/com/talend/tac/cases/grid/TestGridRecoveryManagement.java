package com.talend.tac.cases.grid;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Parameters;

public class TestGridRecoveryManagement extends Grid {

	// @Test
	@Parameters({ "grid.task.label", "labelDescription",
			"addCommonProjectName", "branchNameTrunk", "jobNameTJava",
			"version0.1", "context", "serverForUseAvailable",
			"statisticEnabled" })
	public void testGridWaitingExecutionHasNoRecovery(String label,
			String description, String projectName, String branchName,
			String jobName, String version, String context, String serverName,
			String statisticName) {
		this.cleanTask();
		this.addTask(label, description, projectName, branchName, jobName,
				version, context, serverName, statisticName);
		this.openGridMenu();
		this.sleep(5000);
		Assert.assertTrue(
				selenium.getXpathCount(
						"//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "
								+ label + "']").intValue() == 0,
				"Grid past execution display failed!");
		this.openTaskMenu();
		this.addSimpleTriggerForTask(label, "testSimpleTrigger", "3600", "3");
		this.waitForTextPresent("Generating...", WAIT_TIME);
		this.waitForElementPresent("//span[text()='Ready to run']", MAX_WAIT_TIME);
		this.openGridMenu();
		this.sleep(5000);
		Assert.assertTrue(
				selenium.getXpathCount(
						"//span[@title='Waiting for triggering...' and text()='Waiting for triggering...']")
						.intValue() == 3,
				"Grid Future execution display failed!");
	}

	@Test
	@Parameters({ "grid.task.label", "labelDescription",
			"addCommonProjectName", "branchNameTrunk", "jobNameTJava",
			"version0.1", "context", "serverForUseAvailable",
			"statisticEnabled" })
	public void testGridShowStatisticView(String label, String description,
			String projectName, String branchName, String jobName,
			String version, String context, String serverName,
			String statisticName) {
		this.cleanTask();
		this.addTask(label, description, projectName, branchName, jobName,
				version, context, serverName, statisticName);
		this.openGridMenu();
		this.sleep(5000);
		Assert.assertTrue(
				selenium.getXpathCount(
						"//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "
								+ label + "']").intValue() == 0,
				"Grid past execution display failed!");
		this.openTaskMenu();
		this.runTask(label, 1);
		this.openGridMenu();
		this.sleep(5000);
		Assert.assertTrue(
				selenium.getXpathCount(
						"//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "
								+ label + "']").intValue() == 1,
				"Grid Future execution display failed!");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "
						+ label
						+ "']//ancestor::table[@class='x-grid3-row-table']//table[@title='Show statistic view']//button[@class='x-btn-text']",
				WAIT_TIME);
		selenium.click("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "
				+ label
				+ "']//ancestor::table[@class='x-grid3-row-table']//table[@title='Show statistic view']//button[@class='x-btn-text']");
		
		//verify informations about contexts
		this.waitForElementPresent(
				"//span[@class='x-fieldset-header-text' and text()='Context Parameters']",
				WAIT_TIME);
		this.waitForElementPresent(
				"//span[@class='x-fieldset-header-text' and text()='Context Parameters']//ancestor::fieldset[@class=' x-fieldset x-component']//textarea",
				WAIT_TIME);
		this.sleep(5000);
		String statisticLogsContext = selenium
				.getValue("//span[@class='x-fieldset-header-text' and text()='Context Parameters']//ancestor::fieldset[@class=' x-fieldset x-component']//textarea");
		System.out.println(statisticLogsContext);
		Assert.assertTrue(statisticLogsContext.contains("name: JackZhang"));
		Assert.assertTrue(statisticLogsContext.contains("age: 23"));
        //verify informations about TASK
		Assert.assertTrue(selenium.getValue("//label[text()='Task:']//ancestor::div[@class='x-form-item ']//input").equals("Task: "+label), "Task task information shows wrong!");
		Assert.assertTrue(selenium.getValue("//span[@class='x-fieldset-header-text' and text()='Task']//ancestor::fieldset[@class=' x-fieldset x-component']//label[text()='Project:']//ancestor::div[@class='x-form-item ']//input").contains(projectName), "Task project information shows wrong!");
	    //verify job execution
		Assert.assertTrue(selenium.getValue("//span[@class='x-fieldset-header-text' and text()='Job Execution']//ancestor::fieldset[@class=' x-fieldset x-component']//label[text()='Job Server:']//ancestor::div[@class='x-form-item ']//input").contains(serverName), "Task server information shows wrong!");
		Assert.assertTrue(selenium.getValue("//span[@class='x-fieldset-header-text' and text()='Job Execution']//ancestor::fieldset[@class=' x-fieldset x-component']//label[text()='Job:']//ancestor::div[@class='x-form-item ']//input").contains(jobName), "Task job information shows wrong!");
	}
	
	@Test
	@Parameters({ "grid.task.label", "labelDescription",
			"addCommonProjectName", "branchNameTrunk", "jobNameTJava",
			"version0.1", "context", "serverForUseAvailable",
			"statisticEnabled" })
	public void testGridExecutionInfo(String label, String description,
			String projectName, String branchName, String jobName,
			String version, String context, String serverName,
			String statisticName) {
		this.cleanTask();
		this.addTask(label, description, projectName, branchName, jobName,
				version, context, serverName, statisticName);
		this.openGridMenu();
		this.sleep(5000);
		Assert.assertTrue(
				selenium.getXpathCount(
						"//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "
								+ label + "']").intValue() == 0,
				"Grid past execution display failed!");
		this.openTaskMenu();
		this.runTask(label, 1);
		this.openGridMenu();
		this.sleep(5000);
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "
				+ label + "']", WAIT_TIME);
		Assert.assertTrue(
				selenium.getXpathCount(
						"//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "
								+ label + "']").intValue() == 1,
				"Grid Future execution display failed!");
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "
								+ label + "']");
	    this.sleep(4000);
	    this.waitForTextPresent(serverName, WAIT_TIME);
	    Assert.assertTrue(selenium.getValue("//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//textarea[@name='contextValues']").contains("birth: yyyy-MM-dd HH:mm:ss;1988-08-13 00:00:00"), "test execution infor shows in grid failed!");
	    Assert.assertTrue(selenium.getValue("//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//textarea[@name='contextValues']").contains("name: JackZhang"), "test execution infor shows in grid failed!");
	    Assert.assertTrue(selenium.getValue("//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//textarea[@name='contextValues']").contains("age: 23"), "test execution infor shows in grid failed!");
	    Assert.assertTrue(selenium.getText("//label[text()='Triggered by:']//ancestor::div[@class='x-form-item ']//div[contains(@class,'x-form-label x-component')]").contains("Manual run by user 'admin@company.com'"),"test run task directly execution infor trigger by show wrong!");
	    
	}
	
	@Test
	@Parameters({ "grid.task.label", "labelDescription",
			"addCommonProjectName", "branchNameTrunk", "jobNameTJava",
			"version0.1", "context", "ServerForUseAvailable",
			"statisticEnabled" })
	public void testGridExecutionInfoRunByTrigger(String label, String description,
			String projectName, String branchName, String jobName,
			String version, String context, String serverName,
			String statisticName) {
		this.cleanTask();
		this.addTask(label, description, projectName, branchName, jobName,
				version, context, serverName, statisticName);
		this.addSimpleTriggerForTask(label, "test", "10", "2");
		this.waitForTextPresent("3 / 3", MAX_WAIT_TIME);
		this.waitForElementPresent("//img[@title='Completed']", WAIT_TIME);
		this.sleep((WAIT_TIME/3)*1000);
		this.openGridMenu();
		this.sleep(5000);
		Assert.assertTrue(
				selenium.getXpathCount(
						"//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "
								+ label + "']").intValue() == 3,
				"Grid past execution display failed!");
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "
								+ label + "']");
	    this.sleep(4000);
	    this.waitForTextPresent(serverName, WAIT_TIME);
	    Assert.assertTrue(selenium.getValue("//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//textarea[@name='contextValues']").contains("birth: yyyy-MM-dd HH:mm:ss;1988-08-13 00:00:00"), "test execution infor shows in grid failed!");
	    Assert.assertTrue(selenium.getValue("//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//textarea[@name='contextValues']").contains("name: JackZhang"), "test execution infor shows in grid failed!");
	    Assert.assertTrue(selenium.getValue("//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//textarea[@name='contextValues']").contains("age: 23"), "test execution infor shows in grid failed!");
	    Assert.assertTrue(selenium.getText("//label[text()='Triggered by:']//ancestor::div[@class='x-form-item ']//div[contains(@class,'x-form-label x-component')]").contains("SimpleTrigger[talendTriggerName='test'"),"test run task by trigger execution infor trigger by show wrong!");
	    Assert.assertTrue(selenium.getText("//label[text()='Trigger type:']//ancestor::div[@class='x-form-item ']//div[contains(@class,'x-form-label x-component')]").contains("SimpleTrigger"), "execution infor test trigger type failed!");
	    
	}
	

}
