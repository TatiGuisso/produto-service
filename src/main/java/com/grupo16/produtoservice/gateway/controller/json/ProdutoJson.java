package com.grupo16.produtoservice.gateway.controller.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.grupo16.produtoservice.domain.Produto;
import com.grupo16.produtoservice.domain.Status;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 21/02/2024
 * Project Name: produto-service
 */

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdutoJson {

    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @DecimalMin(value = "0.0", message = "O preço deve ser maior ou igual a zero")
    private double preco;

    private String status;

    private LocalDateTime dataCriacao;


    public ProdutoJson(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.status = produto.getStatus().name();
        this.dataCriacao = produto.getDataCriacao();
    }

    public Produto mapearParaProdutoDomain() {
        return Produto.builder()
                .id(this.id)
                .nome(this.nome)
                .descricao(this.descricao)
                .preco(this.preco)
                .status(Status.ATIVO)
                .dataCriacao(LocalDateTime.now())
                .build();
    }
}
