package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutCompletePage extends BaseSauceDemoPage {
    public CheckoutCompletePage() {
        super("/checkout-complete.html");
    }

    private final By cartBadge = By.cssSelector("span[data-test='shopping-cart-badge']");
    private final By inventoryItems = By.className("inventory_item_name");

    public WebElement getBadge() {
        return driver().findElement(cartBadge);
    }

    public List<WebElement> getShoppingCartItems() { return driver().findElements(inventoryItems); }
}
