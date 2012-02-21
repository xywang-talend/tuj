package com.talend.tac.cases.executePlan;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAddTriggerAddCronTrigger extends Plan{
    	
    
	@Test
	@Parameters({ "plan.toaddcrontrigger.label","plan.toaddcrontrigger.task", "plan.crontrigger.label"})
	public void testAddCronTrigger(String planlabel,String task,String crongtriggerlabel) throws InterruptedException{
	    TriggerDate date = new TriggerDate().getFuture(24);
		//open to execution plan add trigger page
	    this.addPlan(planlabel, task, "testPlanCrontrigger");
	    selenium.refresh();
	    this.waitForElementPresent("//span[text()='"+planlabel+"']", WAIT_TIME);
	    this.sleep(2000);
    	selenium.mouseDown("//span[text()='"+planlabel+"']");
    	this.waitForElementPresent("//button[text()='Add trigger...' and @aria-disabled='false']", WAIT_TIME);
		selenium.click("//button[text()='Add trigger...']");
		selenium.click("//a[text()='Add CRON trigger']");
//		selenium.setSpeed(MID_SPEED);
		Thread.sleep(2000);
//		selenium.setSpeed(MIN_SPEED);
		//type  label
		this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='label']",crongtriggerlabel);
		//type  description
		this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='description']", "testCrontrigger");
    	//type minutes
		this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='minutes']", date.minutes);
		//type hours
		this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='hours']", date.hours);
		//type days
		this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='daysOfMonth']", date.days);
		//type months
		this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='months']", date.months);
		//type years
		this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='years']", date.years);	
		//click save button
//		selenium.setSpeed(MID_SPEED);
		selenium.click("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idCrontTriggerSave']");
//		Thread.sleep(5000);
		this.waitForElementPresent("//span[text()='"+crongtriggerlabel+"']", WAIT_TIME);
	    Assert.assertTrue(selenium.isElementPresent("//span[text()='"+crongtriggerlabel+"']"), "Crontrigger added failed!");
	    selenium.setSpeed(MIN_SPEED);
	}

		
	

}
