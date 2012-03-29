package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.DeleteESBConductor;

public class DeleteESBConductorImpl extends DeleteESBConductor{

	public DeleteESBConductorImpl(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void deleteConductorCancel(String label, String des, String repository,
            String group, String artifact, String version, String name, String type, 
            String context, String server) {
		this.intoESBConductorPage();
		this.addEsbConductor(label, des, repository, group, artifact, version, name, type, context, server);
	    this.deleteESBConductorCancel(label);
	}
	
	public void deleteConductorOk(String label,String name) {
		this.intoESBConductorPage();
		this.deleteESBConductorOK(label, name);
	}
	
	public void deleteUndeployESBConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		this.intoESBConductorPage();
		this.addEsbConductor(label, des, repository, group, artifact, version, name, type, context, server);
		this.deployStartConductor(label, name);
		this.undeployESBConductor(label, name);
		this.deleteESBConductorOK(label, name);
	}
	
	

}
