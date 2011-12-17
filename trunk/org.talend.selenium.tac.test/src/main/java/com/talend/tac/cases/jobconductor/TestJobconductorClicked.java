package com.talend.tac.cases.jobconductor;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.talend.tac.cases.Login;

public class TestJobconductorClicked extends Login {
	@Test
	public void clickJobconductor() {
		selenium.setSpeed("5000");
		if (selenium.isVisible("!!!menu.executionServers.element!!!")) {
			selenium.click("!!!menu.executionServers.element!!!");
			waitForElementPresent("idSubModuleAddButton", 30000);

		} else {
			selenium.click("!!!menu.jobConductor.element!!!");
			selenium.setSpeed("3000");
			selenium.click("!!!menu.executionServers.element!!!");
			waitForElementPresent("idSubModuleAddButton", 30000);

		}
		
	}
}
