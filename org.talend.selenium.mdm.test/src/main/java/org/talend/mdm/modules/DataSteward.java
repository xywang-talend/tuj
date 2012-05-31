package org.talend.mdm.modules;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.talend.mdm.Base;
import org.testng.Assert;

public class DataSteward extends Base{
	public void switchDriver(WebDriver dri){
		this.driver=dri;
	}
	
	public void openMenuGoven() {
		this.waitfor(By.xpath(locator.getString("xpath.menu.goven")), WAIT_TIME_MIN);
		this.clickElementByXpath(locator.getString("xpath.menu.goven"));
	}

	public void openMenuDSC() {
		this.waitfor(By.id(locator.getString("id.menu.datastewardship")), WAIT_TIME_MIN);
		this.clickElementById(locator.getString("id.menu.datastewardship"));
	}
	
	public void selectATaskByNameInCommonAlltasks(String taskName){
		this.clickTaskNavigatorCommonAllTasks();
		this.clickElementByXpath(this.getString(locator,"xpath.datatewardshipconsole.tasks.list.byname.row",taskName));
	}
	
	public void taskAssignToUser(String userName){
		this.clickTaskNavigatorAdministrationAssignTasks();
	    this.clickElementByXpath("//div[contains(@class,'x-view x-component')]//td[contains(text(),'user')]//ancestor::tr//input[contains(@class,'x-view-item-checkbox')]");
	    this.clickElementByXpath("//div[contains(@class,'x-view x-component')]//ancestor::div[contains(@class,'x-window-bwrap')]//button[contains(text(),'Ok')]");
	}
	
	public void clickTaskNavigatorAdministrationCreateTask() {
		this.clickElementByXpath("//span[contains(text(),'Task Navigator')]//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component')]//div[contains(@class,'x-icon-btn x-nodrag icon-reload x-component')]");
		this.waitfor(By.xpath(locator.getString("xpath.datatewardship.administration.createtask")), WAIT_TIME_MIN);
		logger.warn("create task button xpath is :"+locator.getString("xpath.datatewardship.administration.createtask"));
		this.sleepCertainTime(5000);
		this.clickElementByXpath(locator.getString("xpath.datatewardship.administration.createtask"));
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.datatewardship.administration.createtask.panel.title")), WAIT_TIME_MIN)!=null,"open create task panel failed!");
	}
	
	public void clickTaskNavigatorAdministrationAssignTasks() {
		this.clickElementByXpath(locator.getString("xpath.datatewardship.administration.assigntasks"));
		logger.warn("Task navigator Assigh tasks click ok.");
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.datatewardship.assigntasks.window.title")), WAIT_TIME_MIN).isDisplayed());
		logger.warn("Task navigator Assign tasks click ok ,and assign task pannel opened ok.");
	}
	
	public void clickTaskNavigatorCommonNewTasks() {
		this.clickElementByXpath(locator
				.getString("xpath.datatewardship.common.newtasks"));
		logger.warn("Task navigator New tasks click ok.");
	}

	public void clickTaskNavigatorCommonAllTasks() {
		this.clickElementByXpath(locator
				.getString("xpath.datatewardship.common.alltasks"));
		logger.warn("Task navigator All tasks click ok.");
	}
	
	public void typeTaskName(String taskName){
		this.typeString(this.getElementByXpath(locator.getString("xpath.datatewardship.administration.createtask.panel.taskproperties.taskname.input")), taskName);
	}
	
	public void typeTaskDefaultSourceName(String source){
		this.typeString(this.getElementByXpath(locator.getString("xpath.datatewardship.administration.createtask.panel.taskproperties.sourcename.input")), source);
	}
	
	public void selectTaskType(String taskType){
		this.seletDropDownList(By.xpath(locator.getString("xpath.datatewardship.administration.createtask.panel.taskproperties.tasktype.arrow")), taskType);
	}
	
	public void clickAddColumButton(){
		this.clickElementByXpath(locator.getString("xpath.datatewardship.administration.createtask.panel.add.button"));
	}
	
    public void clickSaveColumButton(){
		this.clickElementByXpath(locator.getString("xpath.datatewardship.administration.createtask.panel.taskschemadata.save.button"));
	}
	
    public void keyBoardTypeString(int key){
        Robot a;
    		try {
    			a = new Robot();
    			 a.keyPress(key);
    		} catch (AWTException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
    }
	public void typeColumFieldName(String fieldName){
		Assert.assertTrue(this.driver.findElement(By.xpath(locator.getString("xpath.datatewardship.administration.createtask.panel.taskschemadata.fieldname.input"))).isEnabled());
		
		WebElement e = this.driver.findElement(By.xpath("//span[contains(@class,'x-fieldset-header-text') and text()='Task properties']//ancestor::fieldset[contains(@class,'x-fieldset x-component')]//label[contains(text(),'Task Name:')]//ancestor::div[contains(@class,'x-window-mr')]//div[contains(@class,'x-row-editor-body x-box-layout-ct')]//div[contains(@class,'x-form-field-wrap  x-row-editor-field x-component x-box-item') and contains(@gxt-dindex,'name')]"));

		(new Actions(driver)).click(e);
        this.typeStringByRobot(fieldName);
		logger.warn("-----------------------"+this.getElementsByXpath(locator.getString("xpath.datatewardship.administration.createtask.panel.taskschemadata.fieldname.input")).size());
		logger.warn(this.driver.findElement(By.xpath(locator.getString("xpath.datatewardship.administration.createtask.panel.taskschemadata.fieldname.input"))).getAttribute("value"));
	}
	
	public void clickOKOnTaskSchemaCreatPanel(){
		this.clickElementByXpath(locator.getString("xpath.datatewardship.administration.createtask.panel.ok.button"));
		logger.warn("click task schema creation pannel Ok button");
	}
	
    public void clickCANCELOnTaskSchemaCreatPanel(){
    	this.clickElementByXpath(locator.getString("xpath.datatewardship.administration.createtask.panel.cancel.button"));
		logger.warn("click task schema creation pannel cancel button");
	}
    
    public void clickSaveOnTaskSchemaEditView(){
    	this.sleepCertainTime(5000);
    	this.clickElementByXpath(locator.getString("xpath.datatewardship.taskschemaeditview.save.button"));
        logger.warn("click save button on task schema edit view ok.");
    }
    
    public void checkTaskSchemaSaveSuccessAndClickOk(){
    	this.waitfor(By.xpath(locator.getString("xpath.datatewardship.taskschemaeditview.save.success.info")), WAIT_TIME_MIN).isDisplayed();
    	logger.warn("task schema saved ok promt appeared");
    	this.clickElementByXpath(locator.getString("xpath.datatewardship.taskschemaeditview.save.success.ok.button"));
    	logger.warn("task schema saved ok button clicked.");
    }
    
    public void typeStringByRobot(String value){
    	for(int i = 0; i < value.length(); i++){
    		char a =value.charAt(i);
        
    		int b = a-32;
	        try {
	        	Robot r = new Robot();
	        	r.keyPress(b);
	        	r.keyRelease(b);
	        } catch (AWTException e1) {
	 		// TODO Auto-generated catch block
	        	e1.printStackTrace();
	        }
    	}
    }
}
