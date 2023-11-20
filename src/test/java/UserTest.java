import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserTest extends Base {

    @Before
    public void setUp() {
        mainPage.clickLogin();
        loginPage.waitForLoadElement();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLoginButton();
        mainPage.waitForLoadElement();
    }

    @Test
    @DisplayName("click on “Personal Account”")
    public void clickOnPersonalAccountTest() {
        userPage.clickPersonalAccount();
        assertTrue("there was a transition to your personal account", userPage.isProfileButtonVisible());
    }

    @Test
    @DisplayName("from the personal account to the “Constructor” button")
    public void fromPersonalAccountConstructorButtonTest() {
        userPage.fromPersonalAccountConstructorButton();
        assertTrue("go to constructor completed", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("from the personal account to the designer by logo")
    public void fromPersonalAccountDesignerByLogoTest() {
        userPage.fromPersonalAccountDesignerByLogo();
        assertTrue("go to constructor completed", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("exit using the “Logout” button in your personal account")
    public void logoutButtonLogoutTest() {
        userPage.logout();
        assertTrue("log out", loginPage.isEnterLabelVisible());
    }
}