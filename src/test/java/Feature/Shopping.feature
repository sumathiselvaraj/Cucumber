Feature: Verifying and Selecting Product 

@productName
Scenario Outline: User verify product in landing page 

	Given User lands in Green Cart Home Page 
	When User search the product with shortname <Name> 
	Then User exctract the actual name of the product 
	
	Examples: 
		| Name  |
		| Tom 	|
		| Beet  |
		
		
