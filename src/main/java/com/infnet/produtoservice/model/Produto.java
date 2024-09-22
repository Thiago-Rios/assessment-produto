package com.infnet.produtoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@AllArgsConstructor@NoArgsConstructor
@Data
@Table("produtos")
public class Produto {
    @Id
    private Long id;
    private String nome;
    private BigDecimal preco;
}
