package com.talend.tac.cases.esbconductor;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestGroupByESBConductor extends ESBConductorUtils {
	public void checkColumn(String columnName){
		boolean present = selenium.isElementPresent("//span[text()='"+columnName+"']");
		if(!present){
			selenium.click("//a[text()='"+columnName+"']");
			this.waitForElementPresent("//span[text()='"+columnName+"']", WAIT_TIME);
			selenium.click("//a[text()='"+columnName+"']");
			this.waitForElementDispear("//span[text()='"+columnName+"']", WAIT_TIME);
		}
		else{
			selenium.click("//a[text()='"+columnName+"']");
			this.waitForElementDispear("//span[text()='"+columnName+"']", WAIT_TIME);
			selenium.click("//a[text()='"+columnName+"']");
			this.waitForElementPresent("//span[text()='"+columnName+"']", WAIT_TIME);
		}
		
	}
	public void addESBConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server ,String tag,int times) {
		
		this.intoESBConductorPage();
		
		this.clickWaitForElementPresent("idESBConductorTaskGridAddButton");
		this.waitForElementPresent("//img[@class='gwt-Image" +
				" x-component ']", WAIT_TIME);
		
		this.typeString("idESBConductorTasklabelInput", label);
		this.typeString("idESBConductorTaskdesInput", des);
		selenium.click("idESBConductorTaskSelectButton");
		this.waitForElementPresent("//span[text()='Select" +
				" Feature from Talend repository']", WAIT_TIME);
		this.selectDropDownListForESBConductor("idTaskProjectListBox", repository, "Repository:");
		this.selectDropDownListForESBConductor("idTaskBranchListBox", group, "Group:");
		this.selectDropDownListForESBConductor("idTaskApplicationListBox", artifact, "Artifact:");
		this.selectDropDownListForESBConductor("idTaskVersionListBox", version, "Version:");
		selenium.click("//span[text()='Select Feature from Talend repository']" +
				"//ancestor::div[@class=' x-window x-component']" +
				"//button[text()='OK']");//save select feature info after click OK 
		this.selectDropDownListForESBConductor("idTaskProjectListBox", name, "Name:");
		this.selectDropDownListForESBConductor("idJobConductorExecutionServerListBox", type, "Type:");
		this.selectDropDownListForESBConductor("idESBConductorTaskContextListBox", context, "Context:");
		this.selectDropDownListForESBConductor("idJobConductorExecutionServerListBox", server, "Server:");
		if(times==0){
		this.typeString("idESBConductorApplicationGroupListBox", tag);
		}
		else{
			this.selectDropDownListByClickArrow("//input[@id='idESBConductorApplicationGroupListBox']/following-sibling::div", tag, "x-combo-list-item");
		}
		selenium.click("idFormSaveButton");
		
	}
   
	/*add esbconductor of service*/
	@Test
	@Parameters({"labelOfService_1","labelOfService_2","labelOfService_3", "desOfService", "repository", "group", "artifact",
		"version", "name", "type", "context", "serverOfRuntime","tag_1","tag_2"})
	public void testGroupESBConductorOfService(String label1,String label2,String label3, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server,String tagA, String tagB) {
		
		
		this.addESBConductor(label1, des, repository, group, artifact, version,
				name, type, context, server,tagA,0);
		this.addESBConductor(label2, des, repository, group, artifact, version,
				name, type, context, server,tagB,0);
		this.addESBConductor(label3, des, repository, group, artifact, version,
				name, type, context, server,tagB,1);		
		this.waitForElementPresent("//span[text()='Tag']", WAIT_TIME);
		this.sleep(2000);
		selenium.click("//span[text()='Tag']//parent::div[contains(@class,'x-grid3-hd-inner x-grid3-hd-applicationGroup x-component')]//a");
		this.waitForElementPresent("//a[text()='Columns']", WAIT_TIME);
		selenium.mouseOver("//a[text()='Columns']");
		this.checkColumn("Feature URL");
		this.checkColumn("Id");
		selenium.click("//a[text()='Group By This Field']");
		this.sleep(3000);
		Assert.assertTrue(selenium.getXpathCount("//div[contains(@class,'x-grid-group-div') and contains(text(),'Tag:  (')]").intValue()>=2);
//	    this.deleteESBConductorOK(label1, name);
//	    this.deleteESBConductorOK(label2, name);
//	    this.deleteESBConductorOK(label3, name);
	}
	

	
}

