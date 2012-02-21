package com.talend.tac.cases.executePlan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

@SuppressWarnings("deprecation")
public class TestAddTriggerAddSimpleTriggerByUI extends Login {

	TriggerDate date = new TriggerDate();

	// add a simpleTrigger
	@Test
	@Parameters({ "plan.toaddsimpletrigger.label",
			"plan.simpletrigger.byui.label" })
	public void testAddTriggerAddSimpleTriggerUI(String plantoaddsimletrigger,
			String simpletriggerlabel) throws InterruptedException {
		 this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
			this.waitForElementPresent("//div[@class='header-title' and text()='Execution Plan']", WAIT_TIME);
			Assert.assertTrue(selenium
					.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
		this.waitForElementPresent("//span[text()='" + plantoaddsimletrigger + "']", WAIT_TIME);
		this.sleep(3000);
		selenium.mouseDown("//span[text()='" + plantoaddsimletrigger + "']");// select
		selenium.click("//button[text()='Add trigger...']");// add a trigger
		selenium.click("//a[text()='Add simple trigger']");// add a SimpleTrigger
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"
				+ rb.getString("trigger.action.addSimpleTrigger") + "']"));
		Thread.sleep(2000);
		selenium.setSpeed(MIN_SPEED);
		// type simple trigger label
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='label']",
				simpletriggerlabel);// label
		// type simple trigger description
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='description']",
				"SimpleTrigger");// description
		// type simple trigger start time
		selenium.click("//input[@name='startTime']/parent::div//img[@class='x-form-trigger x-form-date-trigger']");
		if(TriggerDate.isClickFutureMonthButton(date.getFuture(24))){
    		this.clickWaitForElementPresent("//div[contains(@class,'x-icon-btn x-nodrag x-date-right-icon x-component')]");
        }
		this.clickWaitForElementPresent("//td[@class='x-date-active']/a/span[text()='" + date.getFuture(24).days + "']");
		/*selenium.setSpeed(MAX_SPEED);
		// selenium.click("//div[@class=' x-icon-btn x-nodrag x-date-left-icon x-component ']");
		selenium.click("//td[@class='x-date-active']/a/span[text()='" + date.getFuture(24).days + "']");
		selenium.setSpeed(MIN_SPEED);*/
		// this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='startTime']",
		// date.getFuture("24"));//description
		// type simple trigger end time
		selenium.click("//input[@name='endTime']/parent::div//img[@class='x-form-trigger x-form-date-trigger']");
		if(TriggerDate.isClickFutureMonthButton(date.getFuture(48))){
    		this.clickWaitForElementPresent("//div[contains(@class,'x-icon-btn x-nodrag x-date-right-icon x-component')]");
        }
		this.clickWaitForElementPresent("//td[@class='x-date-active']/a/span[text()='" + date.getFuture(48).days + "']");
		/*selenium.setSpeed(MAX_SPEED);
		// selenium.click("//div[@class=' x-icon-btn x-nodrag x-date-left-icon x-component ']");
		selenium.click("//td[@class='x-date-active']/a/span[text()='" + date.getFuture(48).days + "']");
		selenium.setSpeed(MIN_SPEED);*/
		// this.typeString("//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='endTime']",
		// date.getFuture("48"));//description
		// type simple trigger repeat count
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatCount']",
				"40");// description
		// type simple trigger repeat interval
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatInterval']",
				"15");// Number of triggerings
		// selenium.click("//span[text()='Add simple trigger']/parent::legend/parent::fieldset/parent::form/parent::div/parent::div/parent::div/parent::div/parent::div//button[@id='idFormSaveButton']");
		selenium.click("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSimpleTriggerSave']");
//		selenium.setSpeed(MID_SPEED);
//		 Thread.sleep(5000);
		this.waitForElementPresent("//span[text()='"+simpletriggerlabel+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+simpletriggerlabel+"']"));
		selenium.setSpeed(MIN_SPEED);
	}

}
