package com.grupo16.produtoservice.usecase;

import com.grupo16.produtoservice.domain.Estoque;
import com.grupo16.produtoservice.gateway.EstoqueServiceGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 07/03/2024
 * Project Name: produto-service
 */

@Service
@AllArgsConstructor
public class CriarAlterarEstoqueUseCase {

    private final EstoqueServiceGateway estoqueServiceGateway;


    public Long atualizarEstoque(Estoque estoque) {
        return estoqueServiceGateway.atualizarProdutoEstoque(estoque);
    }
}
