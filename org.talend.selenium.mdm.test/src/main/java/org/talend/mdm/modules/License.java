package org.talend.mdm.modules;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.Base;


public class License extends Base{
	
	public License(WebDriver driver) {
		super.setDriver(driver);
		this.driver = driver;
	}

	
	
	/****
	 * click menu license to jump to license page
	 */
	protected void gotoLicensePage(){
		this.logger.info("go to license page");
		this.clickElementByXpath(locator.getString("xpath.Administration.menu"));
		this.clickElementByXpath("//span[text()='License']");
		Assert.assertTrue("Go to License page", this.isElementPresent(By.xpath(locator.getString("xpath.license.edit")), this.WAIT_TIME_MAX));
		this.logger.info("go to license page ok");
	}
	
	protected void uploadLicense(){
		
	}
	protected String getUsersAllowedCountAdmin(){
		this.clickElementByXpath(locator.getString("xpath.license.refresh.button"));
		this.waitforElementDisplayed(By.id(locator.getString("id.license.input.admincount")), WAIT_TIME_MAX);
	    return this.getValue(this.getElementById((locator.getString("id.license.input.admincount"))));
	}
	
	protected String getUsersExistCountAdmin(){
		this.clickElementByXpath(locator.getString("xpath.license.refresh.button"));
		this.waitforElementDisplayed(By.xpath(locator.getString("xpath.license.existadmin.user.count.text")), WAIT_TIME_MAX);
	    return this.getValue(this.getElementByXpath((locator.getString("xpath.license.existadmin.user.count.text"))));
	}
	
	protected String getUsersAllowedCountWeb(){
		this.clickElementByXpath(locator.getString("xpath.license.refresh.button"));
		this.waitforElementDisplayed(By.id(locator.getString("id.license.input.webuser")), WAIT_TIME_MAX);
	    return this.getValue(this.getElementById((locator.getString("id.license.input.webuser"))));
	}
	
	protected String getUsersExistCountWeb(){
		this.clickElementByXpath(locator.getString("xpath.license.refresh.button"));
		this.waitforElementDisplayed(By.xpath(locator.getString("xpath.license.existweb.user.count.text")), WAIT_TIME_MAX);
	    return this.getValue(this.getElementByXpath((locator.getString("xpath.license.existweb.user.count.text"))));
	}
	
	protected String getUsersAllowedCountInteractive(){
		this.clickElementByXpath(locator.getString("xpath.license.refresh.button"));
		this.waitforElementDisplayed(By.id(locator.getString("id.license.input.interactiveuser")), WAIT_TIME_MAX);
	    return this.getValue(this.getElementById((locator.getString("id.license.input.interactiveuser"))));
	}
	
	protected String getUsersExistCountInteractive(){
		this.clickElementByXpath(locator.getString("xpath.license.refresh.button"));
		this.waitforElementDisplayed(By.xpath(locator.getString("xpath.license.existinteractive.user.count.text")), WAIT_TIME_MAX);
	    return this.getValue(this.getElementByXpath((locator.getString("xpath.license.existinteractive.user.count.text"))));
	}
	
	protected int transformExistUserNum(String str){
		System.err.println(str);
		String s=(str.substring(str.indexOf("/")-1, str.length()));
		return Integer.parseInt(s.split("/")[0]);
	}
	
	protected int transformTotalUserNum(String str){
		System.err.println(str);
		String s=(str.substring(str.indexOf("/")-1, str.length()));
		return Integer.parseInt(s.split("/")[1]);
	}
	
	public int getExistInteractive(){
		return (this.transformExistUserNum(this.getUsersExistCountInteractive()));
	}

	
	
	/****
	 * get already exist System_Admin users Num
	 * @return
	 */
	public int getExistAdmin(){
		return (this.transformExistUserNum(this.getUsersExistCountAdmin()));
	}

	
	/****
	 * get System_Admin user within license
	 * @return
	 */
	public int getAvailableAdmin(){
		return (this.transformTotalUserNum(this.getUsersExistCountAdmin())-this.transformExistUserNum(this.getUsersExistCountAdmin()));
	}
	
	
	/*****
	 * get System_Web user left within license
	 * @return
	 */
	public int getAvailableWeb(){
		return (this.transformTotalUserNum(this.getUsersExistCountWeb())-this.transformExistUserNum(this.getUsersExistCountWeb()));
	}
	
	
}