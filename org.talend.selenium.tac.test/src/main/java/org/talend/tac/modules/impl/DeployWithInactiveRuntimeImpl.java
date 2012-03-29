package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.DeployWithInactiveRuntime;

public class DeployWithInactiveRuntimeImpl extends DeployWithInactiveRuntime{

	public DeployWithInactiveRuntimeImpl(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void deployWithInactiveRuntime(String label, String des, String repository,
            String group, String artifact, String version,String name, String type, String context, String server,String status) {
		this.intoESBConductorPage();
		this.addEsbConductor(label, des, repository, group, artifact, version, name,
			 type, context, server);
	    this.deployStartConductor(label, name,status);
	}
}
