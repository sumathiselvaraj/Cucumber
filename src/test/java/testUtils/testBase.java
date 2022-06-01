package testUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase {

	public WebDriver driver;
	public  WebDriverWait wait ;

	public WebDriver initialization ()

	{
		if(driver == null)
		{
			WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		}
		

		return driver;
	}

}
