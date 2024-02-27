package com.grupo16.produtoservice.service;

import com.grupo16.produtoservice.gateway.database.ProdutoRepositoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 23/02/2024
 * Project Name: produto-service
 */

@Service
@AllArgsConstructor
public class RemoverProdutoService {

    private final ProdutoRepositoryGateway produtoRepositoryGateway;

    public void remover(Long id) {
        produtoRepositoryGateway.inativar(id);
    }
}
