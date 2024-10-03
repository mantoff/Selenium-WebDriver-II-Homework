package saucedemotests.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import saucedemotests.core.SauceDemoBaseWebTest;
import saucedemotests.enums.TestData;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductsTests extends SauceDemoBaseWebTest {
    public final String BACKPACK_TITLE = "Sauce Labs Backpack";
    public final String SHIRT_TITLE = "Sauce Labs Bolt T-Shirt";

    @BeforeEach
    public void beforeTest() {
        // Authenticate with Standard user
        loginPage.submitLoginForm(TestData.STANDARD_USER_USERNAME.getValue(), TestData.STANDARD_USER_PASSWORD.getValue());
        inventoryPage.waitForPageTitle();

        // Add products to shopping cart
        inventoryPage.addProductsByTitle(BACKPACK_TITLE, SHIRT_TITLE);

        // Go to shopping cart
        inventoryPage.clickShoppingCartLink();

    }

    @Test
    public void productAddedToShoppingCart_when_addToCart() {
        // Add products to shopping cart

        // Go to shopping cart

        // Assert Items and Totals
        List<WebElement> shoppingCartItems = shoppingCartPage.getShoppingCartItems();
        assertAll(() -> assertEquals(BACKPACK_TITLE, shoppingCartItems.get(0).getText(),
                        "Product title not as expected:"),
                () -> assertEquals(SHIRT_TITLE, shoppingCartItems.get(1).getText(),
                        "Product title not as expected:"),
                () -> assertEquals(2, shoppingCartItems.size(), "Items count not as expected"));
    }

    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation() {
        // Add products to shopping cart

        // Go to shopping cart

        // Go to checkout
        shoppingCartPage.clickCheckout();

        // Fill form
        checkoutYourInformationPage.fillShippingDetails("John", "Doe", "1234");

        // Continue
        checkoutYourInformationPage.clickContinue();

        // Assert Cart Items number
        List<WebElement> shoppingCartItems = checkoutOverviewPage.getShoppingCartItems();
        Assertions.assertEquals(2, shoppingCartItems.size());

        // Calculate expected total cost
        double expectedTotalCost = checkoutOverviewPage.getTotalPrice();
        double actualTotalCost = Double.parseDouble(checkoutOverviewPage.getTotalLabelText()
                .replace("Total: $", "").trim());

        // Assert Cart Items Titles and total cost
        assertAll(() -> assertEquals(BACKPACK_TITLE, checkoutOverviewPage.getShoppingCartItems().get(0).getText(),
                        "Product title not as expected:"),
                () -> assertEquals(SHIRT_TITLE, checkoutOverviewPage.getShoppingCartItems().get(1).getText(),
                        "Product title not as expected:"),
                () -> assertEquals(expectedTotalCost, actualTotalCost, "Total cost not as expected"));
    }

    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm() {
        // Add Backpack and T-shirt to shopping cart

        // Click on shopping Cart

        // Go to Billing Info
        shoppingCartPage.clickCheckout();
        // Fill form
        checkoutYourInformationPage.fillShippingDetails("John", "Doe", "1234");
        // Continue
        checkoutYourInformationPage.clickContinue();

        // Assert Items removed from Shopping Cart

        // Complete Order
        checkoutOverviewPage.clickFinish();

        // Assert Shopping cart is empty
        Assertions.assertThrows(NoSuchElementException.class, () -> checkoutCompletePage.getBadge());
    }
}