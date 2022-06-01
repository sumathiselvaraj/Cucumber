package testUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.PageManager;


public class TestSetUp {

	public  WebDriverWait wait ;

	public WebDriver driver;
	public String productName;
	public String originalName = "Tomato";
	public String originalName1 = "Beetroot";
	public String dealProduct;
	public String parentWindow;
	public Integer int1;
	public testBase base;
	public PageManager pgMngr ;
	public String offerPageTitle;
	public Genericutil gUtil;
	public String currentUrl;
	public String url = "https://rahulshettyacademy.com/seleniumPractise/#/cart";

	public TestSetUp() throws IOException

	{
		base = new testBase();
        pgMngr = new PageManager(base.initialization());
        gUtil = new Genericutil(base.initialization()); 	
	}

}
