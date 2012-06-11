package com.talend.tac.cases.esb.serviceLocator;


import java.awt.Event;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.talend.tac.base.Karaf;
public class TestServiceLocator extends EsbUtil {	

		
	//test display service of 'live services only'/'all services'	
	@Test
	@Parameters({"license.esb.file.path", "jobFirstProvider", "jobSecondProvider",
		"jobThirdProvider", "jobFourthProvider", "jobFiveProvider", "jobSixProvider"})
	public void testDisplayAllService(String license, String jobFirstProvider, String jobSecondProvider,
			String jobThirdProvider, String jobFourthProvider, String jobFiveProvider,String jobSixthProvider) {	
		
		uploadLicense(license);
		
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
		//click 'Refresh' button
		selenium.click("//b[text()='Refresh']");
		//verify service start success
		assertStartService(jobFirstProvider);
		assertStartService(jobSecondProvider);
		assertStartService(jobFourthProvider);
		assertStartService(jobFiveProvider);
		assertStartService(jobSixthProvider);
		assertStartService(jobThirdProvider);
		
	    
	}
	
	//test check 'live services only', check display whether only dispaly live services
	@Test
	@Parameters({"jobFirstProvider", "jobSecondProvider",
		"jobThirdProvider", "jobFourthProvider", "jobFiveProvider", "jobSixProvider"})
	public void testDisplayLiveServicesOnly(String jobFirstProvider, String jobSecondProvider,
			String jobThirdProvider, String jobFourthProvider, String jobFiveProvider,String jobSixthProvider) {
		
//		//stop service	
		uninstallService(jobFiveProvider);
		uninstallService(jobSixthProvider);
		
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");

		//click 'Refresh' button
		selenium.click("//b[text()='Refresh']");
		
		assertStopService(jobFiveProvider);
		assertStopService(jobSixthProvider);
		
		//just only display live service 
		selenium.click("//label[text()='live services only']//preceding-sibling::input");		
		
		//just only display live service 
		assertStartService(jobFirstProvider);	
		assertStartService(jobSecondProvider);
		assertStartService(jobFourthProvider);
		assertStartService(jobThirdProvider);		
		Assert.assertFalse(selenium.isElementPresent("//div[contains(text(),'"+jobFiveProvider+"')]"));
		Assert.assertFalse(selenium.isElementPresent("//div[contains(text(),'"+jobSixthProvider+"')]"));
		
	}
    
	//stop all services, check info of click 'all services' page
//	@Test
//	@Parameters({"jobFirstProvider", "jobSecondProvider", "jobThirdProvider"})
//	public void testDisplayLiveServicesOnlyAfterStopAllServices(String jobFirstProvider,
//			String jobSecondProvider, String jobThirdProvider) {
//
//		//stop all jobs	
//		stopService(jobThirdProvider);
//		
//		//go to 'ServiceLocator' page
//		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
//		
//		//click 'Refresh' button
//		selenium.click("//b[text()='Refresh']");
//		
//		//stop job
//		assertStopService(jobFirstProvider);
//		assertStopService(jobSecondProvider);
//		assertStopService(jobThirdProvider);
//		
//		//just only display live service 
//		selenium.click("//label[text()='live services only']//preceding-sibling::input");
//		
//		//verify display result
//		this.waitForTextPresent("There are no services available. Please check your filter and click" +
//				" refresh button to retry.", WAIT_TIME);
//		
//		
//	}
	
