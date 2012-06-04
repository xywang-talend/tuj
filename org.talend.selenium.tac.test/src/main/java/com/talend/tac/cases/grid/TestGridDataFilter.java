package com.talend.tac.cases.grid;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Parameters;

public class TestGridDataFilter extends Grid {
	Robot rob = null;
	public void openColumnsFilters(String beginTag,String beginTagClass){
		this.waitForElementPresent("//span[text()='"+beginTag+"']", WAIT_TIME);
		this.sleep(2000);
		selenium.click("//span[text()='"+beginTag+"']//parent::div[contains(@class,'"+beginTagClass+"')]//a");
		this.waitForElementPresent("//a[text()='Filters']", WAIT_TIME);
		selenium.mouseOver("//a[text()='Filters']");
	}
	
	public void activeFilters(){
		if(!selenium.isElementPresent("//a[@class=' x-menu-item x-menu-check-item x-menu-item-arrow x-component x-menu-checked' and text()='Filters']")){
			selenium.click("//a[text()='Filters']");
		}
	}
	
	public void inputString(String inputXpath,String value){
		
		selenium.type(inputXpath, value);
		try {
			 rob = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rob.keyPress(KeyEvent.VK_TAB);
		rob.keyRelease(KeyEvent.VK_TAB);
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
	public void unCheckBasicStatusFilterAndVerify(String filter){
		this.unCheckFilter(filter);
		this.sleep(3000);
		Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-basicStatus']//img[@title='"+filter+"']").intValue()==0, "");
	    
	}
	public void unCheckDetailedStatusFilterAndVerify(String filter){
		this.unCheckFilter(filter);
		this.sleep(3000);
		Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-detailedStatus']//span[text()='"+filter+"']").intValue()==0, "");
	    
	}
	
	public void checkAllBasicStatusFilters(){
		this.checkFilter("Misfired!");
		this.checkFilter("Running...");
		this.checkFilter("Ok");
		this.checkFilter("Killed");
		this.checkFilter("Error");
		this.checkFilter("Unknown");
		this.checkFilter("Waiting for triggering...");
		this.checkFilter("Warning");
	}
	
	public void checkAllDetailStatusFilters(){
		this.checkFilter("Misfired!");
		this.checkFilter("Incomplete configuration");
		this.checkFilter("Task launched");
		this.checkFilter("Generating...");
		this.checkFilter("Requesting deployment...");
		this.checkFilter("Sending...");
		this.checkFilter("Deploying...");
		this.checkFilter("Requesting run...");
		this.checkFilter("Running...");
		this.checkFilter("Requesting stop");
		this.checkFilter("Unknown, JobServer might be unreachable");
		this.checkFilter("Unknown, JobServer was unreachable, task has been restarted");
		this.checkFilter("Unknown job state, JobServer was unreachable, task has been killed");
		this.checkFilter("Unknown job state, JobServer was unreachable, task has been recovered");
		this.checkFilter("Ok");
		this.checkFilter("Killed");
		this.checkFilter("Error while generating job");
		this.checkFilter("Connection to server failed");
		this.checkFilter("Unreachable server timeout");
		this.checkFilter("Connection to Generator failed (CommandLine)");
		this.checkFilter("Sending error");
		this.checkFilter("Deploying error");
		this.checkFilter("Task already processing error");
		this.checkFilter("Running error");
		this.checkFilter("Unexpected error");
		this.checkFilter("Unexpected state");
		this.checkFilter("Ended with unknown state");
		this.checkFilter("Job ended with error(s)");
		this.checkFilter("Waiting for triggering...");
		this.checkFilter("JobServer is inactive");
		this.checkFilter("Ended with warning");
		this.checkFilter("Unauthorized user for jobserver");
		
	}
	
	@Test
	public void testFilterBaseOnDetailStatus(){
		this.openGridMenu();
		this.openColumnsFilters("Detailed status", " x-grid3-hd-inner x-grid3-hd-detailedStatus x-component");
		this.checkAllDetailStatusFilters();
	    this.unCheckDetailedStatusFilterAndVerify("Ok");
	}
	
	@Test
	@Parameters({"grid.task.exist","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testFiltersDisable(String label, String description, String projectName, String branchName, String jobName, String version, String context, String serverName, String statisticName){
		this.cleanTask();
		this.addTask(label, description, projectName, branchName, jobName, version, context, serverName, statisticName);
		this.runTask(label, 1);
		this.testFilterBaseOnDetailStatus();
		this.sleep(5000);
		Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-detailedStatus']//span[text()='Ok']").intValue()==0, "");
		selenium.click("//button[text()='Disable filters']");
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-detailedStatus']//span[text()='Ok']", WAIT_TIME);
		Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-detailedStatus']//span[text()='Ok']").intValue()>=1, "");
		
	}
	@Test
	@Parameters({"grid.task.exist","grid.task.notexist"})
	public void testFilterDataBaseOnTaskStringExist(String taskExist,String taskNotExist){
		this.openGridMenu();
        this.openColumnsFilters("Task", "x-grid3-hd-inner x-grid3-hd-taskLabel x-component");
	    selenium.setSpeed(MID_SPEED);
		this.inputString("//div[@class='x-menu-list-item x-menu-list-item-indent']//input", taskExist);
		selenium.setSpeed(MIN_SPEED);
		this.activeFilters();
	    this.sleep(3000);
	    java.util.List<String> a = this.findSpecialMachedStrings("^Task: *.*");
	    Assert.assertTrue(a.size()>=1,"filter data in grid base on task string failed!");
	    for (int i = 0; i < a.size(); i++) {
			System.out.println("___________>"+a.get(i));
			Assert.assertTrue(a.get(i).contains(taskExist), "test filter data base on task string failed!");
		}
	}
	
	@Test
	@Parameters({"grid.task.exist","grid.task.notexist"})
	public void testFilterDataBaseOnTaskStringNotExist(String taskExist,String taskNotExist){
		this.openGridMenu();
		this.openColumnsFilters("Task", "x-grid3-hd-inner x-grid3-hd-taskLabel x-component");
		selenium.setSpeed(MID_SPEED);
		this.inputString("//div[@class='x-menu-list-item x-menu-list-item-indent']//input",taskNotExist);
		selenium.setSpeed(MIN_SPEED);
		this.activeFilters();
	    this.sleep(3000);
	    Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-detailedStatus']//span[text()='Ok']").intValue()==0, "");
	}
	
	@Test 
	public void testFilterDataBaseOnBasicStatus(){
		this.openGridMenu();
		this.openColumnsFilters("Basic status", "x-grid3-hd-inner x-grid3-hd-basicStatus x-component");
		this.checkAllBasicStatusFilters();
	    this.unCheckBasicStatusFilterAndVerify("Ok");
	}
	
}
