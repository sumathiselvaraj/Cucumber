package testUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase {

	public WebDriver driver;

	public WebDriver initialization ()

	{
		if(driver == null)
		{
			WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		}
		

		return driver;
	}

}
