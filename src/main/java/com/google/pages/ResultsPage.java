package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ResultsPage extends BaseGooglePage {
    public ResultsPage() {
        super("/search");
    }

    // Locators
    private final By resultHeadersLocator = By.xpath("//a/h3");

    // Actions
    public List<WebElement> getSearchResults() {
        driverWait().until(ExpectedConditions.numberOfElementsToBeMoreThan(resultHeadersLocator, 1));
        return driver().findElements(resultHeadersLocator);
    }
}