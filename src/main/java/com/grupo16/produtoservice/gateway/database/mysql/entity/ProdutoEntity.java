package com.grupo16.produtoservice.gateway.database.mysql.entity;

import com.grupo16.produtoservice.domain.Produto;
import com.grupo16.produtoservice.domain.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 21/02/2024
 * Project Name: produto-service
 */

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private double preco;
    private int status;
    private LocalDateTime dataCriacao;

    public ProdutoEntity(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.status = produto.getStatus().ordinal();
        this.dataCriacao = produto.getDataCriacao();
    }

    public Produto mapearProdutoEntityParaDomain() {
        return Produto.builder()
                .id(this.id)
                .nome(this.nome)
                .descricao(this.descricao)
                .preco(this.preco)
                .status(this.status == 0 ? Status.ATIVO : Status.INATIVO)
                .dataCriacao(this.dataCriacao)
                .build();
    }
}
