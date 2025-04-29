package org.suzano.rest.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;

public class RequestManager {
    private static RequestManager sharedInstance;
    @Getter
    @Setter
    private Response response;

    private RequestSpecification request;

    public static synchronized RequestManager shared() {
        if (sharedInstance == null) sharedInstance = new RequestManager();

        return sharedInstance;
    }

    public RequestSpecification getRequest() {
        if (request == null ) request = new RequestSpecBuilder().build();
        return request;
    }

    public void setBaseURI(final String uri) {
        this.getRequest().baseUri(uri);
    }

    public void teardownRequest() {
        this.request = null;
    }

    public void teardownRequestResponse() {
        this.response = null;
    }
}
