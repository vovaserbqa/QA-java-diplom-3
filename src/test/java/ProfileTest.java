import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.AuthPage;
import pageobject.MainPage;
import pageobject.PersonalAreaPage;
import pageobject.RegisterPage;

import static org.junit.Assert.assertEquals;


public class ProfileTest extends BaseTest {

    private RegisterPage registerPage;
    private AuthPage authPage;
    private MainPage mainPage;
    private PersonalAreaPage personalAreaPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://stellarburgers.nomoreparties.site/register");
        driver.manage().window().maximize();

        registerPage = new RegisterPage(driver);
        registerPage.register(name, email, password);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        authPage = new AuthPage(driver);
        authPage.login(email, password);
    }


    @DisplayName("to personal account")
    @Test
    public void toPersonalAccountTest() {
        mainPage = new MainPage(driver);
        personalAreaPage = new PersonalAreaPage(driver);
        mainPage.waitForPersonalAreaButton();
        mainPage.clickPersonalAreaButton();
        personalAreaPage.waitForExitButton();
    }

    @DisplayName("from personal account to ingredients")
    @Test
    public void fromPersonalAccountToIngredientsTest() {
        mainPage = new MainPage(driver);
        personalAreaPage = new PersonalAreaPage(driver);
        mainPage.waitForPersonalAreaButton();
        mainPage.clickPersonalAreaButton();
        personalAreaPage.waitForExitButton();
        mainPage.clickConstructorButton();

        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }


    @DisplayName("logout")
    @Test
    public void logoutTest() {
        mainPage = new MainPage(driver);
        personalAreaPage = new PersonalAreaPage(driver);
        mainPage.waitForPersonalAreaButton();
        mainPage.clickPersonalAreaButton();
        personalAreaPage.waitForExitButton();
        personalAreaPage.logOut();
    }
}