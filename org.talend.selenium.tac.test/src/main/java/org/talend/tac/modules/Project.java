package org.talend.tac.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.Locatable;
import org.talend.tac.base.WebDriverBase;
import org.testng.Assert;

import com.talend.tac.base.Base;

public class Project extends WebDriverBase {
	
	public static int PROJECT_ADD_TYPE_COMMON = 0;
	public static int PROJECT_ADD_TYPE_REF = 1;
	
	public Project(WebDriver driver) {
		// TODO Auto-generated method stub
		super.setDriver(driver);
		this.driver = driver;
	}

	protected void gotoProject() {
		
		logger.info("Ready go to project page");
		getElementById("!!!menu.project.element!!!").click();
		logger.info("Go to project page");
		this.isElementPresent(By.xpath("//div[@class='header-title'" +
		" and text()='Projects']"), WAIT_TIME_MID);
		logger.info("Check whether into project page");
		
	}
	
	protected void addProject(String projectLabel, String type, int commonReference) {
		
		logger.info("Click add button");
		getElementById("idSubModuleAddButton").click();
		logger.info("Enter label value");
		this.waitforElementDisplayed(By.id("idLabelInput"), WAIT_TIME_MIN);
		this.waitElemet(2000);
		this.getElementById("idLabelInput").sendKeys(projectLabel);
		
		if (driver.findElement(By.id("idProjectTypeComboBox")).isDisplayed()) {
			logger.info("Click type selece box");
			getElementByXpath("//input[@id='idProjectTypeComboBox']//following-sibling::div[contains(@class,'x-form-trigger x-form-trigger-arrow')]").click();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("Verify type'option whether is displayed");
			boolean types = driver.findElement(By.xpath("//div[text()='"+type+"' and @role='listitem']")).isDisplayed();
						
			if(types == false) {				
				
				logger.info("Invoking method(selectDropDownList)");
				this.selectDropDownList("idProjectTypeComboBox", type);
				
			} else {
				
				logger.info("Selece an type");
				getElementByXpath("//div[text()='"+type+"']").click();
				
			}
			
		}

		if (commonReference == PROJECT_ADD_TYPE_REF) {
			
			logger.info("Check reference");
			// check reference checkbox
			getElementById("idReferenceInput").click();
		}
		logger.info("Click save button");
		this.waitElemet(2000);
		getElementById("idFormSaveButton").click();
		logger.info("Verify project whether is displayed");
		Assert.assertTrue(this.isElementPresent(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ projectLabel + "')]"), WAIT_TIME_MID));
		
		
	}	
	
	protected void failedDeleteProject(String projectLabel, String delProInfo) {
		
		logger.info("wait project appear");
		this.waitforElementDisplayed(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
						+ projectLabel + "')]"), WAIT_TIME_MID);
		this.waitElemet(2000);
		logger.info("mouse down project");
		getElementByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ projectLabel + "')]").click();
		this.waitElemet(2000);
		logger.info("click delete button");
		getElementById("idSubModuleDeleteButton").click();
		this.waitElemet(2000);
		logger.info("accept alert");
		this.acceptAlert();
		logger.info("check project whether disappear");
		Assert.assertTrue(this.waitforTextDisplayed(delProInfo, 20));
		Assert.assertTrue(this.waitforElementDisplayed(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ projectLabel + "')]"), 100));
		
	}

	protected void deleteProject(String projectLabel) {
		
		logger.info("wait project appear");
		this.waitforElementDisplayed(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
						+ projectLabel + "')]"), WAIT_TIME_MID);
		this.waitElemet(2000);
		logger.info("mouse down project");
		getElementByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ projectLabel + "')]").click();
		this.waitElemet(3000);
		logger.info("click delete button");
		getElementByXpath("//div[text()='Projects' and @class='header-title']/ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleDeleteButton']").click();
		this.waitElemet(2000);
		logger.info("accept alert");
		this.acceptAlert();
		logger.info("check project whether disappear");
		Assert.assertFalse(this.waitforElementDisplayed(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ projectLabel + "')]"), 100));
		
	}
	
	protected void waitElemet(long time) {
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
