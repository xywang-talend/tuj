package com.talend.tac.cases.audit;

import java.awt.Event;
import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAuditProjectWithH2DB extends Audit {
    
	@Test
	@Parameters({"dbUrl", "h2UserName", "h2PassWord", "h2Driver", "addCommonProjectName","trunjobWithCheckpoint", "tjavaWithMulripleCheckpoint", 
		"jobNameTJava"})
	public void testAuditProjectWithH2DB(String url, String userName, String userPassWd, String driver,
			   String projectName, String trunjobWithCheckpoint, String tjavaWithMulripleCheckpoint, String tjava) {
		
	   //get get incipient report path
	   String defaultPath = this.getDefaultReportPath();
		
	   this.openAudit();
		   
	   /*change db info*/
	   this.configAuditDB(this.getFormatedDbURL(url), userName, driver, userPassWd);
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
	   this.waitForElementPresent("//div//font[1][text()='The Audit process has terminated successfully']", WAIT_TIME*4);
	   this.waitForElementPresent("//div//font[3][text()='The Audit process has terminated successfully']", WAIT_TIME*4);	   
	   
//	   int auditListLinkCount = this.checkAuditListLink(projectName);
//	   Assert.assertEquals(auditListLinkCount, 2);
	   String reportFileName = this.getReportFileName();
	   File auditReportFile = this.checkReportPdf(defaultPath, projectName, tjava);
	   Assert.assertTrue(this.isExistedInfoInPdf(defaultPath+"/"+reportFileName, trunjobWithCheckpoint));
	   Assert.assertTrue(this.isExistedInfoInPdf(defaultPath+"/"+reportFileName, tjavaWithMulripleCheckpoint));
	   auditReportFile.delete();
	   
	}
	
}
