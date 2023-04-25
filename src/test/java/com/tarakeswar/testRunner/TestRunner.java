package com.tarakeswar.testRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/featureFiles/Customers.feature",
    glue={"com.tarakeswar.stepDefinations"},
    plugin = {"pretty","json:target/cucumber-report/cucumber.json",
            "html:target/cucumber-report/cucumber.html"},dryRun = false,monochrome = true )
public class TestRunner extends AbstractTestNGCucumberTests{

}
