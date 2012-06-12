package org.talend.tac.cases.reference;

import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.ReferenceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestProjectReference extends WebdriverLogin {
   
	
	ReferenceImpl refernceImpl;
	@BeforeMethod
	public void beforeMethod() {
		
		refernceImpl = new ReferenceImpl(driver);
		
	}
	
	@Test
	@Parameters({"addReferenceProjectName", "comm.pro.trunk", "ref.pro.info"})
	public void testReference(String source, String target, String refInfo) {
		
		refernceImpl.referenceImpl(source, target, refInfo);
		
	}
	
	@Test
	@Parameters({"type.DI", "cycle.ref.pro1", "cycle.ref.pro2", "cycle.ref.pro3"
		, "cycle.ref.pro1.info", "cycle.ref.pro2.info", "cycle.ref.pro3.info"})
	public void testCycleReferenceproRestriction(String typeDI, String cycleRefPro1, String cycleRefPro2
			, String cycleRefPro3, String cycleRefPro1Info, String cycleRefPro2Info,
			String cycleRefPro3Info) {
		
		refernceImpl.cycleRestrictionReferenceproImpl(typeDI, 1, cycleRefPro1, cycleRefPro2, cycleRefPro3, cycleRefPro1Info, cycleRefPro2Info, cycleRefPro3Info);
		
	}
	
	@Test
	@Parameters({"remove.ref.pro1", "type.DI", "remove.ref.pro1.info", "spacepro.info"})
	public void testRemoveReference(String removeRefPro1, String typeDI, String
			removeRefPro1Info, String spaceproInfo) {
		
        refernceImpl.removeReferenceImpl(removeRefPro1, typeDI, 1,
        		removeRefPro1, spaceproInfo, removeRefPro1Info);
		
	}
	
	@Test
	@Parameters({"retrieve.ref.pro1", "addReferenceProjectName", "spacepro.info"
		, "ref.pro.info", "trunk", "retrieve.ref.pro1.info", "type.DI"})
	public void testRetrievePeoject(String projectLabel, String refpro, 
			String spacePro, String refProInfo, String trunk,
			 String retrieveRefPro1Info, String typeDI) {
		
		refernceImpl.retrieveDisplayReferenceImpl(projectLabel, typeDI, 1,
				trunk, typeDI, refpro, trunk, typeDI,
				spacePro, retrieveRefPro1Info, refProInfo);
		
	}		
	
	@Test
	@Parameters({"delete.ref.pro1", "type.DI", "spacepro.info", "del.ref.pro1.info"})
	public void testDeleteRefProDisplay(String projectLabel, String typeDI, 
			String spaceProInfo, String delRefPro1Info) {
		
		refernceImpl.deleteRefproDispalyReferenceImpl(projectLabel, typeDI, 1,
				projectLabel, spaceProInfo, delRefPro1Info, 2);
		
	}
	
	@Test
	@Parameters({"addReferenceProjectName", "branch", "spacepro.info", "refbranch.pro.info"})
	public void testRefBranchToTrunk(String sourePro, String branchName, 
			String targetPro, String refBranchProInfo) {
		
		refernceImpl.referenceBranchToTrunkReferenceImpl(sourePro, branchName, 
				targetPro, refBranchProInfo);
		
	}	
	
	@Test
	@Parameters({"addReferenceProjectName", "branch", "commbranch.pro.info", "refbranch.pro.info"})
	public void testRefBranchToBranch(String sourePro, String branchName, 
			String targetPro, String refBranchProInfo) {
		
		refernceImpl.referenceBranchToBranchReferenceImpl(sourePro, branchName, 
				targetPro, refBranchProInfo);
		
	}	

	@Test
	@Parameters({"addReferenceProjectName", "trunk", "commbranch.pro.info", "ref.pro.info"})
	public void testRefTrunkToBranch(String sourePro, String branchName, 
			String targetPro, String refBranchProInfo) {
		
		refernceImpl.referenceTrunkToBranchReferenceImpl(sourePro, branchName, 
				targetPro, refBranchProInfo);
		
		
	}
	
	@Test
	public void testMultipleSameTimeReference() {		
		
		refernceImpl.multipleSameTimeReferenceToOtherProReferenceImpl("aa", "Data Integration", "bb", "project space - trunk");
		
	}
	
	@Test
	@Parameters({"refPro.level1", "refPro.level2", "type.DI", "spacepro.info", 
		"refPro.level1.info", "refPro.level2.info"})
	public void testLevelRestriction(String refProLevel1, String refProLevel2, String type, String targetPro
			, String refProLevel1Info, String refProLevel2Info) {
		
		refernceImpl.levelRestrictionReferenceImpl(refProLevel1, type, refProLevel2, targetPro, refProLevel1Info, refProLevel2Info);
		
	}
	
	@Test
	@Parameters({"DIPro", "DQPro", "DIPro.info", "DQPro.info", "type.DI", "type.DQ"})
	public void testReferenceDIProTODQPro(String DIPro, String DQPro, String DIProInfo
			, String DQProInfo, String typeDI, String typeDQ) {
		
		refernceImpl.referenceDIProToDQProReferenceImpl(DIPro, DQPro, typeDI, typeDQ, DIProInfo,
				DQProInfo);
		
	}
	
	@Test
	@Parameters({"DIPro", "DQPro", "DIPro.info", "DQPro.info"})
	public void testReferenceDQProToDIPro(String DIPro, String DQPro,
			String DIProInfo, String DQProInfo) {
		
		refernceImpl.referenceDQProToDIProReferenceImpl(DIPro, DQPro, DIProInfo, DQProInfo);
		
	}
	
	@Test
	@Parameters({"MDMPro", "DQPro", "MDMPro.info", "DQPro.info", "type.MDM"})
	public void testReferenceDQProToMDMPro(String MDMPro, String DQPro,
			String MDMProInfo, String DQProInfo, String typeMDM) {
		
		refernceImpl.referenceDQProToMDMProReferenceImpl(MDMPro, typeMDM, DQPro, MDMProInfo, DQProInfo);
	}
	
	@Test
	@Parameters({"MDMPro", "DIPro", "MDMPro.info", "DIPro.info"})
	public void testReferenceDIProToMDMPro(String MDMPro, String DIPro,
			String MDMProInfo, String DIProInfo) {
		
		refernceImpl.referenceDIProToMDMProReferenceImpl(MDMPro, DIPro, MDMProInfo, DIProInfo);
		
	}	

	@Test
	@Parameters({"MDMPro", "DIPro", "MDMPro.info", "DIPro.info"})
	public void testReferenceMDMProToDIPro(String MDMPro, String DIPro,
			String MDMProInfo, String DIProInfo) {
		
		refernceImpl.referenceMDMProToDIProReferenceImpl(MDMPro, DIPro, MDMProInfo, DIProInfo);
		
	}

	@Test
	@Parameters({"MDMPro", "DQPro", "MDMPro.info", "DQPro.info", "DIPro"})
	public void testReferenceMDMProToDQPro(String MDMPro, String DQPro,
			String MDMProInfo, String DQProInfo, String DIPro) {
		
		refernceImpl.referenceMDMProToDQProReferenceImpl(MDMPro, DQPro, MDMProInfo, DQProInfo, DIPro);
		
	}
	
	@Test
	@Parameters({"MDM.Pro1", "MDM.Pro2", "MDMPro1.Info", "MDMPro2.Info", "type.MDM"})
	public void testReferenceMDMProToMDMPro(String MDMPro1, String MDMPro2
			, String MDMPro1Info, String MDMPro2Info, String typeMDM) {
		
		refernceImpl.referenceMDMProToMDMProReferenceImpl(MDMPro1, MDMPro2,
				MDMPro1Info, MDMPro2Info, typeMDM);
		
	}
	

	@Test
	@Parameters({"DQ.Pro1", "DQ.Pro2", "DQPro1.Info", "DQPro2.Info", "type.DQ"})
	public void testReferenceDQProToDQPro(String DQPro1, String DQPro2
			, String DQPro1Info, String DQPro2Info, String typeDQ) {
		
		refernceImpl.referenceMDMProToMDMProReferenceImpl(DQPro1, DQPro2,
				DQPro1Info, DQPro2Info, typeDQ);
		
	}
	
	@Test
	@Parameters({"DI.Pro1", "DI.Pro2", "DIPro1.Info", "DIPro2.Info", "type.DI"})
	public void testReferenceDIProToDIPro(String DIPro1, String DIPro2
			, String DIPro1Info, String DIPro2Info, String typeDI) {
		
		refernceImpl.referenceMDMProToMDMProReferenceImpl(DIPro1, DIPro2,
				DIPro1Info, DIPro2Info, typeDI);
		
	}
	
}
