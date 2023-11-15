import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import pageobject.RegisterPage;
import utils.UserApi;

public class BaseTest {

    protected static WebDriver driver;
    protected final String name = RandomStringUtils.randomAlphabetic(10);
    protected final String email = RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
    protected final String password = RandomStringUtils.randomAlphabetic(10);
    protected final String passwordFalse = RandomStringUtils.randomAlphabetic(5);

    protected String token;
    protected RegisterPage createUserRequest;

    @After
    public void tearDown() {
        driver.quit();
        if (token == null) return;
        UserApi.deleteUser(createUserRequest, token);
    }
}
