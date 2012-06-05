package org.talend.mdm.cases.license;


import org.talend.mdm.Login;
import org.talend.mdm.impl.LicenseImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestLicense extends Login {
	LicenseImpl license;
	@BeforeMethod
	public void beforeMethod(){
		license = new LicenseImpl(driver);
	}
	
	@Test
	@Parameters( {"license.file.path"})
	public void testUploadValidLicense(String fileLicenseValid){
		license.uploadValidLicense(fileLicenseValid);
	}
	
	@Test
	@Parameters( {"license.file.path"})
	public void testUploadInValidLicense(String fileLicenseValid){
		license.uploadInValidLicense(fileLicenseValid);
	}
	
	@Test
	@Parameters( {"license.file.path"})
	public void testUploadExpiredLicense(String fileLicenseValid){
		license.uploadExpiredLicense(fileLicenseValid);
	}
	
}
