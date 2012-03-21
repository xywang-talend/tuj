package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.Reference;
import org.testng.annotations.BeforeMethod;

public class ReferenceImpl extends Reference {

	public ProjectImpl projectIml = new ProjectImpl(driver);
	
	public ReferenceImpl(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		
	}

	public void referenceImpl(String source, String target, String refInfo) {
		
		this.gotoReferencePage();
		this.reference(source, target, refInfo, 2);
	}
	
	public void cycleRestrictionReferenceproImpl(String type, int commonReference, 
			String cycleRefPro1, String cycleRefPro2, String cycleRefPro3, String cycleRefPro1Info
			, String cycleRefPro2Info, String cycleRefPro3Info) {
		
		projectIml.addProjectImpl(cycleRefPro1, type, commonReference);
		projectIml.addProjectImpl(cycleRefPro2, type, commonReference);
		projectIml.addProjectImpl(cycleRefPro3, type, commonReference);
		this.gotoReferencePage();
		this.reference(cycleRefPro1, cycleRefPro2Info, cycleRefPro1Info, 2);
		this.reference(cycleRefPro2, cycleRefPro3Info, cycleRefPro2Info, 2);
		this.failedReference(cycleRefPro3, cycleRefPro1Info, cycleRefPro3Info, 2);
		this.removeReference(cycleRefPro2Info, cycleRefPro1Info, 2);
		this.removeReference(cycleRefPro3Info, cycleRefPro2Info, 2);
		projectIml.deleteProjectImpl(cycleRefPro1);
		projectIml.deleteProjectImpl(cycleRefPro2);
		projectIml.deleteProjectImpl(cycleRefPro3);
				
	}
	
	public void removeReferenceImpl(String projectLabel, String type, int commonReference, 
			String source, String target, String refInfo) {
		
		projectIml.addProjectImpl(projectLabel, type, commonReference);
		this.gotoReferencePage();
		this.reference(source, target, refInfo, 2);
		this.removeReference(target, refInfo, 2);
		projectIml.deleteProjectImpl(projectLabel);
		
	}
	
	public void retrieveDisplayReferenceImpl(String projectLabel, String type, int commonReference, 
			String branch,  String projectLabelType, String refPro, String refProBranch, 
			 String refProType, String spaceproTarget, String refproLabelInfo1, 
			 String refproInfo2) {
		
		projectIml.addProjectImpl(projectLabel, type, commonReference);
		this.gotoReferencePage();
		this.checkRefProDisplay(projectLabel, branch, projectLabelType);
		this.checkRefProDisplay(refPro, refProBranch, refProType);
		this.reference(projectLabel, spaceproTarget, refproLabelInfo1, 2);
		this.reference(refPro, spaceproTarget, refproInfo2, 2);
		this.reference(refPro, refproLabelInfo1, refproInfo2, 2);
		this.removeReference(refproLabelInfo1, refproInfo2, 2);
		this.removeReference(spaceproTarget, refproLabelInfo1, 2);
		this.removeReference(spaceproTarget, refproInfo2, 2);
		projectIml.deleteProjectImpl(projectLabel);
		
	}

	public void deleteRefproDispalyReferenceImpl(String projectLabel, String type, 
			int commonReference, String source, String target, String refInfo
			, int nodeLevel) {
		
		projectIml.addProjectImpl(projectLabel, type, commonReference);
		this.gotoReferencePage();
		this.reference(source, target, refInfo, nodeLevel);
		projectIml.failedDeleteProjectImpl(projectLabel, rb.getString("project.error.referenced"));
		this.gotoReferencePage();
		this.removeReference(target, refInfo, nodeLevel);
		projectIml.deleteProjectImpl(projectLabel);
		
	}
	
}
