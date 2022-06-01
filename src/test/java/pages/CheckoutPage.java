package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testUtils.TestSetUp;

public class CheckoutPage {
	
	@FindBy(xpath = "//button[@type = 'button']") WebElement checkOutButton;
	@FindBy(css = ".promoBtn") WebElement promoButton;
	@FindBy(xpath = "//button[contains(text(),'Place Order')]") WebElement placeOrder;
	@FindBy (xpath = "//img[@alt = 'Cart']") WebElement cartBag;
	@FindBy(css ="td:nth-child(3)") WebElement items;
	@FindBy(css = ".product-action button") WebElement addToCart;
	
	public WebDriver driver;
	TestSetUp testsetup;
	
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
				
	}
	
	
	public Integer getNoOfItems()
	{
		items.getText();
		return getNoOfItems();
	}
	public void checkOut()
	{
	addToCart.click();
	cartBag.click();
	checkOutButton.click();
	}

	public Boolean applyCode() throws InterruptedException
	{	
		Thread.sleep(1000);
		return promoButton.isDisplayed();
	}
	
	public Boolean Order()
	{
	          
		return placeOrder.isDisplayed();
	}
	
	public String getUrl()
	{
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	

}
