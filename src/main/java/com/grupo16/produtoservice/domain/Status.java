package com.grupo16.produtoservice.domain;

import lombok.Getter;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 21/02/2024
 * Project Name: produto-service
 */

@Getter
public enum Status {

    ATIVO(0),
    INATIVO(1);

    private int value;

    Status(int value) {
        this.value = value;
    }
}
