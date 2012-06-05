package com.talend.cases.esb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.executePlan.TriggerDate;

public class TestEsbServiceActivityFilterData extends Esb {
	
	/**
	 * this method is used to wait something disappear
	 * @param element: element that should disappear
	 * @param timeout: max wait time
	 */
	public void waitForElementDispear(String element, int timeout) {
		if (selenium.isElementPresent(element)) {
			for (int second = 0;; second++) {
				if (second >= timeout)
					Assert.assertFalse(selenium.isElementPresent(element));
				try {
					if ((!selenium.isElementPresent(element))) {
						break;
					} else {
						this.sleep(1000);
					}
				} catch (Exception e) {
				}

			}
		}

	}
	
	/**
	 * 
	 */
	@Test
	public void testDateTimeFiltersSelect(){
		this.openServiceActivityMonitor();
		this.openColumnsFilters("Date / Time","x-grid3-hd-inner x-grid3-hd-timestamp x-component");
		this.checkFilter("Before");
		this.closeFilters();
		this.openColumnsFilters("Date / Time","x-grid3-hd-inner x-grid3-hd-timestamp x-component");
		this.waitForElementPresent("//a[contains(@class,'x-menu-item x-menu-check-item x-menu-item-arrow x-component x-menu-checked') and text()='Before']", WAIT_TIME);
		this.checkFilter("After");
		this.closeFilters();
		this.openColumnsFilters("Date / Time","x-grid3-hd-inner x-grid3-hd-timestamp x-component");
		this.waitForElementDispear("//a[contains(@class,'x-menu-item x-menu-check-item x-menu-item-arrow x-component x-menu-checked') and text()='Before']", WAIT_TIME);
		this.waitForElementPresent("//a[contains(@class,'x-menu-item x-menu-check-item x-menu-item-arrow x-component x-menu-checked') and text()='After']", WAIT_TIME);
		this.closeFilters();
		this.openColumnsFilters("Date / Time","x-grid3-hd-inner x-grid3-hd-timestamp x-component");
		this.checkFilter("On");
		this.closeFilters();
		this.openColumnsFilters("Date / Time","x-grid3-hd-inner x-grid3-hd-timestamp x-component");
		this.waitForElementDispear("//a[contains(@class,'x-menu-item x-menu-check-item x-menu-item-arrow x-component x-menu-checked') and text()='Before']", WAIT_TIME);
		this.waitForElementDispear("//a[contains(@class,'x-menu-item x-menu-check-item x-menu-item-arrow x-component x-menu-checked') and text()='After']", WAIT_TIME);
		this.waitForElementPresent("//a[contains(@class,'x-menu-item x-menu-check-item x-menu-item-arrow x-component x-menu-checked') and text()='On']", WAIT_TIME);
		
	}
	/**
	 * this test case is mainly to test samserver can receive new events and display on tac
	 * 
	 */
	@Test
	@Parameters({"esbMonitorKarafUrl","esbMonitorKarafJar","esbMonitorReceiveNewEventsConsumer"})
	public void testReceiveNewEvents(String karafUrl,String jarPath,String consumerName){
		
		this.openServiceActivityMonitor();
		this.sleep(3000);
		this.openColumnsFilters("Date / Time","x-grid3-hd-inner x-grid3-hd-timestamp x-component");
		this.chooseFilterToday("On");
		String lastpage = selenium
		.getText("//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//div[contains(text(),'of') and @class='my-paging-text x-component ']");
        System.out.println(lastpage);
        String totalPage = lastpage.substring(lastpage.indexOf(" ") + 1);
		selenium.click("//div[contains(@class,'my-paging-text x-component ') and text()='Page']//ancestor::tr[contains(@class,'x-toolbar-left-row')]//td[9]//table");
		this.sleep(3000);
		Assert.assertTrue(
				selenium.getValue(
						"//div[contains(@class,' x-small-editor x-toolbar x-component x-toolbar-layout-ct ')]//input[contains(@class,'gwt-TextBox x-component')]")
						.equals(totalPage), "test go to last page failed!");
		this.sleep(3000);
		int eventsBefore = selenium.getXpathCount("//div[text()='Service Activity Monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')]").intValue();
	    System.out.println("EventsBefore:"+eventsBefore);
		this.generateEvents(karafUrl,consumerName,1);
		this.sleep(3000);
		selenium.click("//div[@class='header-title' and text()='Service Activity Monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//b[text()='Refresh']");
		this.sleep(3000);
		int eventsAfter = selenium.getXpathCount("//div[text()='Service Activity Monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')]").intValue();
		System.out.println("EventsAfter:"+eventsAfter);				
		Assert.assertTrue(eventsAfter==eventsBefore+1, "test new events receive failed!");
	
	}
	
