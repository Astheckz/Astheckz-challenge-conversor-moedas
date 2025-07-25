package br.com.paulo.conversordemoedas.domain;

import java.math.BigDecimal;

public record ConversaoMonetaria (
     String moedaOrigem,
     String moedaDestino,
     BigDecimal taxaDeConversao,
     BigDecimal resultadoDaConversao,
     BigDecimal valor
)
{

    @Override
    public String toString() {
        return "O valor de %.2f [%s] corresponde ao valor final de =>>> %.2f [%s]".formatted(
                this.valor,
                this.moedaOrigem,
                this.resultadoDaConversao,
                this.moedaDestino
        );
    }
}
