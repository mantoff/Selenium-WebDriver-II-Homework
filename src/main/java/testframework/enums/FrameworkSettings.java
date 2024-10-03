package testframework.enums;

public enum FrameworkSettings {
    BROWSER_TYPE("browserType"),
    BROWSER_MODE("browserMode"),
    DEFAULT_TIMEOUT_SECONDS("defaultTimeoutSeconds");

    FrameworkSettings(String propName) {
        value = propName;
    }

    public String getValue() {
        return value;
    }

    final String value;
}
