package com.talend.tac.cases.grid;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Parameters;

public class TestGridPageSize extends Grid {

	@Test
	@Parameters({ "grid.task.label", "labelDescription",
			"addCommonProjectName", "branchNameTrunk", "jobNameTJava",
			"version0.1", "context", "serverForUseAvailable",
			"statisticEnabled" })
	public void testPastExecutionsEqualsToPageSizeWithFutureExecs(String label,
			String description, String projectName, String branchName,
			String jobName, String version, String context, String serverName,
			String statisticName) {
		this.cleanTask();
		this.addTask(label, description, projectName, branchName, jobName,
				version, context, serverName, statisticName);
		this.runTask(label, 11);
		this.addSimpleTriggerForTask(label, "testTrigger", "60", "5");
		this.openGridMenu();
		this.sleep(5000);
		this.clickWaitForElementPresent("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//td[@class='x-toolbar-left']//tr[@class='x-toolbar-left-row']//td[1]//table//button");
		this.sleep(5000);
		Assert.assertTrue(
				selenium.getValue(
						"//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']")
						.equals("1"), "go to first page by UI button failed!");
		Assert.assertTrue(
				selenium.getXpathCount(
						"//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "
								+ label + "']").intValue() == 10,
				"Grid past execution display failed!");

	}

	@Test
	@Parameters({ "grid.task.label", "labelDescription",
			"addCommonProjectName", "branchNameTrunk", "jobNameTJava",
			"version0.1", "context", "serverForUseAvailable",
			"statisticEnabled" })
	public void testFutureExecutionsGreaterThenPageSizeWithoutPastExecutions(
			String label, String description, String projectName,
			String branchName, String jobName, String version, String context,
			String serverName, String statisticName) {
		this.cleanTask();
		this.addTask(label, description, projectName, branchName, jobName,
				version, context, serverName, statisticName);
		this.runTask(label, 4);
		this.openGridMenu();
		this.sleep(5000);
		this.waitForElementPresent(
				"//div[@class=' x-form-field-wrap  x-component ' and @title='Enter the number of items per page']//input",
				WAIT_TIME);
		selenium.type(
				"//div[@class=' x-form-field-wrap  x-component ' and @title='Enter the number of items per page']//input",
				"2");
		selenium.keyDown(
				"//div[@class=' x-form-field-wrap  x-component ' and @title='Enter the number of items per page']//input",
				"\\13");
		this.clickWaitForElementPresent("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//td[@class='x-toolbar-left']//tr[@class='x-toolbar-left-row']//td[1]//table//button");
		this.sleep(5000);
		Assert.assertTrue(
				selenium.getValue(
						"//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']")
						.equals("1"), "go to first page by UI button failed!");
		Assert.assertTrue(
				selenium.getXpathCount(
						"//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "
								+ label + "']").intValue() == 2,
				"Grid past execution display failed!");
		selenium.click("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//td[@class='x-toolbar-left']//tr[@class='x-toolbar-left-row']//td[9]//table//button");
		this.sleep(5000);
		Assert.assertTrue(
				selenium.getValue(
						"//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']")
						.equals("2"), "go to last page by UI button failed!");

	}

	@Test
	@Parameters({ "grid.task.label", "labelDescription",
			"addCommonProjectName", "branchNameTrunk", "jobNameTJava",
			"version0.1", "context", "serverForUseAvailable",
			"statisticEnabled" })
	public void testFutureTriggerExecutionsCountsSameWithPageSize(String label,
			String description, String projectName, String branchName,
			String jobName, String version, String context, String serverName,
			String statisticName) {
		this.cleanTask();
		this.addTask(label, description, projectName, branchName, jobName,
				version, context, serverName, statisticName);
		this.addSimpleTriggerForTask(label, "testTrigger", "3600", "9");
		this.waitForElementPresent("//span[@title='Generating...']", WAIT_TIME);
//	    this.waitForElementPresent("//span[@title='Ready to deploy']", MAX_WAIT_TIME);
		this.waitForElementPresent("//span[@title='Ready to run']", MAX_WAIT_TIME);
		this.sleep(8000);
		this.openGridMenu();
		this.sleep(5000);
		this.waitForElementPresent(
				"//div[@class=' x-form-field-wrap  x-component ' and @title='Enter the number of items per page']//input",
				WAIT_TIME);
		this.sleep(5000);
		Assert.assertTrue(
				selenium.getXpathCount(
						"//span[@title='Waiting for triggering...']")
						.intValue() == 9,
				"Grid waiting for triggering counts is wrong!");
		Assert.assertTrue(
				selenium.getXpathCount(
						"//div[@class='x-grid3-cell-inner x-grid3-col-detailedStatus']//span[@title='Generating...']")
						.intValue() <= 1, "Grid generating counts is wrong!");
	}

