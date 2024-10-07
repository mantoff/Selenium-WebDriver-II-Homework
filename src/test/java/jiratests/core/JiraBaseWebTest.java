package jiratests.core;

import com.jira.pages.AtlassianHomePage;
import com.jira.pages.JiraProjectsPage;
import com.jira.pages.LoginPage;
import jiratests.enums.TestData;
import org.junit.jupiter.api.BeforeEach;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;


public class JiraBaseWebTest extends BaseWebTest {

    protected LoginPage loginPage;
    protected AtlassianHomePage atlassianHomePage;
    protected JiraProjectsPage jiraProjectsPage;

    @BeforeEach
    public void beforeTests() {
        // perform some code before each test starts

        loginPage = new LoginPage();
        atlassianHomePage = new AtlassianHomePage();
        jiraProjectsPage = new JiraProjectsPage();

        // Navigate to base page
        driver().get(PropertiesManager.getConfigProperties().getProperty("jiraBaseUrl"));

        //Login to Atlassian
        loginPage.login(TestData.USERNAME.getValue(), TestData.PASSWORD.getValue());

        //Go to Jira
        atlassianHomePage.goToJira();
    }

}
