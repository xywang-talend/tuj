package com.talend.tac.cases.jobconductor;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestChangeServerPort extends Server {
    
	//change port of jobserver and check  the process without error	appear
	@Test
	@Parameters({"ServerUnused"})
	public void testChangeServerPort(String servername) {
		
		this.openServerMenu();
		
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label'" +
				" and text()='"+servername+"']", WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and text()" +
				"='"+servername+"']");
		
		// port1
		this.typeString(other.getString("inputname.id.server.add.commandPort"),
				"2255");
		// port2
		this.typeString(
				other.getString("inputname.id.server.add.fileTransfertPort"),
				"2251");
		// port3
		this.typeString(
				other.getString("inputname.id.server.add.monitoringPort"),
				"2252");
		
		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		this.waitForElementPresent("//span[contains(text(),'Command port:')]//parent::li//img[@title='This port is " +
				"misconfigured or an other application uses it on server!']",
				WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[contains(text(),'Command port:')]//parent::li//img[@title='This port is " +
				"misconfigured or an other application uses it on server!']"));
		Assert.assertTrue(selenium.isElementPresent("//span[contains(text(),'File transfert port:')]//parent::li//img[@title=" +
				"'This port is misconfigured or an other application uses it on server!']"));
		Assert.assertTrue(selenium.isElementPresent("//span[contains(text(),'Monitoring port:')]//parent::li//img[@title='This port is " +
		"misconfigured or an other application uses it on server!']"));
		Assert.assertTrue(selenium.isElementPresent("//span[contains(text(),'Command port:')]" +
				"//parent::li//div[contains(text(),'2255')]"));
		Assert.assertTrue(selenium.isElementPresent("//span[contains(text(),'File transfert port:')]" +
				"//parent::li//div[contains(text(),'2251')]"));
		Assert.assertTrue(selenium.isElementPresent("//span[contains(text(),'Monitoring port:')]" +
		"//parent::li//div[contains(text(),'2252')]"));
		
		
	}
	
}
