package com.qa.example_2_complete;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.example_2_complete.hooks.WebDriverHooks;
import com.qa.example_2_complete.pages.secret_sauce.LoginPage;
import com.qa.example_2_complete.pages.secret_sauce.PageRepository;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SecretSaucePurchaseItemsStepDefinitions {
	
	private WebDriver driver;
	
	private String username;
	private String password;
	private String forename;
	private String surname;
	private String postcode;
	
	private PageRepository pages;
	
	public SecretSaucePurchaseItemsStepDefinitions(WebDriverHooks hooks) {
		this.driver = hooks.getWebDriver();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		this.pages = new PageRepository();
	}

	@Given("the secret sauce login page")
	public void theSecretSauceLoginPage() {
	    pages.loginPage = PageFactory.initElements(driver, LoginPage.class);
	}

	@Given("the user with the username {word}")
	public void theUserWithTheUsername(String username) {
	    this.username = username;
	}

	@Given("the password {word}")
	public void thePassword(String password) {
	    this.password = password;
	}

	@Given("the forename {word}")
	public void theForename(String forename) {
	    this.forename = forename;
	}

	@Given("the surname {word}")
	public void theSurname(String surname) {
	    this.surname = surname;
	}

	@Given("the postcode {word}")
	public void thePostcode(String postcode) {
	    this.postcode = postcode;
	}

	@Given("the user is logged in")
	public void theUserIsLoggedIn() {
	    pages.storePage = pages.loginPage
	    					   .login(username, password); 
	}

	@When("the user adds items to the cart")
	public void theUserAddsItemsToTheCart(List<String> items) {
	    for (String item : items) {
	    	pages.storePage
	    	     .addItemToCart(item);
	    }
	}

	@When("the user navigates to the cart")
	public void theUserNavigatesToTheCart() {
	    pages.cartPage = pages.storePage
	    		              .navigateToCart();
	}

	@When("the user proceeds to checkout")
	public void theUserProceedsToCheckout() {
	    pages.checkoutPage = pages.cartPage
	    						  .navigateToCheckout();
	}

	@When("the user enters their details")
	public void theUserEntersTheirDetails() {
	    pages.checkoutPage
	         .fillForm(forename, surname, postcode);
	}

	@When("the user proceeds to checkout overview")
	public void theUserProceedsToCheckoutOverview() {
	    pages.checkoutOverviewPage = pages.checkoutPage
		         						  .navigateToCheckoutOverview();
	}

	@When("the user confirms the transaction")
	public void theUserConfirmsTheTransaction() {
	    pages.checkoutCompletePage = pages.checkoutOverviewPage
		    	 						  .completeTransaction();
	}

	@Then("a purchase verification should appear on the screen saying {}")
	public void aPurchaseVerificationShouldAppearOnTheScreenSaying(String expected) {
	    boolean orderSuccess = pages.checkoutCompletePage
		         					.didOrderComplete(expected);
	    assertTrue(orderSuccess);
	}
}
