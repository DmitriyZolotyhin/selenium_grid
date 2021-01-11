package com.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.CapabilityType.ForSeleniumServer;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverInstance {

    private static DriverInstance instance;
    private WebDriver driver;

    private WebDriverWait wait;

    private DriverInstance(String browser, int nodePort) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setCapability("platform", Platform.WINDOWS);
        capabilities.setCapability(ForSeleniumServer.PROXYING_EVERYTHING, true);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        capabilities.setCapability("marionette", true);
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:" + nodePort + "/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(60000, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        wait = new WebDriverWait(driver, 10000);


    }

    public static void setInstance(String browser, int nodePort) {
        DriverInstance.instance = new DriverInstance(browser, nodePort);
    }

    public static DriverInstance getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

}
