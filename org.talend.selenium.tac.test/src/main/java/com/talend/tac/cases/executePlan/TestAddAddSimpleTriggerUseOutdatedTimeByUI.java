package com.talend.tac.cases.executePlan;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAddAddSimpleTriggerUseOutdatedTimeByUI extends Plan{
    	
	TriggerDate date = new TriggerDate();
   
	// add a simpleTrigger
	@Test
	@Parameters({ "plan.toaddsimpletrigger.label", "plan.simpletrigger.outdated.label"})
	public void testAddTriggerAddSimpleTriggerOutdated(String plantoaddsimletrigger, String simpletriggeroutdated) {
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent("//div[@class='header-title' and text()='Execution Plan']", WAIT_TIME);
		Assert.assertTrue(selenium	
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
        this.waitForElementPresent("//span[text()='"+plantoaddsimletrigger+"']", WAIT_TIME);
    	selenium.mouseDown("//span[text()='"+plantoaddsimletrigger+"']");//select a exist task
		selenium.click("idTriggerAdd trigger...");//add a trigger
		selenium.click("//a[text()='Add simple trigger']");//add a SimpleTrigger
        Assert.assertTrue(selenium.isElementPresent("//span[text()='"+rb.getString("trigger.action.addSimpleTrigger")+"']"));
//        selenium.setSpeed(MID_SPEED);
        //type simple trigger label
        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='label']",simpletriggeroutdated );//label
		//type simple trigger description
        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='description']", "SimpleTriggerOutdated");//description
        //type simple trigger start time
//        this.typeString("//input[@name='startTime']", date.getPast("48"));
//        selenium.typeKeys("//input[@name='startTime']", date.getPast("48"));
          //selenium.typeKeys("//input[@name='startTime']", "2011-04-10 09:30:15");
//        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='startTime']", date.getFuture("24"));//description
       
       selenium.click("//input[@name='startTime']/parent::div//img[@class='x-form-trigger x-form-date-trigger']");
       if(TriggerDate.isClickPastMonthButton(date.getPast(48))){
    	   this.clickWaitForElementPresent("//div[contains(@class,'x-icon-btn x-nodrag x-date-left-icon x-component')]");
       }
       this.clickWaitForElementPresent("//td[@class='x-date-active']/a/span[text()='"+date.getPast(48).days+"']");
      /*  selenium.setSpeed(MAX_SPEED);
//        selenium.click("//div[@class=' x-icon-btn x-nodrag x-date-left-icon x-component ']");
        selenium.click("//td[@class='x-date-active']/a/span[text()='"+date.getPast(48).days+"']");
        selenium.setSpeed(MIN_SPEED);*/
        //type simple trigger end time
//        selenium.typeKeys("//input[@name='endTime']", date.getPast("24"));
//        selenium.typeKeys("//input[@name='endTime']", "2011-04-16 09:08:34");
//        this.typeString("//input[@name='endTime']", date.getPast("24"));
//        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='endTime']", date.getFuture("48"));//description
        selenium.click("//input[@name='endTime']/parent::div//img[@class='x-form-trigger x-form-date-trigger']");
        if(TriggerDate.isClickPastMonthButton(date.getPast(24))){
        		this.clickWaitForElementPresent("//div[contains(@class,'x-icon-btn x-nodrag x-date-left-icon x-component')]");
        }
        this.clickWaitForElementPresent("//td[@class='x-date-active']/a/span[text()='"+date.getPast(24).days+"']");
       /* selenium.setSpeed(MAX_SPEED);
//        selenium.click("//div[@class=' x-icon-btn x-nodrag x-date-left-icon x-component ']");
        selenium.click("//td[@class='x-date-active']/a/span[text()='"+date.getPast(24).days+"']");
        selenium.setSpeed(MIN_SPEED);*/
        //type simple trigger repeat count
        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatCount']", "40");//description
	    //type simple trigger repeat interval
        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatInterval']", "15");//Number of triggerings
//	    selenium.click("//span[text()='Add simple trigger']/parent::legend/parent::fieldset/parent::form/parent::div/parent::div/parent::div/parent::div/parent::div//button[@id='idFormSaveButton']");
	    //click save button
        selenium.setSpeed(MAX_SPEED); 
        selenium.click("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSimpleTriggerSave']");
//	    Assert.assertTrue(selenium.isTextPresent("Save failed: Start time has to be set with a date greater than server time  "), "simpleTriggerOutdated added failed!");
	    Assert.assertFalse(selenium.isElementPresent("//span[text()='"+simpletriggeroutdated+"']"));
	    selenium.setSpeed(MIN_SPEED);
	}

}
