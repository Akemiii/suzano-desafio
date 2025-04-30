package org.suzano.rest.client;

import io.restassured.response.Response;
import org.suzano.rest.model.UserModelRequest;

import static org.suzano.rest.utils.RequestManager.shared;

public class UserClient extends BaseClient {
    private static final String USERS_ENDPOINT = "/users";

    public UserClient() {
        shared().setBaseURI(BASE_URL);
    }

    public Response getUserList() {
        return doGetRequest(USERS_ENDPOINT);
    }

    public Response getUser(int id) {
        return doGetRequest(USERS_ENDPOINT, id);
    }

    public Response postUser(UserModelRequest user) {
        return doPostRequest(USERS_ENDPOINT, user);
    }

    public Response putUser(UserModelRequest user, int id) {
        return doPutRequest(USERS_ENDPOINT, user, id);
    }

    public Response deleteUser(int id) {
        return doDeleteRequest(USERS_ENDPOINT, id);
    }
}
