package org.talend.tac.cases.esbconductor;

import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.SelectFeatureFromArchivaImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSelectFeatureWithArtifactUnavailable extends WebdriverLogin {
	SelectFeatureFromArchivaImpl selectFeatureFromArchivaImpl;
    @BeforeMethod
    public void beforeMethod() {
    	selectFeatureFromArchivaImpl=new SelectFeatureFromArchivaImpl(driver);
    }
    
    @Test
    @Parameters({"artifactRepositoryWrongUrl",
        "artifactRepositoryUserName","artifactRepositoryPassWord","mavenProtocolExpected"
    })
    public void configArtifact(String artifactRepositoryUrl, String artifactRepositoryUserName
                      			, String artifactRepositoryPassWord, String mavenProtocolExpected) {
    	selectFeatureFromArchivaImpl.configurationESBConductionIsWrong(artifactRepositoryUrl, artifactRepositoryUserName, artifactRepositoryPassWord, mavenProtocolExpected, "ESBConduction.ArtifactRepositoryUrlWrong.statusIcon",
        		                    "ESBConduction.ArtifactRepositoryUserNameWrong.statusIcon", "ESBConduction.ArtifactRepositoryPassWordWrong.statusIcon","ESBConduction.mavenProtocol.statusIcon");

    }
    
    @Test
    @Parameters({
        "labelOfService", "desOfService", "repository"})
    public void selectFeature(String label, String des, String repository) {
    	selectFeatureFromArchivaImpl.selectFeatureNormally(label, des, repository);
    }
    

}
