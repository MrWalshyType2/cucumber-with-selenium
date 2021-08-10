package com.qa.example_2_complete.pages.secret_sauce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StorePage {
	
	private WebDriver driver;

	@FindAll({
		@FindBy(className = "inventory_item")
	})
	private List<WebElement> itemsOnPage;
	
	@FindBy(className = "shopping_cart_link")
	private WebElement shoppingCartButton;
	
	public StorePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addItemToCart(String itemName) {
		itemsOnPage.stream()
				   .filter(element -> getItemTitle(element).equals(itemName))
				   .findFirst()
				   .orElseThrow()
				   .findElement(By.tagName("button"))
				   .click();
		
//		itemsOnPage.iterator().forEachRemaining(element -> {
//			String title = getItemTitle(element);
//			
//			if (title.equals(itemName)) {
//				WebElement addToCartButton = element.findElement(By.tagName("button"));
//				addToCartButton.click();
//			}
//		});
	}
	
	public CartPage navigateToCart() {
		shoppingCartButton.click();
		
		return PageFactory.initElements(driver, CartPage.class);
	}
	
	private String getItemTitle(WebElement element) {
		return element.findElement(By.className("inventory_item_name"))
				  	  .getText();
	}
}
