Feature: Placing Order
Background: User verify product in landing page  
	Given User lands in Green Cart Home Page 
	When User search the product with shortname "Tom"
	Then User exctract the actual name of the product 
	
	
	@checkoutpage
	Scenario Outline: User increments his product quantity
	
	Given User exctract the actual name of the product 
	When User increments his product quantity to <no of items> and proceed to checkout
	Then  verify product quantity, promocode and placeorder button
	
	
	Examples:
	| no of items |
	|    3        |
	
   
    
  