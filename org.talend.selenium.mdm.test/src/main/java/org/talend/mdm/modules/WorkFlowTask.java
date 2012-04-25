package org.talend.mdm.modules;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.talend.mdm.Base;
import org.talend.mdm.impl.LogonImpl;
import org.testng.Assert;


public class WorkFlowTask extends Base{
	


	public void switchDriver(WebDriver dri){
		
		this.driver=dri;
		
	}
	

	
	public void openMenuGoven() {
		
		this.waitfor(By.xpath(locator.getString("xpath.menu.goven")), WAIT_TIME_MIN);
		this.clickElementByXpath(locator.getString("xpath.menu.goven"));
		
	}

	public void openMenuWorkFlowTask() {
		
		this.waitfor(By.id(locator.getString("id.menu.workflowtasks")), WAIT_TIME_MIN);
		this.clickElementById(locator.getString("id.menu.workflowtasks"));
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.workflowtaskspage.search.button")),WAIT_TIME_MIN).isDisplayed());
	}
	
	public void uncheckHideFinishedTask(){
		this.clickElementByXpath(locator.getString("xpath.workflowtaskspage.hidefinishedtasks.checkbox.img"));
	}
	
	public void sortWorkFlowTaskBydate(){
		
		this.moveToElement(driver.findElement(By.xpath("//div[text()='Ready Date']")));
		this.clickElementByXpath("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-3')]//a[@class='x-grid3-hd-btn']");
		this.sleepCertainTime(5000);
		logger.info("!!!!!!!!!!!!!!!!!!!!!!"+this.getElementsByXpath("//a[contains(text(),'Sort Descending')]").size());
		this.clickVisibleElementByXpath("//a[contains(text(),'Sort Descending')]");
//		this.driver.findElement(By.xpath("//div[contains(@class,'x-layer x-menu')]//a[contains(text(),'Sort Descending')]")).sendKeys("\n"); 
//		this.clickElementByXpath("//div[contains(@class,'x-layer x-menu')]//a[contains(text(),'Sort Descending')]");
	}
	
	public void openAWorkTask(){
		this.clickElementByXpath(locator.getString("xpath.workflowtaskspage.tasks.firsttask"));
	    this.doubleClick(this.getElementByXpath(locator.getString("xpath.workflowtaskspage.tasks.firsttask")));
	}
	
	public void closeAWorkTask(){
		this.clickElementByXpath(locator.getString("xpath.workflow.openedworkflowtask.close"));
	}
	
	public void openRelatedRecord(){
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.workflow.openedworkflowtask.openrecord.button")), WAIT_TIME_MIN).isDisplayed());
		this.sleepCertainTime(3000);
		this.clickElementByXpath(locator.getString("xpath.workflow.openedworkflowtask.openrecord.button"));
	}
	
	public void closeRelatedRecord(String recordID){
		this.clickElementByXpath(this.getString(locator, "xpath.workflowtask.openrelatedrecord.open.closeTab", recordID));
	}
	
	public void closeRelatedAgentRecord(){
		this.clickElementByXpath(locator.getString("xpath.workflowtask.agent.openrelatedrecord.open.closeTab"));
	}
	public void approveBoxChecked(){
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.workflow.openedworkflowtask.approve.checkbox.input")), WAIT_TIME_MID)!=null);
		this.sleepCertainTime(5000);
		this.driver.findElement(By.xpath(locator.getString("xpath.workflow.openedworkflowtask.approve.checkbox.img"))).click();
	}
	
	public void approveCommissionCodeChange(String approveType){
		this.seletDropDownList(By.xpath(locator.getString("xpath.workflow.openedworkflowtask.agent.approve.selectdropdownlist.arrow")), approveType);
	}
	
	public void clickSearch(){
		
		this.clickElementByXpath(locator.getString("xpath.workflowtaskspage.search.button"));
		
	}
	
	public void clickSubmit(){
		this.clickElementByXpath("//button[text()='Submit']");
	}
	
}
