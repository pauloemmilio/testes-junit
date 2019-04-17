package com.paulo.exceptions;

public class TimeNaoEncontradoException extends RuntimeException {

	public static final String MSG_PADRAO = "Time não encontrado.";
	
	public TimeNaoEncontradoException() {
		super(MSG_PADRAO);
	}
	
	public TimeNaoEncontradoException(String s) {
		super(s);
	}
}
