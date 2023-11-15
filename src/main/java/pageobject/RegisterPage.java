package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    private final WebDriver driver;

    By inputName = By.xpath("//fieldset[1]//input[@name='name']");
    By inputEmail = By.xpath("//fieldset[2]//input[@name='name']");
    By inputPassword = By.xpath(".//input[@type='password']");

    By registerButton = By.xpath("//button[.='Зарегистрироваться']");
    By succesHeader = By.xpath(".//button[text()='Зарегистрироваться']");
    By incorrectPass = By.xpath(".//p[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkSuccess() {
        driver.findElement(succesHeader);
    }

    public RegisterPage register(String name, String email, String password) {
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(registerButton).click();
        return this;
    }

    public void waitForLoad(By fieldToAppear) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(fieldToAppear));
    }

    public void waitForIncorrectMess() {
        waitForLoad(incorrectPass);
    }
}