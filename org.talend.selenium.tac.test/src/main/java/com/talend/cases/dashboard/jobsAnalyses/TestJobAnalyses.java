package com.talend.cases.dashboard.jobsAnalyses;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class TestJobAnalyses extends Login {

	@Test
	@Parameters({"Mysql_Connectionlabel"})
	public void testJobAnalysesWithMYSQL(String connection) {
		this.clickWaitForElementPresent("!!!menu.dashjobs.element!!!");
		//wait and select the first "connection"
		this.waitForElementPresent("//label[text()='Active connection:']/following-sibling::div//input",WAIT_TIME);
	    selenium.click("//label[text()='Active connection:']/following-sibling::div//input/following-sibling::div");
		
		boolean flag = false;
		int i = 0;
		while(i <5 && flag == false){
			
			i++;
			selenium.click("//label[text()='Active connection:']/following-sibling::div//input/following-sibling::div");
			flag = selenium.isElementPresent("//div[contains(@class,'x-combo-list-item') and text()=' "+connection+"']");
			
		}
		
		this.mouseDownWaitForElementPresent("//div[contains(@class,'x-combo-list-item') and text()=' "+connection+"']", WAIT_TIME);
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
	@Parameters({"MSSQL_Connectionlabel"})
	public void testJobAnalysesWithMSSQL(String connection) {
		this.clickWaitForElementPresent("!!!menu.dashjobs.element!!!");
		//wait and select the first "connection"
		this.waitForElementPresent("//label[text()='Active connection:']/following-sibling::div//input",WAIT_TIME);
	    selenium.click("//label[text()='Active connection:']/following-sibling::div//input/following-sibling::div");
		
		boolean flag = false;
		int i = 0;
		while(i <5 && flag == false){
			
			i++;
			selenium.click("//label[text()='Active connection:']/following-sibling::div//input/following-sibling::div");
			flag = selenium.isElementPresent("//div[contains(@class,'x-combo-list-item') and text()=' "+connection+"']");
			
		}
		
		this.mouseDownWaitForElementPresent("//div[contains(@class,'x-combo-list-item') and text()=' "+connection+"']", WAIT_TIME);
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
	@Parameters({"Oracle_Connectionlabel"})
	public void testJobAnalysesWithORACLE(String connection) {	
		this.clickWaitForElementPresent("!!!menu.dashjobs.element!!!");
		//wait and select the first "connection"
		this.waitForElementPresent("//label[text()='Active connection:']/following-sibling::div//input",WAIT_TIME);
	    selenium.click("//label[text()='Active connection:']/following-sibling::div//input/following-sibling::div");
		
		boolean flag = false;
		int i = 0;
		while(i <5 && flag == false){
			
			i++;
			selenium.click("//label[text()='Active connection:']/following-sibling::div//input/following-sibling::div");
			flag = selenium.isElementPresent("//div[contains(@class,'x-combo-list-item') and text()=' "+connection+"']");
			
		}
		
		this.mouseDownWaitForElementPresent("//div[contains(@class,'x-combo-list-item') and text()=' "+connection+"']", WAIT_TIME);
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
	@Parameters({"Mysql_Connectionlabel"})
	public void testDeleteConnectionUsedByJobAnalyses(String connection) {
		String warningmessage = other.getString("delete.connetion.warning");
		String warningmessage1 =  "Delete Faild: Cannot delete connection "+'"'+connection+'"'+" because it's active for...";
		this.clickWaitForElementPresent("!!!menu.dashjobs.element!!!");
		//wait and select the first "connection"
		this.waitForElementPresent("//label[text()='Active connection:']/following-sibling::div//input/following-sibling::div",WAIT_TIME);
		selenium.click("//label[text()='Active connection:']/following-sibling::div//input/following-sibling::div");
		this.mouseDownWaitForElementPresent("//div[contains(@class,'x-combo-list-item') and text()=' "+connection+"']");
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
				"//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+ connection + "')]", Base.WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+ connection + "')]");
		selenium.chooseOkOnNextConfirmation();
		selenium.click("//div[text()='Connections']/ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleDeleteButton']");
		assert (selenium.getConfirmation().equals(warningmessage));
//		assertTrue(this.waitForTextPresent(warningmessage1, WAIT_TIME));
		selenium.refresh();
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+ connection + "')]", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		
		
	}
}