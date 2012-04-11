package org.talend.mdm.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.talend.mdm.modules.DataSteward;
import org.talend.mdm.modules.User;
import org.testng.Assert;


public class DataStewardImpl extends DataSteward{

	public DataStewardImpl(WebDriver driver) {
		this.driver = driver;
	}
	
	public void createTaskWithTypeOfResolution(String taskName,String taskType,String source){
		this.openMenuGoven();
		this.openMenuDSC();
		this.sleepCertainTime(5000);
		this.switchDriver(driver.switchTo().frame("TDSCFrame"));
		this.clickAdminCreateTask();
		this.typeTaskName(taskName);
		this.typeTaskDefaultSourceName(source);
		this.selectTaskType(taskType);
		this.clickAddColumButton();
		this.sleepCertainTime(5000);
		this.typeColumFieldName("testtrtertertrtrtrt");
		this.sleepCertainTime(3000);
		this.clickSaveColumButton();
		this.sleepCertainTime(5000);
		
		
	}
}
