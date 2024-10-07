package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testframework.PropertiesManager;

public class AtlassianHomePage extends BaseJiraPage{

    private final By goalsCloseBtn = By.cssSelector("button[class*='css-1fx4wg5']");
    private final By greetingText = By.className("css-xtidjr");
    private final By apps = By.className("css-1celsnm");

    public AtlassianHomePage() {
        super("/");
    }

    /*public void closeGoalsSuggestion() {
        driver().findElement(goalsCloseBtn).click();
    }*/

    public void goToJira() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(apps));
        WebElement jiraBtn = driver().findElements(apps).stream().filter(e -> e.getText().equals("Jira"))
                .findFirst().get();
        jiraBtn.click();
    }
}
