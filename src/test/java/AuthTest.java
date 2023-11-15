import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.AuthPage;
import pageobject.ForgotPasswordPage;
import pageobject.MainPage;
import pageobject.RegisterPage;

public class AuthTest extends BaseTest {
    private AuthPage authPage;
    private MainPage mainPage;
    private ForgotPasswordPage passwordPage;
    private RegisterPage registerPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://stellarburgers.nomoreparties.site/register");
        driver.manage().window().maximize();

        registerPage = new RegisterPage(driver);
        registerPage.register(name, email, password);
    }

    @DisplayName("auth from main page")
    @Test
    public void authTest() {
        driver.get("https://stellarburgers.nomoreparties.site");

        mainPage = new MainPage(driver);
        authPage = new AuthPage(driver)
        .loginIn(email, password);
    }

    @DisplayName("auth from forgot-password page")
    @Test
    public void authFromForgetPasswordTest() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");

        passwordPage = new ForgotPasswordPage(driver);
        authPage = new AuthPage(driver);
        passwordPage.clickAuthButton();
        authPage.login(email, password);
    }
}