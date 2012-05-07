package com.talend.tac.cases.audit;


import java.awt.Event;
import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestAudit extends Audit {
	
	@Test
	@Parameters({"mysqlURL", "mysqlUserName", "mysqlPassWord", "mysqlDriver", "auditStoredDefaultReportsPath"})
	public void changeDbToMysqlAndReportPath(String url, String userName, String userPassWd,
			String driver, String defaultPath) {
		
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
	    this.typeWordsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.editButton"),other.getString("audit.conf.reportsStoredPath.input"), this.getAbsolutePath(defaultPath));
	    this.AssertEqualsInConfigurationMenu(other.getString("audit.conf.reportsStoredPath.value"), this.getAbsolutePath(defaultPath)	
	    		,other.getString("audit.conf.reportsStoredPath.statusIcon"));
	    
	}
	
	@Test
	@Parameters({"AddcommonProjectname", "trunjobWithCheckpoint", "tjavaWithMulripleCheckpoint", 
		"jobNameTJava"})
	public void testAuditTrunk(String projectName, String tRunJobCheckPoint, String tjavaCheckpoint,
			String tjava){
		
		//get get incipient report path
		String defaultPath = this.getDefaultReportPath();
		
		auditProcess(projectName, "trunk");
		int linksbefore = checkAuditListLink(projectName);
		Assert.assertTrue(checkAuditInfo(projectName),"TestAudit audit trunk failed!");
		this.sleep(5000);
		Assert.assertTrue((checkAuditListLink(projectName)==linksbefore +1),"TestAudit audit trunk failed,not create links!");
		
        File auditReportFile = this.checkReportPdf(defaultPath, projectName, tjava);
        Assert.assertTrue(this.isExistedInfoInPdf(defaultPath+"/"+this.getReportFileName(), tRunJobCheckPoint));
	    Assert.assertTrue(this.isExistedInfoInPdf(defaultPath+"/"+this.getReportFileName(), tjavaCheckpoint));
	    auditReportFile.delete();
		
	}
	
	@Test
	@Parameters({"AddcommonProjectname"})
	public void testAuditTrunkStop(String projectName){
		auditProcess(projectName, "trunk");
		Assert.assertTrue(this.waitForTextPresent("Running...", WAIT_TIME));
		this.sleep(2000);
		selenium.click("//button[text()='Stop']");
		Assert.assertTrue(this.waitForTextPresent("Stopping...", WAIT_TIME));
		Assert.assertFalse(this.waitForTextPresent("Saving reports... !", WAIT_TIME),"TestAudit stop audit trunk failed!");
	}
	
	
	@Test
	@Parameters({"AddcommonProjectname","trunjobWithCheckpoint", "tjavaWithMulripleCheckpoint", 
		"jobNameTJava"})
	public void testAuditTrunkStopRelaunchAudit(String projectName, String tRunJobCheckPoint, String tjavaCheckpoint,
			String tjava){
		auditProcess(projectName, "trunk");
		Assert.assertTrue(this.waitForTextPresent("Running...", WAIT_TIME));
		this.sleep(2000);
		selenium.click("//button[text()='Stop']");
		Assert.assertTrue(this.waitForTextPresent("Stopping...", WAIT_TIME));
		Assert.assertFalse(this.waitForTextPresent("Saving reports... !", WAIT_TIME),"TestAudit stop audit trunk failed!");
		Assert.assertTrue(this.waitForTextPresent("The Audit process has terminated successfully", 300));
		this.sleep(3000);
		Assert.assertTrue(selenium.isVisible("//button[text()='Start audit']"));
		
        String defaultPath = this.getDefaultReportPath();
		
        selenium.click("//button[text()='Start audit']");
		int linksbefore = checkAuditListLink(projectName);
		Assert.assertTrue(checkAuditInfo(projectName),"TestAudit audit trunk failed!");
		this.sleep(5000);
		Assert.assertTrue((checkAuditListLink(projectName)==linksbefore +1),"TestAudit audit trunk failed,not create links!");
		
        File auditReportFile = this.checkReportPdf(defaultPath, projectName, tjava);
        Assert.assertTrue(this.isExistedInfoInPdf(defaultPath+"/"+this.getReportFileName(), tRunJobCheckPoint));
	    Assert.assertTrue(this.isExistedInfoInPdf(defaultPath+"/"+this.getReportFileName(), tjavaCheckpoint));
	    auditReportFile.delete();
	}
	
	@Test
	@Parameters({"AddcommonProjectname", "trunjobWithCheckpoint", "tjavaWithMulripleCheckpoint", 
		"jobNameTJava", "jobNameBranchJob"})
	public void testAuditBranch(String projectName, String tRunJobCheckPoint, String tjavaCheckpoint,
			String tjava, String branchJob){
		
		//get get incipient report path
		String defaultPath = this.getDefaultReportPath();
		
		auditProcess(projectName, "branch");
		int linksbefore = checkAuditListLink(projectName);
		Assert.assertTrue(checkAuditInfo(projectName),"TestAudit audit branch failed!");
		this.sleep(5000);
		Assert.assertTrue((checkAuditListLink(projectName)==linksbefore +1),"TestAudit audit branch failed,not create links!");

        File auditReportFile = this.checkReportPdf(defaultPath, projectName, tjava);
//        Assert.assertTrue(this.isExistedInfoInPdf(defaultPath+"/"+this.getReportFileName(), tRunJobCheckPoint));
	    Assert.assertTrue(this.isExistedInfoInPdf(defaultPath+"/"+this.getReportFileName(), tjavaCheckpoint));
	    Assert.assertTrue(this.isExistedInfoInPdf(defaultPath+"/"+this.getReportFileName(), branchJob));;
	    auditReportFile.delete();
	    
	}
	
	@Test
	@Parameters({"AddcommonProjectname","remotehostAddress","remotehostAddressWithWrong"})
	public void testAuditWithOutStartCommondline(String projectName,String normalCommondline,String wrongCommondline){
		System.err.println(wrongCommondline);	
		this.changeCommandLineConfig(wrongCommondline, other.getString("commandLine.conf.primary.wrong.host.statusIcon"));
		selenium.refresh();
		this.sleep(5000);
		auditProcess(projectName, "branch");
		Assert.assertTrue(this.waitForTextPresent("Cannot connect to CommandLine, please check your configuration", MAX_WAIT_TIME));
		this.sleep(5000);
		this.changeCommandLineConfig(normalCommondline, other.getString("commandLine.conf.primary.host.statusIcon"));
		selenium.refresh();
		this.sleep(5000);
	}
}
