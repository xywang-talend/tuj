package com.talend.tac.cases.license;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestLicenseTypes extends TestLicenseTypesAllowed{
	
	public void resetToValidLicense(String filename){
		this.openLicensePage();
		this.addLicense(filename);
		
	}
	
	public void openLicensePage(){
		this.clickWaitForElementPresent("idMenuLicenseElement");
		this.waitForElementPresent(
				"//span[@class='x-panel-header-text' and text()='License Parameters']",
				WAIT_TIME);
		this.sleep(5000);
	}
	public void checkUser(String[] pass,String[] unpass,String filename){
		this.clickWaitForElementPresent("idMenuUserElement");
		this.clickWaitForElementPresent("idSubModuleAddButton");
		this.sleep(3000);
		if(pass.length==1){
			Assert.assertTrue((!selenium.isVisible("//input[@id='idTypeInput']"))," user  type input should not appear!");
		}
		else{
			Assert.assertTrue((selenium.isVisible("//input[@id='idTypeInput']")),"user type input should appear!");
			this.clickDropDownList("idTypeInput");
			for(int i = 0 ; i<pass.length; i++){
				Assert.assertTrue(this.waitForCondition("//div[@role='listitem'  and contains(text(),'"+pass[i]+"')]", 30), "license  "+filename+"  shouled contains" +pass[i]+ "users!");
			}
			if(unpass!=null){
			for(int i = 0 ; i<unpass.length; i++){
				Assert.assertFalse(this.waitForCondition("//div[@role='listitem'  and text()='"+unpass[i]+"']", 30), "license  "+filename+"  shouled not contains" +unpass[i]+ "users!");
			}
			}
		   
		}
		selenium.refresh();
		this.sleep(5000);
	
	}
	
	public void checkProjects(String[] pass,String[] unpass,String filename){
	
        this.clickWaitForElementPresent("!!!menu.project.element!!!");
		
		this.clickWaitForElementPresent("//div[text()='Projects']/ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleAddButton']");
		this.sleep(5000);
		if(pass.length==1){
			Assert.assertTrue((!selenium.isVisible("//input[@id='idTypeInput']"))," project  type input should not appear!");
		}
		else{
			Assert.assertTrue((selenium.isVisible("//input[@id='idProjectTypeComboBox']"))," project type input should appear!");
			this.clickDropDownList("idProjectTypeComboBox");
			for(int i = 0 ; i<pass.length; i++){
				Assert.assertTrue(this.waitForCondition("//div[@role='listitem'  and contains(text(),'"+pass[i]+"')]", 30), "license  "+filename+"  shouled contains" +pass[i]+ "users!");
			}
			if(unpass!=null){
			for(int i = 0 ; i<unpass.length; i++){
				Assert.assertFalse(this.waitForCondition("//div[@role='listitem'  and text()='"+unpass[i]+"']", 30), "license  "+filename+"  shouled not contains" +unpass[i]+ "users!");
			}
			}
		}
		
	}
	
	
	@Test
	@Parameters( { "licenseFilePath","pass","fail","validlicensePath" })
	public void testLicenseTypes(String path,String passTypes,String unpassTypes,String valid){
		String[] pass = null;
		String[] unpass = null;
		if(!passTypes.equals("")){
		pass = this.splitParameter(passTypes);
		}
		if(!unpassTypes.equals("")){
		unpass = this.splitParameter(unpassTypes);
		}
		this.addLicense(this.parseRelativePath(path));
		this.sleep(5000);
		selenium.refresh();
		this.sleep(8000);
		List list = this.getUserTypes();
		System.out.println("types get from license page:");
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		
		System.out.println("types allowed:");
		for(int i = 0; i < pass.length; i++){
			System.out.println(pass[i]);
		}
		
		System.out.println("types not allowed:");
		if(unpass!=null){
		for(int i = 0; i < unpass.length; i++){
			System.out.println(unpass[i]);
		}
		}
		assertTypes(list,pass,unpass);
		checkUser(pass,unpass,"");
		checkProjects(pass,unpass,"");
		this.openLicensePage();
		this.resetToValidLicense(this.parseRelativePath(valid));
	}
	public void assertTypes(List list,String[] pass,String[] unpass){
		if(pass!=null){
		for(int i = 0; i < pass.length; i++){
			Assert.assertTrue(list.contains(pass[i]), "type "+pass[i]+" should contains in this license!");
		}
		}
		if(unpass!=null){	
		for(int i = 0; i < unpass.length; i++){
			Assert.assertFalse(list.contains(unpass[i]), "type "+unpass[i]+" should not contains in this license!");
		}
		}
	}
	

}
