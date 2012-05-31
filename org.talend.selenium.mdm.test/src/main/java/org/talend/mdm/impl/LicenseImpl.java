package org.talend.mdm.impl;

import java.io.File;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.Base;
import org.talend.mdm.modules.License;
import org.testng.Assert;

public class LicenseImpl extends License{

	public LicenseImpl(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void openLicense(){
		this.openAdministration();
		this.gotoLicensePage();
		
	}
	
	public void uploadValidLicense(String fileLicenseValid){
		this.openLicense();
		this.clickEditlicenseKey();
		logger.warn("the license file ready to upload is :"+fileLicenseValid);
		logger.warn(Base.class.getClassLoader());
		logger.warn(Base.class.getClassLoader().getResource(fileLicenseValid));
		logger.warn(Base.class.getClassLoader().getResource(fileLicenseValid));
		
		File file = null;
		try {
			file = new File(LicenseImpl.class.getClassLoader().getResource(fileLicenseValid).toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		System.out.println(file.getAbsolutePath());
		this.typeInlicenseFile(file.getAbsolutePath());
		this.clickUploadLicenseButton();
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.license.uploading.inprogressbar.wating")), WAIT_TIME_MID), "uploading license bar err");
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.license.upload.sending")), WAIT_TIME_MID), "uploading license bar err");
	    this.sleepCertainTime(5000);
	}
	
	public void uploadInValidLicense(String fileLicenseInValid){
		this.openLicense();
		this.clickEditlicenseKey();
		logger.warn("the license file ready to upload is :"+fileLicenseInValid);
		logger.warn(Base.class.getClassLoader());
		logger.warn(Base.class.getClassLoader().getResource(fileLicenseInValid));
		logger.warn(Base.class.getClassLoader().getResource(fileLicenseInValid));
		
		File file = null;
		try {
			file = new File(LicenseImpl.class.getClassLoader().getResource(fileLicenseInValid).toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		System.out.println(file.getAbsolutePath());
		this.typeInlicenseFile(file.getAbsolutePath());
		this.clickUploadLicenseButton();
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.license.invalidlicense.warning")), WAIT_TIME_MID), "uploading license bar err");
	    this.clickElementByXpath(locator.getString("xpath.license.invalidlicense.ok.button"));
	}
	
	public void uploadExpiredLicense(String fileLicenseInValid){
		this.openLicense();
		this.clickEditlicenseKey();
		logger.warn("the license file ready to upload is :"+fileLicenseInValid);
		logger.warn(Base.class.getClassLoader());
		logger.warn(Base.class.getClassLoader().getResource(fileLicenseInValid));
		logger.warn(Base.class.getClassLoader().getResource(fileLicenseInValid));
		
		File file = null;
		try {
			file = new File(LicenseImpl.class.getClassLoader().getResource(fileLicenseInValid).toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		System.out.println(file.getAbsolutePath());
		this.typeInlicenseFile(file.getAbsolutePath());
		this.clickUploadLicenseButton();
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.license.invalidlicense.warning")), WAIT_TIME_MID), "uploading license bar err");
	    this.clickElementByXpath(locator.getString("xpath.license.invalidlicense.ok.button"));
	}
}
