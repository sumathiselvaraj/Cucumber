package pages;

import org.openqa.selenium.WebDriver;

import testUtils.Genericutil;



public class PageManager {
	
	public WebDriver driver;
	public ShoppingPage shopPg;
	public OfferPage offerpage;
	public CheckoutPage checkoutPg;
	Genericutil genericutils;
	
	public PageManager(WebDriver driver)
	
	{
		this.driver = driver;
	}
	
	
	public ShoppingPage getShoppingPage()
	
	{
		shopPg = new ShoppingPage(driver);
		
		return shopPg;
	}
	
	public OfferPage getOfferPage()
	{
		offerpage = new OfferPage(driver);
		
		return offerpage;
	}
	
	public CheckoutPage getCheckoutPage()
	
	{
		checkoutPg = new CheckoutPage(driver);
		
		return checkoutPg;
	}

}
