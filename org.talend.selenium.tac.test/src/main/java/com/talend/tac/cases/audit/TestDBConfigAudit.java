package com.talend.tac.cases.audit;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class TestDBConfigAudit extends Audit {
	@Test
	@Parameters({"mysqlURL","mysqlUserName","mysqlPassWord","mysqlDriver"})
	public void testChangeAuditDBWithRightConfig(String url,String userName,String userPassWd,String driver){
		this.openAudit();
		this.configAuditDB(url, userName, driver, userPassWd);
		this.clickWaitForElementPresent("idDbConfigSaveButton");
		/*this.waitForTextPresent("Parameters saved", WAIT_TIME);
		this.clickWaitForElementPresent("idDbConfigCheckButton");*/
		this.waitForCheckConnectionStatus("//div[text()='OK']", 3);
	}
	
	
}
