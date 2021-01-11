package com.stepDefinition;

import com.driver.DriverInstance;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import org.junit.Before;

public class CucumberHooks {
    public static String browserName;

    @Given("^start browser \"([^\"]*)\" on node port (\\d+)$")
    public void browser_is(String browser, int nodePort) throws Throwable {
        if (browserName == null) {
            DriverInstance.setInstance(browser, nodePort);
            browserName = browser;
        }
        if (browserName != null && !browserName.equals(browser)) {
            DriverInstance.setInstance(browser, nodePort);
            browserName = browser;
        }
        System.out.println("Browser is " + browser + " " + nodePort+"");

    }

    @Before
    public void beforeScenario(Scenario sc) {
        System.out.println(sc.getName());
    }


}
