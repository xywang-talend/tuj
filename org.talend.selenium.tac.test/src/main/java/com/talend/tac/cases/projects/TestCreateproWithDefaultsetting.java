/*
 * CaseName:
 * CreateproWithDefaultsettint
 * Steps:
 1. Configuration of the SVN parameters in Configuration page
    Server location URL : URL of your repository
    Username : SVN username
    Password : SVN password
 2. Creation of a project
    Label : project name
    Language : Java
    Description : description of the project
    Repository : Subversion
 * expect result:
    1. SVN parameters are all green
    2. The SVN project is created and appears in the projects list
 *Auto test problem:
    when configuration some id not be sure for now
    such as:
           svnusernameinput
           svnpasswordinput
 */

package com.talend.tac.cases.projects;

import java.awt.event.KeyEvent;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestCreateproWithDefaultsetting extends Login {
	@Test
	@Parameters({ "svnUrl", "svnUserName", "svnUserPassword", "proLableName",
			"proLanguage" })
	public void f(String SVNurl, String SVNusername, String SVNpassword,
			String prolable, String language) {
		configSetting(SVNurl, SVNusername, SVNpassword);

		addpro(prolable, language);
	}

	public void configSetting(String SVNurl, String SVNusername,
			String SVNpassword) {
		selenium.setSpeed("5000");
		selenium.click("idMenuConfigElement");//
		// selenium.waitForPageToLoad("30000");
		this.waitForElementPresent("//div[text()=' Svn (3 Parameters)']", 30000);
		// selenium.setSpeed("50000");
		// **config the default_settings;
		// selenium.click(rb.getString("config.svn"));
		selenium.click("//div[text()=' Svn (3 Parameters)']");
		selenium.setSpeed("2000");

		selenium.click("//div[text()='"
				+ rb.getString("config.svn.serverLocationUrl") + "']");
		selenium.type(
				"//div[text()='" + rb.getString("config.svn.serverLocationUrl")
						+ "']", SVNurl);
		selenium.fireEvent(
				"//div[text()='" + rb.getString("config.svn.serverLocationUrl")
						+ "']", "blur");
		selenium.click("//div[text()='" + rb.getString("config.svn.username")
				+ "']");
		selenium.type("//div[text()='" + rb.getString("config.svn.username")
				+ "']", SVNusername);
		selenium.fireEvent(
				"//div[text()='" + rb.getString("config.svn.username") + "']",
				"blur");
		selenium.click("//div[text()='" + rb.getString("config.svn.password")
				+ "']");
		selenium.type("//div[text()='" + rb.getString("config.svn.password")
				+ "']", SVNpassword);
		selenium.fireEvent(
				"//div[text()='" + rb.getString("config.svn.password") + "']",
				"blur");

		// **
	}

	public void addpro(String prolable, String language) {
		selenium.click("!!!menu.project.element!!!");
		selenium.setSpeed("2000");
		selenium.click("idSubModuleAddButton");
		selenium.click("idLabelInput");
		selenium.type("idLabelInput", prolable);
		selenium.fireEvent("idLabelInput", "blur");
		if ("Java".equals(language) || "".equals(language)) {

		} else {
			selenium.click("idLanguageInput");
			selenium.keyPressNative("" + KeyEvent.VK_DOWN);
			selenium.keyUpNative("" + KeyEvent.VK_DOWN);
			selenium.keyPressNative("" + KeyEvent.VK_ENTER);
			selenium.keyUpNative("" + KeyEvent.VK_ENTER);
			selenium.fireEvent("idLanguageInput", "blur");
		}
		selenium.click("idFormSaveButton");
		selenium.setSpeed("3000");
		addProwithexistLable(prolable);

	}
	public void addProwithexistLable(String name){
		selenium.click("idSubModuleAddButton");
		selenium.click("idLabelInput");
		selenium.type("idLabelInput", name);
		selenium.fireEvent("idLabelInput", "blur");
		selenium.click("idFormSaveButton");
		selenium.setSpeed("3000");
		if(selenium.isElementPresent("//div[@class='ext-mb-icon  ext-mb-warning']")){
			assert true ;
			
		}
		else{
			assert false;
			
		}
		
	}
}
