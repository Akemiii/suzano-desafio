package org.suzano.rest.data.factory;

import net.datafaker.Faker;
import org.suzano.rest.model.AuthModelRequest;
import org.suzano.rest.model.UserModelRequest;
import org.suzano.rest.utils.Manipulation;

public class UserDataFactory {
    private static final Faker faker = new Faker();

    public static UserModelRequest validUser(){
        return createValidUser();
    }

    public static UserModelRequest invalidUser(){
        return createInvalidUser();
    }

    public static UserModelRequest userWithInvalidType(){
        return createUserWithInvalidType();
    }

    public static AuthModelRequest authenticatedUser() {
        return createAuthenticatedUser();
    }

    public static AuthModelRequest userAuthenticatedWithPasswordInvalid() {
        return createAuthenticatedUserWithInvalidPassword();
    }

    public static AuthModelRequest userAuthenticatedWithUsernameInvalid() {
        return createAuthenticatedUserWithInvalidUsername();
    }

    public static AuthModelRequest AuthenticatedUserWithoutUsername() {
        return createAuthenticatedUserWithoutUsername();
    }

    private static UserModelRequest createValidUser(){
        UserModelRequest user = new UserModelRequest();
        user.setId(12);
        user.setPassword(faker.internet().password());
        user.setUsername(faker.name().username());
        user.setEmail(faker.internet().emailAddress());
        return user;
    }

    private static UserModelRequest createInvalidUser(){
        UserModelRequest user = new UserModelRequest();
        user.setId(0);
        user.setPassword(faker.internet().password());
        return user;
    }

    private static UserModelRequest createUserWithInvalidType() {
        UserModelRequest user = new UserModelRequest();
        user.setId(faker.number().numberBetween(15, 100));
        user.setPassword(faker.internet().password());
        user.setUsername(faker.name().username());
        user.setEmail(faker.phoneNumber().cellPhone());
        return user;
    }

    private static AuthModelRequest createAuthenticatedUser() {
        AuthModelRequest authUser = new AuthModelRequest();
        authUser.setUsername(Manipulation.getUserName());
        authUser.setPassword(Manipulation.getUserPassword());
        return authUser;
    }

    private static AuthModelRequest createAuthenticatedUserWithInvalidPassword() {
        AuthModelRequest authUser = new AuthModelRequest();
        authUser.setUsername(Manipulation.getUserName());
        authUser.setPassword("senhaInvalida");
        return authUser;
    }

    private static AuthModelRequest createAuthenticatedUserWithInvalidUsername() {
        AuthModelRequest authUser = new AuthModelRequest();
        authUser.setUsername("UsuarioInvalido");
        authUser.setPassword(Manipulation.getUserPassword());
        return authUser;
    }

    private static AuthModelRequest createAuthenticatedUserWithoutUsername() {
        AuthModelRequest authUser = new AuthModelRequest();
        authUser.setPassword(Manipulation.getUserPassword());
        return authUser;
    }
}
