package com.modyo.front.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.modyo.front.FrontDesafioApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(classes = { FrontDesafioApplication.class })
@AutoConfigureMockMvc
@Slf4j
public class PokemonControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void debeObtenerListadoPokemonsPaginado() throws Exception {
		log.debug("Entrando a debeObtenerListadoPokemonsPaginado");
		
		 mockMvc.perform(get("/?page=3&size=9")).andExpect(status().isOk()).andExpect(model().attributeExists("data")).andReturn();

	
	}
	
	@Test
	public void debeObtenerListadoPokemonsConSizeDistinto() throws Exception {
		log.debug("Entrando a debeObtenerListadoPokemonsPaginado");
		
		 mockMvc.perform(post("/").param("size", "9"))
					.andExpect(status().isOk()).andExpect(model().attributeExists("data")).andReturn();
		 
		
	}
	
	@Test
	public void debeObtenerDetallePokemon() throws Exception {
		log.debug("Entrando a debeObtenerDetallePokemon");
		
		mockMvc.perform(post("/obtenerDetalle").param("urlDetalle", "https://pokeapi.co/api/v2/pokemon/1/"))
					.andExpect(status().isOk()).andExpect(model().attributeExists("detail")).andReturn();
		 
		
	}
	
	@Test
	public void debeObtenerDetallePokemonError() throws Exception {
		log.debug("Entrando a debeObtenerDetallePokemonError");
		
		mockMvc.perform(post("/obtenerDetalle").param("urlDetalle", "https://pokeapi.co/api/v2/pokemon/10000/"))
					.andExpect(status().isOk()).andExpect(model().attributeExists("errorDetail")).andReturn();
		 
		
	}
}
