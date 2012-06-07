package com.talend.tac.cases.executionTask;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;
import com.thoughtworks.selenium.Selenium;

public class TestDeleteProjectUsedBytask extends Login {

	public void okDelete(Selenium selenium, String name,String warningmessage)
			throws InterruptedException {
		// s.click("!!!menu.project.element!!!");
		selenium.setSpeed(MID_SPEED);
		
		selenium.refresh();
		Thread.sleep(5000);
		if (selenium
				.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
						+ name + "')]")) {
			selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
					+ name + "')]");
			selenium.chooseOkOnNextConfirmation();
			selenium.click("idSubModuleDeleteButton");
			selenium.getConfirmation();
//			Thread.sleep(5000);
			Assert.assertTrue(selenium.isTextPresent(warningmessage), "project used by task delete failed!");
			Assert.assertTrue(
					selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
							+ name + "')]"), "delete project " + name
							+ " failed!");
		}
		selenium.setSpeed(MIN_SPEED);
	}

	@Test
	@Parameters({ "addCommonProjectName" })
	public void testDeleteProjectUsedbytask(String deleteProname) throws Exception {
		//
		selenium.setSpeed(MAX_SPEED);
		this.waitForElementPresent("!!!menu.project.element!!!", Base.WAIT_TIME);
		selenium.click("!!!menu.project.element!!!");
		//this.waitForElementPresent("!!!menu.project.element!!!", 30);
		//try to delete project used by task.
		String warning = other.getString("warningmessage.delete.project.usedbytask");
		okDelete(selenium,deleteProname,warning);
	
	}

	@AfterMethod
	public void tearDown() throws Exception {
		// selenium.stop();
	}

}
