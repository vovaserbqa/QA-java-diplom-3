package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage {
    private final WebDriver driver;

    By fieldEmail = By.name("name");
    By fieldPassword = By.name("Пароль");
    By buttonLogin = By.xpath(".//button[text()='Войти']");
    By buttonLoginIn = By.xpath(".//button[text()='Войти в аккаунт']");

    public AuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public AuthPage loginIn(String email, String password) {
        waitForLoad(buttonLoginIn);
        driver.findElement(buttonLoginIn).click();
        driver.findElement(fieldEmail).sendKeys(email);
        driver.findElement(fieldPassword).sendKeys(password);
        driver.findElement(buttonLogin).click();
        return this;
    }

    public AuthPage login(String email, String password) {
        waitForLoad(buttonLogin);
        driver.findElement(fieldEmail).sendKeys(email);
        driver.findElement(fieldPassword).sendKeys(password);
        driver.findElement(buttonLogin).click();
        return this;
    }

    public void waitForLoad(By fieldToAppear) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(fieldToAppear));
    }
}