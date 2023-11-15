package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;
    By buttonAuth = By.xpath("//*[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAuthButton() {
        driver.findElement(buttonAuth).click();
    }
}