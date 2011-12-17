package com.talend.tac.cases.executionTask;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class CheckLogs extends Login {
	
	//into JobConductor page
	public void intoJobConductor(String taskLabel) {
		
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
        selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[text()='"+rb.getString("menu.jobConductor")+"']"));
	    selenium.setSpeed(MIN_SPEED);
	    
	    this.waitForElementPresent("//span[text()='"+taskLabel+"']", WAIT_TIME);
	    selenium.mouseDown("//span[text()='"+taskLabel+"']");//select an exist task
	    						
	}
	
	//clear logs
	public void clearLogsAndRunTask() {
		
		selenium.setSpeed(MID_SPEED);
		/*clear logs*/
		selenium.click("//span[text()='Logs']");
		selenium.setSpeed(MIN_SPEED);
		selenium.chooseOkOnNextConfirmation();
		this.waitForElementPresent("idJobConductorJobLogClearLogButton", WAIT_TIME);
		selenium.click("idJobConductorJobLogClearLogButton");
		selenium.getConfirmation();
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent("The entire log size: 0 Bytes"));
		selenium.setSpeed(MIN_SPEED);
		
		selenium.click("//span[text()='Triggers']");
		/*clear logs*/
		for(int i=1; i<=6; i++) {
			
			selenium.click("//button[@id='idJobConductorTaskRunButton' and text()='Run']");//click Run button
			
			this.waitForElementPresent("//span[text()='Real time statistics']", WAIT_TIME);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='Real time statistics']"));
			this.waitForElementPresent("//label[text()='Ok']", WAIT_TIME);
			Assert.assertTrue(selenium.isElementPresent("//label[text()='Ok']"));
			selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");//close window of 'Real time statistics'
			
		}
		
	}
	
	//creation method for test modify per page display numbers
	public void enterTheNumberOfItemsPerPage(String num, String numbersOfPerPage, int expectedResult) {
		
		selenium.click("//span[text()='Logs']");
		selenium.setSpeed(MIN_SPEED);
		
		this.waitForElementPresent("//span[text()='Logs']//ancestor::div[contains(@class,'x-tab-panel x-component')]" +
				"//div[@title='Enter the number of items per page']", WAIT_TIME);
		selenium.type("//span[text()='Logs']//ancestor::div[contains(@class,'x-tab-panel x-component')]" +
				"//div[@title='Enter the number of items per page']/input", num);//modify of per page display numbers
		selenium.setSpeed(MID_SPEED);
		selenium.focus("//span[text()='Logs']//ancestor::div[contains(@class,'x-tab-panel x-component')]" +
				"//div[@title='Enter the number of items per page']/input");
		selenium.keyDownNative(""+KeyEvent.VK_ENTER);
		selenium.setSpeed(MIN_SPEED);
		
		this.waitForElementPresent("//div[text()='of "+numbersOfPerPage+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='of "+numbersOfPerPage+"']"));
				
		List<String> list = new ArrayList<String>();
		list = this.findSpecialMachedStrings(".*34 Bytes$");
		int logsNum = list.size();//per page numbers after modified 
		System.out.println("logs numbers"+logsNum);
	
		Assert.assertEquals(logsNum, expectedResult);
		
	}
	
	//test input a right format parameter of 'enterTheNumberOfItemsPerPage' and check numbers of per page
	@Test
	@Parameters({"modifyTask"})
	public void testInputRightFormatParameterOfEnterTheNumberOfItemsPerPage(String taskLabel) {
		
		intoJobConductor(taskLabel);
		
        clearLogsAndRunTask();
		
		enterTheNumberOfItemsPerPage("2", "3", 2);
		
	}

	//test input a wrong format parameter of 'enterTheNumberOfItemsPerPage' and check numbers of per page
	@Test
	@Parameters({"modifyTask"})
	public void testInputWrongFormatParameterOfEnterTheNumberOfItemsPerPage(String taskLabel) {
		
		intoJobConductor(taskLabel);
		
		enterTheNumberOfItemsPerPage("aa", "1", 6);
		
		Assert.assertTrue(selenium.isElementPresent("//span[text()='Logs']//ancestor::div[contains(@class,'x-tab-panel x-component')]" +
				"//div[@title='Enter the number of items per page']/parent::td//img"));
		
	}
    
	//test next page and previous of logs
	@Test
	@Parameters({"modifyTask"})
	public void testNextPagePreviousPage(String taskLabel) {
		
		intoJobConductor(taskLabel);
		
		enterTheNumberOfItemsPerPage("2", "3", 2);
		/*test next page*/
		selenium.click("//span[text()='Logs']//ancestor::div[contains(@class,'x-tab-panel x-component')]" +
				"//td[8]/table[contains(@class,'x-component x-unselectable')]//button");//click next page button
		
		selenium.setSpeed(MID_SPEED);
		String nextPageNumber = selenium.getValue("//span[text()='Logs']//ancestor::div[contains(@class,'x-tab-panel x-component')]//td[5]/input");
		selenium.setSpeed(MIN_SPEED);		
		
		Assert.assertEquals(nextPageNumber, "2");
		Assert.assertTrue(selenium.isTextPresent("Displaying 3 - 4 of 6"));
		/*test next page*/
		
		/*test previous page*/
		selenium.click("//span[text()='Logs']//ancestor::div[contains(@class,'x-tab-panel x-component')]" +
		"//td[2]/table[contains(@class,'x-component x-unselectable')]//button");//click previous page button

		selenium.setSpeed(MID_SPEED);
		String previousPageNumber = selenium.getValue("//span[text()='Logs']//ancestor::div[contains(@class,'x-tab-panel x-component')]//td[5]/input");
		selenium.setSpeed(MIN_SPEED);		
		
		Assert.assertEquals(previousPageNumber, "1");
		Assert.assertTrue(selenium.isTextPresent("Displaying 1 - 2 of 6"));
		/*test previous page*/
		
	}
	
    //test last page and first page of logs
	@Test
	@Parameters({"modifyTask"})
	public void testLastPageFirstPage(String taskLabel) {
		
		intoJobConductor(taskLabel);
		
		enterTheNumberOfItemsPerPage("2", "3", 2);
		/*test last page*/
		selenium.click("//span[text()='Logs']//ancestor::div[contains(@class,'x-tab-panel x-component')]" +
				"//td[9]/table[contains(@class,'x-component x-unselectable')]//button");//click last page button
		
		selenium.setSpeed(MID_SPEED);
		String lastPageNumber = selenium.getValue("//span[text()='Logs']//ancestor::div[contains(@class,'x-tab-panel x-component')]//td[5]/input");
		selenium.setSpeed(MIN_SPEED);		
		
		Assert.assertEquals(lastPageNumber, "3");
		Assert.assertTrue(selenium.isTextPresent("Displaying 5 - 6 of 6"));
		/*test last page*/
		
		/*test first page*/
		selenium.click("//span[text()='Logs']//ancestor::div[contains(@class,'x-tab-panel x-component')]" +
		"//td[1]/table[contains(@class,'x-component x-unselectable')]//button");//click first page button

		selenium.setSpeed(MID_SPEED);
		String firstPageNumber = selenium.getValue("//span[text()='Logs']//ancestor::div[contains(@class,'x-tab-panel x-component')]//td[5]/input");
		selenium.setSpeed(MIN_SPEED);		
		
		Assert.assertEquals(firstPageNumber, "1");
		Assert.assertTrue(selenium.isTextPresent("Displaying 1 - 2 of 6"));
		/*test first page*/
		
	}
	
	//test modify page number in page input
	@Test
	@Parameters({"modifyTask"})
	public void testPageInput(String taskLabel) {
		
		intoJobConductor(taskLabel);
		
		enterTheNumberOfItemsPerPage("2", "3", 2);
		
		selenium.setSpeed(MID_SPEED);
		selenium.type("//span[text()='Logs']//ancestor::div[contains(@class," +
				"'x-tab-panel x-component')]//td[5]//input", "3");//modify of page numbers
		
		selenium.focus("//span[text()='Logs']//ancestor::div[contains(@class," +
				"'x-tab-panel x-component')]//td[5]//input");
		selenium.keyDownNative(""+KeyEvent.VK_ENTER);
		
		Assert.assertTrue(selenium.isTextPresent("Displaying 5 - 6 of 6"));
		selenium.setSpeed(MIN_SPEED);
		
	}
	
	//test display and hide of logs info 
