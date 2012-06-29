package com.talend.tac.cases.executePlan;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAddTwoPlansCheckInformations extends Plan {
	
	@Test
	@Parameters({ "plan.label", "plan.description", "plan.task" })
	public void testCheckInformationsBetweenPlans(String label, String description, String task) {
		label = "testPlanInformation1";
		String label2 = "testPlanInformation2";
		String des2 = "";
		this.addPlan(label, task, description);	
		// addPlan(label, description, task);
		selenium.click("//div[text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[contains(@class,'x-tab-strip-text') and text()='Information']");
        this.sleep(3000);
        System.out.println(selenium.getText("//span[@class='x-fieldset-header-text' and text()='Execution plan']//ancestor::fieldset[@class=' x-fieldset x-component']//label[text()='Label:']//ancestor::div[@class='x-form-item ']//div[@class=' x-form-label x-component']"));
        System.out.println(selenium.getText("//span[@class='x-fieldset-header-text' and text()='Execution plan']//ancestor::fieldset[@class=' x-fieldset x-component']//label[text()='Description:']//ancestor::div[@class='x-form-item ']//div[@class=' x-form-label x-component']"));
        Assert.assertTrue(selenium.getText("//span[@class='x-fieldset-header-text' and text()='Execution plan']//ancestor::fieldset[@class=' x-fieldset x-component']//label[text()='Label:']//ancestor::div[@class='x-form-item ']//div[@class=' x-form-label x-component']").equals(label), "testAddPlanAndCheckPlanInformation -> plan label failed!");
        Assert.assertTrue(selenium.getText("//span[@class='x-fieldset-header-text' and text()='Execution plan']//ancestor::fieldset[@class=' x-fieldset x-component']//label[text()='Description:']//ancestor::div[@class='x-form-item ']//div[@class=' x-form-label x-component']").equals(description), "testAddPlanAndCheckPlanInformation -> plan label failed!");
//	    this.deletePlan(label);
//        selenium.refresh();
        this.sleep(5000);
        this.addPlan(label2, task, des2);
        selenium.setSpeed(MID_SPEED);
        selenium.click("//div[text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[contains(@class,'x-tab-strip-text') and text()='Information']");
        this.sleep(3000);
        System.out.println(selenium.getText("//span[@class='x-fieldset-header-text' and text()='Execution plan']//ancestor::fieldset[@class=' x-fieldset x-component']//label[text()='Label:']//ancestor::div[@class='x-form-item ']//div[@class=' x-form-label x-component']"));
        System.out.println(selenium.getText("//span[@class='x-fieldset-header-text' and text()='Execution plan']//ancestor::fieldset[@class=' x-fieldset x-component']//label[text()='Description:']//ancestor::div[@class='x-form-item ']//div[@class=' x-form-label x-component']"));
        Assert.assertTrue(selenium.getText("//span[@class='x-fieldset-header-text' and text()='Execution plan']//ancestor::fieldset[@class=' x-fieldset x-component']//label[text()='Label:']//ancestor::div[@class='x-form-item ']//div[@class=' x-form-label x-component']").equals(label2), "testAddPlanAndCheckPlanInformation -> plan label failed!");
        Assert.assertTrue(selenium.getText("//span[@class='x-fieldset-header-text' and text()='Execution plan']//ancestor::fieldset[@class=' x-fieldset x-component']//label[text()='Description:']//ancestor::div[@class='x-form-item ']//div[@class=' x-form-label x-component']").equals(des2), "testAddPlanAndCheckPlanInformation -> plan label failed!");
	    selenium.setSpeed(MIN_SPEED);
	}

}
