package com.talend.tac.cases.executePlan;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ModifyPlan extends Plan {

	// modify a plan
	@Test
	@Parameters({ "plan.label","plan.modifyLabel", "plan.modifyDescription" })
	public void testModifyPlanLabelDes(String label,String newlabel, String newdescription)
			throws InterruptedException {

		this.openExecutionPlanMenu();
		this.waitForElementPresent("//span[text()='" + label + "']", WAIT_TIME);
		Thread.sleep(2000);
		selenium.mouseDown("//span[text()='" + label + "']");// select a exist
																// plan
		
		// get root task of plan
		this.sleep(2000);
		this.typeString("idExecutionPlanPlanFormLabelInput", newlabel);// label

		this.typeString("idExecutionPlanPlanFormDescInput", newdescription);// description

		selenium.click("//button[@class='x-btn-text ' and @id='idFormSaveButton']");
		this.waitForElementPresent("//span[text()='" + newlabel + "']",
				WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"
				+ newlabel + "']"));
		selenium.setSpeed(MIN_SPEED);

	}

	@Test
	@Parameters({ "plan.modifyLabel", "plan.modifyTask" })
	public void testModifyPlanTask(String newlabel,
			String task) throws InterruptedException {

		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Execution Plan']",
				WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
		// selenium.setSpeed(MID_SPEED);
//		this.clickWaitForElementPresent("idSubModuleRefreshButton");
		this.waitForElementPresent("//span[text()='" + newlabel + "']", WAIT_TIME);
		Thread.sleep(2000);
		selenium.mouseDown("//span[text()='" + newlabel + "']");// select a exist
																// plan
		this.sleep(2000);
		selenium.setSpeed(MID_SPEED);
		String roottask1 = selenium
				.getValue("String idExecutionPlanPlanFormTaskComboBox");
		this.selectDropDownList("String idExecutionPlanPlanFormTaskComboBox",
				task);
		selenium.mouseDown("//button[@class='x-btn-text ' and @id='idFormSaveButton']");
		selenium.click("//button[@class='x-btn-text ' and @id='idFormSaveButton']");
		selenium.mouseUp("//button[@class='x-btn-text ' and @id='idFormSaveButton']");
		this.sleep(5000);
		selenium.refresh();
		this.waitForElementPresent("//span[text()='" + newlabel + "']",	
				WAIT_TIME);
		selenium.mouseDown("//span[text()='" + newlabel + "']");
		this.sleep(2000);
		Assert.assertTrue(!roottask1.equals(selenium.getValue("String idExecutionPlanPlanFormTaskComboBox")));
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"
				+ newlabel + "']"));
		selenium.setSpeed(MIN_SPEED);

	}

}
