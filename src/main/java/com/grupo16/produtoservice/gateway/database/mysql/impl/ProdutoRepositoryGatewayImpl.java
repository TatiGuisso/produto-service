package com.grupo16.produtoservice.gateway.database.mysql.impl;

import com.grupo16.produtoservice.domain.Produto;
import com.grupo16.produtoservice.gateway.database.ProdutoRepositoryGateway;
import com.grupo16.produtoservice.gateway.database.mysql.entity.ProdutoEntity;
import com.grupo16.produtoservice.gateway.database.mysql.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 21/02/2024
 * Project Name: produto-service
 */

@Component
@Slf4j
@AllArgsConstructor
public class ProdutoRepositoryGatewayImpl implements ProdutoRepositoryGateway {

    private ProdutoRepository produtoRepository;

    @Override
    public Long salvar(Produto produto) {
        try {
            ProdutoEntity produtoEntity = new ProdutoEntity(produto);

            return produtoRepository.save(produtoEntity).getId();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("Erro ao salvar produto", e); // TODO: Implementar tratamento de erro
        }
    }
}
