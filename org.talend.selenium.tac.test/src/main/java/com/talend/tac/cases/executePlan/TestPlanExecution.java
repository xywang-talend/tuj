package com.talend.tac.cases.executePlan;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPlanExecution extends Plan {

	
	@Test
	@Parameters({"plan.unexecuted.label","plan.unexecuted.tasklabel","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","ServerForUseAvailable","statisticEnabled"})
	public void testGeneratePlan(String planlabel,String tasklabel, String labelDescription,String commonpro,String branch,String jobName,
			String version,String context,String jobServer,String statistic) throws InterruptedException {
		
		addTask(tasklabel, labelDescription,commonpro,
				branch, jobName,version, context,
				jobServer,statistic);
		addPlan(planlabel, tasklabel,"planunexcuted") ;
		selenium.refresh();
		this.waitForElementPresent("//span[text()='" + planlabel + "']", WAIT_TIME);
		Thread.sleep(2000);
		selenium.mouseDown("//span[text()='" + planlabel + "']");
		selenium.click("//div[text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idJobConductorTaskGenerateButton']");
		this.waitForElementPresent("//span[text()='Generating...']", WAIT_TIME);
		this.waitForElementPresent("//span[text()='Ready to deploy']", MAX_WAIT_TIME);
	}
	
	@Test
	@Parameters({"plan.unexecuted.label"})
	public void testDeployPlan(String planLabel){
		this.openExecutionPlanMenu();
		this.waitForElementPresent("//span[text()='" + planLabel + "']", WAIT_TIME);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.mouseDown("//span[text()='" + planLabel + "']");
		this.sleep(2000);
		selenium.click("//div[text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idJobConductorTaskDeployButton']");
		this.waitForElementPresent("//span[text()='Ready to run']", MAX_WAIT_TIME);
		
	}
	
	@Test
	@Parameters({"plan.unexecuted.label"})
	public void testRunPlan(String planLabel){
		this.openExecutionPlanMenu();
		this.waitForElementPresent("//span[text()='" + planLabel + "']", WAIT_TIME);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.mouseDown("//span[text()='" + planLabel + "']");
		this.sleep(2000);
		selenium.click("//div[text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idJobConductorTaskRunButton']");
		this.waitForElementPresent("[RUNNING]", WAIT_TIME);
		this.waitForElementPresent("[OK]", MAX_WAIT_TIME);
		this.waitForElementPresent("//span[text()='Ready to run']", MAX_WAIT_TIME);
	}

}
