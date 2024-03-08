package com.grupo16.produtoservice.gateway.controller.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.grupo16.produtoservice.domain.Estoque;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 07/03/2024
 * Project Name: produto-service
 */

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstoqueJson {

    @DecimalMin(value = "1", message = "A quantidade deve ser maior ou igual a 1")
    private Long quantidade;


    public Estoque mapearParaEstoqueDomain(Long id) {
        return Estoque.builder()
                .idProduto(id)
                .quantidade(this.quantidade)
                .build();
    }
}
