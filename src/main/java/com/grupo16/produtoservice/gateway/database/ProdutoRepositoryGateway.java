package com.grupo16.produtoservice.gateway.database;

import com.grupo16.produtoservice.domain.Produto;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 21/02/2024
 * Project Name: produto-service
 */

public interface ProdutoRepositoryGateway {

    Long salvar(Produto produto);
}
