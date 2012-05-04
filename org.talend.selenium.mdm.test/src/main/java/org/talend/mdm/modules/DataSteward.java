package org.talend.mdm.modules;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.ExecuteMethod;
import org.talend.mdm.Base;
import org.talend.mdm.impl.LogonImpl;
import org.testng.Assert;

import com.thoughtworks.selenium.Selenium;


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
	
	public void clickTaskNavigatorAdministrationCreateTask() {
		this.clickElementByXpath("//span[contains(text(),'Task Navigator')]//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component')]//div[contains(@class,'x-icon-btn x-nodrag icon-reload x-component')]");
		this.waitfor(By.xpath(locator.getString("xpath.datatewardship.administration.createtask")), WAIT_TIME_MIN);
		logger.info("create task button xpath is :"+locator.getString("xpath.datatewardship.administration.createtask"));
		this.sleepCertainTime(5000);
		this.clickElementByXpath(locator.getString("xpath.datatewardship.administration.createtask"));
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.datatewardship.administration.createtask.panel.title")), WAIT_TIME_MIN)!=null,"open create task panel failed!");
	
	}
	
	public void clickTaskNavigatorAdministrationAssignTasks() {
		this.clickElementByXpath(locator.getString("xpath.datatewardship.administration.assigntasks"));
		logger.info("Task navigator Assigh tasks click ok.");
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.datatewardship.assigntasks.window.title")), WAIT_TIME_MIN).isDisplayed());
		logger.info("Task navigator Assign tasks click ok ,and assign task pannel opened ok.");
	}
	
	public void clickTaskNavigatorCommonNewTasks() {
		this.clickElementByXpath(locator
				.getString("xpath.datatewardship.common.newtasks"));
		logger.info("Task navigator New tasks click ok.");
	}

	public void clickTaskNavigatorCommonAllTasks() {
		this.clickElementByXpath(locator
				.getString("xpath.datatewardship.common.alltasks"));
		logger.info("Task navigator All tasks click ok.");
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
		logger.info("#########################################################################"+this.getElementsByXpath(locator.getString("xpath.datatewardship.administration.createtask.panel.taskschemadata.fieldname.input")).size());
		logger.info(this.driver.findElement(By.xpath(locator.getString("xpath.datatewardship.administration.createtask.panel.taskschemadata.fieldname.input"))).getAttribute("value"));
		
	}
	
	public void clickOKOnTaskSchemaCreatPanel(){
		this.clickElementByXpath(locator.getString("xpath.datatewardship.administration.createtask.panel.ok.button"));
		logger.info("click task schema creation pannel Ok button");
	}
	
    public void clickCANCELOnTaskSchemaCreatPanel(){
    	this.clickElementByXpath(locator.getString("xpath.datatewardship.administration.createtask.panel.cancel.button"));
		logger.info("click task schema creation pannel cancel button");
	}
    
    public void clickSaveOnTaskSchemaEditView(){
    	this.clickElementByXpath(locator.getString("xpath.datatewardship.taskschemaeditview.save.button"));
        logger.info("click save button on task schema edit view ok.");
    }
    
    public void checkTaskSchemaSaveSuccessAndClickOk(){
    	
    	this.waitfor(By.xpath(locator.getString("xpath.datatewardship.taskschemaeditview.save.success.info")), WAIT_TIME_MIN).isDisplayed();
    	logger.info("task schema saved ok promt appeared");
    	this.clickElementByXpath(locator.getString("xpath.datatewardship.taskschemaeditview.save.success.ok.button"));
    	logger.info("task schema saved ok button clicked.");
    }
    
    public void typeStringByRobot(String value){
    	for(int i = 0; i < value.length(); i++){
        char a =value.charAt(i);
        
        int b = a-32;
        try {
 		Robot r = new Robot();
 		r.keyPress(b);
 	} catch (AWTException e1) {
 		// TODO Auto-generated catch block
 		e1.printStackTrace();
 	}
    	}
    }
}