	/**
	 * this test case is mainly to test data filter base on date/time
	 */
	@Test
	public void testFilterDataBaseOnDateTime(){
		TriggerDate date = new TriggerDate();
//		this.sendServiceRequest(consumerName);
		this.openServiceActivityMonitor();
		this.sleep(5000);
		Date now = new Date();
		this.openColumnsFilters("Date / Time","x-grid3-hd-inner x-grid3-hd-timestamp x-component");
		this.chooseFilterToday("Before");
		this.checkFileterDateTimeBefore(now);
		this.openColumnsFilters("Date / Time","x-grid3-hd-inner x-grid3-hd-timestamp x-component");
		this.chooseFilterDateTime("After",date);
		this.sleep(5000);
		this.checkFileterDateTimeAfter();
		this.openColumnsFilters("Date / Time","x-grid3-hd-inner x-grid3-hd-timestamp x-component");
		this.chooseFilterToday("On");
		this.sleep(3000);
		this.checkFileterDateTimeOn(now);
		
	}
	
	/**
	 * this test case is mainly to test filter data base on port type
	 */
	@Test
	@Parameters({"esbMonitorPorttypeExist","esbMonitorPorttypeNotExist"})
	public void testFilterDataBaseOnPortType(String portTypeExist,String portTypeNotExist){
		
		this.openServiceActivityMonitor();
		this.sleep(3000);
		int events = selenium.getXpathCount("//div[text()='Service Activity Monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')]").intValue();
		this.openColumnsFilters("PortType"," x-grid3-hd-inner x-grid3-hd-port x-component");
		this.waitForElementPresent("//div[contains(@class,'x-ignore x-menu x-component')]//input", WAIT_TIME);
		this.typeString("//div[contains(@class,'x-ignore x-menu x-component')]//input", portTypeNotExist);
	    this.closeFilters();
		this.waitForTextPresent("There are no events available. Please click refresh button to retry.", WAIT_TIME);
		this.openColumnsFilters("PortType"," x-grid3-hd-inner x-grid3-hd-port x-component");
		this.waitForElementPresent("//div[contains(@class,'x-ignore x-menu x-component')]//input", WAIT_TIME);
		this.typeString("//div[contains(@class,'x-ignore x-menu x-component')]//input", portTypeExist);
		this.closeFilters();
		this.checkFilterResultWithString(portTypeExist);
		this.openColumnsFilters("PortType"," x-grid3-hd-inner x-grid3-hd-port x-component");
		this.waitForElementPresent("//div[contains(@class,'x-ignore x-menu x-component')]//input", WAIT_TIME);
	    this.typeString("//div[contains(@class,'x-ignore x-menu x-component')]//input", "");
	    this.closeFilters();
	    this.sleep(3000);
	    int eventsSpace = selenium.getXpathCount("//div[text()='Service Activity Monitoring']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[@class='x-grid3-body']//div[contains(@class,'x-grid3-row')]").intValue();
	    Assert.assertTrue(events==eventsSpace, "test filter data with null string failed!");
		
	}
	
	public void checkFilterResultWithString(String filterString){
//		System.out.println(selenium.getBodyText());
		java.util.List<String> a = this.findSpecialMachedStrings("^\\{http://[^/s]*.*/\\}.*");
		for (int i = 0; i < a.size(); i++) {
			System.out.println("___________>"+a.get(i));
			Assert.assertTrue(a.get(i).contains(filterString), "test filter data base on string failed!");
		}
	}
	
