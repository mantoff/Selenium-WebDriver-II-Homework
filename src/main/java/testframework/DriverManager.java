package testframework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import testframework.enums.BrowserMode;
import testframework.enums.BrowserType;
import testframework.enums.FrameworkSettings;

public class DriverManager {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static Driver driver;

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static Driver getDriver() {
        if (driver == null || driver.isDisposed()) {
            driver = setupBrowserFromConfig();
        }
        return driver;
    }

    private static Driver setupBrowser(BrowserType browserType, BrowserMode browserMode, Integer defaultTimeoutSeconds) {
        Driver startedDriver;
        switch (browserType) {
            case CHROME: {
                ChromeOptions chromeOptions = new ChromeOptions();
                if (browserMode == BrowserMode.HEADLESS) {
                    LOGGER.info("Starting Chrome browser in headless mode...");
                    chromeOptions.addArguments("--headless");
                } else {
                    LOGGER.info("Starting Chrome browser in normal mode...");
                }
                startedDriver = new Driver(new ChromeDriver(chromeOptions), defaultTimeoutSeconds);
                break;
            }
            case FIREFOX: {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (browserMode == BrowserMode.HEADLESS) {
                    firefoxOptions.addArguments("--headless");
                    LOGGER.info("Starting Firefox browser in headless mode...");
                } else {
                    LOGGER.info("Starting Firefox browser in normal mode...");
                }

                startedDriver = new Driver(new FirefoxDriver(firefoxOptions), defaultTimeoutSeconds);
                break;
            }
            case EDGE: {
                EdgeOptions edgeOptions = new EdgeOptions();
                if (browserMode == BrowserMode.HEADLESS) {
                    edgeOptions.addArguments("--headless");
                    LOGGER.info("Starting Edge browser in headless mode...");
                } else {
                    LOGGER.info("Starting Edge browser in normal mode...");
                }

                startedDriver = new Driver(new EdgeDriver(edgeOptions), defaultTimeoutSeconds);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + browserType);
        }

        if (browserMode == BrowserMode.NORMAL) {
            startedDriver.manage().window().maximize();
        }
        return startedDriver;
    }

    private static Driver setupBrowserFromConfig() {
        try {
            BrowserType browserTypeFromConfig =
                    Enum.valueOf(
                            BrowserType.class,
                            (String) PropertiesManager.getConfigProperties().get(
                                    FrameworkSettings.BROWSER_TYPE.getValue()));

            BrowserMode browserModeFromConfig =
                    Enum.valueOf(
                            BrowserMode.class,
                            (String) PropertiesManager.getConfigProperties().get(
                                    FrameworkSettings.BROWSER_MODE.getValue()));

            Integer timeoutFromConfig =
                    Integer.parseInt(PropertiesManager.getConfigProperties().get(
                            FrameworkSettings.DEFAULT_TIMEOUT_SECONDS.getValue()).toString());

            return setupBrowser(browserTypeFromConfig, browserModeFromConfig, timeoutFromConfig);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to start Driver from config options.", ex);
        }
    }
}
