package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OfferPage;
import pages.ShoppingPage;
import testUtils.TestSetUp;

public class OfferStepDef {

	TestSetUp testsetup;
	OfferPage dealPg;
	ShoppingPage shopPg;
	public String dealProduct;

	public OfferStepDef(TestSetUp testsetup) {

		this.testsetup = testsetup;
		this.dealPg = testsetup.pgMngr.getOfferPage();
		this.shopPg = testsetup.pgMngr.getShoppingPage();
		
	}

			
	// ********** Dynamic step ,so step starts with ^ and ends with $
	// **************//
	// ********** Also < Name > indicates the value changes , so it is represented
	// as (.+) ********* //

	@When("^User search the product with (.+) in deals$")
	public void user_search_the_product_with_in_deals(String shortname) throws InterruptedException {
		testsetup.gUtil.windowHandle();
		dealPg.searchItem(shortname);;
		//System.out.print(shortname); 
		Thread.sleep(1000);
		dealProduct = dealPg.getProductName().split("-")[0].trim();
		System.out.println(dealProduct);
		
//		if(shortname.equals("Tom"))
//		{
//			System.out.print("Tomato :" + dealProduct);
//			
//		}
//		
//		else
//		{
//			System.out.print("Beetroot :" + dealProduct);
//			
//		}
	}
	
	public void switchToOffersPage()
	{
		//if switched to offer page-> skip below part
		
		ShoppingPage landingPage  =testsetup.pgMngr.getShoppingPage();
		landingPage.selectTopDealsPage();
		testsetup.gUtil.windowHandle();
		//explicit wait, parse string
			
	}

	@Then("^User check if the product exists (.+)$")
	public void user_check_if_the_product_exists(String shortname) {

		System.out.println(testsetup.productName+"-->testsetup.productName");
		System.out.println(dealProduct+"-->dealProduct");
		Assert.assertEquals(dealProduct,testsetup.productName);
		
	}

}
