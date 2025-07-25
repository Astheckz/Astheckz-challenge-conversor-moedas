# 🪙 Conversor de Moedas - Alura Challenge ONE

Oi! 

Este é o meu projeto para o **Challenge ONE - Java - Back-end** da Alura.

A ideia é bem simples: é um programa que roda direto no seu terminal e permite converter valores entre diferentes moedas. Para as cotações serem sempre atuais, ele se conecta em tempo real com a [ExchangeRate-API](https://www.exchangerate-api.com/) para buscar os dados.

## ✨ O que ele faz?

* Converte valores entre diferentes pares de moedas (Dólar, Real Brasileiro, Peso Argentino, etc.).
* Busca taxas de câmbio sempre atualizadas através de uma API externa.

## 🛠️ Tecnologias que usei

* **Java 21**
* **Gson:** Uma biblioteca do Google para "conversar" com o formato JSON da API.
* **HttpClient do Java:** Para fazer a chamada à internet e buscar os dados.

## 🚀 Como Executar o Projeto

Para rodar na sua máquina, é bem tranquilo.

### O que você precisa ter:
* Java Development Kit (JDK) 21 ou superior.
* Git para clonar o projeto.
* Sua IDE preferida (IntelliJ, Eclipse, etc.).

### Passo a Passo

1.  **Clone o projeto:**
    ```bash
    git clone https://github.com/seu-usuario/challenge-conversor-moedas.git
    ```

2.  **Configure sua Chave da API:**
    O programa precisa de uma chave de acesso (API Key) para funcionar. É grátis e rápido de conseguir:
    * Crie sua conta no site da [**ExchangeRate-API**](https://www.exchangerate-api.com/) para pegar sua chave.
    * Depois, abra o projeto na sua IDE.
    * Vá até o arquivo `src/br/com/paulo/conversordemoedas/client/ExchangeRateApiClient.java`.
    * Encontre esta linha e cole sua chave no lugar de `"SUA_API_KEY"`:

        ```java
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/SUA_API_KEY/pair/" + origem + "/" + destino + "/" + valor);
        ```

3.  **Rode a Aplicação:**
    * Com a chave no lugar, encontre o arquivo `Main.java` (na pasta `application`), clique para executar, e o menu do conversor vai aparecer no seu console!
