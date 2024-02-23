package com.grupo16.produtoservice.gateway.database;

import com.grupo16.produtoservice.domain.Produto;

import java.util.Optional;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 21/02/2024
 * Project Name: produto-service
 */

public interface ProdutoRepositoryGateway {

    Optional<Produto> obterPorId(Long id);

    Long salvar(Produto produto);
}
