package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.DuplicateESBConductor;

public class DuplicateESBConductorImpl extends DuplicateESBConductor{

	public DuplicateESBConductorImpl(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void duplicateConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		this.intoESBConductorPage();
		this.duplicateEsbConductor(label, des, repository, group, artifact,
				version, name, type, context, server);
	}
	
	public void openLinkofArtifactRepository(String PageTitleExpected) {
		this.intoESBConductorPage();
		this.openLinkOfArtifact(PageTitleExpected);
	}

}
