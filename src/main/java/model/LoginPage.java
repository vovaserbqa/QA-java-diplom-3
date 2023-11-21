package model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    MainPage mainPage = new MainPage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);
    ForgetPasswordPage forgetPasswordPage = new ForgetPasswordPage(driver);

    private final By titleEnter = By.xpath("//h2[text()='Вход']");

    private final By fieldEmail = By.xpath("//input[@name='name']");

    private final By fieldPassword = By.xpath("//input[@name='Пароль']");

    private final By buttonLogin = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final By buttonRegister = By.xpath("//a[@href='/register']");

    private final By buttonRecoverPassword = By.xpath("//a[@href='/forgot-password']");

    private final By buttonLogo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("loading page")
    public void waitForLoadElement() {
        waitForElementVisibility(titleEnter);
    }

    @Step("click register button")
    public void clickRegister() {
        driver.findElement(buttonRegister).click();
    }

    @Step("filling authorization fields")
    public void fillLoginForm(String email, String password) {
        driver.findElement(fieldEmail).sendKeys(email);
        driver.findElement(fieldPassword).sendKeys(password);
    }

    @Step("click login button")
    public void clickLoginButton() {
        driver.findElement(buttonLogin).click();
    }

    @Step("click logo button")
    public void clickLogo() {
        driver.findElement(buttonLogo).click();
    }

    @Step("click forget password button")
    public void clickReset() {
        driver.findElement(buttonRecoverPassword).click();
    }

    @Step("check Login display")
    public boolean isEnterLabelVisible() {
        return driver.findElement(titleEnter).isDisplayed();
    }

    @Step("log in from main page test")
    public void login(String email, String password) {
        mainPage.clickLogin();
        waitForLoadElement();
        fillLoginForm(email, password);
        clickLoginButton();
        mainPage.waitForLoadElement();
    }

    @Step("login through the “Personal Account” button test")
    public void loginPersonalAccount(String email, String password) {
        mainPage.clickPersonal();
        waitForLoadElement();
        fillLoginForm(email, password);
        clickLoginButton();
        mainPage.waitForLoadElement();
    }

    @Step("log in from registration page test")
    public void loginRegistrationPage(String email, String password) {
        mainPage.clickLogin();
        clickRegister();
        registrationPage.waitForLoadElement();
        registrationPage.clickLogin();
        waitForLoadElement();
        fillLoginForm(email, password);
        clickLoginButton();
        mainPage.waitForLoadElement();
    }

    @Step("login from password recovery page test")
    public void loginResetPasswordPage(String email, String password) {
        mainPage.clickLogin();
        waitForLoadElement();
        clickReset();
        forgetPasswordPage.waitForLoad();
        forgetPasswordPage.clickLogin();
        waitForLoadElement();
        fillLoginForm(email, password);
        clickLoginButton();
        mainPage.waitForLoadElement();
    }
}