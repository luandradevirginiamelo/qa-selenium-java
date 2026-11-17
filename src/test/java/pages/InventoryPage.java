
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private final WebDriver driver;

    private final By addBackpackButton =
        By.id("add-to-cart-sauce-labs-backpack");

    private final By removeBackpackButton =
        By.id("remove-sauce-labs-backpack");

    private final By addBikeLightButton =
        By.id("add-to-cart-sauce-labs-bike-light");

    private final By cartBadge =
        By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBackpackToCart() {
        driver.findElement(addBackpackButton).click();
    }

    public void removeBackpackFromCart() {
        driver.findElement(removeBackpackButton).click();
    }

    public void addBikeLightToCart() {
        driver.findElement(addBikeLightButton).click();
    }

    public String getCartItemCount() {
        return driver.findElement(cartBadge).getText();
    }

    public boolean isCartEmpty() {
        return driver.findElements(cartBadge).isEmpty();
    }
}
