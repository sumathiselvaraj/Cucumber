package testUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase {

	public WebDriver driver;
	public  WebDriverWait wait ;

	public WebDriver initialization () throws IOException

	{

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resource\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("Url");
		String browser_properties = prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		// result = testCondition ? value1 : value2
		
		String browser = browser_maven!=null ? browser_maven : browser_properties;
		
		if(driver == null)
		{
			WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			driver.get(url);
		}
		

		return driver;
	}

}
