package com.grupo16.produtoservice.service;

import com.grupo16.produtoservice.domain.Produto;
import com.grupo16.produtoservice.gateway.database.ProdutoRepositoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 22/02/2024
 * Project Name: produto-service
 */

@Service
@AllArgsConstructor
public class CriarAlterarProdutoService {

    private final ProdutoRepositoryGateway produtoRepositoryGateway;

    public Long criar(Produto produto) {
        return this.produtoRepositoryGateway.salvar(produto);
    }
}
