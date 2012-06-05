package org.talend.mdm.impl;

import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Welcome;

public class WelcomeImpl extends Welcome{

	public WelcomeImpl(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void reSortWindows(){
		this.checkGetStartedWindow();
		this.reSortWindowLayout("xpath.ui.window.getstarted.title","xpath.ui.window.search.title",0,20);
		this.checkAlertsWindow();
		this.reSortWindowLayout("xpath.ui.window.processes.title","xpath.ui.window.alerts.title", 0, 20);
		this.checkSearchWindow();
		this.reSortWindowLayout("xpath.ui.window.search.title", "xpath.ui.window.alerts.title", 0, 20);
		this.checkTasksWindow();
		this.reSortWindowLayout("xpath.ui.window.alerts.title", "xpath.ui.window.getstarted.title", 0,20);
		this.checkProcessWindow();
	}
	
	public void openWorkFlowTaskFromWelcome(){
		this.checkTasksWindow();
		this.openTasks();
	}
}

