import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest extends Base {

    @Test
    @DisplayName("log in from main page")
    public void logInFromMainPageTest() {
        loginPage.login(apiUserPage.getEmail(), apiUserPage.getPassword());
        assertTrue("The 'Place an order' button is displayed", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("login through the “Personal Account” button")
    public void logInThroughPersonalAccountButtonTest() {
        loginPage.loginPersonalAccount(apiUserPage.getEmail(), apiUserPage.getPassword());
        assertTrue("The 'Place an order' button is displayed", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("log in from registration page")
    public void logInFromRegistrationPageTest() {
        loginPage.loginRegistrationPage(apiUserPage.getEmail(), apiUserPage.getPassword());
        assertTrue("The 'Place an order' button is displayed", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("login from password recovery page")
    public void loginOnResetPasswordPageTest() {
        loginPage.loginResetPasswordPage(apiUserPage.getEmail(), apiUserPage.getPassword());
        assertTrue("The 'Place an order' button is displayed", mainPage.isOrderButtonVisible());
    }
}