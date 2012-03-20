package org.talend.mdm.impl;

import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.License;
import org.talend.mdm.modules.User;


public class LicenseImpl extends License{

	public LicenseImpl(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void openLicense(){
		this.openAdministration();
		this.gotoLicensePage();
		
	}
	

}
