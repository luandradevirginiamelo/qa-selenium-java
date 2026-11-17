
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By menuButton =
        By.id("react-burger-menu-btn");

    private final By logoutLink =
        By.id("logout_sidebar_link");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
            driver,
            Duration.ofSeconds(10)
        );
    }

    public void logout() {
        driver.findElement(menuButton).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(logoutLink)
        ).click();
    }
}
