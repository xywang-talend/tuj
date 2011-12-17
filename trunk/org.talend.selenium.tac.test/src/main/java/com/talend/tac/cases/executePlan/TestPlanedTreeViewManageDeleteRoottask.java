package com.talend.tac.cases.executePlan;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestPlanedTreeViewManageDeleteRoottask extends Plan {
	@Test
	@Parameters({ "plan.tasktreeviewmanage.label","plan.tasktreeviewmanage.task" })
	public void testDeleteRoottask(String plan,String roottask) {
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Execution Plan']",
				WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
		this.waitForElementPresent("//span[text()='" + plan + "']",
				WAIT_TIME);
		selenium.mouseDown("//span[text()='" + plan + "']");
		selenium.click("idExecutionPlanTreeViewRefreshButton");
		if(this.waitElement(
				"//span[@class='x-tree3-node-text' and text()='" + roottask
						+ " : [OK]']", 20))
		{
			this.sleep(2000);
			// mouse down the root task
			selenium.mouseDown("//span[@class='x-tree3-node-text' and text()='" + roottask
						+ " : [OK]']");
			// selenium.chooseOkOnNextConfirmation();
			// click delete button
//			selenium.click("//div[@class='x-panel-tbar']/div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct']/table[@class='x-toolbar-ct']/tbody/tr/td[@class='x-toolbar-left']/table/tbody/tr[@class='x-toolbar-left-row']/td[@class='x-toolbar-cell']/table[@class=' x-btn x-component x-btn-text-icon ']/tbody[@class='x-btn-small x-btn-icon-small-left']/tr/td[@class='x-btn-mc']/em/button[text()='Delete']");
			selenium.click("idExecutionPlanTreeViewDeleteButton");
			Assert.assertTrue(
					selenium.getAlert()
							.equals(other
									.getString("warningmessage.delete.executionplan.plantasktreeviewmanage.delete.roottask")),
					"root task delete failed!");
			Assert.assertTrue(
					selenium.isElementPresent("//span[@class='x-tree3-node-text' and text()='" + roottask
						+ " : [OK]']"), "root task delete failed!");
		}
		else{
			this.waitForElementPresent("//span[@class='x-tree3-node-text' and text()='"+roottask+"']",
					WAIT_TIME);
			this.sleep(2000);
			// mouse down the root task
			selenium.mouseDown("//span[@class='x-tree3-node-text' and text()='"+roottask+"']");
			// selenium.chooseOkOnNextConfirmation();
			// click delete button
//			selenium.click("//div[@class='x-panel-tbar']/div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct']/table[@class='x-toolbar-ct']/tbody/tr/td[@class='x-toolbar-left']/table/tbody/tr[@class='x-toolbar-left-row']/td[@class='x-toolbar-cell']/table[@class=' x-btn x-component x-btn-text-icon ']/tbody[@class='x-btn-small x-btn-icon-small-left']/tr/td[@class='x-btn-mc']/em/button[text()='Delete']");
			selenium.click("idExecutionPlanTreeViewDeleteButton");
			Assert.assertTrue(
					selenium.getAlert()
							.equals(other
									.getString("warningmessage.delete.executionplan.plantasktreeviewmanage.delete.roottask")),
					"root task delete failed!");
			Assert.assertTrue(
					selenium.isElementPresent("//span[@class='x-tree3-node-text' and text()='"+roottask+"']"), "root task delete failed!");
		}
		
		
	}

}
