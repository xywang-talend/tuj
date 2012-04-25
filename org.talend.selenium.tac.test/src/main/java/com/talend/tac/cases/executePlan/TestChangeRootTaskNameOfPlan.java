package com.talend.tac.cases.executePlan;

import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestChangeRootTaskNameOfPlan extends Plan {

	
	@Test
	
	@Parameters({"plan.unexecuted.label","plan.unexecuted.tasklabel","plan.task","labelDescription","AddcommonProjectname","branchNameTrunk","jobNameTJava","version0.1",
		"context","ServerForUseAvailable","statisticEnabled"})
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
        String taskNewLabel = "testPlanChangeTaskNew";
        this.typeString("idJobConductorTaskLabelInput", taskNewLabel);
        this.selectDropDownList("idJobConductorTaskStatisticsListBox",
				"enabled");
        selenium.click("//span[@class='x-fieldset-header-text' and text()='Execution task']/ancestor::div[@class=' x-panel x-component']//button[@id='idFormSaveButton']");
       
        this.waitForElementPresent("//span[text()='" + taskNewLabel + "']", WAIT_TIME);
        this.openExecutionPlanMenu();         
        selenium.refresh();
        this.waitForElementPresent("//span[text()='" + planlabel + "']", WAIT_TIME);        
        selenium.mouseDown("//span[text()='" + planlabel + "']");        
        this.waitForTextPresent("Task: \""+taskNewLabel+"\"",
				WAIT_TIME);
	    this.clickWaitForElementPresent("//span[text()='Planned task tree view']//ancestor::div[contains(@class,'x-small-editor x-panel-header x-component x-unselectable')]//following-sibling::div//div[2]//div[@class='x-tree3-node']//div[contains(@class,'x-tree3-el') and @aria-level='1']//span[@class='x-tree3-node-text']");
	    this.waitForElementPresent("//input[@id='idExecutionPlanTreeFormTaskComboBox']",
			WAIT_TIME);
        Assert.assertEquals(selenium.getValue("idExecutionPlanTreeFormTaskComboBox"), taskNewLabel);
        
	}

}
