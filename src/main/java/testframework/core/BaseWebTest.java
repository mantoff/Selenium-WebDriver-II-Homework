package testframework.core;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.support.ui.WebDriverWait;
import testframework.Driver;
import testframework.DriverManager;

public abstract class BaseWebTest {

    public static Driver driver() {
        return DriverManager.getDriver();
    }

    public static WebDriverWait driverWait() {
        return driver().getDriverWait();
    }

    @AfterAll
    public static void afterAll() {
        driver().close();
    }
}