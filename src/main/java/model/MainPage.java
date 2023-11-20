package model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private final By buttonLogInAccount = By.xpath("//button[text()='Войти в аккаунт']");
    private final By buttonPersonalAccount = By.linkText("Личный Кабинет");
    private final By buttonBunActive = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By buttonBunInactive = By.xpath("//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By buttonSauceActive = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    private final By buttonSauceInactive = By.xpath("//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    private final By buttonFillingActive = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    private final By buttonFillingInactive = By.xpath("//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    private final By titleMakeBurger = By.xpath("//h1[@class='text text_type_main-large mb-5 mt-10']");

    private final By buttonPlaceOrder = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("click login button")
    public void clickLogin() {
        driver.findElement(buttonLogInAccount).click();
    }

    @Step("wait main page")
    public void waitForLoadElement() {
        waitForElementVisibility(titleMakeBurger);
    }

    @Step("wait order button")
    public boolean isOrderButtonVisible() {
        return driver.findElement(buttonPlaceOrder).isDisplayed();
    }

    @Step("click login personal area button")
    public void clickPersonal() {
        driver.findElement(buttonPersonalAccount).click();
    }

    @Step("click sauces")
    public void clickSauce() {
        driver.findElement(buttonSauceInactive).click();
    }

    @Step("check sauces")
    public boolean isSauceActive() {
        return driver.findElement(buttonSauceActive).isDisplayed();
    }

    @Step("click fillings")
    public void clickFilling() {
        driver.findElement(buttonFillingInactive).click();
    }

    @Step("check fillings")
    public boolean isFillingActive() {
        return driver.findElement(buttonFillingActive).isDisplayed();
    }

    @Step("click rolls")
    public void clickBun() {
        driver.findElement(buttonBunInactive).click();
    }

    @Step("check rolls")
    public boolean isBunActive() {
        return driver.findElement(buttonBunActive).isDisplayed();
    }

}