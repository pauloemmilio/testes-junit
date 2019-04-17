package com.paulo.exceptions;

public class PartidaInvalidaException extends RuntimeException {

	public static final String MSG_PADRAO = "Partida inválida.";
	
	public PartidaInvalidaException() {
		super(MSG_PADRAO);
	}
	
	public PartidaInvalidaException(String s) {
		super(s);
	}
}
