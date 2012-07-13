package com.talend.cases.esb;


import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;



public class TestEsbServicePayloadContentsDisplay extends Esb {
	Robot rob = null;
	
	
	@Test()
	public void testPopUpPayLoadContens(){
		
	
		this.openServiceActivityMonitor();
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-port']", WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-port']");
		this.sleep(2000);
		this.clickWaitForElementPresent("//legend[text()='Response IN']//parent::fieldset//img[@class='samui-event-content-popup-link']");
		this.waitForElementPresent("//div[contains(@class,'x-small-editor x-window-header x-window-draggable x-component')]//img[@class=' x-panel-inline-icon']", WAIT_TIME);
		String getContent = selenium.getText("//div[@class='x-window-body']");
		String length = selenium.getText("//div[@class='samui-event-content']");
		int len = Integer.parseInt(length.substring(length.indexOf(":")+1,length.length()-1).trim());
		System.out.println(len);
		System.out.println(getContent.length());
		Assert.assertTrue(getContent.length()>=len, "envelop infor for request in is wrong");
		selenium.click("//div[contains(@class,'x-small-editor x-window-header x-window-draggable x-component')]//div[contains(@class,'x-nodrag x-tool-close x-tool x-component')]");
		this.waitForElementDispear("//div[contains(@class,'x-small-editor x-window-header x-window-draggable x-component')]//img[@class=' x-panel-inline-icon']", WAIT_TIME);
		
		selenium.click("//div[text()='Service Activity Monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader" +
		" x-panel-body-noborder x-border-layout-ct']//b[text()='Refresh']");
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-port']");
		rob.keyPress(KeyEvent.VK_DOWN);
		this.clickWaitForElementPresent("//legend[text()='Request OUT']//parent::fieldset//img[contains(@class,'samui-event-content-popup-link')]");
		this.waitForElementPresent("//div[contains(@class,'x-small-editor x-window-header x-window-draggable x-component')]//img[@class=' x-panel-inline-icon']", WAIT_TIME);
		getContent = selenium.getText("//div[@class='x-window-body']");
		length = selenium.getText("//div[@class='samui-event-content']");
		len = Integer.parseInt(length.substring(length.indexOf(":")+1,length.length()-1).trim());
		System.out.println(len);
		System.out.println(getContent.length());
		Assert.assertTrue(getContent.length()>=len, "envelop infor for request in is wrong");
		System.out.println(getContent.length());
		selenium.click("//div[contains(@class,'x-small-editor x-window-header x-window-draggable x-component')]//div[contains(@class,'x-nodrag x-tool-close x-tool x-component')]");
		this.waitForElementDispear("//div[contains(@class,'x-small-editor x-window-header x-window-draggable x-component')]//img[@class=' x-panel-inline-icon']", WAIT_TIME);
		
	}
	
	@Test
	public void testEnvelopeOpenClose(){
		
	
		this.openServiceActivityMonitor();
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-port']", WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-port']");
		this.sleep(2000);
		this.clickWaitForElementPresent("//legend[text()='Response IN']//parent::fieldset//img[contains(@class,'samui-event-content-popup-link')]");
		this.waitForElementPresent("//div[contains(@class,'x-small-editor x-window-header x-window-draggable x-component')]//img[@class=' x-panel-inline-icon']", WAIT_TIME);
		try {
			 rob = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rob.keyPress(KeyEvent.VK_ESCAPE);
		rob.keyRelease(KeyEvent.VK_ESCAPE);
		this.waitForElementDispear("//div[contains(@class,'x-small-editor x-window-header x-window-draggable x-component')]//img[contains(@class,'x-panel-inline-icon')]", WAIT_TIME);
		
		selenium.click("//div[text()='Service Activity Monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader" +
				" x-panel-body-noborder x-border-layout-ct']//b[text()='Refresh']");
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-port']");
		rob.keyPress(KeyEvent.VK_DOWN);
		this.clickWaitForElementPresent("//legend[text()='Request OUT']//parent::fieldset//img[@class='samui-event-content-popup-link']");
		this.waitForElementPresent("//div[contains(@class,'x-small-editor x-window-header x-window-draggable x-component')]//img[@class=' x-panel-inline-icon']", WAIT_TIME);
		rob.keyPress(KeyEvent.VK_ESCAPE);
		rob.keyRelease(KeyEvent.VK_ESCAPE);
		this.waitForElementDispear("//div[contains(@class,'x-small-editor x-window-header x-window-draggable x-component')]//img[@class=' x-panel-inline-icon']", WAIT_TIME);
		
	}
	
	
//	@Test
	public void testCopy(){
		this.clickWaitForElementPresent("idMenuUserElement");
		this.sleep(5000);
		selenium.mouseDown("//div[text()='admin@company.com']");
		selenium.setSpeed(MID_SPEED);
		this.copy("//input[@id='idUserFirstNameInput']");
		this.paste("//input[@id='idUserFirstNameInput']");
		this.sleep(5000);
		selenium.click("idFormSaveButton");
//		selenium.setSpeed(MIN_SPEED);
		
		
		
	}
	
	public void copy(String contentXpath){
		try {
			 rob = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.focus(contentXpath);
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_A);
		rob.keyRelease(KeyEvent.VK_A);
//		selenium.controlKeyUp();
//		selenium.controlKeyDown();
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_C);
		rob.keyRelease(KeyEvent.VK_C);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		
		
	}
	
	public void paste(String contentXpath){
		try {
			 rob = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.click(contentXpath);
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_CONTROL);
	}
	
}
