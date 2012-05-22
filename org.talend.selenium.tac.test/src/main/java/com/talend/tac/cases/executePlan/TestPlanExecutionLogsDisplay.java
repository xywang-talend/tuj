package com.talend.tac.cases.executePlan;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPlanExecutionLogsDisplay extends Plan {
	@Test
	 @Parameters({ "planexecutionlogsdisplay.plan.label",
	 "planexecutionlogsdisplay.plan.roottask"})
	public void testCheckPlanLogsPerpage(String planLabel,String taskLabel) {
		// this.addPlan(planLabel, rootTask, "treeManagePlan");
		this.addPlan(planLabel, taskLabel, "testPlanlogsdisplay");
		this.runPlanAndCheck(planLabel, taskLabel, 11);
		this.clickWaitForElementPresent("//span[@class='x-tab-strip-text  ' and text()='History']");
		this.clickWaitForElementPresent("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class=' x-panel-noborder x-panel x-component']//span[text()='Task execution monitoring']//ancestor::div[@class=' x-panel-noborder x-panel x-component']//table[@class='x-toolbar-ct']//td[11]//button");
		this.clickWaitForElementPresent("//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//table[contains(@class,'x-btn x-component x-btn-icon')]");
		this.sleep(5000);
		int defaultCounts = Integer.parseInt(selenium.getValue("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class=' x-panel-noborder x-panel x-component']//div[@title='Enter the number of items per page']//input"));
//		selenium.click("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class=' x-panel-noborder x-panel x-component']//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//table[contains(@title,'Go to current time')]");
		this.typeAndPressEnter("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class=' x-panel-noborder x-panel x-component']//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//input[contains(@class,'gwt-TextBox x-component')]", "1");
		this.sleep(5000);
		System.out.println("defaultCounts: " +defaultCounts);
		System.out.println("logs get is: "+selenium.getXpathCount("//img[@class='gwt-Image' and @title='Ok']").intValue());
		Assert.assertTrue((selenium.getXpathCount("//img[@class='gwt-Image' and @title='Ok']").intValue()+selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-basicStatus' and text()='ERROR']").intValue())==defaultCounts, "test plan execution logs per page failed!");
		System.err.println(selenium.getValue("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class=' x-panel-noborder x-panel x-component']//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//input[contains(@class,'gwt-TextBox x-component')]"));
		Assert.assertTrue(selenium.getValue("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class=' x-panel-noborder x-panel x-component']//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//input[contains(@class,'gwt-TextBox x-component')]").equals("1"));
	    
	}
	
	@Test
	 @Parameters({ "planexecutionlogsdisplay.plan.label",
	 "planexecutionlogsdisplay.plan.roottask"})
	public void testCheckPlanLogsPerpageChange(String planLabel,String taskLabel) {
		// this.addPlan(planLabel, rootTask, "treeManagePlan");
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Execution Plan']",
				WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
		this.waitForElementPresent("//span[text()='" + planLabel + "']",
				WAIT_TIME);
		selenium.mouseDown("//span[text()='" + planLabel + "']");
		this.clickWaitForElementPresent("//span[@class='x-tab-strip-text  ' and text()='History']");
		this.clickWaitForElementPresent("//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//table[contains(@class,'x-btn x-component x-btn-icon')]");
		
		this.sleep(3000);
		int newNum = 5;
//		typeAndPressEnter("//div[@class='my-paging-text x-component ' and text()='Page']//ancestor::td[@class='x-toolbar-cell']/following-sibling::td//input[@class='gwt-TextBox x-component ']", "1");
		typeAndPressEnter("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class=' x-panel-noborder x-panel x-component']//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//div[@title='Enter the number of items per page']//input", ""+newNum);
		this.sleep(3000);
		this.typeAndPressEnter("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class=' x-panel-noborder x-panel x-component']//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//input[contains(@class,'gwt-TextBox x-component')]", "1");
		this.sleep(5000);
		System.out.println("after modified,logs get is: "+(selenium.getXpathCount("//img[@class='gwt-Image' and @title='Ok']").intValue()+selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-basicStatus' and text()='ERROR']").intValue()));
		Assert.assertTrue((selenium.getXpathCount("//img[@class='gwt-Image' and @title='Ok']").intValue()+selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-basicStatus' and text()='ERROR']").intValue())==newNum, "test plan execution logs per page failed!");
	}
	
	public void typeAndPressEnter(String xpath,String value){
		selenium.type(xpath, value);
		selenium.keyDown(xpath,"\\13");
	}
	
}
