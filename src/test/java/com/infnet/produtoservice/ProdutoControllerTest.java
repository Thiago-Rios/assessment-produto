package com.infnet.produtoservice;

import com.infnet.produtoservice.controller.ProdutoController;
import com.infnet.produtoservice.model.Produto;
import com.infnet.produtoservice.repository.ProdutoRepository;
import com.infnet.produtoservice.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;


@WebFluxTest(ProdutoController.class)
public class ProdutoControllerTest {
    @Autowired
    private WebTestClient webClient;

    @MockBean
    private ProdutoRepository produtoRepository;

    private Produto produto;

    @BeforeEach
    void setUp() {
        BigDecimal valor = BigDecimal.valueOf(11699.90);
        produto = new Produto(3L, "RTX 4090", valor);
    }

    @Test
    public void testFindAll(){
        doReturn(Flux.just(produto)).when(produtoRepository).findAll();

        webClient.get().uri("/api/produtos")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Produto.class)
                .hasSize(1)
                .contains(produto);

        verify(produtoRepository, times(1)).findAll();
    }

    @Test
    public void testSaveProduto(){
        Produto newProduto = new Produto(null, "RTX 4080", BigDecimal.ZERO);
        Produto produtoSalvo = new Produto(4L, "RTX 4080", BigDecimal.ZERO);

        doReturn(Mono.just(produtoSalvo)).when(produtoRepository).save(newProduto);

        webClient.post().uri("/api/produtos")
                .bodyValue(newProduto)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Produto.class)
                .isEqualTo(produtoSalvo);
        verify(produtoRepository, times(1)).save(newProduto);
    }
}
