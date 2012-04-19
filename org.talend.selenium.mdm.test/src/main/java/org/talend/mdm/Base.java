package org.talend.mdm;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.talend.mdm.TestCase.Result;
import org.testng.Assert;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.TestRunner;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

public class Base {
	public Logger logger  =  Logger.getLogger(this.getClass());
	public Locale currentLocale = new Locale("en", "US"); // set the locale that
	// you want to test
	public ResourceBundle rb = ResourceBundle.getBundle("org.talend.mdm.resources.messages",currentLocale);
	
	public ResourceBundle other = ResourceBundle.getBundle("org.talend.mdm.resources.other",currentLocale);
	public ResourceBundle locator = ResourceBundle.getBundle("org.talend.mdm.resources.locator",currentLocale);
	
	public final static int WAIT_TIME_MIN =50;
	public final static int WAIT_TIME_MID = 300;
	public final static int WAIT_TIME_MAX = 5000;
	
	public static List<TestCase> successTestCases = new ArrayList<TestCase>();
	public static List<TestCase> failedTestCases = new ArrayList<TestCase>();
	TestCaseRecorder testCaseRecorder = new TestCaseRecorder();
	TestCaseScreenRecorder testCaseScreenRecorder;
	
	public WebDriver driver;
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	
	public void sleepCertainTime(int sleepTime){
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void refreshBrowser(){
		driver.navigate().refresh();
	}
	
	public void openURL(WebDriver dri,String url){
		dri.get(url);
	}
	
	public WebDriver initNewDriver(){
		
		return new FirefoxDriver();
		
	}
	
	public WebElement findElementDefineDriver(WebDriver dri,By by){
		return dri.findElement(by);
	}
	
	public WebElement waitfor(final By by, int timeout) {
		 WebElement element = null;
		 
		 WebDriverWait wait = new WebDriverWait(driver, timeout);

		 try {
			element = wait.until((new Function<WebDriver, WebElement>() {
			    public WebElement apply(WebDriver webDriver) {
			    	WebElement wElement = webDriver.findElement(by);
			        if (wElement != null) {
			            return wElement;
			        }
			        return null;
			    }
			}));
		} catch (Exception e) {
			System.out.println("Couldn't find the element - " + by);
		}
		return element;
	}
	
	public boolean isElementPresent(By by, int timeout) {
		if(this.waitfor(by, WAIT_TIME_MIN) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	
	public WebElement waitfor(final By by, int checkTimes, int timeout) {
		int i=0;
		WebElement element = null;
		 do{
			 i++;
			 element = waitfor(by, timeout);
			 try {
				Thread.sleep(timeout);
			} catch (InterruptedException e) {
			}
		 }while(element==null | i<=checkTimes);
		 return element;
	}
	
	
	/**
	 */
	public boolean waitforElementDisplayed(final By by, int timeout) {
		 WebDriverWait wait = new WebDriverWait(driver, timeout);
		 wait.until((new Predicate<WebDriver>(){
			public boolean apply(WebDriver webDriver) {
				WebElement wElement = webDriver.findElement(by);
				return wElement.isDisplayed();
			}
		 }));
		return false;
	}
	
	
	/**
	 */
	public boolean waitforElementDisplayed(final WebElement wElement, int timeout) {
		 WebDriverWait wait = new WebDriverWait(driver, timeout);
		 wait.until((new Predicate<WebDriver>(){
			public boolean apply(WebDriver webDriver) {
				return wElement.isDisplayed();
			}
		 }));
		return false;
	}
	
	/**
	 *  driver.findElement(By.tagName("body")).getText().contains(what);
	 * @param by
	 * @param timeout
	 */
	public boolean waitforTextDisplayed(final String text, int timeout) {
		 WebDriverWait wait = new WebDriverWait(driver, timeout);
		 wait.until((new Predicate<WebDriver>(){
			public boolean apply(WebDriver webDriver) {
				return driver.findElement(By.tagName("body")).getText().contains(text);
			}
		 }));
		return false;
	}
	
	/**
	 *  driver.findElement(By.tagName("body")).getText().contains(what);
	 * @param by
	 * @param timeout
	 */
	public boolean waitforTextDisplayed(final String text, int checkTimes, int timeout) {
		 int i=0;
		 boolean flag = false;
		 do{
			 i++;
			 flag = this.waitforTextDisplayed(text, timeout);
		 }while(flag | i>checkTimes);
		 return flag;
	}
	
	
	/**
	 *  driver.findElement(By.tagName("body")).getText().contains(what);
	 * @param by
	 * @param timeout
	 */
	public boolean waitforTextDisappeared(final String text, int timeout) {
		 WebDriverWait wait = new WebDriverWait(driver, timeout);
		 wait.until((new Predicate<WebDriver>(){
			public boolean apply(WebDriver webDriver) {
				return !driver.findElement(By.tagName("body")).getText().contains(text);
			}
		 }));
		return false;
	}
	
	public void typeString(WebElement ele,String value){
		Assert.assertTrue(ele.isEnabled());
//		ele.click();
		ele.clear();
		ele.sendKeys(value);
	}
	
	public void typeString(By by, String str, int timeout) {
		WebElement element = this.waitfor(by, timeout);
		element.sendKeys(str);
	}
	
	public WebElement getElementById(String id) {
		 return this.waitfor(By.id(id), WAIT_TIME_MIN);
	}
	public WebElement getElementByName(String name) {
		return  this.waitfor(By.name(name), WAIT_TIME_MIN);
	}
	public WebElement getElementByXpath(String xpath) {
		return  this.waitfor(By.xpath(xpath), WAIT_TIME_MIN);
	}
	
	public WebElement getElementByLinkText(String linkText) {
		return  this.waitfor(By.linkText(linkText), WAIT_TIME_MIN);
	}
	
	public void typeTextById(String id, String text) {
		 this.getElementById(id).sendKeys(text);
//		 System.out.println("ID - " + this.getElementById(id).getText());
	}
	public void typeTextByName(String name, String text) {
		 this.getElementByName(name).sendKeys(text);
	}
	public void typeTextByXpath(String xpath, String text) {
		 this.getElementByXpath(xpath).sendKeys(text);
	}
	
	public void modifyText(WebElement element,String text) {
		element.clear();
		element.sendKeys(text);
	}
	public void modifyTextById(String id, String text) {
		this.modifyText(this.getElementById(id), text);
	}
	public void modifyTextByName(String name, String text) {
		this.modifyText(this.getElementByName(name), text);
	}
	public void modifyTextByXpath(String xpath, String text) {
		this.modifyText(this.getElementByXpath(xpath), text);
	}
	
	public String getText(){
		return driver.findElement(By.tagName("body")).getText();
	}
	
	public String getValue(WebElement element){
		return element.getText();
	}
	
    public boolean isTextPresent(String what) {
        try {
                return driver.findElement(By.tagName("body")).getText().contains(what);
        } catch (Exception e) {
                return false;
        }
    } 
    
    public void clickElementById(String id){
    	this.getElementById(id).click();
    }
    public void clickElementByName(String name){
    	this.getElementByName(name).click();
    }
    public void clickElementByXpath(String xpath){
    	Assert.assertTrue(this.waitfor(By.xpath(xpath), WAIT_TIME_MIN)!=null);    
    	this.driver.findElement(By.xpath(xpath)).click();
//    	this.getElementByXpath(xpath).click();			
    	
    }
    
    public void clickElementByLinkText(String linkText){
    	this.getElementByLinkText(linkText).click();
    }
    
	public List<WebElement> getElementsByXpath(String  xpath){
		return driver.findElements(By.xpath(xpath));
	}
	
	public void dragAndDrop(WebElement source, WebElement target){
		(new Actions(driver)).dragAndDrop(source, target).perform();
	}
	
	public void dragAndDropBy(WebElement source, int xOffset, int yOffset){
		new Actions(driver).dragAndDropBy(source, xOffset, yOffset).perform();
	}
	
	public void dragAndDropByXOffset(WebElement source, int xOffset){
		new Actions(driver).dragAndDropBy(source, xOffset, 0).perform();
	}
	
	public void dragAndDropByYOffset(WebElement source, int yOffset){
		new Actions(driver).dragAndDropBy(source, 0, yOffset).perform();
	}
	
	public void rightClick(WebElement element){
		new Actions(driver).contextClick(element).perform();
	}
	
	public void doubleClick(WebElement element){
		new Actions(driver).doubleClick(element).perform();
	}
	
	public void release(WebElement element){
		new Actions(driver).release(element).perform();
	}
	
	public void release(){
		new Actions(driver).release().perform();
	}
	
	public void clickAndOnHold(WebElement element){
		new Actions(driver).clickAndHold(element).perform();
	}
	
	public void keyDown(WebElement element, Keys keys){
		new Actions(driver).keyDown(element, keys).perform();
	}
	
	public void keyDown(Keys keys){
		new Actions(driver).keyDown(keys).perform();
	}
	
	public void keyUp(WebElement element, Keys keys){
		new Actions(driver).keyUp(element, keys).perform();
	}
	
	public void keyUp(Keys keys){
		new Actions(driver).keyUp(keys).perform();
		
	}
	
	public void moveToElement(WebElement element){
		new Actions(driver).moveToElement(element).perform();
	}
	
	public void moveToElement(WebElement element, int xOffset, int yOffset){
		new Actions(driver).moveToElement(element, xOffset, yOffset).perform();
	}
	
	public void moveToElement(int xOffset, int yOffset){
		new Actions(driver).moveByOffset(xOffset, yOffset).perform();
	}
	
	
	public void acceptAlert(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Alert alert = driver.switchTo().alert();
		System.out.println(driver.switchTo().alert().getText());
		alert.accept();
	}
	public void acceptAlert(String allertMessage){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Alert alert = driver.switchTo().alert();
		Assert.assertTrue((driver.switchTo().alert().getText().contains(allertMessage)),"allert wrong message!");
		alert.accept();
	}
	
	public void dismissAlert(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Alert alert = driver.switchTo().alert();
		System.out.println(driver.switchTo().alert().getText());
		alert.dismiss();
	}
	
	
	
	public void windowMaximize(){
        Toolkit toolkit =  Toolkit.getDefaultToolkit ();
        java.awt.Dimension dim = toolkit.getScreenSize();
        Dimension dimension =  new Dimension(dim.width, dim.height);
        driver.manage().window().setSize(dimension);
	}
	
	public void captureScreenshot(String filename){
        try {
        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(screenShot, "JPG", new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AWTException e) {
			e.printStackTrace();
		} 
	}
	
	public void onTestListener(ITestContext context, final String imgFilePath){
		TestRunner runner = (TestRunner) context;
		runner.addListener(new TestListenerAdapter(){
			@Override
			public void onTestFailure(ITestResult tr) {
				Reporter.setCurrentTestResult(tr);
				
				String testCaseInfo = this.getTestCaseInfo(tr);
				
				String methodName = tr.getMethod().getMethodName();
				int lineNumber = 0;
				for(StackTraceElement element: tr.getThrowable().getStackTrace()) {
					if(methodName.equals(element.getMethodName())) {
						lineNumber = element.getLineNumber();
					}
				}
				String name = testCaseInfo + "_" + lineNumber + ".png";
				try {
					captureScreenshot(imgFilePath + File.separator + name);
					System.out.println(imgFilePath + File.separator + name);
				} catch (Exception e) {
				}
				
				this.setTestCaseResultInfo(failedTestCases, testCaseInfo, Result.f);
			}
			
			
			@Override
			public void onTestSuccess(ITestResult tr) {
				super.onTestSuccess(tr);
				Reporter.setCurrentTestResult(tr);
				String testCaseInfo = this.getTestCaseInfo(tr);
				this.setTestCaseResultInfo(successTestCases, testCaseInfo, Result.p);
			}
			
			@Override
			public void onTestStart(ITestResult tr) {
				String testCaseInfo = this.getTestCaseInfo(tr);
				try {
					testCaseScreenRecorder = testCaseRecorder.getScreenRecorder(getAbsoluteFolderPath("org/talend/mdm/download") + "/" + testCaseInfo);
					logger.info(getAbsoluteFolderPath("org/talend/mdm/download") + "/" + testCaseInfo);
					
					if(testCaseScreenRecorder ==null) {
						logger.info("testCaseScreenRecorder = null");
					}
					testCaseScreenRecorder.start();
				} catch (Exception e) {
					logger.info(e.getMessage());
					e.printStackTrace();
				}

				super.onTestStart(tr);
			}
			
			@Override
			public void onFinish(ITestContext testContext) {
				try {
					if(testCaseScreenRecorder != null) {
						testCaseScreenRecorder.stop();
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					testCaseScreenRecorder = null;
				}
				super.onFinish(testContext);
			}
			
			public String getTestCaseInfo(ITestResult tr) {
				IClass clazz = tr.getTestClass();
				
				String className = clazz.getRealClass().getSimpleName();
				
				String methodName = tr.getMethod().getMethodName();
				
				String parameter = "";
				
				try {
					for(Object param : tr.getParameters()) {
						String par = (String)param;
						parameter = parameter + ",'" + par.replaceAll("/", "_")+"'"; 
					}
				} catch (Exception ex) {
					for(Object param : tr.getParameters()) {
					}
					ex.printStackTrace();
				}
				
				if(parameter!=null && !"".equals(parameter.trim())){
					parameter = parameter.substring(1);
				}
				
				return className + "." + methodName + "(" + parameter + ")";
			}
			
			public void setTestCaseResultInfo(List<TestCase> testcases, String testCaseInfo, Result result) {
				TestCase testCase = new TestCase();
				
				String testlinkProject = System.getProperty("testlink.porject");
				String testlinkId = System.getProperty("testlink.id");
				int id = Integer.parseInt(testlinkId.substring(testlinkProject.length()+1));
				testCase.setId(id);
				
				testCase.setResult(result);
				testCase.setNote(testCaseInfo + " !");
				testCase.setComment(testCaseInfo);
				testcases.add(testCase);
			}
		}); 
		
	}
	
	/**
	 * split parameter to an array
	 * @param parameter
	 * @return an array
	 */
	public String[] splitParameter(String parameter){
		String[] parameters = parameter.split(",");
		return parameters;
	}
	
	public String getString(ResourceBundle locator, String key, String[] params) {
		String value = locator.getString(key);

		for (int i = 0; i < params.length; i++) {
			Pattern pattern = Pattern.compile(".*{" + i + "}.*");
			Matcher matcher = pattern.matcher(value);
			if (matcher.matches()) {
				value = value.replace("{" + i + "}", params[i]);
			}
		}
		return value;
	}

	public String getString(ResourceBundle locator,String key, String param) {
		if ("".equals(param) || param == null) {
			return locator.getString(key);
		} else {
			return this.getString(locator, key, new String[] { param });
		}
	}
	
	public String getAbsoluteFolderPath(String folder) {
		String path = Base.class.getClassLoader().getResource(folder).getPath();
		if(System.getProperty("os.name").startsWith("Windows")) {
			if(path.startsWith("/")){
				path = path.substring(1);
			}
			path = path.replace("/", "\\");
		}
		return path;
	}
	
	public void seletDropDownList(By by,String option){
		
		Assert.assertTrue(this.isElementPresent(by, 3000));
		Assert.assertTrue(this.waitfor(by, 50)!=null);
//		this.clickElementByXpath(locator.getString("xpath.datatewardship.administration.createtask.panel.taskproperties.tasktype.arrow"));	
		this.waitfor(by, WAIT_TIME_MIN).click();
//		this.clickElementByXpath(locator.getString("xpath.datatewardship.administration.createtask.panel.taskproperties.tasktype.arrow"));		
		this.isElementPresent(By.xpath("//div[contains(@class,'x-combo-list-item') and contains(text(),'"+option+"')]"),WAIT_TIME_MAX);
		this.clickElementByXpath("//div[contains(@class,'x-combo-list-item') and contains(text(),'"+option+"')]");
	
	}
	
	public String getValueInput(By by){
		return this.waitfor(by, WAIT_TIME_MIN).getAttribute("value");
	}
}
