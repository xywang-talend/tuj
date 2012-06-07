package com.talend.tac.cases.projects;

import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class TestAddProjectWithExistlable extends Projects {

	@Test
	// @Test(groups = { "AddBranch" }, dependsOnGroups = { "Add" })
	@Parameters({ "svnUrl", "svnUserName", "svnUserPassword",
			"addCommonTestProjectName", "proLanguage", "projectType" })
	public void testAddProjectExist(String url, String user, String password,
			String proname, String language, String type) throws Exception {
        this.openMenuProject();
		testAddexistproject(proname, language, type, url, user, password);

	}

	public void testAddexistproject(String namecommon, String language,
			String type, String svnurl, String user, String password)
			throws Exception {
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

		if (!"Java".equals(language) && !"".equals(language)) {
			selenium.click("idLanguageInput");
			this.waitForElementPresent("//div[@role='listitem'][2]", WAIT_TIME);
			selenium.mouseDownAt("//div[@role='listitem'][2]", ""
					+ KeyEvent.VK_ENTER);
		}
		selenium.click("idAdvanceInput");
		this.typeString("idUrlInput", svnurl + "/" + namecommon + "/");// svn
		this.typeString("idLoginInput", user);// svn account
		this.typeString("idPasswordInput", password);// svn password
		this.typeString("idDescriptionInput", "adf");
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium
				.isTextPresent("Save failed: A project with this name already exists"));
		selenium.setSpeed(MIN_SPEED);
	}
}
