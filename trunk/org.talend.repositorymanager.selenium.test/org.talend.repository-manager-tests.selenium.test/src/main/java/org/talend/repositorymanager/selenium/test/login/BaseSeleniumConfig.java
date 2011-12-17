package org.talend.repositorymanager.selenium.test.login;

import com.thoughtworks.selenium.SeleneseTestCase;

public class BaseSeleniumConfig extends SeleneseTestCase {

	private static String application_server = "localhost";
	private static String port = "8080";
	private static String browser = "*firefox";
	private static String url = "/RepoMngGxt/";

	public void setUp() throws Exception {
		setUp("http://" + application_server + ":" + port, browser);
	}

	public static String getUrl() {
		return url;
	}
}
