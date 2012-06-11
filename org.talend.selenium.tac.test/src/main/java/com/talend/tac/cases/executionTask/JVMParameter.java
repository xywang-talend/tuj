package com.talend.tac.cases.executionTask;

import org.testng.Assert;
import com.talend.tac.cases.Login;

public class JVMParameter extends Login{
	
	//add method for add jvm parameter 
	public void addJVMParametersForTask(String jvmParameterStatus, String label, String jvmParameter, 
			String jvmParameterDescription, String warnInfo,int waitTime) {
    	
    	this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
    	Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
    	//select a exist task
    	selenium.setSpeed(MID_SPEED);
    	selenium.mouseDown("//span[text()='"+label+"']");
    	selenium.setSpeed(MIN_SPEED);
		this.clickWaitForElementPresent("//span[text()='JVM parameters']");//into JVMParameter page
		this.clickWaitForElementPresent("idJobConductorCmdPrmAddButton");//click add button, add jvm parameter
		//jvm parameters
		this.clickWaitForElementPresent("//span[text()='JVM parameter']//ancestor::div[@class='x-grid3-viewport']" +
				"//div[@class='x-grid3-cell-inner x-grid3-col-parameter']");
		this.waitForElementPresent("//span[text()='JVM parameter']//ancestor::div[@class='x-grid3-viewport']" +
				"//input[contains(@class,'x-form-field x-form-text x-form-focus')]", WAIT_TIME);//jvm
		selenium.click("//span[text()='JVM parameter']//ancestor::div[@class='x-grid3-viewport']" +
				"//input[contains(@class,'x-form-field x-form-text x-form-focus')]");
		selenium.type("//span[text()='JVM parameter']//ancestor::div[@class='x-grid3-viewport']" +
				"//input[contains(@class,'x-form-field x-form-text x-form-focus')]",jvmParameter);//input jvm parameter
		//description
		this.clickWaitForElementPresent("//span[text()='Description']//ancestor::div[@class='x-grid3-viewport']" +
				"//div[@class='x-grid3-cell-inner x-grid3-col-description']");
		this.waitForElementPresent("//span[text()='JVM parameter']//ancestor::div[@class='x-grid3-viewport']" +
				"//div[@class='x-grid3-cell-inner x-grid3-col-description']//ancestor::div[@class='x-grid3-" +
				"viewport']//input", WAIT_TIME);//jvm
		selenium.click("//span[text()='JVM parameter']//ancestor::div[@class='x-grid3-viewport']" +
				"//div[@class='x-grid3-cell-inner x-grid3-col-description']//ancestor::div[@class='x-grid3-" +
				"viewport']//input");
		selenium.type("//span[text()='JVM parameter']//ancestor::div[@class='x-grid3-viewport']" +
				"//div[@class='x-grid3-cell-inner x-grid3-col-description']//ancestor::div[@	class='x-grid3-" +
				"viewport']//input",jvmParameterDescription);//input jvm parameter description
		selenium.keyDown("//span[text()='JVM parameter']//ancestor::div[@class='x-grid3-viewport']" +
				"//div[@class='x-grid3-cell-inner x-grid3-col-description']//ancestor::div[@class='x-grid3-" +
				"viewport']//input", "\\13");
	    selenium.setSpeed(MIN_SPEED);
	    
	    if("Inactive".equals(jvmParameterStatus)) {
	    	
	    	selenium.mouseDown("//div[contains(@class,'x-grid3-check-col x-grid3-check-col-on x-grid3-cc-active')]");
	    		    	
	    }
	    
	    selenium.click("//button[@id='idJobConductorTaskRunButton'  and @class='x-btn-text ' and text()='Run']");
	    this.waitForElementPresent("//label[text()='"+warnInfo+"']", waitTime);
	    selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
	    
	    
    }
	
