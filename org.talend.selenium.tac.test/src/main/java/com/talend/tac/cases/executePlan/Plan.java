package com.talend.tac.cases.executePlan;

import org.testng.Assert;

import com.talend.tac.cases.executionTask.TaskUtils;

public class Plan extends TaskUtils {
	public static int TriggerCheckTime = 40;

	public void openExecutionPlanMenu() {
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Execution Plan']",
				WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
	}

	/*
	 * public void addTask(String label, String description, String projectName,
	 * String branchName, String jobName, String version, String context, String
	 * serverName, String statisticName) {
	 * this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
	 * selenium.setSpeed(MID_SPEED);
	 * Assert.assertTrue(selenium.isElementPresent("//div[text()='" +
	 * rb.getString("menu.jobConductor") + "']")); selenium.setSpeed(MIN_SPEED);
	 * selenium.click("idSubModuleAddButton");
	 * this.typeString("idJobConductorTaskLabelInput", label);// plan name
	 * this.typeString("idJobConductorTaskDescInput", description);// plan name
	 * if (!selenium.isChecked("idJobConductorTaskActiveListBox")) {
	 * selenium.click("idJobConductorTaskActiveListBox");// check active
	 * Assert.assertTrue(selenium
	 * .isChecked("idJobConductorTaskActiveListBox")); }
	 * this.selectDropDownList("idTaskProjectListBox", projectName);
	 * this.selectDropDownList("idTaskBranchListBox", branchName);
	 * this.selectDropDownList("idTaskJobListBox", jobName);
	 * this.selectDropDownList("idTaskVersionListBox", version);
	 * this.selectDropDownList("idTaskContextListBox", context);
	 * this.selectDropDownList("idJobConductorExecutionServerListBox",
	 * serverName);
	 * this.selectDropDownList("idJobConductorTaskStatisticsListBox",
	 * statisticName);
	 * this.selectDropDownList("idJobConductorOnUnavailableJobServerListBox",
	 * "Wait"); if (!selenium.isElementPresent("//span[text()='" + label +
	 * "']")) { selenium.click(
	 * "//span[@class='x-fieldset-header-text' and text()='Execution task']/ancestor::div[@class=' x-panel x-component']//button[@id='idFormSaveButton']"
	 * ); this.waitForElementPresent("//span[text()='" + label + "']",
	 * Base.WAIT_TIME); } }
	 */

	public void addPlan(String planLabel, String rootTask, String description) {

		this.openExecutionPlanMenu();
		this.clickWaitForElementPresent("//button[text()='Add plan']");
		this.typeString("idExecutionPlanPlanFormLabelInput", planLabel);
		this.typeString("idExecutionPlanPlanFormDescInput", description);
		// selenium.setSpeed(MID_SPEED);
		this.selectDropDownList("String idExecutionPlanPlanFormTaskComboBox",
				rootTask);
		selenium.mouseDown("//span[@class='x-fieldset-header-text' and text()='Execution Plan']/ancestor::div[@class=' x-panel x-component']//button[@id='idFormSaveButton']");
		selenium.click("//span[@class='x-fieldset-header-text' and text()='Execution Plan']/ancestor::div[@class=' x-panel x-component']//button[@id='idFormSaveButton']");
		selenium.mouseUp("//span[@class='x-fieldset-header-text' and text()='Execution Plan']/ancestor::div[@class=' x-panel x-component']//button[@id='idFormSaveButton']");
		this.waitForElementPresent("//span[text()='" + planLabel + "']",
				WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"
				+ planLabel + "']"));
		selenium.setSpeed(MIN_SPEED);
		// selenium.refresh();
		this.waitForElementPresent("//span[text()='" + planLabel + "']",
				WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//span[text()='" + planLabel + "']");
		System.out.println("++++++++++++++"+rootTask);
		System.out.println("---------------"+selenium.getValue("String idExecutionPlanPlanFormTaskComboBox"));
		
		Assert.assertTrue(
				selenium.getValue("String idExecutionPlanPlanFormTaskComboBox")
						.equals(rootTask), "plan added failed!");
	}

