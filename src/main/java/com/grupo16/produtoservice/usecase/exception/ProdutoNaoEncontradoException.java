package com.grupo16.produtoservice.usecase.exception;

import com.grupo16.produtoservice.exception.SystemBaseException;
import lombok.Getter;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 23/02/2024
 * Project Name: produto-service
 */

@Getter
public class ProdutoNaoEncontradoException extends SystemBaseException {
    private static final long serialVersionUID = 5199898008763121907L;

    private final String code = "tc.produtoNaoEncontrado";
    private final String message = "Produto não encontrado.";
    private final Integer httpStatus = 404;
}
