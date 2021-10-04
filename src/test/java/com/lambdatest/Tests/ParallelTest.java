package com.lambdatest.Tests;

import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.LinkedList;

import org.junit.runners.Parameterized;


@RunWith(Parallelized.class)
public class ParallelTest {

	public String platform;
	public String browserName;
	public String browserVersion;
	public static WebDriver driver;
	public static String status = "failed";


	@Parameterized.Parameters
	public static LinkedList<String[]> getEnvironments() throws Exception {
		LinkedList<String[]> env = new LinkedList<String[]>();
		env.add(new String[] { "Windows 10", "chrome", "latest" });
		env.add(new String[] { "Windows 10", "firefox", "latest" });
		env.add(new String[] { "Windows 7", "internet explorer", "latest" });

		// add more browsers here

		return env;
	}

	public ParallelTest(String platform, String browserName, String browserVersion) {

		this.platform = platform;
		this.browserName = browserName;
		this.browserVersion = browserVersion;
	}

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability(CapabilityType.BROWSER_NAME, this.browserName);
		capability.setCapability(CapabilityType.VERSION, this.browserVersion);
		capability.setCapability(CapabilityType.PLATFORM, this.platform);
		capability.setCapability("build", "Junit Parallel Tests");
		capability.setCapability("name", "JUnit Parallel");

		// Set you LAMBDATEST Username here if not Provided from Jenkins
		String username = Configuration.readConfig("LambdaTest_UserName");

		// Set you LAMBDATEST AppKey here if not Provided from Jenkins
		String accesskey = Configuration.readConfig("LambdaTest_AppKey");

		String gridURL = "https://" + username + ":" + accesskey + "@hub.lambdatest.com/wd/hub";

		driver = new RemoteWebDriver(new URL(gridURL), capability);
	}

	@Test
	public void test() throws InterruptedException {
		// Launch the app
		driver.get("https://lambdatest.github.io/sample-todo-app/");
		Thread.sleep(3000);
		status = "passed";
	}

	@After
	public void tearDown() throws Exception {
		if (driver != null)
			driver.quit();
	}

	public WebDriver getWebDriver() {
		return driver;
	}
}