
package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cartIcon =
        By.className("shopping_cart_link");

    private final By checkoutButton =
        By.id("checkout");

    private final By continueButton =
        By.id("continue");

    private final By errorMessage =
        By.cssSelector("[data-test='error']");

    private final By firstNameField =
        By.id("first-name");

    private final By lastNameField =
        By.id("last-name");

    private final By postalCodeField =
        By.id("postal-code");

    private final By finishButton =
        By.id("finish");

    private final By confirmationMessage =
        By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
            driver,
            Duration.ofSeconds(10)
        );
    }

    public void goToCheckout() {
        wait.until(
            ExpectedConditions.elementToBeClickable(cartIcon)
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(checkoutButton)
        ).click();

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(firstNameField)
        );
    }

    public void continueWithoutInformation() {
        wait.until(
            ExpectedConditions.elementToBeClickable(continueButton)
        ).click();
    }

    public String getErrorMessage() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(errorMessage)
        ).getText();
    }

    public void fillCheckoutInformation(
            String firstName,
            String lastName,
            String postalCode) {

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(firstNameField)
        ).sendKeys(firstName);

        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);

        wait.until(
            ExpectedConditions.elementToBeClickable(continueButton)
        ).click();
    }

    public void finishPurchase() {
        wait.until(
            ExpectedConditions.urlContains("checkout-step-two.html")
        );

        wait.until(
            ExpectedConditions.elementToBeClickable(finishButton)
        ).click();
    }

    public String getConfirmationMessage() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                confirmationMessage
            )
        ).getText();
    }
}
