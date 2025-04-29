package org.suzano.rest.steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.suzano.rest.utils.RequestManager.shared;

public class CommonSteps {

    @Entao("o status da resposta deve ser {int}")
    public void oStatusDaRespostaDeveSer(final int statusCode) {
        shared().getResponse().then().statusCode(statusCode);
    }

    @E("o tempo da resposta deve ser menor que {int} milissegundos")
    public void oTempoDaRespostaDeveSerMenorQueMilissegundos(int tempoMaximo) {
        long tempoResposta = shared().getResponse().time();
        assertTrue(tempoResposta < tempoMaximo, "O tempo de resposta excedeu o limite esperado!");
    }

}
