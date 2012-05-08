package com.talend.tac.cases.executionTask;

import org.testng.Assert;		
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import com.talend.tac.cases.Login;

public class TestTaskDisplay extends Login {
	@Test(description="")
	@Parameters({"labelReferenceproTjava"})
	public void testTaskDisplayGroupedByProject(String TaskLable){
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		
		this.waitForElementPresent("//div[contains(text(),'Project: referencepro')]", WAIT_TIME);
		//click the group of task
		this.waitForElementPresent("//span[text()='"+TaskLable+"']", WAIT_TIME);
		//make a task selected
		selenium.mouseDown("//span[text()='"+TaskLable+"']");
		//collapsed the group and assert the display(by attribute) 
		assertFalse(selenium.isElementPresent("//div[@class='x-grid3-row  x-unselectable-single ']//span[text()='"+TaskLable+"']"));
		selenium.mouseDown("//div[contains(text(),'Project: referencepro')]");
		selenium.refresh();
		this.waitForElementPresent("//div[contains(text(),'Project: referencepro')]", WAIT_TIME);
		//expand the group
		selenium.mouseDown("//div[contains(text(),'Project: referencepro')]");
		this.waitForElementPresent("//div[@class='x-grid3-row  x-unselectable-single ']//span[text()='"+TaskLable+"']", WAIT_TIME);
		
	}

	@Test(description="input a key work and search task")
	@Parameters({"labelReferenceproTjava"})
	public void testSearchTask (String TaskLable){
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		
		this.waitForElementPresent("//div[contains(text(),'Project: referencepro')]", WAIT_TIME);
		//click the group of task
		this.waitForElementPresent("//span[text()='"+TaskLable+"']", WAIT_TIME);
		//wait and input a keyWord
		this.waitForElementPresent("//button[text()='Filter tasks']/ancestor::td/following-sibling::td//input", WAIT_TIME);
		selenium.typeKeys("//button[text()='Filter tasks']/ancestor::td/following-sibling::td//input","input a keyword");
		//setSpeed,wait the tasks disappears and make sure the assertFalse works well.
		selenium.setSpeed(MID_SPEED);
		assertFalse(selenium.isElementPresent("//span[text()='"+TaskLable+"']"));
		selenium.setSpeed(MIN_SPEED);
		//clear the keyWrods
		selenium.click("//button[text()='Filter tasks']/ancestor::td/following-sibling::td//input/following-sibling::img");
		assertTrue(selenium.isElementPresent("//span[text()='"+TaskLable+"']"));
		//type a the name of task as a keyword
		selenium.typeKeys("//button[text()='Filter tasks']/ancestor::td/following-sibling::td//input",TaskLable);
		assertTrue(selenium.isElementPresent("//span[text()='"+TaskLable+"']"));
	}
	
	@Test(description="change the statistic status of task, this is not an urgent case ")
	@Parameters({"labelReferenceproTjava"})
	public void testTaskChangeStatisticStatus (String TaskLable){
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		this.waitForElementPresent("//span[text()='"+TaskLable+"']", WAIT_TIME);
		selenium.mouseDown("//span[text()='"+TaskLable+"']");
		//change the status of statistic 
		this.selectDropDownList("idJobConductorTaskStatisticsListBox", "disabled");
		
		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MIN_SPEED);
		
		selenium.setSpeed(MAX_SPEED);
		assertEquals(selenium.getValue("idJobConductorTaskStatisticsListBox"), "disabled");
		selenium.setSpeed(MIN_SPEED);		
		
		this.selectDropDownList("idJobConductorTaskStatisticsListBox", "enabled");
		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MIN_SPEED);
		
		selenium.setSpeed(MAX_SPEED);
		assertEquals(selenium.getValue("idJobConductorTaskStatisticsListBox"), "enabled");
		selenium.setSpeed(MIN_SPEED);	
						
	}
	
	@Test(description="check if the trigger belong to a task is displayed well ")
	@Parameters({"labelReferenceproTjava","addCronTriggerByHandInputDateLabel"})
	public void testTriggerOfTaskDisplay (String TaskLable,String triggerLabel){
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		this.waitForElementPresent("//span[text()='"+TaskLable+"']", WAIT_TIME);
		selenium.mouseDown("//span[text()='"+TaskLable+"']");
		this.waitForElementPresent("//span[@title='"+ triggerLabel +"']", WAIT_TIME);
		// we can check the other task's trigger display well or not. 
		//We must organize the order and the name of parameters( like the trigger belong to a task).make it standard and easy recognized.

	}
	
	/*verify 'RecoverLastExecution' menu displays correctly, mousedown a job, go to 'RecoverLastExecution' page,
	displaying all checkpoints of the job.*/
	@Test
	@Parameters({"taskWithTjavaWithMulripleCheckpoint"})
	public void testCheckRecoverLastExecutionMenu(String taskWithTjavaWithMulripleCheckpoint) {
		
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
        selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
	    selenium.setSpeed(MIN_SPEED);
	    
	    this.waitForElementPresent("//span[text()='"+taskWithTjavaWithMulripleCheckpoint+"']", WAIT_TIME);
	    selenium.mouseDown("//span[text()='"+taskWithTjavaWithMulripleCheckpoint+"']");
	    
		if(selenium.isElementPresent("//table[contains(@class,'x-btn x-toolbar-more x-component x-btn-icon')]")) {
	    	
	    	selenium.click("//table[contains(@class,'x-btn x-toolbar-more x-component x-btn-icon')]");
	    	
	    }	
	    
		selenium.setSpeed(MID_SPEED);
	    selenium.click("idJobConductorTaskRecoverButton");//into Error recovery management page
	    selenium.setSpeed(MIN_SPEED);
	    
	    this.waitForElementPresent("//div[text()='Error recovery management']", WAIT_TIME);
	    Assert.assertTrue(selenium.isElementPresent("//div[text()='Error recovery management']"), "verify failed: 'Error recovery management' is without appear");
	    
	    this.waitForElementPresent("//span[text()='Execution info']", WAIT_TIME);
	    Assert.assertTrue(selenium.isElementPresent("//span[text()='Execution info']"), "verify faile: 'Execution info without appear'");
	    
	    this.clickWaitForElementPresent("//span[text()='Recovery checkpoints']");

	    selenium.setSpeed(MAX_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//span[text()='Job: tjavaWithMulripleCheckPoint']"), "verify failed: '//span[text()='Job: tjavaWithMulripleCheckPoint']' is without appear");
		selenium.setSpeed(MIN_SPEED);
		
		
	}
		
}
