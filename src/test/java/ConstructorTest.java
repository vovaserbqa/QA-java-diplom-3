import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.AuthPage;
import pageobject.ConstructorPage;
import pageobject.RegisterPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;

public class ConstructorTest extends BaseTest {
    private RegisterPage registerPage;
    private AuthPage authPage;
    private  ConstructorPage constructorPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://stellarburgers.nomoreparties.site/register");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        registerPage = new RegisterPage(driver);
        registerPage.register(name, email, password);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        authPage = new AuthPage(driver);
        authPage.login(email, password);

    }

    @DisplayName("buns section")
    @Test
    public void bunsSectionTest() {
        constructorPage = new ConstructorPage(driver);

        assertThat(constructorPage.bunsSection(), CoreMatchers.containsString("tab_tab_type_current"));
    }

    @DisplayName("sauce section")
    @Test
    public void sauceSectionTest() {
        constructorPage = new ConstructorPage(driver);
        constructorPage.clickSauceTab();
        assertThat(constructorPage.saucesSection(), CoreMatchers.containsString("tab_tab_type_current"));
    }

    @DisplayName("stuffing section")
    @Test
    public void stuffingSectionTest() {
        constructorPage = new ConstructorPage(driver);
        constructorPage.clickFeelingsTab();
        assertThat(constructorPage.fillingsSection(), CoreMatchers.containsString("tab_tab_type_current"));
    }
}