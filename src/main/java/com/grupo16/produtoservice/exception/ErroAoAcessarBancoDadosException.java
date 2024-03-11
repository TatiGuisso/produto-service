package com.grupo16.produtoservice.exception;

import lombok.Getter;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 22/02/2024
 * Project Name: produto-service
 */

@Getter
public class ErroAoAcessarBancoDadosException extends SystemBaseException {
	private static final long serialVersionUID = -415384055723475621L;
	
	private final String code = "tc.erroAoAcessarBancoDados";
	private final String message = "Erro ao acessar o banco de dados";
	private final Integer httpStatus = 500;
}
