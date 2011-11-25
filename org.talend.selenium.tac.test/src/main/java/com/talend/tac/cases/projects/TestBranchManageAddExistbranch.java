package com.talend.tac.cases.projects;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class TestBranchManageAddExistbranch extends Login {
	@Test
	@Parameters({ "AddcommonProjectname", "BranchName" })
	public void testAddProjectbranchexist(String project, String branchname) throws InterruptedException {
		// first add a branch to a project
//		Thread.sleep(5000);
		
		this.waitForElementPresent("!!!menu.project.element!!!", Base.WAIT_TIME);
//		selenium.setSpeed(MID_SPEED);
		this.clickWaitForElementPresent("!!!menu.project.element!!!");//
		// System.out.println(selenium.getBodyText());
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ project + "')]", WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ project + "')]");// the selected project's id
		selenium.click("idBranchManagementButton");
		selenium.setSpeed(MID_SPEED);
		selenium.click("idBranchManagementSourceInput");
		selenium.mouseDown("//div[text()='trunk']");
		selenium.fireEvent("idBranchManagementSourceInput", "blur");
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idBranchManagementTargetInput");
		selenium.type("idBranchManagementTargetInput", branchname);
		selenium.fireEvent("idBranchManagementTargetInput", "blur");
		selenium.setSpeed(MID_SPEED);
		selenium.click("idBranchManagementCreateButton");

		if (selenium.isElementPresent("//span[text()='"
				+ other.getString("project.branchmanage.add.conform") + "']")) {

			selenium.click("//button[text()='"
					+ other.getString("project.branchmanage.add.conform.ok")
					+ "']");
			selenium.setSpeed(MAX_SPEED);
			Assert.assertTrue(selenium
					.isTextPresent("Failed to create branch: Project already contains a branch 'branches/branch' -- For more information see your log file"));
		
		}
		// delete the exist branch
		selenium.setSpeed(MAX_SPEED);
		selenium.mouseDown("//span[text()='" + branchname + "']");
		selenium.contextMenu("//span[text()='" + branchname + "']");
		selenium.mouseOver("delete-item-branch");
		selenium.click("delete-item-branch");
		Assert.assertTrue(selenium.isElementPresent("//button[text()='Yes']"),
				"ok button can not be seen!");
		selenium.click("//button[text()='"
				+ other.getString("project.branchmanage.delete.confor.ok")
				+ "']");
		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");// close
		selenium.setSpeed(MIN_SPEED);
		// check the new close button
		selenium.refresh();
		closeButton(project, branchname);

	}

	public void closeButton(String project, String branchname) {
//		selenium.setSpeed(MID_SPEED);
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ project + "')]", WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ project + "')]");// the selected project's id
		selenium.click("idBranchManagementButton");
		selenium.setSpeed(MAX_SPEED);
		selenium.click("idBranchManagementSourceInput");
		selenium.mouseDown("//div[text()='trunk']");
		selenium.fireEvent("idBranchManagementSourceInput", "blur");
		selenium.setSpeed(MIN_SPEED);
		this.typeString("idBranchManagementTargetInput", branchname);
		selenium.click("idBranchManagementCloseButton");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(
				selenium.isElementPresent("idBranchManagementCloseButton"),
				"Button idBranchManagementCloseButton have no effect!");
		selenium.setSpeed(MIN_SPEED);
	}

}
