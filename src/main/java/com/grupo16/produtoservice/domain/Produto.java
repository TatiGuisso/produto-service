package com.grupo16.produtoservice.domain;

import lombok.*;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 21/02/2024
 * Project Name: produto-service
 */

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private String id;
    private String nome;
    private String descricao;
    private double preco;
    private Status status;
}
