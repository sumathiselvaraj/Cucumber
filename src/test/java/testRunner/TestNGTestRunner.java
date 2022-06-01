package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Feature", 
                     glue = "stepDefinitions", monochrome = true, tags = "@productName",
                     plugin = {	"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests {


	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}
