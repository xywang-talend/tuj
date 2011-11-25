package com.talend.tac.cases.executePlan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@SuppressWarnings("deprecation")
public class TestAddTriggerAddSimpleTriggerByUIendbeforestart extends Plan {

	TriggerDate date = new TriggerDate();

	// add a simpleTrigger
	@Test
	@Parameters({ "plan.toaddsimpletrigger.label",
			"plan.simpletrigger.byui.endbeforestart.label" })
	public void testAddTriggerAddSimpleTrigger(String plantoaddsimletrigger,
			String simpletriggerlabel) throws InterruptedException {
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Execution Plan']",
				WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
		this.waitForElementPresent("//span[text()='" + plantoaddsimletrigger
				+ "']", WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//span[text()='" + plantoaddsimletrigger + "']");// select
		selenium.click("//button[text()='Add trigger...']");// add a trigger
		selenium.click("//a[text()='Add simple trigger']");// add a
															// SimpleTrigger
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
		if (TriggerDate.isClickFutureMonthButton(date.getFuture(48))) {
			this.clickWaitForElementPresent("//div[contains(@class,'x-icon-btn x-nodrag x-date-right-icon x-component')]");
		}
		this.clickWaitForElementPresent("//td[@class='x-date-active']/a/span[text()='"
				+ date.getFuture(48).days + "']");
		selenium.click("//input[@name='endTime']/parent::div/img[@class='x-form-trigger x-form-date-trigger']");
		if (TriggerDate.isClickFutureMonthButton(date.getFuture(24))) {
			this.clickWaitForElementPresent("//div[contains(@class,'x-icon-btn x-nodrag x-date-right-icon x-component')]");
		}
		this.clickWaitForElementPresent("//td[@class='x-date-active']/a/span[text()='"
				+ date.getFuture(24).days + "']");
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatCount']",
				"40");// description
		// type simple trigger repeat interval
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatInterval']",
				"15");// Number of triggerings
		selenium.click("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSimpleTriggerSave']");
		Assert.assertTrue(
				this.waitForTextPresent(
						"Save failed: End time cannot be before start time -- For more information see your log file",
						WAIT_TIME),
				"SimpleTrigger endTime before startTime failed!");
		Thread.sleep(3000);
		Assert.assertFalse(
				selenium.isElementPresent("//span[text()='"
						+ simpletriggerlabel + "']"),
				"SimpleTrigger endTime before startTime failed!");
		selenium.setSpeed(MIN_SPEED);
	}

}
