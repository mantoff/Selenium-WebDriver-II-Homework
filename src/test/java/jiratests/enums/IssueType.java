package jiratests.enums;

public enum IssueType {
    IMPROVEMENT("Improvement"),
    TASK("Task"),
    BUG("Bug"),
    EPIC("Epic"),
    NEW_FEATURE("New Feature");

    final String value;

    IssueType(String propName) {
        value = propName;
    }

    public String getValue() {
        return value;
    }
}
