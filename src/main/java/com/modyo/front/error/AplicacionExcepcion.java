package com.modyo.front.error;

import com.modyo.front.util.MensajeError;

public class AplicacionExcepcion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  MensajeError codigoError = null;
	
	public AplicacionExcepcion(String msj) {
		super(msj);
	}
	
	public AplicacionExcepcion(MensajeError codigoError) {
		this.codigoError = codigoError;
	}
	
	public MensajeError getCodigoError() {
		return codigoError;
	}
	
}