package com.grupo16.produtoservice.usecase;

import com.grupo16.produtoservice.domain.Produto;
import com.grupo16.produtoservice.gateway.database.ProdutoRepositoryGateway;
import com.grupo16.produtoservice.usecase.exception.ProdutoNaoEncontradoException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 22/02/2024
 * Project Name: produto-service
 */

@Service
@AllArgsConstructor
@Slf4j
public class CriarAlterarProdutoUseCase {

    private final ProdutoRepositoryGateway produtoRepositoryGateway;

    public Long criar(Produto produto) {
        return this.produtoRepositoryGateway.salvar(produto);
    }

    public void alterar(Long id, Produto produto) {
        Optional<Produto> produtoOp = this.produtoRepositoryGateway.obterPorId(id);

        if (produtoOp.isEmpty()) {
            log.warn("Produto não encontrado: id={}", id);
            throw new ProdutoNaoEncontradoException();
        }

        Produto produtoSalvo = Produto.builder()
                .id(id)
                .nome(produto.getNome())
                .descricao(produto.getDescricao())
                .preco(produto.getPreco())
                .status(produto.getStatus())
                .dataCriacao(produto.getDataCriacao())
                .build();

        this.produtoRepositoryGateway.salvar(produtoSalvo);
    }
}
