package com.infnet.produtoservice.service.impl;

import com.infnet.produtoservice.model.Produto;
import com.infnet.produtoservice.repository.ProdutoRepository;
import com.infnet.produtoservice.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;


    @Override
    public Flux<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Mono<Produto> save(Produto produto) {
        return produtoRepository.save(produto);
    }
}
