
package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.MenuPage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest extends BaseTest {

    @Test
    void shouldLogoutSuccessfully() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
            "standard_user",
            "secret_sauce"
        );

        MenuPage menuPage = new MenuPage(driver);
        menuPage.logout();

        assertTrue(
            driver.getCurrentUrl().contains("saucedemo.com")
                && !driver.getCurrentUrl().contains("inventory.html"),
            "User should be redirected to the login page after logout"
        );
    }
}
