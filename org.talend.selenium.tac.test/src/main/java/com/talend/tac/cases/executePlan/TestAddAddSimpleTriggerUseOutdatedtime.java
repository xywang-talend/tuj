package com.talend.tac.cases.executePlan;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@SuppressWarnings("deprecation")
public class TestAddAddSimpleTriggerUseOutdatedtime extends Plan{
    	
	TriggerDate date = new TriggerDate();
   
	// add a simpleTrigger
	@Test
	@Parameters({ "plan.toaddsimpletrigger.label", "plan.simpletrigger.outdated.label"})
	public void testAddTriggerAddSimpleTriggerOutdated(String plantoaddsimletrigger, String simpletriggeroutdated) throws InterruptedException {
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent("//div[@class='header-title' and text()='Execution Plan']", WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
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
        selenium.typeKeys("//input[@name='startTime']", "2011-04-10 09:30:15");
//        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='startTime']", date.getFuture("24"));//description
        //type simple trigger end time
//        selenium.typeKeys("//input[@name='endTime']", date.getPast("24"));
        selenium.typeKeys("//input[@name='endTime']", "2011-04-16 09:08:34");
//        this.typeString("//input[@name='endTime']", date.getPast("24"));
//        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='endTime']", date.getFuture("48"));//description
        //type simple trigger repeat count
        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatCount']", "40");//description
	    //type simple trigger repeat interval
        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatInterval']", "15");//Number of triggerings
//	    selenium.click("//span[text()='Add simple trigger']/parent::legend/parent::fieldset/parent::form/parent::div/parent::div/parent::div/parent::div/parent::div//button[@id='idFormSaveButton']");
	    //click save button
//        selenium.setSpeed(MID_SPEED); 
        selenium.click("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-footer']/div[@class=' x-panel-btns']/div[@class=' x-small-editor x-panel-btns-center x-panel-fbar x-component x-toolbar-layout-ct']/table[@class='x-toolbar-ct']/tbody/tr/td[@class='x-toolbar-left']/table/tbody/tr[@class='x-toolbar-left-row']/td[@class='x-toolbar-cell']/table[@class=' x-btn x-component x-btn-text-icon ']/tbody[@class='x-btn-small x-btn-icon-small-left']/tr/td[@class='x-btn-mc']/em/button[@class='x-btn-text ' and text()='Save']");
	    ;
        Assert.assertTrue(this.waitForTextPresent("Save failed: Start time has to be set with a date greater than server time  ", WAIT_TIME), "simpleTriggerOutdated added failed!");
	    Thread.sleep(3000);
        Assert.assertFalse(selenium.isElementPresent("//span[text()='"+simpletriggeroutdated+"']"));
	    selenium.setSpeed(MIN_SPEED);
	}

}
