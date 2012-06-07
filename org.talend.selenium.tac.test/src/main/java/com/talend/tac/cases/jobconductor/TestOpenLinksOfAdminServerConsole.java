package com.talend.tac.cases.jobconductor;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import junit.framework.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestOpenLinksOfAdminServerConsole extends Server {
   
	//open links of admin console
	@Test
	@Parameters({"ServerLablename"})
	public void testOpenLinksOfAdminServerConsole(String esbServer) {
		
		String karafPageTitleExpected = "Apache Karaf Web Console - Bundles";
		
		//into server page 
		this.openServerMenu();
		
		//open 'Admin Server' 
		this.waitForElementPresent("//div[text()='"+esbServer+"']//ancestor::table[contains(@class," +
				"'x-grid3-row-table')]//button[text()='Admin server']", WAIT_TIME);
		selenium.click("//div[text()='"+esbServer+"']//ancestor::table[contains(@class," +
				"'x-grid3-row-table')]//button[text()='Admin server']");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//login 'Admin Server'
		selenium.setSpeed(MID_SPEED);		
		this.genenateUserPw();
		selenium.keyPressNative(""+KeyEvent.VK_ENTER);
		selenium.keyPressNative("9");
		this.genenateUserPw();
		selenium.keyPressNative(""+KeyEvent.VK_ENTER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String[] idss = selenium.getAllWindowTitles();
		for(String id : idss) {
			if(id.startsWith("Apache")) {
				selenium.windowFocus();
			}			
			System.out.println("=" + id);
		}
		System.out.println(idss[1]);		
		Assert.assertEquals(karafPageTitleExpected, idss[1]);
		uploadLicense("org/talend/tac/folder/license/ESB_EE.license");
		this.waitForElementPresent("idLeftMenuTreeLogoutButton", WAIT_TIME);
	}
	
	public void genenateUserPw() {
		
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_K);
			r.keyRelease(KeyEvent.VK_K);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_A);
			r.keyPress(KeyEvent.VK_R);
			r.keyRelease(KeyEvent.VK_R);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_A);
			r.keyPress(KeyEvent.VK_F);
			r.keyRelease(KeyEvent.VK_F);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}
	
	public void uploadLicense(String license) {
		
		   this.waitForElementPresent("//b[text()='admin, admin']", WAIT_TIME);
		   			
		   this.clickWaitForElementPresent("idMenuLicenseElement");
		   waitForElementPresent("//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]", WAIT_TIME);
		   selenium.type("//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]", parseRelativePath(license));
		   selenium.click("//button[text()='Upload']");
				
	       System.out.println("license upload is successful");	
	       
	       try {
			Thread.sleep(3000);
		   } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		   }
	       selenium.refresh();        
	       
		}	
	
}