	//check service value display whether normal per columns
	@Test
	@Parameters({"jobFiveProvider"})
	public void testServicePerColumnsValue(String jobFiveProvider) {
		
		String xpathOfFirstProviderServiceEndpoint = "//table[@class='x-grid3-row-table']//div[text()='http://localhost:8040/services/"+jobFiveProvider+"']";
		String xpathOfFirstProviderServiceUptime = "//div[contains(text(),'"+jobFiveProvider+"')]//ancestor::div[contains(@class,'x-grid-group')]" +
				"//span[contains(text(),'Last seen')]";
		String xpathOfFirstProviderServiceHttp = "//div[text()='http://localhost:8040/services/"+jobFiveProvider+"']//ancestor::table[@class='x-grid3-row-table']" +
				"//td[1]//img[@class='gwt-Image x-component']";
		String xpathOfFirstProviderServiceSOAP11 = "//div[text()='http://localhost:8040/services/"+jobFiveProvider+"']//ancestor::table[@class='x-grid3-row-table']" +
		"//td[2]//img[@class='gwt-Image x-component']";
		String xpathOfFirstProviderServiceNameSpace = "//div[text()='http://localhost:8040/services/"+jobFiveProvider+"']//ancestor::table[@class='x-grid3-row-table']" +
				"//div[text()='http://www.talend.org/service/']";
		
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
		
		Assert.assertTrue(selenium.isElementPresent(xpathOfFirstProviderServiceEndpoint));
		Assert.assertTrue(selenium.isElementPresent(xpathOfFirstProviderServiceUptime));
		Assert.assertTrue(selenium.isElementPresent(xpathOfFirstProviderServiceHttp));
		Assert.assertTrue(selenium.isElementPresent(xpathOfFirstProviderServiceSOAP11));
		Assert.assertTrue(selenium.isElementPresent(xpathOfFirstProviderServiceNameSpace));		
				
	}
	
	//check refresh button is well work
	@Test
	@Parameters({"jobFirstProvider", "jobSecondProvider",
		"jobThirdProvider", "jobFourthProvider", "jobFiveProvider", "jobSixProvider"})
	public void testCheckRefresh(String jobFirstProvider, String jobSecondProvider,
			String jobThirdProvider, String jobFourthProvider, String jobFiveProvider,String jobSixthProvider) {
		
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
		
		//verify status of all services
		assertStartService(jobFirstProvider);	
		assertStartService(jobSecondProvider);
		assertStartService(jobFourthProvider);
		assertStartService(jobThirdProvider);		
		assertStopService(jobFiveProvider);
		assertStopService(jobSixthProvider);
		
		uninstallService(jobFourthProvider);
		
		//click 'Refresh' button
		selenium.click("//b[text()='Refresh']");
		/*check the well refresh
		  change service status is successful */
		assertStartService(jobFirstProvider);	
		assertStartService(jobSecondProvider);
		assertStopService(jobFourthProvider);
		assertStartService(jobThirdProvider);		
		assertStopService(jobFiveProvider);
		assertStopService(jobSixthProvider);
		
	}
	
