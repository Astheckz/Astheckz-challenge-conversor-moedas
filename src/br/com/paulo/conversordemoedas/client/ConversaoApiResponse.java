package br.com.paulo.conversordemoedas.client;

import java.math.BigDecimal;

public record ConversaoApiResponse(
        String baseCode,
        String targetCode,
        BigDecimal conversionRate,
        BigDecimal conversionResult
) {
}
