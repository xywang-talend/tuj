package com.talend.tac.cases.grid;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Parameters;


public class TestGridExecutionsPageDisplay extends Grid {

	@Test
	@Parameters({"grid.task.label","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testGridGoToFirstPage(String label, String description, String projectName, String branchName, String jobName, String version, String context, String serverName, String statisticName) {
	    this.cleanTask();
		this.addTask(label, description, projectName, branchName, jobName, version, context, serverName, statisticName);
		String label2 = label+"second";
		this.addTask(label2, description, projectName, branchName, jobName, version, context, serverName, statisticName);
        this.runTask(label, 11);
        this.runTask(label2,11);
        this.openGridMenu();
        this.sleep(10000);
        Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label+"']").intValue()+selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label2+"']").intValue()==2,"Grid past execution display failed!");
	    String containsPages = selenium.getText("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//div[contains(text(),'of')]");
        System.out.println(containsPages);
	    String totalPage = containsPages.substring(containsPages.indexOf(" ")+1);
        System.out.println(totalPage);
	    Assert.assertTrue(totalPage.equals("3"), "total page display wrong!");
	    selenium.type("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']", "1");
	    selenium.keyDown("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']","\\13");
	    this.sleep(5000);
	    Assert.assertTrue(selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']").equals("1"), "go to first page failed!");
	    Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label+"']").intValue()+selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label2+"']").intValue()==10,"Grid past execution display failed!");
        	
	}
	
	@Test(dependsOnMethods={"testGridGoToFirstPage"})
	@Parameters({"grid.task.label"})
	public void testGridGoToCurrentTime(String label) {
		String label2 = label+"second";
        this.openGridMenu();
        this.sleep(5000);
        selenium.type("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']", "1");
	    selenium.keyDown("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']","\\13");
	    this.sleep(5000);
	    Assert.assertTrue(selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']").equals("1"), "go to first page failed!");
	    Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label+"']").intValue()+selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label2+"']").intValue()==10,"Grid past execution display failed!");
       selenium.setSpeed(MID_SPEED);
	    selenium.click("//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//table[@title='Go to current time']");
        this.sleep(5000);
	    Assert.assertTrue(selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']").equals("3"), "go to current time without future execution failed!");
	    Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label+"']").intValue()+selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label2+"']").intValue()==2,"Grid go to current time without future execution failed!");
        this.addSimpleTriggerForTask(label, "testSimpleTrigger", "150", "10");
        this.sleep(1000);
        this.openGridMenu();
        this.sleep(5000);
        selenium.click("//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//table[@title='Go to current time']");
	    this.sleep(5000);
	    Assert.assertTrue(selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']").equals("3"), "go to current time without future execution failed!");
	    Assert.assertTrue(selenium.getXpathCount("//img[@class='gwt-Image' and @title='Ok']").intValue()>=2,"Grid go to current time without future execution failed!");
	    Assert.assertTrue(selenium.getXpathCount("//span[@title='Waiting for triggering...' and text()='Waiting for triggering...']").intValue()==7,"Grid go to current time without future execution failed!");
	    this.deleteSimpleTriggerOfTask(label, "testSimpleTrigger");
	}
	
	@Test(dependsOnMethods={"testGridGoToFirstPage"})
	@Parameters({"grid.task.label"})
	public void testGridNoFutureExecutionsAfterAFutureDate(String label) {
		String label2 = label+"second";
		this.addSimpleTriggerForTask(label, "triggerRun100", "150", "100");
		this.sleep(2000);
        this.openGridMenu();
        this.sleep(5000);
        selenium.type("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']", "1");
	    selenium.keyDown("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']","\\13");
	    this.sleep(5000);
	    Assert.assertTrue(selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']").equals("1"), "go to first page failed!");
	    Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label+"']").intValue()+selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label2+"']").intValue()==10,"Grid past execution display failed!");
        //
	    selenium.type("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//div[@title='Go to date...']//input", "2100-06-08 13:54:01");
		selenium.keyDown("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//div[@title='Go to date...']//input","\\13");
		this.sleep(5000);
		Assert.assertTrue(selenium.getXpathCount("//span[@title='Waiting for triggering...' and text()='Waiting for triggering...']").intValue()==0,"Grid Future 2100 execution display failed!");
		 Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label+"']").intValue()+selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label2+"']").intValue()==0,"Grid past execution display failed!");
		this.deleteSimpleTriggerOfTask(label, "triggerRun100");
		 //
      
	}
	
	@Test(dependsOnMethods={"testGridGoToFirstPage"})
	@Parameters({"grid.task.label"})
	public void testGridGoToSpecialDate(String label) {
		String label2 = label+"second";
		this.addSimpleTriggerForTask(label, "triggerUnfinished", "150", "");
		this.sleep(2000);
        this.openGridMenu();
        this.sleep(5000);
        selenium.type("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']", "1");
	    selenium.keyDown("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']","\\13");
	    this.sleep(5000);
	    Assert.assertTrue(selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']").equals("1"), "go to first page failed!");
	    Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label+"']").intValue()+selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label2+"']").intValue()==10,"Grid past execution display failed!");
        //
	    String definedTime = "2100-06-08 13:54:01";
	    selenium.type("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//div[@title='Go to date...']//input", definedTime);
		selenium.keyDown("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//div[@title='Go to date...']//input","\\13");
		this.sleep(5000);
		selenium.setSpeed(MID_SPEED);
		selenium.click("//div[@qtip='Expected triggering date']//a[@class='x-grid3-hd-btn']");
		selenium.click("//a[@class=' x-menu-item x-component' and text()='Sort Ascending']");
		selenium.setSpeed(MIN_SPEED);
		this.sleep(2000);
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
		Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label+"']").intValue()+selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label2+"']").intValue()==10,"Grid past execution display failed!");
		this.deleteSimpleTriggerOfTask(label, "triggerUnfinished");
		 //
      
	}
	
	
