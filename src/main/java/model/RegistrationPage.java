package model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    private final By titleRegister = By.xpath("//h2[text()='Регистрация']");
    private final By fieldName = By.xpath("//label[text()='Имя']/../input");
    private final By fieldEmail = By.xpath("//label[text()='Email']/../input");
    private final By fieldPassword = By.xpath("//label[text()='Пароль']/../input");
    private final By buttonRegister = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final By buttonLogin = By.xpath("//a[@href='/login']");
    private final By titleIncorrectPassword = By.xpath("//p[@class='input__error text_type_main-default']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("wait for registration")
    public void waitForLoadElement() {
        waitForElementVisibility(titleRegister);
    }

    @Step("filling registration form")
    public void fillRegistrationForm(String name, String email, String password) {
        driver.findElement(fieldName).sendKeys(name);
        driver.findElement(fieldEmail).sendKeys(email);
        driver.findElement(fieldPassword).sendKeys(password);
    }

    @Step("click registration button")
    public void clickRegisterButton() {
        driver.findElement(buttonRegister).click();
    }

    @Step("check wrong password")
    public boolean isIncorrectPasswordLabelVisible() {
        return driver.findElement(titleIncorrectPassword).isDisplayed();
    }

    @Step("click login button")
    public void clickLogin() {
        driver.findElement(buttonLogin).click();
    }

    @Step("registration test")
    public void register(String name, String email, String password) {
        fillRegistrationForm(name, email, password);
        clickRegisterButton();
    }
}