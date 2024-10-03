package saucedemotests.api;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import saucedemotests.core.SauceDemoBaseApiTest;

public class SauceDemoApiTests extends SauceDemoBaseApiTest {

    @Test
    @Disabled
    public void userAuthenticated_when_validCredentialsProvided() {
        sauceProductsService.authenticate("username");

        var response = sauceProductsService.request().get("/");

        response.then().assertThat().statusCode(HttpStatus.SC_OK);
    }
}
