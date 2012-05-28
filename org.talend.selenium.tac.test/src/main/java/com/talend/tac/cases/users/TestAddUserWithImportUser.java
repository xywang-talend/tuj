package com.talend.tac.cases.users;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestAddUserWithImportUser extends Login{
    
	//creation method for add user with import user
	public void addUserWithImportUser(String filePath, String infoAfterUpload) {
		
		this.clickWaitForElementPresent("idMenuUserElement");

		this.waitForElementPresent("//div[text()='admin@company.com']", WAIT_TIME);
		Assert.assertTrue(selenium.isTextPresent("admin@company.com"));
		
		selenium.click("//button[text()='Import users']");//click import user button
		
		this.waitForElementPresent("//input[@name='Path']", WAIT_TIME);
		selenium.type("//input[@name='Path']", parseRelativePath(filePath));//select import file
		selenium.click("idLicenseUploadButton");//click upload user
		selenium.setSpeed(MID_SPEED);
		this.waitForElementPresent("//button[text()='OK']", WAIT_TIME);
		Assert.assertTrue(selenium.isTextPresent(infoAfterUpload));
		selenium.setSpeed(MIN_SPEED);	
		selenium.click("//button[text()='OK']");//click OK
		selenium.click("//button[text()='Close']");
		
	}
	
	//clear all users
    public void clearAllUsers() {
	 
    	 List<String> users = new ArrayList<String>(); 
    	 this.clickWaitForElementPresent("idMenuUserElement");   

 		 this.waitForElementPresent("//div[text()='admin@company.com']", WAIT_TIME);
      	 users = this.findSpecialMachedStrings(".*@[a-zA-Z0-9]*\\.com");

    	 for(int i=0;i<users.size();i++) {
    		 System.out.println(users.get(i));
    		 if(!"admin@company.com".equals(users.get(i))) {
    			selenium.mouseDown("//div[text()='"+users.get(i)+"']");
  				selenium.chooseOkOnNextConfirmation();
  				selenium.click("idSubModuleDeleteButton");
  				selenium.getConfirmation().contains("you sure you want to remove the selected user");
  				selenium.setSpeed(MID_SPEED);
  				Assert.assertFalse(selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
  						+ users.get(i) + "')]"));
  				selenium.setSpeed(MIN_SPEED);
    		 } 
    	 }
    	 selenium.setSpeed(MIN_SPEED);
    }
    
	
	//test import user with a '.cvs' file and check info
	@Test
	@Parameters({"filePathOfCvsFile","addUserOfCvsFileInfo"})
	public void testAddUserImportUserWithCVSFile(String filePath,String info) {
		
		clearAllUsers();//clear user
		
		addUserWithImportUser(filePath, info);
		
		Assert.assertTrue(selenium.isElementPresent("//div[text()='userWithCvsFile@talend.com']"));
		
	}	
	
	//test import user with a null'.cvs' file and check info
	@Test
	@Parameters({"filePathOfNullCvsFile","addUserOfNullCvsFileInfo"})
	public void testAddUserImportUserWithNullFile(String filePath,String info) {
			
		addUserWithImportUser(filePath, info);		
		
	}	
	
	//test import user with a '.cvs' file, use a exist label and check info
	@Test
	@Parameters({"filePathOfCvsFile","addUserUseExistLabelOfCvsFileInfo"})
	public void testAddUserImportUserWithUseExistLabelOfCVSFile(String filePath,String info) {
		
		addUserWithImportUser(filePath, info);
		
	}
	
	//test import user with a '.xml' file and check info
	@Test
	@Parameters({"filePathOfXMLFile","addUserOfXmlFileInfo"})
	public void testAddUserImportUserWithXMLFile(String filePath,String info) {
		
		addUserWithImportUser(filePath, info);

		Assert.assertTrue(selenium.isElementPresent("//div[text()='userWithXMLFile@talend.com']"));
		
	}	
	
	//test import user with a '.txt' file and check info
	@Test
	@Parameters({"filePathOfTXTFile","addUserOfTXTFileInfo"})
	public void testAddUserImportUserWithTxtFile(String filePath,String info) {
		
		addUserWithImportUser(filePath, info);

		Assert.assertTrue(selenium.isElementPresent("//div[text()='userWithTXTFile@talend.com']"));
		
	}
	 
	
	//test import user with a '.doc' file and check warn info
	@Test
	@Parameters({"filePathOfDOCFile","addUserOfDOCFileInfo"})
	public void testAddUserImportUserWithDOCFile(String filePath,String info) {
		
		addUserWithImportUser(filePath, info);
		
	}
	
	//test import user with a wrong label file and check warn info
	@Test
	@Parameters({"filePathOfWrongLabelValueFile","addUserOfWrongLabelValueFileInfo"})
	public void testAddUserImportUserWithWrongLabelValueFile(String filePath,String info) {
		
		addUserWithImportUser(filePath, info);
		
	}	
	
	//test import user with file of type is not exist  and check warn info
	@Test	
	@Parameters({"filePathOfSetTypeIsNotExistFile","addUserOfSetTypeIsNotExistFileInfo"})
	public void testAddUserImportUserWithSetTypeIsNotExistFile(String filePath,String info) {
		
		addUserWithImportUser(filePath, info);
		
	}
	
}
