package com.talend.cases.configuration;

import static org.testng.Assert.assertEquals;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.talend.tac.base.AntAction;
import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class configuration extends Login {
  

	int seconds = 0;
	//start zookeeper server
	public void startStopZkServer(String controlZkServer, String zookeeperPath) {
		
		 AntAction aa = new AntAction();
	     Hashtable<String, String> properties = new Hashtable<String, String>();
	     properties.put("server.home", zookeeperPath);
	     properties.put("command", "zkServer.cmd");
	     properties.put("action", controlZkServer);
	     aa.runTarget("Server.xml", properties);
		
	}
	
	/**
	 * type a value in configuration menu.click the edit button firstly to wait for the input to appear.
	 * @param locatorOfEditButton
	 * @param locatorOfInput
	 * @param value
	 */
	public void typeWordsInConfigurationMenu(String locatorOfEditButton,String locatorOfInput,String value){
		 this.clickWaitForElementPresent(locatorOfEditButton);//click the edit button to make the input tag shown.
		 selenium.setSpeed(MID_SPEED);
		 this.typeWaitForElementPresent(locatorOfInput, value);
		 selenium.keyPress(locatorOfInput, KeyEvent.VK_ENTER+"");
		 selenium.setSpeed(MIN_SPEED);
	}
	
	public void selectDropDownListInConfigurationMenu(String locatorOfEditButton,String locatorOfSelect,String value){
		 this.clickWaitForElementPresent(locatorOfEditButton);//click the edit button to make the input tag shown.
		 selenium.setSpeed(MID_SPEED);
		 this.selectDropDownList(locatorOfSelect, value);
//		 selenium.fireEvent(locatorOfInput, "blur");
		 selenium.setSpeed(MIN_SPEED);
	}
	/**
	 * assertions,check the value in input tag is as expected,and check the status icon.
	 * @param locatorOfEditButton
	 * @param locatorOfInput	
	 * @param value
	 */
		public void AssertEqualsInConfigurationMenu(String locatorOfEditButton,String locatorOfInput,String value,String statusIconLocator){
		    this.AssertEqualsInConfigurationMenu(locatorOfEditButton, locatorOfInput, value);
			this.clickWaitForElementPresent(locatorOfEditButton);
			selenium.setSpeed(MID_SPEED);
		    selenium.keyPress(locatorOfInput, KeyEvent.VK_ENTER+"");
		    this.waitForElementPresent(statusIconLocator, WAIT_TIME);//wait and check the icon status.
	        selenium.setSpeed(MIN_SPEED);  
		}
	public void AssertEqualsInConfigurationMenu(String locatorOfEditButton,String locatorOfInput,String value){
		this.clickWaitForElementPresent(locatorOfEditButton);//click the edit button to make the input tag shown.
		this.waitForElementPresent(locatorOfInput, Base.WAIT_TIME);
		assertEquals(selenium.getValue(locatorOfInput), value);
		selenium.keyPressNative(KeyEvent.VK_ENTER+"");
		
	}
	
	public void selectDropDownList(String xpath, String value) {
		
		selenium.click(xpath);
		selenium.mouseDownAt("//div[contains(@class,'x-combo-list-item') and text()='"+value+"']", ""
				+ Event.ENTER);
		
	}
	@BeforeClass
	@Override
	@Parameters( { "userName", "userPassword" })
	public void login(String user, String password) {
		super.login(user, password);
		this.clickWaitForElementPresent("idMenuConfigElement");
//		selenium.setSpeed("500");
		this.waitForElementPresent("//div[text()='Configuration' and @class='header-title']", WAIT_TIME);
		String onlineButton = "//div[text()='Configuration' and @class='header-title']//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component x-border-panel')]/following-sibling::div//button[@aria-pressed='true']";
		String offlineButton = "//div[text()='Configuration' and @class='header-title']//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component x-border-panel')]/following-sibling::div//button[@aria-pressed='false']";
		if(selenium.isElementPresent(onlineButton)) {
			
			selenium.click(onlineButton);			
			
		}
		this.waitForElementPresent(offlineButton, WAIT_TIME);
		
	}

	@AfterClass
	@Override
	public void logout() {
		selenium.click("idLeftMenuTreeLogoutButton");
		selenium.stop();
	}

	@Override
	public void typeWaitForElementPresent(String locator,String value) {
		this.waitForElementPresent(locator, Base.WAIT_TIME);
		selenium.type(locator,value);
		selenium.fireEvent(locator, "blur");
	}

	@Override
	public void killBroswer() {
	}
	
}
