package com.talend.tac.cases.audit;

import java.awt.Event;
import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestChangeAuditReportStoredPathInConfiguration extends Audit {
	
	String defaultPath = "";
	
/*	//change audit report stored path in configuration, go to audit page.select a  project
   and branch ,start audit, go to the directory to check the reports generated */
	@Test
	@Parameters({"auditStoredReportsPath","mysqlURL", "mysqlUserName", "mysqlPassWord", "mysqlDriver", "AddcommonProjectname","trunjobWithCheckpoint", "tjavaWithMulripleCheckpoint", 
		"jobNameTJava"})
	public void testChangeAuditReportStoredPathInConfiguration(String auditStoredReportsPath, String url, String userName, String userPassWd, String driver,
			String projectName, String tRunJobCheckPoint, String tjavaCheckpoint,
			String tjava) {
		
		//get get incipient report path
		defaultPath = this.getDefaultReportPath();
		
	    this.typeWordsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.editButton"),other.getString("audit.conf.reportsStoredPath.input"), this.getAbsolutePath(auditStoredReportsPath));
	    this.AssertEqualsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.value"),this.getAbsolutePath(auditStoredReportsPath),other.getString("audit.conf.reportsStoredPath.statusIcon"));
		
	    this.openAudit();
		   
	    /*change db info*/
	    this.configAuditDB(url, userName, driver, userPassWd);
	    selenium.setSpeed(MID_SPEED);
	    selenium.keyPressNative(Event.TAB +"");
//	    selenium.keyPressNative(Event.TAB +"");
	    selenium.click("idDbConfigSaveButton");
	    selenium.setSpeed(MIN_SPEED);
	   
	    this.waitForCheckConnectionStatus("//div[text()='OK']", 3);
	    selenium.click("//div[contains(@class,'x-nodrag x-tool-close x-tool x-component')]");
//	    /*change db info*/
	   
	    this.auditProcess(projectName, "trunk");
	   
//	    int linksbefore = checkAuditListLink(projectName);
		Assert.assertTrue(checkAuditInfo(projectName),"TestAudit audit trunk failed!");
		this.sleep(5000);
	    
	    //check report pdf after audit 
		String reportFileName = this.getReportFileName();
		File auditReportFile = this.checkReportPdf(this.getAbsolutePath(auditStoredReportsPath), projectName, tjava);
		Assert.assertTrue(this.isExistedInfoInPdf(this.getAbsolutePath(auditStoredReportsPath)+"/"+reportFileName, tRunJobCheckPoint));
	    Assert.assertTrue(this.isExistedInfoInPdf(this.getAbsolutePath(auditStoredReportsPath)+"/"+reportFileName, tjavaCheckpoint));
	    auditReportFile.delete(); 	    
	    	    
	}
	
	//change 'reports stored path' with not exist path
	@Test
	@Parameters({"auditStoredReportsPathWithNotExistPath"})
	public void testChangeReportStoredPathWithNotExistPath(String notExistPath) {
		
		//go to configuration page
		this.clickWaitForElementPresent("idMenuConfigElement");
		this.waitForElementPresent("//div[text()='Configuration' and @class='header-title']", WAIT_TIME);
		String onlineButton = "//div[text()='Configuration' and @class='header-title']//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component x-border-panel')]/following-sibling::div//button[@aria-pressed='true']";
//		String offlineButton = "//div[text()='Configuration' and @class='header-title']//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component x-border-panel')]/following-sibling::div//button[@aria-pressed='false']";
		if(selenium.isElementPresent(onlineButton)) {
			
			selenium.click(onlineButton);			
			
		}
		//change value of 'reports stored path' to a directory not exist
		this.waitForElementPresent("//div[contains(text(),'Audit (')]", WAIT_TIME);
		selenium.mouseDown("//div[contains(text(),'Audit (')]");
		
		/*change 'reports stored path' to a not exist path*/
	    this.typeWordsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.editButton"),other.getString("audit.conf.reportsStoredPath.input"), notExistPath);
	    this.AssertEqualsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.value")
	    		, notExistPath,other.getString("audit.conf.reportsStoredPath.notExistPath.statusIcon"));
	    
	    this.waitForElementPresent("//div[contains(text(),'Audit (')]/parent::div/following-sibling::div//table//div[text()='Reports stored path']/parent::td/following-sibling::" +
	    		"td//div[text()='Path does not exist']", WAIT_TIME);
	    
//	    /*change 'reports stored path' to incipient path*/
//	    this.typeWordsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.editButton"),other.getString("audit.conf.reportsStoredPath.input"), defaultPath);
//	    this.AssertEqualsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.value"), defaultPath,other.getString("audit.conf.reportsStoredPath.statusIcon"));
	}
	
	@Test
	public void resetReportStoredPathToIncipient() {
		
		//go to configuration page
		this.clickWaitForElementPresent("idMenuConfigElement");
		this.waitForElementPresent("//div[text()='Configuration' and @class='header-title']", WAIT_TIME);
		String onlineButton = "//div[text()='Configuration' and @class='header-title']//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component x-border-panel')]/following-sibling::div//button[@aria-pressed='true']";
//		String offlineButton = "//div[text()='Configuration' and @class='header-title']//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component x-border-panel')]/following-sibling::div//button[@aria-pressed='false']";
		if(selenium.isElementPresent(onlineButton)) {
			
			selenium.click(onlineButton);			
			
		}
		//change value of 'reports stored path' to a directory not exist
		this.waitForElementPresent("//div[contains(text(),'Audit (')]", WAIT_TIME);
		selenium.mouseDown("//div[contains(text(),'Audit (')]");
	    /*change 'reports stored path' to incipient path*/
	    this.typeWordsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.editButton"),other.getString("audit.conf.reportsStoredPath.input"), defaultPath);
	    this.AssertEqualsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.value"), defaultPath,other.getString("audit.conf.reportsStoredPath.statusIcon"));
		
	}
	
}
