package testUtils;

import org.openqa.selenium.WebDriver;

import Pages.PageManager;


public class TestSetUp {

	public WebDriver driver;
	public String productName;
	public String originalName = "Tomato";
	public String dealProduct;
	public String parentWindow;
	
	public testBase base;
	public PageManager pgMngr ;
	public String offerPageTitle;
	public Genericutil gUtil;

	public TestSetUp()

	{
		base = new testBase();
        pgMngr = new PageManager(base.initialization());
        gUtil = new Genericutil(base.initialization()); 	
	}

}
