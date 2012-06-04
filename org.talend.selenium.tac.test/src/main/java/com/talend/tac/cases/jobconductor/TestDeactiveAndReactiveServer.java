package com.talend.tac.cases.jobconductor;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestDeactiveAndReactiveServer extends Server{
	@Test
	@Parameters({ "deactiveServerlable" })
	public void testServerDeactiveAndReactive(String deactiveServername) throws InterruptedException {
//		Thread.sleep(5000);
		boolean refresh= false;
	    this.openServerMenu();
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+deactiveServername+"')]", WAIT_TIME);
		Thread.sleep(2000);
			selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+deactiveServername+"')]");
			// uncheck the active optioon
			Thread.sleep(3000);
			selenium.click("//input[@class=' x-form-checkbox' and @type='checkbox' and @name='active']");
			// click the save button
//			selenium.setSpeed(MID_SPEED);
			selenium.click("idFormSaveButton");
			// refresh
			if(refresh){
				selenium.refresh();
				}
//			selenium.click("idSubModuleRefreshButton");
			this.waitForElementPresent("//span[@class='serv-value' and (text()='INACTIVE')]", WAIT_TIME);
			Assert.assertTrue(
					(selenium
							.isElementPresent("//span[@class='serv-value' and (text()='INACTIVE')]")),
					"Server deactive failed!");
			selenium.setSpeed(MIN_SPEED);
			//reactive the server
			if(refresh){
			selenium.refresh();
			}
			this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+deactiveServername+"')]", WAIT_TIME);
			Thread.sleep(3000);
			selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+deactiveServername+"')]");
			// checked the active optioon
			Thread.sleep(3000);
			selenium.click("//input[@class=' x-form-checkbox' and @type='checkbox' and @name='active']");
			// click the save button
//			selenium.setSpeed(MID_SPEED);
			selenium.click("idFormSaveButton");
			// refresh
			if(refresh){
				selenium.refresh();
				}
			this.waitForElementPresent("//span[@class='serv-value' and (text()='UP')]", WAIT_TIME);
			Assert.assertTrue(
					(selenium
							.isElementPresent("//span[@class='serv-value' and (text()='UP')]")),
					"Server reactive failed!");
		
		selenium.setSpeed(MIN_SPEED);
	}
}
