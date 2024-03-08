package com.grupo16.produtoservice.gateway;

import com.grupo16.produtoservice.domain.Estoque;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 07/03/2024
 * Project Name: produto-service
 */

public interface EstoqueServiceGateway {

    Long atualizarProdutoEstoque(Estoque estoque);
}
