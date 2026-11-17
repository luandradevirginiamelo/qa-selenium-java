
package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.InventoryPage;
import pages.CheckoutPage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTest extends BaseTest {

    @Test
    void shouldShowErrorWhenCheckoutInformationIsMissing() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.goToCheckout();
        checkoutPage.continueWithoutInformation();

        assertTrue(
            checkoutPage.getErrorMessage()
                .contains("First Name is required"),
            "An error should appear when required fields are empty"
        );
    }

    @Test
    void shouldCompletePurchaseSuccessfully() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.goToCheckout();

        checkoutPage.fillCheckoutInformation(
            "Test",
            "User",
            "12345"
        );

        checkoutPage.finishPurchase();

        assertEquals(
            "Thank you for your order!",
            checkoutPage.getConfirmationMessage(),
            "Purchase confirmation message should be displayed"
        );
    }
}
