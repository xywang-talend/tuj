package org.talend.mdm.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.talend.mdm.Base;
import org.testng.Assert;


public class Welcome extends Base{
	
	public Welcome(WebDriver driver) {
		super.setDriver(driver);
		this.driver = driver;
	}
	
	public void checkGetStartedWindow(){
		
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.ui.window.getstarted")), WAIT_TIME_MIN)!=null, "element getstarted window is not displayed right now");
		logger.info("check welcome page UI getting started window ok");
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.ui.window.getstarted.item.labeltext")), WAIT_TIME_MIN)!=null, "element getstarted window is not displayed right now");
		logger.info("check welcome page UI getting started window.label ok.");
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.ui.window.getstarted.item.link.databrowser")), WAIT_TIME_MIN)!=null, "element getstarted window is not displayed right now");
		logger.info("check welcome page UI getting started window.item.databrowser ok.");
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.ui.window.getstarted.item.link.journal")), WAIT_TIME_MIN)!=null, "element getstarted window is not displayed right now");
		logger.info("check welcome page UI getting started window.item.journal ok.");
	
	}
	
	public void checkProcessWindow(){
		
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.ui.window.processes")), WAIT_TIME_MIN)!=null, "element processess window is not displayed right now");
		logger.info("check welcome page UI processes window ok");
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.ui.window.processes.title")), WAIT_TIME_MIN)!=null, "element processess window.title is not displayed right now");
		logger.info("check welcome page UI processes window.title ok.");
	
	}
	
	
	public void checkAlertsWindow(){
		
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.ui.window.alerts")), WAIT_TIME_MIN)!=null, "element alerts window is not displayed right now");
		logger.info("check welcome page UI processes window ok");
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.ui.window.alerts.title")), WAIT_TIME_MIN)!=null, "element alerts window.title is not displayed right now");
		logger.info("check welcome page UI alerts window.title ok.");
	
	}
	
	
	public void checkTasksWindow(){
		
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.ui.window.tasks")), WAIT_TIME_MIN)!=null, "element tasks window is not displayed right now");
		logger.info("check welcome page UI processes window ok");
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.ui.window.tasks.title")), WAIT_TIME_MIN)!=null, "element tasks window.title is not displayed right now");
		logger.info("check welcome page UI tasks window.title ok.");
		
	}
	
	public void openTasks(){
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.ui.window.tasks.workflow.entry")), WAIT_TIME_MIN).isDisplayed());
		this.clickElementByXpath(locator.getString("xpath.ui.window.tasks.workflow.entry"));
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.workflowtaskspage.search.button")),WAIT_TIME_MIN).isDisplayed());
	}
	
	public void checkSearchWindow(){
		
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.ui.window.search")), WAIT_TIME_MIN)!=null, "element search window is not displayed right now");
		logger.info("check welcome page UI processes window ok");
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.ui.window.search.title")), WAIT_TIME_MIN)!=null, "element search window.title is not displayed right now");
		logger.info("check welcome page UI search window.title ok.");
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.ui.window.search.item.search.input")), WAIT_TIME_MIN)!=null, "element search window.item.search.input is not displayed right now");
		logger.info("check welcome page UI processes window ok");
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.ui.window.search.item.search.button")), WAIT_TIME_MIN)!=null, "element search window.item.search.button is not displayed right now");
		logger.info("check welcome page UI search window.item.search.button ok.");
	}
	
	public Point getWindowPosition(WebElement ele){
		return ele.getLocation();
	}
	
	public void reSortWindowLayout(String srcXpathLocatorKey, String destXpathLocatorKey, int xP,int yP){
		WebElement srcElementOld = (this.getElementByXpath(locator.getString(srcXpathLocatorKey)));
		Point pointOld = this.getWindowPosition(srcElementOld);
		Actions builder = new Actions(driver); 
		builder.clickAndHold(this.getElementByXpath(locator.getString(srcXpathLocatorKey))) 
			.moveToElement(this.getElementByXpath(locator.getString(destXpathLocatorKey)), xP, yP).release().build().perform();      
		
		this.sleepCertainTime(5000);
		WebElement srcElementNew = (this.getElementByXpath(locator.getString(srcXpathLocatorKey)));
		Point pointNew = this.getWindowPosition(srcElementNew);
		Assert.assertFalse(pointNew.equals(pointOld), "lay out resort failed");
	}
	
}