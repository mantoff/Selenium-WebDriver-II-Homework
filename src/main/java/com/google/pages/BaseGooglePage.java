package com.google.pages;

import testframework.PropertiesManager;
import testframework.core.BaseWebPage;

public class BaseGooglePage extends BaseWebPage {

    public BaseGooglePage(String pageSpecificUrl) {
        super(pageSpecificUrl);
    }

    @Override
    public String getBasePageUrl() { return PropertiesManager.getConfigProperties().getProperty("googleBaseUrl"); }
}