	@Test
	@Parameters({ "grid.task.label", "labelDescription",
			"addCommonProjectName", "branchNameTrunk", "jobNameTJava",
			"version0.1", "context", "serverForUseAvailable",
			"statisticEnabled" })
	public void testMisfiredExecutionsAddedWithServerStarting(String label,
			String description, String projectName, String branchName,
			String jobName, String version, String context, String serverName,
			String statisticName) {
		this.cleanTask();
		this.addTask(label, description, projectName, branchName, jobName,
				version, context, serverName, statisticName);
		this.runTask(label, 1);
		this.addSimpleTriggerForTask(label, "testTrigger", "6", "10");
		this.waitForElementPresent(
				"//span[@title='11 / 11' and text()='11 / 11']", MAX_WAIT_TIME);
		this.sleep(8000);
		this.openGridMenu();
		this.sleep(5000);
		selenium.click("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//td[@class='x-toolbar-left']//tr[@class='x-toolbar-left-row']//td[9]//table//button");
		this.sleep(5000);
		Assert.assertTrue(selenium.getXpathCount("//span[@title='Ok']")
				.intValue() == 2, "test go to last page failed");
		Assert.assertTrue(selenium.getXpathCount("//span[@title='Misfired!']")
				.intValue() == 0, "test go to last page failed");
		selenium.click("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//td[@class='x-toolbar-left']//tr[@class='x-toolbar-left-row']//td[2]//table//button");
		this.sleep(2000);
		Assert.assertTrue(
				selenium.getValue(
						"//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']")
						.equals("1"), "go to first page by UI button failed!");
		Assert.assertTrue(selenium.getXpathCount("//span[@title='Ok']")
				.intValue() == 10, "test go to last page failed");
		Assert.assertTrue(selenium.getXpathCount("//span[@title='Misfired!']")
				.intValue() == 0, "test go to last page failed");
	}

//	@Test
	@Parameters({ "grid.task.label", "labelDescription",
			"addCommonProjectName", "branchNameTrunk", "jobNameTJava",
			"version0.1", "context", "serverForUseAvailable",
			"statisticEnabled" })
	public void testFirstPageWithPreviousAndNextAndMoreInNextPage(String label,
			String description, String projectName, String branchName,
			String jobName, String version, String context, String serverName,
			String statisticName) {
		this.cleanTask();
		this.addTask(label, description, projectName, branchName, jobName,
				version, context, serverName, statisticName);
		this.runTask(label, 1);
		this.addSimpleTriggerForTask(label, "testTrigger", "10", "48");
		this.waitForElementPresent(
				"//span[@title='1 / 49' and text()='1 / 49']", MAX_WAIT_TIME);
		this.sleep(5000);
		this.openGridMenu();
		this.sleep(5000);
		this.waitForElementPresent(
				"//div[@class=' x-form-field-wrap  x-component ' and @title='Enter the number of items per page']//input",
				WAIT_TIME);
		selenium.type(
				"//div[@class=' x-form-field-wrap  x-component ' and @title='Enter the number of items per page']//input",
				"20");
		selenium.keyDown(
				"//div[@class=' x-form-field-wrap  x-component ' and @title='Enter the number of items per page']//input",
				"\\13");
		this.sleep(5000);
		int ok = selenium.getXpathCount("//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@title='Ok']").intValue();
		int running = selenium.getXpathCount("//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@title='Running...']")
				.intValue();
		int waiting = selenium.getXpathCount(
				"//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@title='Waiting for triggering...']").intValue();
		System.out.println("ok+"+ok);
		System.out.println("running+"+running);
		System.out.println("waiting+"+waiting);
		Assert.assertTrue(ok >= 1, "test go to last page failed");
//		Assert.assertTrue((running == 1)||(running == 0), "test go to last page failed");
		Assert.assertTrue(waiting >= 1, "test go to last page failed");
		Assert.assertTrue(ok + running + waiting == 20,
				"test go to last page failed");
		selenium.click("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//td[@class='x-toolbar-left']//tr[@class='x-toolbar-left-row']//td[8]//table//button");
		this.sleep(5000);
		ok = selenium.getXpathCount("//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@title='Ok']").intValue();
		running = selenium.getXpathCount("//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@title='Running...']")
				.intValue();
		waiting = selenium.getXpathCount(
				"//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@title='Waiting for triggering...']").intValue();
		Assert.assertTrue(ok == 0, "test go to last page failed");
		Assert.assertTrue(running == 0, "test go to last page failed");
		Assert.assertTrue(waiting == 20, "test go to last page failed");
		Assert.assertTrue(
				selenium.getValue(
						"//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']")
						.equals("2"));
		selenium.click("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//td[@class='x-toolbar-left']//tr[@class='x-toolbar-left-row']//td[8]//table//button");
		this.sleep(5000);
		ok = selenium.getXpathCount("//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@title='Ok']").intValue();
		running = selenium.getXpathCount("//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@title='Running...']")
				.intValue();
		waiting = selenium.getXpathCount(
				"//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@title='Waiting for triggering...']").intValue();
		Assert.assertTrue(ok == 0, "test go to last page failed");
		Assert.assertTrue(running == 0, "test go to last page failed");
		Assert.assertTrue(waiting == 10, "test go to last page failed");
		Assert.assertTrue(
				selenium.getValue(
						"//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']")
						.equals("3"));

	}
	
