package com.talend.cases.configuration;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestConfigutationWithWrongSet extends configuration {
  
	  @Test
	  @Parameters ({"svn.conf.wrong.serverLocationURL","svn.conf.wrong.serverUser","svn.conf.wrong.serverPassword"})
	  public void testSetWrongSVN(String svnServerLocationWrongUrl,String svnServerWrongUser,String svnServerWrongPassword){
		  
		  this.mouseDownWaitForElementPresent("//div[contains(text(),'Svn (')]"); 
		  this.typeWordsInConfigurationMenu(other.getString("svn.conf.serverLocationURL.editButton"), other.getString("svn.conf.serverLocationURL.input"), svnServerLocationWrongUrl);
		  this.typeWordsInConfigurationMenu(other.getString("svn.conf.serverUser.editButton"), other.getString("svn.conf.serverUser.input"), svnServerWrongUser);
		  this.typeWordsInConfigurationMenu(other.getString("svn.conf.serverPassword.editButton"), other.getString("svn.conf.serverPassword.input"), svnServerWrongPassword);
			
		  this.AssertEqualsInConfigurationMenu(other.getString("svn.conf.serverLocationURL.editButton"), other.getString("svn.conf.serverLocationURL.input"), svnServerLocationWrongUrl,other.getString("svn.conf.serverLocationURL.wrong.statusIcon"));
		  this.AssertEqualsInConfigurationMenu(other.getString("svn.conf.serverUser.editButton"), other.getString("svn.conf.serverUser.input"), svnServerWrongUser,other.getString("svn.conf.serverUser.wrong.statusIcon"));
		  this.AssertEqualsInConfigurationMenu(other.getString("svn.conf.serverPassword.editButton"), other.getString("svn.conf.serverPassword.input"), svnServerWrongPassword,other.getString("svn.conf.serverPassword.wrong.statusIcon"));
	      Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Svn')]/parent::div/following-sibling::div//table//div[text()='Server location url']//ancestor::table[@class='x-grid3-row-table']//div[contains(text(),'Authentication" +
	      		" failed while connecting to "+svnServerLocationWrongUrl+"')]"));
	      Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Svn')]/parent::div/following-sibling::div//table//div[text()='Username']//ancestor::table[@class='x-grid3-row-table']//div[contains(text(),'Authentication" +
	      		" failed while connecting to "+svnServerLocationWrongUrl+"')]"));
	      Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Svn')]/parent::div/following-sibling::div//table//div[text()='Password']//ancestor::table[@class='x-grid3-row-table']//div[contains(text(),'Authentication " +
	      		"failed while connecting to "+svnServerLocationWrongUrl+"')]"));
		  this.mouseDownWaitForElementPresent("//div[contains(text(),'Svn (')]"); 	

	  }
	  
	  @Test
	  @Parameters ({"smtp.conf.useSmtp","smtp.conf.wrong.mailServerHost","smtp.conf.wrong.mailServerPort","smtp.conf.wrong.mailUserName","smtp.conf.wrong.mailPassword","smtp.conf.serverRequireSSL"})
	  public void testSetWrongSMTP(String useSmtp,String wrongMailServerHost,String wrongMailServerPort,String wrongMailUserName,String wrongMailPassword,String serverRequireSSL){//String serverRequireSSL
		  this.mouseDownWaitForElementPresent("//div[contains(text(),'SMTP')]");
		  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.useSmtp.editButton"), other.getString("smtp.conf.useSmtp.input"), useSmtp);
		  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.mailServerHost.editButton"), other.getString("smtp.conf.mailServerHost.input"), wrongMailServerHost);
		  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.mailServerPort.editButton"), other.getString("smtp.conf.mailServerPort.input"), wrongMailServerPort);
		  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.mailUserName.editButton"), other.getString("smtp.conf.mailUserName.input"), wrongMailUserName);
		  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.mailPassword.editButton"), other.getString("smtp.conf.mailPassword.input"), wrongMailPassword);
		  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.serverRequireSSL.editButton"), other.getString("smtp.conf.serverRequireSSL.input"), serverRequireSSL);
		  
		  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.useSmtp.editButton"), other.getString("smtp.conf.useSmtp.input"), useSmtp,other.getString("smtp.conf.useSmtp.statusIcon"));
		  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.mailServerHost.editButton"), other.getString("smtp.conf.mailServerHost.input"), wrongMailServerHost,other.getString("smtp.conf.mailServerHost.wrong.statusIcon"));
		  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.mailServerPort.editButton"), other.getString("smtp.conf.mailServerPort.input"), wrongMailServerPort,other.getString("smtp.conf.mailServerPort.wrong.statusIcon"));
		  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.mailUserName.editButton"), other.getString("smtp.conf.mailUserName.input"), wrongMailUserName,other.getString("smtp.conf.mailUserName.wrong.statusIcon"));
		  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.mailPassword.editButton"), other.getString("smtp.conf.mailPassword.input"), wrongMailPassword,other.getString("smtp.conf.mailPassword.wrong.statusIcon"));
		  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.serverRequireSSL.editButton"), other.getString("smtp.conf.serverRequireSSL.input"), serverRequireSSL,other.getString("smtp.conf.serverRequireSSL.wrong.statusIcon"));
//		  this.waitForElementPresent(other.getString("smtp.conf.generalStatusIcon"), WAIT_TIME);
		  
		  this.mouseDownWaitForElementPresent("//div[contains(text(),'SMTP')]");  
		//assertEquals
	  }
	
}
