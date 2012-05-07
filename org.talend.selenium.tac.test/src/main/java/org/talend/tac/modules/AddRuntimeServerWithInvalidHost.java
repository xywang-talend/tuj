package org.talend.tac.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.talend.tac.base.WebDriverBase;
import org.testng.Assert;
import com.talend.tac.base.Karaf;

public class AddRuntimeServerWithInvalidHost extends WebDriverBase{
	Karaf karaf = new Karaf("localhost");
	
	public static String server_status_inactive = "INACTIVE";
	public static boolean server_active_true = true;
	public static boolean server_active_false = false;
    
	public AddRuntimeServerWithInvalidHost(WebDriver driver) {
		super.setDriver(driver);
		this.driver=driver;
	}
	
	public void openServerMenu() {
		this.getElementById("!!!menu.executionServers.element!!!").click();
        this.waitforTextDisplayed("SERVERS", WAIT_TIME_MAX);
		
		this.waitforElementDisplayed(By.xpath(
				"//div[@class='header-title' and text()='Servers']//ancestor::div[@class=' x-viewport x-component x-border-layout-ct']//span[@class='x-fieldset-header-text' and text()='Execution server']"),
				WAIT_TIME_MIN);
		this.waitforElementDisplayed(By.xpath(
				"//div[@class='header-title' and text()='Servers']"), WAIT_TIME_MIN);

	}
	
	public void addRuntimeServer(String Servername,String host) {
		this.clickElementById("idSubModuleAddButton");
		// lable
		this.typeTextByXpath("//span[text()='Execution server']//parent::legend//following-sibling::div//input[@name='label']",
				Servername);
		
		// description
		this.typeTextByXpath("//span[text()='Execution server']//parent::legend//following-sibling::div//input[@name='description']",
				"description");
		// host
		this.typeTextByXpath("//span[text()='Execution server']//parent::legend//following-sibling::div//input[@name='host']",
				host);
		this.clickElementById("idAdvanceInput");
		Assert.assertTrue(this.isElementPresent(By.xpath("//input[@id='idAdvanceInput' and @checked]"),WAIT_TIME_MIN));
		this.waitforElementDisplayed(By.xpath("//input[@name='mgmtServerPort']"), WAIT_TIME_MIN);
		this.clickElementById("idFormSaveButton");
		this.clickElementByXpath("//div[text()='Servers']//ancestor::div[@class=' x-panel-noborder x-panel x-component x-border-panel']//following-sibling::div[1]//button[text()='Refresh']");
		this.waitforElementDisplayed(By.xpath("//div[text()='" + Servername + "']"),
				WAIT_TIME_MIN);		
	}
	
	public void checkServerStatus(String serverLabel,String serviceStatus) {
		this.waitforElementDisplayed(By.xpath("//div[text()='" + serverLabel + "']"),
				WAIT_TIME_MIN);
		this.waitforElementDisplayed(By.xpath(
				"//div[text()='"
						+ serverLabel
						+ "']//ancestor::table[contains(@class,'x-grid3-row-table')]//span[contains(@class,'serv-value') and text()='"
						+ serviceStatus + "']"), WAIT_TIME_MIN);
	}
	
    public void uninstallService(String jobName) {
		
		karaf.karafAction("features:uninstall "+jobName+"", 5000);
		logger.info("**--**the "+jobName+" is unintall successful");
		
	}
    
 public void installJobServer(String jobName) {
		
		karaf.karafAction("features:install "+jobName+"", 5000);	
		logger.info("**--**the "+jobName+" is intall successful");
		
	}
    
    public void checkPortStatus() {
    	Assert.assertTrue(this.isElementPresent(By.xpath("//span[text()='Monitoring port:']//following-sibling::span//img[@title='This port is misconfigured or an other application uses it on server!']"), WAIT_TIME_MIN));
    	Assert.assertTrue(this.isElementPresent(By.xpath("//span[text()='Command port:']//following-sibling::span//img[@title='This port is misconfigured or an other application uses it on server!']"), WAIT_TIME_MIN));
    	Assert.assertTrue(this.isElementPresent(By.xpath("//span[text()='File transfert port: ']//following-sibling::span//img[@title='This port is misconfigured or an other application uses it on server!']"), WAIT_TIME_MIN));
    }
    
