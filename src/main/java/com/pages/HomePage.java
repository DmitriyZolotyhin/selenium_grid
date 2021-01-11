package com.pages;

import com.driver.DriverInstance;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import static java.lang.String.format;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    static DriverInstance instance;


    {
        instance = DriverInstance.getInstance();
        driver = instance.getDriver();
        wait = instance.getWait();
    }

    private static final String loginThirdPartyService = "https://accounts.google.com/o/oauth2/auth/identifier?client_id=717762328687-iludtf96g1hinl76e4lc1b9a82g457nn.apps.googleusercontent.com&scope=profile%20email&redirect_uri=https%3A%2F%2Fstackauth.com%2Fauth%2Foauth2%2Fgoogle&state=%7B%22sid%22%3A1%2C%22st%22%3A%2259%3A3%3Abbc%2C16%3A9a4eac82fbe25814%2C10%3A1608148397%2C16%3A604b105ea9dee4cc%2Ca0ea95b79d247fbcae91cc69abcbb4093ea87a783e339f96830b930d1c137f45%22%2C%22cdl%22%3Anull%2C%22cid%22%3A%22717762328687-iludtf96g1hinl76e4lc1b9a82g457nn.apps.googleusercontent.com%22%2C%22k%22%3A%22Google%22%2C%22ses%22%3A%22a2073494620346de93c02b65a5eea380%22%7D&response_type=code&flowName=GeneralOAuthFlow";
    private static final String ENTER_TO_GMAIL = "https://mail.google.com";
    private static final String uName = "samara2020testov@gmail.com";
    private static final String pwd = "SamaraQA2020Task";
    private static final String recipient = "samara2020testov@gmail.com";
    private static final String topic = "Тестовое задание.Золотухин";
    public static final String textLetterField = "//td[2]/div[2]/div";


    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement xpathLogin2;

    @FindBy(xpath = "//button/div[2]")
    private WebElement buttonAfterEnterLogin2;

    @FindBy(xpath = "//*[@id='password']//input")
    public WebElement passwordToService;

    @FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button/div[2]")
    private WebElement buttonAfterPassword;

    @FindBy(xpath = "//*[@class='aic']/div/div")
    private WebElement buttonForCreateLetter;

    @FindBy(xpath = "//*[@name='to']")
    public WebElement recipientInputField;


    @FindBy(name = "subjectbox")
    public WebElement subjectInputField;

    @FindBy(xpath = "//*[@class='dC']/div")
    private WebElement buttonSendEmail;

    public void goToSite() {
        driver.get(loginThirdPartyService);
    }

    public WebElement findElement(By by) {
        return instance.getDriver().findElement(by);
    }

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step("Enter login")
    public void login() {
        init(driver);
        xpathLogin2.sendKeys(uName);
    }

    @Step("Click button")
    public void buttonAfterEnterLogin() {
        buttonAfterEnterLogin2.click();
    }

    @Step
    public void passwordToService() {

        passwordToService.sendKeys(pwd);
    }

    @Step
    public void buttonAfterPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Далее']")));
        buttonAfterPassword.click();
    }

    @Step
    public WebElement textLetter(String linkText) {
        return findElement(By.xpath(format(textLetterField, linkText)));
    }

    @Step
    public void goToSiteGmail() {
        driver.get(ENTER_TO_GMAIL);
        driver.get(ENTER_TO_GMAIL);


    }

    @Step
    public void buttonCreateLetter() {
        buttonForCreateLetter.click();
    }

    @Step
    public void recipientInputField() {
        recipientInputField.sendKeys(recipient);
    }

    @Step
    public void subjectInputField() {
        subjectInputField.sendKeys(topic);
    }

    @Step
    public void buttonSendEmail() {
        buttonSendEmail.click();
    }
}