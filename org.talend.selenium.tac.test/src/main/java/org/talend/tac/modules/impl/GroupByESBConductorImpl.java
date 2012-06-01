package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.GroupByESBConductor;

public class GroupByESBConductorImpl extends GroupByESBConductor{

	public GroupByESBConductorImpl(WebDriver driver) {
		super(driver);
		this.driver=driver;
		this.intoESBConductorPage();
	}
	
	public void addESBConductors(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server ,String tag,int times) {
	    this.addEsbConductor(label, des, repository, group, artifact, version, name, type, context, server,tag,times);	    
	}
    
	public void groupESBConductorByKey() {
		this.groupESBConductor();
	}
	
	public void SortESBConductor(String value,String value1) {
		this.checkSortAscendingSortDescending(value, value1);
	}
}
