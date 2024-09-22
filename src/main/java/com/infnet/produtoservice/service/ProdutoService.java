package com.infnet.produtoservice.service;

import com.infnet.produtoservice.model.Produto;
import com.infnet.produtoservice.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Flux<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Mono<Produto> save(Produto produto) {
        return produtoRepository.save(produto);
    }
}
