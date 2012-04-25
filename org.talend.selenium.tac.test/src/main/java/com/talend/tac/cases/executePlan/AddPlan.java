package com.talend.tac.cases.executePlan;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddPlan extends Plan {
	
	@Test
	
	@Parameters({ "plan.label", "plan.description", "plan.task" })
	public void testAddPlanAndCheckPlanInformation(String label, String description, String task) {
		label = "testPlanInformation";
		this.addPlan(label, task, description);	
		// addPlan(label, description, task);
		selenium.refresh();
		this.waitForElementPresent("//span[text()='" + label + "']", WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//span[text()='" + label + "']");
		this.sleep(3000);
		this.waitForElementPresent("//div[text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[contains(@class,'x-tab-strip-text') and text()='Information']", WAIT_TIME);
		selenium.click("//div[text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[contains(@class,'x-tab-strip-text') and text()='Information']");
        this.sleep(3000);
        Assert.assertTrue(selenium.getText("//span[@class='x-fieldset-header-text' and text()='Execution plan']//ancestor::fieldset[@class=' x-fieldset x-component']//label[text()='Label:']//ancestor::div[@class='x-form-item ']//div[@class=' x-form-label x-component']").equals(label), "testAddPlanAndCheckPlanInformation -> plan label failed!");
        Assert.assertTrue(selenium.getText("//span[@class='x-fieldset-header-text' and text()='Execution plan']//ancestor::fieldset[@class=' x-fieldset x-component']//label[text()='Description:']//ancestor::div[@class='x-form-item ']//div[@class=' x-form-label x-component']").equals(description), "testAddPlanAndCheckPlanInformation -> plan label failed!");
	    this.deletePlan(label);
	}
	

	
	@Test
	
	@Parameters({ "plan.label", "plan.description", "plan.task" })
	public void testAddPlan(String label, String description, String task) {
		this.addPlan(label, task, description);	
		// addPlan(label, description, task);

	}
	
	@Test
	
	@Parameters({ "plan.label", "plan.description", "plan.task" })
	public void testAddPlanLabelWithSpecialChar(String label, String description, String task) {
		label = "sdaf;test";
		this.openExecutionPlanMenu();
		this.clickWaitForElementPresent("//button[text()='Add plan']");
		this.typeString("idExecutionPlanPlanFormLabelInput", label);
		this.waitForElementPresent("//img[@class='gwt-Image x-component ' and @role='alert']", WAIT_TIME);
		this.typeString("idExecutionPlanPlanFormDescInput", description);
		selenium.click("//span[@class='x-fieldset-header-text' and text()='Execution Plan']/ancestor::div[@class=' x-panel x-component']//button[@id='idFormSaveButton']");	
		this.waitForTextPresent("Fix errors in form before save", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);

	}
	

}
