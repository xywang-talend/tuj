package com.talend.tac.cases.executionTask;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class TestTaskContext extends Login {
	
	@Test
	@Parameters({ "label" })
	public void testChangeContextValue(String tasklabel) throws InterruptedException {
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"
				+ rb.getString("menu.jobConductor") + "']"));
		// select a exist task
		this.waitForElementPresent("//span[text()='"+tasklabel+"']", WAIT_TIME);
		selenium.mouseDown("//span[text()='"+tasklabel+"']");
		this.clickWaitForElementPresent("//span[text()='Context parameters']");
		// jvm parameters
		selenium.setSpeed(MID_SPEED);
//		selenium.click("//div[text()='age']/ancestor::table[@class='x-grid3-row-table']//img");
		selenium.click("//div[@class='x-grid3-cell-inner x-grid3-col-parameter' and text()='age']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-cell-inner x-grid3-col-customValue']");

		String contextBefore = selenium
				.getValue("//span[text()='Custom value']//ancestor::div[@class='x-grid3-viewport']//div[text()='age']//ancestor::div[@class='x-grid3-scroller']//input");
		String contextNewage = (Integer.parseInt(contextBefore) + 10) + "";
		this.typeString(
				"//span[text()='Custom value']//ancestor::div[@class='x-grid3-viewport']//div[text()='age']//ancestor::div[@class='x-grid3-scroller']//input",
				contextNewage);
		selenium.click("//div[@class='x-grid3-cell-inner x-grid3-col-parameter' and text()='age']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-cell-inner x-grid3-col-customValue']");
		contextBefore = selenium
				.getValue("//span[text()='Custom value']//ancestor::div[@class='x-grid3-viewport']//div[text()='age']//ancestor::div[@class='x-grid3-scroller']//input");
		System.out.println(contextBefore);
		if (!isCheckBoxChecked("//div[text()='age']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-override']")) {
			checkBoxChecked("//div[text()='age']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-check-col x-grid3-check-col x-grid3-cc-override']");
		}
		selenium.setSpeed(MIN_SPEED);
		runtask(tasklabel, Base.MAX_WAIT_TIME);
		Assert.assertTrue(checkContextValue().contains(contextNewage),
				"test context change failed!");

	}

	@Test
	@Parameters({ "label" })
	public void testCheckDefaultContext(String tasklabel)
			throws InterruptedException {
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"
				+ rb.getString("menu.jobConductor") + "']"));
		// select a exist task
		this.waitForElementPresent("//span[text()='"+tasklabel+"']", WAIT_TIME);
		selenium.mouseDown("//span[text()='"+tasklabel+"']");
		this.clickWaitForElementPresent("//span[text()='Context parameters']");
		// jvm parameters
		selenium.setSpeed(MAX_SPEED);

		String defaultContextAge = selenium
				.getText("//div[text()='age']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-cell-inner x-grid3-col-originalValue']");
		if (isCheckBoxChecked("//div[text()='age']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-override']")) {
			checkBoxUnchecked("//div[text()='age']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-override']");
		}
		selenium.setSpeed(MIN_SPEED);
		runtask(tasklabel,Base.WAIT_TIME);
		Assert.assertTrue(checkContextValue().contains(defaultContextAge),
				"default context test failed");
	}

	
	@Test
	@Parameters({ "label" })
	public void testResetContext(String tasklabel)
			throws InterruptedException {
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"
				+ rb.getString("menu.jobConductor") + "']"));
		// select a exist task
		this.waitForElementPresent("//span[text()='"+tasklabel+"']", WAIT_TIME);
		selenium.mouseDown("//span[text()='"+tasklabel+"']");
		this.clickWaitForElementPresent("//span[text()='Context parameters']");
		selenium.setSpeed(MID_SPEED);
		String defaultContextAge = selenium
				.getText("//div[text()='age']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-cell-inner x-grid3-col-originalValue']");
		String defaultContextBirth = selenium
		.getText("//div[text()='birth']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-cell-inner x-grid3-col-originalValue']");
		String defaultContextName = selenium
		.getText("//div[text()='name']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-cell-inner x-grid3-col-originalValue']");
		
		
		//modify context age
		
		String contextNewage = (Integer.parseInt(defaultContextAge) + 10) + "";
		selenium.click("//div[@class='x-grid3-cell-inner x-grid3-col-parameter' and text()='age']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-cell-inner x-grid3-col-customValue']");
		this.typeString(
				"//span[text()='Custom value']//ancestor::div[@class='x-grid3-viewport']//div[text()='age']//ancestor::div[@class='x-grid3-scroller']//input",
				contextNewage);
		//modify context birth
		String contextNewbirth = " yyyy-MM-dd HH:mm:ss;2012-01-01 00:00:00";
		selenium.click("//div[@class='x-grid3-cell-inner x-grid3-col-parameter' and text()='birth']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-cell-inner x-grid3-col-customValue']");
		this.typeString(
				"//span[text()='Custom value']//ancestor::div[@class='x-grid3-viewport']//div[text()='birth']//ancestor::div[@class='x-grid3-scroller']//input",
				contextNewbirth);
		//modify context name 
		String contextNewname = "testname";
		selenium.click("//div[@class='x-grid3-cell-inner x-grid3-col-parameter' and text()='name']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-cell-inner x-grid3-col-customValue']");
		this.typeString(
				"//span[text()='Custom value']//ancestor::div[@class='x-grid3-viewport']//div[text()='name']//ancestor::div[@class='x-grid3-scroller']//input",
				contextNewname);
		//active these three contexts
		if (!isCheckBoxChecked("//div[text()='age']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-override']")) {
			checkBoxChecked("//div[text()='age']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-check-col x-grid3-check-col x-grid3-cc-override']");
		}
		if (!isCheckBoxChecked("//div[text()='birth']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-override']")) {
			checkBoxChecked("//div[text()='birth']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-check-col x-grid3-check-col x-grid3-cc-override']");
		}
		if (!isCheckBoxChecked("//div[text()='name']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-override']")) {
			checkBoxChecked("//div[text()='name']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-check-col x-grid3-check-col x-grid3-cc-override']");
		}
		
		selenium.setSpeed(MIN_SPEED);
		runtask(tasklabel,Base.WAIT_TIME);
		String logs = checkContextValue();
		Assert.assertTrue(logs.contains(contextNewname),
				"default context name test failed");
		
		Assert.assertTrue(logs.contains(contextNewage),
		"default context age test failed");
