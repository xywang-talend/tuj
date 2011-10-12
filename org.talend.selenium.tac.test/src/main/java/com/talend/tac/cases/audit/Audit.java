package com.talend.tac.cases.audit;

import static org.testng.Assert.assertTrue;

import com.talend.tac.cases.Login;


public class Audit extends Login {
	public void openAudit(){
		this.waitForElementPresent("!!!menu.audit.element!!!", WAIT_TIME);
		selenium.click("!!!menu.audit.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Audit']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-panel-header-text' and text()='Audits list']",
				WAIT_TIME);
		selenium.refresh();
		this.sleep(3000);
		this.waitForElementPresent("//button[text()='Audit DB Configuration']", WAIT_TIME);
		
	}
	public String getFormatedDbURL(String url){
		String fomatedUrl = url;
		if ("org/talend/tac/folder/h2database".equals(url)){
			System.out.println("before changing");
			fomatedUrl = "jdbc:h2:"+this.parseRelativePath(url)+"/talend_administrator;AUTO_SERVER=TRUE;MVCC=TRUE";
			System.out.println(fomatedUrl);

		}else{
			fomatedUrl = "jdbc:h2:"+(url)+"/talend_administrator;AUTO_SERVER=TRUE;MVCC=TRUE";
		}
		return fomatedUrl;
	}
	public void configAuditDB(String url, String userName, String driver, String userPassWd){
		this.clickWaitForElementPresent("//button[text()='Audit DB Configuration']");
		this.waitForElementPresent("//span[@class='x-fieldset-header-text' and text()='Database parameters']", WAIT_TIME);
		this.waitForElementPresent("//span[@class='x-fieldset-header-text' and text()='Database parameters']//ancestor::fieldset[@class=' x-fieldset x-component']", WAIT_TIME);
		this.waitForElementPresent("//span[@class='x-fieldset-header-text' and text()='Check']//ancestor::fieldset[@class=' x-fieldset x-component']", WAIT_TIME);
		selenium.setSpeed(MID_SPEED);
		selenium.type("idDbConfigUrlInput", url);
		selenium.type("idDbConfigUserNmeInput", userName);
		selenium.type("idDbConfigPasswordInput", userPassWd);
		selenium.type("idDbConfigDriverInput", driver);
	}
	
	public void waitForCheckConnectionStatus(String locator, int OK_Num) {
		boolean flag = false;
		int seconds_Counter = 0;
		while (flag == false) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			flag = selenium.getXpathCount("//td[@align='LEFT']/div").intValue()==5;
			flag = selenium.getXpathCount(locator).intValue() >= OK_Num;
			seconds_Counter++;
			if(seconds_Counter >= WAIT_TIME)
				assertTrue(selenium.getXpathCount("//div[text()='OK']").intValue() >= OK_Num);
		}

	}
	
	/**
	 * test audit process, projectName is the name of project,branches: we can define it as "trunk" or "branch"
	 * @param projectName
	 * @param branches
	 */
	public void auditProcess(String projectName,String branches){
		this.clickWaitForElementPresent("!!!menu.audit.element!!!");
		//project
		this.clickWaitForElementPresent("//label[text()='Project:']/following-sibling::div//table//div//div");
		this.waitForElementPresent("//div[@role='listitem' and text()='"+projectName+"']",WAIT_TIME+70);
		selenium.mouseDown("//div[@role='listitem' and text()='"+projectName+"']");
		//branches
		this.clickWaitForElementPresent("//label[text()='Branch:']/following-sibling::div//div/div");
		this.waitForElementPresent("//div[@role='listitem' and contains(text(),'"+branches+"')][1]", WAIT_TIME);
		selenium.mouseDown("//div[@role='listitem' and contains(text(),'"+branches+"')][1]");
		//start
		this.waitForElementPresent("//button[text()='Start audit']",WAIT_TIME);
		selenium.click("//button[text()='Start audit']");
	
	}
	
	public boolean checkAuditInfo(String projectName){
		
	boolean ok = false;
	ok = this.waitForTextPresent("The Audit process has terminated successfully", MAX_WAIT_TIME);
	if(this.waitForTextPresent("The Audit process has terminated with error(s)", WAIT_TIME)){
		 ok = false;
	 }
	return ok;
	
	}
	public int checkAuditListLink(String projectName){
		
		int linksNum = this.selenium.getXpathCount("//a[contains(text(),'Audit for project "+'"'+projectName.toUpperCase()+'"'+" created at')]").intValue();
		return linksNum;
	}
	public void changeCommandLineConfig(String hostAddress) {
		System.err.println(hostAddress);
		selenium.refresh();
		selenium.setSpeed("1000");
		this.clickWaitForElementPresent("idMenuConfigElement");//into Configuration page
		this.waitForElementPresent("//div[contains(text(),'Command line/primary')]", WAIT_TIME);
		selenium.mouseDown("//div[contains(text(),'Command line/primary')]");
		this.clickWaitForElementPresent("//div[contains(text(),'Command line/primary')]//ancestor::div[@class='x-grid-group ']" +
				"//div[text()='Host']//ancestor::tr[@role='presentation']//img[@title='Click to edit']");
		this.waitForElementPresent("//div[@class=' x-form-field-wrap  x-component']//input", WAIT_TIME); 
		System.out.println("*--------------*");
		this.typeString("//div[contains(text(),' Command line/primary (')]/ancestor::div[@class='x-grid3-body']/following-sibling::div/div/input",hostAddress);
		selenium.setSpeed(MIN_SPEED);
	}
}
