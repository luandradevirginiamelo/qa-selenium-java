
package tests;

import base.BaseTest;
import pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    void shouldLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        assertTrue(
            driver.getCurrentUrl().contains("inventory.html"),
            "User should be redirected to the inventory page"
        );
    }

    @Test
    void shouldShowErrorForInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("invalid_user", "wrong_password");

        assertTrue(
            loginPage.getErrorMessage().contains(
                "Username and password do not match"
            ),
            "An error message should be displayed"
        );
    }

    @Test
    void shouldShowErrorForLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("locked_out_user", "secret_sauce");

        assertTrue(
            loginPage.getErrorMessage().contains(
                "Sorry, this user has been locked out"
            ),
            "A locked-out user should not be able to log in"
        );
    }
}
