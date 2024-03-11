package com.grupo16.produtoservice.gateway.http.estoque;

import com.grupo16.produtoservice.gateway.http.estoque.json.EstoqueJson;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 07/03/2024
 * Project Name: produto-service
 */

@FeignClient(value = "ESTOQUE-SERVICE", path = "estoques")
public interface EstoqueServiceFeignClient {

    @PostMapping("atualizar")
    Long atualizarProdutoEstoque(@RequestBody EstoqueJson estoqueJson);
}
