package com.talend.tac.cases.projects;

import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAddProjectWithOutType extends Projects {

	@Test
	@Parameters({"sVNProjecturl", "sVNuserName", "sVNuserPassword","projectWithOutType", "proLanguage", "projectType"})
	public void testAddpro(String url,String username,String password,String proname, String language, String type) throws Exception {

		testAddProjectWithOutType(url,username,password,proname, language, type);

	}

	public void testAddProjectWithOutType(String url,String username,String password,String proname, String language, String type)
			throws Exception {
		this.openMenuProject();
		this.clickWaitForElementPresent("idSubModuleAddButton");
		Thread.sleep(2000);
		this.typeString("idLabelInput", proname);
		if (!"Java".equals(language) && !"".equals(language)) {
			selenium.click("idLanguageInput");
			this.waitForElementPresent("//div[@role='listitem'][2]", WAIT_TIME);
			selenium.mouseDownAt("//div[@role='listitem'][2]", ""
					+ KeyEvent.VK_ENTER);
		}
		selenium.click("idAdvanceInput");
		this.typeString("idUrlInput", url);// svn
		this.typeString("idLoginInput", username);// svn account
		this.typeString("idPasswordInput", password);// svn password
		this.typeString("idDescriptionInput", "projectnotype");
//		System.out.println(selenium.getValue("idProjectTypeComboBox"));
		Assert.assertTrue(selenium.getValue("idProjectTypeComboBox").equals("Select a type..."));
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ proname + "')]"), "TestAddProjectWithWrongSvnUrl failed !");
		selenium.setSpeed(MIN_SPEED);
	}
}
