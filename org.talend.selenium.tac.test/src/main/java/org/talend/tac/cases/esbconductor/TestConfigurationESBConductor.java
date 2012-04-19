package org.talend.tac.cases.esbconductor;

import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.ConfigurationESBConductorImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestConfigurationESBConductor extends WebdriverLogin {
	ConfigurationESBConductorImpl configurationESBConductorImpl;
    @BeforeMethod
    public void beforeMethod(){
    	configurationESBConductorImpl = new ConfigurationESBConductorImpl(driver);
    }
	
	@Test
	@Parameters({"artifactRepositoryUrl","artifactRepositoryUserName","artifactRepositoryPassWordWithWrong","mavenProtocolExpected"})
	public void testConfigurationESBConductorIsWrong(String artifactRepositoryUrl, String artifactRepositoryUserName
			, String artifactRepositoryPassWord, String mavenProtocolExpected) {
		
		configurationESBConductorImpl.configurationESBConductionIsWrong(artifactRepositoryUrl, artifactRepositoryUserName, artifactRepositoryPassWord,
        		mavenProtocolExpected, "ESBConduction.ArtifactRepositoryUrlWrong.statusIcon",
        		"ESBConduction.ArtifactRepositoryUserNameWrong.statusIcon", "ESBConduction.ArtifactRepositoryPassWordWrong.statusIcon",
        		"ESBConduction.mavenProtocol.statusIcon");	
              
		
		
	}
	
	@Test
	@Parameters({"artifactRepositoryUrl","artifactRepositoryUserName","artifactRepositoryPassWord","mavenProtocolExpected"})
	public void testConfigurationESBConductorIsOK(String artifactRepositoryUrl, String artifactRepositoryUserName
			, String artifactRepositoryPassWord, String mavenProtocolExpected) {
		
		configurationESBConductorImpl.configurationESBConductionOk(artifactRepositoryUrl, artifactRepositoryUserName, artifactRepositoryPassWord,
        		mavenProtocolExpected, "ESBConduction.ArtifactRepositoryUrl.statusIcon",
        		"ESBConduction.ArtifactRepositoryUserName.statusIcon", "ESBConduction.ArtifactRepositoryPassWord.statusIcon",
        		"ESBConduction.mavenProtocol.statusIcon");			
		
		
	}
	
}
