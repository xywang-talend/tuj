package com.talend.tac.cases.audit;

import static org.testng.Assert.assertEquals;
import java.awt.Event;
import java.awt.event.KeyEvent;
import java.io.File;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;

public class TestChangeAuditReportStoredPathInConfiguration extends Audit {
	
/*	//change audit report stored path in configuration, go to audit page.select a  project
   and branch ,start audit, go to the directory to check the reports generated */
	@Test
	@Parameters({"auditStoredReportsPath","mysqlURL", "mysqlUserName", "mysqlPassWord", "mysqlDriver", "ProjectWithSpaceChar", 
		"jobNameTJava"})
	public void testChangeAuditReportStoredPathInConfiguration(String auditStoredReportsPath, String url, String userName, String userPassWd, String driver,
			   String projectName, String tjava) {
		
		//get get incipient report path
		String defaultPath = this.getDefaultReportPath();
		
	    this.typeWordsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.editButton"),locatorOfAllInputTags, this.getAbsolutePath(auditStoredReportsPath));
	    this.AssertEqualsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.editButton"),locatorOfAllInputTags, this.getAbsolutePath(auditStoredReportsPath),other.getString("audit.conf.reportsStoredPath.statusIcon"));
		
	    this.openAudit();
		   
	    /*change db info*/
	    this.configAuditDB(url, userName, driver, userPassWd);
	    selenium.setSpeed(MID_SPEED);
	    selenium.keyPressNative(Event.TAB +"");
	    selenium.keyPressNative(Event.TAB +"");
	    selenium.click("idDbConfigSaveButton");
	    selenium.setSpeed(MIN_SPEED);
	   
	    this.waitForCheckConnectionStatus("//div[text()='OK']", 3);
	    selenium.click("//div[contains(@class,'x-nodrag x-tool-close x-tool x-component')]");
//	    /*change db info*/
	   
	    this.auditProcess(projectName, "trunk");
	   
	    /*check audit tesult*/
	    this.waitForElementPresent("//div//font[1][text()='The Audit process has terminated successfully']", WAIT_TIME*4);
	    this.waitForElementPresent("//div//font[3][text()='The Audit process has terminated successfully']", WAIT_TIME*4);	   
	    this.waitForElementPresent("//a[contains(text(),'Audit for project \"PROJECT_SPACE\" created at')]", WAIT_TIME);
	    
	    //check report pdf after audit 
		File auditReportFile = this.checkReportPdf(this.getAbsolutePath(auditStoredReportsPath), projectName, tjava);
	    
	    auditReportFile.delete(); 	    
	    
	    //go to configuration page
		this.clickWaitForElementPresent("idMenuConfigElement");
		
//		//change value of 'reports stored path' to a directory exist
		this.waitForElementPresent("//div[contains(text(),'Audit (')]", WAIT_TIME);
		selenium.mouseDown("//div[contains(text(),'Audit (')]");
		
	    this.typeWordsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.editButton"),locatorOfAllInputTags, defaultPath);
	    this.AssertEqualsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.editButton"),locatorOfAllInputTags, defaultPath,other.getString("audit.conf.reportsStoredPath.statusIcon"));
	    
	}
	
	//change 'reports stored path' with not exist path
	@Test
	@Parameters({"auditStoredReportsPathWithNotExistPath"})
	public void testChangeReportStoredPathWithNotExistPath(String notExistPath) {
		
		//go to configuration page
		this.clickWaitForElementPresent("idMenuConfigElement");
		
		//change value of 'reports stored path' to a directory not exist
		this.waitForElementPresent("//div[contains(text(),'Audit (')]", WAIT_TIME);
		selenium.mouseDown("//div[contains(text(),'Audit (')]");
		
		this.clickWaitForElementPresent(other.getString("audit.conf.reportsStoredPath.editButton"));//click the edit button to make the input tag shown.
		String defaultPath = selenium.getValue(locatorOfAllInputTags);
		selenium.keyDownNative(""+KeyEvent.VK_ENTER);
		System.out.println(">>>>>>>>"+defaultPath);
		
		/*change 'reports stored path' to a not exist path*/
	    this.typeWordsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.editButton"),locatorOfAllInputTags, notExistPath);
	    this.AssertEqualsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.editButton"),locatorOfAllInputTags, notExistPath,other.getString("audit.conf.reportsStoredPath.notExistPath.statusIcon"));
	    
	    this.waitForElementPresent("//div[contains(text(),'Audit (')]/parent::div/following-sibling::div//table//div[text()='Reports stored path']/parent::td/following-sibling::" +
	    		"td//div[text()='Path does not exist']", WAIT_TIME);
	    
	    /*change 'reports stored path' to incipient path*/
	    this.typeWordsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.editButton"),locatorOfAllInputTags, defaultPath);
	    this.AssertEqualsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.editButton"),locatorOfAllInputTags, defaultPath,other.getString("audit.conf.reportsStoredPath.statusIcon"));
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
		
	}
	/**
	 * assertions,check the value in input tag is as expected,and check the status icon.
	 * @param locatorOfEditButton
	 * @param locatorOfInput	
	 * @param value
	 */
		public void AssertEqualsInConfigurationMenu(String locatorOfEditButton,String locatorOfInput,String value,String statusIconLocator){
		this.AssertEqualsInConfigurationMenu(locatorOfEditButton, locatorOfInput, value);
			this.waitForElementPresent(statusIconLocator, WAIT_TIME);//wait and check the icon status.
	}
	public void AssertEqualsInConfigurationMenu(String locatorOfEditButton,String locatorOfInput,String value){
		this.clickWaitForElementPresent(locatorOfEditButton);//click the edit button to make the input tag shown.
		this.waitForElementPresent(locatorOfInput, Base.WAIT_TIME);
		assertEquals(selenium.getValue(locatorOfInput), value);
		selenium.fireEvent(locatorOfInput, "blur");
	}
	
}
