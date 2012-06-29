package com.talend.cases.configuration;

import java.awt.event.KeyEvent;
import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TestConfigurations extends configuration {
	
  @Test
  @Parameters({"commandlineConfPrimaryHost","commandlineConfPrimaryPort","commandlineConfPrimaryArchivePath"})
  public void testSetCommandlinePrimary(String commandlineHost,String commandlinePort,String commandlinePath) {
	
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'CommandLine/primary')]");
	  this.typeWordsInConfigurationMenu(other.getString("commandline.conf.primary.host.editButton"),locatorOfAllInputTags, commandlineHost);
	  this.typeWordsInConfigurationMenu(other.getString("commandline.conf.primary.port.editButton"),locatorOfAllInputTags, commandlinePort);
	  this.typeWordsInConfigurationMenu(other.getString("commandLine.conf.primary.archivePath.editButton"),locatorOfAllInputTags, this.getAbsolutePath(commandlinePath));

	  this.AssertEqualsInConfigurationMenu(other.getString("commandline.conf.primary.host.editButton"),locatorOfAllInputTags, commandlineHost,other.getString("commandLine.conf.primary.host.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("commandline.conf.primary.port.editButton"),locatorOfAllInputTags, commandlinePort,other.getString("commandline.conf.primary.port.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("commandLine.conf.primary.archivePath.editButton"),locatorOfAllInputTags, this.getAbsolutePath(commandlinePath));
//	  this.waitForElementPresent(other.getString("commandline.conf.primary.genralStatusIcon"), WAIT_TIME);
	  //->THIS IS NOT SUIT FOR AUTOMATION CURRENTLY,BECAUSE THE GENERAL ICON STATUS DID'T CHANGE IN TIME, AUTHOUGHT THE PARAMETERS ARE ALL CORRECT.

	  this.mouseDownWaitForElementPresent("//div[contains(text(),'CommandLine/primary')]");
  }
  @Test
  @Parameters ({"commandlineConfSecondaryHost","commandlineConfSecondaryPort","commandlineConfSecondaryArchivePath"})
  public void testSetCommandlineSecondary(String commandlineHost,String commandlinePort,String commandlinePath) {
	 
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'CommandLine/secondary')]");
	  this.typeWordsInConfigurationMenu(other.getString("commandline.conf.secondary.host.editButton"),locatorOfAllInputTags, commandlineHost);
	  this.typeWordsInConfigurationMenu(other.getString("commandline.conf.secondary.port.editButton"),locatorOfAllInputTags, commandlinePort);
	  this.typeWordsInConfigurationMenu(other.getString("commandLine.conf.secondary.archivePath.editButton"),locatorOfAllInputTags, this.getAbsolutePath(commandlinePath));
	  
	  this.AssertEqualsInConfigurationMenu(other.getString("commandline.conf.secondary.host.editButton"),locatorOfAllInputTags, commandlineHost,other.getString("commandLine.conf.secondary.host.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("commandline.conf.secondary.port.editButton"),locatorOfAllInputTags, commandlinePort,other.getString("commandline.conf.secondary.port.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("commandLine.conf.secondary.archivePath.editButton"),locatorOfAllInputTags, this.getAbsolutePath(commandlinePath));
//	  this.waitForElementPresent(other.getString("commandline.conf.secondary.generalStatusIcon"), WAIT_TIME);
	 
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'CommandLine/secondary')]");
	  
  }
  
  
  //set a stop zkServer
  @Test
  @Parameters ({"esbConfZookeeperServerStop","esbConfServiceActivityMonitorServer"})
  public void testSetESBWithStopZKServer(String zookeeperServer,String serviceActivityMonitorServer){
		
	  try {
		Thread.sleep(5000);
	  } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	  
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'ESB')]");
	  selenium.setSpeed(MID_SPEED);
	  this.typeWordsInConfigurationMenu(other.getString("esb.conf.ZookeeperServer.editButton"), locatorOfAllInputTags, zookeeperServer);
	  selenium.setSpeed(MIN_SPEED);
	  if(selenium.isElementPresent(other.getString("esb.conf.serviceActivityMonitorServer.editButton"))) {
		  
		  this.typeWordsInConfigurationMenu(other.getString("esb.conf.serviceActivityMonitorServer.editButton"), locatorOfAllInputTags, serviceActivityMonitorServer);
		  this.AssertEqualsInConfigurationMenu(other.getString("esb.conf.serviceActivityMonitorServer.editButton"), locatorOfAllInputTags,
				  serviceActivityMonitorServer, other.getString("esb.conf.ServiceActivityMonitorServerStatusIconLocator"));
		  
	  }	 
	  
	  this.AssertEqualsInConfigurationMenu(other.getString("esb.conf.ZookeeperServer.editButton"), locatorOfAllInputTags,
			  zookeeperServer, other.getString("esb.conf.StopZookeeperServerStatusIconLocator"));
	  
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'ESB')]"); 
	  
  }
  
  
  @Test
  @Parameters ({"esbConfZookeeperServer","esbConfServiceActivityMonitorServer"})
  public void testSetESBWithStartZKServer(String zookeeperServer,String serviceActivityMonitorServer){
	  
	  startStopZkServer("start", this.getZookeeperPath());	  
		
	  try {
		Thread.sleep(5000);
	  } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
		  
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'ESB')]");		  
	  selenium.setSpeed(MID_SPEED);
	  this.typeWordsInConfigurationMenu(other.getString("esb.conf.ZookeeperServer.editButton"), locatorOfAllInputTags, zookeeperServer);
	  selenium.setSpeed(MIN_SPEED);
	  if(selenium.isElementPresent(other.getString("esb.conf.serviceActivityMonitorServer.editButton"))) {
		  
		  this.typeWordsInConfigurationMenu(other.getString("esb.conf.serviceActivityMonitorServer.editButton"), locatorOfAllInputTags, serviceActivityMonitorServer);
		  this.AssertEqualsInConfigurationMenu(other.getString("esb.conf.serviceActivityMonitorServer.editButton"), locatorOfAllInputTags,
				  serviceActivityMonitorServer, other.getString("esb.conf.ServiceActivityMonitorServerStatusIconLocator"));
		  
	  }	 
	  selenium.click(other.getString("esb.conf.ZookeeperServer.editButton"));
	  selenium.click(locatorOfAllInputTags);
	  
	  this.AssertEqualsInConfigurationMenu(other.getString("esb.conf.ZookeeperServer.editButton"), locatorOfAllInputTags,
			  zookeeperServer, other.getString("esb.conf.ZookeeperServerStatusIconLocator"));
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'ESB')]");
	  
	 	  
//	  this.clickWaitForElementPresent("//div[contains(text(),'ESB (1 Parameter)')]");  
	  
  }

  @Test
  @Parameters ({"ldapConfuseLDAPAutentication","ldapConfLdapServerIp","ldapConfLdapServerPort","ldapConfLdapRoot","ldapConfLdapPrincipalDNPrefix",
	  "ldapConfLdapAdminPassword","ldapConfLdapFieldsMail","ldapConfLdapFieldsFirstname","ldapConfLdapFieldsLastname"})
  public void testSetLDAP(String useLDAPAutentication,String ldapServerIp,String ldapServerPort,String ldapRoot,String ldapPrincipalDNPrefix,String ldapAdminPassword,String ldapFieldsMail,String ldapFieldsFirstName,String ldapFieldsLastName ) {
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'LDAP (11 Parameters')]");
	  this.typeWordsInConfigurationMenu(other.getString("LDAP.conf.useLDAPAutentication.editButton"), locatorOfAllInputTags, useLDAPAutentication);
	  this.typeWordsInConfigurationMenu(other.getString("LDAP.conf.ldapServerIp.editButton"), locatorOfAllInputTags, ldapServerIp);
	  this.typeWordsInConfigurationMenu(other.getString("LDAP.conf.ldapServerPort.editButton"), locatorOfAllInputTags, ldapServerPort);
	  this.typeWordsInConfigurationMenu(other.getString("LDAP.conf.ldapRoot.editButton"), locatorOfAllInputTags, ldapRoot);
	  this.typeWordsInConfigurationMenu(other.getString("LDAP.conf.ldapPrincipalDNPrefix.editButton"), locatorOfAllInputTags, ldapPrincipalDNPrefix);
	  this.typeWordsInConfigurationMenu(other.getString("LDAP.conf.ldapAdminPassword.editButton"), locatorOfAllInputTags, ldapAdminPassword);
	  this.typeWordsInConfigurationMenu(other.getString("LDAP.conf.ldap.fields.mail.editButton"), locatorOfAllInputTags, ldapFieldsMail);
	  this.typeWordsInConfigurationMenu(other.getString("LDAP.conf.ldap.fields.firstname.editButton"), locatorOfAllInputTags, ldapFieldsFirstName);
	  this.typeWordsInConfigurationMenu(other.getString("LDAP.conf.ldap.fields.lastname.editButton"), locatorOfAllInputTags, ldapFieldsLastName);
	
	  this.AssertEqualsInConfigurationMenu(other.getString("LDAP.conf.useLDAPAutentication.editButton"), locatorOfAllInputTags, useLDAPAutentication);
	  this.AssertEqualsInConfigurationMenu(other.getString("LDAP.conf.ldapServerIp.editButton"), locatorOfAllInputTags, ldapServerIp);
	  this.AssertEqualsInConfigurationMenu(other.getString("LDAP.conf.ldapServerPort.editButton"), locatorOfAllInputTags, ldapServerPort);
	  this.AssertEqualsInConfigurationMenu(other.getString("LDAP.conf.ldapRoot.editButton"), locatorOfAllInputTags, ldapRoot);
	  this.AssertEqualsInConfigurationMenu(other.getString("LDAP.conf.ldapPrincipalDNPrefix.editButton"), locatorOfAllInputTags, ldapPrincipalDNPrefix);
	  this.AssertEqualsInConfigurationMenu(other.getString("LDAP.conf.ldapAdminPassword.editButton"), locatorOfAllInputTags, ldapAdminPassword);
	  this.AssertEqualsInConfigurationMenu(other.getString("LDAP.conf.ldap.fields.mail.editButton"), locatorOfAllInputTags, ldapFieldsMail);
	  this.AssertEqualsInConfigurationMenu(other.getString("LDAP.conf.ldap.fields.firstname.editButton"), locatorOfAllInputTags, ldapFieldsFirstName);
	  this.AssertEqualsInConfigurationMenu(other.getString("LDAP.conf.ldap.fields.lastname.editButton"), locatorOfAllInputTags, ldapFieldsLastName);
	
	  
	  //check ldap imgs
	  if(useLDAPAutentication.equals("true")){
	  this.waitForElementPresent("//div[contains(text(),' LDAP (11 Parameters')]/parent::div/following-sibling::div//table//div[text()='Host']/parent::td/following-sibling::td//img[@title='Ok']",WAIT_TIME);
	  }
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'LDAP (11 Parameters')]");
  }
  @Test
  @Parameters ({"log4j.conf.logsPath","log4j.conf.logsName"})
  public void testSetLog4j(String logsPath,String logsName){
	  	  
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Log4j (2')]");
	  this.typeWordsInConfigurationMenu(other.getString("log4j.conf.logsPath.editButton"), locatorOfAllInputTags, this.getAbsolutePath(logsPath)+logsName);
 
	  this.AssertEqualsInConfigurationMenu(other.getString("log4j.conf.logsPath.editButton"), locatorOfAllInputTags,
			  this.getAbsolutePath(logsPath)+logsName, other.getString("log4j.conf.TalendAppenderStatusIconLocator"));
	  Assert.assertTrue(selenium.isElementPresent(other.getString("log4j.conf.TechnicalLogThreshold.StatusIcon")));
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Log4j (2')]");
	  this.clickWaitForElementPresent("//div[contains(text(),'Log4j (2 Parameters)')]");  
  }
  @Test
  @Parameters ({"smtpConfUseSmtp","smtpConfMailServerHost","smtpConfMailServerPort","smtpConfMailUserName","smtpConfMailPassword","smtpConfServerRequireSSL"})
  public void testSetSMTP(String useSmtp,String mailServerHost,String mailServerPort,String mailUserName,String mailPassword,String serverRequireSSL){//String serverRequireSSL
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'SMTP')]");
	  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.useSmtp.editButton"), locatorOfAllInputTags, useSmtp);
	  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.mailServerHost.editButton"), locatorOfAllInputTags, mailServerHost);
	  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.mailServerPort.editButton"), locatorOfAllInputTags, mailServerPort);
	  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.mailUserName.editButton"), locatorOfAllInputTags, mailUserName);
	  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.mailPassword.editButton"), locatorOfAllInputTags, mailPassword);
	  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.serverRequireSSL.editButton"), locatorOfAllInputTags, serverRequireSSL);
	  
	  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.useSmtp.editButton"), locatorOfAllInputTags, useSmtp,other.getString("smtp.conf.useSmtp.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.mailServerHost.editButton"), locatorOfAllInputTags, mailServerHost,other.getString("smtp.conf.mailServerHost.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.mailServerPort.editButton"), locatorOfAllInputTags, mailServerPort,other.getString("smtp.conf.mailServerPort.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.mailUserName.editButton"), locatorOfAllInputTags, mailUserName,other.getString("smtp.conf.mailUserName.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.mailPassword.editButton"), locatorOfAllInputTags, mailPassword,other.getString("smtp.conf.mailPassword.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.serverRequireSSL.editButton"), locatorOfAllInputTags, serverRequireSSL,other.getString("smtp.conf.serverRequireSSL.statusIcon"));
//	  this.waitForElementPresent(other.getString("smtp.conf.generalStatusIcon"), WAIT_TIME);
	  
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'SMTP')]");  
	//assertEquals
  }
  
  @Test
  @Parameters ({"scheduler.conf.ArchivedPath","scheduler.conf.LogsPath"})
  public void testSetJobconductor(String ArchivedPath,String logsPath){
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Job conductor (')]"); 
	  this.typeWordsInConfigurationMenu(other.getString("scheduler.conf.ArchivedPath.editButton"), locatorOfAllInputTags, this.getAbsolutePath(ArchivedPath));
	  this.typeWordsInConfigurationMenu(other.getString("scheduler.conf.LogsPath.editButton"), locatorOfAllInputTags, this.getAbsolutePath(logsPath));
	  this.AssertEqualsInConfigurationMenu(other.getString("scheduler.conf.ArchivedPath.editButton"), locatorOfAllInputTags, this.getAbsolutePath(ArchivedPath),other.getString("scheduler.conf.ArchivedPath.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("scheduler.conf.LogsPath.editButton"), locatorOfAllInputTags, this.getAbsolutePath(logsPath),other.getString("scheduler.conf.LogsPath.statusIcon"));
//	  this.waitForElementPresent(other.getString("scheduler.conf.generalStatusIcon"), WAIT_TIME);
	 
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Job conductor (')]"); 
	//assertEquals
  }
//  @Test
  @Parameters ({"soaManager.conf.jobsDeployPath","soaManager.conf.serverAddress","soaManager.conf.serverPort"})
  public void testSetSoaManager(String soaJobDeployedPath,String soaMangerHost,String soaMangerProt){
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Soa manager (')]"); 
	  this.typeWordsInConfigurationMenu(other.getString("soaManager.conf.jobsDeployPath.editButton"), locatorOfAllInputTags, this.getAbsolutePath(soaJobDeployedPath));
	  this.typeWordsInConfigurationMenu(other.getString("soaManager.conf.serverAddress.editButton"), locatorOfAllInputTags, soaMangerHost);
	  this.typeWordsInConfigurationMenu(other.getString("soaManager.conf.serverPort.editButton"), locatorOfAllInputTags, soaMangerProt);
		
	  this.AssertEqualsInConfigurationMenu(other.getString("soaManager.conf.jobsDeployPath.editButton"), locatorOfAllInputTags, this.getAbsolutePath(soaJobDeployedPath),other.getString("soaManager.conf.jobsDeployPath.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("soaManager.conf.serverAddress.editButton"), locatorOfAllInputTags, soaMangerHost,other.getString("soaManager.conf.serverAddress.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("soaManager.conf.serverPort.editButton"), locatorOfAllInputTags, soaMangerProt,other.getString("soaManager.conf.serverPort.statusIcon"));
//	  this.waitForElementPresent(other.getString("soaManager.conf.generalStatusIcon"), WAIT_TIME);
	 
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Soa manager (')]"); 
	//assertEquals
  }


  @Test
  @Parameters ({"svnUrl","svnConfServerUser","svnConfServerPassword"})
  public void testSetSVN(String svnServerLocationUrl,String svnServerUser,String svnServerPassword){
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Svn (')]"); 
	  this.typeWordsInConfigurationMenu(other.getString("svn.conf.serverLocationURL.editButton"), locatorOfAllInputTags, svnServerLocationUrl);
	  this.typeWordsInConfigurationMenu(other.getString("svn.conf.serverUser.editButton"), locatorOfAllInputTags, svnServerUser);
	  this.typeWordsInConfigurationMenu(other.getString("svn.conf.serverPassword.editButton"), locatorOfAllInputTags, svnServerPassword);
		
	  this.AssertEqualsInConfigurationMenu(other.getString("svn.conf.serverLocationURL.editButton"), locatorOfAllInputTags, svnServerLocationUrl,other.getString("svn.conf.serverLocationURL.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("svn.conf.serverUser.editButton"), locatorOfAllInputTags, svnServerUser,other.getString("svn.conf.serverUser.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("svn.conf.serverPassword.editButton"), locatorOfAllInputTags, svnServerPassword,other.getString("svn.conf.serverPassword.statusIcon"));
//	  this.waitForElementPresent(other.getString("svn.conf.generalStatusIcon"), WAIT_TIME);//assertion of the general icon.It should be green if all the parameters set correctly
	 
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Svn (')]"); 	
	//assertEquals
  }

  @Test(enabled=false)
  @Parameters ({"suite.link.dqportal","suite.link.drools","suite.link.mdm"})
  public void testLinkToTalendSuite(String dqportal,String drools,String mdm){
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Talend suite')]"); 
	  
//	  this.typeWordsInConfigurationMenu(other.getString("suite.link.dqportal.editButton"), locatorOfAllInputTags, dqportal);
//	  this.typeWordsInConfigurationMenu(other.getString("suite.link.drools.editButton"), locatorOfAllInputTags, drools);
//	  this.typeWordsInConfigurationMenu(other.getString("suite.link.mdm.editButton"), locatorOfAllInputTags, mdm);
	
	  this.typeWordsInConfigurationMenu(other.getString("suite.link.dqportal.editButton"), locatorOfAllInputTags, dqportal);
	  this.waitForElementPresent("!!!menu.dqportal.element!!!",WAIT_TIME);
	  this.typeWordsInConfigurationMenu(other.getString("suite.link.drools.editButton"), locatorOfAllInputTags, drools);
	  this.waitForElementPresent("!!!menu.drools.element!!!",WAIT_TIME);
	  this.typeWordsInConfigurationMenu(other.getString("suite.link.mdm.editButton"), locatorOfAllInputTags, mdm);
	  this.waitForElementPresent("!!!menu.mdm.element!!!",WAIT_TIME);
	  //assertEquals
  }
  
  /**
   * using firefox profile to start server, this is mainly to avoid the popup windows when loading a file.
   * java -jar selenium-server.jar -firefoxProfileTemplate C:\Talend\ff\profile
   * (copy mimeTypes.rdf and prefs.js to this folder C:\Talend\ff\profile\)
   * @param downloadPath
   * @param logsName
   */
		  
	@Test//(enabled=true,dependsOnMethods="testSetLog4j")
	 @Parameters ({"firefoxDownloadPath","log4j.conf.logsName"})
	public void testDownloadLog(String downloadPath,String logsName) {
		this.mouseDownWaitForElementPresent("//div[contains(text(),'CommandLine/primary')]");
		this.clickWaitForElementPresent("//button[text()='Download Log']");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		selenium.setSpeed(MID_SPEED);
		selenium.keyDownNative(""+KeyEvent.VK_ENTER);
		selenium.keyUpNative(""+KeyEvent.VK_ENTER);
		selenium.setSpeed(MIN_SPEED);
		
//		File file = new File(
//				"C:\\Users\\Administrator\\Downloads\\422NBS.txt.zip");
		
		String absoluteDownloadPath=this.getAbsolutePath(downloadPath);
//		String absoluteDownloadPath=new Properties(System.getProperties()).getProperty("user.home") + File.separator +"Downloads";
		File file = new File(
				absoluteDownloadPath+logsName+".zip");
		for (int seconds = 0;; seconds++) {
			if (seconds >= WAIT_TIME) {
				assertTrue(file.exists());
			}
			if (file.exists()) {
				System.out.println(seconds + "' used to download");
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Test//(enabled=false)
	@Parameters ({"firefoxDownloadPath"})
	public void testExportParameters(String downloadPath) {
		this.mouseDownWaitForElementPresent("//div[contains(text(),'CommandLine/primary')]");
		this.clickWaitForElementPresent("//button[text()='Export parameters']");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		selenium.setSpeed(MID_SPEED);
		selenium.keyDownNative(""+KeyEvent.VK_ENTER);
		selenium.keyUpNative(""+KeyEvent.VK_ENTER);
		selenium.setSpeed(MIN_SPEED);
		
		String absoluteDownloadPath=this.getAbsolutePath(downloadPath);
		//to encourage the download path to be user.home. Any way, the path should match with that defined by firefox profile.
//		String absoluteDownloadPath=new Properties(System.getProperties()).getProperty("user.home") + File.separator +"Downloads";
		File file = new File(
				absoluteDownloadPath + "administrator_config.txt");
		for (int seconds = 0;; seconds++) {
			if (seconds >= WAIT_TIME) {
				assertTrue(file.exists());
			}
			if (file.exists()) {
				System.out.println(seconds + "' used to download");
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

}
