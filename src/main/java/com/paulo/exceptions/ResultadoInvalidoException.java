package com.paulo.exceptions;

public class ResultadoInvalidoException extends RuntimeException {

	public static final String MSG_PADRAO = "Resultado inválido.";
	
	public ResultadoInvalidoException() {
		super(MSG_PADRAO);
	}
	
	public ResultadoInvalidoException(String s) {
		super(s);
	}
}
