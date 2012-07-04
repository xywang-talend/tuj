package com.talend.cases.dashboard.jobsAnalyses;

import static org.testng.Assert.*;

import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class TestJobAnalyses extends Login {

	@Test
	@Parameters({"mysqlConnectionlabel"})
	public void testJobAnalysesWithMYSQL(String connection) {
		this.clickWaitForElementPresent("!!!menu.dashjobs.element!!!");
		//wait and select the first "connection"
		this.waitForElementPresent("//label[text()='Active connection:']/following-sibling::div//input",WAIT_TIME);
	    selenium.click("//label[text()='Active connection:']/following-sibling::div//input");
		
		boolean flag = false;
		int i = 0;
		while(i <10 && flag == false){
			
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selenium.click("//label[text()='Active connection:']/following-sibling::div//input");
			flag = 
				selenium.isElementPresent("//div[contains(@class,'x-combo-list-item') and contains(text(),'"+connection+"')]");
			System.out.println(">>>"+i+flag);
		}	
		
		this.mouseDownWaitForElementPresent("//div[contains(@class,'x-combo-list-item') and contains(text(),'"+connection+"')]", WAIT_TIME);
		this.waitForElementPresent("//img[@title='Ok']", WAIT_TIME);
		//select a connection and simulate a click
		this.sleep(3000);
		selenium.mouseDown("//img[@title='Ok']/ancestor::table");
		//not less than one "Ok"s are displayed
		this.sleep(5000);
		assertTrue(selenium.getXpathCount("//img[@title='Ok']").intValue() > 1);
		//System.out.println(selenium.getXpathCount("//img[@title='Ok']"));
	}
	
	
	@Test
	@Parameters({"mssqlConnectionlabel"})
	public void testJobAnalysesWithMSSQL(String connection) {
		this.clickWaitForElementPresent("!!!menu.dashjobs.element!!!");
		//wait and select the first "connection"
		this.waitForElementPresent("//label[text()='Active connection:']/following-sibling::div//input",WAIT_TIME);
	    selenium.click("//label[text()='Active connection:']/following-sibling::div//input");
	    
	    boolean flag = false;
		int i = 0;
		while(i <10 && flag == false){
			
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selenium.click("//label[text()='Active connection:']/following-sibling::div//input");
			flag = 
				selenium.isElementPresent("//div[contains(@class,'x-combo-list-item') and contains(text(),'"+connection+"')]");
			System.out.println(">>>"+i+flag);
		}	
		
		this.mouseDownWaitForElementPresent("//div[contains(@class,'x-combo-list-item') and contains(text(),'"+connection+"')]", WAIT_TIME);
		this.waitForElementPresent("//img[@title='Ok']", WAIT_TIME);
		//select a connection and simulate a click
		this.sleep(3000);
		selenium.mouseDown("//img[@title='Ok']/ancestor::table");
		//not less than one "Ok"s are displayed
		this.sleep(5000);
		assertTrue(selenium.getXpathCount("//img[@title='Ok']").intValue() > 1);
		//System.out.println(selenium.getXpathCount("//img[@title='Ok']"));
	}
	
	@Test
	@Parameters({"oracleConnectionlabel"})
	public void testJobAnalysesWithORACLE(String connection) {	
		this.clickWaitForElementPresent("!!!menu.dashjobs.element!!!");
		//wait and select the first "connection"
		this.waitForElementPresent("//label[text()='Active connection:']/following-sibling::div//input",WAIT_TIME);
	    selenium.click("//label[text()='Active connection:']/following-sibling::div//input");
		
		boolean flag = false;
		int i = 0;
		while(i <10 && flag == false){
			
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selenium.click("//label[text()='Active connection:']/following-sibling::div//input");
			flag = 
				selenium.isElementPresent("//div[contains(@class,'x-combo-list-item') and contains(text(),'"+connection+"')]");
			System.out.println(">>>"+i+flag);
		}	
		
		this.mouseDownWaitForElementPresent("//div[contains(@class,'x-combo-list-item') and contains(text(),'"+connection+"')]", WAIT_TIME);
		this.sleep(3000);
		this.waitForElementPresent("//img[@title='Ok']", WAIT_TIME);
		//select a connection and simulate a click
		selenium.mouseDown("//img[@title='Ok']/ancestor::table");
		//not less than one "Ok"s are displayed
		this.sleep(5000);
		assertTrue(selenium.getXpathCount("//img[@title='Ok']").intValue() > 1);
		//System.out.println(selenium.getXpathCount("//img[@title='Ok']"));
	}
	
	@Test
	@Parameters({"mysqlConnectionlabel"})
	public void testDeleteConnectionUsedByJobAnalyses(String connection) {
		String warningmessage = other.getString("delete.connetion.warning");
		String warningmessage1 =  "Delete Faild: Cannot delete connection \""+connection+"\" because it's active for at least one user -- For more information see your log file";
		
		this.clickWaitForElementPresent("!!!menu.dashjobs.element!!!");
		//wait and select the first "connection"
		this.waitForElementPresent("//label[text()='Active connection:']/following-sibling::div//input",WAIT_TIME);
		selenium.click("//label[text()='Active connection:']/following-sibling::div//input");
		
		boolean flag = false;
		int i = 0;
		while(i <10 && flag == false){
			
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selenium.click("//label[text()='Active connection:']/following-sibling::div//input");
			flag = 
				selenium.isElementPresent("//div[contains(@class,'x-combo-list-item') and contains(text(),'"+connection+"')]");
			System.out.println(">>>"+i+flag);
		}	
		
		this.mouseDownWaitForElementPresent("//div[contains(@class,'x-combo-list-item') and contains(text(),'"+connection+"')]");
		this.waitForElementPresent("//img[@title='Ok']", WAIT_TIME);
		//select a connection and simulate a click
		this.sleep(3000);
		selenium.mouseDown("//img[@title='Ok']/ancestor::table");
		//not less than one "Ok"s are displayed
		this.sleep(5000);
		assertTrue(selenium.getXpathCount("//img[@title='Ok']").intValue() > 1);
		//System.out.println(selenium.getXpathCount("//img[@title='Ok']"));
		this.clickWaitForElementPresent("!!!menu.connections.element!!!");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+connection+"')]", Base.WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and contains(text(),'"+connection+"')]");
		selenium.chooseOkOnNextConfirmation();
		selenium.click("//div[text()='Connections']/ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleDeleteButton']");
		selenium.getConfirmation();
//		assertTrue(this.waitForTextPresent(warningmessage1, WAIT_TIME));
		this.waitForTextPresent(warningmessage1, WAIT_TIME);
		Assert.assertTrue(selenium.isTextPresent(warningmessage1));
		selenium.refresh();
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and contains(text(),'"+connection+"')]", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		
		
	}
}