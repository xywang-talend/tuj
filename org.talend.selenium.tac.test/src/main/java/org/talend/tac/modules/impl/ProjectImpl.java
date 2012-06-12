package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.Project;

public class ProjectImpl extends Project {

	public ProjectImpl(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		
	}

	public void addProjectImpl(String projectLabel, String type, int commonReference) {
		
		this.gotoProject();
		this.addProject(projectLabel, type, commonReference);
		
	}
	
	public void deleteProjectImpl(String projectLabel) {
		
		this.gotoProject();
		this.deleteProject(projectLabel);
		
	}
	

	public void failedDeleteProjectImpl(String projectLabel, String delProInfo) {
		
		this.gotoProject();
		this.failedDeleteProject(projectLabel, delProInfo);
		
	}
	
	public void addBranchProjectImpl(String project, String branchName) {
		
		this.gotoProject();
		this.addBranch(project, branchName);
		
	}
	
	public void deleteBranchProjectImpl(String project, String branchName) {
		
		this.gotoProject();
		this.deleteBranch(project, branchName);
		
	}
	
}
