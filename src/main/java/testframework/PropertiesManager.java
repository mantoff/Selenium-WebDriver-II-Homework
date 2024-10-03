package testframework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesManager {
    private static final String CONFIG_PROPERTIES = "src/test/resources/config.properties";
    private static final Logger LOGGER = LogManager.getRootLogger();

    private static Properties loadProperties(String url) {
        Properties properties = new Properties();

        try {
            properties.load(Files.newInputStream(Paths.get(url)));
        } catch (IOException ex) {
            LOGGER.error("Loading properties failed!");
        }

        return properties;
    }

    public static Properties getConfigProperties() {
        return loadProperties(CONFIG_PROPERTIES);
    }
}
