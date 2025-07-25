package br.com.paulo.conversordemoedas.client;

import br.com.paulo.conversordemoedas.domain.ConversaoMonetaria;
import br.com.paulo.conversordemoedas.domain.ProvedorDeTaxasDeCambio;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApiClient implements ProvedorDeTaxasDeCambio {
    private final HttpClient client;
    private final Gson gson;

    public ExchangeRateApiClient() {
        this.client = HttpClient.newHttpClient();
        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Override
    public ConversaoMonetaria buscarConversao(String origem, String destino, BigDecimal valor) {
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/SUA-API-KEY/pair/" + origem + "/" + destino + "/" + valor);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //ConversaoApiResponse apiResponse = gson.fromJson(response.body(), ConversaoApiResponse.class);
            ConversaoApiResponse apiResponse = gson.fromJson(response.body(), ConversaoApiResponse.class);

            return new ConversaoMonetaria(
                    apiResponse.baseCode(),
                    apiResponse.targetCode(),
                    apiResponse.conversionRate(),
                    apiResponse.conversionResult(),
                    valor
            );

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
