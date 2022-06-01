package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import testUtils.TestSetUp;

public class Hooks {

	TestSetUp testsetup;
	public Hooks(TestSetUp testsetup) 
	{

		this.testsetup = testsetup;
	}
	
	@After
	public void AfterScenario() 
	{
		
		testsetup.base.initialization().quit();
		
	}
	

	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException 
	{
		WebDriver driver =testsetup.base.initialization();
		if(scenario.isFailed())
		{
		//screenshot
		File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		
		}
	}
}
