package com.talend.tac.cases.projects;

import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.talend.tac.base.Base;

public class TestAddProjectWithNullLabel extends Projects {

	@Test
	@Parameters({ "sVNurl", "sVNuserName", "sVNuserPassword",
			"nullLabelProject", "proLanguage", "projectType" })
	public void testAddProjectWithOutLabel(String url, String user, String password,
			String proname, String language, String type) throws Exception {
		testAddprojectwithnulllabel(proname, language, type, url, user, password);
	}

	public void testAddprojectwithnulllabel(String namecommon, String language,
			String type, String svnurl, String user, String password)
			throws Exception {
		this.openMenuProject();
		this.clickWaitForElementPresent("idSubModuleAddButton");
		Thread.sleep(2000);
		this.typeString("idLabelInput", "");
		// add the type select option selenium.setSpeed("2000");
//		selenium.setSpeed(MID_SPEED);
		if (selenium.isVisible("idProjectTypeComboBox")) {
			selenium.click("idProjectTypeComboBox");
			this.waitForElementPresent("//div[text()='" + type + "']", WAIT_TIME);
			selenium.mouseDown("//div[text()='" + type + "']");
			selenium.fireEvent("idProjectTypeComboBox", "blur");
		}
//		selenium.setSpeed(MIN_SPEED);
		// if ("Java".equals(language) || "".equals(language)) {
		// } else {
		// selenium.click("idLanguageInput");
		// selenium.mouseDownAt("//div[@role='listitem'][2]",""+KeyEvent.VK_ENTER);
		// }
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
//		selenium.click("idSvnCommitInput");
//		selenium.mouseDownAt("//div[@role='listitem'][2]", ""
//				+ KeyEvent.VK_ENTER);
//		selenium.click("idSvnLockInput");
//		selenium.mouseDownAt("//div[@role='listitem'][2]", ""
//				+ KeyEvent.VK_ENTER);
//		selenium.click("idSvnUserLogInput");
		this.typeString("idDescriptionInput", "adf");
		Assert.assertTrue(selenium.isElementPresent("//input[@id='idLabelInput']//ancestor::div[@class='x-form-item ']//img"), "TestAddProjectWithNullLabel failed !");
		selenium.setSpeed(MIN_SPEED);
	}
}
