package com.saucedemo.pages;

import testframework.PropertiesManager;
import testframework.core.BaseWebPage;

public class BaseSauceDemoPage extends BaseWebPage {
    public BaseSauceDemoPage(String pageSpecificUrl) {
        super(pageSpecificUrl);
    }

    @Override
    public String getBasePageUrl() { return PropertiesManager.getConfigProperties().getProperty("sauceDemoBaseUrl"); }
}
