package com.grupo16.produtoservice.exception;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 22/02/2024
 * Project Name: produto-service
 */

public abstract class SystemBaseException extends RuntimeException {
	private static final long serialVersionUID = 869484695654256005L;
	
	public abstract String getCode();
	public abstract Integer getHttpStatus();
	@Override
	public abstract String getMessage();

}
