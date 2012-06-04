package com.talend.tac.cases.jobconductor;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestServerDisplyInVirtualServersPage extends Server {
   
	//check server type 'talend runtime' display in virture server page
	@Test
	@Parameters({"serverForUseAvailable", "serverForUseUnavailable", "serverLablename",
		"runtimeServerChangeDefaultPortLablename", "serverLablenameOfUncheckActive"})
	public void testServerDisplyInVirtualServersPage(String jobServer1, String jobServer2, String esbServer1,
			String esbServer2, String esbServer3) {
		
		//into server page
		this.openServerMenu();
		
		//check server whether exist
		this.waitForElementPresent("//div[text()='"+jobServer1+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
				" x-grid3-col-talendRuntime') and text()='Job Server']", WAIT_TIME);
		
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+jobServer1+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
		" x-grid3-col-talendRuntime') and text()='Job Server']"));
		
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+jobServer2+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
		" x-grid3-col-talendRuntime') and text()='Job Server']"));
		
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+esbServer1+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
				" x-grid3-col-talendRuntime') and text()='Talend Runtime']"));		
		
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+esbServer2+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
				" x-grid3-col-talendRuntime') and text()='Talend Runtime']"));
		
		
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+esbServer3+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
				" x-grid3-col-talendRuntime') and text()='Talend Runtime']"));
		
		//go to 'virtualServers' page
		this.clickWaitForElementPresent("!!!menu.virtual_server.element!!!");
		
		//server 'jobserver' is visiable.
		this.waitForElementPresent("//span[text()='"+jobServer1+"' and @class='x-tree3-node-text']", WAIT_TIME);
		
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+jobServer1+"' and @class='x-tree3-node-text']"));
		
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+jobServer2+"' and @class='x-tree3-node-text']"));
		
		//server 'serverESB' is not visiable.
		Assert.assertFalse(selenium.isElementPresent("//span[text()='"+esbServer1+"' and @class='x-tree3-node-text']"));		
		
		Assert.assertFalse(selenium.isElementPresent("//span[text()='"+esbServer2+"' and @class='x-tree3-node-text']"));		
		
		Assert.assertFalse(selenium.isElementPresent("//span[text()='"+esbServer3+"' and @class='x-tree3-node-text']"));
		
		
	}
		
}
