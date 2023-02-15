package com.modyo.front.service;

import com.modyo.front.error.AplicacionExcepcion;
import com.modyo.front.modelo.PokemonDetalle;
import com.modyo.front.modelo.Pokemons;

public interface PokemonService {
	
	/**
	 * Metodo utilizado para obtener el listado de pokemons
	 * @param pagina numero de pagina
	 * @param numeroElementosPorPagina registros por pagina
	 * @return Objeto que tiene la informacion de los pokemnos y paginacion
	 * @throws AplicacionExcepcion
	 */
	Pokemons obtenerPaginaPokemons(int pagina, int numeroElementosPorPagina) throws AplicacionExcepcion;
	
	PokemonDetalle obtenerDetallePokemon(String urlDetalle) throws AplicacionExcepcion;
}
