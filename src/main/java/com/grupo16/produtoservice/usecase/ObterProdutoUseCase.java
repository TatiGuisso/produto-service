package com.grupo16.produtoservice.usecase;

import com.grupo16.produtoservice.domain.Produto;
import com.grupo16.produtoservice.gateway.database.ProdutoRepositoryGateway;
import com.grupo16.produtoservice.usecase.exception.ProdutoNaoEncontradoException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 23/02/2024
 * Project Name: produto-service
 */

@Service
@AllArgsConstructor
@Slf4j
public class ObterProdutoUseCase {

    private final ProdutoRepositoryGateway produtoRepositoryGateway;


    public List<Produto> obterTodosAtivos() {
        return this.produtoRepositoryGateway.obterTodosAtivos();
    }

    public Produto obterPorId(Long id) {
        Optional<Produto> produtoOp = this.produtoRepositoryGateway.obterPorId(id);

        if (produtoOp.isEmpty()) {
            log.warn("Produto não encontrado: id={}", id);
            throw new ProdutoNaoEncontradoException();
        }

        return produtoOp.get();
    }
}
