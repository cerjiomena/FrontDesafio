package com.modyo.front.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.modyo.front.FrontDesafioApplication;
import com.modyo.front.modelo.Pokemon;
import com.modyo.front.modelo.Pokemons;
import com.modyo.front.service.IntegracionService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(classes = { FrontDesafioApplication.class })
@Slf4j
public class IntegracionServiceImplTest {
	
	@Autowired
	private IntegracionService integracionService;
	
	@Test
	public void debeObtenerListadoPokemons() {
		log.debug("Entrando a IntegracionServiceImplTest.debeObtenerListadoPokemons");
		
		Pokemons pokemons = integracionService.obtenerListadoPokemons("1", "3");
		
		for (Pokemon pokemon: pokemons.getPokemons()) {
			
			log.debug(pokemon.toString());
		}
		
		
	}

}