	public HashMap<String, String> getMonthmap() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Jan","01");
		map.put("Feb","02");
		map.put( "Mar","03");
		map.put("Apr","04");
		map.put("May","05");
		map.put("Jun","06");
		map.put("Jul","07");
		map.put("Aug","08");
		map.put("Sep","09");
		map.put("Oct","10");
		map.put("Nov","11");
		map.put("Dec","12");
		return map;

	}
	
	public Date changeToDate(String strTime){
		
		String date = "Sat Sep 11 21:50:00 GMT 2010";
		date = strTime.replace("GMT+800", "GMT");
		  SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.US);
		  
		  Date d = null;
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("date parse failed!");
		}
		 return d;

	}
	
	public void checkFileterDateTimeBefore(Date date){
		boolean ok = false;
		System.out.println(date.toGMTString());
		Date compare = null;
		Date now = null;
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.US);
		try {
			 now = sdf.parse(date.toString().replace("CST", "GMT"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.util.List<String> a = this.findSpecialMachedStrings("^[a-zA-Z]{3} [a-zA-Z]{3} \\d{2} \\d{2}:\\d{2}:\\d{2} GMT+.*");
		for (int i = 0; i < a.size(); i++) {
			
				System.out.println("-------------->"+a.get(i));
				compare=this.changeToDate(a.get(i));
				System.out.println("****************"+compare.getYear());
				System.out.println("date get: "+compare.toGMTString());
				if(compare.before(now)){
				ok  = true;
				}
				Assert.assertTrue(ok);
			}
	}
	
     public void checkFileterDateTimeAfter(){
    		
    		boolean ok = false;
    		
    		java.util.List<String> a = this.findSpecialMachedStrings("^[a-zA-Z]{3} [a-zA-Z]{3} \\d{2} \\d{2}:\\d{2}:\\d{2} GMT+.*");
    		if(a==null||a.size()==0){
            	ok = true;
            }
				Assert.assertTrue(ok);
		
	}
     
     public void checkFileterDateTimeOn(Date date){
 		
    		boolean ok = false;
    		System.out.println(date.toGMTString());
    		Date compare = null;
    		Date now = null;
    		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.US);
    		try {
    			 now = sdf.parse(date.toString().replace("CST", "GMT"));
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		java.util.List<String> a = this.findSpecialMachedStrings("^[a-zA-Z]{3} [a-zA-Z]{3} \\d{2} \\d{2}:\\d{2}:\\d{2} GMT+.*");
    		for (int i = 0; i < a.size(); i++) {
    			
    				System.out.println("-------------->"+a.get(i));
    				
    				compare=this.changeToDate(a.get(i));
    				System.out.println("****************"+compare.getYear());
    				System.out.println("date get: "+compare.toGMTString());
    				
    				if((compare.getYear()==now.getYear())&&(compare.getMonth()==now.getMonth())&&(compare.getDay()==now.getDay()))
    				{
    				ok  = true;
    				}
    				Assert.assertTrue(ok);
    			}
 	}
	
	public void openColumnsFilters(String beginTag,String beginTagClass){
		this.waitForElementPresent("//span[text()='"+beginTag+"']", WAIT_TIME);
		this.sleep(2000);
		selenium.click("//span[text()='"+beginTag+"']//parent::div[contains(@class,'"+beginTagClass+"')]//a");
//		this.waitForElementPresent("//a[text()='Columns']", WAIT_TIME);
		this.waitForElementPresent("//a[text()='Filters']", WAIT_TIME);
		selenium.mouseOver("//a[text()='Filters']");
	}
	
	public void checkFilter(String filterName){
		boolean present = selenium.isElementPresent("//a[contains(@class,' x-menu-item x-menu-check-item x-menu-item-arrow x-component  x-menu-checked') and text()='"+filterName+"']");
		if(!present){
			selenium.click("//a[text()='"+filterName+"']");
		}
		
	}
	
	public void chooseFilter(String filterName,String dateTime){
		selenium.mouseOver("//a[text()='"+filterName+"']");
		selenium.mouseDown("//span[text()='"+dateTime+"']");
	}
	public void chooseFilterToday(String filterName){
		selenium.mouseOver("//a[text()='"+filterName+"']");
		this.clickWaitForElementPresent(("//button[text()='Today']"));
	}
	
	public void chooseFilterDateTime(String fileterName,TriggerDate date){
		selenium.mouseOver("//a[text()='"+fileterName+"']");
		if(TriggerDate.isClickFutureMonthButton(date.getFuture(24))){
    		this.clickWaitForElementPresent("//div[contains(@class,'x-icon-btn x-nodrag x-date-right-icon x-component')]");
        }
		this.clickWaitForElementPresent("//td[@class='x-date-active']/a/span[text()='" + date.getFuture(24).days + "']");
	}
	
	public void unChooseColumn(String filterName){
		boolean present = selenium.isElementPresent("//a[@contains(@class,' x-menu-item x-menu-check-item x-menu-item-arrow x-component  x-menu-checked') and text()='"+filterName+"']");
		if(present){
			selenium.click("//a[text()='"+filterName+"']");
		}
	}
	
	public void closeFilters(){
		if(selenium.isElementPresent("//a[text()='Filters']")){
			selenium.click("//a[text()='Filters']");
		}
	}
	
}
