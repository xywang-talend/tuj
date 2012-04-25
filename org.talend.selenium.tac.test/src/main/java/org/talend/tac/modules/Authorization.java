package org.talend.tac.modules;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.talend.tac.base.WebDriverBase;
import org.testng.Assert;

public class Authorization extends WebDriverBase {
//	@FindBy(how = How.ID, using = "!!!menu.projectsauthorizations.element!!!")
	
	
	protected Authorization(WebDriver driver) {
		super.setDriver(driver);
		this.driver = driver;
	}
	protected void gotoAuthorzationPage(){
		logger.info("click 'project authoraizations' button");
		getElementById("!!!menu.projectsauthorizations.element!!!").click();
		logger.info("check whether into page");
		this.waitforTextDisplayed("PROJECTS AUTHORIZATIONS", WAIT_TIME_MIN);
		logger.info("Go to authorization page");
		
	}
	
	protected void authorization(String userName, String project, String userInfo){
		logger.info("get user+"+"//span[text()='Users']//ancestor::div[contains(@class,'x-small-editor x-panel-header x-component x-unselectable')]//following-sibling::div//div[text()='"+userName+"']");
		WebElement user = getElementByXpath("//span[text()='Users']//ancestor::div[contains(@class,'x-small-editor x-panel-header x-component x-unselectable')]//following-sibling::div//div[text()='"+userName+"']");
		logger.info("get project+"+"//span[text()='Projects']//ancestor::div[contains(@class,'x-small-editor x-panel-head')]//following-sibling::div//span[text()='"+project+"']");
		WebElement projectUser = getElementByXpath("//span[text()='Projects']//ancestor::div[contains(@class,'x-small-editor x-panel-head')]//following-sibling::div//span[text()='"+project+"']");
		logger.info("drap in progress");
		dragAndDrop(user, projectUser);
		logger.info("check authorization result");
		Assert.assertTrue(this.isElementPresent(By.xpath("//span[text()='"+project+"']//ancestor::div[contains(@class,'x-tree3-node')]//following-sibling::div//span[contains(text(),'"+userInfo+"')]"), WAIT_TIME_MIN));
		logger.info("Authorization project - '" + project + "'  to user '"+ userName +"'");
	}

	
	protected void reAuthorization(String userName, String project, String userInfo){
		logger.info("get user");
		WebElement user = getElementByXpath("//span[text()='Users']//ancestor::div[contains(@class,'x-small-editor x-panel-header x-component x-unselectable')]//following-sibling::div//div[text()='"+userName+"']");
		logger.info("get project");
		WebElement projectUser = getElementByXpath("//span[text()='"+project+"']");
		logger.info("drap in progress");
		dragAndDrop(user, projectUser);	
		this.clickElementById("idConfigRefreshButton");
		this.isElementPresent(By.xpath("//span[text()='"+project+"']//ancestor::div[contains(@class,'x-tree3-el x-tree3-node-joint')]//following-sibling::div//span[contains(text(),'"+userInfo+"')]"), WAIT_TIME_MIN);
		logger.info("check authorization result");
		List l = this.getElementsByXpath("//span[text()='"+project+"']//ancestor::div[contains(@class,'x-tree3-el x-tree3-node-joint')]//following-sibling::div//span[contains(text(),'"+userInfo+"')]");
		Assert.assertEquals(1, l.size());
		logger.info("Reauthorization project - '" + project + "'  to user '"+ userName +"'");
	}
	
	
	protected void deleteAuthorization(String project, String lastName, String firstName, String userInfo){
		logger.info("get authorization user");
		WebElement authorization = getElementByXpath("//span[contains(text(), '"+project+"')]//parent::div//parent::div//span[contains(text(), '"+lastName+", "+firstName+"')]");
		logger.info("rigth click");
		this.rightClick(authorization);
		logger.info("click delete author");
		getElementById("delete-item-author").click();
		logger.info("check result of delete author");
		Assert.assertFalse(this.isElementPresent(By.xpath("//span[text()='"+project+"']//ancestor::div[contains(@class,'x-tree3-node')]//following-sibling::div//span[contains(text(),'"+userInfo+"')]"), 5));
	}
	
	protected void setAuthorizationReadOnly(String project, String lastName, String firstName, String userInfo){
		logger.info("get authorization user");
		WebElement authorization = getElementByXpath("//span[contains(text(), '"+project+"')]//parent::div//parent::div//span[contains(text(), '"+lastName+", "+firstName+"')]");
		logger.info("rigth click");
		this.rightClick(authorization);
		logger.info("click 'readonly' button");
		getElementById("tog-readonly-item").click();
		logger.info("Set project Authorization Read Only");
		Assert.assertTrue(this.isElementPresent(By.xpath("//span[text()='"+project+"']//ancestor::div[contains(@class,'x-tree3-node')]//following-sibling::div//font[contains(text(),'"+userInfo+"')]"), WAIT_TIME_MIN));
	}
	
	protected void setAuthorizationReadAndWrite(String project, String lastName, String firstName, String userReadwriteInfo){
		this.gotoAuthorzationPage();
		WebElement authorization = getElementByXpath("//span[contains(text(), '"+project+"')]//parent::div//parent::div//span/font[contains(text(), '"+lastName+", "+firstName+"')]");
		this.rightClick(authorization);
		getElementById("tog-readwrite-item").click();
		logger.info("Set project Authorization Read and Write");
		Assert.assertTrue(this.isElementPresent(By.xpath("//span[text()='"+project+"']//ancestor::div[contains(@class,'x-tree3-node')]//following-sibling::div//span[contains(text(),'"+userReadwriteInfo+"')]"), WAIT_TIME_MIN));
	}
	
	
	protected void resetColumn(){
		this.waitforElementDisplayed(getElementByXpath("//div[text()='admin@company.com']"), 2000);
		WebElement item = getElementByXpath("//div[text()='admin@company.com']");
		Point p = item.getLocation();
		int x = p.getX();
		int y = p.getY();
		System.out.println("x-" + x + ",y-" + y);
		new Actions(driver).clickAndHold(item).moveByOffset(100, 0).perform();
		logger.info("Set project Authorization dragAndDropByOnHold");
	}
	
}
