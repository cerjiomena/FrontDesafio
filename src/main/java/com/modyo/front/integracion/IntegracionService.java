package com.modyo.front.integracion;

import com.modyo.front.error.AplicacionExcepcion;
import com.modyo.front.modelo.PokemonDetalle;
import com.modyo.front.modelo.Pokemons;

public interface IntegracionService {
	
	/**
	 * Metodo utilizado para obtener el listado paginado de los pokemons
	 * @param pagina el numero de la pagina
	 * @param numeroElementosPorPagina los registros por pagina
	 * @return Objeto de dominio con la informacion de la paginacion y pokemons
	 */
	Pokemons obtenerListadoPokemons(int pagina, int numeroElementosPorPagina) throws AplicacionExcepcion;
	

	/**
	 * Metodo utilizado para obtener el detalle del pokemon
	 * @param id identificador del pokemon para obtener el detalle
	 * @return Objeto mapeado con los propiedades de la respuesta del json
	 */
	PokemonDetalle obtenerDetallePokemon(String id) throws AplicacionExcepcion;


}
