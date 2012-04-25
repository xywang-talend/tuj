package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.AddESBConductor;

public class AddESBConductorImpl extends AddESBConductor{

	public AddESBConductorImpl(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void addESBConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		this.intoESBConductorPage();
		this.addEsbConductor(label, des, repository, group, artifact, version,
				name, type, context, server);
	}
    
	public void addESBConductorWithExistingLabel(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		this.intoESBConductorPage();
		this.addEsbConductor(label, des, repository, group, artifact, version,
				name, type, context, server);
		this.addConductorWithExistingLabel();
	}
	
	public void editExsitingConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		this.intoESBConductorPage();
		this.editEsbConductor(label, des, repository, group, artifact, version, name, type, context, server);
		this.verifyEditedConductor(label, des, repository, group, artifact, version, name, type, context, server);
	}
}
