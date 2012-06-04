package com.talend.tac.cases.grid;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import com.talend.tac.cases.executePlan.TriggerDate;


public class TestGridUICalendarFilter extends Grid {
	TriggerDate date = new TriggerDate();
	@Test
	@Parameters({"grid.task.label","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testGridCalendarFilter(String label, String description, String projectName, String branchName, String jobName, String version, String context, String serverName, String statisticName) {
	    this.cleanTask();
		this.addTask(label, description, projectName, branchName, jobName, version, context, serverName, statisticName);
        this.openGridMenu();
        this.sleep(5000);
        Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label+"']").intValue()==0,"Grid past execution display failed!");
        this.openTaskMenu();
        this.runTask(label, 2);
        this.openGridMenu();
        this.sleep(5000);
        Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label+"']").intValue()==2,"Grid past execution display failed!");
        this.addSimpleTriggerForTask(label, "testSimpleTrigger", "3600", "100");
        this.sleep(15000);
        this.openGridMenu();
        this.sleep(5000);
        Assert.assertTrue(selenium.getXpathCount("//span[@title='Waiting for triggering...' and text()='Waiting for triggering...']").intValue()==7,"Grid Future execution display failed!");
       this.clickWaitForElementPresent("//div[@title='Go to date...']//img");
       if(TriggerDate.isClickFutureMonthButton(date.getFuture(24))){
   		this.clickWaitForElementPresent("//div[contains(@class,'x-icon-btn x-nodrag x-date-right-icon x-component')]");
       }
       this.clickWaitForElementPresent("//td[@class='x-date-active']/a/span[text()='" + date.getFuture(24).days + "']");
       this.sleep(5000);
       Assert.assertTrue(selenium.getXpathCount("//span[@title='Waiting for triggering...' and text()='Waiting for triggering...']").intValue()==10,"Grid Future execution display failed!");
       this.clickWaitForElementPresent("//div[@title='Go to date...']//img");
       this.clickWaitForElementPresent("//button[@class='x-btn-text ' and text()='Today']");
       this.sleep(8000);
       //************
       selenium.setSpeed(MID_SPEED);
		selenium.click("//div[@qtip='Expected triggering date']//a[@class='x-grid3-hd-btn']");
		selenium.click("//a[@class=' x-menu-item x-component' and text()='Sort Ascending']");
		selenium.setSpeed(MIN_SPEED);
		this.sleep(2000);
		String definedTime = selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//div[@title='Go to date...']//input");
		String dateFuture = selenium.getText("//div[@class='x-grid3-cell-inner x-grid3-col-expectedTriggeringDate']");
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(definedTime);
	        date2= 	new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dateFuture);
	        Assert.assertTrue(date1.compareTo(date2)<=0);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       //************
       this.clickWaitForElementPresent("//div[@title='Go to date...']//img");
       if(TriggerDate.isClickPastMonthButton(date.getPast(48))){
    	   this.clickWaitForElementPresent("//div[contains(@class,'x-icon-btn x-nodrag x-date-left-icon x-component')]");
       }
       this.clickWaitForElementPresent("//td[@class='x-date-active']/a/span[text()='"+date.getPast(48).days+"']");
	   this.sleep(5000);
	   Assert.assertTrue(selenium.getXpathCount("//span[@title='Waiting for triggering...' and text()='Waiting for triggering...']").intValue()==7,"Grid Future execution display failed!");
	   Assert.assertTrue(selenium.isElementPresent("//div[@class='x-panel-tbar x-panel-tbar-noheader x-panel-tbar-noborder']//table[@class='x-toolbar-right-ct']//div[@class='my-paging-display x-component ' and text()='Items 1 to 10']"));
	
	}
	
	
	
}
