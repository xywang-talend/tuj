package com.talend.cases.esb;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestSamServerNotRunning extends Esb {
	public String locatorOfAllInputTags = other.getString("commandline.conf.all.input");
	
	 @BeforeMethod
	 @Override
	 @Parameters( { "userName", "userPassword" })
	 public void login(String user, String password) {
	  super.login(user, password);
	  this.clickWaitForElementPresent("idMenuConfigElement");
	//  selenium.setSpeed("500");
	  this.waitForElementPresent("//div[text()='Configuration' and @class='header-title']", WAIT_TIME);
	  String onlineButton = "//div[text()='Configuration' and @class='header-title']//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component x-border-panel')]/following-sibling::div//button[@aria-pressed='true']";
	//  String offlineButton = "//div[text()='Configuration' and @class='header-title']//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component x-border-panel')]/following-sibling::div//button[@aria-pressed='false']";
	  if(selenium.isElementPresent(onlineButton)) {
	   
	   selenium.click(onlineButton);   
	   
	  }
	    
	 }
	
	/**
	 * this method is mainly to test in case of samserver is not running
	 * @param zookeeperServer
	 * @param serviceActivityMonitorServer
	 * @param monitorStop
	 */
	@Test
	@Parameters ({"esbConfZookeeperServer","esbConfServiceActivityMonitorServer","esbConfServiceActivityMonitorServerStop"})
	public void testSamServerNotRunning(String zookeeperServer,String serviceActivityMonitorServer,String monitorStop){
		  this.clickWaitForElementPresent("idMenuConfigElement");
		  
		  this.waitForElementPresent("//div[@class='header-title' and text()='Configuration']", WAIT_TIME);
		  if(selenium.isElementPresent("//button[@class='x-btn-text' and @aria-pressed='true']")) {
			
			 selenium.click("//div[text()='Configuration' and @class='header-title']"+
			"//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct')]"+
			"//button[@class='x-btn-text' and @aria-pressed='true']");
			 this.waitForElementPresent("//div[text()='Configuration' and @class='header-title']"+
					"//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct')]"+
					"//button[@class='x-btn-text' and @aria-pressed='false']", WAIT_TIME);
			
		  }
		  this.mouseDownWaitForElementPresent("//div[contains(text(),'ESB (')]");
		  selenium.setSpeed(MID_SPEED);
		  //change sam server to remote stoped
//	      this.typeWordsInConfigurationMenu(other.getString("esb.conf.ZookeeperServer.editButton"), other.getString("esb.conf.ZookeeperServer.input"), zookeeperServer);
	      this.typeWordsInConfigurationMenu(other.getString("esb.conf.serviceActivityMonitorServer.editButton"), other.getString("esb.conf.serviceActivityMonitorServer.input"), monitorStop);
	      this.AssertEqualsInConfigurationMenu(other.getString("esb.conf.serviceActivityMonitorServer.value"), monitorStop);
		  this.waitForTextPresent("SAM Server for this url is unavailable", WAIT_TIME);
		  //open service activity monitor page
		  this.openServiceActivityMonitor();		  
		  this.clickWaitForElementPresent("//div[@class='header-title' and text()='Service Activity Monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//b[text()='Refresh']");
		  Assert.assertTrue(this.waitForTextPresent("Can not connect to SAM Server", WAIT_TIME),"test with stop samserver failed!");
	}
	
//	@AfterMethod
//	@Parameters ({"esb.conf.zookeeperServer","esb.conf.serviceActivityMonitorServer.remote.available","esb.conf.serviceActivityMonitorServer.remote.stop"})
//	public void logout(String zookeeperServer,String serviceActivityMonitorServer,String monitorStop) {
//		  this.clickWaitForElementPresent("idMenuConfigElement");
//		  
//		  selenium.setSpeed(MAX_SPEED);
//		  
//		  if(!selenium.isVisible("//div[text()='Apache Zookeeper Server(s)']")) {
//			  
//			  this.mouseDownWaitForElementPresent("//div[contains(text(),'ESB (')]");
//			  
//		  }
//		  selenium.setSpeed(MIN_SPEED);
//		  this.typeWordsInConfigurat	ionMenu(other.getString("esb.conf.serviceActivityMonitorServer.editButton"), other.getString("esb.conf.serviceActivityMonitorServer.input"), serviceActivityMonitorServer);
//		  this.AssertEqualsInConfigurationMenu(other.getString("esb.conf.serviceActivityMonitorServer.value"), serviceActivityMonitorServer);
//	}
	
	
}
