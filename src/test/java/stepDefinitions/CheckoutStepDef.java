package stepDefinitions;




import org.testng.Assert;

import io.cucumber.java.en.Then;
import pages.CheckoutPage;
import testUtils.TestSetUp;

public class CheckoutStepDef {

	TestSetUp testsetup;
	CheckoutPage checkoutPg;
	public String productName;

	public CheckoutStepDef(TestSetUp testsetup) {
		this.testsetup = testsetup;
		this.checkoutPg = testsetup.pgMngr.getCheckoutPage();

	}

	@Then("verify product quantity, promocode and placeorder button")
	public void product_added_into_the_cart() throws InterruptedException {
		//int totalitems = checkoutPg.getNoOfItems();
		//Assert.assertEquals(totalitems, testsetup.int1);
		Assert.assertTrue(checkoutPg.applyCode());
		Assert.assertTrue(checkoutPg.Order());
		//System.out.print(testsetup.int1);
	}

	
}
