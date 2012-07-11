package org.talend.mdm.modules;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.talend.mdm.Base;
import org.testng.Assert;

public class Record extends Base {

	public Record(WebDriver driver) {
		super.setDriver(driver);
		this.driver = driver;
	}

	public void deleteTheRecord(String entity) {
		this.clickElementByXpath(locator.getString("xpath.record.delete.record"));
		this.clickElementByXpath(locator.getString("xpath.record.delete.record.choose"));
		this.clickElementByXpath(locator.getString("xpath.record.delete.record.choose.yes"));
		/*
		 * if (this.isElementPresent(By.xpath(locator.getString(
		 * "xpath.record.delete.record.warn")),WAIT_TIME_MIN)){
		 * this.clickElementByXpath("//button[text()='No']"); }
		 */
	}
	
	public void deleteToRecycleBin(){
		this.clickElementByXpath(locator.getString("xpath.record.delete.record")); 
		this.clickElementByXpath(locator.getString("xpath.record.delete.record.to.recycle.choose")); 
//		this.clickElementByXpath(locator.getString("xpath.record.delete.record.to.recycle.choose.ok")); 
	}

	public void openJournal(String entity, String key, String OperationType,
			String source) {
		enterJournal(entity, key, OperationType, source);
		// JournalResultCount();
	}

	public void launchProcess(String processOption) {
		this.seletDropDownList(By.xpath(locator.getString("xpath.record.launchprocess.select.img")),processOption);
		this.clickElementByXpath(locator.getString("xpath.record.launchprocess.button"));
	}

	public void checkProcessDoneAndClickOK() {
		this.waitfor(By.xpath(locator.getString("xpath.record.launchprocess.success.status.info")),WAIT_TIME_MID);
		// click process ok button to verify can open bonita workflow console
		this.clickElementByXpath(locator.getString("xpath.record.launchprocess.success.ok.button"));
	}

	public void enterJournal(String entity, String key, String OperationType,
			String source) {
		clickJournal();
		this.sleepCertainTime(5000);
		this.modifyText(this.getElementByXpath(locator.getString("xpath.record.choose.journal.entity")), entity);
		this.modifyText(this.getElementByXpath(locator.getString("xpath.record.choose.journal.key")), key);
		this.modifyText(this.getElementByXpath(locator.getString("xpath.record.choose.journal.source")), source);
		this.clickElementByXpath(locator.getString("xpath.record.choose.journal.operation.arrows"));
		this.sleepCertainTime(2000);
		this.clickElementByXpath(this.getString(locator,"xpath.record.choose.journal.operation.choose", OperationType));
		this.clickElementByXpath(locator.getString("xpath.record.click.journal.search"));
		this.sleepCertainTime(5000);
	}

	public void JournalResultCount() {
		int recordCount;
		boolean result;
		String recordSearchResult;
		recordSearchResult = this.getElementByXpath(locator.getString("xpath.record.update.journal.price")).getText();
		if (recordSearchResult.contains("No data to display")) {
			recordCount = 0;
		} else {
			recordCount = Integer.parseInt(this.getElementByXpath(locator.getString("xpath.record.journal.count")).getText().split("of")[1].trim());
		}
		if (recordCount > 0) {
			result = true;
		} else {
			result = false;
		}
		Assert.assertTrue(result);
	}

	public void JournalCheckResult(String key, String OperationType) {
		String[] parameters = { key, OperationType };
		/*this.moveToElement(driver.findElement(By.xpath("//div[text()='Operation Time']")));
		this.sleepCertainTime(2000);
		// this.clickVisibleElementByXpath("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-6')]//a[@class='x-grid3-hd-btn']");
		this.clickVisibleElementByXpath("//span[text()='Journal']//ancestor::div[@class='extpj']//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-6')]//a[@class='x-grid3-hd-btn']");

		this.sleepCertainTime(2000);
		this.clickVisibleElementByXpath("//a[text()='Sort Descending']");
		this.sleepCertainTime(2000);
*/		
		this.sleepCertainTime(5000);
		this.doubleClick(this.chooseLatestRecordInJournal());
		this.sleepCertainTime(5000);
/*		this.clickElementByXpath(this.getString(locator,"xpath.record.choose.journal.choose.record", parameters));
		this.doubleClick(this.getElementByXpath(this.getString(locator,"xpath.record.choose.journal.choose.record", parameters)));
		this.sleepCertainTime(5000);*/
		this.clickElementByXpath(locator.getString("xpath.record.journal.click.info"));
		this.sleepCertainTime(3000);
	}
	public void JournalSearch(String key, String OperationType) {
		String[] parameters = { key, OperationType };
		this.moveToElement(driver.findElement(By.xpath("//div[text()='Operation Time']")));
		this.sleepCertainTime(2000);
		// this.clickVisibleElementByXpath("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-6')]//a[@class='x-grid3-hd-btn']");
		this.clickVisibleElementByXpath("//span[text()='Journal']//ancestor::div[@class='extpj']//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-6')]//a[@class='x-grid3-hd-btn']");

		this.sleepCertainTime(2000);
		this.clickVisibleElementByXpath("//a[text()='Sort Descending']");
		this.sleepCertainTime(2000);
		this.clickElementByXpath(this.getString(locator,"xpath.record.choose.journal.choose.record", parameters));
		this.doubleClick(this.getElementByXpath(this.getString(locator,"xpath.record.choose.journal.choose.record", parameters)));
		this.sleepCertainTime(5000);		
	}

