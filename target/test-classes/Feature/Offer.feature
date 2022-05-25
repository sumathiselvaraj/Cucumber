Feature: Verifying Product in OfferPage 

Background: User is in landing page 
	Given User lands in Green Cart Home Page 
	When User click Top deal link 
	Then User lands on offer page 
	
Scenario Outline: Verify product in offerpage 

	Given User lands on offer page
	When User search the product with <Name> in deals 
	Then User check if the product exists 
	
	Examples: 
		| Name |
		| Tom  |
		| Beet |
	
		
		
