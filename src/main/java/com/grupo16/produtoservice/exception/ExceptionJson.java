package com.grupo16.produtoservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 22/02/2024
 * Project Name: produto-service
 */

@Getter
@AllArgsConstructor
public class ExceptionJson {
	private final String code;
	private final String message;
	
	public ExceptionJson(final SystemBaseException baseException) {
		this.code = baseException.getCode();
		this.message = baseException.getMessage();
	}

}
