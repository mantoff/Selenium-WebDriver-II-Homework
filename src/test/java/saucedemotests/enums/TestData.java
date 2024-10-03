package saucedemotests.enums;

public enum TestData {
    STANDARD_USER_USERNAME("standard_user"),
    STANDARD_USER_LOCKED_OUT_USER("locked_out_user"),
    STANDARD_USER_PROBLEM_USER("problem_user"),
    STANDARD_USER_PERFORMANCE_GLITCH_USER("performance_glitch_user"),
    STANDARD_USER_ERROR_USER("error_user"),
    STANDARD_USER_VISUAL_USER("visual_user"),
    STANDARD_USER_PASSWORD("secret_sauce");

    TestData(String propName) {
        value = propName;
    }

    public String getValue() {
        return value;
    }

    final String value;
}
