package com.talend.tac.cases.esbconductor;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDeployESBConductor extends ESBConductorUtils {
    
	@Test
	@Parameters({"labelOfService", "name"})
	public void testDeployESBConductor(String label, String name) {
		
		this.intoESBConductorPage();
		
		this.waitForElementPresent("//div[text()='"+label+"']", WAIT_TIME);
		selenium.mouseDown("//div[text()='"+label+"']");
		
		selenium.click("idESBConductorTaskGridDeployButton");
		
		this.waitForTextPresent("Feature '"+name+"' deployed.", WAIT_TIME);
		selenium.setSpeed(MID_SPEED);
		selenium.click("idESBConductorTaskGridRefreshButton");
		selenium.setSpeed(MIN_SPEED);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+label+"']" +
				"//ancestor::table[@class='x-grid3-row-table']//span[text()='Deployed and started']"));
		
	}
	

	@Test
	@Parameters({"labelOfService", "name"})
	public void testUndeployESBConductor(String label, String name) {
		
		this.intoESBConductorPage();
		
		this.waitForElementPresent("//div[text()='"+label+"']", WAIT_TIME);
		selenium.mouseDown("//div[text()='"+label+"']");
		
		this.sleep(3000);
		selenium.chooseOkOnNextConfirmation();
		selenium.click("idESBConductorTaskGridUndeployButton");
		Assert.assertTrue(selenium.getConfirmation().matches("^Are you sure you want to undeploy the feature '"+name+"' [\\s\\S]$"));
		
		this.waitForTextPresent("Feature '"+name+"' undeployed.", WAIT_TIME);
		selenium.setSpeed(MID_SPEED);
		selenium.click("idESBConductorTaskGridRefreshButton");
		selenium.setSpeed(MIN_SPEED);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+label+"']" +
				"//ancestor::table[@class='x-grid3-row-table']//span[text()='Undeployed']"));
		
	}
	
}
