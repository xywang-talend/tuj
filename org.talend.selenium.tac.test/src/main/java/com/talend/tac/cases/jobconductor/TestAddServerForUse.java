package com.talend.tac.cases.jobconductor;

import junit.framework.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAddServerForUse extends Server {
	@Test
	@Parameters({ "serverForUseAvailable", "serverForUseUnavailable","serverForUseDownlabel",
			"serverAvailableHost" })
	public void testAddServerForUseAvailable(String lableavailable, String labelunactive,String downlabel,
			String availablehost) throws InterruptedException {
		this.openServerMenu();
		this.deleteAllServersNotUsed();
		this.addServer(lableavailable,"", availablehost,true);
		this.checkServerStatus(lableavailable, server_status_up);
		this.addServer(labelunactive,"",availablehost,false);
		this.checkServerStatus(labelunactive, server_status_inactive);
		
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+lableavailable+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
				" x-grid3-col-talendRuntime') and text()='Job Server']"));
		Assert.assertFalse(selenium.isElementPresent("//div[text()='"+lableavailable+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
		" x-grid3-col-talendRuntime') and text()='Talend Runtime']"));
        Assert.assertFalse(selenium.isElementPresent("//div[text()='"+lableavailable+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//button[text()='Admin server']"));
        
	}

	@Test
	@Parameters({ "serverForUseAvailable", "serverForUseUnavailable","serverForUseDownlabel",
			"serverAvailableHost" })
	public void testAddServerForUseInactive(String lableavailable, String labelunactive,String downlabel,
			String availablehost) throws InterruptedException {
		this.openServerMenu();
		this.addServer(labelunactive,"",availablehost,Server.server_active_false);
		this.checkServerStatus(labelunactive, server_status_inactive);
		

		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+lableavailable+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
				" x-grid3-col-talendRuntime') and text()='Job Server']"));
		Assert.assertFalse(selenium.isElementPresent("//div[text()='"+lableavailable+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
		" x-grid3-col-talendRuntime') and text()='Talend Runtime']"));
        Assert.assertFalse(selenium.isElementPresent("//div[text()='"+lableavailable+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//button[text()='Admin server']"));
        
	}

}
