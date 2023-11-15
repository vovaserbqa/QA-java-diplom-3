package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    By buttonPersonalArea = By.xpath("//a[.='Личный Кабинет']");
    By buttonLogInMainPage = By.xpath(".//button[text()='Войти в аккаунт']");
    By buttonConstructor = By.xpath("//a[.='Конструктор']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPersonalAreaButton() {
        driver.findElement(buttonPersonalArea).click();
    }

    public void clickLoginButton() {
        driver.findElement(buttonLogInMainPage).click();
    }

    public void clickConstructorButton() {
        driver.findElement(buttonConstructor).click();
    }

    public void waitForLoad(By fieldToAppear) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(fieldToAppear));
    }

    public void waitForPersonalAreaButton() {
        waitForLoad(buttonPersonalArea);
    }
}