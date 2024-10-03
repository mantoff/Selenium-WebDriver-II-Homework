package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BaseGooglePage {
    public SearchPage() {
        super("/");
    }

    // Locators
    private final By searchInputLocator = By.name("q");

    public WebElement getSearchInput() {
        WebElement element = driver().findElement(searchInputLocator);
        driverWait().until(ExpectedConditions.visibilityOf(element));
        return element;
    }
    // Actions
    public void searchForTerm(String term) {
        getSearchInput().sendKeys(term);
        getSearchInput().sendKeys(Keys.ENTER);
    }
}