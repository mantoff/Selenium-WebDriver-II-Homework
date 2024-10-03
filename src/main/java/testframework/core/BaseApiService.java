package testframework.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.specification.RequestSpecification;
import testframework.PropertiesManager;
import testframework.enums.FrameworkSettings;

public abstract class BaseApiService {
    private final String baseUrl;
    private final String servicePath;
    private final Gson serializer;
    private RequestSpecification requestSpecification;

    public BaseApiService(String servicePath, String baseUrl) {
        this.baseUrl = baseUrl;
        this.servicePath = servicePath;

        // configure gson serializer
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        serializer = builder.create();
    }

    public String getServiceUrl() {
        return baseUrl + servicePath;
    }

    public RequestSpecification request() {
        return requestSpecification;
    }

    protected Gson gson() {
        return serializer;
    }

    protected void setRequestSpecification(RequestSpecification req) {
        requestSpecification = req;
    }
}