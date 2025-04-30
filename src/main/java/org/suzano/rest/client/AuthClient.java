package org.suzano.rest.client;

import io.restassured.response.Response;
import org.suzano.rest.model.AuthModelRequest;


public class AuthClient extends BaseClient {
    private static final String AUTH_ENDPOINT = "/auth/login";

    public Response doAuthentication(AuthModelRequest authUser) {
        return doPostRequest(AUTH_ENDPOINT, authUser);
    }
}
