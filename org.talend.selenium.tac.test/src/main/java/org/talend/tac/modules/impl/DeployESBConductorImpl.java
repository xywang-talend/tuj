package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.DeployESBConductor;

public class DeployESBConductorImpl extends DeployESBConductor {

	public DeployESBConductorImpl(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void deployEsbConductor(String label,String name) {
		this.intoESBConductorPage();
		this.deployStartConductor(label, name);
	}
	
	public void undeployEsbConductor(String label,String name) {
		this.intoESBConductorPage();
		this.undeployESBConductor(label, name);
	}

}
