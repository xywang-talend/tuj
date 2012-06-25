package com.talend.tac.cases.audit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.io.File;

import org.testng.Assert;

import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;


public class Audit extends Login {

	public String locatorOfAllInputTags = other.getString("commandline.conf.all.input");
    int seconds = 0;
	//check report pdf after audit 
	public File checkReportPdf(String reportFilePath, String projectName, String jobName) {
		
		File auditReportFile = new File(reportFilePath+"/"+this.getReportFileName());
		System.out.println(auditReportFile);
	    
	    for (int seconds = 0;; seconds++) {
			if (seconds >= WAIT_TIME) {
				assertTrue(auditReportFile.exists());
			}
			if (auditReportFile.exists()) {
				System.out.println(seconds + "' used to download");
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	    
	    Assert.assertTrue(this.isExistedInfoInPdf(reportFilePath+"/"+this.getReportFileName(), projectName));
	    Assert.assertTrue(this.isExistedInfoInPdf(reportFilePath+"/"+this.getReportFileName(), jobName));
		return auditReportFile;
		
	}
	
	//get incipient report path
	public String  getDefaultReportPath() {
		
		//go to configuration page
		this.clickWaitForElementPresent("idMenuConfigElement");
		
		//change value of 'reports stored path' to a directory exist
		this.waitForElementPresent("//div[contains(text(),'Audit (')]", WAIT_TIME);
		selenium.mouseDown("//div[contains(text(),'Audit (')]");
		
		this.clickWaitForElementPresent(other.getString("audit.conf.reportsStoredPath.editButton"));//click the edit button to make the input tag shown.
		String defaultPath = selenium.getValue(locatorOfAllInputTags);
		selenium.keyDownNative(""+KeyEvent.VK_ENTER);
		selenium.keyUpNative(""+KeyEvent.VK_ENTER);
		System.out.println(">>>>>>>>"+defaultPath);
		return defaultPath;
	
   }
	
	//creation method for get report file name
	public String getReportFileName() {		
		
	    this.openAudit();
	    
	    selenium.mouseOver("//a[contains(text(),'Audit for project')]");
	    selenium.setSpeed("2000");
	    
	    String reportFileHref = "";
	    reportFileHref = selenium.getAttribute("//a[contains(text(),'Audit for project')]@href");
	    String reportFileNames[] = reportFileHref.split("file=");
	    
	    for(int i= 0; i<reportFileNames.length; i++) {
    	
	    	System.out.println(reportFileNames[i]);	
  	
	    }
	    String reportFileName = reportFileNames[1];
	    System.out.println(reportFileName);
		return reportFileName;
	  
	    
	}
	
	public void openAudit(){
		this.waitForElementPresent("!!!menu.audit.element!!!", WAIT_TIME);
		selenium.click("!!!menu.audit.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Audit']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-panel-header-text' and text()='Audits list']",
				WAIT_TIME);
		selenium.refresh();
		this.sleep(3000);
		this.waitForElementPresent("//button[text()='Audit DB Configuration']", WAIT_TIME);
		
	}
	public String getFormatedDbURL(String url){
		String fomatedUrl = url;
		if ("org/talend/tac/folder/h2database".equals(url)){
			System.out.println("before changing");
			fomatedUrl = "jdbc:h2:"+this.parseRelativePath(url)+"/talend_administrator;AUTO_SERVER=TRUE;MVCC=TRUE";
			System.out.println(fomatedUrl);

		}else{
			fomatedUrl = "jdbc:h2:"+(url)+"/talend_administrator;AUTO_SERVER=TRUE;MVCC=TRUE";
		}
		return fomatedUrl;
	}
	public void configAuditDB(String url, String userName, String driver, String userPassWd){
		this.clickWaitForElementPresent("//button[text()='Audit DB Configuration']");
		this.waitForElementPresent("//span[@class='x-fieldset-header-text' and text()='Database parameters']", WAIT_TIME);
		this.waitForElementPresent("//span[@class='x-fieldset-header-text' and text()='Database parameters']//ancestor::fieldset[@class=' x-fieldset x-component']", WAIT_TIME);
		this.waitForElementPresent("//span[@class='x-fieldset-header-text' and text()='Check']//ancestor::fieldset[@class=' x-fieldset x-component']", WAIT_TIME);
		selenium.setSpeed(MID_SPEED);
		selenium.type("idDbConfigUrlInput", url);
		selenium.type("idDbConfigUserNmeInput", userName);
		selenium.type("idDbConfigPasswordInput", userPassWd);
		selenium.type("idDbConfigDriverInput", driver);
		selenium.focus("idDbConfigDriverInput");
	}
	
	public void waitForCheckConnectionStatus(String locator, int OK_Num) {
		boolean flag = false;
		int seconds_Counter = 0;
		while (flag == false) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			flag = selenium.getXpathCount("//td[@align='LEFT']/div").intValue()==5;
			flag = selenium.getXpathCount(locator).intValue() >= OK_Num;
			seconds_Counter++;
			if(seconds_Counter >= WAIT_TIME)
				assertTrue(selenium.getXpathCount("//div[text()='OK']").intValue() >= OK_Num);
		}

	}
	
	/**
	 * test audit process, projectName is the name of project,branches: we can define it as "trunk" or "branch"
	 * @param projectName
	 * @param branches
	 */
	public void auditProcess(String projectName,String branches){
		this.clickWaitForElementPresent("!!!menu.audit.element!!!");
		//project
		this.clickWaitForElementPresent("//label[text()='Project:']/following-sibling::div//table//div//div");
		if(!selenium.isElementPresent("//div[@role='listitem' and text()='"+projectName+"']")) {
			
			selenium.keyPressNative(KeyEvent.VK_DOWN+"");
			selenium.keyUpNative(KeyEvent.VK_DOWN+"");				
			
		}
		this.waitForElementPresent("//div[@role='listitem' and text()='"+projectName+"']",WAIT_TIME+70);
		selenium.mouseDown("//div[@role='listitem' and text()='"+projectName+"']");
		//branches
		this.clickWaitForElementPresent("//label[text()='Branch:']/following-sibling::div//div/div");
		if(!selenium.isElementPresent("//div[@role='listitem' and contains(text(),'"+branches+"')][1]")) {
			
			selenium.keyPressNative(KeyEvent.VK_DOWN+"");
			selenium.keyUpNative(KeyEvent.VK_DOWN+"");	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
					
			
		}
		this.waitForElementPresent("//div[@role='listitem' and contains(text(),'"+branches+"')][1]", WAIT_TIME);
		selenium.mouseDown("//div[@role='listitem' and contains(text(),'"+branches+"')][1]");
		//start
		this.waitForElementPresent("//button[text()='Start audit']",WAIT_TIME);
		selenium.click("//button[text()='Start audit']");
	
	}
	
	public boolean checkAuditInfo(String projectName){
		
		boolean ok = false;
		
		this.sleep(60000);
		boolean failed = selenium.isElementPresent("//font[@color='red' and text()='The Audit process has terminated with error(s)']");
		int second = 0;
		System.out.println(failed);
		while(second <= MAX_WAIT_TIME && failed == false && ok==false) {
			second++;
			System.out.println(second);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ok = selenium.isTextPresent("The Audit process has terminated successfully");
				
			
		}
		return ok;
	
	}
	public int checkAuditListLink(String projectName){
		
		int linksNum = this.selenium.getXpathCount("//a[contains(text(),'Audit for project "+'"'+projectName.toUpperCase()+'"'+" created at')]").intValue();
		return linksNum;
	}
	public void changeCommandLineConfig(String commandlineHost, String statusIcon) {
		
		System.err.println(commandlineHost);
		this.clickWaitForElementPresent("idMenuConfigElement");
		this.mouseDownWaitForElementPresent("//div[contains(text(),'CommandLine/primary')]");
		this.typeWordsInConfigurationMenu(other.getString("commandline.conf.primary.host.editButton"),locatorOfAllInputTags, commandlineHost);
		this.AssertEqualsInConfigurationMenu(other.getString("commandline.conf.primary.host.editButton"),locatorOfAllInputTags, commandlineHost, statusIcon);
		
	}
	
	/**
	 * type a value in configuration menu.click the edit button firstly to wait for the input to appear.
	 * @param locatorOfEditButton
	 * @param locatorOfInput
	 * @param value
	 */
	public void typeWordsInConfigurationMenu(String locatorOfEditButton,String locatorOfInput,String value){
         
		 this.waitForElementPresent("//div[contains(text(),'Audit (') and contains(@class,'x-grid-group-div')]", WAIT_TIME);		 
		 boolean configurationPageIsNotEdit = selenium.isElementPresent("//div[@style='display: block;' and @class='ext-el-mask']");
		 System.out.println(configurationPageIsNotEdit);
	     while (seconds<=WAIT_TIME*2 && configurationPageIsNotEdit == true) {
			 
	    	 seconds++;	   
	    	 configurationPageIsNotEdit = selenium.isElementPresent("//div[@style='display: block;' and @class='ext-el-mask']");
	    	 try {
				Thread.sleep(1000);
			 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			 System.out.println("can not edit in configuration page"+seconds);
			 
		 }
	     
		 this.clickWaitForElementPresent(locatorOfEditButton);//click the edit button to make the input tag shown.
		 this.typeWaitForElementPresent(locatorOfInput, value);
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.keyDown(locatorOfInput, "\\13");
	}
	/**
	 * assertions,check the value in input tag is as expected,and check the status icon.
	 * @param locatorOfEditButton
	 * @param locatorOfInput	
	 * @param value
	 */
	public void AssertEqualsInConfigurationMenu(String locatorOfEditButton,String locatorOfInput,String value,String statusIconLocator){
		
		 this.waitForElementPresent("//div[contains(text(),'Audit (') and contains(@class,'x-grid-group-div')]", WAIT_TIME);
		 
		 boolean configurationPageIsNotEdit = selenium.isElementPresent("//div[@style='display: block;' and @class='ext-el-mask']");
		 System.out.println(configurationPageIsNotEdit);
	     while (seconds<=WAIT_TIME*2 && configurationPageIsNotEdit == true) {			 

	    	 seconds++;	
	    	 configurationPageIsNotEdit = selenium.isElementPresent("//div[@style='display: block;' and @class='ext-el-mask']");   	 
	    	 try {
				Thread.sleep(1000);
			 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			 System.out.println("can not edit in configuration page"+seconds);
			 
		 }
	     
		this.clickWaitForElementPresent(locatorOfEditButton);
		this.AssertEqualsInConfigurationMenu(locatorOfEditButton, locatorOfInput, value);
		this.waitForElementPresent(statusIconLocator, WAIT_TIME);//wait and check the icon status.
	}
	public void AssertEqualsInConfigurationMenu(String locatorOfEditButton,String locatorOfInput,String value){		

		 this.waitForElementPresent("//div[contains(text(),'Audit (') and contains(@class,'x-grid-group-div')]", WAIT_TIME);
		 
		 boolean configurationPageIsNotEdit = selenium.isElementPresent("//div[@style='display: block;' and @class='ext-el-mask']");
		 System.out.println(configurationPageIsNotEdit);
	     while (seconds<=WAIT_TIME*2 && configurationPageIsNotEdit == true) {

	    	 seconds++;	  
	    	 configurationPageIsNotEdit = selenium.isElementPresent("//div[@style='display: block;' and @class='ext-el-mask']");
	    	 try {
				Thread.sleep(1000);
			 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			 System.out.println("can not edit in configuration page"+seconds);
			 
		 }
	     
		this.clickWaitForElementPresent(locatorOfEditButton);//click the edit button to make the input tag shown.
		this.waitForElementPresent(locatorOfInput, Base.WAIT_TIME);
		assertEquals(selenium.getValue(locatorOfInput), value);
		selenium.fireEvent(locatorOfInput, "blur");
	}
	
	
}
