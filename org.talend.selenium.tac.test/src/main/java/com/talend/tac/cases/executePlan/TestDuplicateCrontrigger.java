package com.talend.tac.cases.executePlan;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDuplicateCrontrigger extends Plan {

	@Test
	@Parameters({ "plan.toaddcrontrigger.label",
			"plan.crontrigger.duplicate.label" })	
	public void testDuplicateCronTrigger(String plan,
			String triggertoduplicate) throws InterruptedException {
		TriggerDate date = new TriggerDate().getFuture(48);
		this.openExecutionPlanMenu();
		this.waitForElementPresent("//span[text()='" + plan + "']", WAIT_TIME);
		// select plan
		this.sleep(2000);
		selenium.mouseDown("//span[text()='" + plan + "']");// select a exist
		// select trigger to duplicate
		this.waitForElementPresent("//span[text()='" + triggertoduplicate + "']", WAIT_TIME);
		this.sleep(3000);
		selenium.mouseDown("//span[text()='" + triggertoduplicate + "']");//
		// click duplicate trigger button
		selenium.click("idTriggerDuplicate");
		// configure trigger information about time
		Thread.sleep(2000);
//		selenium.setSpeed(MIN_SPEED);
		// type minutes
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='minutes']",
				date.minutes);
		// type hours
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='hours']",
				date.hours);
		// type days
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='daysOfMonth']",
				date.days);
		// type months
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='months']",
				date.months);
		// type years
		this.typeString(
				"//div[@class=' x-panel x-component ']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader']/div[@class=' x-panel-noborder x-panel x-component']/div[@class='x-panel-bwrap']/div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/form[@class=' x-form-label-left']/fieldset[@class=' x-fieldset x-component']/div[@class=' x-form-label-left']/div[@class='x-form-item ']/div/div[@class=' x-form-field-wrap  x-component ']/input[@name='years']",
				date.years);

		// click save button to save trigger
		selenium.click("//div[@class='header-title' and text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idCrontTriggerSave']");
//		selenium.setSpeed(MID_SPEED);
//		Thread.sleep(5000);
		this.waitForElementPresent("//span[text()='"
				+ "Copy_of_" + triggertoduplicate + "']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"
				+ "Copy_of_" + triggertoduplicate + "']"));
		selenium.setSpeed(MIN_SPEED);
		
		//delete planforcrontrigger
		this.deletePlan(plan);
	}

}
