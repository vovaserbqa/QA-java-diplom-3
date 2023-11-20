package model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage {

    MainPage mainPage = new MainPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    private final By buttonConstructor = By.xpath("//p[text()='Конструктор']");
    private final By buttonLogo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a");
    private final By buttonProfile = By.xpath("//a[@href='/account/profile']");
    private final By buttonLogout = By.xpath("//li[@class='Account_listItem__35dAP']/button");

    public UserPage(WebDriver driver) {
        super(driver);
    }

    @Step("wait for main page")
    public void waitForLoadElement() {
        waitForElementVisibility(buttonProfile);
    }

    @Step("check profile button")
    public boolean isProfileButtonVisible() {
        return driver.findElement(buttonProfile).isDisplayed();
    }

    @Step("click constructor button")
    public void clickConstructor() {
        driver.findElement(buttonConstructor).click();
    }

    @Step("click logo")
    public void clickLogo() {
        driver.findElement(buttonLogo).click();
    }

    @Step("click login button")
    public void clickLogout() {
        driver.findElement(buttonLogout).click();
    }

    @Step("click on “Personal Account” test")
    public void clickPersonalAccount() {
        mainPage.clickPersonal();
        waitForLoadElement();
    }

    @Step("from the personal account to the “Constructor” button test")
    public void fromPersonalAccountConstructorButton() {
        mainPage.clickPersonal();
        waitForLoadElement();
        clickConstructor();
        mainPage.waitForLoadElement();
    }

    @Step("from the personal account to the designer by logo test")
    public void fromPersonalAccountDesignerByLogo() {
        mainPage.clickPersonal();
        waitForLoadElement();
        clickLogo();
        mainPage.waitForLoadElement();
    }

    @Step("exit using the “Logout” button in your personal account test")
    public void logout() {
        mainPage.clickPersonal();
        waitForLoadElement();
        clickLogout();
        loginPage.waitForLoadElement();
    }
}