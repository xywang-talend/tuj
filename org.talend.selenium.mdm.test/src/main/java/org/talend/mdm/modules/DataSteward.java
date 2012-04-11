package org.talend.mdm.modules;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.talend.mdm.Base;
import org.talend.mdm.impl.LogonImpl;
import org.testng.Assert;


public class DataSteward extends Base{
	


	public void switchDriver(WebDriver dri){
		
		this.driver=dri;
		
	}
	

	
	public void openMenuGoven() {
		
		this.waitfor(By.xpath(locator.getString("xpath.menu.goven")), WAIT_TIME_MIN);
		this.clickElementByXpath(locator.getString("xpath.menu.goven"));
		
	}

	public void openMenuDSC() {
		
		this.waitfor(By.id(locator.getString("id.menu.datastewardship")), WAIT_TIME_MIN);
		this.clickElementById(locator.getString("id.menu.datastewardship"));
		
	}
	
	public void clickAdminCreateTask() {
//		System.err.println(this.driver.switchTo().frame("TDSCFrame").getPageSource());
/*		this.sleepCertainTime(5000);
		WebDriver dri1 = driver.switchTo().frame("TDSCFrame");
		WebDriver dri2 = this.driver;
		this.switchDriver(dri1);
		driver = driver.switchTo().frame("TDSCFrame");
		
//		System.out.println(driver.getPageSource());
		
		
		this.sleepCertainTime(5000);*/
		logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		logger.info(this.getText());
		logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		this.typeString(this.getElementByXpath("//span[contains(text(),'Task Navigator')]//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component')]//input"), "test");
		this.clickElementByXpath("//span[contains(text(),'Task Navigator')]//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component')]//div[contains(@class,'x-icon-btn x-nodrag icon-reload x-component')]");
		this.waitfor(By.xpath(locator.getString("xpath.datatewardship.administration.createtask")), WAIT_TIME_MIN);
		logger.info("create task button xpath is :"+locator.getString("xpath.datatewardship.administration.createtask"));
		this.sleepCertainTime(5000);
		this.clickElementByXpath(locator.getString("xpath.datatewardship.administration.createtask"));
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.datatewardship.administration.createtask.panel.title")), WAIT_TIME_MIN)!=null,"open create task panel failed!");
	
	}

	public void typeTaskName(String taskName){
		
		this.typeString(this.getElementByXpath(locator.getString("xpath.datatewardship.administration.createtask.panel.taskproperties.taskname.input")), taskName);
		
	}
	
	public void typeTaskDefaultSourceName(String source){

		this.typeString(this.getElementByXpath(locator.getString("xpath.datatewardship.administration.createtask.panel.taskproperties.sourcename.input")), source);
		
	}
	
	public void selectTaskType(String taskType){
		
    this.seletDropDownList(By.xpath(locator.getString("xpath.datatewardship.administration.createtask.panel.taskproperties.tasktype.arrow")), taskType);
	
	}
	
	public void clickAddColumButton(){
		
		this.clickElementByXpath(locator.getString("xpath.datatewardship.administration.createtask.panel.add.button"));
		
	}
	
    public void clickSaveColumButton(){
		
		this.clickElementByXpath(locator.getString("xpath.datatewardship.administration.createtask.panel.taskschemadata.save.button"));
		
	}
	
	public void typeColumFieldName(String fieldName){
		
		this.typeString(this.getElementByXpath(locator.getString("xpath.datatewardship.administration.createtask.panel.taskschemadata.fieldname.input")), fieldName);
		
	}
}
