package stepDefinitions;

import org.testng.Assert;

import Pages.shoppingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testUtils.testSetUp;


public class shoppingStepDef {
	
	testSetUp testsetup;
	shoppingPage shoppingpage;
	public String productName;
	
	public shoppingStepDef(testSetUp testsetup)
	{
		this.testsetup = testsetup ;
		this.shoppingpage = testsetup.pagemanager.getShoppingPage();
		
	}
	
	@Given("User lands in Green Cart Home Page")
	public void user_lands_in_green_cart_home_page() {
		
		Assert.assertTrue(shoppingpage.getTitleLandingPage().contains("Green"));
		
	}

	@When("User search the product with shortname {string}")
	public void user_search_the_product_with(String shortname) throws InterruptedException {
		shoppingpage.searchItem(shortname);;
		System.out.print(shortname);
		Thread.sleep(1000);
		testsetup.productName = shoppingpage.getProductName().split("-")[0].trim();
		System.out.print(testsetup.productName);
	}

	@Then("User exctract the actual name of the product")
	public void user_exctract_the_actual_name_of_the_product() {
		
		Assert.assertEquals(testsetup.productName, testsetup.originalName);
		
	}
	
	@When("User click Top deal link")
	public void user_click_top_deal_link() {
			shoppingpage.selectTopDealsPage();
	}
	@Then("User lands on offer page")
	public void user_lands_on_offer_page() throws InterruptedException {
		
		Thread.sleep(1000);
		testsetup.offerPageTitle = shoppingpage.getTitleLandingPage();
		Assert.assertTrue(testsetup.offerPageTitle.contains("Green"));
	}
	

	
}
