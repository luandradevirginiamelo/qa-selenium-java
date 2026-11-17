
package base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");

        Map<String, Object> prefs = new HashMap<>();

        // Disable password manager popups
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        // Disable compromised password warnings
        prefs.put(
            "profile.password_manager_leak_detection",
            false
        );

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
