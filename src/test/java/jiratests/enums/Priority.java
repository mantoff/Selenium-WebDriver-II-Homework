package jiratests.enums;

public enum Priority {
    HIGHEST("Highest"),
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low"),
    LOWEST("Lowest");

    final String value;

    Priority(String propName) {
        value = propName;
    }

    public String getValue() {
        return value;
    }
}
