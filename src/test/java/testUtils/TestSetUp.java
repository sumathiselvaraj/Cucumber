package testUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.PageManager;


public class TestSetUp {

	public  WebDriverWait wait ;

	public WebDriver driver;
	public String productName;
	public String originalName ;
	public ExcelReader reader;
	//public String dealProduct;
	public String parentWindow;
	public Integer int1;
	public testBase base;
	public PageManager pgMngr ;
	public String offerPageTitle;
	public Genericutil gUtil;
	public String currentUrl;
	public String filePath = "\\src\\test\\resource2\\SampleExcel.xlsx";

	public TestSetUp() throws IOException

	{
		base = new testBase();
        pgMngr = new PageManager(base.initialization());
        gUtil = new Genericutil(base.initialization()); 	
         reader = new ExcelReader();
	}

}
