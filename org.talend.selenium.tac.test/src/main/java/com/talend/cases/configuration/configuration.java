package com.talend.cases.configuration;

import static org.testng.Assert.assertEquals;

import java.util.Hashtable;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.talend.tac.base.AntAction;
import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class configuration extends Login {
  
public String locatorOfAllInputTags = other.getString("commandline.conf.all.input");
	
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
         
		 this.waitForElementPresent("//div[contains(text(),'Audit (') and contains(@class,'x-grid-group-div')]", WAIT_TIME);		 
		 boolean configurationPageIsNotEdit = selenium.isElementPresent("//div[@style='display: block;' and @class='ext-el-mask']");
//		 System.out.println(configurationPageIsNotEdit);
	     while (seconds<=WAIT_TIME*2 && configurationPageIsNotEdit == true) {
			 
	    	 seconds++;	   
	    	 configurationPageIsNotEdit = selenium.isElementPresent("//div[@style='display: block;' and @class='ext-el-mask']");
	    	 try {
				Thread.sleep(1000);
			 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			 System.out.println("can not edit in configuration page"+seconds);
			 
		 }
	     
		 this.clickWaitForElementPresent(locatorOfEditButton);//click the edit button to make the input tag shown.
		 this.typeWaitForElementPresent(locatorOfInput, value);
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.keyDown(locatorOfInput, "\\13");
	}
	/**
	 * assertions,check the value in input tag is as expected,and check the status icon.
	 * @param locatorOfEditButton
	 * @param locatorOfInput	
	 * @param value
	 */
	public void AssertEqualsInConfigurationMenu(String locatorOfEditButton,String locatorOfInput,String value,String statusIconLocator){
		
		 this.waitForElementPresent("//div[contains(text(),'Audit (') and contains(@class,'x-grid-group-div')]", WAIT_TIME);
		 
		 boolean configurationPageIsNotEdit = selenium.isElementPresent("//div[@style='display: block;' and @class='ext-el-mask']");
//		 System.out.println(configurationPageIsNotEdit);
	     while (seconds<=WAIT_TIME*2 && configurationPageIsNotEdit == true) {			 

	    	 seconds++;	
	    	 configurationPageIsNotEdit = selenium.isElementPresent("//div[@style='display: block;' and @class='ext-el-mask']");   	 
	    	 try {
				Thread.sleep(1000);
			 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			 System.out.println("can not edit in configuration page"+seconds);
			 
		 }
	     
		this.clickWaitForElementPresent(locatorOfEditButton);
		this.AssertEqualsInConfigurationMenu(locatorOfEditButton, locatorOfInput, value);
		this.waitForElementPresent(statusIconLocator, WAIT_TIME);//wait and check the icon status.
	}
	public void AssertEqualsInConfigurationMenu(String locatorOfEditButton,String locatorOfInput,String value){		

		 this.waitForElementPresent("//div[contains(text(),'Audit (') and contains(@class,'x-grid-group-div')]", WAIT_TIME);
		 
		 boolean configurationPageIsNotEdit = selenium.isElementPresent("//div[@style='display: block;' and @class='ext-el-mask']");
//		 System.out.println(configurationPageIsNotEdit);// 
	     while (seconds<=WAIT_TIME*2 && configurationPageIsNotEdit == true) {

	    	 seconds++;	  
	    	 configurationPageIsNotEdit = selenium.isElementPresent("//div[@style='display: block;' and @class='ext-el-mask']");
	    	 try {
				Thread.sleep(1000);
			 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			 System.out.println("can not edit in configuration page"+seconds);
			 
		 }
	     
		this.clickWaitForElementPresent(locatorOfEditButton);//click the edit button to make the input tag shown.
		this.waitForElementPresent(locatorOfInput, Base.WAIT_TIME);
		assertEquals(selenium.getValue(locatorOfInput), value);
		selenium.fireEvent(locatorOfInput, "blur");
	}
	
	
	@BeforeClass
	@Override
	@Parameters( { "userName", "userPassword" })
	public void login(String user, String password) {
		super.login(user, password);
		this.clickWaitForElementPresent("idMenuConfigElement");
//		selenium.setSpeed("500");
		this.waitForElementPresent("//div[@class='header-title' and text()='Configuration']", WAIT_TIME);
		
		if(selenium.isElementPresent("//div[@class='header-title' and text()='Configuration']//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component x-border-panel')]//following-sibling::div//button[@aria-pressed='true']")) {
			
			this.clickWaitForElementPresent("//div[@class='header-title' and text()='Configuration']//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component x-border-panel')]//following-sibling::div//button[@aria-pressed='true']");
			this.waitForElementPresent("//div[@class='header-title' and text()='Configuration']//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component x-border-panel')]//following-sibling::div//button[@aria-pressed='false']", WAIT_TIME);
			
		}
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
