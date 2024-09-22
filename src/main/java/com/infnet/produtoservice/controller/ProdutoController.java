package com.infnet.produtoservice.controller;

import com.infnet.produtoservice.model.Produto;
import com.infnet.produtoservice.repository.ProdutoRepository;
import com.infnet.produtoservice.service.ProdutoService;
import com.infnet.produtoservice.service.ProdutoWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;
    private ProdutoWebClient produtoWebClient;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public Flux<Produto> getAll() {
        return produtoRepository.findAll();
    }

    @PostMapping
    public Mono<Produto> save(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping("/{id}")
    public Mono<Produto> findById(@PathVariable Long id) {
        return produtoRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return produtoRepository.deleteById(id);
    }

}
