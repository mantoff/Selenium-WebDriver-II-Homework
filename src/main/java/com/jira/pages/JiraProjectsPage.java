package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testframework.Driver;

public class JiraProjectsPage extends BaseJiraPage {

    public JiraProjectsPage() {
        super("/");
    }

    private final By createGlobalBtn = By.id("createGlobalItem");
    private final By issueTypeDropdown = By.cssSelector("input[id*='type-picker-uid']");
    private final By summaryField = By.id("summary-field");
    private final By descriptionField = By.xpath("//div[@id='ak-editor-textarea']");
    private final By priorityField = By.id("priority-field");
    private final By assignToMeBtn = By.cssSelector("button[data-testid*='assignee']");
    private final By createBtn = By.cssSelector("button[data-testid*='create-button']");
    private final By creationConfirmation = By.className("css-14lcwon");

    JavascriptExecutor js = driver();

    public void createIssue(String issueType, String summary,String desc, String priority) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(createGlobalBtn));
        driver().findElement(createGlobalBtn).click();
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(issueTypeDropdown));
        driver().findElement(issueTypeDropdown).sendKeys(issueType, Keys.ENTER);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(summaryField));
        driver().findElement(summaryField).sendKeys(summary);
        //js.executeScript("arguments[0].scrollIntoView();", descriptionField);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(descriptionField));
        driver().findElement(descriptionField).sendKeys(desc);
        driver().findElement(priorityField).sendKeys(priority, Keys.ENTER);
        driver().findElement(assignToMeBtn).click();
        driver().findElement(createBtn).click();
    }

    public boolean isIssueCreated() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(creationConfirmation));
        return driver().findElement(creationConfirmation).getText().contains("created");
    }
}
