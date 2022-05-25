package stepDefinitions;

import org.testng.Assert;

import Pages.offerPage;
import Pages.shoppingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testUtils.testSetUp;

public class offerStepDef {

	testSetUp testsetup;
	offerPage offerpage;
	shoppingPage shoppingpage;
	String dealProduct;

	public offerStepDef(testSetUp testsetup) {

		this.testsetup = testsetup;
		this.offerpage = testsetup.pagemanager.getOfferPage();
		this.shoppingpage = testsetup.pagemanager.getShoppingPage();
		
	}

			
	// ********** Dynamic step ,so step starts with ^ and ends with $
	// **************//
	// ********** Also < Name > indicates the value changes , so it is represented
	// as (.+) ********* //

	@When("^User search the product with (.+) in deals$")
	public void user_search_the_product_with_in_deals(String shortname) throws InterruptedException {
		testsetup.genericUtils.windowHandle();
		offerpage.searchItem(shortname);;
		System.out.print(shortname); 
		Thread.sleep(1000);
		dealProduct = offerpage.getProductName();
	}
	
	public void switchToOffersPage()
	{
		//if switched to offer page-> skip below part
		
		shoppingPage landingPage  =testsetup.pagemanager.getShoppingPage();
		landingPage.selectTopDealsPage();
		testsetup.genericUtils.windowHandle();
		//explicit wait, parse string
			
	}

	@Then("User check if the product exists")
	public void user_check_if_the_product_exists() {

		Assert.assertEquals(testsetup.dealProduct, testsetup.productName);;
	}

}
