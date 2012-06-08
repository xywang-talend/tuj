package com.talend.tac.cases.projects;

import java.awt.event.KeyEvent;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;

public class TestCheckConnection extends Projects{

	@Test
	@Parameters({"svnProjecturl", "wrongSVNProjectUrl", "svnuserName", "svnuserPassword","proLanguage"})
	public void testCheckconnection(String rightUrl,String wrongUrl,String user, String password,String language) throws Exception {
	
//		selenium.setSpeed("5000");
		this.waitForElementPresent("!!!menu.project.element!!!", Base.WAIT_TIME);
		String proname = "namepro";
		selenium.click("!!!menu.project.element!!!");
		selenium.click("idSubModuleAddButton");
		this.typeString("idLabelInput", proname);
		if ("Java".equals(language) || "".equals(language)) {

		} else {
			
			selenium.click("idLanguageInput");
			selenium.mouseDownAt("//div[@role='listitem'][2]",""+KeyEvent.VK_ENTER);
		}
		this.typeString("idDescriptionInput", "description");
		selenium.click("idAdvanceInput");
		this.typeString("idUrlInput", wrongUrl);
		this.typeString("idLoginInput", user);
		this.typeString("idPasswordInput", password);
		selenium.click("idSvnCommitInput");
		selenium.keyPressNative("" + KeyEvent.VK_ENTER);
		selenium.keyUpNative("" + KeyEvent.VK_ENTER);
		selenium.click("idSvnLockInput");
		selenium.keyPressNative("" + KeyEvent.VK_ENTER);
		selenium.keyUpNative("" + KeyEvent.VK_ENTER);
		selenium.click("idSvnUserLogInput");
		selenium.click("idCheckUrlButton");
		selenium.setSpeed(MID_SPEED);
		if(selenium.isElementPresent("//div[@class='ext-mb-icon  ext-mb-warning']")){//check connection fail,click ok button
			assert true;
			selenium.click("//button[@class='x-btn-text ' and (text()='"+other.getString("add.project.checkconnection.fail")+"')]");
		}
		else{
			assert false :"The check connection with wrong url failed !";
		    selenium.click("//button[text()='"+other.getString("add.project.checkconnection.ok")+"']");
		}
		selenium.setSpeed(MIN_SPEED);
		selenium.type("idUrlInput", rightUrl);// svn project url
		selenium.fireEvent("idUrlInput", "blur");
		selenium.click("idCheckUrlButton");
		selenium.setSpeed(MID_SPEED);
		if(selenium.isElementPresent("//div[@class='ext-mb-icon  ext-mb-info']")){
			assert true;
			selenium.click("//button[text()='"+other.getString("add.project.checkconnection.ok")+"']");
			
		}
		else{
			assert false:"The check connection with right url failed !";;
			selenium.click("//button[@class='x-btn-text ' and (text()='"+other.getString("add.project.checkconnection.fail")+"')]");
		}
	selenium.setSpeed(MIN_SPEED);
	}
}
