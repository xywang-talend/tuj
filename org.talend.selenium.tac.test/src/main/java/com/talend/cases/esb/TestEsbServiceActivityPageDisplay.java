package com.talend.cases.esb;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestEsbServiceActivityPageDisplay extends Esb {

	@Test
	public void testMonitorGoToNextPage() {
		this.openServiceActivityMonitor();
		this.sleep(5000);
		Assert.assertTrue(selenium
				.getValue(
						"//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//input[contains(@class,'gwt-TextBox x-component ')]")
				.equals("1"));

		selenium.click("//div[@class='my-paging-text x-component ' and text()='Page']//ancestor::tr[@class='x-toolbar-left-row']//td[8]//table");
		this.sleep(5000);
		System.out.println(selenium.getValue(
						"//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[contains(@class,'gwt-TextBox x-component')]").toString());
		Assert.assertTrue(
				selenium.getValue(
						"//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[contains(@class,'gwt-TextBox x-component')]").toString()
						.equals("2"), "test go to next page failed!");

	}

	@Test
	public void testMonitorGoToLastPage() {
		this.openServiceActivityMonitor();
		this.sleep(3000);
		String lastpage = selenium
				.getText("//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//div[contains(text(),'of') and @class='my-paging-text x-component ']");
		System.out.println(lastpage);
		String totalPage = lastpage.substring(lastpage.indexOf(" ") + 1);
		System.out.println(totalPage);
		selenium.click("//div[@class='my-paging-text x-component ' and text()='Page']//ancestor::tr[@class='x-toolbar-left-row']//td[9]//table");
		this.sleep(3000);
		Assert.assertTrue(
				selenium.getValue(
						"//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[contains(@class,'gwt-TextBox x-component')]")
						.equals(totalPage), "test go to last page failed!");

	}

	@Test
	public void testMonitorGoToFirstPage() {
		this.openServiceActivityMonitor();
		this.sleep(3000);
		this.testMonitorGoToLastPage();
		selenium.click("//div[@class='my-paging-text x-component ' and text()='Page']//ancestor::tr[@class='x-toolbar-left-row']//td[1]//table");
		this.sleep(3000);
		Assert.assertTrue(
				selenium.getValue(
						"//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[contains(@class,'gwt-TextBox x-component')]")
						.equals("1"), "test go to last page failed!");

	}

	@Test
	public void testMonitorGoToPrePage() {
		this.openServiceActivityMonitor();
		this.sleep(3000);
		String lastpage = selenium
				.getText("//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//div[contains(text(),'of') and @class='my-paging-text x-component ']");
		System.out.println(lastpage);
		String totalPage = lastpage.substring(lastpage.indexOf(" ") + 1);
		System.out.println(totalPage);
		this.testMonitorGoToLastPage();
		selenium.click("//div[@class='my-paging-text x-component ' and text()='Page']//ancestor::tr[@class='x-toolbar-left-row']//td[2]//table");
		this.sleep(3000);
		System.out.println(selenium.getValue(
						"//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[contains(@class,'gwt-TextBox x-component')]"));
		Assert.assertTrue(
				selenium.getValue(
						"//div[@class=' x-small-editor x-toolbar x-component x-toolbar-layout-ct ']//input[contains(@class,'gwt-TextBox x-component')]").toString()
						.equals((Integer.parseInt(totalPage)-1)+""), "test go to previous page failed!");

	}
	
	@Test
	@Parameters({"esbMonitorPagesize"})
	public void testMonitorPageInput(String pageCounts) {
		this.openServiceActivityMonitor();
		this.sleep(3000);
		Assert.assertTrue(
				selenium.getValue(
						"//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//input[contains(@class,'gwt-TextBox x-component ')]").toString()
						.equals("1"), "test go to previous page failed!");
		this.inputNum("2","//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//input[contains(@class,'gwt-TextBox x-component ')]");
       this.sleep(3000);
       String display = selenium.getText("//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//div[contains(text(),'of') and contains(@class,'my-paging-display x-component')]");
	   String beginNum = display.substring(display.indexOf(" ")+1, display.indexOf("-")-1);
	   String expectedNum = (Integer.parseInt(pageCounts)*1)+1+"";
	   Assert.assertTrue(beginNum.equals(expectedNum), "test go to page input failed!");
	   this.inputNum("-1", "//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//input[contains(@class,'gwt-TextBox x-component ')]");
	   this.sleep(2000);
	   Assert.assertTrue(
				selenium.getValue(
						"//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//input[contains(@class,'gwt-TextBox x-component ')]").toString()
						.equals("2"), "test go to previous page failed!");
	   this.inputNum("0", "//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//input[contains(@class,'gwt-TextBox x-component ')]");
	   this.sleep(2000);
	   Assert.assertTrue(
				selenium.getValue(
						"//div[contains(@class,'x-small-editor x-toolbar x-component x-toolbar-layout-ct')]//input[contains(@class,'gwt-TextBox x-component ')]").toString()
						.equals("2"), "test go to previous page failed!");
	}
	
	public void inputNum(String num ,String xpath){
		
		selenium.type(xpath, num);
		selenium.keyDown(xpath,"\\13");
		
	}
	
	

}
