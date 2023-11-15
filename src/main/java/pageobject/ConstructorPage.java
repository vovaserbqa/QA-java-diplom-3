package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage {

    private final WebDriver driver;
    By tabBun = By.xpath("//div[.='Булки']");
    By tabSauce = By.xpath("//div[.='Соусы']");
    By tabFeelings = By.xpath("//div[.='Начинки']");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    public String bunsSection() {
        return driver.findElement(tabBun).getAttribute("class");
    }

    public void clickSauceTab() {
        driver.findElement(tabSauce).click();
    }

    public void clickFeelingsTab() {
        driver.findElement(tabFeelings).click();

    }

    public String saucesSection() {
        return driver.findElement(tabSauce).getAttribute("class");
    }

    public String fillingsSection() {
        return driver.findElement(tabFeelings).getAttribute("class");
    }
}