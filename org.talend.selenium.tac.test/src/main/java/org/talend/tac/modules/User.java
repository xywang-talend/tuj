package org.talend.tac.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.tac.base.WebDriverBase;
import org.testng.Assert;

public class User extends WebDriverBase {
	
	
	protected User(WebDriver driver) {
		
		setDriver(driver);
		this.driver = driver;
		
	}    
	
	protected void gotoUserPage() {
		
		logger.info("click user button");
		this.getElementById("idMenuUserElement").click();
		logger.info("check whether into user page");
		Assert.assertTrue(this.isElementPresent(By.xpath("//div[@class='header-title' and text()='Users']"), WAIT_TIME_MIN));
		Assert.assertTrue(this.isTextPresent("admin@company.com"));

	}
	
	protected void addUser(String user, String firstName, String lastName, String passWord
			, String svnLogin, String svnPassWord, String typeName, String role) {
		
		logger.info("click add button");
		this.getElementById("idSubModuleAddButton").click();
		logger.info("check panel editable of add user panel ");
	    Assert.assertTrue(this.isElementPresent(By.xpath("//img[@class='gwt-Image x-component ']"), WAIT_TIME_MIN));		
		this.waitforElementDisplayed(By.id("idUserLoginInput"), WAIT_TIME_MIN);
	    logger.info("enter loginname");
	    this.typeTextById("idUserLoginInput", user);
	    logger.info("enter firstname");
		this.typeTextById("idUserFirstNameInput", firstName);
		logger.info("enter lastname");
		this.typeTextById("idUserLastNameInput", lastName);
		logger.info("enter password");
		this.typeTextById("idUserPasswordInput", passWord);
		logger.info("enter svnlogin");
		this.typeTextById("idSvnLogin", svnLogin);
		logger.info("enter svnpassword");
		this.typeTextById("idSvnPwd", svnPassWord);		
		
		logger.info("select an type");
	    if(this.isElementPresent(By.xpath("//input[@id='idTypeInput']//following-sibling::div"), 5)) {
	    	
			logger.info("select an type "+typeName+"");
	    	this.selectDropDownList("idTypeInput", typeName);
			
	    }
		
		logger.info("select role");
	    this.getElementById("idRoleButton").click();
		Assert.assertTrue(this.isTextPresent(rb.getString("user.roles.title")));
		logger.info("select an role");
		this.getElementByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-name' and (text()='"+role+"')]").click();
		logger.info("click ok");
		this.getElementById("idValidateButton").click();
        this.waitElement(2000);
        logger.info("click save");
		this.getElementById("idFormSaveButton").click();
		logger.info("check user ");
		this.isElementPresent(By.xpath("//div[text()='"+user+"']"),WAIT_TIME_MIN);
		Assert.assertTrue(this.isElementPresent(By.xpath("//div[text()='"+user+"']"), WAIT_TIME_MIN));
	    Assert.assertTrue(this.isElementPresent(By.xpath("//div[text()='"+user+"']//ancestor::tbody[@role='presentation']//img[@title='"+typeName+"']"), WAIT_TIME_MIN));
	    
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
