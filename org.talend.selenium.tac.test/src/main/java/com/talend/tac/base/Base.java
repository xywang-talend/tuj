package com.talend.tac.base;

import java.awt.Event;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.testng.Assert;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.TestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class Base {
	public Selenium selenium;

	public Locale currentLocale = new Locale("en", "US"); // set the locale that
															// you want to test
	public ResourceBundle rb = ResourceBundle.getBundle("messages",
			currentLocale);

	public ResourceBundle other = ResourceBundle.getBundle("other",
			currentLocale);

	public static String MID_SPEED = "3000";
	public static String MIN_SPEED = "0";
	public static String MAX_SPEED = "5000";
	public static int WAIT_TIME = 80;
	public static int MAX_WAIT_TIME = 500;
	
	private static boolean onHudson = false;
	private static String zookeeperPath ="";

	@BeforeClass
	@Parameters({ "server", "port", "browser", "url", "language", "country",
			"root" })
	public void initSelenium(String server, String port, String browser,
			String url, String language, String country, String root, ITestContext context) {
		
		server = this.setDefaultValue("localhost", System.getProperty("selenium.server"), server);
//		server = this.setDefaultValue(server, "localhost");
		
		port = this.setDefaultValue(port, 4444 + "");
		
		browser = this.setDefaultValue("*firefox", System.getProperty("selenium.browser"), browser);
//		browser = this.setDefaultValue(browser, "*firefox");
		
		url = this.setDefaultValue("http://localhost:8080/", System.getProperty("tomcat.url"), url);
//		url = this.setDefaultValue(url, "http://localhost:8080/");
		
		root = this.setDefaultValue(root, "/org.talend.administrator/");

		language = this.setDefaultValue(language, "en");
		country = this.setDefaultValue(country, "US");
		currentLocale = new Locale(language, country);
		rb = ResourceBundle.getBundle("messages", currentLocale);

		System.out.println("Server: " + server + ", port: " + port
				+ ", browser: " + browser + ", " + url);
		System.out.println("language: " + language + ", country: " + country);
		
		if(null == System.getProperty("webdriver.firefox.bin.path") || "".equals(System.getProperty("webdriver.firefox.bin.path").trim()) || System.getProperty("webdriver.firefox.bin.path").trim().contains("webdriver.firefox.bin.path")) {
			selenium = new DefaultSelenium(server, Integer.parseInt(port), browser,
					url); // 4444 is default server port
		} else{
			selenium = new DefaultSelenium(server, Integer.parseInt(port), browser+" "+ System.getProperty("webdriver.firefox.bin.path").trim(),
					url); // 4444 is default server port
			System.setProperty("webdriver.firefox.bin", System.getProperty("webdriver.firefox.bin.path").trim());
		}
		


		selenium.start();
		selenium.open(root);
		
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
				
//				System.out.println("name -- " + name);
				String url = getAbsolutePath("org/talend/tac/folder/screen");
//				System.out.println("url -" + url);
				
				try {
					selenium.captureScreenshot(url + File.separator + name);
					System.out.println(url + File.separator + name);
				} catch (Exception e) {
				}
				
			}
		}); 
	}

	public boolean isOnHudson(){
		String testsOnHudson = System.getProperty("tests.on.hudson");
		if(testsOnHudson != null && !"".equals(testsOnHudson.trim())) {
			onHudson = true;
		}
		return onHudson;
	}
	
	public boolean isWindows(){
		return System.getProperty("os.name").contains("Windows");
	}

	
	public String setDefaultValue(String variable, String value) {
		String setValue = variable;
		if ("".equals(variable) || variable == null) {
			setValue = value;
		}
		return setValue;
	}

	/**
	 * Get value one by one, if one of value is not null and "" return.
	 * If all of them doesn't set, return the default value
	 * @param defaultValue
	 * @param values
	 * @return
	 */
	public String setDefaultValue(String defaultValue, String...values ){
		
		String setValue = "";
		
		for(int i=0; i<values.length-1; i++) {
			setValue = this.setDefaultValue(values[i], values[i+1]);
			System.out.println("The " + i + " value =" + setValue);
			if(!"".equals(setValue)) {
				break;
			}
		}
		if("".equals(setValue)) {
			setValue = defaultValue;
		}
		System.out.println("Finally =" + setValue);
		return setValue;
	}
	
	public String getString(String key, String[] params) {
		String value = rb.getString(key);

		for (int i = 0; i < params.length; i++) {
			Pattern pattern = Pattern.compile(".*{" + i + "}.*");
			Matcher matcher = pattern.matcher(value);
			if (matcher.matches()) {
				value = value.replace("{" + i + "}", params[i]);
			}
			// System.out.println(value);
		}
		return value;
	}

	public String getString(String key, String param) {
		if ("".equals(param) || param == null) {
			return rb.getString(key);
		} else {
			return this.getString(key, new String[] { param });
		}

	}
	
	public boolean waitForTextPresent(String text,int seconds){
		boolean present = true;
		for (int second = 0;; second++) {
			if (second >= seconds){
				// org.testng.Assert.fail("wait for element "+ locator +
				// " to be present,time out");
				present = false;
				break;
			}
			try {
				if (selenium.isTextPresent(text))
					break;
			} catch (Exception e) {
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return present;
	}
	
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
	
	public boolean waitElement(String element,int seconds){
		boolean present = true;
		for (int second = 0;; second++) {
			if (second >= seconds){
				// org.testng.Assert.fail("wait for element "+ locator +
				// " to be present,time out");
				present = false;
				break;
			}
			try {
				if (selenium.isElementPresent(element))
					break;
			} catch (Exception e) {
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return present;
	}

	public void waitForElementPresent(String locator, int seconds) {
		for (int second = 0;; second++) {
			if (second >= seconds)
				// org.testng.Assert.fail("wait for element "+ locator +
				// " to be present,time out");
				org.testng.Assert
						.assertTrue(selenium.isElementPresent(locator));
			try {
				if (selenium.isElementPresent(locator)||selenium.isTextPresent(locator))
					break;
			} catch (Exception e) {
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void clickWaitForElementPresent(String locator) {
		this.waitForElementPresent(locator, Base.WAIT_TIME);
		selenium.click(locator);
	}
	public void mouseDownWaitForElementPresent(String locator) {
		this.waitForElementPresent(locator, Base.WAIT_TIME);
		selenium.mouseDown(locator);
	}
	
	public void mouseDownWaitForElementPresent(String locator, int timeout) {
		this.waitForElementPresent(locator, timeout);
		selenium.mouseDown(locator);
	}
	
	public void typeWaitForElementPresent(String locator,String value) {
		this.waitForElementPresent(locator, Base.WAIT_TIME);
		selenium.type(locator,value);
	}
	
	
	/**
	 * find the first String which match regex
	 * 
	 * @param regex
	 * @return
	 */
	public String findSpecialMachedString(String regex) {
		String findedString = "";
		String[] texts;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;

		String text = selenium.getBodyText();
		texts = text.split("\n");
		for (int i = 0; i < texts.length; i++) {
			// System.out.println("text " + i +": " + texts[i]);
			matcher = pattern.matcher(texts[i].trim());
			if (matcher.matches()) {
				findedString = texts[i].trim();
				break;
				// System.out.println(texts[i].trim());
			}
		}
		return findedString;
	}

	/**
	 * find the first String which match regex
	 * 
	 * @param regex
	 * @return
	 */
	public String findSpecialMachedString(String text, String regex) {
		String findedString = "";
		String[] texts;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;

		texts = text.split("\n");
		for (int i = 0; i < texts.length; i++) {
			// System.out.println("text " + i +": " + texts[i]);
			matcher = pattern.matcher(texts[i].trim());
			if (matcher.matches()) {
				findedString = texts[i].trim();
				break;
				// System.out.println(texts[i].trim());
			}
		}
		return findedString;
	}
	
	/**
	 * find the Strings which match regex
	 * 
	 * @param regex
	 * @return
	 */
	public List<String> findSpecialMachedStrings(String regex) {
		List<String> strs = new ArrayList<String>();
		String findedString = "";
		String[] texts;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;

		String text = selenium.getBodyText();
		// System.out.println(text);
		texts = text.split("\n");
		for (int i = 0; i < texts.length; i++) {
			// System.out.println("text " + i +": " + texts[i]);
			matcher = pattern.matcher(texts[i].trim());
			if (matcher.matches()) {
				findedString = texts[i].trim();
				strs.add(findedString);
				// System.out.println(texts[i].trim());
				continue;
			}
		}
		return strs;
	}

	/**
	 * find the Strings which match regex, except the strings match exceptRegex
	 * 
	 * @param regex
	 * @return
	 */
	public List<String> findSpecialMachedStrings(String regex,
			String exceptRegex) {
		List<String> strs = new ArrayList<String>();
		String findedString = "";
		String[] texts;
		Pattern pattern = Pattern.compile(regex);
		Pattern exceptPattern = Pattern.compile(exceptRegex);
		Matcher matcher;
		Matcher exceptMatcher;

		String text = selenium.getBodyText();
		texts = text.split("\n");

		for (int i = 0; i < texts.length; i++) {
			findedString = texts[i].trim();
			// System.out.println("text " + i +": " + texts[i]);
			matcher = pattern.matcher(findedString);
			exceptMatcher = exceptPattern.matcher(findedString);

			if (matcher.matches() && !exceptMatcher.matches()) {
				strs.add(findedString);
				// System.out.println(texts[i].trim());
				continue;
			}
		}
		return strs;
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
	
	public void typeAndBlur(String xpath, String value) {
		this.typeAndFireEnvent(xpath, value, "blur");
	}
	
	public void typeString(String xpath, String value) {
		selenium.click(xpath);
		this.typeAndFireEnvent(xpath, value, "blur");
	}
	
	public void typeAndFireEnvent(String xpath,String value, String event) {
		selenium.type(xpath, value);
		selenium.fireEvent(xpath, event);
	}
	
	public void sleep(int times){
		try {
			Thread.sleep(times);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectDropDownList(String xpath, int item) {
//		selenium.click("//input[@id='"+xpath+"']"
//				+ "/following-sibling::div[@class='x-form-trigger x-form-trigger-arrow ']");
//		selenium.click("//label[text()='Type:']/parent::div//div[@class='x-form-trigger x-form-trigger-arrow']");
//		selenium.click("//input[@id='"+xpath+"']/following-sibling::div[@class='x-form-trigger x-form-trigger-arrow']");
		selenium.click(xpath+"/following-sibling::div[@class='x-form-trigger x-form-trigger-arrow']");
		selenium.mouseDownAt("//div[@role='listitem'][" + item + "]", ""
				+ Event.ENTER);
	}

	public void clickDropDownList(String id){
		if(selenium.isElementPresent("//input[@id='"+id+"']"
				+ "/following-sibling::div")) {
			
			selenium.click("//input[@id='"+id+"']"
					+ "/following-sibling::div");
			
		} else {
			
			selenium.click("//input[@id='"+id+"']"
					+ "/following-sibling::img");
			
		}
	}
	
	public void selectDropDownList(String id, String itemName) {
		
		boolean waitInput = selenium.isElementPresent("//input[@id='"+id+"' and @disabled='']");
		
		int i =0;
		while (waitInput==true && i<=WAIT_TIME) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			waitInput = selenium.isElementPresent("//input[@id='"+id+"' and @disabled='']");
			
			if(waitInput == true) {
								
				System.out.println("waiting input appear ...");
				
			}			
			
		}
		
		if(selenium.isElementPresent("//input[@id='"+id+"']"
				+ "/following-sibling::div")) {
			selenium.click("//input[@id='"+id+"']"
					+ "/following-sibling::div");
		} else {
			selenium.click("//input[@id='"+id+"']"
					+ "/following-sibling::img");
		}
		
		this.waitForElementPresent("//div[text()='" + itemName + "' and @role='listitem']", WAIT_TIME);
		selenium.mouseDown("//div[text()='" + itemName + "' and @role='listitem']");
		selenium.fireEvent("//input[@id='"+id+"']", "blur");

	}
	
public void selectDropDownListByClickArrow(String arrowXpath, String itemName,String classXpath) {
		
	    this.clickWaitForElementPresent(arrowXpath);
		this.waitForElementPresent("//div[contains(@class,'"+classXpath+"') and text()='"+itemName+"']", WAIT_TIME);
		selenium.mouseDown("//div[contains(@class,'"+classXpath+"') and text()='"+itemName+"']");
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
	
	/**
	 * get path of zookeeper
	 * @return
	 */
	public String getZookeeperPath(){
		if(this.isOnHudson()) {
			zookeeperPath = this.setDefaultValue(System.getProperty("zookeeper.path"), zookeeperPath);
		}
		return zookeeperPath;
	}
	
	/**
	 * check pdf contains the info or not
	 * @param pdfPath
	 * @param text
	 * @param caseSensitive
	 * @return
	 */
	public boolean isExistedInfoInPdf(String pdfPath, String text, boolean caseSensitive){
		boolean isExist = false;
		String result = null;  
		PDDocument document = null; 
		FileInputStream is = null;
		PDFTextStripper stripper;
		try {
			is = new FileInputStream(pdfPath);  
			PDFParser parser = new PDFParser(is);  
			parser.parse();  
			document = parser.getPDDocument();
			stripper = new PDFTextStripper();
			if(caseSensitive){
				result = stripper.getText(document);
				isExist = result.contains(text);
			} else{
				result = stripper.getText(document).toLowerCase();
				isExist = result.contains(text.toLowerCase());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {  
			if (is != null) {  
				try {  
					is.close();  
				} catch (IOException e) {  
					e.printStackTrace();  
				}  
			}  
			if (document != null) {  
				try {  
					document.close();  
				} catch (IOException e) {  
					e.printStackTrace();  
				}  
			}  
		} 
		return isExist;
	}
	/**
	 * check pdf contains the info or not, case insensitive
	 * @param pdfPath
	 * @param text
	 * @return
	 */
	public boolean isExistedInfoInPdf(String pdfPath, String text){
		return this.isExistedInfoInPdf(pdfPath, text, false);
	}

}
