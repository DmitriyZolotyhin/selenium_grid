package com.stepDefinition;

import com.driver.DriverInstance;
import com.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static com.pages.HomePage.textLetterField;


public class TestCaseLoginSteps {

    HomePage homePage = new HomePage();
    WebDriver driver;
    WebDriverWait wait;
    static DriverInstance instance;


    {
        instance = DriverInstance.getInstance();
        driver = instance.getDriver();
        wait = instance.getWait();

    }

    @Step
    @Given("^user want to Login to gmail through a third-party service$")
    public void launchBoxApp() {
        homePage.goToSite();

    }

    @Step
    @Then("^user verify the \"([^\"]*)\" in the app$")
    public void verifyAppTitle(String title) {
        Assert.assertTrue("Page title is wrong", wait.until(ExpectedConditions.titleIs(title)));
    }

    @Step
    @When("^user enter the and Login to the app$")
    public void loginToApp() {
        homePage.login();
        homePage.buttonAfterEnterLogin();
        homePage.passwordToService();
        homePage.buttonAfterPassword();
    }

    @Step
    @Given("^user wants to go to Gmail, enter: recipient, subject, number of letters from the user and send a letter$")
    public void launchBoxApp2()  {
        homePage.goToSiteGmail();
        homePage.buttonCreateLetter();
        homePage.recipientInputField();
        homePage.subjectInputField();
        int countingNumberLettersSentByUser;
        countingNumberLettersSentByUser = driver.findElements(By.name("farit.valiahmetov")).size() / 2;
        homePage.textLetter(textLetterField).sendKeys(countingNumberLettersSentByUser + "");
        homePage.buttonSendEmail();
    }

    @Step
    @Then("^user checks that there is an inscription \"([^\"]*)\"")
    public void verifySendLetter(String title2) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Письмо отправлено.']")));
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(title2));


    }

}