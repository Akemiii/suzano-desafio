package org.suzano.rest.client;

import io.restassured.response.Response;
import org.suzano.rest.model.AuthModelRequest;

import static org.suzano.rest.utils.RequestManager.shared;

public class AuthClient extends BaseClient {
    private static final String AUTH_ENDPOINT = "/auth/login";

    public AuthClient() {
        shared().setBaseURI(BASE_URL);
    }

    public Response doAuthentication(AuthModelRequest authUser) {
        return doPostRequest(AUTH_ENDPOINT, authUser);
    }
}
