import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.RegisterPage;

public class RegTest extends BaseTest {

    private RegisterPage registerPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");
        driver.manage().window().maximize();
    }

    @DisplayName("successful registration")
    @Test
    public void successfulRegistrationTest() {
        registerPage = new RegisterPage(driver)
                .register(name, email, password);
        registerPage.checkSuccess();
    }

    @DisplayName("successful registration, password less than 5 characters")
    @Test
    public void unsuccessfulRegistrationTest() {
        registerPage = new RegisterPage(driver)
                .register(name, email, passwordFalse);
        registerPage.waitForIncorrectMess();
    }
}