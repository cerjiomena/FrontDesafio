package com.modyo.front.service;

import org.springframework.data.domain.Page;

import com.modyo.front.modelo.Pokemon;
import com.modyo.front.modelo.Pokemons;

public interface PokemonService {
	
	Pokemons obtenerPaginaPokemons(int pagina, int numeroElementosPorPagina);
}
