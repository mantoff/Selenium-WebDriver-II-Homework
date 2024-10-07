package com.jira.pages;

import testframework.PropertiesManager;
import testframework.core.BaseWebPage;

public class BaseJiraPage extends BaseWebPage {

    public BaseJiraPage(String pageSpecificUrl) {
        super(pageSpecificUrl);
    }

    @Override
    public String getBasePageUrl() {
        return PropertiesManager.getConfigProperties().getProperty("jiraBaseUrl");
    }
}
