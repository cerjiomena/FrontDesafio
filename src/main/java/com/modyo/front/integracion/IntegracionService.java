package com.modyo.front.integracion;

import com.modyo.front.modelo.Pokemons;

public interface IntegracionService {
	
	Pokemons obtenerListadoPokemons(String pagina, String numeroElementosPorPagina);


}
