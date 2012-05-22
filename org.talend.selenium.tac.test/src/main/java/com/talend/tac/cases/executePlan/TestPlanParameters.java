package com.talend.tac.cases.executePlan;


import java.awt.Event;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPlanParameters extends Plan {
	@Test
	 @Parameters({ "parameters.plan.label",
	 "parameters.plan.roottask"})
	public void testCheckPlanExecutionLogs(String planParameters,String taskLabel) {
		// this.addPlan(planLabel, rootTask, "treeManagePlan");
		this.addPlan(planParameters, taskLabel, "testPlanparameters");
		this.runPlan(planParameters);		
		this.waitForTextPresent("[OK]", MAX_WAIT_TIME);
//		this.waitForElementPresent("//span[@class='x-tree3-node-text' and text()='"+taskLabel+" : [OK]']", MAX_WAIT_TIME);
        String logs = (this.getPlanLogsValue(planParameters,taskLabel, null));
        Assert.assertTrue((logs.contains("name: JackZhang")), "test failed!");
        Assert.assertTrue((logs.contains("age: 23")), "test failed!");
	}
	@Test
	 @Parameters({ "parameters.plan.label",
	 "parameters.plan.roottask","parameters.plan.custom.parameterAge.value"})
	public void testCheckPlanExecutionLogsWithCustomParameterValue(String planParameters,String taskLabel,String ageCustom) {
		// this.addPlan(planLabel, rootTask, "treeManagePlan");
		this.openExecutionPlanMenu();
		this.waitForElementPresent("//span[text()='" + planParameters + "']",
				WAIT_TIME);
		selenium.mouseDown("//span[text()='" + planParameters + "']");
		this.sleep(3000);
		selenium.click("idExecutionPlanTreeViewRefreshButton");
		this.waitForElementPresent("//span/b[contains(text(),'>')]", WAIT_TIME);
		selenium.click("//span/b[contains(text(),'>')]");
		this.clickWaitForElementPresent("//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-customValue ')]//input[@name='group_age']");
		this.typeWaitForElementPresent("//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-customValue ')]//input[@name='group_age']//ancestor::div[contains(@class,'x-grid3-cell-inner x-grid3-col-customValue')]//div[contains(@class,' x-form-field-wrap  x-component')]//input", ageCustom);
		this.runPlan(planParameters);	
		this.waitForElementPresent("[RUNNING]",WAIT_TIME);
		this.waitForElementPresent("[OK]", MAX_WAIT_TIME);
		this.sleep(10000);
		selenium.refresh();
//		this.waitForElementPresent("//span[@class='x-tree3-node-text' and text()='"+taskLabel+" : [OK]']", MAX_WAIT_TIME);
       String logs = (this.getPlanLogsValue(planParameters,taskLabel, null));
       System.err.println(logs);
       Assert.assertTrue((logs.contains("name: JackZhang")), "test failed!");
       Assert.assertTrue((logs.contains("age: "+ageCustom)), "test failed!");
	}
	
	
	@Test
	 @Parameters({ "parameters.plan.label",
	 "parameters.plan.roottask","parameters.plan.parameterAge","parameters.plan.parameterAge.value"})
	public void testCheckPlanExecutionLogsWithSelectedParameter(String planParameters,String taskLabel,String parameterToSelected,String parameterSelectedValue) {
		// this.addPlan(planLabel, rootTask, "treeManagePlan");
		this.openExecutionPlanMenu();
		this.waitForElementPresent("//span[text()='" + planParameters + "']",
				WAIT_TIME);
		selenium.mouseDown("//span[text()='" + planParameters + "']");
		this.sleep(3000);
		selenium.click("idExecutionPlanTreeViewRefreshButton");
		this.waitForElementPresent("//span/b[contains(text(),'>')]", WAIT_TIME);
		selenium.click("//span/b[contains(text(),'>')]");
		this.selectDropDownListByClickArrow("//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-customValue ')]//input[@name='group_age']//ancestor::table//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-id ')]//img[contains(@class,'x-form-trigger x-form-trigger-arrow')]", parameterToSelected,"x-combo-list-item");
		this.runPlan(planParameters);	
		this.waitForElementPresent("[RUNNING]", WAIT_TIME);
		this.waitForElementPresent("[OK]", MAX_WAIT_TIME);
		this.sleep(10000);
		selenium.refresh();
//		this.waitForElementPresent("//span[@class='x-tree3-node-text' and text()='"+taskLabel+" : [OK]']", MAX_WAIT_TIME);
      String logs = (this.getPlanLogsValue(planParameters,taskLabel, null));
      System.err.println(logs);
      Assert.assertTrue((logs.contains("name: JackZhang")), "test failed!");
      Assert.assertTrue((logs.contains("age: "+parameterSelectedValue)), "test failed!");
	}
	
	@Test
	 @Parameters({ "parameters.plan.label",
	 "parameters.plan.roottask","parameters.plan.parameterAge","parameters.plan.parameterAge.value","parameters.plan.parameterName","parameters.plan.parameterName.value"})
	public void testAddParametersForPlan(String planParameters,String taskLabel,String ageName,String ageValue,String nameName,String nameValue) {
		// this.addPlan(planLabel, rootTask, "treeManagePlan");
		this.openExecutionPlanMenu();
		this.waitForElementPresent("//span[text()='" + planParameters + "']",
				WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//span[text()='" + planParameters + "']");
		this.AddParameterToPlan(ageName, ageValue);
		
		
	}
	
	
	@Test
	 @Parameters({ "parameters.plan.label",
	 "parameters.plan.roottask","parameters.plan.parameterAge","parameters.plan.parameterAge.value","parameters.plan.parameterName","parameters.plan.parameterName.value"})
	public void testDeleteParametersOfPlan(String planParameters,String taskLabel,String ageName,String ageValue,String nameName,String nameValue) {
		// this.addPlan(planLabel, rootTask, "treeManagePlan");
		this.openExecutionPlanMenu();
		this.waitForElementPresent("//span[text()='" + planParameters + "']",
				WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//span[text()='" + planParameters + "']");
		this.AddParameterToPlan(nameName, nameValue);
		this.DeleteParametersOfPlan(nameName, nameValue);
	}
	
	
	
//	@Test
	 @Parameters({ "parameters.plan.label",
	 "parameters.plan.roottask"})
	public void testChangePlanParametersNotClickOverride(String planParameters,String taskLabel) {
		// this.addPlan(planLabel, rootTask, "treeManagePlan");
		this.openExecutionPlanMenu();
		this.waitForElementPresent("//span[text()='" + planParameters + "']",
				WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//span[text()='" + planParameters + "']");
		this.ChangePlanParamter("name", "talend");
		this.runPlan(planParameters);
		this.waitForTextPresent("[OK]", MAX_WAIT_TIME);
//		this.waitForElementPresent("//span[@class='x-tree3-node-text' and text()='"+taskLabel+" : [OK]']", MAX_WAIT_TIME);
       String logs = (this.getPlanLogsValue(planParameters,taskLabel, null));
       Assert.assertTrue((logs.contains("name: JackZhang"))&&(logs.contains("age: 23")), "test failed!");
	   selenium.setSpeed(MIN_SPEED);
	}
	
//	@Test
	 @Parameters({ "parameters.plan.label",
	 "parameters.plan.roottask"})
	public void testChangePlanParametersAndClickOverride(String planParameters,String taskLabel) {
		// this.addPlan(planLabel, rootTask, "treeManagePlan");
		this.openExecutionPlanMenu();
		this.waitForElementPresent("//span[text()='" + planParameters + "']",
				WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//span[text()='" + planParameters + "']");
		String newage = "50";
		this.ChangePlanParamter("age", newage);
		this.waitForElementPresent("//button[text()='Override']",WAIT_TIME);
		selenium.setSpeed(MID_SPEED);
		selenium.mouseDown("//button[text()='Override']");
		selenium.click("//button[text()='Override']");
		selenium.mouseUp("//button[text()='Override']");
		selenium.setSpeed(MIN_SPEED);
		this.waitForTextPresent("Override successfully", WAIT_TIME);
		this.sleep(5000);
		this.runPlan(planParameters);
		this.waitForElementPresent("[RUNNING]", WAIT_TIME);
		this.sleep(10000);
		this.waitForElementPresent("//span[text()='Ready to run']", MAX_WAIT_TIME);
		this.waitForElementPresent("[OK]", MAX_WAIT_TIME);
//		this.waitForElementPresent("//span[@class='x-tree3-node-text' and text()='"+taskLabel+" : [OK]']", MAX_WAIT_TIME);
        String logs = (this.getPlanLogsValue(planParameters,taskLabel, null));
        System.out.println("after override parameters:\n"+logs);
        Assert.assertTrue((logs.contains("name: JackZhang"))&&(logs.contains("age: 50")), "test failed!");
//	    this.deletePlan(planParameters);
	}
	
	public void ChangePlanParamter(String context,String value){
		
		this.clickWaitForElementPresent("//span[@class='x-tab-strip-text  ' and text()='Parameter']");
		this.clickWaitForElementPresent("idJobConductorCmdPrmAddButton");
		this.clickWaitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-parameter']");
		this.input("//input[contains(@class,'x-form-field x-form-text x-form-focus')]",context);
		this.clickWaitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-description']");
	    this.input("//input[contains(@class,'x-form-field x-form-text')]",value);
	}
	public void AddParameterToPlan(String name,String value){
		this.clickWaitForElementPresent("//span[@class='x-tab-strip-text  ' and text()='Parameter']");
		this.clickWaitForElementPresent("idJobConductorCmdPrmAddButton");
		this.clickWaitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-parameter']");
		this.input("//input[contains(@class,'x-form-field x-form-text x-form-focus')]",name);
		this.clickWaitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-description']");
	    this.input("//input[contains(@class,'x-form-field x-form-text')]",value);
	}
	public void DeleteParametersOfPlan(String name,String value){
		this.clickWaitForElementPresent("//span[@class='x-tab-strip-text  ' and text()='Parameter']");
		selenium.mouseDown("//div[contains(text(),'name1')]//ancestor::div[@class='x-grid3-cell-inner x-grid3-col-parameter']");
		this.sleep(5000);
		selenium.click("idJobConductorCmdPrmDeleteButton");
		selenium.getConfirmation();
		this.sleep(3000);
		Assert.assertFalse(this.waitElement("//div[contains(text(),'name1')]//ancestor::div[@class='x-grid3-cell-inner x-grid3-col-parameter']", 10));
	}
	
	public void input(String inputXpath,String value){
		this.waitForElementPresent(inputXpath, WAIT_TIME);
		selenium.type(inputXpath,value);
		selenium.keyDown(inputXpath,"\\13");
	}
	
	public String getPlanLogsValue(String planLabel,String rootTask,String executeDate){
		String executionLogs = null;
//		selenium.refresh();
		this.waitForElementPresent("//span[text()='" + planLabel + "']", WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//span[text()='" + planLabel + "']");
		this.clickWaitForElementPresent("//span[@class='x-tab-strip-text  ' and text()='History']");
		
		this.clickWaitForElementPresent("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class=' x-panel-noborder x-panel x-component']//span[text()='Task execution monitoring']//ancestor::div[@class=' x-panel-noborder x-panel x-component']//table[@class='x-toolbar-ct']//td[11]//button");		

		this.clickWaitForElementPresent("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-expectedTriggeringDate x-component sort-as')]/a");
		this.clickWaitForElementPresent("//a[contains(@class,'x-menu-item x-component') and text()='Sort Descending']");
		this.clickWaitForElementPresent("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//td[@class='x-toolbar-left']//tr[@class='x-toolbar-left-row']//td[1]//table//button");
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Plan: "+planLabel+" Task: "+rootTask+"']", WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Plan: "+planLabel+" Task: "+rootTask+"']");
		this.waitForElementPresent("//textarea[contains(@class,'x-form-field x-form-textarea') and @name='contextValues']", WAIT_TIME);
		executionLogs = selenium.getValue("//textarea[contains(@class,'x-form-field x-form-textarea') and @name='contextValues']");
		return executionLogs;
		
	}

	
}
