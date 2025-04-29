package org.suzano.rest.data.factory;

import net.datafaker.Faker;
import org.suzano.rest.model.ProductModelRequest;

public class ProductDataFactory {
    private static final Faker faker = new Faker();

    public static ProductModelRequest validProduct() {
        return createValidProduct();
    }

    public static ProductModelRequest invalidProduct() {
        return createInvalidProduct();
    }

    public static ProductModelRequest updatedProduct() {
        return updateProduct();
    }

    private static ProductModelRequest createValidProduct() {
        ProductModelRequest product = new ProductModelRequest();
        product.setId(21);
        product.setTitle(faker.commerce().productName());
        product.setDescription(faker.commerce().material());
        product.setPrice(faker.number().randomDouble(2, 10, 100));
        product.setCategory(faker.commerce().department());
        product.setImage(faker.lorem().sentence());
        return product;
    }

    private static ProductModelRequest createInvalidProduct() {
        ProductModelRequest product = new ProductModelRequest();
        product.setId(0);
        product.setTitle(faker.commerce().productName());
        return product;
    }

    private static ProductModelRequest updateProduct() {
        ProductModelRequest product = new ProductModelRequest();
        product.setId(3);
        product.setTitle(faker.commerce().productName());
        product.setDescription(faker.commerce().material());
        product.setPrice(faker.number().randomDouble(2, 10, 100));
        product.setCategory(faker.commerce().department());
        product.setImage(faker.lorem().sentence());
        return product;
    }

}
