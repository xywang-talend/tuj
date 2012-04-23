package org.talend.mdm.impl;

import java.io.File;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.talend.mdm.Base;
import org.talend.mdm.modules.License;
import org.talend.mdm.modules.User;
import org.talend.mdm.modules.Welcome;
import org.testng.Assert;


public class WelcomeImpl extends Welcome{

	public WelcomeImpl(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}
	
	public void reSortWindows(){
		this.checkGetStartedWindow();
		this.reSortWindowLayout("xpath.ui.window.getstarted.title",500,500);
		this.checkAlertsWindow();
		this.reSortWindowLayout("xpath.ui.window.alerts.title",500,500);
		this.checkProcessWindow();
		this.reSortWindowLayout("xpath.ui.window.processes.title", -800, 500);
		this.checkSearchWindow();
		this.reSortWindowLayout("xpath.ui.window.search.title", -300, 200);
		this.checkTasksWindow();
	}
	
	public void openWorkFlowTaskFromWelcome(){
		this.checkTasksWindow();
		this.openTasks();
	}
}