    public void editExistingServer(String serverName) {
    	String edit_part="_edit";
    	this.waitforElementDisplayed(By.xpath("//div[text()='"+serverName+"']"), WAIT_TIME_MIN);
//    	WebElement element=driver.findElement(By.xpath("//div[text()='"+serverName+"']"));
//    	this.moveToElement(element);
    	this.clickElementByXpath("//div[text()='"+serverName+"']");
    	this.typeTextByXpath("//span[text()='Execution server']//ancestor::legend//following-sibling::div//input[@name='label']", edit_part);
    	this.typeTextByXpath("//span[text()='Execution server']//ancestor::legend//following-sibling::div//label[text()='Description:']", edit_part);
    	this.getElementByName("host").clear();
    	this.typeTextByName("host", "192.168.0.169");
    	this.typeTextByName("username", "tadmin");
//    	this.waitforElementDisplayed(By.xpath("//input[@class=' x-form-field x-form-text ']"), 32);
//    	this.typeTextByXpath("//input[@class=' x-form-field x-form-text ']", "admin");    	
    	this.clickElementById("idFormSaveButton");
    	this.clickElementByXpath("//div[text()='Servers']//ancestor::div[@class=' x-panel-noborder x-panel x-component x-border-panel']//following-sibling::div[1]//button[text()='Refresh']");
		this.waitforElementDisplayed(By.xpath("//div[text()='" + serverName+edit_part + "']"),
				WAIT_TIME_MIN);		
    	
    }
    
    public void verifyEditedServer(String serverName) {
    	String edit_part="_edit";
    	Assert.assertTrue(this.getElementByXpath("//span[text()='Execution server']//ancestor::legend//following-sibling::div//input[@name='label']").getAttribute("value").equals(serverName+edit_part));
  //  	Assert.assertTrue(this.getElementByXpath("//span[text()='Execution server']//ancestor::legend//following-sibling::div//label[text()='Description:']").getAttribute("value").equals(edit_part));
    	Assert.assertTrue(this.getElementByName("host").getAttribute("value").equals("192.168.0.169"));
    	logger.info("---------commandPort:"+this.getElementByName("commandPort").getAttribute("value"));
    	Assert.assertTrue(this.getElementByName("commandPort").getAttribute("value").equals("8000"));
    	Assert.assertTrue(this.getElementByName("fileTransfertPort").getAttribute("value").equals("8001"));
    	Assert.assertTrue(this.getElementByName("monitoringPort").getAttribute("value").equals("8888"));
    	Assert.assertTrue(this.getElementByName("timeoutUnknownState").getAttribute("value").equals("120"));
    	Assert.assertTrue(this.getElementByName("username").getAttribute("value").equals("tadmin"));
  //  	Assert.assertTrue(this.getElementByXpath("//input[@name='password' and @class=' x-form-field x-form-text ']").getAttribute("value").equals("admin"));
    	Assert.assertTrue(this.getElementByName("mgmtServerPort").getAttribute("value").equals("44444"));
    	Assert.assertTrue(this.getElementByName("mgmtRegPort").getAttribute("value").equals("1099"));
    	logger.info("---------adminConsolePort:"+this.getElementByName("adminConsolePort").getAttribute("value"));
    	Assert.assertTrue(this.getElementByName("adminConsolePort").getAttribute("value").equals("8040"));
    	Assert.assertTrue(this.getElementByName("instance").getAttribute("value").equals("trun"));
    }
    
    public void checkSortAscendingSortDescending(String value, String value1) {
    	this.waitforElementDisplayed(By.xpath("//span[text()='Rate']//ancestor::td[contains(@class,'x-grid3-header x-grid3-hd x-grid3-cell x-grid3-td-ratedServer ')]//preceding-sibling::td//span[text()='Label']"), 30);
		WebElement element = driver.findElement(By.xpath("//span[text()='Rate']//ancestor::td[contains(@class,'x-grid3-header x-grid3-hd x-grid3-cell x-grid3-td-ratedServer ')]//preceding-sibling::td//span[text()='Label']"));
		this.moveToElement(element);
		WebElement drop = driver.findElement(By.xpath("//span[text()='Rate']//ancestor::td[contains(@class,'x-grid3-header x-grid3-hd x-grid3-cell x-grid3-td-ratedServer ')]//preceding-sibling::td//span[text()='Label']//preceding-sibling::a"));
		drop.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.clickElementByXpath("//a[text()='Sort Descending']");
		Assert.assertEquals(this.getElementByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-label']").getText(), value);       
       
		WebElement elementagain = driver.findElement(By.xpath("//span[text()='Rate']//ancestor::td[contains(@class,'x-grid3-header x-grid3-hd x-grid3-cell x-grid3-td-ratedServer ')]//preceding-sibling::td//span[text()='Label']"));
		this.moveToElement(elementagain);
		WebElement dropagain = driver.findElement(By.xpath("//span[text()='Rate']//ancestor::td[contains(@class,'x-grid3-header x-grid3-hd x-grid3-cell x-grid3-td-ratedServer ')]//preceding-sibling::td//span[text()='Label']//preceding-sibling::a"));
		dropagain.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        this.clickElementByXpath("//a[text()='Sort Ascending']");
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(this.getElementByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-label']").getText(), value1);
		
	}
}
