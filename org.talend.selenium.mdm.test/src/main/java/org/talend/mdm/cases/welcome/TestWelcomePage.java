package org.talend.mdm.cases.welcome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.talend.mdm.Login;
import org.talend.mdm.impl.LicenseImpl;
import org.talend.mdm.impl.LogonImpl;
import org.talend.mdm.impl.UserImpl;
import org.talend.mdm.impl.WelcomeImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestWelcomePage extends Login {
	WelcomeImpl welcom;
	@BeforeMethod
	public void beforeMethod(){
		welcom = new WelcomeImpl(driver);
	}
		
	
	@Test
	public void testWelcomLayoutResort() {
	welcom.reSortWindows();
	}
	
}
