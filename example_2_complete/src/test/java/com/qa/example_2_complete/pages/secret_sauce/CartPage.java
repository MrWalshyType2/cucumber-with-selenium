package com.qa.example_2_complete.pages.secret_sauce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	private WebDriver driver;
	
	@FindBy(id = "checkout")
	private WebElement checkoutButton;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public CheckoutPage navigateToCheckout() {
		checkoutButton.click();
		
		return PageFactory.initElements(driver, CheckoutPage.class);
	}
}
