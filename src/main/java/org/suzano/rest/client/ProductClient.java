package org.suzano.rest.client;

import io.restassured.response.Response;
import org.suzano.rest.model.ProductModelRequest;

import static org.suzano.rest.utils.RequestManager.shared;

public class ProductClient extends BaseClient {
    private static final String PRODUCTS_ENDPOINT = "/products";

    public ProductClient() {
        shared().setBaseURI(BASE_URL);
    }

    public Response getProductList() {
        return doGetRequest(PRODUCTS_ENDPOINT);
    }

    public Response getProduct(int id) {
        return doGetRequest(PRODUCTS_ENDPOINT, id);
    }

    public Response postProduct(ProductModelRequest product) {
        return doPostRequest(PRODUCTS_ENDPOINT, product);
    }

    public Response putProduct(ProductModelRequest product, int id) {
        return doPutRequest(PRODUCTS_ENDPOINT, product, id);
    }

    public Response deleteProdut(int id) {
        return doDeleteRequest(PRODUCTS_ENDPOINT, id);
    }
}
