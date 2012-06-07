package com.talend.tac.cases.audit;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestChangeAuditDatabaseWithWrongParameters extends Audit {
    
	//creation method for test audit db'wrong info
	public void changeAuditDatabaseInfo(String url, String userName, String userPassWd,
			String driver, String wrongInfoXpath, String expectedWrongInfo, int okStatusCounts) {
		
        this.openAudit();
		
		/*change db info*/
		this.configAuditDB(url, userName, driver, userPassWd);
		
		/*check result info*/
		selenium.click("idDbConfigCheckButton");
		this.waitForCheckConnectionStatus("//div[text()='OK']", okStatusCounts);	
		this.waitForElementPresent("//div[contains(@class,'x-form-item x-component') and contains(text()," +
				"'"+wrongInfoXpath+"')]", WAIT_TIME*2);
		String wrongInfo = selenium.getText("//div[contains(@class,'x-form-item x-component') and contains(text()," +
				"'"+wrongInfoXpath+"')]");
		if("Cannot connect to database".equals(wrongInfoXpath)) {
			
			String[] newWrongUserNamePwInfo = wrongInfo.split("@");			
			wrongInfo = newWrongUserNamePwInfo[0];	
			
		}
		System.out.println(">>>>"+	wrongInfo);
		Assert.assertEquals(wrongInfo, expectedWrongInfo);
		selenium.click("//div[contains(@class,'x-nodrag x-tool-close x-tool x-component')]");
		
	}
	
	//change audit db info with wrong url and check wrong info
	@Test
	@Parameters({"wrongUrl", "mysqlUserName", "mysqlPassWord", "mysqlDriver"})
	public void testChangeAuditDatabaseWithWrongUrl(String url, String userName, String userPassWd, String driver) {
		
		String urlInfo = "Cannot connect to database (cause Communications link failure Last packet sent to the server was 0 ms ago.)";
		                  
		this.changeAuditDatabaseInfo(url, userName, userPassWd, driver,
				"Cannot connect to database", urlInfo, 2);
		
	}
	
	//change audit db info with wrong username and pw and check wrong info
	@Test
	@Parameters({"mysqlURL", "wrongUserName", "wrongPassWord", "mysqlDriver"})
	public void testChangeAuditDatabaseWithWrongUserNamePW(String url, String userName, String userPassWd, String driver) {
		
		String wrongUserNamePwInfo = "Cannot connect to database (cause Access denied for user 'wrongUserName'";
                             
		this.changeAuditDatabaseInfo(url, userName, userPassWd, driver,
				"Cannot connect to database", wrongUserNamePwInfo, 2);
		
	}
    
	//change audit db info with wrong driver and check wrong info
	@Test
	@Parameters({"mysqlURL", "mysqlUserName", "mysqlPassWord", "h2Driver"})
	public void testChangeAuditDatabaseWithWrongDriver(String url, String userName, String userPassWd, String driver) {
		
		String wrongDriverInfo = "Driver cannot understand url '"+url+"'";
		
		this.changeAuditDatabaseInfo(url, userName, userPassWd, driver,
				"Driver cannot understand url", wrongDriverInfo, 1);		
		
	}

}
