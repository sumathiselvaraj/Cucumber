package testUtils;

import org.openqa.selenium.WebDriver;

import Pages.pageManager;


public class testSetUp {

	public WebDriver driver;
	public String productName;
	public String originalName = "Tomato";
	public String dealProduct;
	
	public testBase base;
	public pageManager pagemanager ;
	public String offerPageTitle;
	public Genericutil genericUtils;

	public testSetUp()

	{
		base = new testBase();
        pagemanager = new pageManager(base.initialization());
        genericUtils = new Genericutil(base.initialization()); 	
	}

}
