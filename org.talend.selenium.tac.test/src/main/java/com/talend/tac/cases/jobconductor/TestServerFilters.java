package com.talend.tac.cases.jobconductor;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestServerFilters extends Server {
    
	//upload license and check upload result
	public void uploadLicense(String license) {
		
	   this.waitForElementPresent("//b[text()='admin, admin']", WAIT_TIME);
	   			
	   this.clickWaitForElementPresent("idMenuLicenseElement");
	   waitForElementPresent("//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]", WAIT_TIME);
	   selenium.type("//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]", parseRelativePath(license));
	   selenium.click("//button[text()='Upload']");
			
       System.out.println("license upload is successful");	
       
       try {
		Thread.sleep(3000);
	   } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	   }
       selenium.refresh();        
       
	}	
	
	//check had four servers in server page, contains two jobservers and two esbServers
    public void checkServerInServerPage(String jobServer1, String jobServer2, String esbServer1,
			String esbServer2) {
    	
    	this.openServerMenu();	
		
		this.waitForElementPresent("//div[text()='"+jobServer1+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
		" x-grid3-col-talendRuntime') and text()='Job Server']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+jobServer1+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
		" x-grid3-col-talendRuntime') and text()='Job Server']"));
		Assert.assertFalse(selenium.isElementPresent("//div[text()='"+jobServer1+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
		" x-grid3-col-talendRuntime') and text()='Talend Runtime']"));
		Assert.assertFalse(selenium.isElementPresent("//div[text()='"+jobServer1+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//button[text()='Admin server']"));
	
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+jobServer2+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
		" x-grid3-col-talendRuntime') and text()='Job Server']"));
		Assert.assertFalse(selenium.isElementPresent("//div[text()='"+jobServer2+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
		" x-grid3-col-talendRuntime') and text()='Talend Runtime']"));
		Assert.assertFalse(selenium.isElementPresent("//div[text()='"+jobServer2+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//button[text()='Admin server']"));
		
		Assert.assertFalse(selenium.isElementPresent("//div[text()='"+esbServer1+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
		" x-grid3-col-talendRuntime') and text()='Job Server']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+esbServer1+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
				" x-grid3-col-talendRuntime') and text()='Talend Runtime']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+esbServer1+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//button[text()='Admin server']"));
		
		Assert.assertFalse(selenium.isElementPresent("//div[text()='"+esbServer2+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
		" x-grid3-col-talendRuntime') and text()='Job Server']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+esbServer2+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
				" x-grid3-col-talendRuntime') and text()='Talend Runtime']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+esbServer2+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//button[text()='Admin server']"));
    	
    }
	
	//server filters in jobconductor, check just appear jobServer, check runtime server are not displayed
	@Test
	@Parameters({"ServerForUseAvailable", "ServerForUseUnavailable", "ServerLablename",
		"RuntimeServerChangeDefaultPortLablename"})
	public void testServerFiltersInJobconductor(String jobServer1, String jobServer2, String esbServer1,
			String esbServer2) {
		
		//check had four servers in server page, contains two jobservers and two esbServers
		this.checkServerInServerPage(jobServer1, jobServer2, esbServer1, esbServer2);
		
		//go to 'Job Conductor' page
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		//click add button, check just appear two jobServers in server drop-down list
		selenium.click("//div[contains(text(),'Conductor')]//ancestor::div[@class='x-panel-body x-panel-body-noheader " +
		"x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleAddButton']");
		
		this.clickWaitForElementPresent("//input[@id='idJobConductorExecutionServerListBox']" +
				"/following-sibling::img");
		
		this.waitForElementPresent("//div[text()='"+jobServer1+"' and @role='listitem']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+jobServer1+"' and @role='listitem']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+jobServer2+"' and @role='listitem']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+esbServer1+"' and @role='listitem']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+esbServer2+"' and @role='listitem']"));
		
	}
	
	//server filters in esbconductor, check just appear esbServer, jobserver are not displayed
	@Test
	@Parameters({"ServerForUseAvailable", "ServerForUseUnavailable", "ServerLablename",
		"RuntimeServerChangeDefaultPortLablename", "LicenseESB"})
	public void testServerFiltersInEsbconductor(String jobServer1, String jobServer2, String esbServer1,
			String esbServer2, String esbLicense) {
		
		//change license to esb
		uploadLicense(esbLicense);
		this.waitForElementPresent("//span[text()='ESB Infrastructure']", WAIT_TIME);
		//check had four servers in server page, contains two jobservers and two esbServers
		this.checkServerInServerPage(jobServer1, jobServer2, esbServer1, esbServer2);
		
		//go to 'Job Conductor' page
		this.clickWaitForElementPresent("!!!menu.esbconductor.element!!!");
		//click add button, check just appear two esbServers in server drop-down list
		selenium.click("//div[text()='ESB Conductor' and @class='header-title']//ancestor::div" +
				"[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']" +
				"//button[text()='Add'] ");
		                                              
		this.clickWaitForElementPresent("//input[@name='executionServerId']/following-sibling::div");
		
		this.waitForElementPresent("//div[text()='"+esbServer1+"' and @role='listitem']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+esbServer1+"' and @role='listitem']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+esbServer2+"' and @role='listitem']"));
		Assert.assertFalse(selenium.isElementPresent("//div[text()='"+jobServer1+"' and @role='listitem']"));
		Assert.assertFalse(selenium.isElementPresent("//div[text()='"+jobServer2+"' and @role='listitem']"));
		
	}
	
	//creation the case for change license to MDM
	@Test
	@Parameters({"LicenseMDM"})
	public void resetLicenseToMDM(String license) {
		
		uploadLicense(license);
		this.waitForElementPresent("idLeftMenuTreeLogoutButton", WAIT_TIME);
		
	}
	
}
