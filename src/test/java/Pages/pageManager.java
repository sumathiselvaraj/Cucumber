package Pages;

import org.openqa.selenium.WebDriver;

import testUtils.Genericutil;



public class pageManager {
	
	public WebDriver driver;
	public shoppingPage shoppingpage;
	public offerPage offerpage;
	Genericutil genericutils;
	
	public pageManager(WebDriver driver)
	
	{
		this.driver = driver;
	}
	
	
	public shoppingPage getShoppingPage()
	
	{
		shoppingpage = new shoppingPage(driver);
		
		return shoppingpage;
	}
	
	public offerPage getOfferPage()
	{
		offerpage = new offerPage(driver);
		
		return offerpage;
	}
	

}
