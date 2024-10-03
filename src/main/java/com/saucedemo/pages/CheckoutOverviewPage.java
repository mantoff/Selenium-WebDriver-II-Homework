package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckoutOverviewPage extends BaseSauceDemoPage {
    public CheckoutOverviewPage() {
        super("/checkout-step-two.html");
    }

    private final By inventoryItems = By.className("inventory_item_name");
    private final By summaryTotalLabel = By.className("summary_total_label");
    private final By cartButton = By.xpath("//*[contains(@class,'cart_button')]");
    private final By itemPrice = By.className("inventory_item_price");
    private final By taxPrice = By.cssSelector("div[data-test='tax-label']");

    public List<WebElement> getShoppingCartItems() { return driver().findElements(inventoryItems); }

    public String getTotalLabelText() {
        return driver().findElement(summaryTotalLabel).getText();
    }
    public void clickFinish() {
        driver().findElement(cartButton).click();
    }

    public Double getTotalPrice() {
        return driver().findElements(itemPrice).stream().mapToDouble(p -> Double.parseDouble(p.getText()
                .replace("$", "").trim())).sum() +
                Double.parseDouble(driver().findElement(taxPrice).getText().replace("Tax: $", "").trim());
    }
}
