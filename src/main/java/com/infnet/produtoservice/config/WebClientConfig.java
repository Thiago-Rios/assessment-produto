package com.infnet.produtoservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientConfig {
    @Bean
    public WebClient.Builder webClient() {
        return WebClient.builder();
    }
}
