/**
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements. See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership. The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied. See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.talend.tac.modules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.Locatable;
import org.talend.tac.base.WebDriverBase;

/**
 * 
 */
public class RedefineContext extends WebDriverBase {
	   
       public RedefineContext(WebDriver driver) {
           super.setDriver(driver);
           this.driver = driver;
       }
                 
       public void selectDropDownList(String name, String id, String value) {
    	   getElementByXpath("//label[text()='"+name+"']//following-sibling::div//input[@id='"+id+"']//following-sibling::div[contains(@class,'x-form-trigger x-form-trigger-arrow')]").click();
		   getElementByXpath("//div[text()='"+value+"']").click();
       }
      
       public void mouseDown(String xpathExpression) {
    	   Locatable hoverItem = (Locatable) driver.findElement(By.xpath(xpathExpression));
    	   Mouse mouse = ((HasInputDevices) driver).getMouse();
    	   mouse.mouseDown(hoverItem.getCoordinates());
    	   try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
       }
       
       public void intoESBConductorPage() {
           this.getElementById("!!!menu.esbconductor.element!!!").click();
           this.waitforTextDisplayed("ESB CONDUCTOR", WAIT_TIME_MAX);
       }
       
       public void addESBConductor(String label, String des, String repository,
                                   String group, String artifact, String version, String name, String type, 
                                   String context, String server) {
    	   this.getElementById("idESBConductorTaskGridAddButton").click();
           this.isElementPresent(By.xpath("//img[@class='gwt-Image" +
   				" x-component ']"), WAIT_TIME_MAX);
           this.typeTextById("idESBConductorTasklabelInput", label);
           this.typeTextById("idESBConductorTaskdesInput", des);
           this.getElementById("idESBConductorTaskSelectButton").click();
           this.isElementPresent(By.xpath("//span[text()='Select" +
   				" Feature from Talend repository']"), WAIT_TIME_MAX);
           this.waitforElementDisplayed(By.xpath("//label[text()='Repository:']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]"), WAIT_TIME_MAX);         
           getElementByXpath("//label[text()='Repository:']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]").click();
           this.waitforElementDisplayed(By.xpath("//div[text()='"+repository+"'and @role='listitem']"), WAIT_TIME_MAX);
           getElementByXpath("//div[text()='"+repository+"'and @role='listitem']").click();
   		   this.getElementByXpath("//span[text()='" + group + "']").click();
   		   this.getElementByXpath("//div[text()='" + artifact + "']")
   			   .click();
   		   this.getElementByXpath("//div[text()='" + version + "']").click();
   		   this.getElementByXpath("//button[text()='OK']").click();
           this.selectDropDownList("Name:","idTaskProjectListBox", name);
           this.selectDropDownList("Type:","idJobConductorExecutionServerListBox", type);
           this.selectDropDownList("Context:","idESBConductorTaskContextListBox", context);
           logger.info("select context");
           this.selectDropDownList("Server:","idJobConductorExecutionServerListBox", server);
           logger.info("select server");
           this.getElementById("idFormSaveButton").click();           
       }
       
