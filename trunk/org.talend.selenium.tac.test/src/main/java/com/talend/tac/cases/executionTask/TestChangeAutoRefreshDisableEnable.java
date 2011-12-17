package com.talend.tac.cases.executionTask;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestChangeAutoRefreshDisableEnable extends Login {
    
    
	//test disable/enable auto refresh
	@Test
	@Parameters({"labelRefProJobByMainProTRunJobRun"})
	public void testChangeAutoRefreshDisableEnable(String taskLabel) throws InterruptedException {
		
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		
		this.waitForElementPresent("//span[text()='"+taskLabel+"']", WAIT_TIME);
		selenium.click("//table[contains(@class,'x-component x-btn-icon')]");
		selenium.setSpeed(MID_SPEED);

		selenium.click("//img[contains(@class,'menu-item-icon')]");
		selenium.setSpeed(MIN_SPEED);
		String waitingTimeDisable = selenium.getText("//span[@title='"+taskLabel+"']//ancestor::tr" +
				"//div[@class='x-grid3-cell-inner x-grid3-col-remaingTimeForNextFire']");
		System.out.println(waitingTimeDisable);
		
		Thread.sleep(3000);
		
		String waitingTimeAfter3SecondDisable = selenium.getText("//span[@title='"+taskLabel+"']//ancestor::tr" +
		"//div[@class='x-grid3-cell-inner x-grid3-col-remaingTimeForNextFire']");
        System.out.println(waitingTimeAfter3SecondDisable);
        
        Assert.assertEquals(waitingTimeDisable, waitingTimeAfter3SecondDisable);
        
		selenium.click("//table[contains(@class,'x-component x-btn-icon')]");//click auto refresh icon
		selenium.setSpeed(MID_SPEED);
		selenium.click("//img[contains(@class,'menu-item-icon')]");//enable auto refresh
		selenium.setSpeed(MIN_SPEED);
		
		String waitingTimeEnable = selenium.getText("//span[@title='"+taskLabel+"']//ancestor::tr" +
				"//div[@class='x-grid3-cell-inner x-grid3-col-remaingTimeForNextFire']");//waiting time of task
		System.out.println(waitingTimeEnable);
		
		Thread.sleep(3000);
		
		String waitingTimeAfter3SecondEnable = selenium.getText("//span[@title='"+taskLabel+"']//ancestor::tr" +
		"//div[@class='x-grid3-cell-inner x-grid3-col-remaingTimeForNextFire']");//waiting time of task
        System.out.println(waitingTimeAfter3SecondEnable);
        
        Assert.assertFalse(selenium.isElementPresent("//span[@title='"+taskLabel+"']//" +
	    		"ancestor::tr//div[text()='"+waitingTimeEnable+"']"));
        
	}

}
