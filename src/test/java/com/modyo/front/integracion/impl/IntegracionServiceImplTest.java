package com.modyo.front.integracion.impl;

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
	
	@Test
	public void debeObtenerDetallePokemon() throws AplicacionExcepcion {
		log.debug("Entrando a IntegracionServiceImplTest.debeObtenerDetallePokemon");
		
		PokemonDetalle detalle = integracionService.obtenerDetallePokemon("https://pokeapi.co/api/v2/pokemon/8/");
		
		
	}

}
