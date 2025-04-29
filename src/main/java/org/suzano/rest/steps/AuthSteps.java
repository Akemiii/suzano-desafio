package org.suzano.rest.steps;


import io.cucumber.java.pt.*;
import org.suzano.rest.client.AuthClient;
import org.suzano.rest.data.factory.UserDataFactory;
import org.suzano.rest.model.AuthModelRequest;

import static org.suzano.rest.utils.RequestManager.shared;

public class AuthSteps {
    public static AuthClient authClient = new AuthClient();
    public static String token;
    public static AuthModelRequest authUser = new AuthModelRequest();

    @Dado("que tenho um usuário válido")
    public void queTenhoUmUsuarioComUsernameEPasswordCorretos() {
        authUser = UserDataFactory.authenticatedUser();
    }

    @Quando("executo a requisição para realizar autenticação")
    public void executoARequisicaoParaRealizarAutenticacao() {
        shared().setResponse(authClient.doAuthentication(authUser));
    }

    @E("a resposta deve conter um token de autenticação válido")
    public void aRespostaDeveConterUmTokenDeAutenticacaoValido() {
        token = shared().getResponse().getBody().jsonPath().getString("token");
    }

    @Quando("executo a requisição para realizar autenticação com password incorreto")
    public void executoARequisicaoParaRealizarAutenticacaoComPasswordIncorreto() {
        AuthModelRequest authUser = UserDataFactory.userAuthenticatedWithPasswordInvalid();
        shared().setResponse(authClient.doAuthentication(authUser));
    }

    @Quando("executo a requisição para realizar autenticação com um usuário não registrado")
    public void executoARequisicaoParaRealizarAutenticacaoComUmUsuarioNaoRegistrado() {
        AuthModelRequest authUser = UserDataFactory.userAuthenticatedWithUsernameInvalid();
        shared().setResponse(authClient.doAuthentication(authUser));
    }

    @Quando("executo a requisição para realizar autenticação sem informar o campo username")
    public void executoARequisicaoParaRealizarAutenticacaoSemInformarOCampo() {
        AuthModelRequest authUser = UserDataFactory.authenticatedUserWithoutUsername();
        shared().setResponse(authClient.doAuthentication(authUser));
    }


}
