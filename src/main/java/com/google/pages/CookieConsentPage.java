package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testframework.core.BaseWebPage;

public class CookieConsentPage extends BaseGooglePage {
    public CookieConsentPage() {
        super("");
    }

    // Locators
    private final By agreeButtonLocator = By.id("L2AGLb");

    // Actions
    public void agreeWithCookieConsent() {
        if (!driver().findElements(agreeButtonLocator).isEmpty()) {
            WebElement agreeButton = driver().findElement(agreeButtonLocator);
            agreeButton.click();
            driverWait().until(ExpectedConditions.invisibilityOfAllElements(agreeButton));
        }
    }
}