       public void defineContext(String label,String variableName,String variableValue) {
    	   Robot bot;
		try {
		   bot = new Robot();
		   this.waitforElementDisplayed(By.xpath("//div[text()='" + label + "']"), WAIT_TIME_MIN);
		   this.mouseDown("//div[text()='" + label + "']");
		   this.waitforElementDisplayed(By.xpath("//button[@id='idESBConductorPropertyAddButton']"), WAIT_TIME_MIN);
		   this.getElementById("idESBConductorPropertyAddButton").click();
		 //  this.clickElementById(other.getString("ESBConductor.ConfigProperties.AddButtonId"));
    	   getElementByXpath(other.getString("ESBConductor.ConfigProperties.Name")).click();
    	   this.typeString(By.xpath("//span[text()='Name']//ancestor::div[@class='x-grid3-header']//following-sibling::div//input"), variableName, WAIT_TIME_MIN);
    	   getElementByXpath(other.getString("ESBConductor.ConfigProperties.Value")).click();
    	   this.typeString(By.xpath("//span[text()='Custom Value']//ancestor::div[@class='x-grid3-header']//following-sibling::div//input"), variableValue, WAIT_TIME_MIN);
    	   bot.keyPress(KeyEvent.VK_ENTER);
    	   bot.keyRelease(KeyEvent.VK_ENTER);    
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
		   this.mouseDown(other.getString("ESBConductor.ConfigProperties.Value"));
		   this.waitforElementDisplayed(By.xpath("//button[@id='idESBConductorPropertySaveButton']"), WAIT_TIME_MIN);
		   this.getElementById("idESBConductorPropertySaveButton").click();
	//	   this.clickElementById(other.getString("ESBConductor.ConfigProperties.SaveButtonId"));
		   Assert.assertTrue(this.isElementPresent(By.xpath("//div[text()='"+label+"']"), WAIT_TIME_MIN));
    	   
       }
       
       public void deployEsbConductor(String label,String name) {
           String status = "Deployed and started";
           String promptInfo = "Feature '" + name + "' deployed.";
           this.waitforElementDisplayed(By.xpath("//div[text()='" + label + "']"), WAIT_TIME_MIN);
           this.mouseDown("//div[text()='" + label + "']");
           this.waitforElementDisplayed(By.xpath("//button[@id='idESBConductorTaskGridDeployButton']"), WAIT_TIME_MIN);
		   this.getElementById("idESBConductorTaskGridDeployButton").click();
    //       this.clickElementById(other.getString("ESBConductor.DeployButtonId"));
           try {
			Thread.sleep(3000);
			logger.info("--------PromptInfo:"+promptInfo);
	        this.waitforTextDisplayed(promptInfo, WAIT_TIME_MIN);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
           Assert.assertTrue(this.isElementPresent(By.xpath("//div[text()='" + label + "']"
                   + "//ancestor::table[@class='x-grid3-row-table']//span[text()='" + status
                   + "']"), WAIT_TIME_MIN));
       }
       
       public void deleteContextPropertiesOk(String label) {
    	   this.waitforElementDisplayed(By.xpath("//div[text()='" + label + "']"), WAIT_TIME_MIN);
    	   this.mouseDown("//div[text()='" + label + "']");
    	   this.waitforElementDisplayed(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-property']"),WAIT_TIME_MIN);
    	   this.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-property']");
    	   this.getElementByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-property']").click();
    	   this.getElementByXpath(other.getString("ESBConductor.ConfigProperties.Name")).click();
           this.waitforElementDisplayed(By.xpath("//button[@id='idESBConductorPropertyDeleteButton']"), WAIT_TIME_MIN);
    	   this.getElementById("idESBConductorPropertyDeleteButton").click();
           this.acceptAlert(); 
       }
       
       public void undeployEsbConductorOk(String label) {
    	   String status="Undeployed";
    	   this.mouseDown("//div[text()='" + label + "']");
    	   this.waitforElementDisplayed(By.xpath("//button[@id='idESBConductorTaskGridUndeployButton']"), WAIT_TIME_MIN);
    	   this.getElementById("idESBConductorTaskGridUndeployButton").click();    	   
 //   	   this.clickElementById("idESBConductorTaskGridUndeployButton");
    	   this.acceptAlert();
    	   this.clickElementById(other.getString("ESBConductor.RefreshButtonId"));
    	   Assert.assertTrue(this.isElementPresent(By.xpath("//div[text()='" + label + "']"
                   + "//ancestor::table[@class='x-grid3-row-table']//span[text()='" + status
                   + "']"), WAIT_TIME_MIN));
       }
       
       public void deleteUndeployedConductorOk(String label,String name) {
    	   this.mouseDown("//div[text()='" + label + "']");
    	   this.waitforElementDisplayed(By.xpath("//button[@id='idESBConductorTaskGridDeleteButton']"), WAIT_TIME_MIN);
    	   this.getElementById("idESBConductorTaskGridDeleteButton").click();        	   
    //	   this.clickElementById(other.getString("ESBConductor.DeleteButtonId"));
    	   this.acceptAlert(); 	   
    	   logger.info("-------label:"+label);
           Assert.assertFalse(this.isElementPresent(By.xpath("//div[text()='" + label + "']"), 30));
       }
       
       public void deleteContextPropertyCancel(String label) {
    	   logger.info("^^^^^^^^^^^^^Label:"+label);
    	   this.waitforElementDisplayed(By.xpath("//div[text()='" + label + "']"), WAIT_TIME_MIN);
    	   this.mouseDown("//div[text()='" + label + "']");
    	   this.mouseDown("//span[text()='Custom Value']//ancestor::div[@class='x-grid3-header']//following-sibling::div//input");
    	   this.waitforElementDisplayed(By.xpath("//button[@id='idESBConductorPropertyDeleteButton']"), WAIT_TIME_MIN);
    	   this.getElementById("idESBConductorPropertyDeleteButton").click();
  //  	   this.clickElementById("idESBConductorPropertyDeleteButton");
           this.dismissAlert(); 
       }
    }
