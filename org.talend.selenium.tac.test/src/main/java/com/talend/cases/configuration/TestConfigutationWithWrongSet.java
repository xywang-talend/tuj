package com.talend.cases.configuration;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestConfigutationWithWrongSet extends configuration {
  
	  @Test
	  @Parameters ({"svnConfWrongServerLocationURL","svnConfWrongServerUser","svnConfWrongServerPassword"})
	  public void testSetWrongSVN(String svnServerLocationWrongUrl,String svnServerWrongUser,String svnServerWrongPassword){
		  
		  this.mouseDownWaitForElementPresent("//div[contains(text(),'Svn (')]"); 
		  this.typeWordsInConfigurationMenu(other.getString("svn.conf.serverLocationURL.editButton"), locatorOfAllInputTags, svnServerLocationWrongUrl);
		  this.typeWordsInConfigurationMenu(other.getString("svn.conf.serverUser.editButton"), locatorOfAllInputTags, svnServerWrongUser);
		  this.typeWordsInConfigurationMenu(other.getString("svn.conf.serverPassword.editButton"), locatorOfAllInputTags, svnServerWrongPassword);
			
		  this.AssertEqualsInConfigurationMenu(other.getString("svn.conf.serverLocationURL.editButton"), locatorOfAllInputTags, svnServerLocationWrongUrl,other.getString("svn.conf.serverLocationURL.wrong.statusIcon"));
		  this.AssertEqualsInConfigurationMenu(other.getString("svn.conf.serverUser.editButton"), locatorOfAllInputTags, svnServerWrongUser,other.getString("svn.conf.serverUser.wrong.statusIcon"));
		  this.AssertEqualsInConfigurationMenu(other.getString("svn.conf.serverPassword.editButton"), locatorOfAllInputTags, svnServerWrongPassword,other.getString("svn.conf.serverPassword.wrong.statusIcon"));
	      Assert.assertTrue(this.waitElement("//div[contains(text(),'Svn')]/parent::div/following-sibling::div//table//div[text()='Server location url']//ancestor::table[@class='x-grid3-row-table']//div[contains(text(),'Authentication" +
	      		" failed while connecting to "+svnServerLocationWrongUrl+"')]",WAIT_TIME));
	      Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Svn')]/parent::div/following-sibling::div//table//div[text()='Username']//ancestor::table[@class='x-grid3-row-table']//div[contains(text(),'Authentication" +
	      		" failed while connecting to "+svnServerLocationWrongUrl+"')]"));
	      Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Svn')]/parent::div/following-sibling::div//table//div[text()='Password']//ancestor::table[@class='x-grid3-row-table']//div[contains(text(),'Authentication " +
	      		"failed while connecting to "+svnServerLocationWrongUrl+"')]"));
		  this.mouseDownWaitForElementPresent("//div[contains(text(),'Svn (')]"); 	

	  }
	  
	  @Test
	  @Parameters ({"smtpConfUseSmtp","smtp.conf.wrong.mailServerHost","smtp.conf.wrong.mailServerPort","smtp.conf.wrong.mailUserName","smtp.conf.wrong.mailPassword","smtpConfServerRequireSSL"})
	  public void testSetWrongSMTP(String useSmtp,String wrongMailServerHost,String wrongMailServerPort,String wrongMailUserName,String wrongMailPassword,String serverRequireSSL){//String serverRequireSSL
		  this.mouseDownWaitForElementPresent("//div[contains(text(),'SMTP')]");
		  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.useSmtp.editButton"), locatorOfAllInputTags, useSmtp);
		  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.mailServerHost.editButton"), locatorOfAllInputTags, wrongMailServerHost);
		  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.mailServerPort.editButton"), locatorOfAllInputTags, wrongMailServerPort);
		  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.mailUserName.editButton"), locatorOfAllInputTags, wrongMailUserName);
		  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.mailPassword.editButton"), locatorOfAllInputTags, wrongMailPassword);
		  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.serverRequireSSL.editButton"), locatorOfAllInputTags, serverRequireSSL);
		  
		  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.useSmtp.editButton"), locatorOfAllInputTags, useSmtp,other.getString("smtp.conf.useSmtp.statusIcon"));
		  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.mailServerHost.editButton"), locatorOfAllInputTags, wrongMailServerHost,other.getString("smtp.conf.mailServerHost.wrong.statusIcon"));
		  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.mailServerPort.editButton"), locatorOfAllInputTags, wrongMailServerPort,other.getString("smtp.conf.mailServerPort.wrong.statusIcon"));
		  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.mailUserName.editButton"), locatorOfAllInputTags, wrongMailUserName,other.getString("smtp.conf.mailUserName.wrong.statusIcon"));
		  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.mailPassword.editButton"), locatorOfAllInputTags, wrongMailPassword,other.getString("smtp.conf.mailPassword.wrong.statusIcon"));
		  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.serverRequireSSL.editButton"), locatorOfAllInputTags, serverRequireSSL,other.getString("smtp.conf.serverRequireSSL.wrong.statusIcon"));
//		  this.waitForElementPresent(other.getString("smtp.conf.generalStatusIcon"), WAIT_TIME);
		  
		  this.mouseDownWaitForElementPresent("//div[contains(text(),'SMTP')]");  
		//assertEquals
	  }
	
}
