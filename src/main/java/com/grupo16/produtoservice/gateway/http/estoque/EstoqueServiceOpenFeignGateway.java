package com.grupo16.produtoservice.gateway.http.estoque;

import com.grupo16.produtoservice.domain.Estoque;
import com.grupo16.produtoservice.exception.ErrorAoAcessarEstoqueServiceException;
import com.grupo16.produtoservice.gateway.EstoqueServiceGateway;
import com.grupo16.produtoservice.gateway.http.estoque.json.EstoqueJson;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 07/03/2024
 * Project Name: produto-service
 */

@Component
@AllArgsConstructor
@Slf4j
public class EstoqueServiceOpenFeignGateway implements EstoqueServiceGateway {

    private EstoqueServiceFeignClient estoqueServiceFeignClient;

    @Override
    public Long atualizarProdutoEstoque(Estoque estoque) {

        try {
            EstoqueJson estoqueJson = EstoqueJson.builder()
                    .idProduto(estoque.getIdProduto())
                    .quantidade(estoque.getQuantidade())
                    .build();

            return estoqueServiceFeignClient.atualizarProdutoEstoque(estoqueJson);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            if(e instanceof FeignException feignException) {

                //TODO: implementar
                String exceptionResponseBody = feignException.contentUTF8();
                log.error(exceptionResponseBody);
            }
            throw new ErrorAoAcessarEstoqueServiceException();
        }
    }
}
