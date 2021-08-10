package com.qa.example_2_complete.pages.secret_sauce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {

	private WebDriver driver;
	
	@FindBy(id = "finish")
	private WebElement finishTransactionButton;

	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public CheckoutCompletePage completeTransaction() {
		finishTransactionButton.click();
		
		return PageFactory.initElements(driver, CheckoutCompletePage.class);
	}
}
