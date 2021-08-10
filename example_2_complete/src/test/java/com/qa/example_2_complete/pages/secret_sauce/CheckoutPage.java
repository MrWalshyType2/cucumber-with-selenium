package com.qa.example_2_complete.pages.secret_sauce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	private WebDriver driver;

	@FindBy(id = "first-name")
	private WebElement forenameInputField;
	
	@FindBy(id = "last-name")
	private WebElement surnameInputField;
	
	@FindBy(id = "postal-code")
	private WebElement postalcodeInputField;

	@FindBy(id = "continue")
	private WebElement continueToOverviewButton;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillForm(String forename, String surname, String postCode) {
		forenameInputField.sendKeys(forename);
		surnameInputField.sendKeys(surname);
		postalcodeInputField.sendKeys(postCode);
	}
	
	public CheckoutOverviewPage navigateToCheckoutOverview() {
		continueToOverviewButton.click();
		
		return PageFactory.initElements(driver, CheckoutOverviewPage.class);
	}
	
}
