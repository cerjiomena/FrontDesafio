package com.modyo.front.service;

import org.springframework.data.domain.Page;

import com.modyo.front.modelo.Pokemon;

public interface PokemonService {
	
	Page<Pokemon> obtenerPaginaPokemons();
}
