package com.talend.tac.cases.dbConfig;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import com.talend.tac.base.Base;
import static org.testng.Assert.*;

public class DbConfig extends Base {

	/**
	 * the process of dbConfig(input url,userName,userPasswd,driver, then check
	 * it.)
	 * 
	 * @param url
	 * @param userName
	 * @param userPassWd
	 * @param driver
	 */
	public void DbConfigProcess(String url, String userName, String userPassWd,
			String driver) {
		selenium.windowMaximize();
		waitForPageReactivity();// wait and judge: if no license set,tac will load directly to dbConfig page
		if (selenium.isElementPresent("idDbConfigLoginPasswordInput")) {
		} else {
			waitForElementPresent("idLoginOpenDbConfigButton", WAIT_TIME);
			selenium.click("idLoginOpenDbConfigButton");
		}
		this.waitForElementPresent("idDbConfigLoginPasswordInput", WAIT_TIME);
		selenium.type("idDbConfigLoginPasswordInput", "admin");
		selenium.click("idDbConfigSubmitButton");
		selenium.type("idDbConfigUrlInput", getFormatedDbURL(url));
		selenium.type("idDbConfigUserNmeInput", userName);
		selenium.type("idDbConfigPasswordInput", userPassWd);
		selenium.type("idDbConfigDriverInput", driver);
		selenium.click("idDbConfigCheckButton");
		// some other action like "save" ......
	}

	/**
	 * The first time to open TAC ,there may be a delay. wait and judge this two
	 * condition: 
	 * 1.No license ever set to the current db ,Tac will directly load to dbConfig page
	 * 2.If license has already been set, loginPage will be seen.
	 */
	public void waitForPageReactivity() {
		boolean flag = selenium.isElementPresent("idDbConfigLoginPasswordInput")
				|| selenium.isElementPresent("idLoginOpenDbConfigButton");
		while (flag == false) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			flag = selenium.isElementPresent("idDbConfigLoginPasswordInput")
					|| selenium.isElementPresent("idLoginOpenDbConfigButton");
		}
	}

	/**
	 * wait and check the db Connection status
	 */
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
			if(seconds_Counter >= WAIT_TIME*3)
				assertTrue(selenium.getXpathCount("//div[text()='OK']").intValue() >= OK_Num);
		}

	}
	
	/**
	 * This method mainly identify whether we use h2 database or not,
	 * this is because we want to define the local h2 db-file to a relative path(under our project)  
	 */
	public String getFormatedDbURL(String url){
		String fomatedUrl = url;
		if ("org/talend/tac/folder/h2database".equals(url)){
			System.out.println("before changing");
			fomatedUrl = "jdbc:h2:"+this.parseRelativePath(url)+"/talend_administrator;AUTO_SERVER=TRUE;MVCC=TRUE";
			System.out.println(fomatedUrl);

		}else{
//			System.out.println("The db is not h2,no need to transfer the relative path,it is as bellow .");
//			System.out.println(url);
			fomatedUrl = "jdbc:h2:"+(url)+"/talend_administrator;AUTO_SERVER=TRUE;MVCC=TRUE";
		}
		return fomatedUrl;
	}
	
	@AfterMethod
	public void killBroswer() {
		selenium.stop();
	}
}
