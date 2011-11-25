package com.talend.tac.cases.executePlan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

@SuppressWarnings("deprecation")
public class TestDuplicateSimpletrigger extends Plan {
	TriggerDate date = new TriggerDate();

	@Test
	@Parameters({ "plan.toaddsimpletrigger.label",
			"plan.simpletrigger.duplicate.label" })
	public void testDuplicateSimpleTrigger(String plan,
			String simpleTriggerToduplicate) throws InterruptedException {
		simpleTriggerToduplicate = simpleTriggerToduplicate+"Duplicated";
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Execution Plan']",
				WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
		this.addSimpleTrigger(plan, simpleTriggerToduplicate);
		// select plan
		this.waitForElementPresent("//span[text()='" + plan + "']", WAIT_TIME);
		this.sleep(3000);
		selenium.mouseDown("//span[text()='" + plan + "']");
		// select trigger to duplicate
		this.sleep(2000);
		selenium.mouseDown("//span[text()='" + simpleTriggerToduplicate + "']");//
		// click duplicate trigger button
		selenium.click("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idTriggerDuplicate']");
		selenium.click("//input[@name='startTime']/parent::div//img[@class='x-form-trigger x-form-date-trigger']");
		if (TriggerDate.isClickFutureMonthButton(date.getFuture(24))) {
			this.clickWaitForElementPresent("//div[contains(@class,'x-icon-btn x-nodrag x-date-right-icon x-component')]");
		}
		this.clickWaitForElementPresent("//td[@class='x-date-active']/a/span[text()='"
				+ date.getFuture(24).days + "']");
		selenium.click("//input[@name='endTime']/parent::div//img[@class='x-form-trigger x-form-date-trigger']");
		if (TriggerDate.isClickFutureMonthButton(date.getFuture(72))) {
			this.clickWaitForElementPresent("//div[contains(@class,'x-icon-btn x-nodrag x-date-right-icon x-component')]");
		}
		this.clickWaitForElementPresent("//td[@class='x-date-active']/a/span[text()='"
				+ date.getFuture(72).days + "']");
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatCount']",
				"");// description
		// type simple trigger repeat interval
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='repeatInterval']",
				"1500");// Number of triggerings
		// click save button to save trigger
		selenium.click("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSimpleTriggerSave']");
		this.waitForElementPresent("//span[text()='" + "Copy_of_"
				+ simpleTriggerToduplicate + "']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"
				+ "Copy_of_" + simpleTriggerToduplicate + "']"));
		selenium.setSpeed(MIN_SPEED);
	}

}
