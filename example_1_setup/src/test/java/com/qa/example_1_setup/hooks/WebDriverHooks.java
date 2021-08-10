package com.qa.example_1_setup.hooks;

import org.openqa.selenium.WebDriver;

import com.qa.example_1_setup.utilities.WebDriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebDriverHooks {

	private WebDriver webDriver;

	@Before("@selenium")
	public void setup() throws Exception {
		if (webDriver == null) {
			webDriver = WebDriverFactory.getDriver();
		}
	}

	@After("@selenium")
	public void teardown() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}
}
