		package com.talend.tac.cases.audit;

import java.awt.Event;
import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAuditProjectWithSqlServer extends Audit {
	
	//audit a project with sqlserver
	@Test
	@Parameters({"sqlserverURL", "sqlserverUserName", "sqlserverPassWord", "sqlserverDriver","addCommonProjectName","trunjobWithCheckpoint", "tjavaWithMulripleCheckpoint", 
		"jobNameTJava"})
	public void testAuditProjectWithSqlServer(String url, String userName, String userPassWd, String driver,
			String projectName, String trunjobWithCheckpoint, String tjavaWithMulripleCheckpoint, String tjava) {
		
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
	   int linksbefore = checkAuditListLink(projectName);
	   Assert.assertTrue(checkAuditInfo(projectName),"TestAudit audit trunk failed!");
	   this.sleep(5000);
	   Assert.assertTrue((checkAuditListLink(projectName)==linksbefore +1),"TestAudit audit trunk failed,not create links!");
	   String reportFileName = this.getReportFileName();
	   File auditReportFile = this.checkReportPdf(defaultPath, projectName, tjava);
	   Assert.assertTrue(this.isExistedInfoInPdf(defaultPath+"/"+reportFileName, trunjobWithCheckpoint));
	   Assert.assertTrue(this.isExistedInfoInPdf(defaultPath+"/"+reportFileName, tjavaWithMulripleCheckpoint));
	   auditReportFile.delete();
	   
	}
	
}
