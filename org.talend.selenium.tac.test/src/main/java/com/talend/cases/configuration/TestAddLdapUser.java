package com.talend.cases.configuration;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestAddLdapUser extends Login {

	@Test
	@Parameters( { "ldapUserDn","ldapUserUserName" })
	public void testAddLdapUser(String dn, String userName) {
		this.clickWaitForElementPresent("idMenuUserElement");
		this.clickWaitForElementPresent("idSubModuleAddButton");
	    selenium.type("ldapId", dn);
		this.selectDropDownList("idTypeInput", "Data Integration");
		selenium.click("idRoleButton");
		waitForElementPresent("//td[not(contains(@style,'display: none'))]/div[text()='Administrator']/parent::td/preceding-sibling::td//div[@class='x-grid3-row-checker']", WAIT_TIME);
		selenium.mouseDown("//td[not(contains(@style,'display: none'))]/div[text()='Administrator']/parent::td/preceding-sibling::td//div[@class='x-grid3-row-checker']");
		selenium.mouseUp("//td[not(contains(@style,'display: none'))]/div[text()='Administrator']/parent::td/preceding-sibling::td//div[@class='x-grid3-row-checker']");
		selenium.click("idValidateButton");
		selenium.click("idFormSaveButton");
		
	   waitForElementPresent("//div[text()='"+userName+"']", WAIT_TIME);
		
	}
}
