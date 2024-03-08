package com.grupo16.produtoservice.gateway.http.estoque.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 07/03/2024
 * Project Name: produto-service
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstoqueJson {

    private Long id;
    private Long idProduto;
    private Long quantidade;
}
