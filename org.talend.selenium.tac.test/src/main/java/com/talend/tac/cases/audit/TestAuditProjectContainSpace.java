package com.talend.tac.cases.audit;

import java.awt.Event;
import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAuditProjectContainSpace extends Audit {
   
   @Test
   @Parameters({"mysqlURL", "mysqlUserName", "mysqlPassWord", "mysqlDriver", "projectWithSpaceChar","jobNameTJava"})
   public void testAuditProjectContainsSpace(String url, String userName, String userPassWd, String driver,
		   String projectName, String tjava) {
	   
	   //get get incipient report path
	   String defaultPath = this.getDefaultReportPath();
	   this.openAudit();
	   /*change db info*/
	   this.configAuditDB(url, userName, driver, userPassWd);
	   selenium.setSpeed(MID_SPEED);
	   selenium.keyPressNative(Event.TAB +"");
//	   selenium.keyPressNative(Event.TAB +"");
	   selenium.click("idDbConfigSaveButton");
	   selenium.setSpeed(MIN_SPEED);
	   
	   this.waitForCheckConnectionStatus("//div[text()='OK']", 3);
	   selenium.click("//div[contains(@class,'x-nodrag x-tool-close x-tool x-component')]");
	   /*change db info*/
	   
	   this.auditProcess(projectName, "trunk");
	   
	   /*check audit tesult*/
//	   this.waitForElementPresent("//div//font[1][text()='The Audit process has terminated successfully']", WAIT_TIME*4);
//	   this.waitForElementPresent("//div//font[3][text()='The Audit process has terminated successfully']", WAIT_TIME*4);	   
//	   this.waitForElementPresent("//a[contains(text(),'Audit for project \"PROJECT_SPACE\" created at')]", WAIT_TIME);
	  
	   int linksbefore = checkAuditListLink(projectName);
	   Assert.assertTrue(checkAuditInfo(projectName),"TestAudit audit branch failed!");
	   this.sleep(5000);
//	   Assert.assertTrue((checkAuditListLink("PROJECT_SPACE")==linksbefore +1),"TestAudit audit branch failed,not create links!");
	   
	   String reportFileName = this.getReportFileName();
	   File auditReportFile = this.checkReportPdf(defaultPath, "project_space", tjava); 
	   auditReportFile.delete();
	   
   }	
 	
}
