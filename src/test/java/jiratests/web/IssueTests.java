package jiratests.web;

import jiratests.core.JiraBaseWebTest;
import jiratests.enums.IssueType;
import jiratests.enums.Priority;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IssueTests extends JiraBaseWebTest {

    //change ISSUE_TYPE depending on the issue you want to create, go with Task first and Bug afterward.
    public static final String ISSUE_TYPE = IssueType.TASK.getValue();
    public static final String SUMMARY = String.format("Automated %s creation", ISSUE_TYPE);

    //Description could be changed based on the issue you are creationg
    public static final String TASK_DESC = "While automating a test for a React-based dropdown component, " +
            "the element becomes unclickable or non-interactable. Standard WebDriver locators fail to select the " +
            "dropdown options. JavaScript execution was required to interact with the element, but further investigation" +
            " is needed to understand the root cause and ensure reliable automation across all environments.";
    public static final String BUG_DESC = "Steps to Reproduce:\n" +
            "\n" +
            "Navigate to the page containing the React-based dropdown.\n" +
            "Use Selenium WebDriver to locate and click the dropdown.\n" +
            "Attempt to select any option from the dropdown using findElement or sendKeys().\n" +
            "Observe the behavior when trying to interact with the options.\n" +
            "Actual Result:\n" +
            "\n" +
            "Selenium is unable to interact with or select any options from the dropdown. Options may not be visible in the DOM, and standard locators (CSS or XPath) do not work.\n" +
            "Test fails or throws ElementNotInteractableException.\n" +
            "Expected Result:\n" +
            "\n" +
            "Selenium should be able to click the dropdown and select an option using standard locators.\n" +
            "The options should be visible and interactable, allowing test automation without needing JavaScript execution.";

    public static final String PRIORITY = Priority.LOW.getValue();

    @Test
    public void validateIssueCreation() {
        jiraProjectsPage.createIssue(ISSUE_TYPE, SUMMARY, TASK_DESC, PRIORITY);
        Assertions.assertTrue(jiraProjectsPage.isIssueCreated());
    }
}
