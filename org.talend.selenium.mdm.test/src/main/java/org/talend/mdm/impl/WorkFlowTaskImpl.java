package org.talend.mdm.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.talend.mdm.modules.DataSteward;
import org.talend.mdm.modules.User;
import org.talend.mdm.modules.WorkFlowTask;
import org.testng.Assert;


public class WorkFlowTaskImpl extends WorkFlowTask{

	public WorkFlowTaskImpl(WebDriver driver) {
		this.driver = driver;
	}
	
	
    public void changeProductPriceValidImpl(double d,double e){
    	double value = d*(1+e);
    	this.typeString(this.getElementByXpath("//label[text()='Price:']//ancestor::div[contains(@class,'x-form-item ')]//input"), value+"");
    	this.clickSubmit();
    	this.waitfor(By.xpath("//span[contains(text(),'Successfully submitted.')]"), WAIT_TIME_MID);
    	this.clickElementByXpath("//span[contains(text(),'Successfully submitted.')]//ancestor::div[contains(@class,'x-window-bwrap')]//button[text()='OK']");
    }
}
