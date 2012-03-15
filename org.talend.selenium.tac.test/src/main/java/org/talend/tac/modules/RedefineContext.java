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
       
       
       public void selectDropDownList(String name,String id, String value) {
    	   	   
    	   getElementByXpath("//label[text()='"+name+"']//following-sibling::div//input[@id='"+id+"']//following-sibling::div[contains(@class,'x-form-trigger x-form-trigger-arrow')]").click();
           getElementByXpath("//div[text()='"+value+"']").click();
   
       }
      
       public void mouseDown(String xpathExpression) {
    	   Locatable hoverItem = (Locatable) driver.findElement(By.xpath(xpathExpression));
    	   Mouse mouse = ((HasInputDevices) driver).getMouse();
    	   mouse.mouseDown(hoverItem.getCoordinates());
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
           this.selectDropDownList("Repository:","idTaskProjectListBox", repository);
           this.selectDropDownList("Group:","idTaskBranchListBox", group);
           this.selectDropDownList("Artifact:","idTaskApplicationListBox", artifact);
           this.selectDropDownList("Version:","idTaskVersionListBox", version);
           this.getElementByXpath("//span[text()='Select Feature from Talend repository']" +
				"//ancestor::div[@class=' x-window x-component']" +
				"//button[text()='OK']").click();
           this.selectDropDownList("Name:","idTaskProjectListBox", name);
           this.selectDropDownList("Type:","idJobConductorExecutionServerListBox", type);
           this.selectDropDownList("Context:","idESBConductorTaskContextListBox", context);
           this.selectDropDownList("Server:","idJobConductorExecutionServerListBox", server);
           this.getElementById("idFormSaveButton").click();           
       }
       
       public void defineContext(String label,String variableName,String variableValue) {
    	   Robot bot;
		try {
			
			bot = new Robot();
		    this.waitforElementDisplayed(By.xpath("//div[text()='" + label + "']"), WAIT_TIME_MAX);
		   this.mouseDown("//div[text()='" + label + "']");
    	   this.getElementById("idESBConductorPropertyAddButton").click();
    	   getElementByXpath(other.getString("ESBConductor.ConfigProperties.Name")).click();
    	   this.typeString(By.xpath("//span[text()='Name']//ancestor::div[@class='x-grid3-header']//following-sibling::div//input"), variableName, WAIT_TIME_MAX);
    	   getElementByXpath(other.getString("ESBConductor.ConfigProperties.Value")).click();
    	   this.typeString(By.xpath("//span[text()='Value']//ancestor::div[@class='x-grid3-header']//following-sibling::div//input"), variableValue, WAIT_TIME_MAX);
    	   bot.keyPress(KeyEvent.VK_ENTER);
    	   bot.keyRelease(KeyEvent.VK_ENTER);    
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
		   this.mouseDown(other.getString("ESBConductor.ConfigProperties.Value"));
		   this.clickElementById("idESBConductorPropertySaveButton");
		   Assert.assertTrue(this.isElementPresent(By.xpath("//div[text()='"+label+"']"), WAIT_TIME_MAX));
    	   
       }
       public void deployEsbConductor(String label,String name) {
           String status = "Deployed and started";
           String promptInfo = "Feature '" + name + "' deployed.";
           this.mouseDown("//div[text()='" + label + "']");
           this.clickElementById(other.getString("ESBConductor.DeployButtonID"));
           this.waitforTextDisplayed(promptInfo, WAIT_TIME_MAX);
           this.clickElementById(other.getString("ESBConductor.RefreshButtonId"));
           Assert.assertTrue(this.isElementPresent(By.xpath("//div[text()='" + label + "']"
                   + "//ancestor::table[@class='x-grid3-row-table']//span[text()='" + status
                   + "']"), WAIT_TIME_MAX));
       }
}
