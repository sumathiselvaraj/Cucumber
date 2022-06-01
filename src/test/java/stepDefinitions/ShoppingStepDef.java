package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.ShoppingPage;
import testUtils.TestSetUp;


public class ShoppingStepDef {
	
	TestSetUp testsetup;
	ShoppingPage shopPg;
	Integer int1;
	CheckoutPage checkoutPg;
	
	public String productName;
	
	public ShoppingStepDef(TestSetUp testsetup)
	{
		this.testsetup = testsetup ;
		this.shopPg = testsetup.pgMngr.getShoppingPage();
		this.checkoutPg = testsetup.pgMngr.getCheckoutPage();
	}
	
	@Given("User lands in Green Cart Home Page")
	public void user_lands_in_green_cart_home_page() {
		
		Assert.assertTrue(shopPg.getTitleLandingPage().contains("Green"));
		
	}

	@When("^User search the product with shortname (.+)$")
	public void user_search_the_product_with(String shortname) throws InterruptedException {
		shopPg.searchItem(shortname);;
		System.out.print(shortname);
		Thread.sleep(1000);
		testsetup.productName = shopPg.getProductName().split("-")[0].trim();
		System.out.print("testsetup.productname :" +testsetup.productName);
	}

	@Then("User exctract the actual name of the product")
	public void user_exctract_the_actual_name_of_the_product() {
		
		if(testsetup.productName.equals( testsetup.originalName))
			
		{
		Assert.assertEquals(testsetup.productName, testsetup.originalName);
		}if (testsetup.productName.equals( testsetup.originalName1))  
		{
			Assert.assertEquals(testsetup.productName, testsetup.originalName1);
		}
		
	}
	
	@When("User click Top deal link")
	public void user_click_top_deal_link() {
			shopPg.selectTopDealsPage();
	}
	@Then("User lands on offer page")
	public void user_lands_on_offer_page() throws InterruptedException {
		
		Thread.sleep(1000);
		testsetup.offerPageTitle = shopPg.getTitleLandingPage();
		Assert.assertTrue(testsetup.offerPageTitle.contains("Green"));
	}
	
	@When("User increments his product quantity to {int} and proceed to checkout")
	public void user_increments_his_product_quantity_to_and_proceed_to_checkout(Integer int1)  {
		shopPg.incrementQuantity(int1);	
		checkoutPg.checkOut();
		
	}

	
}
