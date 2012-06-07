package com.talend.tac.cases.grid;



import java.awt.Robot;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Parameters;


public class TestCheckpointsFilter extends Grid {
	Robot rob = null;
	public void openColumnsFilters(String beginTag,String beginTagClass){
		this.waitForElementPresent("//span[text()='"+beginTag+"']", WAIT_TIME);
		this.sleep(2000);
		selenium.click("//span[text()='"+beginTag+"']//parent::div[contains(@class,'"+beginTagClass+"')]//a");
		this.waitForElementPresent("//a[text()='Filters']", WAIT_TIME);
		selenium.mouseOver("//a[text()='Filters']");
	}
	
	public void ActiveColumn(String column){
			boolean present = selenium.isElementPresent("//a[contains(@class,'x-menu-item x-menu-check-item x-menu-checked x-component') and text()='"+column+"']");
			if(!present){
				selenium.click("//a[text()='"+column+"']");
			}
			this.waitForElementPresent("//tr[contains(@class,'x-grid3-hd-row')]//span[text()='"+column+"']", WAIT_TIME);
	}
	
	public void unActiveColumn(String column){
		boolean present = selenium.isElementPresent("//a[contains(@class,'x-menu-item x-menu-check-item x-menu-checked x-component') and text()='"+column+"']");
		if(present){
			selenium.click("//a[text()='"+column+"']");
		}
		this.waitForElementDispear("//td[contains(@class,'x-grid3-header x-grid3-hd x-grid3-cell x-grid3-td-logType')]//span[text()='"+column+"']", WAIT_TIME);
}
	
	public void activeFilters(){
		if(!selenium.isElementPresent("//a[@class=' x-menu-item x-menu-check-item x-menu-item-arrow x-component x-menu-checked' and text()='Filters']")){
			selenium.click("//a[text()='Filters']");
		}
	}
	
	
	public void checkFilter(String filterName){
		boolean present = selenium.isElementPresent("//a[contains(@class,' x-menu-item x-menu-check-item x-menu-item-arrow x-component  x-menu-checked') and text()='"+filterName+"']");
		if(!present){
			selenium.click("//a[text()='"+filterName+"']");
		}
		
	}
	public void unCheckFilter(String filterName){
		boolean present = selenium.isElementPresent("//a[contains(@class,'x-menu-item x-menu-check-item x-component x-menu-checked') and text()='"+filterName+"']");
		if(present){
			selenium.click("//a[text()='"+filterName+"']");
		}
		else{
			System.out.println("asfasdfasdfdfd");
		}
		
	}
	
	public void waitForElementDispear(String element, int timeout) {
		if (selenium.isElementPresent(element)) {
			for (int second = 0;; second++) {
				if (second >= timeout)
					Assert.assertFalse(selenium.isElementPresent(element));
				try {
					if ((!selenium.isElementPresent(element))) {
						break;
					} else {
						this.sleep(1000);
					}
				} catch (Exception e) {
				}

			}
		}

	}

	@Test 
	@Parameters({"grid.recoverymanagement.task.label","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testRecoveryCheckpointsFilters(String label, String description, String projectName, String branchName, String jobName, String version, String context, String serverName, String statisticName){
		this.openTaskMenu();
		this.addTask(label, description, projectName, branchName, jobName, version, context, serverName, statisticName);
		this.runTask(label, 1);
		this.clickWaitForElementPresent("idJobConductorTaskRecoverButton");
		this.clickWaitForElementPresent("//span[@class='x-tab-strip-inner']//span[text()='Recovery checkpoints']");
		this.sleep(5000);
		this.openColumnsFilters("Type", "x-grid3-hd-inner x-grid3-hd-logType x-component");
	    selenium.mouseOver("//a[text()='Columns']");
	    this.unActiveColumn("Event date");
	    this.unActiveColumn("Type");
	    this.unActiveColumn("Status");
	    this.unActiveColumn("Start component");
	    this.unActiveColumn("Job");
	    this.unActiveColumn("Label");
	    this.unActiveColumn("Failure instructions");
	    this.unActiveColumn("Log priority");
	    this.unActiveColumn("Message");
	    this.unActiveColumn("Stack trace");
	    this.unActiveColumn("Error code");
	    this.unActiveColumn("Project");
	    this.unActiveColumn("Version");
	    this.ActiveColumn("Event date");
	    this.ActiveColumn("Type");
	    this.ActiveColumn("Status");
	    this.ActiveColumn("Start component");
	    this.ActiveColumn("Job");
	    this.ActiveColumn("Label");
	    this.ActiveColumn("Failure instructions");
	    this.ActiveColumn("Log priority");
	    this.ActiveColumn("Message");
	    this.ActiveColumn("Stack trace");
	    this.ActiveColumn("Error code");
	    this.ActiveColumn("Project");
	    this.ActiveColumn("Version");
	    selenium.mouseOver("//a[text()='Filters']");
	    this.checkFilter("CHECKPOINT");
	    this.checkFilter("JOB_STARTED");
	    this.checkFilter("JOB_ENDED");
	    this.checkFilter("NODE");
	    this.checkFilter("USER_DEF_LOG");
	    this.checkFilter("SYSTEM_LOG");
	    this.checkFilter("CHECKPOINT");
	    this.unCheckFilter("CHECKPOINT");
	    this.sleep(2000);
	    Assert.assertTrue(selenium.getXpathCount("//span[@title='Checkpoint' and text()='Checkpoint']").intValue()==0, "");
	    this.checkFilter("CHECKPOINT");
	    this.unCheckFilter("JOB_STARTED");
	    this.sleep(2000);
	    Assert.assertTrue(selenium.getXpathCount("//span[@title='Job started' and text()='Job started']").intValue()==0, "");
	    this.checkFilter("JOB_STARTED");
	    this.unCheckFilter("JOB_ENDED");
	    this.sleep(2000);
	    Assert.assertTrue(selenium.getXpathCount("//span[@title='Job ended' and text()='Job ended']").intValue()==0, "");
	    this.checkFilter("JOB_ENDED");

	    }
	
	
	
}
