package testframework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Driver implements WebDriver {

    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;
    private final Actions actions;
    private Boolean isDisposed;
    private static final Logger LOGGER = LogManager.getRootLogger();

    public Driver(WebDriver driver, Integer defaultTimeoutSeconds) {
        Duration timeout = Duration.ofSeconds(defaultTimeoutSeconds);
        webDriver = driver;
        webDriverWait = new WebDriverWait(driver, timeout);
        actions = new Actions(driver);
        isDisposed = false;
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }
    public WebDriverWait getDriverWait() {
        return this.webDriverWait;
    }

    public Boolean isDisposed() {
        return isDisposed;
    }

    @Override
    public void get(String s) {
        LOGGER.info("Navigating to page: " + s);
        webDriver.get(s);
    }

    @Override
    public String getCurrentUrl() {
        String currentUrl = webDriver.getCurrentUrl();
        LOGGER.info("Getting current URL: " + currentUrl);
        return currentUrl;
    }

    @Override
    public String getTitle() {
        String currentTitle = webDriver.getTitle();
        LOGGER.info("Getting Title: " + currentTitle);
        return currentTitle;
    }

    @Override
    public List<WebElement> findElements(By by) {
        LOGGER.info("Finding all element with locator: " + by.toString());
        return webDriver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        LOGGER.info("Finding element with locator: " + by.toString());
        WebElement elementFound = webDriver.findElement(by);
        return webDriverWait.until(ExpectedConditions.visibilityOf(elementFound));
    }

    @Override
    public String getPageSource() {
        LOGGER.info("Getting page source...");
        return webDriver.getPageSource();
    }

    @Override
    public void close() {
        if (webDriver != null && !isDisposed) {
            LOGGER.info("Closing Browser...");
            webDriver.close();
            isDisposed = true;
        }
    }

    @Override
    public void quit() {
        LOGGER.info("Quiting driver...");
        webDriver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        LOGGER.info("Getting Window handles...");
        return webDriver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return webDriver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return webDriver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return webDriver.navigate();
    }

    @Override
    public Options manage() {
        return webDriver.manage();
    }

    // Add custom Driver methods
    public void scrollToElement(By locator) {
        actions.scrollToElement(webDriver.findElement(locator)).perform();
    }
}