	public void deletePlan(String planLabel) {
		this.waitForElementPresent("//span[text()='" + planLabel + "']",
				WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//span[text()='" + planLabel + "']");
		selenium.chooseOkOnNextConfirmation();
		selenium.chooseOkOnNextConfirmation();
		selenium.click("//div[text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleDeleteButton']");
		this.sleep(3000);
		selenium.getConfirmation();
		selenium.getConfirmation();
		this.sleep(3000);
		Assert.assertFalse(
				selenium.isElementPresent("//span[text()='" + planLabel + "']"),
				"plan " + planLabel + " delete failed! ");
	}

	public void runPlan(String planLabel) {
		this.waitForElementPresent("//span[text()='" + planLabel + "']",
				WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//span[text()='" + planLabel + "']");
		this.sleep(2000);
		selenium.click("//div[text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idJobConductorTaskRunButton']");

	}

	public void runPlanAndCheck(String planLabel, String taskName,
			int executeTimes, String expectedStatus) {
		selenium.refresh();
		this.waitForElementPresent("//span[text()='" + planLabel + "']",
				WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//span[text()='" + planLabel + "']");
		for (int i = 0; i < executeTimes; i++) {
			selenium.click("//div[text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idJobConductorTaskRunButton']");
			this.waitForElementPresent("//span[text()='Running...']", WAIT_TIME);
			this.waitForElementPresent("//span[text()='"+planLabel+"']//ancestor::table[@class='x-grid3-row-table']//span[text()='Ready to run']",
					MAX_WAIT_TIME);
			this.sleep(3000);
			String actualStatus = selenium.getText("//div[contains(@class,'x-tree3-node-ct x-tree3 x-component x-unselectable')]//span[2]");
			actualStatus = actualStatus.trim();
			System.out.println("actualStatus+"+actualStatus);
			Assert.assertEquals(actualStatus, expectedStatus);
			this.sleep(2000);
		}

	}

	public void addSimpleTrigger(String plantoaddsimletrigger,
			String simpletriggerlabel) throws InterruptedException {
		TriggerDate date = new TriggerDate();
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Execution Plan']",
				WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
		this.waitForElementPresent("//span[text()='" + plantoaddsimletrigger
				+ "']", WAIT_TIME);
		this.sleep(3000);
		selenium.mouseDown("//span[text()='" + plantoaddsimletrigger + "']");
		selenium.click("//button[text()='Add trigger...']");// add a trigger
		selenium.click("//a[text()='Add simple trigger']");// add a
															// SimpleTrigger
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"
				+ rb.getString("trigger.action.addSimpleTrigger") + "']"));
		Thread.sleep(5000);
		selenium.setSpeed(MIN_SPEED);
		// type simple trigger label
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='label']",
				simpletriggerlabel);// label
		// type simple trigger description
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='description']",
				"SimpleTrigger");// description
		// type simple trigger start time
		this.typeString("//input[@name='startTime']", date.getFuture("24"));
		// this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='startTime']",
		// date.getFuture("24"));//description
		// type simple trigger end time
		this.typeString("//input[@name='endTime']", date.getFuture("48"));
		// this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='endTime']",
		// date.getFuture("48"));//description
		// type simple trigger repeat count
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatCount']",
				"40");// description
		// type simple trigger repeat interval
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatInterval']",
				"15");// Number of triggerings
		// selenium.click("//span[text()='Add simple trigger']/parent::legend/parent::fieldset/parent::form/parent::div/parent::div/parent::div/parent::div/parent::div//button[@id='idFormSaveButton']");
		selenium.click("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSimpleTriggerSave']");
		// selenium.setSpeed(MID_SPEED);
		// Thread.sleep(5000);
		this.waitForElementPresent("//span[text()='" + simpletriggerlabel
				+ "']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"
				+ simpletriggerlabel + "']"));
		selenium.setSpeed(MIN_SPEED);
	}

	public void deleteTrigger(String fileTriggerLabel) {
		this.waitForElementPresent("//span[text()='" + fileTriggerLabel + "']",
				WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//span[text()='" + fileTriggerLabel + "']");
		selenium.chooseOkOnNextConfirmation();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.click("//div[text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idTriggerDelete']");
		selenium.getConfirmation();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertFalse(
				selenium.isElementPresent("//span[text()='" + fileTriggerLabel
						+ "']"), "trigger delete failed!");
	}

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
