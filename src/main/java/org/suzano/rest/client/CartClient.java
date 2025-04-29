package org.suzano.rest.client;

import io.restassured.response.Response;
import org.suzano.rest.model.CartModelRequest;

import static org.suzano.rest.utils.RequestManager.shared;

public class CartClient extends BaseClient {
    private static final String CART_ENDPOINT = "/carts";

    public CartClient() {
        shared().setBaseURI(BASE_URL);
    }

    public Response getCartList() {
        return doGetReqest(CART_ENDPOINT);
    }

    public Response getCart(int id) {
        return doGetReqest(CART_ENDPOINT, id);
    }

    public Response postCart(CartModelRequest cart) {
        return doPostRequest(CART_ENDPOINT, cart);
    }

    public Response putCart(CartModelRequest cart, int id) {
        return doPutRequest(CART_ENDPOINT, cart, id);
    }

    public Response deleteCart(int id) {
        return doDeleteRequest(CART_ENDPOINT, id);
    }

}
