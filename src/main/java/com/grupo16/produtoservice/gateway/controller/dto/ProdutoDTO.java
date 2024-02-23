package com.grupo16.produtoservice.gateway.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.grupo16.produtoservice.domain.Produto;
import com.grupo16.produtoservice.domain.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class ProdutoDTO {

    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotNull
    private double preco;

    private String status;

    public Produto mapearParaProdutoDomain() {
        return Produto.builder()
                .id(this.id)
                .nome(this.nome)
                .descricao(this.descricao)
                .preco(this.preco)
                .status(this.status == null ? Status.ATIVO : Status.valueOf(this.status))
                .dataCriacao(LocalDateTime.now())
                .build();
    }
}
