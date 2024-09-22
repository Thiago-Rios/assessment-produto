package com.infnet.produtoservice.service;

import com.infnet.produtoservice.model.Produto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProdutoWebClient {

    private final WebClient webClient;

    public ProdutoWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8082/api/produtos").build();
    }

    public Flux<Produto> getAllProdutos() {
        return webClient.get()
                .retrieve()
                .bodyToFlux(Produto.class);
    }

    public Mono<Produto> getProdutoByID(Long id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Produto.class);
    }

    public Mono<Produto> saveProduto(Produto produto) {
        return webClient.post()
                .bodyValue(produto)
                .retrieve()
                .bodyToMono(Produto.class);
    }

    public Mono<Void> deleteProduto(Long id) {
        return webClient.delete()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }

    public Mono<Produto> updateProduto(Long id, Produto produto) {
        return webClient.put()
                .uri("/{id}", id)
                .bodyValue(produto)
                .retrieve()
                .bodyToMono(Produto.class);
    }
}