	//check display service cancel groups
	@Test
	public void testDisplayServiceNotWithGroups() {
		
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
				
		this.clickWaitForElementPresent("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-endpoint')]/a");		
		selenium.setSpeed(MID_SPEED);
		selenium.click("//a[text()='Show in Groups']");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isElementPresent("//div[@class='x-grid-group-div']"));
		selenium.setSpeed(MIN_SPEED);
		
	}
	
	//check services display order of per columns sort ascending and sort descending
	@Test
	@Parameters({"jobFirstProvider", "jobSecondProvider",
		"jobThirdProvider", "jobFourthProvider", "jobFiveProvider", "jobSixProvider"})
	public void testCheckSortAscendingSortDescending(String jobFirstProvider, String jobSecondProvider,
			String jobThirdProvider, String jobFourthProvider, String jobFiveProvider,String jobSixthProvider) {		

		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
				
		this.clickWaitForElementPresent("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-endpoint')]/a");		
		selenium.setSpeed(MID_SPEED);
		selenium.click("//a[text()='Show in Groups']");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isElementPresent("//div[@class='x-grid-group-div']"));
		selenium.setSpeed(MIN_SPEED);
		
		checkSortAscendingSortDescending("name", jobThirdProvider, jobFirstProvider);
		checkSortAscendingSortDescending("endpoint", "http://localhost:8040/services/soap/jobSixedProvider/",
				"http://localhost:8040/services/jobFirstProvider");
		
	}
	
	//group service display
	@Test
	@Parameters({"jobFirstProvider", "jobSecondProvider",
		"jobThirdProvider", "jobFourthProvider", "jobFiveProvider", "jobSixProvider"})
	public void testGroupDisplayService(String jobFirstProvider, String jobSecondProvider,
			String jobThirdProvider, String jobFourthProvider, String jobFiveProvider,String jobSixthProvider) {		

		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
			
		changeGroupDisplayService("endpoint", "name", "jobFirstProvider");
		changeGroupDisplayService("endpoint", "isAlive", "false");	
		changeGroupDisplayService("name", "endpoint", "http://localhost:8040/services/jobFirstProvider");
		changeGroupDisplayService("name", "transport_protocol", "http://www.talend.org/service/");
		
		this.clickWaitForElementPresent("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-endpoint')]/a");		
		selenium.setSpeed(MID_SPEED);
		selenium.click("//a[text()='Show in Groups']");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isElementPresent("//div[@class='x-grid-group-div']"));
		selenium.setSpeed(MIN_SPEED);
		
	}
	
	//hide service display service
	@Test
	@Parameters({"jobFirstProvider", "jobSecondProvider",
		"jobThirdProvider", "jobFourthProvider", "jobFiveProvider", "jobSixProvider"})
	public void testHiddenDisplayService(String jobFirstProvider, String jobSecondProvider,
			String jobThirdProvider, String jobFourthProvider, String jobFiveProvider,String jobSixthProvider) {
		
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
		
		hiddenDisplayServices("http://localhost:8040/services/services/jobFirstProvider", jobFirstProvider);
		hiddenDisplayServices("http://localhost:8040/services/services/jobFirstProvider", jobFirstProvider);
		
	}
	
	//modify the services display columns
	@Test
    public void testModifyDisplayServicesColumns() {
		
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
		this.clickWaitForElementPresent("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-endpoint')]/a");

		selenium.setSpeed(MID_SPEED);
		selenium.mouseOver("//a[text()='Columns']");
	    selenium.setSpeed(MIN_SPEED);
		modifyDisplayServicesColumns("Status");		
		modifyDisplayServicesColumns("Service Endpoint");		
        
		modifyDisplayServicesColumns("Status");		
		modifyDisplayServicesColumns("Service Endpoint");
        selenium.setSpeed(MID_SPEED);
		selenium.click("//a[text()='Sort Ascending']/img[@class=' x-menu-item-icon']");
		selenium.setSpeed(MIN_SPEED);
	}
    
	//test sort table by click on column header
	@Test
	@Parameters({"jobFirstProvider", "jobSecondProvider",
		"jobThirdProvider", "jobFourthProvider", "jobFiveProvider", "jobSixProvider"})
	public void testSortTableByClickOnColumnHeader(String jobFirstProvider, String jobSecondProvider,
			String jobThirdProvider, String jobFourthProvider, String jobFiveProvider,String jobSixthProvider) {		

		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
				
		this.clickWaitForElementPresent("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-endpoint')]/a");		
		selenium.setSpeed(MID_SPEED);
		selenium.click("//a[text()='Show in Groups']");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isElementPresent("//div[@class='x-grid-group-div']"));
		selenium.setSpeed(MIN_SPEED);
		
		checkSortAscendingSortDescending("name", jobThirdProvider, jobFirstProvider);
		checkSortAscendingSortDescending("endpoint", "http://localhost:8040/services/soap/jobSixedProvider/",
				"http://localhost:8040/services/jobFirstProvider");
		
	}
	
