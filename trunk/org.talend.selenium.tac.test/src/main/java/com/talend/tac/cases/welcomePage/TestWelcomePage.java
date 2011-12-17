package com.talend.tac.cases.welcomePage;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import com.talend.tac.cases.Login;

public class TestWelcomePage extends Login {
	@Test
	public void testAccessFromWelcomePage() {
		AccessProcessInWelcomePage("Users");
		AccessProcessInWelcomePage("Projects");
		AccessProcessInWelcomePage("Projects authorizations");
		AccessProcessInWelcomePage("Projects references");
		AccessProcessInWelcomePage("License");
		AccessProcessInWelcomePage("Configuration");
		AccessProcessInWelcomePage_Group("User settings");

	}

	public void AccessProcessInWelcomePage(String locatorText) {
		this.waitForElementPresent("//div[text()='" + locatorText + "']",WAIT_TIME);
		selenium.click("//div[text()='" + locatorText + "']");
		assertTrue(selenium.getXpathCount("//div[text()='" + locatorText + "']").intValue() == 2);
		selenium.click("//span[text()='Welcome']");
		this.clickWaitForElementPresent("//span[text()='"+locatorText +"']//ancestor::a/preceding-sibling::a");
	}

	public void AccessProcessInWelcomePage_Group(String locatorText) {
		this.waitForElementPresent("//span[contains(text(),'"+ locatorText + "')]",WAIT_TIME);
		selenium.click("//span[contains(text(),'"+ locatorText + "')]");
		assertTrue(selenium.getXpathCount("//span[contains(text(),'"+ locatorText + "')]").intValue() == 3);
		selenium.click("//span[text()='Welcome']");
		this.clickWaitForElementPresent("//span[contains(text(),'" +locatorText +"')]//ancestor::a/preceding-sibling::a");
	}
	//Francais 
	@Test
	public void testInternationalization() {
		//to Francis 
		this.clickWaitForElementPresent("idLeftMenuTreeLangButton");
		this.clickWaitForElementPresent("//a[text()='Francais']");
		this.waitForElementPresent("//span[text()='Utilisateurs']", WAIT_TIME);
		this.clickWaitForElementPresent("idLeftMenuTreeLogoutButton");
		this.clickWaitForElementPresent("idLoginButton");
		this.waitForElementPresent("//span[text()='Utilisateurs']", WAIT_TIME);
		//trun back to English 
		this.clickWaitForElementPresent("idLeftMenuTreeLangButton");
		this.clickWaitForElementPresent("//a[text()='English']");
		this.waitForElementPresent("//span[text()='Users']", WAIT_TIME);
		
		
	}
}
