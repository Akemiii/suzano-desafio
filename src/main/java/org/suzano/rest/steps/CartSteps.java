package org.suzano.rest.steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import org.suzano.rest.client.CartClient;
import org.suzano.rest.data.factory.CartDataFactory;
import org.suzano.rest.model.CartModelRequest;
import org.suzano.rest.model.response.Cart.CartModelResponse;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.suzano.rest.utils.RequestManager.shared;

public class CartSteps {
    public static CartClient cartClient = new CartClient();
    public static CartModelRequest cart;
    private static final int CART_ID = 1;
    private static final int USER_ID = 1;


    @Quando("realizo uma busca por todos os carrinhos")
    public void realizoUmaBuscaPorTodosOsCarrinhos() {
        shared().setResponse(cartClient.getCartList());
    }

    @E("o corpo da resposta deve conter uma lista de carrinhos")
    public void oCorpoDaRespostaDeveConterUmaListaDeCarrinhos() {
        List<CartModelResponse> cartResponse =
                shared().getResponse()
                        .as(new io.restassured.common.mapper.TypeRef<>() {
                        });
        assertNotNull(cartResponse);
    }

    @Quando("realizo uma busca por um carrinho específico com id {int}")
    public void realizoUmaBuscaPorUmCarrinhoComId(final int id) {
        shared().setResponse(cartClient.getCart(id));
    }

    @E("o corpo da resposta deve conter os dados do carrinho")
    public void oCorpoDaRespostaDeveConterOsDadosDoCarrinho() {
        CartModelResponse cartResponse =
                shared().getResponse()
                        .as(CartModelResponse.class);
        assertAll("cart",
                () -> assertEquals(CART_ID, cartResponse.getId()),
                () -> assertEquals(USER_ID, cartResponse.getUserId()),
                () -> assertNotNull(cartResponse.getProducts())
        );
    }

    @Quando("realizo o cadastro de um novo carrinho com dados completos e válidos")
    public void realizoOCadastroDeUmNovoCarrinhoComDadosCompletosEValidos() {
        cart = CartDataFactory.validCart();
        shared().setResponse(cartClient.postCart(cart));
    }

    @E("o corpo da resposta deve conter os dados do novo carrinho")
    public void oCorpoDaRespostaDeveConterOsDadosDoNovoCarrinho() {
        CartModelResponse cartResponse =
                shared().getResponse()
                        .as(CartModelResponse.class);
        assertAll("cart",
                () -> assertEquals(cart.getId(), cartResponse.getId()),
                () -> assertEquals(cart.getUserId(), cartResponse.getUserId()),
                () -> assertNotNull(cartResponse.getProducts())
        );
    }

    @Quando("realizo o cadastro de um novo carrinho com campos obrigatórios ausentes")
    public void realizoOCadastroDeUmNovoCarrinhoComCamposObrigatoriosAusentes() {
        cart = CartDataFactory.invalidCart();
        shared().setResponse(cartClient.postCart(cart));
    }

    @Quando("realizo a atualização de um carrinho existente com dados válidos")
    public void realizoAAtualizacaoDeUmCarrinhoExistenteComDadosValidos(){
        cart = CartDataFactory.updatedCart();
        shared().setResponse(cartClient.putCart(cart, CART_ID));
    }

    @E("os dados do carrinho devem ser atualizados corretamente")
    public void oCorpoDaRespostaDeveConterOsDadosDoCarrinhoAtualizado() {
        CartModelResponse cartResponse =
                shared().getResponse()
                        .as(CartModelResponse.class);
        assertAll("cart",
                () -> assertEquals(cart.getId(), cartResponse.getId()),
                () -> assertEquals(cart.getUserId(), cartResponse.getUserId()),
                () -> assertNotNull(cartResponse.getProducts())
        );
    }

    @Quando("realizo a exclusão de um carrinho existente com id {int}")
    public void realizoAExclusaoDeUmCarrinhoExistenteComId1(final int id) {
        shared().setResponse(cartClient.deleteCart(id));
    }

    @Quando("realizo a exclusão de um carrinho inexistente com id {int}")
    public void realizoAExclusaoDeUmCarrinhoInexistenteComId(final int id) {
        shared().setResponse(cartClient.deleteCart(id));
    }

}
