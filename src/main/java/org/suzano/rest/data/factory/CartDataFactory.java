package org.suzano.rest.data.factory;

import net.datafaker.Faker;
import org.suzano.rest.model.CartModelRequest;

import java.util.List;

public class CartDataFactory {
    private static final Faker faker = new Faker();

    public static CartModelRequest validCart() {
        return createValidCart();
    }

    public static CartModelRequest invalidCart() {
        return createInvalidCart();
    }

    public static CartModelRequest updatedCart() {
        return updateCart();
    }

    private static CartModelRequest createValidCart() {
        CartModelRequest cart = new CartModelRequest();
        cart.setId(11);
        cart.setUserId(faker.number().numberBetween(1, 10));
        cart.setProducts(
                List.of(
                        ProductDataFactory.validProduct()
                ));
        return cart;
    }

    private static CartModelRequest createInvalidCart() {
        CartModelRequest cart = new CartModelRequest();
        cart.setId(0);
        cart.setUserId(faker.number().numberBetween(1, 10));
        return cart;
    }

    private static CartModelRequest updateCart() {
        CartModelRequest cart = new CartModelRequest();
        cart.setId(1);
        cart.setUserId(faker.number().numberBetween(1, 10));
        cart.setProducts(
                List.of(
                        ProductDataFactory.validProduct()
                ));
        return cart;
    }


}
