package com.talend.tac.cases.executePlan;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestRunPlan extends Plan {

	@Test
	@Parameters({ "plan.unexecuted.label", "plan.unexecuted.tasklabel",
			"labelDescription", "addCommonProjectName", "branchNameTrunk",
			"jobNameTJava", "version0.1", "context", "serverForUseAvailable",
			"statisticEnabled" })
	public void testRunPlanDirectlyByClickRunButton(String planlabel,
			String tasklabel, String labelDescription, String commonpro,
			String branch, String jobName, String version, String context,
			String jobServer, String statistic) {
		// this.addPlan(planLabel, rootTask, "treeManagePlan");
		planlabel = planlabel + "RunByClickRun";
		tasklabel = tasklabel + "RunByClickRun";
		addTask(tasklabel, labelDescription, commonpro, branch, jobName,
				version, context, jobServer, statistic);
		addPlan(planlabel, tasklabel, "planunexcutedRunbyclickrun");
		this.runPlan(planlabel);
		this.waitForElementPresent("[RUNNING]",WAIT_TIME);
		this.waitForElementPresent("[OK]", MAX_WAIT_TIME);
//		this.waitForElementPresent(
//				"//span[@class='x-tree3-node-text' and text()='" + tasklabel
//						+ " : [OK]']", MAX_WAIT_TIME);
	}

	@Test
	@Parameters({ "plan.unexecuted.label", "plan.unexecuted.tasklabel",
			"labelDescription", "addCommonProjectName", "branchNameTrunk",
			"jobNameTJava", "version0.1", "context", "ServerForUseAvailable",
			"statisticEnabled" })
	public void testRunPlanByTrigger(String planlabel, String tasklabel,
			String labelDescription, String commonpro, String branch,
			String jobName, String version, String context, String jobServer,
			String statistic) {
		// this.addPlan(planLabel, rootTask, "treeManagePlan");
		planlabel = planlabel + "RunByTrigger";
		tasklabel = tasklabel + "RunByTrigger";
		addTask(tasklabel, labelDescription, commonpro, branch, jobName,
				version, context, jobServer, statistic);
		addPlan(planlabel, tasklabel, "planunexcutedRunbyTrigger");
		//
		this.sleep(2000);
		selenium.mouseDown("//span[text()='" + planlabel + "']");// select a
		this.sleep(2000); // exist
		this.clickWaitForElementPresent("//div[text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idTriggerAdd trigger...']");// add
		selenium.click("//a[text()='Add simple trigger']");// add a
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"
				+ rb.getString("trigger.action.addSimpleTrigger") + "']"));
		selenium.setSpeed(MIN_SPEED);
		// type simple trigger label
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='label']",
				"RunPlanByTrigier");// label
		// type simple trigger description
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='description']",
				"SimpleTrigger");// description
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatCount']",
				"");// description
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatInterval']",
				"30");// Number of triggerings
		selenium.click("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSimpleTriggerSave']");
		this.waitForElementPresent("//span[text()='RunPlanByTrigier']",
				WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//span[text()='RunPlanByTrigier']"));
		selenium.setSpeed(MIN_SPEED);
		this.waitForElementPresent("[RUNNING]", WAIT_TIME);
		this.waitForElementPresent("[OK]", MAX_WAIT_TIME);
//		this.waitForElementPresent(
//				"//span[@class='x-tree3-node-text' and text()='" + tasklabel
//						+ " : [OK]']", MAX_WAIT_TIME);
		//delete trigger added
		this.deleteTrigger("RunPlanByTrigier");
	}

}
