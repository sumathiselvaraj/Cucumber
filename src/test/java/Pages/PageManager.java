package Pages;

import org.openqa.selenium.WebDriver;

import testUtils.Genericutil;



public class PageManager {
	
	public WebDriver driver;
	public ShoppingPage shoppingpage;
	public OfferPage offerpage;
	Genericutil genericutils;
	
	public PageManager(WebDriver driver)
	
	{
		this.driver = driver;
	}
	
	
	public ShoppingPage getShoppingPage()
	
	{
		shoppingpage = new ShoppingPage(driver);
		
		return shoppingpage;
	}
	
	public OfferPage getOfferPage()
	{
		offerpage = new OfferPage(driver);
		
		return offerpage;
	}
	

}
