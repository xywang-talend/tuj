package com.talend.tac.cases.esb.serviceLocator;

import static org.testng.Assert.assertEquals;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import org.testng.Assert;

import com.talend.tac.base.AntAction;
import com.talend.tac.base.Karaf;
import com.talend.tac.cases.Login;

public class EsbUtil extends Login {
 
	Karaf karaf = new Karaf("localhost");
	public String locatorOfAllInputTags = other.getString("commandline.conf.all.input");
    public int seconds = 0;
	//start zookeeper server
	public void startStopZkServer(String controlZkServer, String zookeeperPath) {
		
		 AntAction aa = new AntAction();
	     Hashtable<String, String> properties = new Hashtable<String, String>();
	     properties.put("server.home", zookeeperPath);
	     properties.put("command", "zkServer.cmd");
	     properties.put("action", controlZkServer);
	     aa.runTarget("Server.xml", properties);
		
	}
	
	public void uninstallService(String jobName) {
		
		karaf.karafAction("uninstall "+jobName+"", 5000);
		System.out.println("**--**the "+jobName+" is unintall successful");
		
	}
	
	public void startAllService(String jobFirstProviderFilePath, String jobFirstProvider,
			String jobSecondProviderFilePath, String jobSecondProvider, String jobThirdProviderFilePath, 
			 String jobThirdProvider) {
		
		installStratService(jobFirstProviderFilePath, jobFirstProvider);
		installStratService(jobSecondProviderFilePath, jobSecondProvider);
		installStratService(jobThirdProviderFilePath, jobThirdProvider);
		
	}	
	
	public void stopAllService(String jobFirstProvider, String jobSecondProvider, 
			String jobThirdProvider) {
		
		stopService(jobFirstProvider);
		stopService(jobSecondProvider);
		stopService(jobThirdProvider);
		
	}
	
	public void installStratService(String filePath, String jobName) {
		
		System.out.println("install -s file://"+	(filePath));
		System.out.println("**--**start");
		karaf.karafAction("install -s file://"+getAbsolutePath(filePath)+"", 5000);
		System.out.println("**--**end");
		karaf.karafAction("job:start "+jobName+"", 5000);
		System.out.println("**--**end");
		
	}
	
	public void installService(String filePath) {
		
		System.out.println("install -s file://"+	(filePath));
		System.out.println("**--**start");
		karaf.karafAction("install -s file://"+getAbsolutePath(filePath)+"", 5000);
		System.out.println("**--**end");
		
	}
	
	public void stopService(String jobName) {
		
		System.out.println("**--**start");
		karaf.karafAction("stop "+jobName+"", 5000);
		System.out.println("**--**end");
		
	}
	
	public void startStopKaraf(String karafPath) {
		
		 AntAction aa = new AntAction();
	     Hashtable<String, String> properties = new Hashtable<String, String>();
	     properties.put("server.home", karafPath);
	     properties.put("command", "zkServer.cmd");
	     properties.put("action", "");
	     aa.runTarget("Server.xml", properties);
		
	}
	
