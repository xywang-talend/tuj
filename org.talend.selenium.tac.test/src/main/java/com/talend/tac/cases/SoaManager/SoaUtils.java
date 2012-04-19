package com.talend.tac.cases.SoaManager;



import org.testng.Assert;
import com.talend.tac.cases.audit.Audit;

public class SoaUtils extends Audit {
    
	public String locatorOfAllInputTags = other.getString("commandline.conf.all.input");
	
	public void addSoa(String serviceName) {
		
		this.clickWaitForElementPresent("!!!menu.soamanager.element!!!");
		selenium.click("idSubModuleAddButton");
		selenium.type("idSoaServiceNameInput", serviceName);
		
		selenium.fireEvent("idSoaServiceNameInput", "blur");
		selenium.type("idSoaServiceContactInput", "contact@TestService.com");
		selenium.fireEvent("idSoaServiceContactInput", "blur");
		selenium.type("idSoaServiceDescInput", "This is TestService");
		selenium.fireEvent("idSoaServiceDescInput", "blur");
		// selenium.type("idSoaServicePortInput", "8881");
		selenium.click("idFormSaveButton");
		waitForElementPresent("//*[text()='"+serviceName+"']", WAIT_TIME);
		
	}
	
	  
	public void addOpration(String serviceName, String operationName, String projectName,
			String UsedJobName, String jobVersion) {
		
		selenium.click("!!!menu.soamanager.element!!!");//*[text()='"+serviceName+"']
		waitForElementPresent("//*[text()='"+serviceName+"']", WAIT_TIME);
		selenium.mouseDown("//*[text()='"+serviceName+"']");
		this.clickWaitForElementPresent("idSoaOperationAdd");
		this.typeAndBlur("idSoaOperationNameInput", operationName);
		this.typeAndBlur("idSoaOperationDescInput", "This is testOperation");
		// select project
		this.selectDropDownList("idTaskProjectListBox", projectName);
		// select trunk,branches 
		this.selectDropDownList("idTaskBranchListBox", "trunk");
		
		if(selenium.isElementPresent("idItemListCombo")) {
		
			this.selectDropDownList("idItemListCombo", "job");
			
		}
		
		this.selectDropDownList("idTaskApplicationListBox", UsedJobName);
		// select version
		this.selectDropDownList("idTaskVersionListBox", jobVersion);
		// select context
		this.selectDropDownList("idTaskContextListBox", "Default");
		selenium.click("idSoaOperationSave");	
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-operationName' and text()='"+operationName+"']", WAIT_TIME);
		this.sleep(3000);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-operationName' and text()='"+operationName+"']");
	    Assert.assertTrue(selenium.getValue("idTaskProjectListBox").toString().equals(projectName), "test add operation with latest job failed!");
	    Assert.assertTrue(selenium.getValue("idTaskBranchListBox").toString().equals("trunk"), "test add operation with latest job failed!");
	    if(selenium.isElementPresent("idItemListCombo")) {
	    	
	    	Assert.assertTrue(selenium.getValue("idItemListCombo").toString().equals("job"), "test add operation with latest job failed!");
	    	
	    }
	    
	    Assert.assertTrue(selenium.getValue("idTaskApplicationListBox").toString().equals(UsedJobName), "test add operation with latest job failed!");
	    Assert.assertTrue(selenium.getValue("idTaskVersionListBox").toString().equals(jobVersion), "test add operation with latest job failed!");
	    Assert.assertTrue(selenium.getValue("idTaskContextListBox").toString().equals("Default"), "test add operation with latest job failed!");
		
	}
	
	//creation method for change commandline host address
	public void changeCommandLineConfig(String hostAddress, String statusIcon) {
		this.clickWaitForElementPresent("idMenuConfigElement");
		this.mouseDownWaitForElementPresent("//div[contains(text(),'Command line/secondary')]");
		selenium.refresh();
		this.mouseDownWaitForElementPresent("//div[contains(text(),'Command line/primary')]");
		this.typeWordsInConfigurationMenu(other.getString("commandline.conf.primary.host.editButton"),locatorOfAllInputTags, hostAddress);
	
//		this.AssertEqualsInConfigurationMenu(other.getString("commandline.conf.primary.host.editButton"),locatorOfAllInputTags, hostAddress,statusIcon);
//		this.AssertEqualsInConfigurationMenu(other.getString("commandline.conf.primary.port.editButton"),locatorOfAllInputTags, "8002",other.getString("commandline.conf.primary.port.statusIcon"));
		
	}
		
}
