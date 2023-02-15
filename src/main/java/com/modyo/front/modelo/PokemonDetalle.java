package com.modyo.front.modelo;

import lombok.Data;

@Data
public class PokemonDetalle {
	
	private String timestamp;
	private DetalleDescripcionEvolucion detail;
	private String message;
	private int status;

}
