package com.modyo.front.integracion.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.modyo.front.FrontDesafioApplication;
import com.modyo.front.error.AplicacionExcepcion;
import com.modyo.front.integracion.IntegracionService;
import com.modyo.front.modelo.PokemonDetalle;
import com.modyo.front.modelo.Pokemons;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(classes = { FrontDesafioApplication.class })
@Slf4j
public class IntegracionServiceImplTest {
	
	@Autowired
	private IntegracionService integracionService;
	
	/**
	 * Metodo para probar el listado de pokemons
	 * @throws AplicacionExcepcion 
	 */
	@Test
	@Disabled
	public void debeObtenerListadoPokemons() throws AplicacionExcepcion {
		log.debug("Entrando a IntegracionServiceImplTest.debeObtenerListadoPokemons");
		
		Pokemons pokemons = integracionService.obtenerListadoPokemons(1, 3);
		
		assertTrue(pokemons.getPokemons().size() > 0);
		
	}
	/**
	 * Metodo que prueba la obtencion del detalle del pokemon
	 * @throws AplicacionExcepcion
	 */
	@Test
	@Disabled
	public void debeObtenerDetallePokemon() throws AplicacionExcepcion {
		log.debug("Entrando a IntegracionServiceImplTest.debeObtenerDetallePokemon");
		
		PokemonDetalle detalle = integracionService.obtenerDetallePokemon("https://pokeapi.co/api/v2/pokemon/8/");
		assertNotNull(detalle);
		
		
	}
	
	/**
	 * Metodo para probar el listado de pokemons con paginacion distinta
	 * @throws AplicacionExcepcion 
	 */
	@Test
	@Disabled
	public void debeObtenerListadoPokemonsErrorPaginacion() throws AplicacionExcepcion  {
		log.debug("Entrando a IntegracionServiceImplTest.debeObtenerListadoPokemonsErrorPaginacion");
		
		Pokemons pokemons = integracionService.obtenerListadoPokemons(1000, 8);
		
		assertTrue(pokemons.getPokemons().size() <= 0);

	}
	
	/**
	 * Metodo que prueba la obtencion del detalle del pokemon
	 * @throws AplicacionExcepcion
	 */
	@Test
	public void debeObtenerDetallePokemonError() throws AplicacionExcepcion {
		log.debug("Entrando a IntegracionServiceImplTest.debeObtenerDetallePokemonError");
		
		PokemonDetalle detalle = integracionService.obtenerDetallePokemon("https://pokeapi.co/api/v2/pokemon/10000/");
		
		assertEquals(-200, detalle.getStatus());
		log.debug(detalle.toString());
		
	}
	

}
