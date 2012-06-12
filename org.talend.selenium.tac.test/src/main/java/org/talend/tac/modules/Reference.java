package org.talend.tac.modules;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.talend.tac.base.WebDriverBase;
import org.testng.Assert;

public class Reference extends WebDriverBase {
			
	public Reference(WebDriver driver) {
		super.setDriver(driver);
		this.driver = driver;
	}
	
	protected void gotoReferencePage() {
		
		logger.info("click referece button");
		getElementById("!!!menu.refprojects.element!!!").click();
		logger.info("check whether into reference page");
		this.isElementPresent(By.xpath("//div[@class='header-title'" +
		" and text()='Projects references']"), WAIT_TIME_MID);
		logger.info("Go to reference page");
		
	}

	protected void multipleSameTimeReference(String sourcePro1, String branchName, String sourcePro2, String targetPro) {
		
		this.waitElement(2000);
		logger.info("get source");
		logger.info("//span[contains(text(),'Projects available as reference')]//ancestor::div[contains(@class,'x-sma')]//following-sibling::div//div[contains(text(),'"+branchName+"')]//parent::td//preceding-sibling::td//div[text()='"+sourcePro1+"']");
		WebElement sourceProject1 = getElementByXpath("//span[contains(text(),'Projects available as reference')]//ancestor::div[contains(@class,'x-sma')]//following-sibling::div//div[contains(text(),'"+branchName+"')]//parent::td//preceding-sibling::td//div[text()='"+sourcePro1+"']");
		WebElement sourceProject2 = getElementByXpath("//span[contains(text(),'Projects available as reference')]//ancestor::div[contains(@class,'x-sma')]//following-sibling::div//div[contains(text(),'"+branchName+"')]//parent::td//preceding-sibling::td//div[text()='"+sourcePro2+"']");
		
//		String sourceProject1 = "//span[contains(text(),'Projects available as reference')]//ancestor::div[contains(@class,'x-sma')]//following-sibling::div//div[text()='"+branchName+"']//parent::td//preceding-sibling::td//div[text()='"+sourcePro1+"']";
		logger.info("sourceProject1"+sourceProject1);
//		String sourceProject2 = "//span[contains(text(),'Projects available as reference')]//ancestor::div[contains(@class,'x-sma')]//following-sibling::div//div[text()='"+branchName+"']//parent::td//preceding-sibling::td//div[text()='"+sourcePro2+"']";
		logger.info("sourceProject2"+sourceProject2);
		WebElement targetProject = driver.findElement(By.xpath("//div[@aria-level='1']//span[text()='"+targetPro+"']"));
		try {
			Robot bot = new Robot();
			this.clickAndOnHold(sourceProject1);
			bot.keyPress(16);
			this.clickAndOnHold(sourceProject2);
			bot.keyRelease(16);
			this.waitElement(4000);
			this.moveToElement(targetProject);
			this.waitElement(4000);
			this.release();
			this.waitElement(4000);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		this.clickAndOnHold(sourceProject1);
		
	}
	
	protected void reference(String source, String target, String refInfo, int nodeLevel, String branchName){
		this.waitElement(2000);
		logger.info("get source");
		logger.info("//span[contains(text(),'Projects available as reference')]//ancestor::div[contains(@class,'x-sma')]//following-sibling::div//div[contains(text(),'"+branchName+"')]//parent::td//preceding-sibling::td//div[text()='"+source+"']");
		WebElement sourceProject = getElementByXpath("//span[contains(text(),'Projects available as reference')]//ancestor::div[contains(@class,'x-sma')]//following-sibling::div//div[contains(text(),'"+branchName+"')]//parent::td//preceding-sibling::td//div[text()='"+source+"']");
//		this.waitforElementDisplayed(sourceProject, WAIT_TIME_MID);
		logger.info("get target");
		logger.info(target);
		logger.info("//div[@aria-level='1']//span[text()='"+target+"']");
		System.err.println("**********------*********"+"//div[@aria-level='1']//span[text()='"+target+"']");
		WebElement targetProject = getElementByXpath("//div[@aria-level='1']//span[text()='"+target+"']");
		this.waitforElementDisplayed(targetProject, WAIT_TIME_MID);
		dragAndDrop(sourceProject, targetProject);
		logger.info("//span[text()='"+target+"']//ancestor::div[contains(@class,'x-tree3-el') and @aria-level='1']//following-sibling::div//div[@aria-level='"+nodeLevel+"']//span[contains(text(),'"+refInfo+"')]");
		this.isElementPresent(By.xpath("//span[text()='"+target+"']//ancestor::div[contains(@class,'x-tree3-el') and @aria-level='1']//following-sibling::div//div[@aria-level='"+nodeLevel+"']//span[contains(text(),'"+refInfo+"')]"), WAIT_TIME_MIN);
		Assert.assertTrue(this.isElementPresent(By.xpath("//span[text()='"+target+"']//ancestor::div[contains(@class,'x-tree3-el') and @aria-level='1']//following-sibling::div//div[@aria-level='"+nodeLevel+"']//span[contains(text(),'"+refInfo+"')]"), WAIT_TIME_MIN));
		logger.info("Reference project - '" + source + "'  to comm project '"+ target +"'");
	    if(this.isElementPresent(By.xpath("//span[text()='"+target+"']//ancestor::div[contains(@class,'x-tree3-el') and @aria-level='1']//following-sibling::div//div[@aria-level='3']//span[contains(text(),'"+refInfo+"')]"), 5)) {
	    	
	    	Assert.assertTrue(this.isElementPresent(By.xpath("//span[text()='"+target+"']//ancestor::div[contains(@class,'x-tree3-el') and @aria-level='1']//following-sibling::div//div[@aria-level='3']//span[contains(text(),'"+refInfo+"')]"), WAIT_TIME_MIN));
	    	
	    }
	    getElementByXpath("//div[text()='Projects references' and @class='header-title']/ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleRefreshButton']").click();
	}
	
	protected void failedReference(String source, String target, String refInfo, int nodeLevel, int targerNodeLevel){
		this.waitElement(2000);
		logger.info("get source");
		logger.info("//span[contains(text(),'Projects available as reference')]//ancestor::div[contains(@class,'x-sma')]//following-sibling::div//div[text()='"+source+"']");
		WebElement sourceProject = getElementByXpath("//span[contains(text(),'Projects available as reference')]//ancestor::div[contains(@class,'x-sma')]//following-sibling::div//div[text()='"+source+"']");
//		this.isElementPresent(By.xpath("//span[contains(text(),'Projects available as reference')]//ancestor::div[contains(@class,'x-sma')]//following-sibling::div//div[text()='"+source+"']"), 5);
		logger.info("get target");
		WebElement targetProject = getElementByXpath("//div[@aria-level='"+targerNodeLevel+"']//span[text()='"+target+"']");
		this.waitforElementDisplayed(targetProject, WAIT_TIME_MID);
		dragAndDrop(sourceProject, targetProject);	
		logger.info("//span[text()='"+target+"']//ancestor::div[contains(@class,'x-tree3-el') and @aria-level='1']//following-sibling::div//div[@aria-level='"+nodeLevel+"']//span[contains(text(),'"+refInfo+"')]");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("//span[text()='"+target+"']//ancestor::div[contains(@class,'x-tree3-el') and @aria-level='"+targerNodeLevel+"']//following-sibling::div//div[@aria-level='"+nodeLevel+"']//span[contains(text(),'"+refInfo+"')]");
		Assert.assertFalse(this.isElementPresent(By.xpath("//span[text()='"+target+"']//ancestor::div[contains(@class,'x-tree3-el') and @aria-level='"+targerNodeLevel+"']//following-sibling::div//div[@aria-level='"+nodeLevel+"']//span[contains(text(),'"+refInfo+"')]"), 5));
		logger.info(" Cannot reference project - '" + source + "'  to comm project '"+ target +"'");
	    
	}
	
	public void removeReference(String target, String refInfo, int nodeLevel) {
		
		logger.info("click right refinfo(sourcePro)");
		logger.info("//span[text()='"+target+"']//ancestor::div[contains(@class,'x-tree3-el') and @aria-level='1']//following-sibling::div[@class='x-tree3-node-ct']//div[@aria-level='"+nodeLevel+"']//span[contains(text(),'"+refInfo+"')]");
		this.isElementPresent(By.xpath("//span[text()='"+target+"']//ancestor::div[contains(@class,'x-tree3-el') and @aria-level='1']//following-sibling::div[@class='x-tree3-node-ct']//div[@aria-level='"+nodeLevel+"']//span[contains(text(),'"+refInfo+"')]"), WAIT_TIME_MIN);
		this.rightClick(getElementByXpath("//span[text()='"+target+"']//ancestor::div[contains(@class,'x-tree3-el') and @aria-level='1']//following-sibling::div[@class='x-tree3-node-ct']//div[@aria-level='"+nodeLevel+"']//span[contains(text(),'"+refInfo+"')]"));
		this.waitElement(2000);
		logger.info("click 'remove reference' button");
		getElementByXpath("//a[text()='Remove reference']").click();
		logger.info("accert alert");
		this.waitElement(3000);
		this.acceptAlert();
		this.waitElement(3000);
		logger.info("check refinfo(sourcePro) whether disappear");
		Assert.assertFalse(this.isElementPresent(By.xpath("//span[text()='"+target+"']//ancestor::div[contains(@class,'x-tree3-el') and @aria-level='1']//following-sibling::div//div[@aria-level='"+nodeLevel+"']//span[contains(text(),'"+refInfo+"')]"), 5));
				
	}
	
	public void checkRefProDisplay(String projectLabel, String branch, String type) {
		
		logger.info("//span[text()='"+projectLabel+"']");
		Assert.assertTrue(this.isElementPresent(By.xpath("//div[text()='"+projectLabel+"']"), WAIT_TIME_MIN));
		logger.info("//div[text()='"+projectLabel+"']//parent::td//preceding-sibling::td//div[contains(@class,'x-grid3-cell-inner x-grid3-col-projectBean')]//img");
		Assert.assertTrue(this.isElementPresent(By.xpath("//div[text()='"+projectLabel+"']//parent::td//preceding-sibling::td//div[contains(@class,'x-grid3-cell-inner x-grid3-col-projectBean')]//img"), WAIT_TIME_MIN));
		logger.info("//div[text()='"+projectLabel+"']//parent::td//following-sibling::td//div[contains(text(),'"+branch+"')]");
		Assert.assertTrue(this.isElementPresent(By.xpath("//div[text()='"+projectLabel+"']//parent::td//following-sibling::td//div[contains(text(),'"+branch+"')]"), WAIT_TIME_MIN));
		logger.info("//div[text()='"+projectLabel+"']//parent::td//following-sibling::td//div[contains(@class,'x-grid3-cell-inner x-grid3-col-projectBean')]//img[@title='Data Integration']");
		Assert.assertTrue(this.isElementPresent(By.xpath("//div[text()='"+projectLabel+"']//parent::td//following-sibling::td//div[contains(@class,'x-grid3-cell-inner x-grid3-col-projectBean')]//img[@title='"+type+"']"), WAIT_TIME_MIN));
		
	}
	
	public void waitElement(long time) {
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
