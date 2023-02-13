package com.modyo.front.modelo;

import java.util.List;

import lombok.Data;

@Datapublic class Pokemons {

	private List<Pokemon> pokemons;
	
	private String timestap;
	private int numberOfElements;
	private int totalPages;
	private int currentPage;
	private int status;
	private int totalElements;
	private int number;
	
	public boolean hasContent() {
		return pokemons.size() > 0 ? true : false;
	}
}
