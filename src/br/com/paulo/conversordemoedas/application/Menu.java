package br.com.paulo.conversordemoedas.application;

import br.com.paulo.conversordemoedas.client.ExchangeRateApiClient;
import br.com.paulo.conversordemoedas.domain.ConversaoMonetaria;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void exibir() {
        ExchangeRateApiClient exchangeRateApiClient = new ExchangeRateApiClient();
        try (Scanner sc = new Scanner(System.in)) {

            int opcao = 0;

            while (opcao != 7) {
                System.out.println("*****************************************");
                System.out.println("Seja bem-vindo/a ao Conversor de Moeda =] ");

                System.out.println("\n1) Dólar =>> Peso argentino");
                System.out.println("2) Peso argentino =>> Dólar");
                System.out.println("3) Dólar =>> Real brasileiro");
                System.out.println("4) Real brasileiro =>> Dólar");
                System.out.println("5) Dólar =>> Peso colombiano");
                System.out.println("6) Peso colombiano =>> Dólar");
                System.out.println("7) Sair");
                System.out.println("\nEscolha uma opção Válida: ");
                System.out.println("*****************************************");

                try {
                    opcao = sc.nextInt();
                    BigDecimal valor = BigDecimal.ZERO;


                    if (opcao != 7) {
                        System.out.println("Digite o valor que deseja converter");
                        valor = BigDecimal.valueOf(sc.nextDouble());
                    }

                    ConversaoMonetaria resultadoConversao = null;
                    switch (opcao) {
                        case 1 -> resultadoConversao = exchangeRateApiClient.buscarConversao("USD", "ARS", valor);
                        case 2 -> resultadoConversao = exchangeRateApiClient.buscarConversao("ARS", "USD", valor);
                        case 3 -> resultadoConversao = exchangeRateApiClient.buscarConversao("USD", "BRL", valor);
                        case 5 -> resultadoConversao = exchangeRateApiClient.buscarConversao("USD", "COP", valor);
                        case 6 -> resultadoConversao = exchangeRateApiClient.buscarConversao("COP", "USD", valor);
                        case 7 -> System.out.println("Saindo....");
                        default -> System.out.println("Opção inválida");

                    }

                    if (resultadoConversao != null) {
                        System.out.println(resultadoConversao);

                    }

                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite apenas números.");
                    sc.nextLine();
                    opcao = 0;

                } catch (Exception e) {
                    System.out.println("Ocorreu um erro:" + e.getMessage());
                }

            }

        }


    }

}
