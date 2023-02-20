package com.modyo.front.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modyo.front.error.AplicacionExcepcion;
import com.modyo.front.integracion.IntegracionService;
import com.modyo.front.modelo.PokemonDetalle;
import com.modyo.front.modelo.Pokemons;
import com.modyo.front.service.PokemonService;

@Service
public class PokemonServiceImpl implements PokemonService {
	
	@Autowired
	private IntegracionService integracionService;

	/**
	 * {@link PokemonService#obtenerPaginaPokemons(int, int)}
	 */
	public Pokemons obtenerPaginaPokemons(int pagina, int numeroElementosPorPagina) throws AplicacionExcepcion {
		
		return integracionService.obtenerListadoPokemons(pagina, numeroElementosPorPagina);
	}

	/**
	 * {@link PokemonService#obtenerDetallePokemon(String)}
	 */
	public PokemonDetalle obtenerDetallePokemon(String id) throws AplicacionExcepcion {
		
		return integracionService.obtenerDetallePokemon(id);
		
	}

}
