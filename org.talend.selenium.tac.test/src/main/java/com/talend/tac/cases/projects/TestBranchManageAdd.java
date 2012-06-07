package com.talend.tac.cases.projects;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class TestBranchManageAdd extends Login {
	@Test
	@Parameters({ "addCommonProjectName", "branchName" })
	public void testAddProjectbranch(String project, String branchname) throws InterruptedException {
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
		this.waitForElementPresent("//div[text()='trunk']", WAIT_TIME);
		selenium.mouseDown("//div[text()='trunk']");
		selenium.fireEvent("idBranchManagementSourceInput", "blur");
		selenium.setSpeed(MIN_SPEED);
		this.typeString("idBranchManagementTargetInput", branchname);
//		selenium.setSpeed(MID_SPEED);
		selenium.click("idBranchManagementCreateButton");
		this.waitForElementPresent("//span[text()='"
				+ other.getString("project.branchmanage.add.conform") + "']", WAIT_TIME);
		selenium.click("//button[text()='"
				+ other.getString("project.branchmanage.add.conform.ok")
				+ "']");
		this.waitForElementPresent("//span[text()='" + branchname + "']", WAIT_TIME);
		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
		
		/*if (selenium.isElementPresent("//span[text()='"
				+ other.getString("project.branchmanage.add.conform") + "']")) {
			
			selenium.click("//button[text()='"
					+ other.getString("project.branchmanage.add.conform.ok")
					+ "']");
			this.waitForElementPresent("//span[text()='" + branchname + "']", WAIT_TIME);
			selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
//			Thread.sleep(20000);
//			if (selenium
//					.isElementPresent("//span[text()='" + branchname + "']")) {
//				selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
//			} else {
//				Assert.fail("branch added failed");
//				selenium.click("//button[text()='"
//						+ other.getString("project.branchmanage.add.conform.ok.warning")
//						+ "']");
//			}
		} else {
			Assert.fail("Can not found the conformation!");
		}*/
		selenium.setSpeed(MIN_SPEED);
		//
		selenium.refresh();
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ project + "')]", Base.WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ project + "')]");// the selected project's id
		selenium.click("idBranchManagementButton");
		selenium.setSpeed(MID_SPEED);
		this.clickWaitForElementPresent("idBranchManagementSourceInput");
		this.waitForElementPresent("//div[text()='trunk']", WAIT_TIME);
		selenium.mouseDown("//div[text()='trunk']");
		selenium.fireEvent("idBranchManagementSourceInput", "blur");
		selenium.setSpeed(MIN_SPEED);
		branchname = "test_"+branchname;
		this.typeString("idBranchManagementTargetInput", branchname);
//		selenium.setSpeed(MID_SPEED);
		selenium.click("idBranchManagementCreateButton");
		this.waitForElementPresent("//span[text()='"
				+ other.getString("project.branchmanage.add.conform") + "']", WAIT_TIME);
		selenium.click("//button[text()='"
				+ other.getString("project.branchmanage.add.conform.ok")
				+ "']");
		this.waitForElementPresent("//span[text()='" + branchname + "']", WAIT_TIME);
		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
		selenium.setSpeed(MIN_SPEED);

	}
	
	@Test
	@Parameters({ "addCommonProjectName", "branchName" })
	public void testAddProjectbranchNamedTrunkToTrunk(String project, String branchname) throws InterruptedException {
		// first add a branch to a project
		branchname = "trunk";
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
		this.waitForElementPresent("//div[text()='trunk']", WAIT_TIME);
		selenium.mouseDown("//div[text()='trunk']");
		selenium.fireEvent("idBranchManagementSourceInput", "blur");
		selenium.setSpeed(MIN_SPEED);
		this.typeString("idBranchManagementTargetInput", branchname);
		this.waitForElementPresent("//input[@id='idBranchManagementTargetInput']//ancestor::div[contains(@class,'x-form-element x-form-el-x')]//img", WAIT_TIME);
//		selenium.setSpeed(MID_SPEED);
		selenium.click("idBranchManagementCreateButton");
		Assert.assertFalse(this.waitElement("//span[text()='"
				+ other.getString("project.branchmanage.add.conform") + "']", WAIT_TIME));
		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");

	}
	
}