package com.talend.cases.esb;


import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Test;



public class TestEsbServiceActivitySelectRows extends Esb {
	Robot rob = null;
	
	/**
	 * this test case is mainly to test rows select by press up and down keys on keyboard
	 */
	@Test
	public void testRowsSelectByUpDown(){
		
		this.openServiceActivityMonitor();
		
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-port']", WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-port']");
		this.sleep(2000);
		this.waitForElementPresent("//div[@class='samui-flow-details']", WAIT_TIME);
		this.sleep(3000);
		String testFlowDetail = selenium.getText("//div[@class='samui-flow-details']");
		System.out.println(testFlowDetail);
		
		try {
			 rob = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rob.keyPress(KeyEvent.VK_DOWN);
		rob.keyRelease(KeyEvent.VK_DOWN);
		this.sleep(2000);
		this.waitForElementPresent("//div[@class='samui-flow-details']", WAIT_TIME);
		this.sleep(3000);
		String testFlowDetailDown = selenium.getText("//div[@class='samui-flow-details']");
		Assert.assertFalse(testFlowDetail.equals(testFlowDetailDown), "test select row with DOWN key failed!");
	
		rob.keyPress(KeyEvent.VK_UP);
		rob.keyRelease(KeyEvent.VK_UP);
		this.sleep(2000);
		this.waitForElementPresent("//div[@class='samui-flow-details']", WAIT_TIME);
		this.sleep(3000);
		String testFlowDetailUP = selenium.getText("//div[@class='samui-flow-details']");
		Assert.assertTrue(testFlowDetail.equals(testFlowDetailUP), "test select row with UP key failed!");
	
	}
	
	/**
	 * this test case is mainly to test rows select by press PageUP and PageDown keys on keyboard to select the first and last event
	 */
	@Test
	public void testRowsSelectByPageUpPageDown(){
		
	
		this.openServiceActivityMonitor();
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-port']", WAIT_TIME);
		int events = selenium.getXpathCount("//div[text()='Service Activity Monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')]").intValue();
		selenium.mouseDown("//div[text()='Service Activity Monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[1]//table[@class='x-grid3-row-table']");
		this.sleep(2000);
		this.waitForElementPresent("//div[@class='samui-flow-details']", WAIT_TIME);
		this.sleep(3000);
		String testFlowDetailFirst = selenium.getText("//div[@class='samui-flow-details']");
		
		selenium.mouseDown("//div[text()='Service Activity Monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div["+events+"]//table[@class='x-grid3-row-table']");
		this.sleep(2000);
		this.waitForElementPresent("//div[@class='samui-flow-details']", WAIT_TIME);
		this.sleep(3000);
		String testFlowDetailLast = selenium.getText("//div[@class='samui-flow-details']");
		
		try {
			 rob = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rob.keyPress(KeyEvent.VK_PAGE_UP);
		rob.keyRelease(KeyEvent.VK_PAGE_UP);
		this.sleep(2000);
		this.waitForElementPresent("//div[@class='samui-flow-details']", WAIT_TIME);
		this.sleep(3000);
		String testFlowDetailFirstUP = selenium.getText("//div[@class='samui-flow-details']");
			Assert.assertTrue(testFlowDetailFirstUP.equals(testFlowDetailFirst), "test select rows with pageUP failed!");
		
		
		rob.keyPress(KeyEvent.VK_PAGE_DOWN);
		rob.keyRelease(KeyEvent.VK_PAGE_DOWN);
		this.sleep(2000);
		this.waitForElementPresent("//div[@class='samui-flow-details']", WAIT_TIME);
		this.sleep(3000);
		String testFlowDetailLastDown = selenium.getText("//div[@class='samui-flow-details']");
		Assert.assertTrue(testFlowDetailLastDown.equals(testFlowDetailLast), "test select rows with pageDOWN failed!");
		
		
	}
	
}
