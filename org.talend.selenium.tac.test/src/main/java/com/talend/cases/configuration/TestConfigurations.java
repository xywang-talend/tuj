package com.talend.cases.configuration;

import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import com.talend.tac.base.AntAction;
import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class TestConfigurations extends configuration {
	
  @Test
  @Parameters({"commandline.conf.primary.host","commandline.conf.primary.port","commandline.conf.primary.archivePath"})
  public void testSetCommandlinePrimary(String commandlineHost,String commandlinePort,String commandlinePath) {
	
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'CommandLine/primary')]");
	  this.typeWordsInConfigurationMenu(other.getString("commandline.conf.primary.host.editButton"),other.getString("commandline.conf.primary.host.input"), commandlineHost);
	  this.typeWordsInConfigurationMenu(other.getString("commandline.conf.primary.port.editButton"),other.getString("commandline.conf.primary.port.input"), commandlinePort);
	  this.typeWordsInConfigurationMenu(other.getString("commandLine.conf.primary.archivePath.editButton"),other.getString("commandLine.conf.primary.archivePath.input"), this.getAbsolutePath(commandlinePath));

	  this.AssertEqualsInConfigurationMenu(other.getString("commandline.conf.primary.host.value"), commandlineHost,other.getString("commandLine.conf.primary.host.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("commandline.conf.primary.port.value"), commandlinePort,other.getString("commandline.conf.primary.port.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("commandline.conf.primary.archivePath.value"), this.getAbsolutePath(commandlinePath));
//	  this.waitForElementPresent(other.getString("commandline.conf.primary.genralStatusIcon"), WAIT_TIME);
	  //->THIS IS NOT SUIT FOR AUTOMATION CURRENTLY,BECAUSE THE GENERAL ICON STATUS DID'T CHANGE IN TIME, AUTHOUGHT THE PARAMETERS ARE ALL CORRECT.

	  this.mouseDownWaitForElementPresent("//div[contains(text(),'CommandLine/primary')]");
  }
  @Test
  @Parameters ({"commandline.conf.secondary.host","commandline.conf.secondary.port","commandline.conf.secondary.archivePath"})
  public void testSetCommandlineSecondary(String commandlineHost,String commandlinePort,String commandlinePath) {
	 
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'CommandLine/secondary')]");
	  this.typeWordsInConfigurationMenu(other.getString("commandline.conf.secondary.host.editButton"),other.getString("commandline.conf.secondary.host.input"), commandlineHost);
	  this.typeWordsInConfigurationMenu(other.getString("commandline.conf.secondary.port.editButton"),other.getString("commandline.conf.secondary.port.input"), commandlinePort);
	  this.typeWordsInConfigurationMenu(other.getString("commandLine.conf.secondary.archivePath.editButton"),other.getString("commandLine.conf.secondary.archivePath.input"), this.getAbsolutePath(commandlinePath));
	  
	  this.AssertEqualsInConfigurationMenu(other.getString("commandline.conf.secondary.host.value"), commandlineHost,other.getString("commandLine.conf.secondary.host.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("commandline.conf.secondary.port.value"), commandlinePort,other.getString("commandline.conf.secondary.port.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("commandline.conf.secondary.archivePath.value"), this.getAbsolutePath(commandlinePath));
//	  this.waitForElementPresent(other.getString("commandline.conf.secondary.generalStatusIcon"), WAIT_TIME);
	 
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'CommandLine/secondary')]");
	  
  }
  
  
  //set a stop zkServer
  @Test
  @Parameters ({"esb.conf.zookeeperServer","esb.conf.serviceActivityMonitorServer"})
  public void testSetESBWithStopZKServer(String zookeeperServer,String serviceActivityMonitorServer){
		
	  try {
		Thread.sleep(5000);
	  } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	  
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'ESB')]");
	  selenium.setSpeed(MID_SPEED);
	  this.typeWordsInConfigurationMenu(other.getString("esb.conf.ZookeeperServer.editButton"), other.getString("esb.conf.ZookeeperServer.input"), zookeeperServer);
	  selenium.setSpeed(MIN_SPEED);
	  if(selenium.isElementPresent(other.getString("esb.conf.serviceActivityMonitorServer.editButton"))) {
		  
		  this.typeWordsInConfigurationMenu(other.getString("esb.conf.serviceActivityMonitorServer.editButton"), other.getString("esb.conf.serviceActivityMonitorServer.input"), serviceActivityMonitorServer);
		  this.AssertEqualsInConfigurationMenu(other.getString("esb.conf.serviceActivityMonitorServer.value"),
				  serviceActivityMonitorServer, other.getString("esb.conf.ServiceActivityMonitorServerStatusIconLocator"));
		  
	  }	 
	  
	  this.AssertEqualsInConfigurationMenu(other.getString("esb.conf.ZookeeperServer.value"),
			  zookeeperServer, other.getString("esb.conf.StopZookeeperServerStatusIconLocator"));
	  
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'ESB')]"); 
	  
  }
  
  
  @Test
  @Parameters ({"esb.conf.zookeeperServer","esb.conf.serviceActivityMonitorServer"})
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
	  this.typeWordsInConfigurationMenu(other.getString("esb.conf.ZookeeperServer.editButton"), other.getString("esb.conf.ZookeeperServer.input"), zookeeperServer);
	  selenium.setSpeed(MIN_SPEED);
	  if(selenium.isElementPresent(other.getString("esb.conf.serviceActivityMonitorServer.editButton"))) {
		  
		  this.typeWordsInConfigurationMenu(other.getString("esb.conf.serviceActivityMonitorServer.editButton"), other.getString("esb.conf.serviceActivityMonitorServer.input"), serviceActivityMonitorServer);
		  this.AssertEqualsInConfigurationMenu(other.getString("esb.conf.serviceActivityMonitorServer.value"),
				  serviceActivityMonitorServer, other.getString("esb.conf.ServiceActivityMonitorServerStatusIconLocator"));
		  
	  }	 
	  selenium.click(other.getString("esb.conf.ZookeeperServer.editButton"));
	  selenium.click(other.getString("esb.conf.ZookeeperServer.input"));
	  
	  this.AssertEqualsInConfigurationMenu(other.getString("esb.conf.ZookeeperServer.value"),
			  zookeeperServer, other.getString("esb.conf.ZookeeperServerStatusIconLocator"));
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'ESB')]");
	  
	 	  
//	  this.clickWaitForElementPresent("//div[contains(text(),'ESB (1 Parameter)')]");  
	  
  }

  @Test
  @Parameters ({"LDAP.conf.useLDAPAutentication", "LDAP.conf.ldapServerIp","LDAP.conf.ldapServerPort","LDAP.conf.ldapRoot","LDAP.conf.ldapPrincipalDNPrefix",
	  "LDAP.conf.ldapAdminPassword","LDAP.conf.ldap.fields.mail","LDAP.conf.ldap.fields.firstname","LDAP.conf.ldap.fields.lastname"})
  public void testSetLDAP(String useLDAPAutentication, String ldapServerIp,String ldapServerPort,String ldapRoot,String ldapPrincipalDNPrefix,String ldapAdminPassword,String ldapFieldsMail,String ldapFieldsFirstName,String ldapFieldsLastName ) {
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'LDAP (11 Parameters')]");
	  this.selectDropDownListInConfigurationMenu(other.getString("LDAP.conf.useLDAPAutentication.editButton"), other.getString("LDAP.conf.useLDAPAutentication.select"), useLDAPAutentication);
	  this.typeWordsInConfigurationMenu(other.getString("LDAP.conf.ldapServerIp.editButton"), other.getString("LDAP.conf.ldapServerIp.input"), ldapServerIp);
	  this.typeWordsInConfigurationMenu(other.getString("LDAP.conf.ldapServerPort.editButton"), other.getString("LDAP.conf.ldapServerPort.input"), ldapServerPort);
	  this.typeWordsInConfigurationMenu(other.getString("LDAP.conf.ldapRoot.editButton"), other.getString("LDAP.conf.ldapRoot.input"), ldapRoot);
	  this.typeWordsInConfigurationMenu(other.getString("LDAP.conf.ldapPrincipalDNPrefix.editButton"), other.getString("LDAP.conf.ldapPrincipalDNPrefix.input"), ldapPrincipalDNPrefix);
	  this.typeWordsInConfigurationMenu(other.getString("LDAP.conf.ldapAdminPassword.editButton"), other.getString("LDAP.conf.ldapAdminPassword.input"), ldapAdminPassword);
	  this.typeWordsInConfigurationMenu(other.getString("LDAP.conf.ldap.fields.mail.editButton"), other.getString("LDAP.conf.ldap.fields.mail.input"), ldapFieldsMail);
	  this.typeWordsInConfigurationMenu(other.getString("LDAP.conf.ldap.fields.firstname.editButton"), other.getString("LDAP.conf.ldap.fields.firstname.input"), ldapFieldsFirstName);
	  this.typeWordsInConfigurationMenu(other.getString("LDAP.conf.ldap.fields.lastname.editButton"), other.getString("LDAP.conf.ldap.fields.lastname.input"), ldapFieldsLastName);
	
	  this.AssertEqualsInConfigurationMenu(other.getString("LDAP.conf.useLDAPAutentication.value"), useLDAPAutentication);
	  this.AssertEqualsInConfigurationMenu(other.getString("LDAP.conf.ldapServerIp.value"), ldapServerIp);
	  this.AssertEqualsInConfigurationMenu(other.getString("LDAP.conf.ldapServerPort.value"), ldapServerPort);
	  this.AssertEqualsInConfigurationMenu(other.getString("LDAP.conf.ldapRoot.value"), ldapRoot);
	  this.AssertEqualsInConfigurationMenu(other.getString("LDAP.conf.ldapPrincipalDNPrefix.value"), ldapPrincipalDNPrefix);
	  this.AssertEqualsInputInConfigurationMenu(other.getString("LDAP.conf.ldapAdminPassword.editButton"), other.getString("LDAP.conf.ldapAdminPassword.input"), ldapAdminPassword);
	  this.AssertEqualsInConfigurationMenu(other.getString("LDAP.conf.ldap.fields.mail.value"), ldapFieldsMail);
	  this.AssertEqualsInConfigurationMenu(other.getString("LDAP.conf.ldap.fields.firstname.value"), ldapFieldsFirstName);
	  this.AssertEqualsInConfigurationMenu(other.getString("LDAP.conf.ldap.fields.lastname.value"), ldapFieldsLastName);
	
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'LDAP (11 Parameters')]");
  }
  @Test
  @Parameters ({"log4j.conf.logsPath","log4j.conf.logsName"})
  public void testSetLog4j(String logsPath,String logsName){
	  	  
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Log4j')]");
	  this.typeWordsInConfigurationMenu(other.getString("log4j.conf.logsPath.editButton"), other.getString("log4j.conf.logsPath.input"), this.getAbsolutePath(logsPath)+logsName);
	  System.err.println("11>>>>>0"+selenium.getText(other.getString("log4j.conf.logsPath.value")));
	  System.err.println("22>>>>>0"+this.getAbsolutePath(logsPath)+logsName);
	  this.AssertEqualsInConfigurationMenu(other.getString("log4j.conf.logsPath.value"),
			  this.getAbsolutePath(logsPath)+logsName, other.getString("log4j.conf.TechnicalLogThreshold.StatusIcon"));
	  
	  assertTrue(selenium.isElementPresent(other.getString("log4j.conf.TechnicalLogThreshold.StatusIcon")));
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Log4j')]");
	  this.clickWaitForElementPresent("//div[contains(text(),'Log4j')]");  
  }
  @Test
  @Parameters ({"smtp.conf.useSmtp","smtp.conf.mailServerHost","smtp.conf.mailServerPort","smtp.conf.mailUserName","smtp.conf.mailPassword","smtp.conf.serverRequireSSL"})
  public void testSetSMTP(String useSmtp,String mailServerHost,String mailServerPort,String mailUserName,String mailPassword,String serverRequireSSL){//String serverRequireSSL
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'SMTP')]");
	  this.selectDropDownListInConfigurationMenu(other.getString("smtp.conf.useSmtp.editButton"), other.getString("smtp.conf.useSmtp.select"), useSmtp);
	  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.mailServerHost.editButton"), other.getString("smtp.conf.mailServerHost.input"), mailServerHost);
	  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.mailServerPort.editButton"), other.getString("smtp.conf.mailServerPort.input"), mailServerPort);
	  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.mailUserName.editButton"), other.getString("smtp.conf.mailUserName.input"), mailUserName);
	  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.mailPassword.editButton"), other.getString("smtp.conf.mailPassword.input"), mailPassword);
	  this.typeWordsInConfigurationMenu(other.getString("smtp.conf.serverRequireSSL.editButton"), other.getString("smtp.conf.serverRequireSSL.input"), serverRequireSSL);
       
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  if(!selenium.isElementPresent("//div[contains(text(),'SMTP (6 Parameters')]//img[@title='Ok']")) {
			  
			  selenium.refresh();  
			  
	  }
	  
	  this.waitElement("//div[contains(text(),'SMTP (6 Parameters')]//img[@title='Ok']", WAIT_TIME);
	  
	  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.useSmtp.value"), useSmtp,other.getString("smtp.conf.useSmtp.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.mailServerHost.value"), mailServerHost,other.getString("smtp.conf.mailServerHost.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.mailServerPort.value"), mailServerPort,other.getString("smtp.conf.mailServerPort.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.mailUserName.value"), mailUserName,other.getString("smtp.conf.mailUserName.statusIcon"));
	  this.AssertEqualsInputInConfigurationMenu(other.getString("smtp.conf.mailPassword.editButton"), other.getString("smtp.conf.mailPassword.input"), mailPassword);
	  this.AssertEqualsInConfigurationMenu(other.getString("smtp.conf.serverRequireSSL.value"), serverRequireSSL,other.getString("smtp.conf.serverRequireSSL.statusIcon"));
