package com.infnet.produtoservice.service;

import com.infnet.produtoservice.model.Produto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProdutoService {
    Flux<Produto> findAll();
    Mono<Produto> save(Produto produto);
}
