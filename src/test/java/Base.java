import api.UserApi;
import dto.ApiUserPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import model.LoginPage;
import model.MainPage;
import model.RegistrationPage;
import model.UserPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base {
    protected String email = RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
    protected String password = RandomStringUtils.randomAlphabetic(10);
    protected String name = RandomStringUtils.randomAlphabetic(10);
    protected WebDriver driver;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected UserPage userPage;
    protected RegistrationPage registrationPage;
    protected ApiUserPage apiUserPage;

    private final String chromeBrowser = "Chrome";
    private final String yandexBrowser = "Yandex";

    @Before
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        selectBrowser(yandexBrowser);

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        userPage = new UserPage(driver);
        registrationPage = new RegistrationPage(driver);
        apiUserPage = new ApiUserPage(email, password, name);
        UserApi.registration(apiUserPage);

        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().window().maximize();
    }

    public void selectBrowser(String browser) {
        if (browser.equals(yandexBrowser)) {
            driver = new ChromeDriver();
        } else if (browser.equals(chromeBrowser)) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\yandexdriver.exe");
            driver = new ChromeDriver();
        }
    }

    @After
    public void tearDown() {
        String accessToken = UserApi.login(new ApiUserPage(email, password)).then().extract().path("accessToken");
        if (accessToken != null) {
            UserApi.delete(accessToken);
        }
        driver.quit();
    }
}