package com.saucedemo.api;

import com.saucedemo.api.models.Product;

public class SauceProductsService extends SauceDemoApi {
    public SauceProductsService() {
        super("/");
    }

    public Product getProduct(Long id) {
        return request().get("/%s".formatted(id))
                .then()
                .extract()
                .response()
                .as(Product.class);
    }
}
