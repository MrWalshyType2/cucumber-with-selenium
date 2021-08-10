package com.qa.example_2_complete.pages.secret_sauce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	@FindBy(id = "user-name")
	private WebElement usernameInputField;

	@FindBy(id = "password")
	private WebElement passwordInputField;

	@FindBy(id = "login-button")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
		driver.get("https://www.saucedemo.com/");

		if (!driver.getTitle().equals("Swag Labs")) {
			throw new IllegalStateException("Page did not load");
		}
	}

	public StorePage login(String username, String password) {
		usernameInputField.sendKeys(username);
		passwordInputField.sendKeys(password);

		loginButton.submit();
		
		return PageFactory.initElements(driver, StorePage.class);
	}
}