	public void searchDateAssert(String searchFeild, String opeartion,
			String value, String entity_Element) {
		int recordCount;
		Date[] dates;
		Date searchDate = null;
		boolean result = false;
		String recordSearchResult;
		String[] parametersSearch = { entity_Element, searchFeild };
		logger.warn(this.getElementByXpath(locator.getString("xpath.record.search.record.count")).getText());
		recordSearchResult = this.getElementByXpath(locator.getString("xpath.record.search.record.count")).getText();
		if (recordSearchResult.contains("No data to display")) {
			recordCount = 0;
			logger.warn("No data to display");
			result = true;
		} else {
			recordCount = this.getTotalRecordNum();
			logger.warn(recordCount);
			dates = new Date[recordCount];
			try {
				searchDate = new SimpleDateFormat("yyyy-MM-dd").parse(value);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i <= recordCount - 1; i++) {
				String dates_text = this.getElementsByXpath(this.getString(locator,"xpath.record.search.record.value",parametersSearch)).get(i).getText();
				if (!dates_text.equals(" ")) {
					try {
						dates[i] = (new SimpleDateFormat("yyyy-MM-dd")).parse(
								this.getElementsByXpath(this.getString(locator,"xpath.record.search.record.value",parametersSearch)).get(i).getText());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (opeartion.contains("equals")) {
						if (dates[i].equals(searchDate)) {
							result = true;
						} else
							result = false;
					}

					if (opeartion.contains("is before")) {
						if (dates[i].before(searchDate)) {
							result = true;
						} else
							result = false;
					}

					if (opeartion.contains("is after")) {
						if (dates[i].after(searchDate)) {
							result = true;
						} else
							result = false;
					}
				}
			}
		}
		Assert.assertTrue(result);
	}

	public void searchStringAssert(String searchFeild, String opeartion,
			String value, String entity_Element) {
		int recordCount;
		String[] names;
		String[] parameters = { entity_Element, searchFeild };
		boolean result = false;
		String recordSearchResult;

		logger.warn(this.getElementByXpath(locator.getString("xpath.record.search.record.count"))
				.getText());
		recordSearchResult = this.getElementByXpath(
				locator.getString("xpath.record.search.record.count")).getText();
		if (recordSearchResult.contains("No data to display")) {
			recordCount = 0;
			logger.warn("No data to display");
			result = true;
		} else {
			recordCount = this.getTotalRecordNum();
			names = new String[recordCount];
			for (int i = 0; i <= recordCount - 1; i++) {
				String names_text = this.getElementsByXpath(this.getString(locator,"xpath.record.search.record.value",parameters)).get(i).getText();
				if (!names_text.equals(" ")) {
					names[i] = this
							.getElementsByXpath(this.getString(locator,"xpath.record.search.record.value",parameters)).get(i).getText();
					if (opeartion.contains("contains the word(s)")) {
						if (names[i].contains(value)) {
							result = true;
						} else
							result = false;
					}

					if (opeartion.contains("contains a word starting with")) {
						if (names[i].contains(value)
								&& names[i].startsWith(value)) {
							result = true;
						} else
							result = false;
					}

					if (opeartion.contains("contains the sentence")) {
						// value = value.replace(" ", "/ ");
						if (names[i].contains(value)) {
							result = true;
						} else
							result = false;
					}
				}
			}
		}
		Assert.assertTrue(result);
	}

	public void searchValueAssert(String searchFeild, String opeartion,
			String value, String entity_Element) {
		// String[] parametersSearch={entity,searchFeild};
		int recordCount;
		String recordSearchResult;
		double[] ages;
		boolean result = false;
		String[] parameters = { entity_Element, searchFeild };
		logger.warn(this.getElementByXpath(
				locator.getString("xpath.record.search.record.count")).getText());
		recordSearchResult = this.getElementByXpath(
				locator.getString("xpath.record.search.record.count")).getText();
		if (recordSearchResult.contains("No data to display")) {
			recordCount = 0;
			logger.warn("No data to display");
			result = true;
		} else {
			recordCount = this.getTotalRecordNum();
			logger.warn(recordCount);
			ages = new double[recordCount];
			for (int i = 0; i <= recordCount - 1; i++) {
				String age_text = this.getElementsByXpath(this.getString(locator,"xpath.record.search.record.value",parameters)).get(i).getText();
				if (!age_text.equals(" ")) {
					ages[i] = Double.parseDouble(
							this.getElementsByXpath(this.getString(locator,"xpath.record.search.record.value",parameters)).get(i).getText());
					logger.warn(ages[i]);
					if (opeartion.contains("is greater than")) {
						if (Double.parseDouble(value) < ages[i]) {
							result = true;
						} else
							result = false;
					}

					if (opeartion.contains("is equal to")) {
						if (Double.parseDouble(value) == ages[i]) {
							result = true;
						} else
							result = false;
					}

					if (opeartion.contains("is greater or equals")) {
						if (Double.parseDouble(value) <= ages[i]) {
							result = true;
						} else
							result = false;
					}

					if (opeartion.contains("is lower than")) {
						if (Double.parseDouble(value) > ages[i]) {
							result = true;
						} else
							result = false;
					}

					if (opeartion.contains("is lower or equals")) {
						if (ages[i] <= Double.parseDouble(value)) {
							result = true;
						} else
							result = false;
					}

					if (opeartion.contains("is not equal to")) {
						if (ages[i] != Double.parseDouble(value)) {
							result = true;
						} else
							result = false;
					}
				}
			}
		}
		Assert.assertTrue(result);

	}

	public void searchCondition(String searchFeild, String opeartion,
			String value) {
		searchFeild(searchFeild);
		searchOpeartion(opeartion);
		searchValue(value);
		// click the search button
		this.clickElementByXpath(locator.getString("xpath.record.search.click"));
		this.sleepCertainTime(3000);
	}

	public void searchFeild(String searchFeild) {
		// choose the search feild
		Assert.assertTrue(this.isElementPresent(
				By.xpath(locator.getString("xpath.record.search.feild.arrows")),3000));
		this.sleepCertainTime(5000);
		this.clickElementByXpath(locator.getString("xpath.record.search.feild.arrows"));
		this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.search.feild", searchFeild)), WAIT_TIME_MAX);
		this.clickElementByXpath(this.getString(locator,"xpath.record.search.feild", searchFeild));
	}

	public void searchOpeartion(String opeartion) {
		// choose the search operator
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.record.search.operator.arrows")), 3000));
		this.clickElementByXpath(locator.getString("xpath.record.search.operator.arrows"));
		this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.search.operator", opeartion)), WAIT_TIME_MAX);
		this.clickElementByXpath(this.getString(locator,"xpath.record.search.operator", opeartion));
	}

	public void searchValue(String value) {
		// input the search value
		this.modifyText(this.getElementByXpath(locator.getString("xpath.record.search.value")), value);
	}

	public void chooseContainer(String container) {
		this.sleepCertainTime(3000);
		this.clickElementByXpath(locator.getString("xpath.record.choose.containe.arrows"));
		this.clickElementByXpath(this.getString(locator,"xpath.record.choose.container", container));

	}

	public void chooseModle(String modle) {
		this.sleepCertainTime(3000);
		this.clickElementByXpath(locator.getString("xpath.record.choose.modle.arrows"));
		this.clickElementByXpath(this.getString(locator,"xpath.record.choose.modle", modle));
	}

	public void clickSave() {
		this.clickElementByXpath(locator.getString("xpath.record.chooseCM.save"));
		this.clickElementByXpath(locator.getString("xpath.record.chooseCM.save.ok"));
	}

	public void chooseEntity(String entity) {
		this.sleepCertainTime(3000);
		this.clickElementByXpath(locator.getString("xpath.record.click.DataBrowser"));
		Assert.assertTrue(this
				.waitfor(By.xpath(locator.getString("xpath.record.choose.entity.arrows")),WAIT_TIME_MIN).isDisplayed());
		/*
		 * this.seletDropDownList(By.xpath(locator.getString(
		 * "xpath.record.choose.entity.arrows")), entity);
		 */
		this.clickElementByXpath(locator.getString("xpath.record.choose.entity.arrows"));
		this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.choose.entity", entity)), WAIT_TIME_MAX);
		// this.sleepCertainTime(10000);
		this.clickElementByXpath(this.getString(locator,"xpath.record.choose.entity", entity));
		this.sleepCertainTime(10000);
	}

	public void chooseEntityDirectlyInDataBrowser(String entity) {
		this.sleepCertainTime(3000);
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.record.choose.entity.arrows")),WAIT_TIME_MIN).isDisplayed());
		/*
		 * this.seletDropDownList(By.xpath(locator.getString(
		 * "xpath.record.choose.entity.arrows")), entity);
		 */
		this.clickElementByXpath(locator.getString("xpath.record.choose.entity.arrows"));
		this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.choose.entity", entity)), WAIT_TIME_MAX);
		// this.sleepCertainTime(10000);
		this.clickElementByXpath(this.getString(locator,"xpath.record.choose.entity", entity));
	}

	public void clickCreateRecord() {
		this.sleepCertainTime(5000);
		this.clickElementByXpath(locator.getString("xpath.record.choose.create"));
		this.sleepCertainTime(5000);
	}

	public int getTotalRecordNum(){
		int recordCount = Integer
				.parseInt(this.getElementByXpath(locator.getString("xpath.record.search.record.count")).getText().split("~")[1].trim());
		return recordCount;
	}
	
	public void closeDatachangesViewer() {
		this.clickElementByXpath(locator.getString("xpath.datachangesviewer.tab.close"));
	}

	public void closeDataBrowser() {
		this.clickElementByXpath(locator.getString("xpath.databrowser.tab.close"));
	}

	public void openDataBrowserFromWelcome() {
		this.clickElementByXpath(locator.getString("xpath.welcome.tab"));
		this.clickElementByXpath(locator.getString("xpath.ui.window.getstarted.item.link.databrowser"));
	}

	public void chooseRcord(String entity, String feild1Name, String feild1Value) {
		String[] parameters = { entity, feild1Name, feild1Value };
		this.sleepCertainTime(5000);
		this.clickElementByXpath(this.getString(locator,"xpath.record.choose.delete.record", parameters));
		this.sleepCertainTime(5000);
	}
	  private int compareDate(String d1,String d2){

			String s1=d1.substring(0,4)+"-"+d1.substring(4,6)+"-"+d1.substring(6,8)+" "+d1.substring(9,d1.length());
			String s2=d2.substring(0,4)+"-"+d2.substring(4,6)+"-"+d2.substring(6,8)+" "+d2.substring(9,d2.length());
//			System.err.println(s1);
//			System.err.println(s2);
			java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Calendar c1=java.util.Calendar.getInstance();
			java.util.Calendar c2=java.util.Calendar.getInstance();
			try
			{
			c1.setTime(df.parse(s1));
			c2.setTime(df.parse(s2));
			}catch(java.text.ParseException e){
			System.err.println("wrong date formate with s1 or s2 ?");
			}
			int result=c1.compareTo(c2);
			return result;
	   }
	public WebElement chooseLatestRecordInJournal(){
		List<WebElement> a = this.getElementsByXpath("//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-6')]//div[contains(@class,'x-grid3-cell-inner x-grid3-col-6')]");
		System.out.println("before:");
		for(int i=0;i<a.size();i++){
		System.out.println(this.getValue(a.get(i)));
		}
		for(int i=0;i<a.size()-1;i++){
			for(int j=i+1;j<a.size();j++){
				WebElement c=null;
				if(compareDate(this.getValue(a.get(i)),this.getValue(a.get(j)))>0){
					c=a.get(i);
					a.set(i, a.get(j));
					a.set(j,c);
					c=null;
				}
			}
		}
		System.out.println("after:");
		for(int i=0;i<a.size();i++){
		System.out.println(this.getValue(a.get(i)));
		}
		System.err.println(this.getValue(a.get(a.size()-1)));
		return a.get(a.size()-1);
	}
	
	public void clickRecycle() {
		this.clickElementByXpath(locator.getString("xpath.record.recycle.click.brower"));
		this.sleepCertainTime(3000);
		this.clickElementByXpath(locator.getString("xpath.record.recycle.click.recycle"));
	}

	public void clickJournal() {
		this.sleepCertainTime(3000);
		this.clickElementByXpath(locator.getString("xpath.record.choose.journal"));
	}

	public void openJournalFromDataBrowser() {
		this.clickJournal();
		// this.clickElementByXpath("//div[contains(@class,'x-small-editor x-toolbar ItemDetailToolBar x-component x-toolbar-layout-ct')]//button[contains(text(),'Journal')]");
	}

	public void switchtoTabWelcome() {
		this.clickElementByXpath(locator.getString("xpath.welcome.tab"));
	}

	public void switchtoTabDataBrowser() {
		this.clickElementByXpath(locator.getString("xpath.datavrowser.tab"));
	}

	public void checkPropertiesBeforeAfterInDatachangesViewer(
			String properties, String valueBefore, String valueAfter,
			boolean compareType) {

		String before = this.getValue(this.getElementByXpath("//span[text()='Before']//ancestor::div[@id='documentHistoryPanel1']//span[contains(text(),'"+ properties + "')]")).trim();
		logger.warn("in update detail panel,value before is :" + before);
		logger.warn("parameters for value before is :" + valueBefore);
		Assert.assertTrue(before.contains(valueBefore));
		String after = this.getValue(this.getElementByXpath("//span[text()='After']//ancestor::div[@id='documentHistoryPanel2']//span[contains(text(),'"+ properties + "')]")).trim();
		logger.warn("in update detail panel,value after is :" + after);
		logger.warn("parameters for value after is :" + valueAfter);
		// true ,means before = after.
		if (compareType) {
			Assert.assertTrue(before.equals(after));
			Assert.assertTrue(after.contains(valueAfter));
		} else {
			Assert.assertFalse(after.equals(before));
		}

	}

	public void closeJournal() {
		this.clickElementByXpath(locator.getString("xpath.journal.tab.close"));
	}

	public void clickExport() {
		this.clickElementByXpath(locator.getString("xpath.record.click.importAndExport"));
		this.clickElementByXpath(locator.getString("xpath.record.choose.export"));
	}

	public void maxARecordPanel() {
		Point b = this.findElementDefineDriver(this.driver,By.xpath(locator.getString("xpath.record.databrowser.bigger"))).getLocation();
		Point a = this.findElementDefineDriver(this.driver,By.xpath(locator.getString("xpath.record.expend.record.pannel"))).getLocation();

		logger.warn("maxARecordPanel-" + b.x + " " + b.y);
		logger.warn("maxARecordPanel-" + a.x + " " + a.y);
		logger.warn("move to left by:" + (a.x - b.x - 50));

		Actions builder = new Actions(driver);
		builder.clickAndHold(
				this.findElementDefineDriver(this.driver, By.xpath(locator.getString("xpath.record.expend.record.pannel"))))
				.moveToElement(this.findElementDefineDriver(this.driver,By.xpath(locator.getString("xpath.record.choose.create"))),2, -2).release().build().perform();

		// this.dragAndDropBy(this.findElementDefineDriver(this.driver,
		// By.xpath(locator.getString("xpath.record.expend.record.pannel"))),
		// -a.x+b.x+50, 0);
	}

	public void maxDataBrowserBoard() {
		Point b = this.findElementDefineDriver(this.driver,By.xpath(locator.getString("xpath.record.databrowser.bigger"))).getLocation();
		logger.warn("maxDataBrowserBoard Point " + b.x + "," + b.y);
		logger.warn("move to left by:" + (b.x - 100));

		Actions builder = new Actions(driver);
		builder.clickAndHold(
				this.findElementDefineDriver(this.driver, By.xpath(locator.getString("xpath.record.databrowser.bigger"))))
				.moveToElement(this.findElementDefineDriver(this.driver, By.xpath(locator.getString("xpath.menuboard.menu"))),10, 0).release().build().perform();
		// this.dragAndDropBy(this.findElementDefineDriver(this.driver,
		// By.xpath(locator.getString("xpath.record.databrowser.bigger"))),
		// -b.x+100, 0);
	}
}