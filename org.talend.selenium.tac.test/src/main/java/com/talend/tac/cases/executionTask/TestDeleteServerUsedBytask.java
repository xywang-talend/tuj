
package com.talend.tac.cases.executionTask;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestDeleteServerUsedBytask extends Login{
	@Test
	@Parameters({ "serverForUseAvailable"})//add parameter of "server used by task to the configure file"
	public void deleteServerUnused(String Servername) {
		selenium.setSpeed(MID_SPEED);
		if (selenium.isVisible("!!!menu.executionServers.element!!!")) {
			selenium.click("!!!menu.executionServers.element!!!");
			waitForElementPresent("idSubModuleAddButton", 30000);

		} else {
			selenium.click("!!!menu.jobConductor.element!!!");
			selenium.setSpeed(MID_SPEED);
			selenium.click("!!!menu.executionServers.element!!!");
			waitForElementPresent("idSubModuleAddButton", 30000);
		}
		
		selenium.refresh();//in order to light on the delete button
		selenium.chooseOkOnNextConfirmation();
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+Servername+"')]");
		selenium.click("idSubModuleDeleteButton");
		selenium.getConfirmation();
		this.waitForElementPresent("//div[@class='ext-mb-icon  ext-mb-warning']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[@class='ext-mb-icon  ext-mb-warning']"), "delete server used by task failed!");
		Assert.assertTrue(selenium.isTextPresent(other.getString("warningmessage.delete.server.usedbytask")), "delete server used by task failed,warning message not appear!");
		selenium.click("//button[text()='OK']");
		Assert.assertTrue(
				selenium.isElementPresent("//div[text()='" + Servername
						+ "']"), "delete server used by task failed !");
	}
}
