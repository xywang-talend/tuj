package com.talend.tac.cases.executePlan;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class DeletePlan extends Plan {
    
	
	@Test
	@Parameters({"plan.delete.label"})
	public void testCancelDeletePlan(String deletelabel) throws InterruptedException {
		
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent("//div[@class='header-title' and text()='Execution Plan']", WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
//		selenium.setSpeed(MID_SPEED);
		this.clickWaitForElementPresent("idSubModuleRefreshButton");
		this.waitForElementPresent("//span[text()='"+deletelabel+"']", WAIT_TIME);
		Thread.sleep(2000);
		selenium.mouseDown("//span[text()='"+deletelabel+"']");//choose a exist plan
		Thread.sleep(2000);
		selenium.chooseCancelOnNextConfirmation();//choose 'Cancel'
		selenium.click("idSubModuleDeleteButton");//click 'Delete' button
		this.sleep(3000);
		selenium.getConfirmation();
		Assert.assertTrue((selenium.getConfirmation()).contains("you want to remove all of the related logs and archives"));								
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+deletelabel+"']"));
		selenium.setSpeed(MIN_SPEED);
		
	}
	
	
	@Test
	@Parameters({"plan.delete.label"})
	public void testDeletePlan(String deletelabel) throws InterruptedException {
		
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent("//div[@class='header-title' and text()='Execution Plan']", WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
		this.deletePlan(deletelabel);
	}
	
}
