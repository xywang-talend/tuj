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
    @Parameters({
        "labelOfService", "desOfService", "repository", "group", "artifact", "version", "name","artifactRepositoryWrongUrl",
        "artifactRepositoryUserName","artifactRepositoryPassWordWithWrong","mavenProtocolExpected"
    })
    public void testSelectFeatureWithUnavaiableArtifact(String label, String des, String repository, String group, String artifact,
                                  String version, String name,String artifactRepositoryUrl, String artifactRepositoryUserName
                      			, String artifactRepositoryPassWord, String mavenProtocolExpected) {
    	selectFeatureFromArchivaImpl.configurationESBConductionIsWrong(artifactRepositoryUrl, artifactRepositoryUserName, artifactRepositoryPassWord, mavenProtocolExpected, "ESBConduction.ArtifactRepositoryUrlWrong.statusIcon",
        		                    "ESBConduction.ArtifactRepositoryUserName.statusIcon", "ESBConduction.ArtifactRepositoryPassWord.statusIcon","ESBConduction.mavenProtocol.statusIcon");
    	selectFeatureFromArchivaImpl.selectFeatureNormally(label, des, repository, group, artifact, version, name);

    }
    

}
