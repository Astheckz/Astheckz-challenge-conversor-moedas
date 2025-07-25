package br.com.paulo.conversordemoedas.domain;

import java.math.BigDecimal;

public interface ProvedorDeTaxasDeCambio {
    ConversaoMonetaria buscarConversao(String origem, String destino, BigDecimal valor);
}
