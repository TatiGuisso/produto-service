package com.grupo16.produtoservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 07/03/2024
 * Project Name: produto-service
 */

@Builder
@Getter
@ToString
public class Estoque {

    private Long idProduto;
    private Long quantidade;
}
