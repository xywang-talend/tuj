package com.talend.cases.configuration;

import static org.testng.Assert.assertEquals;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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
		 this.typeWaitForElementPresent(locatorOfInput, value);
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 selenium.keyPressNative(Event.ENTER+"");
		
	}
	/**
	 * assertions,check the value in input tag is as expected,and check the status icon.
	 * @param locatorOfEditButton
	 * @param locatorOfInput	
	 * @param value
	 */
	public void AssertEqualsInputInConfigurationMenu(String locatorOfEditButton,String locatorOfInput,String value){
		this.clickWaitForElementPresent(locatorOfEditButton);
		selenium.setSpeed("2000");
		Assert.assertEquals(selenium.getValue(locatorOfInput), value);
		selenium.setSpeed("0");
		selenium.keyPressNative(KeyEvent.VK_ENTER+"");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void AssertEqualsInConfigurationMenu(String locatorOfValue,String value){
		
		this.waitElement(locatorOfValue, WAIT_TIME);
		selenium.setSpeed("2000");
		assertEquals(selenium.getText(locatorOfValue), value);
		selenium.setSpeed("0");
		
	}
	
	public void AssertEqualsInConfigurationMenu(String locatorOfValue,String value,String statusIconLocator){
		this.AssertEqualsInConfigurationMenu(locatorOfValue, value);
			this.waitForElementPresent(statusIconLocator, WAIT_TIME);//wait and check the icon status.
	}
	
	public void selectDropDownListInConfigurationMenu(String locatorOfEditButton,String locatorOfSelect,String value){
		 this.clickWaitForElementPresent(locatorOfEditButton);//click the edit button to make the input tag shown.
		 selenium.setSpeed(MID_SPEED);
		 this.selectDropDownList(locatorOfSelect, value);
//		 selenium.fireEvent(locatorOfInput, "blur");
		 selenium.setSpeed(MIN_SPEED);
	}
	
	
	public void selectDropDownList(String xpath, String value) {

		this.waitElement(xpath, WAIT_TIME);
		selenium.click(xpath);
		this.waitElement("//div[contains(@class,'x-combo-list-item') and text()='"+value+"']", WAIT_TIME);
		selenium.mouseDown("//div[contains(@class,'x-combo-list-item') and text()='"+value+"']");
		selenium.keyPressNative(Event.ENTER+"");
		
	}
	@BeforeMethod
	@Override
	@Parameters( { "userName", "userPassword" })
	public void login(String user, String password) {
		super.login(user, password);
		this.clickWaitForElementPresent("idMenuConfigElement");
//		selenium.setSpeed("500");
		this.waitForElementPresent("//div[text()='Configuration' and @class='header-title']", WAIT_TIME);
		String onlineButton = "//div[text()='Configuration' and @class='header-title']//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component x-border-panel')]/following-sibling::div//button[@aria-pressed='true']";
//		String offlineButton = "//div[text()='Configuration' and @class='header-title']//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component x-border-panel')]/following-sibling::div//button[@aria-pressed='false']";
		if(selenium.isElementPresent(onlineButton)) {
			
			selenium.click(onlineButton);			
			
		}
				
	}

	@AfterMethod
	@Override
	public void logout() {
		selenium.click("idLeftMenuTreeLogoutButton");
		this.waitForElementPresent("idLoginButton", WAIT_TIME);
	}

	@Override
	public void typeWaitForElementPresent(String locator,String value) {
		this.waitForElementPresent(locator, Base.WAIT_TIME);
		selenium.type(locator,value);
		selenium.fireEvent(locator, "blur");
	}

	@AfterClass
	public void killBroswer() {
		selenium.stop();
	}
	
}
