package org.suzano.rest.client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.suzano.rest.utils.RequestManager.shared;

public abstract class BaseClient {
    static final String BASE_URL = "https://fakestoreapi.com";
    public static final String ID = "/{id}";
    public static final String CONTENT_TYPE = "application/json";
    public static final String PATH_PARAMS = "id";

    protected BaseClient(){
        shared().setBaseURI(BASE_URL);
    }

    private RequestSpecification baseRequest() {
        return given().spec(shared().getRequest()).contentType(CONTENT_TYPE);
    }

    public Response doGetRequest(String resource) {
        return
                baseRequest()
                        .when()
                        .get(resource);
    }

    public Response doGetRequest(String resource, int id) {
        return
                baseRequest()
                        .when()
                        .pathParams(PATH_PARAMS, id)
                        .get(resource + ID);
    }


    public Response doPostRequest(String resource, Object body) {
        return baseRequest()
                .body(body)
                .when()
                .post(resource);
    }

     public Response doPutRequest(String resource, Object body, int id) {
        return
                baseRequest()
                        .body(body)
                        .pathParam(PATH_PARAMS, id)
                        .when()
                        .put(resource + ID);
    }

    public Response doDeleteRequest(String resource, int id) {
        return
                baseRequest()
                        .pathParam(PATH_PARAMS, id)
                        .when()
                        .delete(resource + ID);
    }

}
