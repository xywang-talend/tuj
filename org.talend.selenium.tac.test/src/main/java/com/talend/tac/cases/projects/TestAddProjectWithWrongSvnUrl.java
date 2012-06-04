package com.talend.tac.cases.projects;

import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.talend.tac.base.Base;

public class TestAddProjectWithWrongSvnUrl extends Projects {

	@Test
	@Parameters({"addcommontestProjectWrongSvn", "proLanguage", "projectType"})
	public void testAddProjectWithWrongSVNUrl(String proname, String language, String type) throws Exception {

		testAddexistproject(proname, language, type);

	}

	public void testAddexistproject(String namecommon, String language,
			String type)
			throws Exception {
		selenium.setSpeed(MIN_SPEED);
		this.waitForElementPresent("!!!menu.project.element!!!", Base.WAIT_TIME);
		this.clickWaitForElementPresent("!!!menu.project.element!!!");
		this.clickWaitForElementPresent("idSubModuleAddButton");
		Thread.sleep(2000);
		this.typeString("idLabelInput", namecommon);
		// add the type select option selenium.setSpeed("2000");
		if (selenium.isVisible("idProjectTypeComboBox")) {
			selenium.click("idProjectTypeComboBox");
			this.waitForElementPresent("//div[text()='" + type + "']", WAIT_TIME);
			selenium.mouseDown("//div[text()='" + type + "']");
			selenium.fireEvent("idProjectTypeComboBox", "blur");
		}
		selenium.setSpeed(MIN_SPEED);
		if (!"Java".equals(language) && !"".equals(language)) {
			selenium.click("idLanguageInput");
			this.waitForElementPresent("//div[@role='listitem'][2]", WAIT_TIME);
			selenium.mouseDownAt("//div[@role='listitem'][2]", ""
					+ KeyEvent.VK_ENTER);
		}
		selenium.click("idAdvanceInput");
		this.typeString("idUrlInput", "svnurl");// svn
		this.typeString("idLoginInput", "svnuser");// svn account
		this.typeString("idPasswordInput", "svnpassword");// svn password
		this.typeString("idDescriptionInput", "adf");
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ namecommon + "')]"), "TestAddProjectWithWrongSvnUrl failed !");
		selenium.setSpeed(MIN_SPEED);
	}
}
