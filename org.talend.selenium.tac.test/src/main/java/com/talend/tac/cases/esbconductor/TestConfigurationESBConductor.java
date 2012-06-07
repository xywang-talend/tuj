package com.talend.tac.cases.esbconductor;

import junit.framework.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestConfigurationESBConductor extends ESBConductorUtils {
	

	@Test
	@Parameters({"artifactRepositoryUrl","artifactRepositoryUserName","artifactRepositoryPassWordWithWrong","mavenProtocolExpected"})
	public void testConfigurationESBConductorIsWrong(String artifactRepositoryUrl, String artifactRepositoryUserName
			, String artifactRepositoryPassWord, String mavenProtocolExpected) {
		
        this.configurationESBConduction(artifactRepositoryUrl, artifactRepositoryUserName, artifactRepositoryPassWord,
        		mavenProtocolExpected, "ESBConduction.ArtifactRepositoryUrl.statusIcon",
        		"ESBConduction.ArtifactRepositoryUserNameWrong.statusIcon", "ESBConduction.ArtifactRepositoryPassWordWrong.statusIcon",
        		"ESBConduction.mavenProtocol.statusIcon");	
//        
//        Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'ESB conductor (4 Parameters')]/parent::div/following-sibling::div//table" +
//        		"//div[text()='Artifact repository url']//ancestor::table[@class='x-grid3-row-table']" +
//        		"//div[contains(text(),'Artifacts repository is unreachable')]"));
//		
//		
	}
	
	@Test
	@Parameters({"artifactRepositoryUrl","artifactRepositoryUserName","artifactRepositoryPassWord","mavenProtocolExpected"})
	public void testConfigurationESBConductorIsOK(String artifactRepositoryUrl, String artifactRepositoryUserName
			, String artifactRepositoryPassWord, String mavenProtocolExpected) {
		
        this.configurationESBConduction(artifactRepositoryUrl, artifactRepositoryUserName, artifactRepositoryPassWord,
        		mavenProtocolExpected, "ESBConduction.ArtifactRepositoryUrl.statusIcon",
        		"ESBConduction.ArtifactRepositoryUserName.statusIcon", "ESBConduction.ArtifactRepositoryPassWord.statusIcon",
        		"ESBConduction.mavenProtocol.statusIcon");			
		
		
	}
	
}
