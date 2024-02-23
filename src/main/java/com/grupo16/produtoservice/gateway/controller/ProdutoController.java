package com.grupo16.produtoservice.gateway.controller;

import com.grupo16.produtoservice.domain.Produto;
import com.grupo16.produtoservice.gateway.controller.dto.ProdutoDTO;
import com.grupo16.produtoservice.service.CriarAlterarProdutoService;
import com.grupo16.produtoservice.service.ObterProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    private final ObterProdutoService obterProdutoService;

    private final CriarAlterarProdutoService criarAlterarProdutoService;


    @GetMapping("{id}")
    public ProdutoDTO obterPorId(@PathVariable Long id) {
        log.trace("Start id={}", id);

        ProdutoDTO produtoDto = new ProdutoDTO(obterProdutoService.obterPorId(id));

        log.trace("End produtoDto={}", produtoDto);
        return produtoDto;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long criar(@Valid @RequestBody ProdutoDTO produtoDTO) {
        log.trace("Start produtoDTO={}", produtoDTO);

        Produto produto = produtoDTO.mapearParaProdutoDomain();
        Long idProduto = criarAlterarProdutoService.criar(produto);

        log.trace("End idProduto={}", idProduto);
        return idProduto;
    }
}
