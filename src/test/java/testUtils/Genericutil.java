package testUtils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Genericutil {

	WebDriver driver;
	testSetUp testsetup;

	public Genericutil(WebDriver driver) {

		this.driver = driver;
	
	}
	public void windowHandle() {
		
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
		
		
	}
}
