
package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstSeleniumTest extends BaseTest {

    @Test
    void shouldLoginWithValidCredentials() {

        driver.findElement(By.id("user-name"))
              .sendKeys("standard_user");

        driver.findElement(By.id("password"))
              .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
              .click();

        assertTrue(
            driver.getCurrentUrl().contains("inventory.html"),
            "User should be redirected to the inventory page"
        );
    }
}