	//check jvm value in grid and RecoverLastExecution
	public void checkJvmValueInGridRecoverLastExecution(String jvmParameterValue) {
	    
		if(selenium.isElementPresent("//table[contains(@class,'x-btn x-toolbar-more x-component x-btn-icon')]")) {
	    	
	    	selenium.click("//table[contains(@class,'x-btn x-toolbar-more x-component x-btn-icon')]");
	    	
	    }	
	    
	    selenium.click("idJobConductorTaskRecoverButton");//into 
	    
	    this.waitForElementPresent("//label[text()='JVM Values:']//ancestor::div[contains" +
	    		"(@class,'x-form-item')]//textarea[contains(@class,'x-form-field x-form-textarea')]", WAIT_TIME);
	    selenium.setSpeed(MID_SPEED);
	    String lastRunEndTime = selenium.getValue("//label[text()='Task:']//ancestor::div" +
	    		"[@class=' x-form-label-left']/div[3]//input[@class=' x-form-field x-form-text']");
	    String jvmValue = selenium.getValue("//label[text()='JVM Values:']//ancestor::div[contains" +
	    		"(@class,'x-form-item')]//textarea[contains(@class,'x-form-field x-form-textarea')]");
	    selenium.setSpeed(MIN_SPEED);
	    System.out.println(jvmValue);
	    System.out.println(lastRunEndTime);
	    Assert.assertEquals(jvmValue, jvmParameterValue);
		
	    this.clickWaitForElementPresent("!!!menu.grid_task_executions_history.element!!!");
	    
	    this.waitForElementPresent("//div[text()='Task execution monitoring']//ancestor::div[@class='x-" +
	    		"panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']" +
	    		"//span[text()='Task start date']//ancestor::div[@class='x-grid3-viewport']" +
	    		"//div[@class='x-grid3-cell-inner x-grid3-col-taskEndDate']//" +
	    		"span[@title='"+lastRunEndTime+"']", WAIT_TIME);
	    selenium.mouseDown("//div[text()='Task execution monitoring']//ancestor::div[@class='x-" +
	    		"panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']" +
	    		"//span[text()='Task start date']//ancestor::div[@class='x-grid3-viewport']" +
	    		"//div[@class='x-grid3-cell-inner x-grid3-col-taskEndDate']//" +
	    		"span[@title='"+lastRunEndTime+"']");
	    
	    String jvmValueInGrid = selenium.getValue("//div[text()='Task execution monitoring']" +
	    		"//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder" +
	    		" x-border-layout-ct']//textarea[@name='jvmValues']");
	    System.out.println("*-*-*-*-*-*"+jvmValueInGrid);
	    selenium.setSpeed(MAX_SPEED);
	    Assert.assertEquals(jvmValueInGrid, jvmParameterValue);
	    selenium.setSpeed(MIN_SPEED);
		
	}
	
	//delete a  JVM parameter 
	public void deleteJVMParameter(String label) {
		

    	this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
    	Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
    	selenium.setSpeed(MID_SPEED);
    	selenium.mouseDown("//span[text()='"+label+"']");
    	selenium.setSpeed(MIN_SPEED);
		this.clickWaitForElementPresent("//span[text()='JVM parameters']");//into JVMParameter page
		
		this.waitForElementPresent("//span[text()='JVM parameter']//ancestor::div[@class='x-grid3-viewport']" +
				"//div[@class='x-grid3-cell-inner x-grid3-col-parameter']", WAIT_TIME);
		selenium.mouseDown("//span[text()='JVM parameter']//ancestor::div[@class='x-grid3-viewport']" +
				"//div[@class='x-grid3-cell-inner x-grid3-col-parameter']");    	//select a exist task
		selenium.chooseOkOnNextConfirmation();
		selenium.setSpeed(MID_SPEED);
		selenium.click("idJobConductorCmdPrmDeleteButton");
		selenium.setSpeed(MIN_SPEED);
		Assert.assertTrue(selenium.getConfirmation().contains("Are you sure you want to remove the selected JVM parameter"));
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(!selenium.isElementPresent("//span[text()='JVM parameter']//ancestor::div[@class='x-grid3-viewport']" +
				"//div[@class='x-grid3-cell-inner x-grid3-col-parameter']"));
		selenium.setSpeed(MIN_SPEED);
		
	}
		
}
