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
	
    /*drag drop a simple reference
     * *
     */
	public void referenceImpl(String source, String target, String refInfo) {
		
		this.gotoReferencePage();
		this.reference(source, target, refInfo, 2, "trunk");
	}
	
	/*test a cycle reference, add three refPro(A,B,C)
	 * drag drop A to B is success
	 * drag drop B to C is success
	 * drag drop C to A is Failed, this drag drop is not allowed
	 */
	public void cycleRestrictionReferenceproImpl(String type, int commonReference, 
			String cycleRefPro1, String cycleRefPro2, String cycleRefPro3, String cycleRefPro1Info
			, String cycleRefPro2Info, String cycleRefPro3Info) {
		
		projectIml.addProjectImpl(cycleRefPro1, type, commonReference);
		projectIml.addProjectImpl(cycleRefPro2, type, commonReference);
		projectIml.addProjectImpl(cycleRefPro3, type, commonReference);
		this.gotoReferencePage();
		this.reference(cycleRefPro1, cycleRefPro2Info, cycleRefPro1Info, 2, "trunk");
		this.reference(cycleRefPro2, cycleRefPro3Info, cycleRefPro2Info, 2, "trunk");
		this.failedReference(cycleRefPro3, cycleRefPro1Info, cycleRefPro3Info, 2, 1);
		this.removeReference(cycleRefPro2Info, cycleRefPro1Info, 2);
		this.removeReference(cycleRefPro3Info, cycleRefPro2Info, 2);
		projectIml.deleteProjectImpl(cycleRefPro1);
		projectIml.deleteProjectImpl(cycleRefPro2);
		projectIml.deleteProjectImpl(cycleRefPro3);
				
	}
	
	/*test removed a reference
	 * drag drop a referencePro to other pro
	 * then removed the reference, the operation is success
	 * */
	public void removeReferenceImpl(String projectLabel, String type, int commonReference, 
			String source, String target, String refInfo) {
		
		projectIml.addProjectImpl(projectLabel, type, commonReference);
		this.gotoReferencePage();
		this.reference(source, target, refInfo, 2, "trunk");
		this.removeReference(target, refInfo, 2);
		projectIml.deleteProjectImpl(projectLabel);
		
	}
	
	/*add two referecepro(A,B), check their various info display is normal
	 * drag drop A to other project, then drag drop B to A,  check reference display of all level
	 * */
	public void retrieveDisplayReferenceImpl(String projectLabel, String type, int commonReference, 
			String branch,  String projectLabelType, String refPro, String refProBranch, 
			 String refProType, String spaceproTarget, String refproLabelInfo1, 
			 String refproInfo2) {
		
		projectIml.addProjectImpl(projectLabel, type, commonReference);
		this.gotoReferencePage();
		this.checkRefProDisplay(projectLabel, branch, projectLabelType);
		this.checkRefProDisplay(refPro, refProBranch, refProType);
		this.reference(projectLabel, spaceproTarget, refproLabelInfo1, 2, "trunk");
		this.reference(refPro, spaceproTarget, refproInfo2, 2, "trunk");
		this.reference(refPro, refproLabelInfo1, refproInfo2, 2, "trunk");
		this.removeReference(refproLabelInfo1, refproInfo2, 2);
		this.removeReference(spaceproTarget, refproLabelInfo1, 2);
		this.removeReference(spaceproTarget, refproInfo2, 2);
		projectIml.deleteProjectImpl(projectLabel);
		
	}
    
	/*
	 * delete project of Reference project 
	 * */
	public void deleteRefproDispalyReferenceImpl(String projectLabel, String type, 
			int commonReference, String source, String target, String refInfo
			, int nodeLevel) {
		
		projectIml.addProjectImpl(projectLabel, type, commonReference);
		this.gotoReferencePage();
		this.reference(source, target, refInfo, nodeLevel, "trunk");
		projectIml.failedDeleteProjectImpl(projectLabel, rb.getString("project.error.referenced"));
		this.gotoReferencePage();
		this.removeReference(target, refInfo, nodeLevel);
		projectIml.deleteProjectImpl(projectLabel);
		
	}
	
    /*
     * References pro branch to other pro trunk
     * */
	public void referenceBranchToTrunkReferenceImpl(String sourePro, String branchName, String targetPro, 
			String refInfo) {		
		
		projectIml.addBranchProjectImpl(sourePro, branchName);		
		this.gotoReferencePage();		
		this.reference(sourePro, targetPro, refInfo, 2, "branch");
		this.removeReference(targetPro, refInfo, 2);
		
	}
    
	/*
	 * References pro branch to other pro branch
	 * */
	public void referenceBranchToBranchReferenceImpl(String sourePro, String branchName, String targetPro, 
			String refInfo) {		
			
		this.gotoReferencePage();		
		this.reference(sourePro, targetPro, refInfo, 2, "branch");
		this.removeReference(targetPro, refInfo, 2);
		
	}	
    
	/*
	 * references pro trunk to other pro branch
	 * */
	public void referenceTrunkToBranchReferenceImpl(String sourePro, String branchName, String targetPro, 
			String refInfo) {		
			
		this.gotoReferencePage();		
		this.reference(sourePro, targetPro, refInfo, 2, branchName);
		this.removeReference(targetPro, refInfo, 2);
		projectIml.deleteBranchProjectImpl(sourePro, "branch");
		
	}
	
	/*
	 * Add several ref projects at the same time
	 * */
	public void multipleSameTimeReferenceToOtherProReferenceImpl(String refPro1, String type, String refPro2, String targetPro) {
		
//		projectIml.addProjectImpl(refPro1, type, 1);
//		projectIml.addProjectImpl(refPro2, type, 1);
		this.gotoReferencePage();
		this.multipleSameTimeReference(refPro1, "trunk", refPro2, targetPro);		
		
	}
	
	/*Drap n' drop is enabled only on project at level 1 (directly under type node)
	 * */
	public void levelRestrictionReferenceImpl(String refProLevel1, String type, String refProLevel2, String targetPro, 
			String refProLevel1Info, String refProLevel2Info) {
		
		projectIml.addProjectImpl(refProLevel1, type, 1);
		projectIml.addProjectImpl(refProLevel2, type, 1);
		this.gotoReferencePage();
		this.reference(refProLevel1, targetPro, refProLevel1Info, 2, "trunk");
		this.failedReference(refProLevel2, refProLevel1Info, refProLevel2Info, 3, 2);
		this.reference(refProLevel2, targetPro, refProLevel2Info, 2, "trunk");		
		this.removeReference(targetPro, refProLevel1Info, 2);
		this.removeReference(targetPro, refProLevel2Info, 2);
		projectIml.deleteProjectImpl(refProLevel1);
		projectIml.deleteProjectImpl(refProLevel2);
		
	}
	
	/*
	 * darg and drop a DI'pro to DQ'pro
	 * */
	public void referenceDIProToDQProReferenceImpl(String DIPro, String DQPro, String typeDI
			, String typeDQ, String DIProInfo, String DQProInfo) {
		
		projectIml.addProjectImpl(DIPro, typeDI, 1);
		projectIml.addProjectImpl(DQPro, typeDQ, 1);
		this.gotoReferencePage();
		this.reference(DIPro, DQProInfo, DIProInfo, 2, "trunk");
		this.removeReference(DQProInfo, DIProInfo, 2);
//		projectIml.deleteProjectImpl(DIPro);
//		projectIml.deleteProjectImpl(DQPro);
		
	}

	/*
	 * darg and drop a DQ'pro to DI'pro
	 * */
	public void referenceDQProToDIProReferenceImpl(String DIPro, String DQPro, String DIProInfo, String DQProInfo) {
				
		this.gotoReferencePage();
		this.failedReference(DQPro, DIProInfo, DQProInfo, 2, 1);
		
	}

	/*
	 * darg and drop a DQ'pro to MDM'pro
	 * */
	public void referenceDQProToMDMProReferenceImpl(String MDMPro, String typeMDM, String DQPro, String MDMProInfo, String DQProInfo) {
				
		projectIml.addProjectImpl(MDMPro, typeMDM, 1);
		this.gotoReferencePage();
		this.reference(DQPro, MDMProInfo, DQProInfo, 2, "trunk");
		this.removeReference(MDMProInfo, DQProInfo, 2);
		
	}

	/*
	 * darg and drop a DI'pro to MDM'pro
	 * */
	public void referenceDIProToMDMProReferenceImpl(String MDMPro, String DIPro, String MDMProInfo, String DIProInfo) {
		
		this.gotoReferencePage();
		this.reference(DIPro, MDMProInfo, DIProInfo, 2, "trunk");
		this.removeReference(MDMProInfo, DIProInfo, 2);
		
	}
	
	/*
	 * darg and drop a MDM'pro to DI'pro
	 * */
	public void referenceMDMProToDIProReferenceImpl(String MDMPro, String DIPro, String MDMProInfo, String DIProInfo) {
		
		this.gotoReferencePage();
		this.failedReference(MDMPro, DIProInfo, MDMProInfo, 2, 1);
		
	}

	/*
	 * darg and drop a MDM'pro to DQ'pro
	 * */
	public void referenceMDMProToDQProReferenceImpl(String MDMPro, String DQPro, String MDMProInfo, String DQProInfo, String DIPro) {
		
		this.gotoReferencePage();
		this.failedReference(MDMPro, DQProInfo, MDMProInfo, 2, 1);
		projectIml.deleteProjectImpl(DQPro);
		projectIml.deleteProjectImpl(MDMPro);
		projectIml.deleteProjectImpl(DIPro);
		
	}	

	/*
	 * darg and drop a MDM'pro to MDM'pro
	 * */
	public void referenceMDMProToMDMProReferenceImpl(String MDMPro1, String MDMPro2, String MDMPro1Info, String MDMPro2Info, String typeMDM) {
		
		projectIml.addProjectImpl(MDMPro1, typeMDM, 1);
		projectIml.addProjectImpl(MDMPro2, typeMDM, 1);
		this.gotoReferencePage();
		this.reference(MDMPro1, MDMPro2Info, MDMPro1Info, 2, "trunk");
		this.removeReference(MDMPro2Info, MDMPro1Info, 2);
		projectIml.deleteProjectImpl(MDMPro1);
		projectIml.deleteProjectImpl(MDMPro2);
		
	}

	/*
	 * darg and drop a DQ'pro to DQ'pro
	 * */
	public void referenceDQProToDQProReferenceImpl(String DQPro1, String DQPro2, String DQPro1Info, String DQPro2Info, String typeDQ) {
		
		projectIml.addProjectImpl(DQPro1, typeDQ, 1);
		projectIml.addProjectImpl(DQPro2, typeDQ, 1);
		this.gotoReferencePage();
		this.reference(DQPro1, DQPro2Info, DQPro1Info, 2, "trunk");
		this.removeReference(DQPro2Info, DQPro1Info, 2);
		projectIml.deleteProjectImpl(DQPro1);
		projectIml.deleteProjectImpl(DQPro2);
		
	}

	/*
	 * darg and drop a DI'pro to DI'pro
	 * */
	public void referenceDIProToDIProReferenceImpl(String DIPro1, String DIPro2, String DIPro1Info, String DIPro2Info, String typeDI) {
		
		projectIml.addProjectImpl(DIPro1, typeDI, 1);
		projectIml.addProjectImpl(DIPro2, typeDI, 1);
		this.gotoReferencePage();
		this.reference(DIPro1, DIPro2Info, DIPro1Info, 2, "trunk");
		this.removeReference(DIPro2Info, DIPro1Info, 2);
		projectIml.deleteProjectImpl(DIPro1);
		projectIml.deleteProjectImpl(DIPro2);
		
	}
	
}
