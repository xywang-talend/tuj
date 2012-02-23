package com.talend.tac.cases.esbconductor;

import static org.testng.Assert.assertEquals;

import java.awt.event.KeyEvent;

import org.testng.Assert;

import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class ESBConductorUtils extends Login {
	
	public String locatorOfAllInputTags = other.getString("commandline.conf.all.input");	
	
	/*go to ESBConductor page*/
	public void intoESBConductorPage() {
		
		this.clickWaitForElementPresent("!!!menu.esbconductor.element!!!");
		this.waitForElementPresent("//div[@class='header-title' and text()" +
				"='ESB Conductor']", WAIT_TIME);
		
	}
	
	/*add method for select feature*/
    public void selectDropDownListForESBConductor(String id, String itemName, String filedName) {
		
		if(selenium.isElementPresent("//span[text()='Select Feature" +
			" from Talend repository']//ancestor::div[@class='" +
			" x-window x-component']//input[@id='"+id+"']"
				+ "/following-sibling::div")) {
			
			selenium.click("//span[text()='Select Feature" +
			" from Talend repository']//ancestor::div[@class='" +
			" x-window x-component']//input[@id='"+id+"']"
					+ "/following-sibling::div");
			
		} else if (selenium.isElementPresent("//label[text()='"+filedName+"']//parent::div" +
						"//input[@id='"+id+"']"
						+ "/following-sibling::div")) {
				
				selenium.click("//label[text()='"+filedName+"']//parent::div" +
						"//input[@id='"+id+"']"
						+ "/following-sibling::div");
				
		} 
		                            
		this.waitForElementPresent("//div[text()='" + itemName + "' and @role='listitem']", WAIT_TIME);
		selenium.mouseDown("//div[text()='" + itemName + "' and @role='listitem']");
		selenium.fireEvent("//input[@id='"+id+"']", "blur");

	}
	
	
	/*add esbconductor*/
	public void addESBConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		
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
		selenium.click("idFormSaveButton");
		
	}
	
	/*
	 * method to delete 
	 * */
	public void deleteESBConductorOK(String label) {
		
		this.intoESBConductorPage();
		this.waitForElementPresent("//div[text()='"+label+"']", WAIT_TIME);
		selenium.mouseDown("//div[text()='"+label+"']");
		this.sleep(3000);
		selenium.chooseOkOnNextConfirmation();//
		selenium.click("idESBConductorTaskGridDeleteButton");
		Assert.assertTrue(selenium.getConfirmation().matches("^Are you sure you want to remove the selected esb task [\\s\\S]$"));
		this.waitForElementDispear("//div[text()='"+label+"']", WAIT_TIME);
		
	}
	
	/*
	 * method to delete 
	 * */
	public void deleteESBConductorCancel(String label) {
		
		this.intoESBConductorPage();
		this.waitForElementPresent("//div[text()='"+label+"']", WAIT_TIME);
		selenium.mouseDown("//div[text()='"+label+"']");
		this.sleep(3000);
		selenium.chooseCancelOnNextConfirmation();//choose 'Cancel'
		selenium.click("idESBConductorTaskGridDeleteButton");
		Assert.assertTrue(selenium.getConfirmation().matches("^Are you sure you want to remove the selected esb task [\\s\\S]$"));
		this.sleep(3000);
		selenium.refresh();
		this.waitForElementPresent("//div[text()='"+label+"']", WAIT_TIME);
		
	}
	
	/*deploy start a conductor*/
	public void deployStartConductor(String label, String name, String promptInfo,
			String id, String status) {
		
		this.waitForElementPresent("//div[text()='"+label+"']", WAIT_TIME);
		selenium.mouseDown("//div[text()='"+label+"']");
		
		selenium.click(id);//button{deploy start}
		
		this.waitForTextPresent(promptInfo, WAIT_TIME);
		selenium.setSpeed(MID_SPEED);
		selenium.click("idESBConductorTaskGridRefreshButton");
		selenium.setSpeed(MIN_SPEED);
		
		this.waitForElementPresent("//div[text()='"+label+"']" +
		"//ancestor::table[@class='x-grid3-row-table']//span[text()='"+status+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+label+"']" +
		"//ancestor::table[@class='x-grid3-row-table']//span[text()='"+status+"']"));
	}
	
	/*undeploy stop conductor*/
    public void undeployStopConductor(String label, String name, String id, String status,
    		String popupInfo, String promptInfo) {
    	
    	this.waitForElementPresent("//div[text()='"+label+"']", WAIT_TIME);
		selenium.mouseDown("//div[text()='"+label+"']");
		
		this.sleep(3000);
		selenium.chooseOkOnNextConfirmation();
		selenium.click(id);//button {undeploy stop}
		Assert.assertTrue(selenium.getConfirmation().matches("^"+popupInfo+" [\\s\\S]$"));
		
		this.waitForTextPresent(promptInfo, WAIT_TIME);
		selenium.setSpeed(MID_SPEED);
		selenium.click("idESBConductorTaskGridRefreshButton");
		selenium.setSpeed(MIN_SPEED);
		
		this.waitForElementPresent("//div[text()='"+label+"']" +
				"//ancestor::table[@class='x-grid3-row-table']//span[text()='"+status+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+label+"']" +
				"//ancestor::table[@class='x-grid3-row-table']//span[text()='"+status+"']"));
    	
    }
    
    /**
	 * type a value in configuration menu.click the edit button firstly to wait for the input to appear.
	 * @param locatorOfEditButton
	 * @param locatorOfInput
	 * @param value
	 */
	public void typeWordsInConfigurationMenu(String locatorOfEditButton,String locatorOfInput,String value){
		 this.clickWaitForElementPresent(locatorOfEditButton);//click the edit button to make the input tag shown.
		 selenium.setSpeed("2000");
		 this.typeWaitForElementPresent(locatorOfInput, value);
		 selenium.setSpeed("0");
	}
	/**
	 * assertions,check the value in input tag is as expected,and check the status icon.
	 * @param locatorOfEditButton
	 * @param locatorOfInput	
	 * @param value
	 */
		public void AssertEqualsInConfigurationMenu(String locatorOfEditButton,String locatorOfInput,String value,String statusIconLocator){
		this.AssertEqualsInConfigurationMenu(locatorOfEditButton, locatorOfInput, value);
			this.waitForElementPresent(statusIconLocator, WAIT_TIME);//wait and check the icon status.
	}
	public void AssertEqualsInConfigurationMenu(String locatorOfEditButton,String locatorOfInput,String value){
		this.clickWaitForElementPresent(locatorOfEditButton);//click the edit button to make the input tag shown.
		this.waitForElementPresent(locatorOfInput, Base.WAIT_TIME);
		assertEquals(selenium.getValue(locatorOfInput), value);
		selenium.fireEvent(locatorOfInput, "blur");
	}
	
	public void configurationESBConduction(String artifactRepositoryUrl, String artifactRepositoryUserName
			, String artifactRepositoryPassWord, String mavenProtocolExpected, String urlStatus
			, String usernameStatus, String pwStatus, String mavenStatus) {
		
		this.clickWaitForElementPresent("idMenuConfigElement");
       
		this.waitForElementPresent("//div[@class='header-title' and text()='Configuration']", WAIT_TIME);
		if(selenium.isElementPresent("//button[@class='x-btn-text' and @aria-pressed='true']")) {
			
			selenium.click("//button[@class='x-btn-text' and @aria-pressed='true']");
			this.waitForElementPresent("//button[@class='x-btn-text' and @aria-pressed='false']", WAIT_TIME);
			
		}
		this.mouseDownWaitForElementPresent("//div[contains(text(),'ESB conductor (4 Parameters')]");
		this.typeWordsInConfigurationMenu(other.getString("ESBConduction.ArtifactRepositoryUrl.editButton"),locatorOfAllInputTags, artifactRepositoryUrl);
		this.typeWordsInConfigurationMenu(other.getString("ESBConduction.ArtifactRepositoryUserName.editButton"),locatorOfAllInputTags, artifactRepositoryUserName);
		this.typeWordsInConfigurationMenu(other.getString("ESBConduction.ArtifactRepositoryPassWord.editButton"),locatorOfAllInputTags, artifactRepositoryPassWord);
		
		String mavenProtocol = selenium.getText("//div[contains(text(),'ESB conductor (4 Parameters')]/parent::div/following-sibling::div//table//div[text()='Maven protocol']" +
				"/parent::td/following-sibling::td[1]//div[1]").trim();
		Assert.assertEquals(mavenProtocol, mavenProtocolExpected);
		
		this.clickWaitForElementPresent(other.getString("ESBConduction.ArtifactRepositoryUrl.editButton"));//click the edit button to make the input tag shown.
		this.waitForElementPresent(locatorOfAllInputTags, WAIT_TIME);
		selenium.focus(locatorOfAllInputTags);
		selenium.keyDownNative(""+KeyEvent.VK_ENTER);
		this.AssertEqualsInConfigurationMenu(other.getString("ESBConduction.ArtifactRepositoryUrl.editButton"),locatorOfAllInputTags, artifactRepositoryUrl,
				other.getString(urlStatus));
		this.AssertEqualsInConfigurationMenu(other.getString("ESBConduction.ArtifactRepositoryUserName.editButton"),locatorOfAllInputTags, artifactRepositoryUserName,
				other.getString(usernameStatus));
		this.AssertEqualsInConfigurationMenu(other.getString("ESBConduction.ArtifactRepositoryPassWord.editButton"),locatorOfAllInputTags, artifactRepositoryPassWord,
				other.getString(pwStatus));
		Assert.assertTrue(selenium.isElementPresent(other.getString(mavenStatus)));	
		
	}
	
}