//	@Test
	@Parameters({"modifyTask"})
	public void testHideDisplayLogs(String taskLabel) throws InterruptedException {
		
		intoJobConductor(taskLabel);
		
		selenium.setSpeed(MID_SPEED);
		selenium.click("//span[text()='Logs']");
		selenium.setSpeed(MIN_SPEED);
		
		this.waitForElementPresent("//span[text()='Logs']//ancestor::div[contains(@class,'x-tab-panel x-component')]" +
		"//div[contains(@class,'grid3-body')]//div[1]//div[contains(@class,'grid3-cell-inner" +
				" x-grid3-col-expander')]", WAIT_TIME);
		selenium.focus("//span[text()='Logs']//ancestor::div[contains(@class,'x-tab-panel x-component')]" +
				"//div[contains(@class,'grid3-body')]//div[1]//div[contains(@class,'grid3-cell-inner" +
						" x-grid3-col-expander')]");
		selenium.click("//span[text()='Logs']//ancestor::div[contains(@class,'x-tab-panel x-component')]" +
				"//div[contains(@class,'grid3-body')]//div[1]//div[contains(@class,'grid3-cell-inner" +
						" x-grid3-col-expander')]");//click display logs info
		
		Thread.sleep(5000);
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent("Summary:"));
		Assert.assertTrue(selenium.isTextPresent(" [statistics] connecting to socket on port 10112 [statistics] connected ... " +
				"(2 hidden lines) ref_88-08-13 [statistics] disconnected"));
		selenium.setSpeed(MIN_SPEED);
		
		selenium.click("//span[text()='Logs']//ancestor::div[contains(@class,'tab-panel x-component')]//div[contains(@class,'rid3-body')]//div[1]//div[contains(@class,'rid3-cell-inner x-grid3-col-expander')]");//click hide logs info
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isTextPresent("Summary:"));
		Assert.assertFalse(selenium.isTextPresent(" [statistics] connecting to socket on port 10112 [statistics] connected ... " +
				"(2 hidden lines) ref_88-08-13 [statistics] disconnected"));
		selenium.setSpeed(MIN_SPEED);
		
	}
	
}
