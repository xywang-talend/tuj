package com.talend.tac.cases.esb.serviceLocator;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestServiceLocator extends EsbUtil {
	
	@Test
	@Parameters({"license.esb.file.path","jobFirstProvider", "jobSecondProvider", 
		"jobThirdProvider", "jobFourthProvider", "jobFirstConsumer"})
	public void deleteAllService(String license,String jobFirstProvider,
			String jobSecondProvider, String jobThirdProvider, String jobFourthProvider
			, String jobFirstConsumer) {
			
		uploadLicense(license);
		
		uninstallService(jobFirstProvider);
		uninstallService(jobSecondProvider);
		uninstallService(jobThirdProvider);
		uninstallService(jobFourthProvider);
		uninstallService(jobFourthProvider); 
		uninstallService(jobFirstConsumer);
		
		stopService(jobFirstProvider);
		stopService(jobSecondProvider);
		stopService(jobThirdProvider);
		stopService(jobFourthProvider);
		stopService(jobFirstConsumer);
		
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
		//click 'Refresh' button
		selenium.click("//b[text()='Refresh']");
		
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;; i++) {
			
			selenium.setSpeed(MID_SPEED);
			if(selenium.isElementPresent("//div[contains(text(),'/esb/provider')]")) {
				
				selenium.setSpeed(MIN_SPEED);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				selenium.mouseDown("//div[contains(text(),'/esb/provider')]");
				selenium.setSpeed(MID_SPEED);
				selenium.click("//button[contains(text(),'Delete')]");
				Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Are you sure you want" +
						" to delete service information for')]"));
				selenium.setSpeed(MIN_SPEED);

				selenium.click("//button[text()='Yes']");
			} else {				
				
				break;
				
			}
			
		}
		
		selenium.setSpeed(MIN_SPEED);
		//verify display result
		this.waitForElementPresent("//div[text()='There are no services available." +
				" Please check your filter and click refresh button to retry.']", WAIT_TIME);
		
		
	}
	
	//test display service of 'live services only'/'all services'	
	@Test
	@Parameters({"provider.file.path.jobFirstProvider", "provider.file.path.jobSecondProvider",
		"provider.file.path.jobThirdProvider", "jobFirstProvider", "jobSecondProvider",
		"jobThirdProvider", "consumer.file.path.jobFirstConsumer"})
	public void testDisplayAllService(String jobFirstProviderFilePath, String jobSecondProviderFilePath,
			String jobThirdProviderFilePath, String jobFirstProvider, String jobSecondProvider,
			String jobThirdProvider, String jobFirstConsumerFilePath) {	
		
		
		//install all job and start
		startAllService(jobFirstProviderFilePath, jobFirstProvider, jobSecondProviderFilePath, 
				jobSecondProvider, jobThirdProviderFilePath, jobThirdProvider);
		
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
		//click 'Refresh' button
		selenium.click("//b[text()='Refresh']");
		//verify service start success
		assertStartService(jobFirstProvider);
		assertStartService(jobSecondProvider);
		assertStartService(jobThirdProvider);
		
		installService(jobFirstConsumerFilePath);
	    
	}
	
	//test check 'live services only', check display whether only dispaly live services
	@Test
	@Parameters({"jobFirstProvider", "jobSecondProvider", "jobThirdProvider"})
	public void testDisplayLiveServicesOnly(String jobFirstProvider, String jobSecondProvider,
			String jobThirdProvider) {
		
		//stop job	
		stopService(jobFirstProvider);
		stopService(jobSecondProvider);
		
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
		
		//just only display live service 
		selenium.click("//label[text()='live services only']//preceding-sibling::input");
		
		//click 'Refresh' button
		selenium.click("//b[text()='Refresh']");
		
		//just only display live service 
		assertStartService(jobThirdProvider);
		
	}
    
	//stop all services, check info of click 'all services' page
	@Test
	@Parameters({"jobFirstProvider", "jobSecondProvider", "jobThirdProvider"})
	public void testDisplayLiveServicesOnlyAfterStopAllServices(String jobFirstProvider,
			String jobSecondProvider, String jobThirdProvider) {

		//stop all jobs	
		stopService(jobThirdProvider);
		
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
		
		//click 'Refresh' button
		selenium.click("//b[text()='Refresh']");
		
		//stop job
		assertStopService(jobFirstProvider);
		assertStopService(jobSecondProvider);
		assertStopService(jobThirdProvider);
		
		//just only display live service 
		selenium.click("//label[text()='live services only']//preceding-sibling::input");
		
		//verify display result
		this.waitForTextPresent("There are no services available. Please check your filter and click" +
				" refresh button to retry.", WAIT_TIME);
		
		
	}
	
	//check service value display whether normal per columns
	@Test
	@Parameters({"jobFirstProvider"})
	public void testServicePerColumnsValue(String jobFirstProvider) {
		
		String xpathOfFirstProviderServiceEndpoint = "//table[@class='x-grid3-row-table']//div[text()='http://127.0.0.1:9999/esb/provider']";
		String xpathOfFirstProviderServiceUptime = "//div[contains(text(),'"+jobFirstProvider+"')]//ancestor::div[contains(@class,'x-grid-group')]" +
				"//span[contains(text(),'Last seen')]";
		String xpathOfFirstProviderServiceHttp = "//div[text()='http://127.0.0.1:9999/esb/provider']//ancestor::table[@class='x-grid3-row-table']" +
				"//td[1]//img[@class='gwt-Image x-component']";
		String xpathOfFirstProviderServiceSOAP11 = "//div[text()='http://127.0.0.1:9999/esb/provider']//ancestor::table[@class='x-grid3-row-table']" +
		"//td[2]//img[@class='gwt-Image x-component']";
		String xpathOfFirstProviderServiceNameSpace = "//div[text()='http://127.0.0.1:9999/esb/provider']//ancestor::table[@class='x-grid3-row-table']" +
				"//div[text()='http://talend.org/esb/service/job']";
		
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
	@Parameters({"jobFirstProvider", "jobSecondProvider", "jobThirdProvider", "provider.file.path.jobFirstProvider"})
	public void testCheckRefresh(String jobFirstProvider,
			String jobSecondProvider, String jobThirdProvider, String jobFirstProviderFilePath) {
		
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
		
		//verify status of all services
		assertStopService(jobFirstProvider);
		assertStopService(jobSecondProvider);
		assertStopService(jobThirdProvider);
		
		installStratService(jobFirstProviderFilePath, jobFirstProvider);
		
		//click 'Refresh' button
		selenium.click("//b[text()='Refresh']");
		/*check the well refresh
		  change service status is successful */
		assertStartService(jobFirstProvider);
		assertStopService(jobSecondProvider);
		assertStopService(jobThirdProvider);
		
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
	public void testCheckSortAscendingSortDescending() {		

		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
				
		this.clickWaitForElementPresent("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-endpoint')]/a");		
		selenium.setSpeed(MID_SPEED);
		selenium.click("//a[text()='Show in Groups']");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isElementPresent("//div[@class='x-grid-group-div']"));
		selenium.setSpeed(MIN_SPEED);
		
		checkSortAscendingSortDescending("name", "TEST_jobThirdProvider", "TEST_jobFirstProvider");
		checkSortAscendingSortDescending("endpoint", "http://127.0.0.1:9999/esb/provider",
				"http://127.0.0.1:9996/esb/provider");
		
	}
	
	//group service display
	@Test
	public void testGroupDisplayService() {		

		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
			
		changeGroupDisplayService("endpoint", "name", "TEST_jobFirstProvider");
		changeGroupDisplayService("endpoint", "isActive", "false");	
		changeGroupDisplayService("name", "endpoint", "http://127.0.0.1:9997/esb/provider");
		changeGroupDisplayService("name", "transport_protocol", "http://talend.org/esb/service/job");
		
		this.clickWaitForElementPresent("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-endpoint')]/a");		
		selenium.setSpeed(MID_SPEED);
		selenium.click("//a[text()='Show in Groups']");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isElementPresent("//div[@class='x-grid-group-div']"));
		selenium.setSpeed(MIN_SPEED);
		
	}
	
	//hide service display service
	@Test
	public void testHiddenDisplayService() {
		
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
		
		hiddenDisplayServices("http://127.0.0.1:9999/esb/provider", "TEST_jobFirstProvider");
		hiddenDisplayServices("http://127.0.0.1:9999/esb/provider", "TEST_jobFirstProvider");
		
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
	public void testSortTableByClickOnColumnHeader() {		

		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
				
		this.clickWaitForElementPresent("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-endpoint')]/a");		
		selenium.setSpeed(MID_SPEED);
		selenium.click("//a[text()='Show in Groups']");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isElementPresent("//div[@class='x-grid-group-div']"));
		selenium.setSpeed(MIN_SPEED);
		
		checkSortAscendingSortDescending("name", "TEST_jobThirdProvider", "TEST_jobFirstProvider");
		checkSortAscendingSortDescending("endpoint", "http://127.0.0.1:9999/esb/provider",
				"http://127.0.0.1:9996/esb/provider");
		
	}
	
	//Stop and restart a service connected to Service Locator and check correct status display in server table
	@Test
	@Parameters({"provider.file.path.jobFourthProvider", "jobFourthProvider"})
	public void testCheckServiceLocationPageStopServiceAndRestart(String jobFourthPrividerFilePath, 
			String jobFourthProvider) {
		 
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
		
		installStratService(jobFourthPrividerFilePath, jobFourthProvider);		
		//click 'Refresh' button
		selenium.click("//b[text()='Refresh']");		
		//start job
		assertStartService(jobFourthProvider);
		Assert.assertFalse(selenium.isElementPresent("//div[text()='http://127.0.0.1:9996/esb/provider']" +
				"//ancestor::table[@class='x-grid3-row-table']//span[@style='color: red;']"));
		
		stopService("jobFourthProvider");
		//click 'Refresh' button
		selenium.click("//b[text()='Refresh']");		
		//stop job
		assertStopService(jobFourthProvider);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='http://127.0.0.1:9996/esb/provider']" +
				"//ancestor::table[@class='x-grid3-row-table']//span[@style='color: red;']"));
		
		installStratService(jobFourthPrividerFilePath, jobFourthProvider);		
		//click 'Refresh' button
		selenium.click("//b[text()='Refresh']");		
		//start job
		assertStartService(jobFourthProvider);
		Assert.assertFalse(selenium.isElementPresent("//div[text()='http://127.0.0.1:9996/esb/provider']" +
				"//ancestor::table[@class='x-grid3-row-table']//span[@style='color: red;']"));
		
	}	
	
	//stop zkserver, check status info of configuration page and serviceLocation page  
	@Test
	@Parameters({"esb.conf.zookeeperServer", "esb.conf.zookeeperServerWithWrong"})
	public void testStopStartZkServerCheckPageStatus(String zookeeperServer, String zookeeperServerWithWrong) {
		
		//go to 'ServiceLocator' page
		this.clickWaitForElementPresent("!!!menu.servicelocator.element!!!");
		//click 'Refresh' button
		selenium.click("//b[text()='Refresh']");
		//verify service start success
		Assert.assertTrue(selenium.isElementPresent("//div[text()='TEST_jobFirstProvider']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='TEST_jobSecondProvider']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='TEST_jobThirdProvider']"));
		
		modifyEsbConfigurationInConfigurationPage(zookeeperServerWithWrong, other.getString("esb.conf.StopZookeeperServerStatusIconLocator"));
        
		selenium.click("//b[text()='Refresh']");
		this.waitForElementPresent("//div[contains(text(),'Zookeeper for this url is unavailable')]", WAIT_TIME);
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
		Assert.assertTrue(selenium.isElementPresent("//div[text()='TEST_jobFirstProvider']"));
		selenium.setSpeed(MIN_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='TEST_jobSecondProvider']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='TEST_jobThirdProvider']"));
		
	}
	
	//set sam-server url in configuration
    @Test
    @Parameters ({"esb.conf.serviceActivityRemoteMonitorServer", "esb.conf.serviceActivityMonitorServer"})
	public void testSetESBSamServer(String remoteMonitorServer, String localServer){
    	
	   //go to configuration page 
	   this.clickWaitForElementPresent("idMenuConfigElement");
		  
	   this.mouseDownWaitForElementPresent("//div[contains(text(),'ESB')]");	   
	   
	   modifySAMServer(remoteMonitorServer, other.getString("esb.conf.ServiceActivityMonitorServerStatusIconLocator"));
	   
	   modifySAMServer(localServer, other.getString("esb.conf.ServiceActivityMonitorServerStatusIconLocator"));
	   
	}
	
  //set sam-server url with wrong in configuration
    @Test
    @Parameters ({"esb.conf.serviceActivityMonitorServerWithWrong", "esb.conf.serviceActivityMonitorServer"})
	public void testSetESBSamServerWithWrongUrl(String remoteMonitorServerWithWrongUrl, String localServer){	   
    	
	   //go to configuration page 
	   this.clickWaitForElementPresent("idMenuConfigElement");
		  
	   this.mouseDownWaitForElementPresent("//div[contains(text(),'ESB')]");	   

	   modifySAMServer(remoteMonitorServerWithWrongUrl, other.getString("esb.conf.ServiceActivityMonitorServerStatusIconLocator.wrongURL"));
	   
	   this.waitForElementPresent("//div[contains(text(),'SAM Server for this url is unavailable')]", WAIT_TIME);
	   Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'SAM Server for this url is unavailable')]"));
	   selenium.setSpeed(MIN_SPEED);
	   
	   modifySAMServer(localServer, other.getString("esb.conf.ServiceActivityMonitorServerStatusIconLocator"));
	   
	}

    
}
