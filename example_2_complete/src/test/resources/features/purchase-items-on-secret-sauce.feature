@selenium
Feature: Purchase items on secret sauce

	Background: Secret sauce home page
		Given the secret sauce login page
		And the user with the username standard_user
		And the password secret_sauce
		And the forename bobby
		And the surname pickles
		And the postcode PINE123
		And the user is logged in

		Scenario: Successful purchase of items
			When the user adds items to the cart
				| Sauce Labs Backpack 	|
				| Sauce Labs Bike Light |
			And the user navigates to the cart
			And the user proceeds to checkout
			And the user enters their details
			And the user proceeds to checkout overview
			And the user confirms the transaction
			Then a purchase verification should appear on the screen saying THANK YOU FOR YOUR ORDER
		