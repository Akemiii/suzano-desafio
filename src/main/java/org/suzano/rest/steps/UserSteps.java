package org.suzano.rest.steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.restassured.common.mapper.TypeRef;
import org.suzano.rest.client.UserClient;
import org.suzano.rest.data.factory.UserDataFactory;
import org.suzano.rest.model.UserModelRequest;
import org.suzano.rest.model.response.User.UserModelResponse;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.suzano.rest.utils.RequestManager.shared;

public class UserSteps {
    public static UserClient userClient = new UserClient();
    public static UserModelRequest user;
    private static final int USER_ID = 1;
    private static final String USERNAME = "johnd";
    private static final String CITY = "kilcoole";


    @Quando("realizo uma busca por todos os usuários")
    public void realizoUmaBuscaPorTodoOsUsuarios() {
        shared().setResponse(userClient.getUserList());
    }

    @E("o corpo da resposta deve conter uma lista de usuários")
    public void oCorpoDaRespostaDeveConterAListaDeUsuarios() {
        List<UserModelResponse> users =
                shared().getResponse()
                        .as(new TypeRef<>() {
                        });
        assertNotNull(users);
    }

    @Quando("realizo uma busca por um usuário específico com id {int}")
    public void realizoUmaBuscaPorUmUsuarioEspecificoComId(final int id) {
       shared().setResponse(userClient.getUser(id));
    }

    @E("o corpo da resposta deve conter os dados do usuário")
    public void oCorpoDaRespostaDeveConterOsDadosDoUsuario() {
        UserModelResponse userResponse =
                shared().getResponse()
                        .as(UserModelResponse.class);
        assertAll("user",
                () -> assertEquals(USER_ID, userResponse.getId()),
                () -> assertEquals(USERNAME, userResponse.getUsername()),
                () -> assertEquals(CITY, userResponse.getAddress().getCity())
        );
    }

    @Quando("realizo o cadastro de um novo usuário com dados completos e válidos")
    public void realizoOCadastroDeUmNovoUsuarioComDadosCompletosEValidos() {
        user = UserDataFactory.validUser();
        shared().setResponse(userClient.postUser(user));
    }

    @E("o corpo da resposta deve conter os dados do novo usuário")
    public void oCorpoDaRespostaDeveConterOsDadosDoNovoUsuario() {
        UserModelResponse userResponse =
                shared().getResponse()
                        .as(UserModelResponse.class);

        assertAll("user",
                () -> assertEquals(user.getId(), userResponse.getId()),
                () -> assertEquals(user.getUsername(), userResponse.getUsername()),
                () -> assertEquals(user.getEmail(), userResponse.getEmail())
        );
    }

    @Quando("realizo o cadastro de um novo usuário com campos obrigatórios ausentes")
    public void realizoOCadastroDeUmNovoUsuarioComCamposObrigatoriosAusentes() {
        UserModelRequest invalidUser = UserDataFactory.invalidUser();
        shared().setResponse(userClient.postUser(invalidUser));
    }

    @Quando("realizo o cadastro de um novo usuário com tipos de dados inválidos")
    public void realizoOCadastroDeUmNovoUsuarioComTiposDeDadosInvalidos() {
        UserModelRequest invalidUser = UserDataFactory.userWithInvalidType();
        shared().setResponse(userClient.postUser(invalidUser));
    }

    @Quando("realizo a atualização de um usuário existente com dados válidos")
    public void realizoAAtualizacaoDeUmUsuarioExistenteComDadosValidos() {
        user = UserDataFactory.validUser();
        shared().setResponse(userClient.putUser(user, USER_ID));
    }

    @E("os dados do usuário devem ser atualizados corretamente")
    public void osDadosDoUsuarioDevemSerAtualizadosCorretamente() {
        UserModelResponse userResponse =
                shared().getResponse()
                        .as(UserModelResponse.class);

        assertAll("user",
                () -> assertEquals(user.getId(), userResponse.getId()),
                () -> assertEquals(user.getUsername(), userResponse.getUsername()),
                () -> assertEquals(user.getEmail(), userResponse.getEmail())
        );
    }

    @Quando("realizo a exclusão de um usuário existente com id {int}")
    public void realizoAExclusaoDeUmUsuarioExistenteComId(final int id) {
        shared().setResponse(userClient.deleteUser(id));
    }

    @Quando("realizo a exclusão de um usuário inexistente com id {int}")
    public void realizoAExclusaoDeUmUsuarioInexistenteComId(final int id) {
        shared().setResponse(userClient.deleteUser(id));
    }

}