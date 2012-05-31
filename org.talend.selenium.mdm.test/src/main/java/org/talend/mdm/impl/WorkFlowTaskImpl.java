package org.talend.mdm.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.WorkFlowTask;

public class WorkFlowTaskImpl extends WorkFlowTask{

	public WorkFlowTaskImpl(WebDriver driver) {
		this.driver = driver;
	}
	
    public String changeProductPriceValidImpl(double d,double e){
    	double value = d*(1+e-0.05);
    	this.typeString(this.getElementByXpath("//label[text()='Price:']//ancestor::div[contains(@class,'x-form-item ')]//input"), value+"");
    	String submited = this.getValueInput(By.xpath("//label[text()='Price:']//ancestor::div[contains(@class,'x-form-item ')]//input"));
    	this.clickSubmit();
    	this.waitfor(By.xpath("//span[contains(text(),'Successfully submitted.')]"), WAIT_TIME_MID);
    	this.clickElementByXpath("//span[contains(text(),'Successfully submitted.')]//ancestor::div[contains(@class,'x-window-bwrap')]//button[text()='OK']");
        return submited.substring(0,5);
    }
    
    public String changeAgentCommissionCodeValidImpl(int initialCode,int step){
    	int code = initialCode+step;
    	this.seletDropDownList(By.xpath(locator.getString("xpath.record.agent.comchangeworkflow.taskopened.commissioncode.dropdownlist.arrow")), code+"");
    	this.clickSubmit();
    	this.waitfor(By.xpath("//span[contains(text(),'Successfully submitted.')]"), WAIT_TIME_MID);
    	this.clickElementByXpath("//span[contains(text(),'Successfully submitted.')]//ancestor::div[contains(@class,'x-window-bwrap')]//button[text()='OK']");
    	return code+"";
    }
    
    public String changeProductPriceInvalidImpl(double d,double e){
    	double value = d*(1+e+0.15);
    	this.typeString(this.getElementByXpath("//label[text()='Price:']//ancestor::div[contains(@class,'x-form-item ')]//input"), value+"");
    	String submited = this.getValueInput(By.xpath("//label[text()='Price:']//ancestor::div[contains(@class,'x-form-item ')]//input"));
    	this.clickSubmit();
    	this.waitfor(By.xpath("//span[contains(text(),'Successfully submitted.')]"), WAIT_TIME_MID);
    	this.clickElementByXpath("//span[contains(text(),'Successfully submitted.')]//ancestor::div[contains(@class,'x-window-bwrap')]//button[text()='OK']");
        return submited.substring(0,5);
    }
}
