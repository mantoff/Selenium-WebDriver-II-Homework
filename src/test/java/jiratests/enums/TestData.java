package jiratests.enums;

public enum TestData {
    USERNAME("your email"),
    PASSWORD("your password");

    final String value;

    TestData(String propName) {
        value = propName;
    }

    public String getValue() {
        return value;
    }
}
