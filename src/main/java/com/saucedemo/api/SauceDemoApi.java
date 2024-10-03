package com.saucedemo.api;

import io.restassured.http.ContentType;
import testframework.PropertiesManager;
import testframework.core.BaseApiService;

import static io.restassured.RestAssured.given;

public class SauceDemoApi extends BaseApiService {
    public SauceDemoApi(String path) {
        super(path, PropertiesManager.getConfigProperties().getProperty("add_config_key_here"));
    }

    public void authenticate(String username){
        setRequestSpecification(
                given()
                .contentType(ContentType.JSON)
                        .baseUri(getServiceUrl())
// Uncomment to set authentication cookie from resources
//                .cookie("JSESSIONID", PropertiesManager.getConfigProperties().getProperty(String.format("%s.apikey", username)))
        );
    }
}
