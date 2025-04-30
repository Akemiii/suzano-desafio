package org.suzano.rest.steps;


import io.cucumber.java.pt.*;
import org.suzano.rest.client.AuthClient;
import org.suzano.rest.data.factory.UserDataFactory;
import org.suzano.rest.model.AuthModelRequest;

import static org.suzano.rest.utils.RequestManager.shared;

public class AuthSteps {
    public static final AuthClient authClient = new AuthClient();
    private String token;
    private AuthModelRequest authUser = new AuthModelRequest();

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
        shared().setResponse(authClient.doAuthentication(UserDataFactory.userAuthenticatedWithPasswordInvalid()));
    }

    @Quando("executo a requisição para realizar autenticação com um usuário não registrado")
    public void executoARequisicaoParaRealizarAutenticacaoComUmUsuarioNaoRegistrado() {
        shared().setResponse(authClient.doAuthentication(UserDataFactory.userAuthenticatedWithUsernameInvalid()));
    }

    @Quando("executo a requisição para realizar autenticação sem informar o campo username")
    public void executoARequisicaoParaRealizarAutenticacaoSemInformarOCampo() {
        shared().setResponse(authClient.doAuthentication(UserDataFactory.authenticatedUserWithoutUsername()));
    }


}
