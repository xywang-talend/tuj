package com.talend.tac.cases.license;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class TestLicenseAccountsCount extends Login {
	public double moreOver = 0.20;
	
	@Test
	public void testCleanUsersNotUsed() throws InterruptedException {
		cleanAllExceptAdmin();
	}

	@Test
	public void testAddDIChangeToDQ() throws InterruptedException {
		// cleanAllExceptAdmin();
		// int n = getDQcounts();
		this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idMenuUserElement");
		// addUserallowed(2,n);
		selenium.refresh();
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']",
				WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']");
		// Thread.sleep(2000);
		// selenium.click("idTypeInput");
		// selenium.mouseDownAt("//div[@role='listitem'][2]", "" + Event.ENTER);
		this.selectDropDownList("//input[@id='idTypeInput']", 2);
		Assert.assertEquals(selenium.getValue("idTypeInput"), "Data Quality");
		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		// Assert.assertTrue(selenium.isTextPresent("Save failed: You are using "+(n-1)+" DQ users, but your license allows only "+(n-1)+", please contact your talend account manager -- For more information see your log file"));
		// selenium.setSpeed(MIN_SPEED);
		// Thread.sleep(5000);
		selenium.refresh();
		selenium.setSpeed(MIN_SPEED);
		// Thread.sleep(3000);
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']",
				WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']");
		Thread.sleep(1000);
		Assert.assertEquals(selenium.getValue("idTypeInput"),
				"Data Integration");
		// cleanAllExceptAdmin();
	}

	@Test
	public void testAddDQChangeToDI() throws InterruptedException {
		// cleanAllExceptAdmin();
		int n = getDIcounts();
		// System.out.println("Di users :"+n);
		this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idMenuUserElement");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']",
				WAIT_TIME);
		// add max amounts of DI users
		// addUserallowed(1,n-1);

		//
		String username = "";
		String name = "";
		// change DQ users added type from DI to DQ
		int i = 0;
		username = "DQ_" + i + "@talend.com";
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
				+ username + "']");
		Thread.sleep(2000);
		Assert.assertEquals(selenium.getValue("idTypeInput"), "Data Quality");
		String valuebefore = selenium.getValue("idTypeInput");
		Assert.assertTrue(valuebefore.equals("Data Quality"));
		// selenium.setSpeed(MID_SPEED);
		// selenium.click("idTypeInput");
		// selenium.mouseDownAt("//div[@role='listitem'][1]", "" + Event.ENTER);
		// selenium.fireEvent("idTypeInput", "blur");
		this.selectDropDownList("//input[@id='idTypeInput']", 1);
		Assert.assertEquals(selenium.getValue("idTypeInput"),
				"Data Integration");
		selenium.click("idRoleButton");
		this.waitForElementPresent("//span[text()='Roles Selection']",
				Base.WAIT_TIME);
		selenium.controlKeyDown();
		selenium.mouseDown("//td[not(contains(@style,'display: none'))]/div[text()='"
				+ rb.getString("menu.role.administrator")
				+ "']"
				+ "/parent::td/preceding-sibling::td//div[@class='x-grid3-row-checker']");
		selenium.mouseDown("//td[not(contains(@style,'display: none'))]/div[text()='"
				+ rb.getString("menu.role.viewer")
				+ "']"
				+ "/parent::td/preceding-sibling::td//div[@class='x-grid3-row-checker']");
		selenium.mouseDown("//td[not(contains(@style,'display: none'))]/div[text()='"
				+ rb.getString("menu.role.operationManager")
				+ "']"
				+ "/parent::td/preceding-sibling::td//div[@class='x-grid3-row-checker']");
		// selenium.mouseDown("//td[not(contains(@style,'display: none'))]/div[text()='"
		// + rb.getString("menu.role.designer")
		// + "']"
		// +
		// "/parent::td/preceding-sibling::td//div[@class='x-grid3-row-checker']");
		selenium.click("idValidateButton");

		selenium.click("idFormSaveButton");
		Thread.sleep(3000);
		selenium.refresh();
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
						+ username + "']", Base.WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
				+ username + "']");
		Thread.sleep(1000);
		String valueafter = selenium.getValue("idTypeInput");
		// Assert.assertTrue(selenium.isTextPresent("Save failed: You are using "+(n-1)+" DQ users, but your license allows only "+(n-1)+", please contact your talend account manager -- For more information see your log file"),
		// "test failed!");
		Assert.assertFalse(valueafter.equals("Data Integration"));
		selenium.setSpeed(MIN_SPEED);
	}

	@Test
	public void testAddMaxAmountsDIUsersAllowed() throws InterruptedException {
		// cleanAllExceptAdmin();
		int n = getDIcounts();
		addUserallowed(1, n - 1);
	}

	@Test
	public void testAddMaxAmountsDQUsersAllowed() throws InterruptedException {
		cleanAllExceptAdmin();
		int n = getDQcounts();
		addUserallowed(2, n);
	}

	public void addUserallowed(int type, int n) throws InterruptedException {
		this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idMenuUserElement");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']",
				WAIT_TIME);
		String username = "";
		String usernamepre = null;
		String name = "";
		String namepre = null;
		String typeStr = "";
		if (type == 1) {
			typeStr += "Data Integration";
			usernamepre = "DI_";
			namepre = "DI";
		} else if (type == 2) {
			typeStr += "Data Quality";
			usernamepre = "DQ_";
			namepre = "DQ";
		} else {
			typeStr += "Master Data Management";
			usernamepre = "MDM_";
			namepre = "MDM";
		}
		for (int i = 0; i < n; i++) {
			username = usernamepre + i + "@talend.com";
			name = namepre + i;
			//
			selenium.refresh();
			this.waitForElementPresent("idSubModuleAddButton", Base.WAIT_TIME);
			selenium.click("idSubModuleAddButton");
			selenium.type("idUserLoginInput", username);
			selenium.fireEvent("idUserLoginInput", "blur");
			selenium.type("idUserFirstNameInput", name);
			selenium.fireEvent("idUserFirstNameInput", "blur");
			selenium.type("idUserLastNameInput", name);
			selenium.fireEvent("idUserLastNameInput", "blur");
			selenium.type("idUserPasswordInput", name);
			selenium.fireEvent("idUserPasswordInput", "blur");
			selenium.type("//input[@name='authenticationLogin']", "admin");
			selenium.fireEvent("//input[@name='authenticationLogin']", "blur");
			selenium.type("//input[@name='authenticationPassword']", "admin");
			selenium.fireEvent("//input[@name='authenticationPassword']",
					"blur");
			// selenium.click("idTypeInput");
			// selenium.mouseDownAt("//div[@role='listitem'][2]", "" +
			// Event.ENTER);
			this.selectDropDownList("//input[@id='idTypeInput']", type);
			Assert.assertEquals(selenium.getValue("idTypeInput"), typeStr);
			String roles = rb.getString("menu.role.administrator") + "/"
					+ rb.getString("menu.role.viewer") + "/"
					+ rb.getString("menu.role.operationManager") + "/"
					+ rb.getString("menu.role.designer");
			selenium.click("idRoleButton");
			this.waitForElementPresent("//span[text()='Roles Selection']",
					Base.WAIT_TIME);
			// selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isTextPresent(rb
					.getString("user.roles.title")));
			selenium.setSpeed(MIN_SPEED);
			selenium.click("//span[text()='Role']/parent::div[not(contains(@style,'display: none'))]/" +
		    		"parent::td[not(contains(@style,'display: none'))]/preceding-sibling::td" +
		    		"[not(contains(@style,'display: none'))]/div[@class=' x-grid3-hd-inner x-grid3-hd-checker x-component']");
			selenium.click("idValidateButton");
			// selenium.setSpeed(MAX_SPEED);
			Assert.assertEquals(selenium.getValue("idActiveInput"), roles);
			//
			selenium.click("idFormSaveButton");
			// Thread.sleep(5000);
			this.waitForElementPresent(
					"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
							+ username + "']", Base.WAIT_TIME*2);
			Assert.assertTrue(selenium.isTextPresent(username),
					"testAddMaxAmountsDQUsersAllowed  failed!");
			selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
					+ username + "']");
			Thread.sleep(1000);
			Assert.assertTrue(selenium.getValue("//input[@name='active']")
					.equals("on"));
			selenium.setSpeed(MIN_SPEED);
		}

		// cleanAllExceptAdmin();

	}

	public void addLicense(String filename) {
		this.waitForElementPresent("idMenuLicenseElement", 30);
		selenium.click("idMenuLicenseElement");
		this.waitForElementPresent(
				"//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]",
				WAIT_TIME);
		selenium.type(
				"//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]",
				filename);
		selenium.click("//button[text()='Upload']");
	}

	public void addProjectsAllow(int type, List<String> types)
			throws InterruptedException {
		this.waitForElementPresent("!!!menu.project.element!!!", Base.WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		String typeStr = "";
		String projectname = null;
		if (type == 1) {
			typeStr += "Data Integration";
			projectname = "test@DI";

		} else if (type == 2) {
			typeStr += "Data Quality";
			projectname = "test@DQ";

		} else {
			typeStr += "Master Data Management";
			projectname = "test@MDM";

		}
		selenium.click("!!!menu.project.element!!!");
		selenium.click("//div[text()='Projects']/ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleAddButton']");
		Thread.sleep(1000);
		// selenium.setSpeed(MIN_SPEED);
		// type project label

		this.typeString("idLabelInput", projectname);
		// add the type select option selenium.setSpeed("2000");
		// selenium.setSpeed(MID_SPEED);
		if (selenium.isVisible("idProjectTypeComboBox")) {
			selenium.click("idProjectTypeComboBox");
			this.waitForElementPresent("//div[@role='listitem'][" + type + "]",
					WAIT_TIME);
			selenium.mouseDown("//div[@role='listitem'][" + type + "]");
			selenium.fireEvent("idProjectTypeComboBox", "blur");

		}
		// selenium.setSpeed(MIN_SPEED);
		// select project language

		selenium.click("idLanguageInput");
		this.waitForElementPresent("//div[@role='listitem'][1]", WAIT_TIME);
		selenium.mouseDownAt("//div[@role='listitem'][1]", ""
				+ KeyEvent.VK_ENTER);

		// //type project description
		// this.typeString(xpath, value)
		// selenium.type("idDescriptionInput", "adf");
		// selenium.fireEvent("idDescriptionInput", "blur");
		// check advanced checkbox
		selenium.click("idAdvanceInput");
		// type project svn url
		this.typeString("idUrlInput", "url");
		// type svn username
		this.typeString("idLoginInput", "user");
		// type svn password
		this.typeString("idPasswordInput", "password");

		// selenium.setSpeed(MAX_SPEED);
		this.typeString("idDescriptionInput", "description_");
		selenium.click("idAdvanceInput");
		// selenium.focus("idFormSaveButton");
		// selenium.keyDownNative(""+KeyEvent.VK_ENTER);
		// selenium.keyUpNative(""+KeyEvent.VK_ENTER);
		selenium.click("//div[text()='Projects']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idFormSaveButton']");

		if (types.contains(typeStr)) {
			this.waitForElementPresent(
					"//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
							+ projectname + "')]", WAIT_TIME);
			Assert.assertTrue(
					selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
							+ projectname + "')]"), typeStr
							+ " project added failed");

			selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
					+ projectname + "')]");
			Thread.sleep(2000);
			selenium.chooseOkOnNextConfirmation();
			selenium.click("//div[text()='Projects']/ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleDeleteButton']");
			// selenium.setSpeed(MAX_SPEED);
			assert (selenium.getConfirmation().matches(other
					.getString("delete.project.warning")));
		} else {
			Thread.sleep(5000);
			Assert.assertFalse(
					selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
							+ projectname + "')]"), typeStr
							+ " project added failed");
		}
		selenium.setSpeed(MIN_SPEED);

	}

	public void addUserAllow(int type, int n, List<String> types)
			throws InterruptedException {
		this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idMenuUserElement");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']",
				WAIT_TIME);
		String username = "";
		String usernamepre = null;
		String name = "";
		String namepre = null;
		String typeStr = "";
		if (type == 1) {
			typeStr += "Data Integration";
			usernamepre = "DI_";
			namepre = "DI";
		} else if (type == 2) {
			typeStr += "Data Quality";
			usernamepre = "DQ_";
			namepre = "DQ";
		} else {
			typeStr += "Master Data Management";
			usernamepre = "MDM_";
			namepre = "MDM";
		}
		for (int i = 0; i < n; i++) {
			username = usernamepre + i + "@talend.com";
			name = namepre + i;
			//
			selenium.refresh();
			this.waitForElementPresent("idSubModuleAddButton", WAIT_TIME);
			selenium.click("idSubModuleAddButton");
			selenium.type("idUserLoginInput", username);
			selenium.fireEvent("idUserLoginInput", "blur");
			selenium.type("idUserFirstNameInput", name);
			selenium.fireEvent("idUserFirstNameInput", "blur");
			selenium.type("idUserLastNameInput", name);
			selenium.fireEvent("idUserLastNameInput", "blur");
			selenium.type("idUserPasswordInput", name);
			selenium.fireEvent("idUserPasswordInput", "blur");
			selenium.type("//input[@name='authenticationLogin']", "admin");
			selenium.fireEvent("//input[@name='authenticationLogin']", "blur");
			selenium.type("//input[@name='authenticationPassword']", "admin");
			selenium.fireEvent("//input[@name='authenticationPassword']",
					"blur");
			// selenium.click("idTypeInput");
			// selenium.mouseDownAt("//div[@role='listitem'][2]", "" +
			// Event.ENTER);
			this.selectDropDownList("//input[@id='idTypeInput']", type);
			Assert.assertEquals(selenium.getValue("idTypeInput"), typeStr);
			String roles = rb.getString("menu.role.administrator") + "/"
					+ rb.getString("menu.role.viewer") + "/"
					+ rb.getString("menu.role.operationManager") + "/"
					+ rb.getString("menu.role.designer");
			selenium.click("idRoleButton");
			this.waitForElementPresent("//span[text()='Roles Selection']",
					Base.WAIT_TIME);
			// selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isTextPresent(rb
					.getString("user.roles.title")));
			selenium.click("//span[text()='Role']/parent::div[not(contains(@style,'display: none'))]/" +
		    		"parent::td[not(contains(@style,'display: none'))]/preceding-sibling::td" +
		    		"[not(contains(@style,'display: none'))]/div[@class=' x-grid3-hd-inner x-grid3-hd-checker x-component']");
			selenium.click("idValidateButton");
			// selenium.setSpeed(MAX_SPEED);
			Assert.assertEquals(selenium.getValue("idActiveInput"), roles);
			//
			selenium.click("idFormSaveButton");

			/*
			 * Assert.assertTrue(selenium.isTextPresent(username),
			 * "testAddMaxAmountsDQUsersAllowed  failed!");
			 */
			if (types.contains(typeStr)) {
				this.waitForElementPresent(
						"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
								+ username + "']", MAX_WAIT_TIME);
				selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
						+ username + "']");
				Thread.sleep(2000);
				Assert.assertTrue(selenium.getValue("//input[@name='active']")
						.equals("on"));
			} else {
				Thread.sleep(5000);
				Assert.assertFalse(selenium
						.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
								+ username + "']"));
			}

			selenium.setSpeed(MIN_SPEED);
		}

	}

	public void addUsersMoreOver(int type, int n) throws InterruptedException {
		this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idMenuUserElement");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']",
				WAIT_TIME);
		String username = "";
		String usernamepre = null;
		String name = "";
		String namepre = null;
		String typeStr = "";
		if (type == 1) {
			typeStr += "Data Integration";
			usernamepre = "DI_";
			namepre = "DI";
		} else if (type == 2) {
			typeStr += "Data Quality";
			usernamepre = "DQ_";
			namepre = "DQ";
		} else {
			typeStr += "Master Data Management";
			usernamepre = "MDM_";
			namepre = "MDM";
		}
		for (int i = 0; i <= n; i++) {
			username = usernamepre + i + "@talend.com";
			name = namepre + i;
			//
			selenium.refresh();
			this.waitForElementPresent("idSubModuleAddButton", WAIT_TIME);
			selenium.click("idSubModuleAddButton");
			selenium.type("idUserLoginInput", username);
			selenium.fireEvent("idUserLoginInput", "blur");
			selenium.type("idUserFirstNameInput", name);
			selenium.fireEvent("idUserFirstNameInput", "blur");
			selenium.type("idUserLastNameInput", name);
			selenium.fireEvent("idUserLastNameInput", "blur");
			selenium.type("idUserPasswordInput", name);
			selenium.fireEvent("idUserPasswordInput", "blur");
			selenium.type("//input[@name='authenticationLogin']", "admin");
			selenium.fireEvent("//input[@name='authenticationLogin']", "blur");
			selenium.type("//input[@name='authenticationPassword']", "admin");
			selenium.fireEvent("//input[@name='authenticationPassword']",
					"blur");
			// selenium.click("idTypeInput");
			// selenium.mouseDownAt("//div[@role='listitem'][2]", "" +
			// Event.ENTER);
			this.selectDropDownList("//input[@id='idTypeInput']", type);
			Assert.assertEquals(selenium.getValue("idTypeInput"), typeStr);
			String roles = rb.getString("menu.role.administrator") + "/"
					+ rb.getString("menu.role.viewer") + "/"
					+ rb.getString("menu.role.operationManager") + "/"
					+ rb.getString("menu.role.designer");
			selenium.click("idRoleButton");
			this.waitForElementPresent("//span[text()='Roles Selection']",
					Base.WAIT_TIME);
			// selenium.setSpeed(MID_SPEED);
			// Assert.assertTrue(selenium.isTextPresent(rb
			// .getString("user.roles.title")));
			// selenium.setSpeed(MIN_SPEED);
			selenium.click("//span[text()='Role']/parent::div[not(contains(@style,'display: none'))]/" +
		    		"parent::td[not(contains(@style,'display: none'))]/preceding-sibling::td" +
		    		"[not(contains(@style,'display: none'))]/div[@class=' x-grid3-hd-inner x-grid3-hd-checker x-component']");
			selenium.click("idValidateButton");
			// selenium.setSpeed(MAX_SPEED);
			Assert.assertEquals(selenium.getValue("idActiveInput"), roles);
			//
			selenium.click("idFormSaveButton");

			if (i != n) {
				this.waitForElementPresent(
						"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
								+ username + "']", WAIT_TIME);
				Assert.assertTrue(selenium.isTextPresent(username), "test "
						+ namepre + " users more over failed!");
			} else {
				// Assert.assertTrue(
				// selenium.isTextPresent("Save failed: You are using "
				// + (n - 1)
				// + " DQ users, but your license allows only "
				// + (n - 1)
				// +
				// ", please contact your talend account manager -- For more information see your log file"),
				// "test failed!");
				Thread.sleep(5000);
				Assert.assertFalse(selenium.isTextPresent(username), "test "
						+ namepre + " users more over failed!");
			}
			selenium.setSpeed(MIN_SPEED);
		}
		cleanAllExceptAdmin();
	}

	@Test
	public void testAddMaxAmountsMDMUsersAllowed() throws InterruptedException {
		// cleanAllExceptAdmin();
		int n = getMDMcounts();
		// System.out.println("MDM:"+n);
		if(n!=-1){
		addUserallowed(3, n);
		}

	}

	@Test
	public void testMDMUsersMoreOver() throws InterruptedException {
		// cleanAllExceptAdmin();
		int n = getMDMcounts();
		if(n!=-1){
		this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idMenuUserElement");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='MDM_1@talend.com']",
				WAIT_TIME);
		String username = "MDM_1@talend.com";
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
				+ username + "']");
		Thread.sleep(2000);
		username = "Copy_of_" + username;
		selenium.click("idSubModuleDuplicateButton");
		Thread.sleep(2000);
		this.typeString("idUserPasswordInput", "admin");
		selenium.click("idFormSaveButton");
		Thread.sleep(10000);
		Assert.assertFalse(selenium.isTextPresent(username),
				"test mdm users more over failed!");
		}
	}

	@Test
	public void testDIUsersMoreOver() throws InterruptedException {

		int n = getDIcounts();
		this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idMenuUserElement");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']",
				WAIT_TIME);
		String username = selenium
				.getText("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']");
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
				+ username + "']");
		Thread.sleep(2000);
		username = "Copy_of_" + username;
		selenium.click("idSubModuleDuplicateButton");
		Thread.sleep(2000);
		this.typeString("idUserPasswordInput", "admin");
		selenium.click("idFormSaveButton");
		Thread.sleep(5000);
		Assert.assertFalse(selenium.isTextPresent(username),
				"test di users more over failed!");
	}

	public void diUsersMover() throws InterruptedException {
		cleanAllExceptAdmin();
		int n = getDIcounts();
		/*
		 * this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		 * selenium.setSpeed(MIN_SPEED); selenium.click("idMenuUserElement");
		 * this.waitForElementPresent(
		 * "//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']"
		 * , WAIT_TIME); String username = selenium .getText(
		 * "//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']"
		 * ); for (int i = 0; i < n ; i++) { selenium.refresh();
		 * Thread.sleep(3000); selenium.mouseDown(
		 * "//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='" +
		 * username + "']"); Thread.sleep(2000); username = "Copy_of_" +
		 * username; // System.out.println(username);
		 * selenium.click("idSubModuleDuplicateButton"); Thread.sleep(2000);
		 * this.typeString("idUserPasswordInput", "admin");
		 * selenium.click("idFormSaveButton"); Thread.sleep(5000); if (i != n -
		 * 1) { Assert.assertTrue(selenium.isTextPresent(username),
		 * "test di users more over failed!"); } else { // Assert.assertTrue( //
		 * selenium.isTextPresent("Save failed: You are using " // + (n - 1) //
		 * + " DI users, but your license allows only " // + (n - 1) // +
		 * ", please contact your talend account manager -- For more information see your log file"
		 * ), // "test failed!");
		 * Assert.assertFalse(selenium.isTextPresent(username),
		 * "test di users more over failed!"); } } cleanAllExceptAdmin();
		 */
		addUsersMoreOver(1, n - 1);
		cleanAllExceptAdmin();
	}

	public void dqUsersMover() throws InterruptedException {
		cleanAllExceptAdmin();
		int n = getDQcounts();
		/*
		 * this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		 * selenium.setSpeed(MIN_SPEED); selenium.click("idMenuUserElement");
		 * this.waitForElementPresent(
		 * "//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']"
		 * , WAIT_TIME); String username = ""; String name = ""; for (int i = 0;
		 * i <= n; i++) { username = "DQ_" + i + "@talend.com"; name = "DQ_" +
		 * i; // selenium.refresh();
		 * this.waitForElementPresent("idSubModuleAddButton", WAIT_TIME);
		 * selenium.click("idSubModuleAddButton");
		 * selenium.type("idUserLoginInput", username);
		 * selenium.fireEvent("idUserLoginInput", "blur");
		 * selenium.type("idUserFirstNameInput", name);
		 * selenium.fireEvent("idUserFirstNameInput", "blur");
		 * selenium.type("idUserLastNameInput", name);
		 * selenium.fireEvent("idUserLastNameInput", "blur");
		 * selenium.type("idUserPasswordInput", name);
		 * selenium.fireEvent("idUserPasswordInput", "blur");
		 * selenium.type("//input[@name='authenticationLogin']", "admin");
		 * selenium.fireEvent("//input[@name='authenticationLogin']", "blur");
		 * selenium.type("//input[@name='authenticationPassword']", "admin");
		 * selenium.fireEvent("//input[@name='authenticationPassword']",
		 * "blur"); // selenium.click("idTypeInput"); //
		 * selenium.mouseDownAt("//div[@role='listitem'][2]", "" + Event.ENTER);
		 * this.selectDropDownList("//input[@id='idTypeInput']", 2);
		 * Assert.assertEquals(selenium.getValue("idTypeInput"),
		 * "Data Quality"); String roles =
		 * rb.getString("menu.role.administrator") + "/" +
		 * rb.getString("menu.role.viewer") + "/" +
		 * rb.getString("menu.role.operationManager") + "/" +
		 * rb.getString("menu.role.designer"); selenium.click("idRoleButton");
		 * selenium.setSpeed(MID_SPEED);
		 * Assert.assertTrue(selenium.isTextPresent(rb
		 * .getString("user.roles.title"))); selenium.setSpeed(MIN_SPEED);
		 * selenium.controlKeyDown(); selenium.mouseDown(
		 * "//td[not(contains(@style,'display: none'))]/div[text()='" +
		 * rb.getString("menu.role.administrator") + "']" +
		 * "/parent::td/preceding-sibling::td//div[@class='x-grid3-row-checker']"
		 * ); selenium.mouseDown(
		 * "//td[not(contains(@style,'display: none'))]/div[text()='" +
		 * rb.getString("menu.role.viewer") + "']" +
		 * "/parent::td/preceding-sibling::td//div[@class='x-grid3-row-checker']"
		 * ); selenium.mouseDown(
		 * "//td[not(contains(@style,'display: none'))]/div[text()='" +
		 * rb.getString("menu.role.operationManager") + "']" +
		 * "/parent::td/preceding-sibling::td//div[@class='x-grid3-row-checker']"
		 * ); selenium.mouseDown(
		 * "//td[not(contains(@style,'display: none'))]/div[text()='" +
		 * rb.getString("menu.role.designer") + "']" +
		 * "/parent::td/preceding-sibling::td//div[@class='x-grid3-row-checker']"
		 * ); selenium.controlKeyUp(); selenium.click("idValidateButton");
		 * selenium.setSpeed(MID_SPEED);
		 * Assert.assertEquals(selenium.getValue("idActiveInput"), roles); //
		 * selenium.click("idFormSaveButton"); Thread.sleep(5000); if (i != n )
		 * { Assert.assertTrue(selenium.isTextPresent(username),
		 * "test dq users more over failed!"); } else { // Assert.assertTrue( //
		 * selenium.isTextPresent("Save failed: You are using " // + (n - 1) //
		 * + " DQ users, but your license allows only " // + (n - 1) // +
		 * ", please contact your talend account manager -- For more information see your log file"
		 * ), // "test failed!");
		 * Assert.assertFalse(selenium.isTextPresent(username),
		 * "test dq users more over failed!"); } selenium.setSpeed(MIN_SPEED); }
		 */
		addUsersMoreOver(2, n);
		cleanAllExceptAdmin();
	}

	@Test
	public void testDIUsersMoreOverUnactive() throws InterruptedException {
		// cleanAllExceptAdmin();
		int n = getDIcounts();
		this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idMenuUserElement");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']",
				WAIT_TIME);
		String username = selenium
				.getText("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']");
		int i = 0;
		selenium.refresh();
		Thread.sleep(3000);
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
				+ username + "']", WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
				+ username + "']");
		Thread.sleep(2000);
		username = "Copy_of_" + username;
		// System.out.println(username);
		selenium.click("idSubModuleDuplicateButton");
		Thread.sleep(2000);
		this.typeString("idUserPasswordInput", "admin");
		// uncheck active
		if (i == 0) {
			selenium.click("//input[@name='active']");
		}

		selenium.click("idFormSaveButton");
		Thread.sleep(5000);
		Assert.assertFalse(selenium.isTextPresent(username),
				"user duplicated failed!");

		// cleanAllExceptAdmin();
	}

	@Test
	public void testDIUsersMoreOverUnactiveReactive()
			throws InterruptedException {
		// cleanAllExceptAdmin();
		int n = getDIcounts();
		this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idMenuUserElement");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']",
				WAIT_TIME);
		String username = selenium
				.getText("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']");
		String usernameReuse = username;

		for (int j = 0; j < 3; j++) {
			usernameReuse = "DI_" + j + "@talend.com";
			selenium.refresh();
			this.waitForElementPresent(
					"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
							+ usernameReuse + "']", WAIT_TIME);
			selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
					+ usernameReuse + "']");
			Thread.sleep(2000);
			String valuebefore = selenium.getValue("//input[@name='active']");
			// System.out.println(valuebefore);
			Assert.assertTrue(valuebefore.equals("on"));
			selenium.click("//input[@name='active']");
			// selenium.setSpeed(MID_SPEED);
			selenium.click("idFormSaveButton");
			Thread.sleep(3000);
			selenium.refresh();
			this.waitForElementPresent(
					"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
							+ usernameReuse + "']", WAIT_TIME);
			selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
					+ usernameReuse + "']");
			Thread.sleep(1000);
			String valueafter = selenium.getValue("//input[@name='active']");
			// System.out.println(valueafter);
			Assert.assertTrue(valueafter.equals("off"));
		}

		//
		username = selenium
				.getText("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']");
		int i = 0;
		selenium.refresh();
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
						+ username + "']", WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
				+ username + "']");
		Thread.sleep(2000);
		username = "Copy_of_" + username;
		// System.out.println(username);
		selenium.click("idSubModuleDuplicateButton");
		Thread.sleep(1000);
		this.typeString("idUserPasswordInput", "admin");
		// uncheck active
		if (i == 0) {
			selenium.click("//input[@name='active']");
		}

		selenium.click("idFormSaveButton");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
						+ username + "']", WAIT_TIME);
		// reactive
		for (int j = 0; j < 3; j++) {
			usernameReuse = "DI_" + j + "@talend.com";
			selenium.refresh();
			this.waitForElementPresent(
					"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
							+ usernameReuse + "']", WAIT_TIME);
			selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
					+ usernameReuse + "']");
			Thread.sleep(1000);
			String valuebefore = selenium.getValue("//input[@name='active']");
			// System.out.println(valuebefore);
			Assert.assertTrue(valuebefore.equals("off"));
			selenium.click("//input[@name='active']");
			selenium.setSpeed(MID_SPEED);
			selenium.click("idFormSaveButton");
			Thread.sleep(3000);
			selenium.refresh();
			this.waitForElementPresent(
					"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
							+ usernameReuse + "']", WAIT_TIME);
			selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
					+ usernameReuse + "']");
			Thread.sleep(1000);
			String valueafter = selenium.getValue("//input[@name='active']");
			// System.out.println(valueafter);
			Assert.assertTrue(valueafter.equals("on"));
		}
		username = "Copy_of_admin@company.com";
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
				+ username + "']");
		Thread.sleep(2000);
		selenium.click("//input[@name='active']");
		selenium.click("idFormSaveButton");
		Thread.sleep(3000);
		selenium.refresh();
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
						+ username + "']", WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
				+ username + "']");
		Assert.assertTrue(
				selenium.getValue("//input[@name='active']").equals("off"),
				"user duplicated failed!");
		selenium.setSpeed(MIN_SPEED);
		//

		// cleanAllExceptAdmin();
	}

	@Test
	public void testDQUsersMoreOver() throws InterruptedException {
		// cleanAllExceptAdmin();
		int n = getDQcounts();
		this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idMenuUserElement");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']",
				WAIT_TIME);
		String username = "DQ_" + 0 + "@talend.com";
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
				+ username + "']");
		Thread.sleep(2000);
		username = "Copy_of_DQ_" + 0 + "@talend.com";
		selenium.click("idSubModuleDuplicateButton");
		Thread.sleep(2000);
		this.typeString("idUserPasswordInput", "admin");
		selenium.click("idFormSaveButton");
		Thread.sleep(5000);
		Assert.assertFalse(selenium.isTextPresent(username),
				"test dq users more over failed!");
		// addUsersMoreOver(2,0);
		// cleanAllExceptAdmin();

	}

	public void addUsersMoreOverUnactive(int type, int n)
			throws InterruptedException {
		this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idMenuUserElement");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']",
				WAIT_TIME);
		String username = "";
		String usernamepre = null;
		String name = "";
		String namepre = null;
		String typeStr = "";
		if (type == 1) {
			typeStr += "Data Integration";
			usernamepre = "DI_";
			namepre = "DI";
		} else if (type == 2) {
			typeStr += "Data Quality";
			usernamepre = "DQ_";
			namepre = "DQ";
		} else {
			typeStr += "Master Data Management";
			usernamepre = "MDM_";
			namepre = "MDM";
		}
		for (int i = 0; i < n + 5; i++) {
			username = usernamepre + i + "@talend.com";
			name = namepre + i;
			//
			selenium.refresh();
			this.waitForElementPresent("idSubModuleAddButton", WAIT_TIME);
			selenium.click("idSubModuleAddButton");
			selenium.type("idUserLoginInput", username);
			selenium.fireEvent("idUserLoginInput", "blur");
			selenium.type("idUserFirstNameInput", name);
			selenium.fireEvent("idUserFirstNameInput", "blur");
			selenium.type("idUserLastNameInput", name);
			selenium.fireEvent("idUserLastNameInput", "blur");
			selenium.type("idUserPasswordInput", name);
			selenium.fireEvent("idUserPasswordInput", "blur");
			selenium.type("//input[@name='authenticationLogin']", "admin");
			selenium.fireEvent("//input[@name='authenticationLogin']", "blur");
			selenium.type("//input[@name='authenticationPassword']", "admin");
			selenium.fireEvent("//input[@name='authenticationPassword']",
					"blur");
			// selenium.click("idTypeInput");
			// selenium.mouseDownAt("//div[@role='listitem'][2]", "" +
			// Event.ENTER);
			this.selectDropDownList("//input[@id='idTypeInput']", type);
			Assert.assertEquals(selenium.getValue("idTypeInput"), typeStr);
			String roles = rb.getString("menu.role.administrator") + "/"
					+ rb.getString("menu.role.viewer") + "/"
					+ rb.getString("menu.role.operationManager") + "/"
					+ rb.getString("menu.role.designer");
			selenium.click("idRoleButton");
			selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isTextPresent(rb
					.getString("user.roles.title")));
			selenium.setSpeed(MIN_SPEED);
			selenium.click("//span[text()='Role']/parent::div[not(contains(@style,'display: none'))]/" +
		    		"parent::td[not(contains(@style,'display: none'))]/preceding-sibling::td" +
		    		"[not(contains(@style,'display: none'))]/div[@class=' x-grid3-hd-inner x-grid3-hd-checker x-component']");
			selenium.click("idValidateButton");
			selenium.setSpeed(MID_SPEED);
			Assert.assertEquals(selenium.getValue("idActiveInput"), roles);
			selenium.click("//input[@name='active']");
			//
			selenium.click("idFormSaveButton");
			Thread.sleep(5000);
			Assert.assertTrue(selenium.isTextPresent(username),
					"user duplicated failed!");
			selenium.setSpeed(MIN_SPEED);
		}
		cleanAllExceptAdmin();

	}

	public void addUsersMoreOverUnactiveReactive(int type, int n)
			throws InterruptedException {
		this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idMenuUserElement");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']",
				WAIT_TIME);
		String username = "";
		String usernamepre = null;
		String name = "";
		String namepre = null;
		String typeStr = "";
		if (type == 1) {
			typeStr += "Data Integration";
			usernamepre = "DI_";
			namepre = "DI";
		} else if (type == 2) {
			typeStr += "Data Quality";
			usernamepre = "DQ_";
			namepre = "DQ";
		} else {
			typeStr += "Master Data Management";
			usernamepre = "MDM_";
			namepre = "MDM";
		}
		for (int i = 0; i < n + 5; i++) {
			username = usernamepre + i + "@talend.com";
			name = namepre + i;
			//
			selenium.refresh();
			this.waitForElementPresent("idSubModuleAddButton", WAIT_TIME);
			selenium.click("idSubModuleAddButton");
			selenium.type("idUserLoginInput", username);
			selenium.fireEvent("idUserLoginInput", "blur");
			selenium.type("idUserFirstNameInput", name);
			selenium.fireEvent("idUserFirstNameInput", "blur");
			selenium.type("idUserLastNameInput", name);
			selenium.fireEvent("idUserLastNameInput", "blur");
			selenium.type("idUserPasswordInput", name);
			selenium.fireEvent("idUserPasswordInput", "blur");
			selenium.type("//input[@name='authenticationLogin']", "admin");
			selenium.fireEvent("//input[@name='authenticationLogin']", "blur");
			selenium.type("//input[@name='authenticationPassword']", "admin");
			selenium.fireEvent("//input[@name='authenticationPassword']",
					"blur");
			// selenium.click("idTypeInput");
			// selenium.mouseDownAt("//div[@role='listitem'][2]", "" +
			// Event.ENTER);
			this.selectDropDownList("//input[@id='idTypeInput']", type);
			Assert.assertEquals(selenium.getValue("idTypeInput"), typeStr);
			String roles = rb.getString("menu.role.administrator") + "/"
					+ rb.getString("menu.role.viewer") + "/"
					+ rb.getString("menu.role.operationManager") + "/"
					+ rb.getString("menu.role.designer");
			selenium.click("idRoleButton");
			selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isTextPresent(rb
					.getString("user.roles.title")));
			selenium.setSpeed(MIN_SPEED);
			selenium.click("//span[text()='Role']/parent::div[not(contains(@style,'display: none'))]/" +
		    		"parent::td[not(contains(@style,'display: none'))]/preceding-sibling::td" +
		    		"[not(contains(@style,'display: none'))]/div[@class=' x-grid3-hd-inner x-grid3-hd-checker x-component']");
			selenium.click("idValidateButton");
			selenium.setSpeed(MID_SPEED);
			Assert.assertEquals(selenium.getValue("idActiveInput"), roles);
			selenium.click("//input[@name='active']");
			//
			selenium.click("idFormSaveButton");
			Thread.sleep(5000);
			Assert.assertTrue(selenium.isTextPresent(username),
					"user duplicated failed!");
			selenium.setSpeed(MIN_SPEED);
		}
		for (int i = 0; i <= n; i++) {
			username = usernamepre + i + "@talend.com";
			selenium.refresh();
			Thread.sleep(3000);
			selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
					+ username + "']");
			Thread.sleep(2000);
			String valuebefore = selenium.getValue("//input[@name='active']");
			Assert.assertTrue(valuebefore.equals("off"));
			selenium.click("//input[@name='active']");
			selenium.click("idFormSaveButton");
			Thread.sleep(3000);
			selenium.refresh();
			Thread.sleep(3000);
			selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
					+ username + "']");
			Thread.sleep(3000);
			String valueafter = selenium.getValue("//input[@name='active']");
			if (i == n) {
				// Assert.assertTrue(selenium.isTextPresent("Save failed: You are using "+(n-1)+" DQ users, but your license allows only "+(n-1)+", please contact your talend account manager -- For more information see your log file"),
				// "test failed!");
				Assert.assertFalse(valueafter.equals("on"));
			} else {
				Assert.assertTrue(valueafter.equals("on"));
			}
		}
		cleanAllExceptAdmin();
	}

	@Test
	public void testMDMUsersMoreOverUnactive() throws InterruptedException {
		// cleanAllExceptAdmin();
		int n = getMDMcounts();
		this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		selenium.click("idMenuUserElement");
		if(n!=-1){
		String username = "";
		String name = "";
		for (int i = 0; i < 1; i++) {
			username = "MDM_over@talend.com";		
			name = "DQ_" + i;
			//
			selenium.refresh();
			this.waitForElementPresent("idSubModuleAddButton", WAIT_TIME*2);
			selenium.click("idSubModuleAddButton");
			selenium.type("idUserLoginInput", username);
			selenium.fireEvent("idUserLoginInput", "blur");
			selenium.type("idUserFirstNameInput", name);
			selenium.fireEvent("idUserFirstNameInput", "blur");
			selenium.type("idUserLastNameInput", name);
			selenium.fireEvent("idUserLastNameInput", "blur");
			selenium.type("idUserPasswordInput", name);
			selenium.fireEvent("idUserPasswordInput", "blur");
			selenium.type("//input[@name='authenticationLogin']", "admin");
			selenium.fireEvent("//input[@name='authenticationLogin']", "blur");
			selenium.type("//input[@name='authenticationPassword']", "admin");
			selenium.fireEvent("//input[@name='authenticationPassword']",
					"blur");
			// selenium.click("idTypeInput");
			// selenium.mouseDownAt("//div[@role='listitem'][2]", "" +
			// Event.ENTER);
			this.selectDropDownList("//input[@id='idTypeInput']", 3);
			Assert.assertEquals(selenium.getValue("idTypeInput"),
					"Master Data Management");
			String roles = rb.getString("menu.role.administrator") + "/"
					+ rb.getString("menu.role.viewer") + "/"
					+ rb.getString("menu.role.operationManager") + "/"
					+ rb.getString("menu.role.designer");
			selenium.click("idRoleButton");
			this.waitForElementPresent("//span[text()='Roles Selection']",
					Base.WAIT_TIME);
			selenium.click("//span[text()='Role']/parent::div[not(contains(@style,'display: none'))]/" +
		    		"parent::td[not(contains(@style,'display: none'))]/preceding-sibling::td" +
		    		"[not(contains(@style,'display: none'))]/div[@class=' x-grid3-hd-inner x-grid3-hd-checker x-component']");
			selenium.click("idValidateButton");
			selenium.setSpeed(MID_SPEED);
			Assert.assertEquals(selenium.getValue("idActiveInput"), roles);
			selenium.click("//input[@name='active']");
			//
			selenium.click("idFormSaveButton");
			Thread.sleep(10000);
			Assert.assertFalse(selenium.isTextPresent(username),
					"MDM inactive user test failed!");
			selenium.setSpeed(MIN_SPEED);
		}
		}
		// addUsersMoreOverUnactive(3,n);

	}

	@Test
	public void testMDMUsersMoreOverUnactiveReactive()
			throws InterruptedException {
		// cleanAllExceptAdmin();
		int n = getMDMcounts();
		if(n!=-1){
		this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idMenuUserElement");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']",
				WAIT_TIME);
		String username = "";
		String name = "";
		//
		for (int i = 0; i < 3; i++) {
			username = "MDM_" + i + "@talend.com";
			name = "MDM_" + i;
			//
			selenium.refresh();
			this.waitForElementPresent(
					"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
							+ username + "']", WAIT_TIME);
			selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
					+ username + "']");
			Thread.sleep(1000);
			selenium.click("//input[@name='active']");
			//
			selenium.click("idFormSaveButton");
			Thread.sleep(5000);
			Assert.assertTrue(selenium.getValue("//input[@name='active']")
					.equals("off"), "dq inactive  failed!");
			selenium.setSpeed(MIN_SPEED);
		}
		//
		username = "MDM_1@talend.com";
		selenium.refresh();
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
						+ username + "']", WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
				+ username + "']");
		Thread.sleep(1000);
		selenium.click("idSubModuleDuplicateButton");
		this.typeString("idUserPasswordInput", "adf");
		selenium.click("idFormSaveButton");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='Copy_of_"
						+ username + "']", WAIT_TIME);
		for (int i = 0; i < 3; i++) {
			username = "MDM_" + i + "@talend.com";
			name = "MDM_" + i;
			//
			selenium.refresh();
			this.waitForElementPresent(
					"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
							+ username + "']", WAIT_TIME);
			selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
					+ username + "']");
			Thread.sleep(1000);
			selenium.click("//input[@name='active']");
			//
			selenium.click("idFormSaveButton");
			Thread.sleep(3000);
			Assert.assertTrue(selenium.getValue("//input[@name='active']")
					.equals("on"), "dq inactive  failed!");
			selenium.setSpeed(MIN_SPEED);
		}
		username = "MDM_1@talend.com";
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='Copy_of_"
				+ username + "']");
		Thread.sleep(1000);
		selenium.click("//input[@name='active']");
		//
		selenium.click("idFormSaveButton");
		Thread.sleep(3000);
		selenium.refresh();
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='Copy_of_"
						+ username + "']", WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='Copy_of_"
				+ username + "']");
		Thread.sleep(1000);
		Assert.assertFalse(
				selenium.getValue("//input[@name='active']").equals("on"),
				"dq inactive  failed!");
		}
	}

	@Test
	public void testDQUsersMoreOverUnactive() throws InterruptedException {
		// cleanAllExceptAdmin();
		int n = getDQcounts();
		this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idMenuUserElement");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']",
				WAIT_TIME);
		String username = "";
		String name = "";
		for (int i = 0; i < 1; i++) {
			username = "DQ_over@talend.com";
			name = "DQ_" + i;
			//
			selenium.refresh();
			this.waitForElementPresent("idSubModuleAddButton", WAIT_TIME);
			selenium.click("idSubModuleAddButton");
			selenium.type("idUserLoginInput", username);
			selenium.fireEvent("idUserLoginInput", "blur");
			selenium.type("idUserFirstNameInput", name);
			selenium.fireEvent("idUserFirstNameInput", "blur");
			selenium.type("idUserLastNameInput", name);
			selenium.fireEvent("idUserLastNameInput", "blur");
			selenium.type("idUserPasswordInput", name);
			selenium.fireEvent("idUserPasswordInput", "blur");
			selenium.type("//input[@name='authenticationLogin']", "admin");
			selenium.fireEvent("//input[@name='authenticationLogin']", "blur");
			selenium.type("//input[@name='authenticationPassword']", "admin");
			selenium.fireEvent("//input[@name='authenticationPassword']",
					"blur");
			// selenium.click("idTypeInput");
			// selenium.mouseDownAt("//div[@role='listitem'][2]", "" +
			// Event.ENTER);
			this.selectDropDownList("//input[@id='idTypeInput']", 2);
			Assert.assertEquals(selenium.getValue("idTypeInput"),
					"Data Quality");
			String roles = rb.getString("menu.role.administrator") + "/"
					+ rb.getString("menu.role.viewer") + "/"
					+ rb.getString("menu.role.operationManager") + "/"
					+ rb.getString("menu.role.designer");
			selenium.click("idRoleButton");
			this.waitForElementPresent("//span[text()='Roles Selection']",
					Base.WAIT_TIME);
			selenium.click("//span[text()='Role']/parent::div[not(contains(@style,'display: none'))]/" +
		    		"parent::td[not(contains(@style,'display: none'))]/preceding-sibling::td" +
		    		"[not(contains(@style,'display: none'))]/div[@class=' x-grid3-hd-inner x-grid3-hd-checker x-component']");
			selenium.click("idValidateButton");
			selenium.setSpeed(MID_SPEED);
			Assert.assertEquals(selenium.getValue("idActiveInput"), roles);
			selenium.click("//input[@name='active']");
			//
			selenium.click("idFormSaveButton");
			Thread.sleep(5000);
			Assert.assertFalse(selenium.isTextPresent(username),
					"dq inactive user test failed!");
			selenium.setSpeed(MIN_SPEED);
		}

	}

	@Test
	public void testDQUsersMoreOverUnactiveReactive()
			throws InterruptedException {
		// cleanAllExceptAdmin();
		int n = getDQcounts();
		// System.out.println("DQ:"+n);
		this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idMenuUserElement");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='admin@company.com']",
				WAIT_TIME);
		String username = "";
		String name = "";
		//
		for (int i = 0; i < 3; i++) {
			username = "DQ_" + i + "@talend.com";
			name = "DQ_" + i;
			//
			selenium.refresh();
			this.waitForElementPresent(
					"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
							+ username + "']", WAIT_TIME);
			selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
					+ username + "']");
			Thread.sleep(1000);
			selenium.click("//input[@name='active']");
			//
			selenium.click("idFormSaveButton");
			Thread.sleep(3000);
			Assert.assertTrue(selenium.getValue("//input[@name='active']")
					.equals("off"), "dq inactive  failed!");
			selenium.setSpeed(MIN_SPEED);
		}
		//
		username = "DQ_1@talend.com";
		selenium.refresh();
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
						+ username + "']", WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
				+ username + "']");
		Thread.sleep(1000);
		selenium.click("idSubModuleDuplicateButton");
		this.typeString("idUserPasswordInput", "adf");
		selenium.click("idFormSaveButton");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='Copy_of_"
						+ username + "']", WAIT_TIME);
		for (int i = 0; i < 3; i++) {
			username = "DQ_" + i + "@talend.com";
			name = "DQ_" + i;
			//
			selenium.refresh();
			this.waitForElementPresent(
					"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
							+ username + "']", WAIT_TIME);
			selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='"
					+ username + "']");
			Thread.sleep(1000);
			selenium.click("//input[@name='active']");
			//
			selenium.click("idFormSaveButton");
			Thread.sleep(3000);
			Assert.assertTrue(selenium.getValue("//input[@name='active']")
					.equals("on"), "dq inactive  failed!");
			selenium.setSpeed(MIN_SPEED);
		}
		username = "DQ_1@talend.com";
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='Copy_of_"
				+ username + "']");
		Thread.sleep(1000);
		selenium.click("//input[@name='active']");
		//
		selenium.click("idFormSaveButton");
		Thread.sleep(3000);
		selenium.refresh();
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='Copy_of_"
						+ username + "']", WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-login' and text()='Copy_of_"
				+ username + "']");
		Thread.sleep(1000);
		Assert.assertFalse(
				selenium.getValue("//input[@name='active']").equals("on"),
				"dq inactive  failed!");

		// cleanAllExceptAdmin();
	}

	public List<String> getUserTypes() throws InterruptedException {
		List<String> types = new ArrayList<String>();
		this.waitForElementPresent("idMenuLicenseElement", WAIT_TIME);
		selenium.click("idMenuLicenseElement");
		this.waitForElementPresent(
				"//span[@class='x-panel-header-text' and text()='License Parameters']",
				WAIT_TIME);
		// selenium.setSpeed("3000");
		if (waitForCondition(
				"//div[@class='gwt-HTML' and text()='Data Integration']", 30)) {
			if (selenium
					.getText("//div[text()='Data Integration']/ancestor::div[@class='x-column-inner']//div[@class='x-progress-text x-progress-text-back']//div") != null) {
				System.out
						.println(selenium
								.getText("//div[text()='Data Integration']/ancestor::div[@class='x-column-inner']//div[@class='x-progress-text x-progress-text-back']//div"));
				types.add("Data Integration");
			}
		}
		if (waitForCondition(
				"//div[@class='gwt-HTML' and text()='Data Quality']", 30)) {
			if (selenium
					.getText("//div[text()='Data Quality']/ancestor::div[@class='x-column-inner']//div[@class='x-progress-text x-progress-text-back']//div") != null) {
				System.out
						.println(selenium
								.getText("//div[text()='Data Quality']/ancestor::div[@class='x-column-inner']//div[@class='x-progress-text x-progress-text-back']//div"));
				types.add("Data Quality");
			}
		}
		if (waitForCondition(
				"//div[@class='gwt-HTML' and text()='Master Data Management']",
				30)) {
			if (selenium
					.getText(
							"//div[text()='Master Data Management']/ancestor::div[@class='x-column-inner']//div[@class='x-progress-text x-progress-text-back']//div")
					.contains("/")) {
				System.out
						.println(selenium
								.getText("//div[text()='Master Data Management']/ancestor::div[@class='x-column-inner']//div[@class='x-progress-text x-progress-text-back']//div"));
				types.add("Master Data Management");
			}
		}
		return types;
	}

	public boolean waitForCondition(String locator, int seconds)
			throws InterruptedException {
		boolean conditionPresent = true;
		for (int second = 0;; second++) {
			if (second >= seconds) {
				conditionPresent = false;
				break;
			}

			if (selenium.isElementPresent(locator)) {
				break;
			} else {
				Thread.sleep(1000);
			}
		}

		return conditionPresent;
	}

	public int getDIcounts() {
		this.waitForElementPresent("idMenuLicenseElement", WAIT_TIME);
		selenium.click("idMenuLicenseElement");
		this.waitForElementPresent(
				"//span[@class='x-panel-header-text' and text()='License Parameters']",
				WAIT_TIME);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String allowedDI = selenium
				.getText("//div[text()='Data Integration']/ancestor::div[@class='x-column-inner']//div[@class='x-progress-text x-progress-text-back']//div");
		String num = allowedDI.split("/")[1];
		num = num.substring(num.indexOf(" ") + 1, num.length());
		return ((int) Math.ceil((Integer.parseInt(num)) * (moreOver + 1.0)));

	}

	public int getDQcounts() {
		this.waitForElementPresent("idMenuLicenseElement", WAIT_TIME);
		selenium.click("idMenuLicenseElement");
		this.waitForElementPresent(
				"//span[@class='x-panel-header-text' and text()='License Parameters']",
				WAIT_TIME);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String allowedDI = selenium
				.getText("//div[text()='Data Quality']/ancestor::div[@class='x-column-inner']//div[@class='x-progress-text x-progress-text-back']//div");
		String num = allowedDI.split("/")[1];
		num = num.substring(num.indexOf(" ") + 1, num.length());
		return ((int) Math.ceil((Integer.parseInt(num)) * (moreOver + 1.0)));
	}

	public int getMDMcounts() {
		this.waitForElementPresent("idMenuLicenseElement", WAIT_TIME);
		selenium.click("idMenuLicenseElement");
		this.waitForElementPresent(
				"//span[@class='x-panel-header-text' and text()='License Parameters']",
				WAIT_TIME);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if(this.findSpecialMachedString("^Defined Master Data Management users.*").equals("")){
			return -1;
		}
		else{
		String allowedMDM = selenium
				.getText("//div[text()='Master Data Management']/ancestor::div[@class='x-column-inner']//div[@class='x-progress-text x-progress-text-back']//div");
		String num = allowedMDM.split("/")[1];
		num = num.substring(num.indexOf(" ") + 1, num.length());
		System.out.println("mdm num:" + num);
		return ((int) Math.ceil((Integer.parseInt(num)) * (moreOver + 1.0)));
	      }
	}

	public void cleanAllExceptAdmin() {
		List<String> users = new ArrayList<String>();
		this.clickWaitForElementPresent("idMenuUserElement");
		users = this.findSpecialMachedStrings(".*@[a-zA-Z0-9]*\\.com");
		// users = this.findSpecialMachedStrings(".[A-Za-z]*\\ to ");
		for (int i = 0; i < users.size(); i++) {
			// System.out.println(users.get(i));
			if (!"admin@company.com".equals(users.get(i))) {
				selenium.mouseDown("//div[text()='" + users.get(i) + "']");
				selenium.chooseOkOnNextConfirmation();
				selenium.click("idSubModuleDeleteButton");
				selenium.setSpeed(MID_SPEED);
				selenium.getConfirmation();
//				Assert.assertEquals(selenium.getConfirmation(), other.getString("delete.User.confirmation"));
				selenium.setSpeed(MIN_SPEED);
			}

		}
	}

	// @Test
	@Parameters({ "license.file.path" })
	public void testAllLicenses(String licensePath) throws InterruptedException {
		System.out.println(licensePath);
		// selenium.setSpeed(MID_SPEED);
		addLicense(licensePath);
		selenium.setSpeed(MIN_SPEED);
		List<String> types = getUserTypes();
		// String[] licenseFiles =null;
		// File f = new File(licensePath);
		// if(f.isDirectory()){
		// licenseFiles = f.list();
		// }
		// if(licenseFiles!=null){
		//
		// }
		addLicense(licensePath);
		System.out.println("User types allowed:");
		for (int i = 0; i < types.size(); i++) {
			System.out.println(types.get(i));
		}
		addUserAllow(1, 1, types);
		addUserAllow(2, 1, types);
		addUserAllow(3, 1, types);
		cleanAllExceptAdmin();
		if (types.contains("Data Integration")) {
			System.out.println("DI: " + getDIcounts());
			diUsersMover();
		}
		if (types.contains("Data Quality")) {
			System.out.println("DQ: " + getDQcounts());
			dqUsersMover();
		}
		if (types.contains("Master Data Management")) {
			System.out.println("MDM: " + getMDMcounts());
			testMDMUsersMoreOver();
		}
		//
		// this.waitForElementPresent("!!!menu.project.element!!!", WAIT_TIME);
		// new TacCleaner().cleanProjectsNotused(this.selenium);

		addProjectsAllow(1, types);
		addProjectsAllow(2, types);
		addProjectsAllow(3, types);

	}
}