//	@Test//(dependsOnMethods={"testGridGoToFirstPage"})
	@Parameters({"grid.task.label","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testGridGoToLastPage(String label, String description, String projectName, String branchName, String jobName, String version, String context, String serverName, String statisticName) {
		String label2 = label+"second";
        this.openGridMenu();
        this.sleep(5000);
        selenium.type("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']", "1");
	    selenium.keyDown("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']","\\13");
	    this.sleep(5000);
	    Assert.assertTrue(selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']").equals("1"), "go to first page failed!");
	    Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label+"']").intValue()+selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label2+"']").intValue()==10,"Grid past execution display failed!");
       selenium.setSpeed(MID_SPEED);
       selenium.mouseDown("//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//td[9]");
	    selenium.click("//div[@class='header-title' and text()='Task execution monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//td[9]");
        this.sleep(5000);
	    Assert.assertTrue(selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']").equals("3"), "go to last page failed!");
	    Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label+"']").intValue()+selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label2+"']").intValue()==2,"Grid past execution display failed!");
        	
	}
	
	@Test(dependsOnMethods={"testGridNoFutureExecutionsAfterAFutureDate"})
	@Parameters({"grid.task.label","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testGridGoToNextPageByUIButton(String label, String description, String projectName, String branchName, String jobName, String version, String context, String serverName, String statisticName) {
		String label2 = label+"second";
        this.openGridMenu();
        this.sleep(8000);
        Assert.assertTrue(selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label+"']").intValue()+selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-taskLabel' and text()='Task: "+label2+"']").intValue()==5,"Grid past execution display failed!");
	    Assert.assertTrue(selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']").equals("3"));
	    selenium.type("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']", "1");
	    selenium.keyDown("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']","\\13");
	    this.sleep(5000);
	    Assert.assertTrue(selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']").equals("1"), "go to first page failed!");
	    selenium.click("//div[text()='Task execution monitoring']//ancestor::div[contains(@class,'panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct')]//td[8]/table[contains(@class,'x-component x-unselectable')]//button");
	    this.sleep(5000);
	    Assert.assertTrue(selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']").equals("2"),"Go to next page by button failed!");
	}
	
	
	@Test(dependsOnMethods={"testGridGoToFirstPage"})
	@Parameters({"grid.task.label","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testGridGoToPreviousPageByUIButton(String label, String description, String projectName, String branchName, String jobName, String version, String context, String serverName, String statisticName) {
		String label2 = label+"second";
        this.openGridMenu();
	    Assert.assertTrue(selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[contains(@class,'gwt-TextBox x-component')]").equals("3"), "go to last page failed!");
        selenium.click("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//td[@class='x-toolbar-left']//tr[@class='x-toolbar-left-row']//td[2]//table//button");
        this.sleep(5000);
        Assert.assertTrue(selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']").equals("2"), "go to previous page failed!");
        
	}
	
	@Test(dependsOnMethods={"testGridGoToFirstPage"})
	@Parameters({"grid.task.label","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testGridGoToFirstPageByUIButton(String label, String description, String projectName, String branchName, String jobName, String version, String context, String serverName, String statisticName) {
		String label2 = label+"second";
        this.openGridMenu();
        this.sleep(5000);
        String currentPage = selenium.getValue("//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//input[contains(@class,'gwt-TextBox x-component')]");
	    System.out.println("*-*-*-*-"+currentPage);
        Assert.assertTrue(currentPage.equals("3"), "go to last page failed!");
        selenium.click("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//td[@class='x-toolbar-left']//tr[@class='x-toolbar-left-row']//td[1]//table//button");
        this.sleep(5000);
        Assert.assertTrue(selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']").equals("1"), "go to first page by UI button failed!");
        
	}
	
	@Test(dependsOnMethods={"testGridGoToFirstPage"})
	@Parameters({"grid.task.label","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","ServerForUseAvailable","statisticEnabled"})
	public void testGridGoToLastPageByUIButton(String label, String description, String projectName, String branchName, String jobName, String version, String context, String serverName, String statisticName) {
		String label2 = label+"second";
        this.openGridMenu();
	    Assert.assertTrue(selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']").equals("3"), "go to last page failed!");
        selenium.click("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//td[@class='x-toolbar-left']//tr[@class='x-toolbar-left-row']//td[1]//table//button");
        this.sleep(5000);
        Assert.assertTrue(selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']").equals("1"), "go to first page by UI button failed!");
        selenium.click("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//td[@class='x-toolbar-left']//tr[@class='x-toolbar-left-row']//td[9]//table//button");
        this.sleep(5000);
        Assert.assertTrue(selenium.getValue("//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[@class='gwt-TextBox x-component ']").equals("3"), "go to first page by UI button failed!");
        
	}
	
	
}
