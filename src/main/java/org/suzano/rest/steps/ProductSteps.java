package org.suzano.rest.steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.restassured.common.mapper.TypeRef;
import org.suzano.rest.client.ProductClient;
import org.suzano.rest.data.factory.ProductDataFactory;
import org.suzano.rest.model.ProductModelRequest;
import org.suzano.rest.model.response.Product.ProductModelResponse;

import java.util.List;

import static org.suzano.rest.utils.RequestManager.shared;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSteps {
    public static final ProductClient productClient = new ProductClient();
    public static final String PRODUCT = "product";
    private ProductModelRequest product;
    private static final int PRODUCT_ID = 3;
    private static final String TITLE = "Mens Cotton Jacket";
    private static final double PRICE = 55.99;

    @Quando("realizo uma busca por todos os produtos")
    public void realizoUmaBuscaPorTodosOsProdutos() {
        shared().setResponse(productClient.getProductList());
    }

    @E("a resposta deve conter uma lista de produtos")
    public void aRespostaDeveConterUmaListaDeProdutos() {
        List<ProductModelResponse> productsResponse =
                shared().getResponse()
                        .as(new TypeRef<>() {
                        });
        assertNotNull(productsResponse);
    }

    @Quando("realizo uma busca por um produto específico com id {int}")
    public void realizoUmaBuscaPorUmProdutoEspecificoComId(int id) {
        shared().setResponse(productClient.getProduct(id));
    }


    @E("o corpo da resposta deve conter os dados do produto")
    public void oCorpoDaRespostaDeveConterOsDadosDoProduto() {
        ProductModelResponse productResponse =
                shared().getResponse()
                        .as(ProductModelResponse.class);
        assertAll(PRODUCT,
                () -> assertEquals(PRODUCT_ID, productResponse.getId()),
                () -> assertEquals(TITLE, productResponse.getTitle()),
                () -> assertEquals(PRICE, productResponse.getPrice())
        );
    }

    @Quando("realizo o cadastro de um novo produto com dados completos e válidos")
    public void realizoOCadastroDeUmNovoProdutoComDadosCompletosEValidos() {
        product = ProductDataFactory.validProduct();
        shared().setResponse(productClient.postProduct(product));
    }

    @E("o corpo da resposta deve conter os dados do novo produto")
    public void oCorpoDaRespostaDeveConterOsDadosDoNovoProduto() {
        ProductModelResponse productResponse =
                shared().getResponse()
                        .as(ProductModelResponse.class);
        assertAll(PRODUCT,
                () -> assertEquals(product.getId(), productResponse.getId()),
                () -> assertEquals(product.getTitle(), productResponse.getTitle()),
                () -> assertEquals(product.getDescription(), productResponse.getDescription()),
                () -> assertEquals(product.getPrice(), productResponse.getPrice()),
                () -> assertEquals(product.getCategory(), productResponse.getCategory()),
                () -> assertEquals(product.getImage(), productResponse.getImage())
        );
    }

    @Quando("realizo o cadastro de um novo produto com campos obrigatórios ausentes")
    public void realizoOCadastroDeUmNovoProdutoComCamposObrigatoriosAusentes() {
        product = ProductDataFactory.invalidProduct();
        shared().setResponse(productClient.postProduct(product));
    }

    @Quando("realizo a atualização de um produto existente com dados válidos")
    public void realizoAAtualizacaoDeUmProdutoExistenteComDadosValidos() {
        product = ProductDataFactory.updatedProduct();
        shared().setResponse(productClient.putProduct(product, PRODUCT_ID));
    }

    @E("os dados do produto devem ser atualizados corretamente")
    public void osDadosDoProdutoDevemSerAtualizadosCorretamente() {
        ProductModelResponse productResponse =
                shared().getResponse()
                        .as(ProductModelResponse.class);
        assertAll(PRODUCT,
                () -> assertEquals(product.getId(), productResponse.getId()),
                () -> assertEquals(product.getTitle(), productResponse.getTitle()),
                () -> assertEquals(product.getDescription(), productResponse.getDescription()),
                () -> assertEquals(product.getPrice(), productResponse.getPrice()),
                () -> assertEquals(product.getCategory(), productResponse.getCategory()),
                () -> assertEquals(product.getImage(), productResponse.getImage())
        );
    }

    @Quando("realizo a exclusão de um produto existente com id {int}")
    public void realizoAExclusaoDeUmProdutoExistenteComId(int id) {
        shared().setResponse(productClient.deleteProdut(id));
    }

    @Quando("realizo a exclusão de um produto inexistente com id {int}")
    public void realizoAExclusaoDeUmProdutoInexistenteComId(int id) {
        shared().setResponse(productClient.deleteProdut(id));
    }
}
