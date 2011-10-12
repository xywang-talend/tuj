package com.talend.tac.cases.audit;

import java.awt.Event;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAuditProjectWithH2DB extends Audit {
    
	@Test
	@Parameters({"db.url", "H2UserName", "H2PassWord", "H2Driver", "ProjectWithSpaceChar"})
	public void testAuditProjectWithH2DB(String url, String userName, String userPassWd, String driver,
			   String projectName) {
		
	   this.openAudit();
		   
	   /*change db info*/
	   this.configAuditDB(this.getFormatedDbURL(url), userName, driver, userPassWd);
	   selenium.setSpeed(MID_SPEED);
	   selenium.keyPressNative(Event.TAB +"");
	   selenium.keyPressNative(Event.TAB +"");
	   selenium.click("idDbConfigSaveButton");
	   selenium.setSpeed(MIN_SPEED);
	   
	   this.waitForCheckConnectionStatus("//div[text()='OK']", 3);
	   selenium.click("//div[contains(@class,'x-nodrag x-tool-close x-tool x-component')]");
	   /*change db info*/
	   
	   this.auditProcess(projectName, "trunk");
	   
	   /*check audit tesult*/
	   this.waitForElementPresent("//div//font[1][text()='The Audit process has terminated successfully']", WAIT_TIME*4);
	   this.waitForElementPresent("//div//font[3][text()='The Audit process has terminated successfully']", WAIT_TIME*4);	   
	   
	   int auditListLinkCount = this.checkAuditListLink(projectName);
	   Assert.assertEquals(auditListLinkCount, 2);
	   
		
	}
	
}
