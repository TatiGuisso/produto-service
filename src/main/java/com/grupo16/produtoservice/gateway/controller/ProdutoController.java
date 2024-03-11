package com.grupo16.produtoservice.gateway.controller;

import com.grupo16.produtoservice.domain.Produto;
import com.grupo16.produtoservice.gateway.controller.json.EstoqueJson;
import com.grupo16.produtoservice.gateway.controller.json.ProdutoJson;
import com.grupo16.produtoservice.usecase.CriarAlterarEstoqueUseCase;
import com.grupo16.produtoservice.usecase.CriarAlterarProdutoUseCase;
import com.grupo16.produtoservice.usecase.ObterProdutoUseCase;
import com.grupo16.produtoservice.usecase.RemoverProdutoUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 21/02/2024
 * Project Name: produto-service
 */

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("produtos")
public class ProdutoController {

    private final ObterProdutoUseCase obterProdutoUseCase;

    private final CriarAlterarProdutoUseCase criarAlterarProdutoUseCase;

    private final RemoverProdutoUseCase removerProdutoUseCase;

    private final CriarAlterarEstoqueUseCase criarAlterarEstoqueUseCase;


    @GetMapping
    public List<ProdutoJson> obterTodosAtivos() {
        return obterProdutoUseCase.obterTodosAtivos()
                .stream()
                .map(ProdutoJson::new)
                .toList();
    }

    @GetMapping("{id}")
    public ProdutoJson obterPorId(@PathVariable Long id) {
        log.trace("Start id={}", id);

        ProdutoJson produtoJson = new ProdutoJson(obterProdutoUseCase.obterPorId(id));

        log.trace("End produtoDto={}", produtoJson);
        return produtoJson;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long criar(@Valid @RequestBody ProdutoJson produtoJson) {
        log.trace("Start produtoDTO={}", produtoJson);

        Produto produto = produtoJson.mapearParaProdutoDomain();
        Long idProduto = criarAlterarProdutoUseCase.criar(produto);

        log.trace("End idProduto={}", idProduto);
        return idProduto;
    }

    //FIXME: Este endpoint deveria estar em "estoque-service" - VERIFICADO QUE JA EXISTE EM ESTOQUE-SERVICE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{idProduto}/estoque")
    public Long criarAlterarEstoque(@PathVariable Long idProduto, @Valid @RequestBody EstoqueJson estoqueJson) {
        log.trace("Start id={}, estoqueDTO={}", idProduto, estoqueJson);

        Long idEstoque = criarAlterarEstoqueUseCase.atualizarEstoque(estoqueJson.mapearParaEstoqueDomain(idProduto));

        log.trace("End idEstoque={}", idEstoque);
        return idEstoque;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{id}")
    public void alterar(@PathVariable Long id, @Valid @RequestBody ProdutoJson produtoJson) {
        log.trace("Start id={}, produtoDTO={}", id, produtoJson);

        Produto produto = produtoJson.mapearParaProdutoDomain();
        criarAlterarProdutoUseCase.alterar(id, produto);

        log.trace("End");
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        log.trace("Start id={}", id);

        removerProdutoUseCase.remover(id);

        log.trace("End");
    }
}
