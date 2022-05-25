package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (  features = "src/test/java/Feature",glue = "stepDefinitions" ,monochrome = true)



public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
