package com.talend.tac.cases.projects;

import java.awt.event.KeyEvent;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class TestAddProjectWithWrongSvnPassword extends Projects {

	@Test
	@Parameters({ "svnUrl", "svnUserName", "svnConfWrongServerPassword",
			"addCommonTestProjectName", "proLanguage", "projectType" })
	public void testAddProjectWithWrongSVNPassword(String url, String user, String password,
			String proname, String language, String type) throws Exception {
		proname = "test@WrongPassword";
		testAddProjectWithWrongPassword(proname, language, type, url, "user", "password");

	}

	public void testAddProjectWithWrongPassword(String namecommon, String language,
			String type, String svnurl, String user, String password)
			throws Exception {
		this.openMenuProject();
		this.clickWaitForElementPresent("idSubModuleAddButton");
		Thread.sleep(2000);
		this.typeString("idLabelInput", namecommon);
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
		selenium.click("idFormSaveButton");
		String text = "Save failed: Authentication failed while connecting to "+svnurl+"/"+namecommon+" -- For more information see your log file";
		Assert.assertTrue(this.waitForTextPresent(text, WAIT_TIME));
		Assert.assertFalse(selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ namecommon + "')]"));
		selenium.setSpeed(MIN_SPEED);
	}
}
