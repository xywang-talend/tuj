package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.ConfigurationESBConductor;

public class ConfigurationESBConductorImpl extends ConfigurationESBConductor {

	public ConfigurationESBConductorImpl(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	
	public void configurationESBConductionIsWrong(String artifactRepositoryUrl, String artifactRepositoryUserName
			, String artifactRepositoryPassWord, String mavenProtocolExpected,String urlStatus
			, String usernameStatus, String pwStatus, String mavenStatus) {
		this.intoConfigurationPage();
		this.configurateEsbConductor(artifactRepositoryUrl, artifactRepositoryUserName, artifactRepositoryPassWord,
        		mavenProtocolExpected, "ESBConduction.ArtifactRepositoryUrl.statusIcon",
        		"ESBConduction.ArtifactRepositoryUserNameWrong.statusIcon", "ESBConduction.ArtifactRepositoryPassWordWrong.statusIcon",
        		"ESBConduction.mavenProtocol.statusIcon");
//		Assert.assertTrue(this.isElementPresent(By.xpath("//div[contains(text(),'ESB conductor (4 Parameters')]/parent::div/following-sibling::div//table" +
//        		"//div[text()='Artifact repository url']//ancestor::table[@class='x-grid3-row-table']" +
//        		"//div[contains(text(),'Artifacts repository is unreachable')]"),WAIT_TIME_MIN));  
		
	}
	
	public void configurationESBConductionOk(String artifactRepositoryUrl, String artifactRepositoryUserName
			, String artifactRepositoryPassWord, String mavenProtocolExpected,String urlStatus
			, String usernameStatus, String pwStatus, String mavenStatus) {
		this.intoConfigurationPage();
		this.configurateEsbConductor(artifactRepositoryUrl, artifactRepositoryUserName, artifactRepositoryPassWord,
        		mavenProtocolExpected, "ESBConduction.ArtifactRepositoryUrl.statusIcon",
        		"ESBConduction.ArtifactRepositoryUserName.statusIcon", "ESBConduction.ArtifactRepositoryPassWord.statusIcon",
        		"ESBConduction.mavenProtocol.statusIcon");
		
	}

}
