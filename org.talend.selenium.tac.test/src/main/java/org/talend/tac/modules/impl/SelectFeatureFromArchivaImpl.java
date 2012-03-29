package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.SelectFeatureFromArchiva;

public class SelectFeatureFromArchivaImpl extends SelectFeatureFromArchiva {

	public SelectFeatureFromArchivaImpl(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void selectFeatureNormally(String label, String des, String repository, String group, String artifact,
            String version, String name) {
		this.seletFeature(label, des, repository, group, artifact, version, name);
	}
	
	
}
