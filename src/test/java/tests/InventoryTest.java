
package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.InventoryPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryTest extends BaseTest {

    @Test
    void shouldAddBackpackToCart() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();

        assertEquals(
            "1",
            inventoryPage.getCartItemCount(),
            "Cart should contain one product"
        );
    }

    @Test
    void shouldRemoveBackpackFromCart() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.addBackpackToCart();
        inventoryPage.removeBackpackFromCart();

        assertTrue(
            inventoryPage.isCartEmpty(),
            "Cart should be empty after removing the product"
        );
    }

    
@Test
void shouldAddMultipleProductsToCart() {

    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("standard_user", "secret_sauce");

    InventoryPage inventoryPage = new InventoryPage(driver);

    inventoryPage.addBackpackToCart();
    inventoryPage.addBikeLightToCart();

    assertEquals(
        "2",
        inventoryPage.getCartItemCount(),
        "Cart should contain two products"
    );
}

}
