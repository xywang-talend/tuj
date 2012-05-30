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

		this.waitForElementPresent("//span[contains(text(),'"
				+ other.getString("project.branchmanage.add.conform") + "')]", WAIT_TIME);
		selenium.click("//button[text()='"
				+ other.getString("project.branchmanage.add.conform.ok")
				+ "']");
		selenium.setSpeed(MAX_SPEED);
		Assert.assertTrue(selenium
				.isTextPresent("Failed to create branch: Project already contains a branch 'branches/branch' -- For more information see your log file"));
		
		// delete the exist branch
		selenium.setSpeed(MAX_SPEED);
		selenium.mouseDown("//span[text()='" + branchname + "']");
		selenium.contextMenu("//span[text()='" + branchname + "']");
		selenium.mouseOver("delete-item-branch");
		selenium.click("delete-item-branch");
		this.waitForElementPresent("//span[contains(text(),'Are you sure  you want to delete this branch')]", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//button[text()='Yes']"),
				"ok button can not be seen!");
		selenium.click("//button[text()='"
				+ other.getString("project.branchmanage.delete.confor.ok")
				+ "']");
		Assert.assertFalse(selenium.isElementPresent("//span[text()='"+branchname+"']"));
		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");// close
		selenium.setSpeed(MIN_SPEED);
		// check the new close button
		selenium.refresh();
		closeButton(project, branchname);

	}
	
	@Test
	@Parameters({ "AddcommonProjectname", "BranchName" })
	public void testAddProjectbranchNamedTrunkToBranch(String project, String branchname) throws InterruptedException {
		// first add a branch to a project
		
		selenium.setSpeed(MIN_SPEED);
		this.waitForElementPresent("!!!menu.project.element!!!", Base.WAIT_TIME);

		selenium.click("!!!menu.project.element!!!");//
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ project + "')]", Base.WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ project + "')]");// the selected project's id
		selenium.click("idBranchManagementButton");
		selenium.setSpeed(MID_SPEED);
		this.clickWaitForElementPresent("idBranchManagementSourceInput");
		this.waitForElementPresent("//div[text()='branches/"+branchname+"']", WAIT_TIME);
		selenium.mouseDown("//div[text()='branches/"+branchname+"']");
		selenium.fireEvent("idBranchManagementSourceInput", "blur");
		selenium.setSpeed(MIN_SPEED);
		this.typeString("idBranchManagementTargetInput", "trunk");
		this.waitForElementPresent("//input[@id='idBranchManagementTargetInput']//ancestor::div[contains(@class,'x-form-element x-form-el-x')]//img", WAIT_TIME);
//		selenium.setSpeed(MID_SPEED);
		selenium.click("idBranchManagementCreateButton");
		Assert.assertFalse(this.waitElement("//span[text()='"
				+ other.getString("project.branchmanage.add.conform") + "']", WAIT_TIME));
		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");

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
