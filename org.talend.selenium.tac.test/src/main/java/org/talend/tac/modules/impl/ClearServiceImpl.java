package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.ClearService;


public class ClearServiceImpl extends ClearService {

	public ClearServiceImpl(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void clearAllConductors() {
		this.intoESBConductorPage();
		this.clearAllEsbConductors();
	}
}