	@Test
	@Parameters({ "grid.task.label", "labelDescription",
			"addCommonProjectName", "branchNameTrunk", "jobNameTJava",
			"version0.1", "context", "serverForUseAvailable",
			"statisticEnabled" })
	public void testSetPageSizeWithModuloCountOfFutureTriggerings(String label,
			String description, String projectName, String branchName,
			String jobName, String version, String context, String serverName,
			String statisticName) {
		this.cleanTask();
		this.addTask(label, description, projectName, branchName, jobName,
				version, context, serverName, statisticName);
		
		this.addSimpleTriggerForTask(label, "testTrigger", "3600", "30");
		this.sleep(5000);
		this.openGridMenu();
		this.sleep(5000);
		this.waitForElementPresent(
				"//div[@class=' x-form-field-wrap  x-component ' and @title='Enter the number of items per page']//input",
				WAIT_TIME);
		this.sleep(2000);
		Assert.assertTrue(
				selenium.getXpathCount(
						"//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "
								+ label + "']").intValue() == 10,
				"Grid past execution display failed!");
		for (int i = 0; i < 2; i++) {
			selenium.click("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//td[@class='x-toolbar-left']//tr[@class='x-toolbar-left-row']//td[8]//table//button");
			this.sleep(3000);
			Assert.assertTrue(
					selenium.getXpathCount(
							"//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "
									+ label + "']").intValue() == 10,
					"Grid past execution display failed!");
			Assert.assertTrue(
					selenium.getValue(
							"//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']")
							.equals(""+(i+2)));
		}
		selenium.click("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//td[@class='x-toolbar-left']//tr[@class='x-toolbar-left-row']//td[8]//table//button");
		this.sleep(5000);
		Assert.assertTrue(
				selenium.getXpathCount(
						"//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "
								+ label + "']").intValue() == 1,
				"Grid past execution display failed!");
		Assert.assertTrue(
				selenium.getValue(
						"//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']")
						.equals("4"));
		
		selenium.click("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//td[@class='x-toolbar-left']//tr[@class='x-toolbar-left-row']//td[8]//table//button");
		this.sleep(5000);
		System.out.println(selenium.getXpathCount(
						"//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "
								+ label + "']").intValue());
		String pageNum =selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']");
		Assert.assertTrue(Integer.parseInt(pageNum) >= 4);
	}
	
}
