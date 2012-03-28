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
	@Parameters({"AddreferenceProjectname", "comm.pro.trunk", "ref.pro.info"})
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
	@Parameters({"retrieve.ref.pro1", "AddreferenceProjectname", "spacepro.info"
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
	@Parameters({"AddreferenceProjectname", "branch", "spacepro.info", "refbranch.pro.info"})
	public void testRefBranchToTrunk(String sourePro, String branchName, 
			String targetPro, String refBranchProInfo) {
		
		refernceImpl.referenceBranchToTrunkReferenceImpl(sourePro, branchName, 
				targetPro, refBranchProInfo);
		
	}	
	
	@Test
	@Parameters({"AddreferenceProjectname", "branch", "commbranch.pro.info", "refbranch.pro.info"})
	public void testRefBranchToBranch(String sourePro, String branchName, 
			String targetPro, String refBranchProInfo) {
		
		refernceImpl.referenceBranchToBranchReferenceImpl(sourePro, branchName, 
				targetPro, refBranchProInfo);
		
	}	

	@Test
	@Parameters({"AddreferenceProjectname", "trunk", "commbranch.pro.info", "ref.pro.info"})
	public void testRefTrunkToBranch(String sourePro, String branchName, 
			String targetPro, String refBranchProInfo) {
		
		refernceImpl.referenceTrunkToBranchReferenceImpl(sourePro, branchName, 
				targetPro, refBranchProInfo);
		
		
	}
}
