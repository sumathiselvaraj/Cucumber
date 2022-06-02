package stepDefinitions;

import java.util.List;
import java.util.Map;

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

	public String shortName;

	public ShoppingStepDef(TestSetUp testsetup) {
		this.testsetup = testsetup;
		this.shopPg = testsetup.pgMngr.getShoppingPage();
		this.checkoutPg = testsetup.pgMngr.getCheckoutPage();
		

	}

	@Given("User lands in Green Cart Home Page")
	public void user_lands_in_green_cart_home_page() {

		Assert.assertTrue(shopPg.getTitleLandingPage().contains("Green"));

	}

	@When("User search the product from {string} and rownumber {int}")
	public void user_search_the_product_from_and_rownumber(String SheetName, Integer RowNumber) throws Exception {

		//*********   data from excel  **********  //
		List<Map<String, String>> data = testsetup.reader
				.getData(System.getProperty("user.dir") + testsetup.filePath, SheetName);

		shortName = data.get(RowNumber).get("shortName");
		testsetup.originalName = data.get(RowNumber).get("originalName");
		shopPg.searchItem(shortName);
		//System.out.println(shortName);
		Thread.sleep(500);
		testsetup.productName = shopPg.getProductName().split("-")[0].trim();
		System.out.println("testsetup.productname :" + testsetup.productName);
	}

	@Then("User exctract the actual name of the product")
	public void user_exctract_the_actual_name_of_the_product() {

		Assert.assertEquals(testsetup.productName, testsetup.originalName);

	}

	@When("User search the product with shortname {string}")
	public void user_search_the_product_with_shortname(String shortName) throws InterruptedException {
		shopPg.searchItem(shortName);
		Thread.sleep(500);
		//testsetup.productName = shopPg.getProductName().split("-")[0].trim();
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
	public void user_increments_his_product_quantity_to_and_proceed_to_checkout(Integer int1) {
		shopPg.incrementQuantity(int1);
		checkoutPg.checkOut();

	}

}
