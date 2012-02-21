package com.talend.tac.cases.executePlan;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;


public class TestTriggerPauseAndResume extends Plan {

	@Test
	@Parameters({ "plan.toaddsimpletrigger.label", "plan.trigger.pauseandresume.label"})
	public void testPauseAndResume(String plan,String triggerPauseAndResume) throws InterruptedException {
		this.openExecutionPlanMenu();
		this.waitForElementPresent("//span[text()='" + plan + "']",
				WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//span[text()='"+plan+"']");//select a exist task
		selenium.click("idTriggerAdd trigger...");//add a trigger
		selenium.click("//a[text()='Add simple trigger']");//add a SimpleTrigger
        Assert.assertTrue(selenium.isElementPresent("//span[text()='"+rb.getString("trigger.action.addSimpleTrigger")+"']"));
        selenium.setSpeed(MIN_SPEED);
        //type simple trigger label
        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='label']",triggerPauseAndResume );//label
		//type simple trigger description
        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='description']", "SimpleTrigger");//description
        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatCount']", "");//description
        this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatInterval']", "5");//Number of triggerings
	    selenium.click("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSimpleTriggerSave']");
	    this.waitForElementPresent("//span[text()='"+triggerPauseAndResume+"']", WAIT_TIME);
	    Assert.assertTrue(selenium.isElementPresent("//span[text()='"+triggerPauseAndResume+"']"));
	    selenium.setSpeed(MIN_SPEED);
		//
//    	AddSimpleTrigger(plan,triggerPauseAndResume);
//    	selenium.mouseOver("//img[]")
	    for(int i =0; i <3; i++)
	    {
	    this.waitForElementPresent("//span[text()='Running...']", Base.WAIT_TIME);
	    this.waitForElementPresent("//span[text()='Ready to run']",
				Base.MAX_WAIT_TIME);
	    }
	    
    	//click pause trigger button
    	selenium.mouseDown("//span[text()='"+triggerPauseAndResume+"']");
    	selenium.click("//div[text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idTriggerPause trigger']");
    	this.sleep(10000);
    	Assert.assertFalse(this.waitElement("//span[text()='Running...']", TriggerCheckTime),"test trigger pause failed!");
	    selenium.click("//div[text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idTriggerResume trigger']");
	    this.sleep(3000);
	    Assert.assertTrue(this.waitElement("//span[text()='Running...']", TriggerCheckTime),"test trigger Resume failed!");
	    this.deleteTrigger(triggerPauseAndResume);
	}
	
	

}