//	//Stop and restart a service connected to Service Locator and check correct status display in server table
//	@Test
//	@Parameters({"provider.file.path.jobFourthProvider", "jobFourthProvider"})
//	public void testCheckServiceLocationPageStopServiceAndRestart(String jobFourthPrividerFilePath, 
//			String jobFourthProvider) {
//		 
//		//go to 'ServiceLocator' page
//		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
//		
//		installStratService(jobFourthPrividerFilePath, jobFourthProvider);		
//		//click 'Refresh' button
//		selenium.click("//b[text()='Refresh']");		
//		//start job
//		assertStartService(jobFourthProvider);
//		Assert.assertFalse(selenium.isElementPresent("//div[text()='http://127.0.0.1:9996/esb/provider']" +
//				"//ancestor::table[@class='x-grid3-row-table']//span[@style='color: red;']"));
//		
//		stopService("jobFourthProvider");
//		//click 'Refresh' button
//		selenium.click("//b[text()='Refresh']");		
//		//stop job
//		assertStopService(jobFourthProvider);
//		Assert.assertTrue(selenium.isElementPresent("//div[text()='http://127.0.0.1:9996/esb/provider']" +
//				"//ancestor::table[@class='x-grid3-row-table']//span[@style='color: red;']"));
//		
//		installStratService(jobFourthPrividerFilePath, jobFourthProvider);		
//		//click 'Refresh' button
//		selenium.click("//b[text()='Refresh']");		
//		//start job
//		assertStartService(jobFourthProvider);
//		Assert.assertFalse(selenium.isElementPresent("//div[text()='http://127.0.0.1:9996/esb/provider']" +
//				"//ancestor::table[@class='x-grid3-row-table']//span[@style='color: red;']"));
//		
//	}	
	
	//stop zkserver, check status info of configuration page and serviceLocation page  
	@Test
	@Parameters({"esbConfZookeeperServer", "esbConfZookeeperServerStop","jobFirstProvider", "jobSecondProvider",
		"jobThirdProvider", "jobFourthProvider", "jobFiveProvider", "jobSixProvider"})
	public void testStopStartZkServerCheckPageStatus(String zookeeperServer, String zookeeperServerWithWrong, String jobFirstProvider, String jobSecondProvider,
			String jobThirdProvider, String jobFourthProvider, String jobFiveProvider,String jobSixthProvider) {
		
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
		//click 'Refresh' button
		selenium.click("//b[text()='Refresh']");
		//verify service start success
		assertStartService(jobFirstProvider);
		assertStartService(jobSecondProvider);
		assertStopService(jobFourthProvider);
		assertStartService(jobThirdProvider);		
		assertStopService(jobFiveProvider);
		assertStopService(jobSixthProvider);
		
		modifyEsbConfigurationInConfigurationPage(zookeeperServerWithWrong, other.getString("esb.conf.StopZookeeperServerStatusIconLocator"));
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
		selenium.click("//b[text()='Refresh']");		
		this.waitForElementPresent("//div[contains(text(),'Can not get a list of services from Service Locator')]", WAIT_TIME);
	  	Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Zookeeper for this url is unavailable')]"));
	  	selenium.setSpeed(MIN_SPEED);
		
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
		//click 'Refresh' button
		selenium.click("//b[text()='Refresh']");
		//verify display result
		this.waitForTextPresent("There are no services available. Please check your filter and click" +
				" refresh button to retry.", WAIT_TIME);		
		modifyEsbConfigurationInConfigurationPage(zookeeperServer, other.getString("esb.conf.ZookeeperServerStatusIconLocator"));
		  	
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
		//click 'Refresh' button
		selenium.click("//b[text()='Refresh']");
		
		selenium.setSpeed(MAX_SPEED);
		//verify service start success
		assertStartService(jobFirstProvider);
		selenium.setSpeed(MIN_SPEED);
		assertStartService(jobSecondProvider);
		assertStopService(jobFourthProvider);
		assertStartService(jobThirdProvider);		
		assertStopService(jobFiveProvider);
		assertStopService(jobSixthProvider);
		
	}
	
	//set sam-server url in configuration
    @Test
    @Parameters ({"esbConfServiceActivityMonitorServer", "esbConfServiceActivityMonitorServer"})
	public void testSetESBSamServer(String remoteMonitorServer, String localServer){
    	
	   //go to configuration page 
	   this.clickWaitForElementPresent("idMenuConfigElement");
	   
	   this.waitForElementPresent("//div[@class='header-title' and text()='Configuration']", WAIT_TIME);
	   if(selenium.isElementPresent("//button[@class='x-btn-text' and @aria-pressed='true']")) {
			
			 selenium.click("//div[text()='Configuration' and @class='header-title']"+
			"//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct')]"+
			"//button[@class='x-btn-text' and @aria-pressed='true']");
			 this.waitForElementPresent("//div[text()='Configuration' and @class='header-title']"+
					"//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct')]"+
					"//button[@class='x-btn-text' and @aria-pressed='false']", WAIT_TIME);
			
		  }	  
	   this.mouseDownWaitForElementPresent("//div[contains(text(),'ESB (')]");	   
	   modifySAMServer(remoteMonitorServer, other.getString("esb.conf.ServiceActivityMonitorServerStatusIconLocator"));
	   
	   modifySAMServer(localServer, other.getString("esb.conf.ServiceActivityMonitorServerStatusIconLocator"));
	   
	}
	
  //set sam-server url with wrong in configuration
    @Test
    @Parameters ({"esbConfServiceActivityMonitorServerStop", "esbConfServiceActivityMonitorServer"})
	public void testSetESBSamServerWithWrongUrl(String remoteMonitorServerWithWrongUrl, String localServer){	   
    	
	   //go to configuration page 
	   this.clickWaitForElementPresent("idMenuConfigElement");
	   
	   this.waitForElementPresent("//div[@class='header-title' and text()='Configuration']", WAIT_TIME);
	   if(selenium.isElementPresent("//button[@class='x-btn-text' and @aria-pressed='true']")) {
			
			 selenium.click("//div[text()='Configuration' and @class='header-title']"+
			"//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct')]"+
			"//button[@class='x-btn-text' and @aria-pressed='true']");
			 this.waitForElementPresent("//div[text()='Configuration' and @class='header-title']"+
					"//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct')]"+
					"//button[@class='x-btn-text' and @aria-pressed='false']", WAIT_TIME);
			
		  }
		  
	   this.mouseDownWaitForElementPresent("//div[contains(text(),'ESB (')]");

	   modifySAMServer(remoteMonitorServerWithWrongUrl, other.getString("esb.conf.ServiceActivityMonitorServerStatusIconLocator.wrongURL"));
	   
	   this.waitForElementPresent("//div[contains(text(),'SAM Server for this url is unavailable')]", WAIT_TIME);
	   Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'SAM Server for this url is unavailable')]"));
	   selenium.setSpeed(MIN_SPEED);
	   selenium.click("//button[@id='idConfigRefreshButton']");
	   modifySAMServer(localServer, other.getString("esb.conf.ServiceActivityMonitorServerStatusIconLocator"));
	   
	}
    
    @Test
    public void testFilterServiceLocator() {
    	this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");//into SL page
		this.clickWaitForElementPresent("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-endpoint')]/a");
		selenium.setSpeed(MID_SPEED);
		selenium.click("//a[text()='Show in Groups']");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isElementPresent("//div[@class='x-grid-group-div']"));
		selenium.setSpeed(MIN_SPEED);
		this.clickWaitForElementPresent("//div[@class=' x-grid3-hd-inner x-grid3-hd-name x-component sort-asc ']/a");
		selenium.mouseOver("//a[text()='Filters']");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		selenium.click("//div[@class='x-menu-list-item x-menu-list-item-indent']");
		this.waitElement("//div[contains(@class,'x-menu-list-item x-menu-list-item-indent')]//input[contains(@class,'x-form-text x-form-empty-field')] ", WAIT_TIME);
		selenium.click("//div[contains(@class,'x-menu-list-item x-menu-list-item-indent')]//input[contains(@class,'x-form-text x-form-empty-field')] ");
		selenium.setSpeed(MID_SPEED);
		this.waitForElementPresent("//div[contains(@class,'x-menu-list-item x-menu-list-item-indent')]//input[contains(@class,'x-form-text x-form-focus')]", WAIT_TIME);
        selenium.type("//div[contains(@class,'x-menu-list-item x-menu-list-item-indent')]//input[contains(@class,'x-form-text x-form-focus')]", "F");
        selenium.keyDownNative(""+Event.ENTER);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String lastPage=selenium.getText("//div[text()='Page']//ancestor::td[contains(@class,'x-toolbar-cell')]//following-sibling::td[2]/div[contains(@class,'my-paging-text x-component')]");
		String totalPage=lastPage.substring(lastPage.indexOf(" ")+1);
		this.waitForElementPresent("//div[contains(@class,'my-paging-display x-component')]", WAIT_TIME);
		String serviceDesc=selenium.getText("//div[contains(@class,'my-paging-display x-component')]");
		String totalService=serviceDesc.substring(serviceDesc.indexOf("of")+2);
		System.out.println("-----------totalPage"+totalPage);
		System.out.println("-----------totalService"+totalService);
		Assert.assertTrue(totalPage.equals("1"));		
		Assert.assertTrue(totalService.trim().equals("3"));
    }
    
    @Test
    @Parameters({"karafUrl","providerName"})
    public void testUptimeOfService(String KarafURL,String ProviderName) {
    	Karaf karaf=new Karaf(KarafURL);
    	karaf.karafAction("stop "+ProviderName+"-control-bundle", WAIT_TIME);  //stop service
    	this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");  //into SL page
		selenium.setSpeed(MID_SPEED);
		this.waitForElementPresent("//div[text()='jobFirstProvider']//ancestor::div[@class='x-grid-group-hd']//following-sibling::div[1]//div[@class='x-grid3-cell-inner x-grid3-col-upTime']", WAIT_TIME);
		String uptime_before=selenium.getText("//div[text()='jobFirstProvider']//ancestor::div[@class='x-grid-group-hd']//following-sibling::div[1]//div[@class='x-grid3-cell-inner x-grid3-col-upTime']");
		Assert.assertTrue(uptime_before.equals("Last seen less than 1 min ago"));		
    	karaf.karafAction("start "+ProviderName+"-control-bundle", WAIT_TIME);  //start service
    	selenium.click("//b[text()='Refresh']");
		String uptime_after=selenium.getText("//div[text()='jobFirstProvider']//ancestor::div[@class='x-grid-group-hd']//following-sibling::div[1]//div[@class='x-grid3-cell-inner x-grid3-col-upTime']");
        System.out.println("---------uptime_after:"+uptime_after);
		Assert.assertTrue(uptime_after.equals("less than 1 min"));
    }
    
    @Test
    @Parameters({})
    public void testDeleteUnavaiableService() {
    	this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");  //into SL page
    	selenium.setSpeed(MID_SPEED);
    	this.waitForElementPresent("//div[text()='http://localhost:8040/services/jobFourthProvider' and @class='x-grid3-cell-inner x-grid3-col-endpoint']", WAIT_TIME);
    	selenium.mouseDown("//div[text()='http://localhost:8040/services/jobFourthProvider' and @class='x-grid3-cell-inner x-grid3-col-endpoint']");
    	this.waitForElementPresent("//span[text()='Metadata']", WAIT_TIME);
    	selenium.click("//span[text()='Metadata']");
    	this.waitForElementPresent("//span[text()='Metadata']//ancestor::div[@class=' x-tab-panel x-component']//following-sibling::div[@class=' x-component']//table//button[text()='Delete']", WAIT_TIME);
    	selenium.chooseOkOnNextConfirmation();
    	selenium.click("//span[text()='Metadata']//ancestor::div[@class=' x-tab-panel x-component']//following-sibling::div[@class=' x-component']//table//button[text()='Delete']");
        selenium.click("//button[text()='Yes']");
    	this.waitForElementDispear("//div[text()='http://localhost:8040/services/jobFourthProvider' and @class='x-grid3-cell-inner x-grid3-col-endpoint']", WAIT_TIME);
    }
}