	public void assertStartService(String jobName) {
		
		this.waitForElementPresent("//div[text()='"+jobName+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+jobName+"']"));
		Assert.assertTrue(!selenium.isElementPresent("//div[text()='"+jobName+"']//ancestor::div[contains(@class,'x-grid-group')]" +
		"//span[contains(text(),'Last seen')]"));
			
	}
	
	public void assertStopService(String jobName) {
		
		this.waitForElementPresent("//div[contains(text(),'"+jobName+"')]//ancestor::div[contains(@class,'x-grid-group')]" +
				"//span[contains(text(),'Last seen')]", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'"+jobName+"')]//ancestor::div[contains(@class,'x-grid-group')]" +
				"//span[contains(text(),'Last seen')]"));
		                       
	}
	
	public void checkSortAscendingSortDescending(String xpathName, String value, String value1) {
				
		selenium.setSpeed(MID_SPEED);
        selenium.click("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-"+xpathName+"')]/a");
        selenium.setSpeed(MIN_SPEED);  
		selenium.click("//a[text()='Sort Descending']");
		selenium.setSpeed(MID_SPEED);
		System.out.println("---decending actually:"+selenium.getText("//div[@class='x-grid3-cell-inner x-grid3-col-"+xpathName+"']"));
		Assert.assertEquals(selenium.getText("//div[@class='x-grid3-cell-inner x-grid3-col-"+xpathName+"']"), value);       
        selenium.setSpeed(MIN_SPEED);
        
        selenium.setSpeed(MID_SPEED);
        selenium.click("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-"+xpathName+"')]/a");
        selenium.setSpeed(MIN_SPEED);  
		selenium.click("//a[text()='Sort Ascending']");
		selenium.setSpeed(MID_SPEED);
		System.out.println("---ascending actually"+selenium.getText("//div[@class='x-grid3-cell-inner x-grid3-col-"+xpathName+"']"));
		Assert.assertEquals(selenium.getText("//div[@class='x-grid3-cell-inner x-grid3-col-"+xpathName+"']"), value1);
		selenium.setSpeed(MIN_SPEED);
		
	}
	
	public void changeGroupDisplayService(String filedName, String newFiledName, String xpath) {
		
		
		this.clickWaitForElementPresent("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-"+filedName+"')]/a");		
		
		selenium.setSpeed(MID_SPEED);
		//cancel group display
		selenium.click("//a[text()='Show in Groups']");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isElementPresent("//div[@class='x-grid-group-div']"));
		selenium.setSpeed(MIN_SPEED);
		
		this.clickWaitForElementPresent("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-"+newFiledName+"')]/a");
		selenium.setSpeed(MID_SPEED);
		//select filed, service of according to the filed group display	
		selenium.click("//a[text()='Group By This Field']");
		
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+xpath+"']"));
		selenium.setSpeed(MIN_SPEED);
		
		
	}
	
	//hidden services/display service    
	public void hiddenDisplayServices(String serviceEndPoint,String serviceName) {
	 
		
		if(selenium.isTextPresent(serviceEndPoint) && selenium.isTextPresent(serviceName)) {
			
			if(selenium.isVisible("//div[text()='"+serviceEndPoint+"']")) {
			 
				 selenium.mouseDown("//div[text()='"+serviceName+"']");
				 selenium.setSpeed(MID_SPEED);
				 Assert.assertFalse(selenium.isVisible("//div[text()='"+serviceEndPoint+"']"));
				 selenium.setSpeed(MIN_SPEED);
			} else {
				 
				 selenium.mouseDown("//div[text()='"+serviceName+"']");
				 selenium.setSpeed(MID_SPEED);
				 Assert.assertTrue(selenium.isVisible("//div[text()='"+serviceEndPoint+"']"));
				 selenium.setSpeed(MIN_SPEED);
			}
			
		} else {
			
			System.out.println("services does not exist or wrong title");
		}
		
		
	}
	
	//modify the services display columns
	public void modifyDisplayServicesColumns(String xpathName) {
		

		if(selenium.isElementPresent("//span[text()='"+xpathName+"']")) {
			selenium.setSpeed(MID_SPEED);
			selenium.click("//a[text()='"+xpathName+"']/img[@class=' x-menu-item-icon']");
			Assert.assertFalse(selenium.isElementPresent("//span[text()='"+xpathName+"']"));
		    selenium.setSpeed(MIN_SPEED);
		} else {
			
			selenium.setSpeed(MID_SPEED);
			selenium.click("//a[text()='"+xpathName+"']/img[@class=' x-menu-item-icon']");
		    Assert.assertTrue(selenium.isElementPresent("//span[text()='"+xpathName+"']"));
		    selenium.setSpeed(MIN_SPEED);
		}
		

	}
	
	//sort table by click on column header
	public void SortTableByClickOnColumnHeader(String columnName, String value, String value1) {
		
		selenium.click("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-name x-component sort-asc')]");
		System.out.println(selenium.getText("//div[@class='x-grid3-cell-inner x-grid3-col-"+columnName+"']"));
		Assert.assertEquals(selenium.getText("//div[@class='x-grid3-cell-inner x-grid3-col-"+columnName+"']"), value1);
		selenium.click("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-name x-component sort-desc')]");		
		System.out.println(selenium.getText("//div[@class='x-grid3-cell-inner x-grid3-col-"+columnName+"']"));
		Assert.assertEquals(selenium.getText("//div[@class='x-grid3-cell-inner x-grid3-col-"+columnName+"']"), value1);
		
	}
	
	//start zookeeper server
	public void startStopZkServer(String controlZkServer) {
		
		 AntAction aa = new AntAction();
	     Hashtable<String, String> properties = new Hashtable<String, String>();
	     properties.put("server.home", "D:\\produck\\fgzhang\\talend-esb-4.2\\zookeeper");
	     properties.put("command", "zkServer.cmd");
	     properties.put("action", controlZkServer);
	     aa.runTarget("Server.xml", properties);
		
	}
    
	public void modifyEsbConfigurationInConfigurationPage(String ServiceLocation, String zookeeperServerStatusIconLocator) {	
		
		//go to configuration page 
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
		this.typeWordsInConfigurationMenu(other.getString("esb.conf.ZookeeperServer.editButton"), other.getString("esb.conf.ZookeeperServer.input"), ServiceLocation);
	  	
		selenium.click("idConfigRefreshButton");
		
	  	this.AssertEqualsInConfigurationMenu(other.getString("esb.conf.ZookeeperServer.value"),
	  			ServiceLocation, zookeeperServerStatusIconLocator);	    
		
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
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       selenium.keyPressNative(Event.ENTER+"");
	
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
	
	public void modifySAMServer(String MonitorServer, String MonitorServerStatusIconLocator) {					     
		  
		this.typeWordsInConfigurationMenu(other.getString("esb.conf.serviceActivityMonitorServer.editButton"), other.getString("esb.conf.serviceActivityMonitorServer.input"), MonitorServer);
		  
//	    this.AssertEqualsInConfigurationMenu(other.getString("esb.conf.serviceActivityMonitorServer.value"),
//			   MonitorServer, MonitorServerStatusIconLocator);
//		
	}
	
	public void uploadLicense(String license) {
		
	   this.waitForElementPresent("//b[text()='admin, admin']", WAIT_TIME);
	   
	   selenium.setSpeed(MID_SPEED);
       if(!selenium.isElementPresent("//span[text()='ESB Infrastructure']")) {
    	   
			selenium.setSpeed(MIN_SPEED);			
			this.clickWaitForElementPresent("idMenuLicenseElement");
			waitForElementPresent("//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]", WAIT_TIME);
			selenium.type("//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]", parseRelativePath(license));
			selenium.click("//button[text()='Upload']");
			
	   }
       
       selenium.setSpeed(MIN_SPEED);	
       System.out.println("license upload is successful");	
       
       try {
		Thread.sleep(3000);
	   } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	   }
       selenium.refresh();       
       this.waitForElementPresent("//span[text()='ESB Infrastructure']", WAIT_TIME);
       
	}	

}
