package com.talend.tac.cases.executePlan;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestChangeRootTaskNameOfPlan extends Plan {

	
	@Test
	
	@Parameters({"plan.unexecuted.label","plan.unexecuted.tasklabel","plan.task","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testChangePlanRootTaskName(String planlabel,String taskLabel,String task,String des,String pro,String branch,String job,String version,String context,String server,String statistic) {
		taskLabel = "testPlanChangeTask";
		planlabel = "testChangePlantask";
		this.addTask(taskLabel, des, pro, branch, job, version, context, server, statistic);
		this.addPlan(planlabel, taskLabel, "testChangePlantask");
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"
				+ rb.getString("menu.jobConductor") + "']"));
		selenium.setSpeed(MIN_SPEED);
		this.waitForElementPresent("//span[text()='" + taskLabel + "']", WAIT_TIME);
        this.sleep(2000);
        selenium.mouseDown("//span[text()='" + taskLabel + "']");
        taskLabel = "testPlanChangeTaskNew";
        this.typeString("idJobConductorTaskLabelInput", taskLabel);
        this.selectDropDownList("idJobConductorTaskStatisticsListBox",
				"enabled");
        selenium.click("//span[@class='x-fieldset-header-text' and text()='Execution task']/ancestor::div[@class=' x-panel x-component']//button[@id='idFormSaveButton']");
        this.waitForElementPresent("//span[@title='testPlanChangeTaskNew' and text()='testPlanChangeTaskNew']", WAIT_TIME);
        this.openExecutionPlanMenu();
        this.waitForElementPresent("//span[text()='" + planlabel + "']",
				WAIT_TIME);
        selenium.click("idSubModuleRefreshButton");
        this.waitForElementPresent("//span[text()='RootTask']//ancestor::div[@class='x-grid3-viewport']//span[@title='testPlanChangeTaskNew' and text()='testPlanChangeTaskNew']",
				WAIT_TIME);
	}

}
