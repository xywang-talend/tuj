package com.talend.tac.cases.projects;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class Projects extends Login {
	public static int PROJECT_ADD_TYPE_COMMON = 0;
	public static int PROJECT_ADD_TYPE_REF = 1;

	public void openMenuProject() {
		this.clickWaitForElementPresent("!!!menu.project.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Projects']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-fieldset-header-text' and text()='Project'] ",
				WAIT_TIME);
	}

	public void addProjectSVN_DEFAULT(String projectLabel, String projectDes,
			String language, int commonReference, String Type) {
		this.waitForElementPresent("!!!menu.project.element!!!", Base.WAIT_TIME);
		this.clickWaitForElementPresent("!!!menu.project.element!!!");
		this.clickWaitForElementPresent("idSubModuleAddButton");
		this.typeString("idLabelInput", projectLabel);
		
		if (selenium.isVisible("idProjectTypeComboBox")) {
			
			selenium.click("//input[@id='idProjectTypeComboBox']");
			
			selenium.setSpeed(MID_SPEED);
			boolean type = selenium.isElementPresent("//div[text()='" + Type + "' and @role='listitem']");
			selenium.setSpeed(MIN_SPEED);
			
			if(type == false) {
				
				selenium.click("idProjectTypeComboBox");
				this.waitForElementPresent("//div[text()='" + Type + "' and @role='listitem']", WAIT_TIME);
				selenium.mouseDown("//div[text()='" + Type + "' and @role='listitem']");
				selenium.fireEvent("//input[@id='idProjectTypeComboBox']", "blur");
				
			} else {
				
				selenium.mouseDown("//div[text()='" + Type + "' and @role='listitem']");
				selenium.fireEvent("//input[@id='idProjectTypeComboBox']", "blur");
				
			}
			
		}

		if (commonReference == PROJECT_ADD_TYPE_REF) {
			// check reference checkbox
			selenium.click("idReferenceInput");
		}
		selenium.click("idFormSaveButton");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
						+ projectLabel + "')]", WAIT_TIME);
		Assert.assertTrue(
				selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
						+ projectLabel + "')]"),
				"reference project added failed");
		selenium.setSpeed(MIN_SPEED);
	}

	public void addProjectSVN_DEFINED(String projectLabel, String projectDes,
			String language, int proType, String Type, String svnURL,
			String username, String password) {
		this.waitForElementPresent("!!!menu.project.element!!!", Base.WAIT_TIME);
		this.clickWaitForElementPresent("!!!menu.project.element!!!");
		this.clickWaitForElementPresent("idSubModuleAddButton");
		this.typeString("idLabelInput", projectLabel);
		if (selenium.isVisible("idProjectTypeComboBox")) {
			
			selenium.click("//input[@id='idProjectTypeComboBox']");
			
			selenium.setSpeed(MID_SPEED);
			boolean type = selenium.isElementPresent("//div[text()='" + Type + "' and @role='listitem']");
			selenium.setSpeed(MIN_SPEED);
			
			if(type == false) {
				
				selenium.click("idProjectTypeComboBox");
				this.waitForElementPresent("//div[text()='" + Type + "' and @role='listitem']", WAIT_TIME);
				selenium.mouseDown("//div[text()='" + Type + "' and @role='listitem']");
				selenium.fireEvent("//input[@id='idProjectTypeComboBox']", "blur");
				
			} else {
				
				selenium.mouseDown("//div[text()='" + Type + "' and @role='listitem']");
				selenium.fireEvent("//input[@id='idProjectTypeComboBox']", "blur");
				
			}
			
		}
		if (proType == PROJECT_ADD_TYPE_REF) {
			// check reference checkbox
			selenium.click("idReferenceInput");
		}
		selenium.click("idAdvanceInput");
		this.typeString("idUrlInput", svnURL + "/" + projectLabel.toUpperCase() + "/");
		this.typeString("idLoginInput", username);
		this.typeString("idPasswordInput", password);
		selenium.click("idFormSaveButton");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
						+ projectLabel + "')]", WAIT_TIME);
		Assert.assertTrue(
				selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
						+ projectLabel + "')]"),
				"reference project added failed");
		selenium.setSpeed(MIN_SPEED);
	}

	public void duplicateProject(String proname) {

		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
						+ proname + "')]", WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ proname + "')]");// the selected project's id
		selenium.click("idSubModuleDuplicateButton");
		selenium.click("idDescriptionInput");
		selenium.click("idFormSaveButton");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
						+ "Copy_of_" + proname + "')]", WAIT_TIME);
	}

	public void deleteProjectCANCEL(String projectLabel) {
		selenium.refresh();
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
						+ projectLabel + "')]", WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ projectLabel + "')]");
		selenium.chooseCancelOnNextConfirmation();
		selenium.click("idSubModuleDeleteButton");
		Assert.assertTrue(selenium.getConfirmation().contains(other
				.getString("delete.project.warning")));
		this.sleep(5000);
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
						+ projectLabel + "')]", WAIT_TIME);
	}

	public void deleteProjectOK(String projectLabel) {
		selenium.refresh();
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
						+ projectLabel + "')]", Base.WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ projectLabel + "')]");
		selenium.chooseOkOnNextConfirmation();
		selenium.click("idSubModuleDeleteButton");
		Assert.assertTrue(selenium.getConfirmation().contains(other
				.getString("delete.project.warning")));
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ projectLabel + "')]"));
		selenium.setSpeed(MIN_SPEED);
	}

	public void deleteAllProjects() {
		this.openMenuProject();

		for (int i = 0;; i++) {
			this.sleep(2000);
			if (selenium
					.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label']")) {
				selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label']");
				deleteProjectOK(selenium.getValue("idLabelInput").toString());
			} else {
				break;
			}
		}
		selenium.setSpeed(MIN_SPEED);
         
	}

	public void deleteProjectsNotUsed() {
		List<String> projects = new ArrayList<String>();
		// this.clickWaitForElementPresent("idMenuUserElement");
		selenium.click("!!!menu.project.element!!!");
		this.sleep(5000);
		selenium.setSpeed(MIN_SPEED);
		projects = this.findSpecialMachedStrings(".*@[a-zA-Z0-9]*");
		// users = this.findSpecialMachedStrings(".[A-Za-z]*\\ to ");
		for (int i = 0; i < projects.size(); i++) {
			// System.out.println(users.get(i));
			selenium.setSpeed(MIN_SPEED);
			if (projects.get(i).startsWith("test")
					|| projects.get(i).startsWith("Copy_of_")) {
//				selenium.refresh();
				this.waitForElementPresent(
						"//div[@class='x-grid3-cell-inner x-grid3-col-label' and text()='"
								+ projects.get(i) + "']", Base.WAIT_TIME);
				this.sleep(1000);
				selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and text()='"
						+ projects.get(i) + "']");
				this.sleep(2000);
				selenium.chooseOkOnNextConfirmation();
				selenium.click("//div[text()='Projects']/ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleDeleteButton']");
				// selenium.setSpeed(MAX_SPEED);
				Assert.assertTrue(selenium.getConfirmation().contains(other
						.getString("delete.project.warning")));
				selenium.setSpeed(MIN_SPEED);
                selenium.setSpeed(MID_SPEED);
				Assert.assertFalse(selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and text()='"
						+ projects.get(i) + "']"));
				selenium.setSpeed(MIN_SPEED);
			}

		}

	}

}
