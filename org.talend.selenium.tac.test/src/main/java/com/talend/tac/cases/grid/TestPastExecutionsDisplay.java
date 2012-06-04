package com.talend.tac.cases.grid;

import java.awt.event.KeyEvent;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import com.talend.tac.base.Base;

public class TestPastExecutionsDisplay extends Grid {

	@Test
	@Parameters({"grid.task.label","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testGridPastDisplay(String label, String description, String projectName, String branchName, String jobName, String version, String context, String serverName, String statisticName) {
	    this.cleanTask();
		this.addTask(label, description, projectName, branchName, jobName, version, context, serverName, statisticName);
		String label2 = label+"second";
		this.addTask(label2, description, projectName, branchName, jobName, version, context, serverName, statisticName);
        this.runTask(label, 2);
        this.runTask(label2, 2);
        this.openGridMenu();
        this.sleep(5000);
        Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label+"']").intValue()+selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label2+"']").intValue()==4,"Grid past execution display failed!");
	
	}
	
	@Test(dependsOnMethods={"testGridPastDisplay"})
	@Parameters({"grid.task.label","testGridFutureDisplay.trigger.label"})
	public void testGridFutureDisplay(String label, String TriggerLabel) {
	this.addSimpleTriggerForTask(label, TriggerLabel, "160", "3");
	this.sleep(10000);
	this.openGridMenu();
	this.sleep(5000);
	Assert.assertTrue(selenium.getXpathCount("//span[@title='Waiting for triggering...' and text()='Waiting for triggering...']").intValue()==3,"Grid Future execution display failed!");
	}
	
	@Test(dependsOnMethods={"testGridFutureDisplay"})
	@Parameters({"grid.task.label","testGridFutureDisplay.trigger.label"})
	public void testGridFutureTriggerPausedDisplay(String label, String TriggerLabel) {
	this.openTaskMenu();
	this.waitForElementPresent("//span[text()='" + label + "']",
			Base.WAIT_TIME);
	this.sleep(2000);
	selenium.mouseDown("//span[text()='" + label + "']");
	this.waitForElementPresent("//span[text()='" + TriggerLabel + "']", WAIT_TIME);
	this.sleep(2000);
	selenium.mouseDown("//span[text()='" + TriggerLabel + "']");
	this.sleep(2000);
	selenium.click("idTriggerPause trigger");
	this.openGridMenu();
	this.sleep(5000);
	Assert.assertTrue(selenium.getXpathCount("//span[@title='Waiting for triggering...' and text()='Waiting for triggering...']").intValue()==0,"Grid Future execution display failed!");
	}
	
	@Test(dependsOnMethods={"testGridFutureTriggerPausedDisplay"})
	@Parameters({"grid.task.label"})
	public void testRunTaskByGridInterface(String label) {
	this.openGridMenu();
	this.sleep(5000);
	selenium.chooseOkOnNextConfirmation();
	selenium.click("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: gridTask']//ancestor::table[@class='x-grid3-row-table']//button");
	selenium.getConfirmation();
	this.sleep(5000);
	selenium.refresh();
	this.sleep(10000);
	String label2 = label +"second";
	selenium.setSpeed(MID_SPEED);
	Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label+"']").intValue()+selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label2+"']").intValue()==6,"Run task through Grid interface displayed failed!");
	selenium.setSpeed(MIN_SPEED);
	}
	
	@Test(dependsOnMethods={"testRunTaskByGridInterface"})
	@Parameters({"grid.task.label","testGridFutureDisplay.trigger.label"})
	public void testGridFuture2011Display(String label, String TriggerLabel) {
	this.deleteSimpleTriggerOfTask(label, TriggerLabel);
	this.addSimpleTriggerForTask(label, TriggerLabel, "800", "");
	this.openGridMenu();
	this.sleep(5000);	
//	this.typeString("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//div[@title='Go to date...']//input", "2100-06-08 13:54:01");
//	selenium.keyPressNative(""+KeyEvent.VK_ENTER);
	selenium.type("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//div[@title='Go to date...']//input", "2100-06-08 13:54:01");
	selenium.keyDown("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//div[@title='Go to date...']//input","\\13");
	this.sleep(5000);
	Assert.assertTrue(selenium.getXpathCount("//span[@title='Waiting for triggering...' and text()='Waiting for triggering...']").intValue()==10,"Grid Future 2100 execution display failed!");
	
	
	}
	
	
}
