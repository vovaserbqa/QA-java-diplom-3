import api.UserApi;
import dto.ApiUserPage;
import io.qameta.allure.junit4.DisplayName;
import model.LoginPage;
import model.MainPage;
import model.RegistrationPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;


public class RegistrationTest {

    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private final String name = RandomStringUtils.randomAlphabetic(10);
    private final String email = RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
    private String password;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);

        mainPage.clickLogin();
        loginPage.waitForLoadElement();
        loginPage.clickRegister();
        registrationPage.waitForLoadElement();
    }

    @Test
    @DisplayName("registration")
    public void registerTest() {
        password = RandomStringUtils.randomAlphabetic(10);

        registrationPage.register(name, email, password);

        loginPage.loginPersonalAccount(email, password);
        assertTrue("The 'Place an order' button is displayed", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Incorrect password")
    public void incorrectPasswordTest() {
        password = RandomStringUtils.randomAlphabetic(5);

        registrationPage.register(name, email, password);

        assertTrue("incorrect password", registrationPage.isIncorrectPasswordLabelVisible());
    }

    @After
    public void tearDown() {
        String accessTokenUI = UserApi.login(new ApiUserPage(email, password)).then().extract().path("accessToken");
        if (accessTokenUI != null) {
            UserApi.delete(accessTokenUI);
        }
        driver.quit();
    }
}