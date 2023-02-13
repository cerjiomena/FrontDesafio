package com.modyo.front.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modyo.front.integracion.IntegracionService;
import com.modyo.front.modelo.Pokemons;
import com.modyo.front.service.PokemonService;

@Service
public class PokemonServiceImpl implements PokemonService {
	
	@Autowired
	private IntegracionService integracionService;

	@Override
	public Pokemons obtenerPaginaPokemons(int pagina, int numeroElementosPorPagina) {
		
		return integracionService.obtenerListadoPokemons(pagina, numeroElementosPorPagina);
	}

}
