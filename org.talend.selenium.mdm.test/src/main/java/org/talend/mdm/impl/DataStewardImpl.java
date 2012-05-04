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
	
	public void createTaskWithTypeOfResolution(String taskName,String taskType,String source,String filedName1){
		this.openMenuGoven();
		this.openMenuDSC();
		this.sleepCertainTime(5000);
		this.switchDriver(driver.switchTo().frame("TDSCFrame"));
		this.clickTaskNavigatorAdministrationCreateTask();
		this.typeTaskName(taskName);
		this.typeTaskDefaultSourceName(source);
		this.selectTaskType(taskType);
		this.clickAddColumButton();
		this.sleepCertainTime(2000);
		this.typeColumFieldName(filedName1);
		this.sleepCertainTime(2000);
		this.clickSaveColumButton();
		this.clickOKOnTaskSchemaCreatPanel();
		this.clickSaveOnTaskSchemaEditView();
		this.checkTaskSchemaSaveSuccessAndClickOk();
		this.clickTaskNavigatorCommonNewTasks();
		Assert.assertTrue(this.getValue(this.waitfor(By.xpath(this.getString(locator, "xpath.datatewardshipconsole.tasks.list.byname.row.status", taskName)), WAIT_TIME_MIN)).equals("new"));
		Assert.assertTrue(this.getValue(this.waitfor(By.xpath(this.getString(locator, "xpath.datatewardshipconsole.tasks.list.byname.row.tasktype", taskName)), WAIT_TIME_MIN)).equals(taskType));
	}
}
