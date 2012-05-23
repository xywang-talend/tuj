	package com.talend.tac.cases.license;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import com.talend.tac.cases.Login;

public class TestLicenseTypesAllowed extends Login {
	public double moreOver = 0.20;

	
	
	public void addLicense(String filename) {
//		this.waitForElementPresent("idMenuLicenseElement", 30);
//		selenium.click("idMenuLicenseElement");
//		this.waitForElementPresent(
//				"//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]",
//				WAIT_TIME);
//		selenium.type(
//				"//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]",
//				filename);
//		selenium.click("//button[text()='Upload']");
		selenium.setSpeed(MID_SPEED);
		waitForElementPresent("idMenuLicenseElement", 30);
		selenium.click("idMenuLicenseElement");
		waitForElementPresent("//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]", WAIT_TIME);
		selenium.type("//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]", filename);
		selenium.click("//button[text()='Upload']");
		selenium.setSpeed(MIN_SPEED);
	}

	public List<String> getUserTypes(){
		List<String> types = new ArrayList<String>();
		this.waitForElementPresent("idMenuLicenseElement", WAIT_TIME);
		selenium.click("idMenuLicenseElement");
		this.waitForElementPresent(
				"//span[@class='x-panel-header-text' and text()='License Parameters']",
				WAIT_TIME);
		// selenium.setSpeed("3000");
		if (waitForCondition(
				"//div[@class='gwt-HTML' and text()='Data Integration']", 30)) {
			if (!selenium
					.getText("//div[text()='Data Integration']/ancestor::div[@class='x-column-inner']//div[@class='x-progress-text x-progress-text-back']//div").equals("")) {
				System.out
						.println(selenium
								.getText("//div[text()='Data Integration']/ancestor::div[@class='x-column-inner']//div[@class='x-progress-text x-progress-text-back']//div"));
				types.add("Data Integration");
			}
		}
		if (waitForCondition(
				"//div[@class='gwt-HTML' and text()='Data Quality']", 30)) {
			if (!selenium
					.getText("//div[text()='Data Quality']/ancestor::div[@class='x-column-inner']//div[@class='x-progress-text x-progress-text-back']//div").equals("")) {
				System.out
						.println(selenium
								.getText("//div[text()='Data Quality']/ancestor::div[@class='x-column-inner']//div[@class='x-progress-text x-progress-text-back']//div"));
				types.add("Data Quality");
			}
		}
		if (waitForCondition(
				"//div[@class='gwt-HTML' and contains(text(),'Master Data Management')]",
				30)) {
			if (selenium
					.getText(
							"//div[@class='gwt-HTML' and contains(text(),'Master Data Management')]/ancestor::div[@class='x-column-inner']//div[@class='x-progress-text x-progress-text-back']//div/ancestor::div[@class='x-column-inner']//div[@class='x-progress-text x-progress-text-back']//div")
					.contains("/")) {
				System.out
						.println(selenium
								.getText("//div[@class='gwt-HTML' and contains(text(),'Master Data Management')]/ancestor::div[@class='x-column-inner']//div[@class='x-progress-text x-progress-text-back']//div/ancestor::div[@class='x-column-inner']//div[@class='x-progress-text x-progress-text-back']//div"));
				types.add("Master Data Management");
			}
		}
		return types;
	}

	public boolean waitForCondition(String locator, int seconds)
			{
		boolean conditionPresent = true;
		for (int second = 0;; second++) {
			if (second >= seconds) {
				conditionPresent = false;
				break;
			}

			if (selenium.isElementPresent(locator)) {
				break;
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
				Assert.assertEquals(selenium.getConfirmation(), other.getString("delete.User.confirmation"));
				selenium.setSpeed(MIN_SPEED);
			}

		}
	}
}