//	  this.waitForElementPresent(other.getString("smtp.conf.generalStatusIcon"), WAIT_TIME);
	  
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'SMTP')]");  
	//assertEquals
  }
  
  @Test
  @Parameters ({"scheduler.conf.ArchivedPath","scheduler.conf.LogsPath"})
  public void testSetScheduler(String ArchivedPath,String logsPath){
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Job conductor')]"); 
	  this.typeWordsInConfigurationMenu(other.getString("scheduler.conf.ArchivedPath.editButton"), other.getString("scheduler.conf.ArchivedPath.input"), this.getAbsolutePath(ArchivedPath));
	  this.typeWordsInConfigurationMenu(other.getString("scheduler.conf.LogsPath.editButton"), other.getString("scheduler.conf.LogsPath.input"), this.getAbsolutePath(logsPath));
	  this.AssertEqualsInConfigurationMenu(other.getString("scheduler.conf.ArchivedPath.value"), this.getAbsolutePath(ArchivedPath),other.getString("scheduler.conf.ArchivedPath.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("scheduler.conf.LogsPath.value"), this.getAbsolutePath(logsPath),other.getString("scheduler.conf.LogsPath.statusIcon"));
//	  this.waitForElementPresent(other.getString("scheduler.conf.generalStatusIcon"), WAIT_TIME);
	 
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Job conductor')]"); 
	//assertEquals
  }
//  	@Test
//  @Parameters ({"soaManager.conf.jobsDeployPath","soaManager.conf.serverAddress","soaManager.conf.serverPort"})
//  public void testSetSoaManager(String soaJobDeployedPath,String soaMangerHost,String soaMangerProt){
//	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Soa manager (')]"); 
//	  this.typeWordsInConfigurationMenu(other.getString("soaManager.conf.jobsDeployPath.editButton"), other.getString("soaManager.conf.jobsDeployPath.input"), this.getAbsolutePath(soaJobDeployedPath));
//	  this.typeWordsInConfigurationMenu(other.getString("soaManager.conf.serverAddress.editButton"), other.getString("soaManager.conf.serverAddress.input"), soaMangerHost);
//	  this.typeWordsInConfigurationMenu(other.getString("soaManager.conf.serverPort.editButton"), other.getString("soaManager.conf.serverPort.input"), soaMangerProt);
//		
//	  this.AssertEqualsInConfigurationMenu(other.getString("soaManager.conf.jobsDeployPath.editButton"), other.getString("soaManager.conf.jobsDeployPath.input"), this.getAbsolutePath(soaJobDeployedPath),other.getString("soaManager.conf.jobsDeployPath.statusIcon"));
//	  this.AssertEqualsInConfigurationMenu(other.getString("soaManager.conf.serverAddress.editButton"), other.getString("soaManager.conf.serverAddress.input"), soaMangerHost,other.getString("soaManager.conf.serverAddress.statusIcon"));
//	  this.AssertEqualsInConfigurationMenu(other.getString("soaManager.conf.serverPort.editButton"), other.getString("soaManager.conf.serverPort.input"), soaMangerProt,other.getString("soaManager.conf.serverPort.statusIcon"));
////	  this.waitForElementPresent(other.getString("soaManager.conf.generalStatusIcon"), WAIT_TIME);
//	 
//	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Soa manager (')]"); 
//	//assertEquals
//  }


  @Test
  @Parameters ({"svn.conf.serverLocationURL","svn.conf.serverUser","svn.conf.serverPassword"})
  public void testSetSVN(String svnServerLocationUrl,String svnServerUser,String svnServerPassword){
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Svn (')]"); 
	  this.typeWordsInConfigurationMenu(other.getString("svn.conf.serverLocationURL.editButton"), other.getString("svn.conf.serverLocationURL.input"), svnServerLocationUrl);
	  this.typeWordsInConfigurationMenu(other.getString("svn.conf.serverUser.editButton"), other.getString("svn.conf.serverUser.input"), svnServerUser);
	  this.typeWordsInConfigurationMenu(other.getString("svn.conf.serverPassword.editButton"), other.getString("svn.conf.serverPassword.input"), svnServerPassword);
	  
	  if(!selenium.isElementPresent(other.getString("svn.conf.serverLocationURL.statusIcon"))) {
			  
			  selenium.click("//div[text()='Configuration' and @class='header-title']//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct')]//button[@id='idConfigRefreshButton']");  
			  
	  }
	  
	  this.waitElement(other.getString("svn.conf.serverLocationURL.statusIcon"), WAIT_TIME);
	  
	  this.AssertEqualsInConfigurationMenu(other.getString("svn.conf.serverLocationURL.value"), svnServerLocationUrl,other.getString("svn.conf.serverLocationURL.statusIcon"));
	  this.AssertEqualsInConfigurationMenu(other.getString("svn.conf.serverUser.value"), svnServerUser,other.getString("svn.conf.serverUser.statusIcon"));
	  this.AssertEqualsInputInConfigurationMenu(other.getString("svn.conf.serverPassword.editButton"), other.getString("svn.conf.serverPassword.input"), svnServerPassword);
//	  this.waitForElementPresent(other.getString("svn.conf.generalStatusIcon"), WAIT_TIME);//assertion of the general icon.It should be green if all the parameters set correctly
	 
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Svn (')]"); 	
	//assertEquals
  }

  @Test(enabled=false)
  @Parameters ({"suite.link.dqportal","suite.link.drools","suite.link.mdm"})
  public void testLinkToTalendSuite(String dqportal,String drools,String mdm){
	  this.mouseDownWaitForElementPresent("//div[contains(text(),'Talend suite')]"); 
	  
//	  this.typeWordsInConfigurationMenu(other.getString("suite.link.dqportal.editButton"), other.getString(), dqportal);
//	  this.typeWordsInConfigurationMenu(other.getString("suite.link.drools.editButton"), other.getString(), drools);
//	  this.typeWordsInConfigurationMenu(other.getString("suite.link.mdm.editButton"), other.getString(), mdm);
	
	  this.typeWordsInConfigurationMenu(other.getString("suite.link.dqportal.editButton"), other.getString("suite.link.dqportal.input"), dqportal);
	  this.waitForElementPresent("!!!menu.dqportal.element!!!",WAIT_TIME);
	  this.typeWordsInConfigurationMenu(other.getString("suite.link.drools.editButton"), other.getString("suite.link.drools.input"), drools);
	  this.waitForElementPresent("!!!menu.drools.element!!!",WAIT_TIME);
	  this.typeWordsInConfigurationMenu(other.getString("suite.link.mdm.editButton"), other.getString("suite.link.mdm.input"), mdm);
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
	@Parameters ({"firefox.download.path","log4j.conf.logsName"})
	public void testDownloadLog(String downloadPath,String logsName) {
		this.mouseDownWaitForElementPresent("//div[contains(text(),' CommandLine/primary')]");
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
	@Parameters ({"firefox.download.path"})
	public void testExportParameters(String downloadPath) {
		this.mouseDownWaitForElementPresent("//div[contains(text(),' CommandLine/primary')]");
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
