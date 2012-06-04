package com.talend.tac.cases.grid;



import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import com.talend.tac.base.Base;


public class TestSortTasksByLabel extends Grid {


	@Test 
	@Parameters({"addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testSortTasksByLabelThenSaveNewTasks(String projectName, String branchName, String jobName, String version, String context, String serverName, String statisticName){
		this.openTaskMenu();
		this.cleanTask();
		String label1 = "a";
		String label2 = "b";
		String label3 = "c";
		String label4 = "d";
		this.addTask(label1, "", projectName, branchName, jobName, version, context, serverName, statisticName);
		this.waitForElementPresent("//span[text()='" + label1 + "']",
				Base.WAIT_TIME);
		this.addTask(label2, "", projectName, branchName, jobName, version, context, serverName, statisticName);
		this.waitForElementPresent("//span[text()='" + label2 + "']",
				Base.WAIT_TIME);
		this.addTask(label4, "", projectName, branchName, jobName, version, context, serverName, statisticName);
		this.waitForElementPresent("//span[text()='" + label4 + "']",
				Base.WAIT_TIME);
//		selenium.setSpeed("5000");
		selenium.click("//div[@class=' x-grid3-hd-inner x-grid3-hd-label x-component']//a[@class='x-grid3-hd-btn']");
		this.sleep(3000);
		if(selenium.isElementPresent("//a[contains(@class,'x-menu-item x-menu-check-item x-menu-checked x-component') and text()='Show in Groups']")){
			selenium.click("//a[contains(@class,' x-menu-item x-menu-check-item x-menu-checked x-component') and text()='Show in Groups']//img");
		}
		
		selenium.click("//div[@class=' x-grid3-hd-inner x-grid3-hd-label x-component']//a[@class='x-grid3-hd-btn']");
		
		selenium.click("//a[@class=' x-menu-item x-component' and text()='Sort Descending']");
	    this.sleep(10000);
	    this.waitForElementPresent("//div[@class='header-title' and text()='Job Conductor']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')][1]//table[@class='x-grid3-row-table']", WAIT_TIME);
	    selenium.mouseDown("//div[@class='header-title' and text()='Job Conductor']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')][1]//table[@class='x-grid3-row-table']");
	    this.sleep(3000);
	    Assert.assertTrue(selenium.getValue("idJobConductorTaskLabelInput").equals(label4));
	   selenium.setSpeed("0");
	    this.waitForElementPresent("//div[@class='header-title' and text()='Job Conductor']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')][2]//table[@class='x-grid3-row-table']", WAIT_TIME);
	    selenium.mouseDown("//div[@class='header-title' and text()='Job Conductor']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')][2]//table[@class='x-grid3-row-table']");
	    this.sleep(3000);
	    Assert.assertTrue(selenium.getValue("idJobConductorTaskLabelInput").equals(label2));
	    this.waitForElementPresent("//div[@class='header-title' and text()='Job Conductor']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')][3]//table[@class='x-grid3-row-table']", WAIT_TIME);
	    selenium.mouseDown("//div[@class='header-title' and text()='Job Conductor']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')][3]//table[@class='x-grid3-row-table']");
	    this.sleep(3000);
	    Assert.assertTrue(selenium.getValue("idJobConductorTaskLabelInput").equals(label1));
	    /*  this.addTask(label3, "", projectName, branchName, jobName, version, context, serverName, statisticName);
	    //check sort results after save new task c
	     this.waitForElementPresent("//div[@class='header-title' and text()='Job Conductor']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')][1]//table[@class='x-grid3-row-table']", WAIT_TIME);
	    selenium.mouseDown("//div[@class='header-title' and text()='Job Conductor']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')][1]//table[@class='x-grid3-row-table']");
	    this.sleep(3000);
	    Assert.assertTrue(selenium.getValue("idJobConductorTaskLabelInput").equals(label4));
	    this.waitForElementPresent("//div[@class='header-title' and text()='Job Conductor']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')][2]//table[@class='x-grid3-row-table']", WAIT_TIME);
	    selenium.mouseDown("//div[@class='header-title' and text()='Job Conductor']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')][2]//table[@class='x-grid3-row-table']");
	    this.sleep(3000);
	    Assert.assertTrue(selenium.getValue("idJobConductorTaskLabelInput").equals(label2));
	    this.waitForElementPresent("//div[@class='header-title' and text()='Job Conductor']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')][3]//table[@class='x-grid3-row-table']", WAIT_TIME);
	    selenium.mouseDown("//div[@class='header-title' and text()='Job Conductor']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')][3]//table[@class='x-grid3-row-table']");
	    this.sleep(3000);
	    Assert.assertTrue(selenium.getValue("idJobConductorTaskLabelInput").equals(label3));
	    this.waitForElementPresent("//div[@class='header-title' and text()='Job Conductor']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')][4]//table[@class='x-grid3-row-table']", WAIT_TIME);
	    selenium.mouseDown("//div[@class='header-title' and text()='Job Conductor']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')][4]//table[@class='x-grid3-row-table']");
	    this.sleep(3000);
	    Assert.assertTrue(selenium.getValue("idJobConductorTaskLabelInput").equals(label1));
	   */
	    
	}

	
}