//		Assert.assertTrue(logs.contains(contextNewbirth),
//		"default context birth test failed");
		//click the reset button 
		selenium.setSpeed(MID_SPEED);
		this.clickWaitForElementPresent("//span[text()='Context parameters']");
		selenium.chooseOkOnNextConfirmation();
		selenium.click("//button[@id='idJobConductorContextPrmResetButton' and text()='Reset']");
		selenium.getConfirmation();
		selenium.click("//div[@class='x-grid3-cell-inner x-grid3-col-parameter' and text()='age']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-cell-inner x-grid3-col-customValue']");
		
		String resetage = selenium
		.getValue("//span[text()='Custom value']//ancestor::div[@class='x-grid3-viewport']//div[text()='age']//ancestor::div[@class='x-grid3-scroller']//input");
		selenium.click("//div[@class='x-grid3-cell-inner x-grid3-col-parameter' and text()='name']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-cell-inner x-grid3-col-customValue']");
		String resetname = selenium
		.getValue("//span[text()='Custom value']//ancestor::div[@class='x-grid3-viewport']//div[text()='name']//ancestor::div[@class='x-grid3-scroller']//input");
		selenium.click("//div[@class='x-grid3-cell-inner x-grid3-col-parameter' and text()='birth']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-cell-inner x-grid3-col-customValue']");
		String resetbirth = selenium
		.getValue("//span[text()='Custom value']//ancestor::div[@class='x-grid3-viewport']//div[text()='birth']//ancestor::div[@class='x-grid3-scroller']//input");
		System.out.println(resetage);
		System.out.println(resetname);
		System.out.println(resetbirth);
		Assert.assertTrue(resetage.equals(defaultContextAge)&&resetname.equals(defaultContextName), "test context reset failed!");
		selenium.setSpeed(MIN_SPEED);
	}		

	public void runtask(String tasklabel,int waitTime) throws InterruptedException {
		selenium.refresh();
		this.waitForElementPresent("//span[text()='" + tasklabel + "']",
				WAIT_TIME);
		selenium.mouseDown("//span[text()='" + tasklabel + "']");
		Thread.sleep(3000);
		selenium.click("//button[@id='idJobConductorTaskRunButton'  and @class='x-btn-text ' and text()='Run']");
		Date start = new Date();
		this.waitForElementPresent("//label[text()='Ok']", waitTime);
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Ok']"));
		// close the pop window
		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
		// System.out.println(checkContextValue(start));

	}

	public String checkContextValue() {
		String context = null;
		selenium.click("//span//span[text()='Logs']");
		selenium.setSpeed(MID_SPEED);
		selenium.click("//div[@class=' x-grid3-hd-inner x-grid3-hd-startDate x-component sort-desc ']//a[@class='x-grid3-hd-btn']");
		selenium.setSpeed(MIN_SPEED);
		selenium.click("//a[@class=' x-menu-item x-component' and text()='Sort Descending']");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-startDate']",
				WAIT_TIME);
		String time = selenium
				.getText("//div[@class='x-grid3-cell-inner x-grid3-col-startDate']");
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-startDate']");
		selenium.setSpeed(MID_SPEED);
		// this.waitForElementPresent(
		// "//div[@class='x-grid3-cell-inner x-grid3-col-startDate' and text()='"+time+"']",
		// WAIT_TIME);
		String logs = selenium
				.getValue("//textarea[@name='log']");
		selenium.setSpeed(MIN_SPEED);
		// String dates[] = after.split("-");
		System.out.println(logs);
		return context = logs;
	}

	public void checkBoxChecked(String checkboxXpath) {
		selenium.mouseDown(checkboxXpath);
	}

	public void checkBoxUnchecked(String checkboxXpath) {
		selenium.mouseDown(checkboxXpath);

	}

	public boolean isCheckBoxChecked(String checkBoxOnXpath) {
		boolean checked = false;
		try {
			if (selenium.isElementPresent(checkBoxOnXpath))
				checked = true;
		} catch (Exception e) {
		}
		return checked;
	}
}
