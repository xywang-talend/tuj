package org.talend.tac.modules;

import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.talend.tac.base.WebDriverBase;

import com.talend.tac.base.Base;

public class Authorization extends WebDriverBase {
//	@FindBy(how = How.ID, using = "!!!menu.projectsauthorizations.element!!!")
	
	
	public Authorization(WebDriver driver) {
		super.setDriver(driver);
		this.driver = driver;
	}
	public void gotoAuthorzationPage(){
//		WebElement authorization = driver.findElement(By.id("!!!menu.projectsauthorizations.element!!!"));
//		
//		authorization.click();
		
		getElementById("!!!menu.projectsauthorizations.element!!!").click();
		this.waitforTextDisplayed("PROJECTS AUTHORIZATIONS", this.WAIT_TIME_MAX);
		logger.info("Go to authorization page");
		
	}
	
	public void authorization(String userName, String project, String userInfo){
		WebElement user = getElementByXpath("//div[text()='"+userName+"']");
		WebElement projectUser = getElementByXpath("//span[text()='Projects']//ancestor::div[contains(@class,'x-small-editor x-panel-head')]//following-sibling::div//span[text()='"+project+"']");
		dragAndDrop(user, projectUser);
		Assert.assertTrue(this.isElementPresent(By.xpath("//span[text()='"+project+"']//ancestor::div[contains(@class,'x-tree3-node')]//following-sibling::div//span[contains(text(),'"+userInfo+"')]"), 10));
		logger.info("Authorization project - '" + project + "'  to user '"+ userName +"'");
	}

	
	public void reAuthorization(String userName, String project, String user_info){
		WebElement user = getElementByXpath("//div[text()='"+userName+"']");
		WebElement projectUser = getElementByXpath("//span[text()='"+project+"']");
		dragAndDrop(user, projectUser);		
		List l = this.getElementsByXpath("//span[text()='"+project+"']//ancestor::div[contains(@class,'x-tree3-el x-tree3-node-joint')]//following-sibling::div//span[contains(text(),'"+user_info+"')]");
		Assert.assertEquals(1, l.size());
		logger.info("Reauthorization project - '" + project + "'  to user '"+ userName +"'");
	}
	
	
	public void deleteAuthorization(String project, String lastName, String firstName){
		this.gotoAuthorzationPage();
		WebElement authorization = getElementByXpath("//span[contains(text(), '"+project+"')]//parent::div//parent::div//span[contains(text(), '"+lastName+", "+firstName+"')]");
		this.rightClick(authorization);
		getElementById("delete-item-author").click();
		logger.info("Authorization project - '" + project + "'  to lastName '"+ lastName +"', fisrtName '"+ firstName +"'");
	}
	
	public void setAuthorizationReadOnly(String project, String lastName, String firstName){
		this.gotoAuthorzationPage();
		WebElement authorization = getElementByXpath("//span[contains(text(), '"+project+"')]//parent::div//parent::div//span[contains(text(), '"+lastName+", "+firstName+"')]");
		this.rightClick(authorization);
		getElementById("tog-readonly-item").click();
		logger.info("Set project Authorization Read Only");
	}
	
	public void setAuthorizationReadAndWrite(String project, String lastName, String firstName){
		this.gotoAuthorzationPage();
		WebElement authorization = getElementByXpath("//span[contains(text(), '"+project+"')]//parent::div//parent::div//span/font[contains(text(), '"+lastName+", "+firstName+"')]");
		this.rightClick(authorization);
		getElementById("tog-readwrite-item").click();
		logger.info("Set project Authorization Read and Write");
	}
	
	
	public void resetColumn(){
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
