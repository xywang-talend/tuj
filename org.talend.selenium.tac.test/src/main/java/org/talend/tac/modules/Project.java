package org.talend.tac.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		Assert.assertTrue(this.isElementPresent(By.xpath("//div[contains(text(),'"+delProInfo+"')]"), WAIT_TIME_MIN));
		Assert.assertTrue(this.isElementPresent(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ projectLabel + "')]"), WAIT_TIME_MIN));
		
	}

	protected void deleteProject(String projectLabel) {
		
		logger.info("wait project appear");
		this.waitElemet(2000);
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
		boolean pro = this.isElementPresent(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ projectLabel + "')]"), 1);
		int i = 0;
		while (pro == true && i < WAIT_TIME_MIN) {
		    
			i++;
			this.waitElemet(1000);
			pro = this.isElementPresent(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
					+ projectLabel + "')]"), 1);
			System.err.println(i+">>>>"+pro);
			
		}
		Assert.assertFalse(this.isElementPresent(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ projectLabel + "')]"), 5));
		
	}
	
	protected void addBranch(String project, String branchName) {
		
		logger.info("mouse down project");
		this.getElementByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ project + "')]").click();
		logger.info("click add branch");
		this.getElementById("idBranchManagementButton").click();
		logger.info("click trunk in add branch view");
		this.getElementByXpath("//span[text()='trunk']").click();
		
		if(!this.isElementPresent(By.xpath("//input[@aria-describedby]"), 5)) {
			
			this.selectDropDownList("idBranchManagementSourceInput", "trunk");
			
		}
		
		logger.info("enter branch name");
		this.getElementById("idBranchManagementTargetInput").sendKeys(branchName);
		logger.info("click create button");
		this.getElementById("idBranchManagementCreateButton").click();
		logger.info("choose Yes");
		this.getElementByXpath("//button[text()='Yes']").click();	
		logger.info("check branch whether success");
		Assert.assertTrue(this.isElementPresent(By.xpath("//span[text()='" + branchName + "']"), WAIT_TIME_MIN));
		logger.info("click close window button");
		this.getElementByXpath("//div[@class=' x-nodrag x-tool-close x-tool x-component']").click();
			
	}
	
	protected void deleteBranch(String project, String branchName) {		
		
		this.waitElemet(3000);
		this.getElementByXpath("//div[text()='commonpro']").click();
		logger.info("mouse down project");		
		this.getElementByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ project + "')]").click();
		logger.info("click add branch button");
		this.waitElemet(2000);
		this.getElementById("idBranchManagementButton").click();		
		WebElement rightBranch = driver.findElement(By.xpath("//span[text()='" + branchName + "']"));
		logger.info("right click branch");
		this.rightClick(rightBranch);
		logger.info("click delete btanch");
		this.getElementById("delete-item-branch").click();
		logger.info("choose Yes");
		this.getElementByXpath("//button[text()='Yes']").click();	
		logger.info("check beanch whether add success");
		this.waitElemet(3000);
		Assert.assertFalse(this.isElementPresent(By.xpath("//span[text()='" + branchName + "']"), 10));
		logger.info("click close button");
		this.getElementByXpath("//div[@class=' x-nodrag x-tool-close x-tool x-component']").click();
				
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
