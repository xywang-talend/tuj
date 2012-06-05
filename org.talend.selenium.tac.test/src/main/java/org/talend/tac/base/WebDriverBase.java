package org.talend.tac.base;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.TestRunner;

import com.google.common.base.Predicate;
import com.talend.tac.base.Base;

public class WebDriverBase {
	public Logger logger  =  Logger.getLogger(this.getClass());
	public Locale currentLocale = new Locale("en", "US"); // set the locale that
	// you want to test
	public ResourceBundle rb = ResourceBundle.getBundle("messages",currentLocale);
	
	public ResourceBundle other = ResourceBundle.getBundle("other",currentLocale);
	
	public final static int WAIT_TIME_MIN =100;
	public final static int WAIT_TIME_MID = 300;
	public final static int WAIT_TIME_MAX = 5000;
	
	private static boolean onHudson = false;
	
	
	public WebDriver driver;
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitfor(final By by, int timeout) {
		 WebElement element = null;
		 
		 WebDriverWait wait = new WebDriverWait(driver, timeout);

		 try {
			 element = wait.until(new ExpectedCondition<WebElement>(){
				    public WebElement apply(WebDriver d) {
				     return d.findElement(by);
				    }});
		} catch (Exception e) {
			System.out.println("Couldn't find the element - " + by);
		}
		return element;
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
	
	public boolean isElementPresent(By by, int timeout) {
		if(this.waitfor(by, timeout) == null) {
			return false;
		} else {
			return true;
		}
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
    	this.getElementByXpath(xpath).click();
    }
    
    public void clickElementByLinkText(String linkText){
    	this.getElementByLinkText(linkText).click();
    }
    
	public List<WebElement> getElementsByXpath(String  xpath){
		return driver.findElements(By.xpath(xpath));
	}
	
	public void dragAndDrop(WebElement source, WebElement target){
		logger.info("click and on hold referecepro");
		this.clickAndOnHold(source);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("move refpro to commpro-trunk");
		this.moveToElement(target);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.release();
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
	
	public void dismissAlert(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert = driver.switchTo().alert();
		System.out.println(driver.switchTo().alert().getText());
		alert.dismiss();
	}
	
	
	public void windowMaximize(){
        Window window = driver.manage().window();
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
	
	public void onTestFailure(ITestContext context, final String imgFilePath){
		TestRunner runner = (TestRunner) context;
		runner.addListener(new TestListenerAdapter(){
			@Override
			public void onTestFailure(ITestResult tr) {
				
				Reporter.setCurrentTestResult(tr);
				IClass clazz = tr.getTestClass();
				
				String className = clazz.getName();
				String methodName = tr.getMethod().getMethodName();
				
				String parameter = "";
				for(Object param : tr.getParameters()) {
					String par = (String)param;
					parameter = parameter + ",'" + par.replaceAll("/", "|")+"'"; 
				}
				if(parameter!=null && !"".equals(parameter.trim())){
					parameter = parameter.substring(1);
				}
				
				int lineNumber = 0;
				for(StackTraceElement element: tr.getThrowable().getStackTrace()) {
					if(methodName.equals(element.getMethodName())) {
						lineNumber = element.getLineNumber();
					}
				}
				
				String name = className + "." + methodName + "(" + parameter + ")_" + lineNumber + ".png";
				
//				String url = getAbsolutePath("org/talend/tac/folder/screen");
				
				try {
					captureScreenshot(imgFilePath + File.separator + name);
					System.out.println(imgFilePath + File.separator + name);
				} catch (Exception e) {
				}
				
			}
		}); 
		
	}
	
	
	/**
	 * get the Uniform Resource Locator of the filePath
	 * @param filePath
	 * @return
	 */
	public URL getfileURL(String filePath){
		URL fileUrl = null;
//		String onHudson = System.getProperty("tests.on.hudson");
		try {
			if(this.isOnHudson()) {
				fileUrl = new File(System.getProperty("selenium.target.src") + File.separator + filePath).toURL();
			} else {
				fileUrl = Base.class.getClassLoader().getResource(filePath);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println("URL -- " + fileUrl);
		return fileUrl;
	}
	
	/**
	 * @param filePath
	 * @return
	 */
	public String parseRelativePath(String filePath){
		System.out.println("path before:     "+filePath);
		System.out.println("path after:     "+getfileURL(filePath).toString());
		return this.getfileURL(filePath).toString();
	}
	
	/**
	 * get absolute path of the filePath
	 * @param filePath
	 * @return
	 */
	public String getAbsolutePath(String filePath) {
		return this.getfileURL(filePath).getPath();
	}
	
	public boolean isOnHudson(){
		String testsOnHudson = System.getProperty("tests.on.hudson");
		if(testsOnHudson != null && !"".equals(testsOnHudson.trim())) {
			onHudson = true;
		}
		return onHudson;
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
	
	public void selectDropDownList(String id, String value) {
         
	   getElementByXpath("//input[@id='"+id+"']//following-sibling::div").click();
       getElementByXpath("//div[text()='"+value+"']").click();
        
    }
	
}
