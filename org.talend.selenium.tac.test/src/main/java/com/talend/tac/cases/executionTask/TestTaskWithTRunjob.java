package com.talend.tac.cases.executionTask;

//import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class TestTaskWithTRunjob extends Login {
	
//	boolean actualResult;
	
	@Test
	@Parameters({ "TaskWithtRunjob" })
	public void testTrunjob(String tasklabel) throws InterruptedException {
//		String tasklabel = "testTask";
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"
				+ rb.getString("menu.jobConductor") + "']"));
		// select a exist task
		this.waitForElementPresent("//span[text()='"+tasklabel+"']", WAIT_TIME);
		selenium.mouseDown("//span[text()='"+tasklabel+"']");
		runtask(tasklabel, Base.MAX_WAIT_TIME);
		
		Assert.assertTrue(getLogsValue().contains("23"),
				"default context test failed");
				

	}

	public void runtask(String tasklabel,int waitTime) throws InterruptedException {
		selenium.refresh();
		this.waitForElementPresent("//span[text()='" + tasklabel + "']",
				WAIT_TIME);
		selenium.mouseDown("//span[text()='" + tasklabel + "']");
		Thread.sleep(3000);
		selenium.click("//button[@id='idJobConductorTaskRunButton'  and @class='x-btn-text ' and text()='Run']");
	
		this.waitForElementPresent("//label[text()='Ok']",MAX_WAIT_TIME);
		// close the pop window
		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
		// System.out.println(checkContextValue(start));			
	   
	    		
	}
	public boolean waitForCondition(String locator,int seconds) throws InterruptedException{
		boolean conditionPresent = true;
		for (int second = 0;; second++) {
			if (second >= seconds){
				conditionPresent = false;
				break;
			}
			
				if (selenium.isElementPresent(locator)){
					break;
				}
				else{
				Thread.sleep(1000);
			    } 
		}
		
		return conditionPresent;
	}

	public String getLogsValue() {
		String logs = null;
		selenium.click("//span//span[text()='Logs']");
		selenium.setSpeed(MID_SPEED);
		selenium.click("//div[@class=' x-grid3-hd-inner x-grid3-hd-startDate x-component sort-desc ']//a[@class='x-grid3-hd-btn']");
		selenium.setSpeed(MIN_SPEED);
		selenium.click("//a[@class=' x-menu-item x-component' and text()='Sort Descending']");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-startDate']",
				WAIT_TIME);
//		String time = selenium
//				.getText("//div[@class='x-grid3-cell-inner x-grid3-col-startDate']");
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-startDate']");
		selenium.setSpeed(MID_SPEED);
		logs = selenium
				.getValue("//textarea[@name='log']");
		selenium.setSpeed(MIN_SPEED);
		System.out.println(logs);
		return logs;
	}
		
//	public void checkBoxChecked(String checkboxXpath) {
//		selenium.mouseDown(checkboxXpath);
//	}
//
//	public void checkBoxUnchecked(String checkboxXpath) {
//		selenium.mouseDown(checkboxXpath);
//
//	}
//
//	public boolean isCheckBoxChecked(String checkBoxOnXpath) {
//		boolean checked = false;
//		try {
//			if (selenium.isElementPresent(checkBoxOnXpath))
//				checked = true;
//		} catch (Exception e) {
//		}
//		return checked;
//	}
}
