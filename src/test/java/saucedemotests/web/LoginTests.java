package saucedemotests.web;

import org.junit.jupiter.api.Test;
import saucedemotests.core.SauceDemoBaseWebTest;
import saucedemotests.enums.TestData;

public class LoginTests extends SauceDemoBaseWebTest {

    @Test
    public void userAuthenticated_when_validCredentialsProvided(){
        // Navigate to Login Page
        loginPage.navigate();

        // Submit login form
        loginPage.submitLoginForm(TestData.STANDARD_USER_USERNAME.getValue(), TestData.STANDARD_USER_PASSWORD.getValue());
        inventoryPage.waitForPageTitle();

        // Assert expected page navigated
        inventoryPage.assertNavigated();
    }
}