package com.talend.tac.cases.executePlan;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPlanPauseAndResume extends Plan {
    
	//test pause plan button and resume plan button
	@Test
	@Parameters({"addTaskForplanPauseAndResume","labelDescription","addCommonProjectName","branchNameTrunk",
		"jobNameTJava","version0.1","context","statisticEnabled","ServerForUseAvailable",
		"planPauseAndResumeLabel","plan.simpletrigger.label.planuseAndResume"})
	public void testPlanPauseAndResume(String label,String taskDescription,String projectName,
			String branchName,String jobName,String version,String context,String statisticName,
			String serverName,String planLabel,String triggerLabel) {
		
		this.addTask(label, taskDescription, projectName, branchName, jobName, version, context, serverName, statisticName);
		
		this.generateDeployRunTask(label,"//button[@id='idJobConductorTaskRunButton' and text()='Run']");//click Run button
		this.waitForElementPresent("//span[text()='Real time statistics']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='Real time statistics']"));
		this.waitForElementPresent("//label[text()='Ok']", MAX_WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Ok']"));
		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
		int logsConut = this.getXpathCount("//div[contains(@class,'x-grid3-" +
		"cell-inner x-grid3-col-startDate')]");
		
		Assert.assertEquals(logsConut, 1);
		
		this.addPlan(planLabel, label, "add a plan for test pause plan and resume plan");
		selenium.refresh();
		this.waitForElementPresent("//span[text()='"+planLabel+"']", WAIT_TIME);
    	selenium.mouseDown("//span[text()='"+planLabel+"']");//select a exist task
		this.sleep(3000);
    	selenium.click("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader" +
    			" x-panel-body-noborder x-border-layout-ct')]//button[@id='idTriggerAdd trigger...']");//add a trigger
		selenium.click("//a[@id='idTriggerAdd simple trigger']");//add a SimpleTrigger
        Assert.assertTrue(selenium.isElementPresent("//span[text()='"+rb.getString("trigger.action.addSimpleTrigger")+"']"));
    	    	
        //type simple trigger label
        this.typeString("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[contains(@class,'x-panel-body x-panel-body" +
        		"-noheader x-panel-body-noborder x-border-layout-ct')]//input[@id='idJobConductorSimpleTriggerLableInput']",triggerLabel );//label
		//type simple trigger description
        this.typeString("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[contains(@class,'x-panel-body x-panel-body" +
        		"-noheader x-panel-body-noborder x-border-layout-ct')]//input[@id='idJobConductorSimpleTriggerDescInput']",
        		"add a trigger for test pause plan and resume plan");//description

	    //type simple trigger repeat interval
        this.typeString("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[contains(@class,'x-panel-body x-panel-body" +
        		"-noheader x-panel-body-noborder x-border-layout-ct')]//input[@id='idJobConductorSimpleTriggerRptIntervalInput']", "40");//Number of triggerings

        selenium.click("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader" +
        		" x-panel-body-noborder x-border-layout-ct')]//button[@id='idSimpleTriggerSave']");
	    selenium.setSpeed(MID_SPEED);
        Assert.assertTrue(selenium.isElementPresent("//span[text()='"+triggerLabel+"']"));
	 	selenium.setSpeed(MIN_SPEED);	 	

		if(selenium.isElementPresent("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct')]" +
				"//table[contains(@class,'x-btn x-toolbar-more x-component x-btn-icon')]")) {
	    	
	    	selenium.click("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct')]" +
				"//table[contains(@class,'x-btn x-toolbar-more x-component x-btn-icon')]");
	    	
	    }
		
	    selenium.setSpeed(MID_SPEED);
		selenium.click("idExecutionPlanPlanGridPauseButton");
		selenium.getConfirmation();
		selenium.setSpeed(MIN_SPEED);
		
		this.waitForElementPresent("//span[text()='"+planLabel+"']//ancestor::table[@class='x-grid3-row-table']//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-triggersStatus')]" +
				"//img[@title='All triggers paused']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+planLabel+"']//ancestor::table[@class='x-grid3-row-table']//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-triggersStatus')]" +
				"//img[@title='All triggers paused']"), "//span[text()='"+planLabel+"']//ancestor::table[@class='x-grid3-row-table']//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-triggersStatus')]" +
						"//img[@title='All triggers paused'] is without appear");
		this.clickWaitForElementPresent("//div[text()='Execution Plan']//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component x-border-panel')]//following-sibling::div//button[@id='idTriggerRefresh']");
		this.waitForElementPresent("//span[text()='"+triggerLabel+"']//ancestor::table[@class='x-grid3-row-table']" +
				"//img[@title='Paused']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+triggerLabel+"']//ancestor::table[@class='x-grid3-row-table']" +
				"//img[@title='Paused']"), "//span[text()='"+triggerLabel+"']//ancestor::table[@class='x-grid3-row-table']//img[@title='Paused'] is without appear");
		
		//go to execution task page
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[text()='"+rb.getString("menu.jobConductor")+"']"));
    	selenium.setSpeed(MIN_SPEED);
    	this.waitForElementPresent("//span[text()='"+label+"']", WAIT_TIME);		
    	selenium.mouseDown("//span[text()='"+label+"']");
    	
		int logsConutExpectedResuleAfterPause = this.getXpathCount("//div[contains(@class,'x-grid3-" +
		"cell-inner x-grid3-col-startDate')]");
		System.out.println("logsConutExpectedResuleAfterPause>>"+logsConutExpectedResuleAfterPause);
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int logsConutActualResuleAfterPause = this.getXpathCount("//div[contains(@class,'x-grid3-" +
		"cell-inner x-grid3-col-startDate')]");
		System.out.println("logsConutActualResuleAfterPause>>"+logsConutActualResuleAfterPause);
		Assert.assertEquals(logsConutExpectedResuleAfterPause, logsConutActualResuleAfterPause);
        
		this.openExecutionPlanMenu();
		selenium.setSpeed(MID_SPEED);
		selenium.mouseDown("//span[text()='" + planLabel + "']");
		selenium.setSpeed(MIN_SPEED);
		
		if(selenium.isElementPresent("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct')]" +
				"//table[contains(@class,'x-btn x-toolbar-more x-component x-btn-icon')]")) {
	    	
	    	selenium.click("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct')]" +
				"//table[contains(@class,'x-btn x-toolbar-more x-component x-btn-icon')]");
	    	
	    }
		
		selenium.setSpeed(MID_SPEED);
		selenium.click("idExecutionPlanTreeViewRefreshButton");
		this.sleep(3000);
		selenium.click("//a[text()='Resume plan']");
		selenium.getConfirmation();
		selenium.setSpeed(MIN_SPEED);
		
		this.waitForElementPresent("//span[text()='"+planLabel+"']//ancestor::table[@class='x-grid3-row-table']//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-triggersStatus')]" +
				"//img[@title='At least one Trigger is running']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+planLabel+"']//ancestor::table[@class='x-grid3-row-table']//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-triggersStatus')]" +
				"//img[@title='At least one Trigger is running' ]"), "//span[text()='"+planLabel+"']//ancestor::table[@class='x-grid3-row-table']//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-triggersStatus')]" +
						"//img[@title='At least one Trigger is running' ] is without appear");
		this.clickWaitForElementPresent("//div[text()='Execution Plan']//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component x-border-panel')]//following-sibling::div//button[@id='idTriggerRefresh']");
		this.waitForElementPresent("//span[text()='"+triggerLabel+"']//ancestor::table[@class='x-grid3-row-table']" +
		"//img[@title='Normal']", WAIT_TIME);
        Assert.assertTrue(selenium.isElementPresent("//span[text()='"+triggerLabel+"']//ancestor::table[@class='x-grid3-row-table']" +
		"//img[@title='Normal']"), "//span[text()='"+triggerLabel+"']//ancestor::table[@class='x-grid3-row-table']//img[@title='Normal'] is without appear");
        Assert.assertTrue(this.waitForTextPresent("[RUNNING]", 100));
        Assert.assertTrue(this.waitForTextPresent("[OK]", MAX_WAIT_TIME));
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[text()='"+rb.getString("menu.jobConductor")+"']"));
    	selenium.setSpeed(MIN_SPEED);
    	this.waitForElementPresent("//span[text()='"+label+"']", WAIT_TIME);		
    	selenium.mouseDown("//span[text()='"+label+"']");

        int logsConutActualResuleAfterResume = this.getXpathCount("//div[contains(@class,'x-grid3-" +
		"cell-inner x-grid3-col-startDate')]");
        System.out.println("logsConutActualResuleAfterResume>>"+logsConutActualResuleAfterResume);
		Assert.assertEquals(logsConutActualResuleAfterResume>logsConutExpectedResuleAfterPause, true);
		
        this.openExecutionPlanMenu();
        
        this.waitForElementPresent("//span[text()='" + planLabel + "']", WAIT_TIME);
		selenium.mouseDown("//span[text()='" + planLabel + "']");
		selenium.setSpeed(MIN_SPEED);
		
		this.deleteTrigger(triggerLabel);
		
	}
	
}
