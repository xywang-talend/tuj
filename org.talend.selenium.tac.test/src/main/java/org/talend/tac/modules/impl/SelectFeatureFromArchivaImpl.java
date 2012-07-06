package org.talend.tac.modules.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.SelectFeatureFromArchiva;
import org.testng.Assert;

public class SelectFeatureFromArchivaImpl extends SelectFeatureFromArchiva {

	public SelectFeatureFromArchivaImpl(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void selectFeatureNormally(String label, String des, String repository) {
		this.selectFeatureWithUnavaiableArtifact(label, des, repository);
	}
	
	public void configurationESBConductionIsWrong(String artifactRepositoryUrl, String artifactRepositoryUserName
			, String artifactRepositoryPassWord, String mavenProtocolExpected,String urlStatus
			, String usernameStatus, String pwStatus, String mavenStatus) {
		this.intoConfigurationPage();
		this.configurateEsbConductor(artifactRepositoryUrl, artifactRepositoryUserName, artifactRepositoryPassWord,
        		mavenProtocolExpected, "ESBConduction.ArtifactRepositoryUrlWrong.statusIcon",
        		"ESBConduction.ArtifactRepositoryUserNameWrong.statusIcon", "ESBConduction.ArtifactRepositoryPassWordWrong.statusIcon",
        		"ESBConduction.mavenProtocol.statusIcon");
		Assert.assertTrue(this.isElementPresent(By.xpath("//div[contains(text(),'ESB conductor (4 Parameters')]/parent::div/following-sibling::div//table" +
        		"//div[text()='Artifact repository url']//ancestor::table[@class='x-grid3-row-table']" +
        		"//div[contains(text(),'Artifacts repository is unreachable')]"),WAIT_TIME_MIN));  
		
	}
	
	public void selectFeatureNormally(String label, String des, String repository, String group, String artifact,
            String version, String name) {
		this.seletFeature(label, des, repository, group, artifact, version, name);
	}
	
	public void testCollapseAndExpandAll(String label,String des,String repository,String group) {
		this.commonMethodForSelectFeature(label, des);
		this.testCollapseAll(repository);
		Assert.assertTrue(this.isElementPresent(By.xpath("//div[contains(@class,'x-tree3-el x-tree3-node-joint-collapse')]"), WAIT_TIME_MIN));
		this.testExpandAll();
		Assert.assertTrue(this.isElementPresent(By.xpath("//span[text()='" + group + "']"), WAIT_TIME_MIN));
	}
	
	public void testSearchId(String label,String des,String repository,String group) {
		this.commonMethodForSelectFeature(label, des);
		this.SearchGroupId(repository, group);
		Assert.assertTrue(this.isElementPresent(By.xpath("//span[text()='" + group + "']"), WAIT_TIME_MIN));
	}
	
	public void testSearchArtifactByKeyWord(String label,String des,String repository,String group,String artifact) {
		this.commonMethodForSelectFeature(label, des);
		this.SearchArtifact(repository, group);
		Assert.assertTrue(this.isElementPresent(By.xpath("//div[text()='" + artifact + "']"), WAIT_TIME_MIN));
	}
	
}
