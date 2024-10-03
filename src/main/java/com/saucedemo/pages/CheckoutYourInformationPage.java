package com.saucedemo.pages;

import org.openqa.selenium.By;

public class CheckoutYourInformationPage extends BaseSauceDemoPage {
    public CheckoutYourInformationPage() {
        super("/checkout-step-one.html");
    }
    private final By firstNameLocator = By.id("first-name");
    private final By lastNameLocator = By.id("last-name");
    private final By postalCodeLocator = By.id("postal-code");
    private final By continueButton = By.id("continue");

    // Actions
    public void fillShippingDetails(String firstName, String lastName, String zip) {
        driver().findElement(firstNameLocator).sendKeys(firstName);
        driver().findElement(lastNameLocator).sendKeys(lastName);
        driver().findElement(postalCodeLocator).sendKeys(zip);
    }

    public void clickContinue(){
        driver().findElement(continueButton).click();
    }
}
