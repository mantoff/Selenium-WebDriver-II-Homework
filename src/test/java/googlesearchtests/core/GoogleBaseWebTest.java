package googlesearchtests.core;

import com.google.pages.CookieConsentPage;
import com.google.pages.ResultsPage;
import com.google.pages.SearchPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;

public class GoogleBaseWebTest extends BaseWebTest {
    protected SearchPage searchPage;
    protected ResultsPage resultsPage;
    protected CookieConsentPage cookieConsentPage;

    @BeforeEach
    public void beforeTests() {
        // perform some code before each test starts

        searchPage = new SearchPage();
        resultsPage = new ResultsPage();
        cookieConsentPage = new CookieConsentPage();

        // Navigate to base page
        driver().get(PropertiesManager.getConfigProperties().getProperty("googleBaseUrl"));

        acceptCookieConsent();
    }

    @BeforeAll
    public static void beforeAll() {
        // perform some code before all tests start
    }

    // close driver
    @AfterEach
    public void afterTest() {
        driver().close();
        // perform some code after each test has finished
    }

    @AfterAll
    public static void afterAll() {
        // perform some code after all tests have finished
    }

    // Extract methods that use multiple pages
    public void acceptCookieConsent() {
        cookieConsentPage.agreeWithCookieConsent();
    }
}