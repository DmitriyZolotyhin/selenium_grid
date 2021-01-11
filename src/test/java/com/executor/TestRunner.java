package com.executor;

import com.driver.DriverInstance;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "com.stepDefinition",
        tags = "@ExampleScenario",
        monochrome = true
)
public class TestRunner {

    @AfterClass
    public static void afterSuite() {
        DriverInstance.getInstance().getDriver().quit();
    }

}
