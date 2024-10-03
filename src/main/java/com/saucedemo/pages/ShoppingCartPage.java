package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends BaseSauceDemoPage {
    public ShoppingCartPage() {
        super("/cart.html");
    }

    // Locators
    private final By inventoryItems = By.className("inventory_item_name");
    private final By checkoutButton = By.id("checkout");

    // Actions
    public List<WebElement> getShoppingCartItems() { return driver().findElements(inventoryItems); }
    public void clickCheckout(){
        driver().findElement(checkoutButton).click();
    }
}