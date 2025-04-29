package org.suzano.rest.client;

import io.restassured.response.Response;
import org.suzano.rest.model.AuthModelRequest;
import org.suzano.rest.model.CartModelRequest;
import org.suzano.rest.model.ProductModelRequest;
import org.suzano.rest.model.UserModelRequest;

import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.suzano.rest.utils.RequestManager.shared;

public abstract class BaseClient {
    final String BASE_URL = "https://fakestoreapi.com";

    public Response doGetReqest(String resource) {
        return
                given().
                        spec(shared().getRequest())
                        .when()
                        .get(resource);
    }

    public Response doGetReqest(String resource, int id) {
        return
                given().
                        spec(shared().getRequest())
                        .when()
                        .pathParams("id", id)
                        .get(resource + "/{id}");
    }


    public Response doPostRequest(String resource, AuthModelRequest authUser) {
        return
                given()
                        .spec(shared().getRequest())
                        .contentType("application/json")
                        .body(authUser)
                        .when()
                        .post(resource);
    }

    public Response doPostRequest(String resource, UserModelRequest user) {
        return
                given()
                        .spec(shared().getRequest())
                        .contentType("application/json")
                        .body(user)
                        .when()
                        .post(resource);
    }

    public Response doPostRequest(String resource, ProductModelRequest product) {
        return
                given()
                        .spec(shared().getRequest())
                        .contentType("application/json")
                        .body(product)
                        .when()
                        .post(resource);
    }

    public Response doPostRequest(String resource, CartModelRequest cart) {
        return
                given()
                        .spec(shared().getRequest())
                        .contentType("application/json")
                        .body(cart)
                        .when()
                        .log().all()
                        .post(resource);
    }

     public Response doPutRequest(String resource, Object body, int id) {
        return
                given()
                        .spec(shared().getRequest())
                        .contentType("application/json")
                        .body(body)
                        .pathParam("id", id)
                        .when()
                        .log().all()
                        .put(resource + "/{id}");
    }

    public Response doDeleteRequest(String resource, int id) {
        return
                given()
                        .spec(shared().getRequest())
                        .contentType("application/json")
                        .pathParam("id", id)
                        .when()
                        .delete(resource + "/{id}");
    }

}
