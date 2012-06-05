package org.talend.mdm.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.DataSteward;
import org.testng.Assert;

public class DataStewardImpl extends DataSteward{
	public DataStewardImpl(WebDriver driver) {
		this.driver = driver;
	}
	
	public void createTaskWithTypeDefined(String taskName,String taskType,String source,String filedName1){
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
		this.sleepCertainTime(5000);
		this.clickSaveOnTaskSchemaEditView();
		this.checkTaskSchemaSaveSuccessAndClickOk();
		this.clickTaskNavigatorCommonNewTasks();
		Assert.assertTrue(this.getValue(this.waitfor(By.xpath(this.getString(locator, "xpath.datatewardshipconsole.tasks.list.byname.row.status", taskName)), WAIT_TIME_MIN)).equals("new"));
		Assert.assertTrue(this.getValue(this.waitfor(By.xpath(this.getString(locator, "xpath.datatewardshipconsole.tasks.list.byname.row.tasktype", taskName)), WAIT_TIME_MIN)).equals(taskType));
	}
	
	public void taskAssign(String taskName,String taskType,String source,String filedName1,String userAssighTo,String userPass,String userAdministrator,String userAdminpass){
		this.openMenuGoven();
		this.openMenuDSC();
		this.sleepCertainTime(5000);
		this.switchDriver(driver.switchTo().frame("TDSCFrame"));
		this.selectATaskByNameInCommonAlltasks(taskName);
		this.taskAssignToUser("user");
		this.driver.switchTo().defaultContent();
		LogonImpl log = new LogonImpl(this.driver);
		log.logout();
		log.loginUserForce("user", "user");
		this.openMenuGoven();
		this.openMenuDSC();
		this.sleepCertainTime(5000);
		this.switchDriver(driver.switchTo().frame("TDSCFrame"));
		this.selectATaskByNameInCommonAlltasks(taskName);
	}
	
}
