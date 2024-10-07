package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseJiraPage {

    public LoginPage() {
        super("/");
    }

    private final By usernameField = By.cssSelector("input[data-testid='username']");
    private final By passwordField = By.cssSelector("input[data-testid='password']");
    private final By skipVerificationBtn = By.id("mfa-promote-dismiss");
    //private final By continueLoginBtn = By.id("login-submit");

    public void login(String username, String password) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver().findElement(usernameField).sendKeys(username, Keys.ENTER);
        driver().findElement(passwordField).sendKeys(password, Keys.ENTER);
    }
}
