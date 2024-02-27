package com.grupo16.produtoservice.gateway.database.mysql.impl;

import com.grupo16.produtoservice.domain.Produto;
import com.grupo16.produtoservice.domain.Status;
import com.grupo16.produtoservice.exception.ErroAoAcessarBancoDadosException;
import com.grupo16.produtoservice.gateway.database.ProdutoRepositoryGateway;
import com.grupo16.produtoservice.gateway.database.mysql.entity.ProdutoEntity;
import com.grupo16.produtoservice.gateway.database.mysql.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
    public Optional<Produto> obterPorId(Long id) {
        try {
            Optional<Produto> produtoOp = Optional.empty();
            Optional<ProdutoEntity> produtoEntityOp = produtoRepository.findById(id);

            if (produtoEntityOp.isPresent()) {
                Produto produto = produtoEntityOp.get().mapearProdutoEntityParaDomain();
                produtoOp = Optional.of(produto);
            }

            return produtoOp;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErroAoAcessarBancoDadosException();
        }
    }

    @Override
    public Long salvar(Produto produto) {
        try {
            ProdutoEntity produtoEntity = new ProdutoEntity(produto);

            return produtoRepository.save(produtoEntity).getId();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErroAoAcessarBancoDadosException();
        }
    }

    @Override
    public void inativar(Long id) {
        try {
            Optional<ProdutoEntity> produtoEntityOp = produtoRepository.findById(id);

            if (produtoEntityOp.isPresent()) {
                Produto produto = produtoEntityOp.get().mapearProdutoEntityParaDomain();

                if (produto.getStatus() == Status.ATIVO) {
                    ProdutoEntity produtoInativado = new ProdutoEntity(
                            produto.getId(),
                            produto.getNome(),
                            produto.getDescricao(),
                            produto.getPreco(),
                            1,
                            produto.getDataCriacao());

                    produtoRepository.save(produtoInativado);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErroAoAcessarBancoDadosException();
        }
    }
}
