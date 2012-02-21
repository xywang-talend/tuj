package com.talend.tac.cases.executePlan;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPlanedTreeViewManage extends Plan{
	
	@Test
	public void testHideAndDisplayPlanTreeView(){
		this.openExecutionPlanMenu();
		this.waitForElementPresent("idExecutionPlanTreeViewOnOkButton", WAIT_TIME);
		this.waitForElementPresent("idExecutionPlanTreeViewOnErrorButton", WAIT_TIME);
		this.waitForElementPresent("idExecutionPlanTreeViewAfterButton", WAIT_TIME);
		this.waitForElementPresent("idExecutionPlanTreeViewRefreshButton", WAIT_TIME);
		this.clickWaitForElementPresent("//span[@class='x-panel-header-text' and text()='Planned task tree view']//ancestor::div[contains(@class,' x-small-editor x-panel-header x-component')]//div[contains(@class,'x-nodrag x-tool-right x-tool x-component')]");
		this.sleep(2000);
		Assert.assertFalse(selenium.isElementPresent("idExecutionPlanTreeViewOnOkButton"),"testHideAndDisplayPlanTreeView failed: idExecutionPlanTreeViewOnOkButton shouled not be visible");
		Assert.assertFalse(selenium.isElementPresent("idExecutionPlanTreeViewOnErrorButton"),"testHideAndDisplayPlanTreeView failed: idExecutionPlanTreeViewOnErrorButton shouled not be visible");
		Assert.assertFalse(selenium.isElementPresent("idExecutionPlanTreeViewAfterButton"),"testHideAndDisplayPlanTreeView failed: idExecutionPlanTreeViewAfterButton shouled not be visible");
		Assert.assertFalse(selenium.isElementPresent("idExecutionPlanTreeViewRefreshButton"),"testHideAndDisplayPlanTreeView failed: idExecutionPlanTreeViewRefreshButton shouled not be visible");
		this.clickWaitForElementPresent("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-panel-body x-panel-body-noheader x-border-layout-ct']//div[contains(@class,'x-nodrag x-tool-left x-tool x-component')]");
		this.sleep(2000);
		Assert.assertTrue(selenium.isElementPresent("idExecutionPlanTreeViewOnOkButton"),"testHideAndDisplayPlanTreeView failed: idExecutionPlanTreeViewOnOkButton shouled  be visible");
		Assert.assertTrue(selenium.isElementPresent("idExecutionPlanTreeViewOnErrorButton"),"testHideAndDisplayPlanTreeView failed: idExecutionPlanTreeViewOnErrorButton shouled  be visible");
		Assert.assertTrue(selenium.isElementPresent("idExecutionPlanTreeViewAfterButton"),"testHideAndDisplayPlanTreeView failed: idExecutionPlanTreeViewAfterButton shouled  be visible");
		Assert.assertTrue(selenium.isElementPresent("idExecutionPlanTreeViewRefreshButton"),"testHideAndDisplayPlanTreeView failed: idExecutionPlanTreeViewRefreshButton shouled  be visible");
	}
	
  @Test
  @Parameters({ "treeviewmanage.plan.label", "treeviewmanage.plan.roottask", "treeviewmanage.plan.taskok", "treeviewmanage.plan.taskerror","treeviewmanage.plan.taskafter" })
  public void testTreeManage(String planLabel,String rootTask,String taskOk,String taskError,String taskAfter) {
	  this.addPlan(planLabel, rootTask, "treeManagePlan");
	  selenium.mouseDown("//span[text()='"
				+ planLabel + "']");
	  this.waitForElementPresent("//span[@class='x-tree3-node-text' and text()='"+rootTask+"']", WAIT_TIME);
	  this.addOnOK(rootTask, taskOk);
	  this.addOnError(rootTask, taskError);
  }
  
  @Test(dependsOnMethods={"testTreeManage"})
  @Parameters({ "treeviewmanage.plan.label", "treeviewmanage.plan.roottask", "treeviewmanage.plan.taskok", "treeviewmanage.plan.taskerror","treeviewmanage.plan.taskafter" })
  public void testTreeManageRepeateAddOK(String planLabel,String rootTask,String taskOk,String taskError,String taskAfter) {
	 this.waitForElementPresent("//span[text()='"
				+ planLabel + "']", WAIT_TIME);
	 this.sleep(2000);
	  selenium.mouseDown("//span[text()='"
				+ planLabel + "']");
	  this.waitForElementPresent("//span[@class='x-tree3-node-text' and text()='"+rootTask+"']", WAIT_TIME);
	  this.sleep(2000);
	  selenium.mouseDown("//span[@class='x-tree3-node-text' and text()='"+rootTask+"']");
	  this.sleep(2000);
//	  selenium.chooseOkOnNextConfirmation();
	  selenium.click("idExecutionPlanTreeViewOnOkButton");
	  this.sleep(2000);
	  if(selenium.isAlertPresent()){
		  System.out.println("Alert present:");
		  Assert.assertTrue(selenium.getAlert().equals("ON_OK node has been existed")); 
	  }
	  if(selenium.isPromptPresent()){
		  System.out.println("Prompt present:");
		  Assert.assertTrue(selenium.getAlert().equals("ON_OK node has been existed")); 
	  }
	  if(selenium.isConfirmationPresent()){
		  System.out.println("Confirmation present:");
		  Assert.assertTrue(selenium.getAlert().equals("ON_OK node has been existed")); 
	  }

	  
	  
  }
  
  @Test(dependsOnMethods={"testTreeManage"})
  @Parameters({ "treeviewmanage.plan.label", "treeviewmanage.plan.roottask", "treeviewmanage.plan.taskok", "treeviewmanage.plan.taskerror","treeviewmanage.plan.taskafter" })
  public void testTreeManageRepeateAddError(String planLabel,String rootTask,String taskOk,String taskError,String taskAfter) {
	 this.waitForElementPresent("//span[text()='"
				+ planLabel + "']", WAIT_TIME);
	 this.sleep(2000);
	  selenium.mouseDown("//span[text()='"
				+ planLabel + "']");
	  this.waitForElementPresent("//span[@class='x-tree3-node-text' and text()='"+rootTask+"']", WAIT_TIME);
	  this.sleep(2000);
	  selenium.mouseDown("//span[@class='x-tree3-node-text' and text()='"+rootTask+"']");
	  this.sleep(2000);
//	  selenium.chooseOkOnNextConfirmation();
	  selenium.click("idExecutionPlanTreeViewOnErrorButton");
	  this.sleep(2000);
	  if(selenium.isAlertPresent()){
		  System.out.println("Alert present:");
		  Assert.assertTrue(selenium.getAlert().equals("ON_ERROR node has been existed")); 
	  }
	  if(selenium.isPromptPresent()){
		  System.out.println("Prompt present:");
		  Assert.assertTrue(selenium.getAlert().equals("ON_ERROR node has been existed")); 
	  }
	  if(selenium.isConfirmationPresent()){
		  System.out.println("Confirmation present:");
		  Assert.assertTrue(selenium.getAlert().equals("ON_ERROR node has been existed")); 
	  }

	  
	  
  }
  
  public void addOnOK(String okTask,String taskToadd){
	  this.waitForElementPresent("//span[@class='x-tree3-node-text' and text()='"+okTask+"']", WAIT_TIME);
	  this.sleep(2000);
	  selenium.mouseDown("//span[@class='x-tree3-node-text' and text()='"+okTask+"']");
	  this.sleep(2000);
	  selenium.click("idExecutionPlanTreeViewOnOkButton");
	  this.waitForElementPresent("//span[@class='x-fieldset-header-text' and text()='Add OnOk for planned task']", WAIT_TIME);
	  this.selectDropDownList("idExecutionPlanTreeFormTaskComboBox", taskToadd);
	  
	  String saveButton = "//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-fieldset-header-text' and text()='Add OnOk for planned task']/ancestor::form[@class=' x-form-label-left']//button[text()='Save']";
//      selenium.keyPressNative(""+KeyEvent.VK_TAB);
//      selenium.keyDownNative(""+KeyEvent.VK_ENTER);
//	  selenium.keyDownNative(""+KeyEvent.VK_TAB);
	  selenium.click(saveButton);

	  this.waitForElementPresent("//span[@class='x-tree3-node-text' and text()='OnOk -> "+taskToadd+"']", WAIT_TIME);
	  selenium.setSpeed(MIN_SPEED);
  }
  public void addOnError(String errorTask,String taskToadd){
	  this.waitForElementPresent("//span[@class='x-tree3-node-text' and text()='"+errorTask+"']", WAIT_TIME);
	  this.sleep(2000);
	  selenium.mouseDown("//span[@class='x-tree3-node-text' and text()='"+errorTask+"']");
	  this.sleep(2000);
	  selenium.click("idExecutionPlanTreeViewOnErrorButton");
	  this.waitForElementPresent("//span[@class='x-fieldset-header-text' and text()='Add OnError for planned task']", WAIT_TIME);
	  this.selectDropDownList("idExecutionPlanTreeFormTaskComboBox", taskToadd);
	  selenium.click("//span[@class='x-fieldset-header-text' and text()='Add OnError for planned task']/ancestor::form[@class=' x-form-label-left']//button[text()='Save']");
	  this.waitForElementPresent("//span[@class='x-tree3-node-text' and text()='OnError -> "+taskToadd+"']", WAIT_TIME);
	  
  }
  public void addAfter(String finishedTaskXpath,String followTask){
	  this.waitForElementPresent(finishedTaskXpath, WAIT_TIME);
	  selenium.mouseDown(finishedTaskXpath);
	  selenium.click("idExecutionPlanTreeViewAfterButton");
	  this.selectDropDownList("idExecutionPlanTreeFormTaskComboBox", followTask);
	  selenium.click("//span[@class='x-fieldset-header-text' and text()='Add After for planned task']/ancestor::form[@class=' x-form-label-left']//button[text()='Save']");
	  this.waitForElementPresent("//span[@class='x-tree3-node-text' and text()='After -> "+followTask+"']", WAIT_TIME);
  }
}
