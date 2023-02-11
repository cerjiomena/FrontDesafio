package com.modyo.front.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.modyo.front.dto.PokemonDTO;
import com.modyo.front.integracion.IntegracionService;
import com.modyo.front.modelo.Pokemon;
import com.modyo.front.modelo.Pokemons;
import com.modyo.front.service.PokemonService;

@Service
public class PokemonServiceImpl implements PokemonService {
	
	@Autowired
	private IntegracionService integracionService;

	@Override
	public Page<Pokemon> obtenerPaginaPokemons() {
		
		Page<Pokemon> pages = null;
		
		Pokemons pokemons = integracionService.obtenerListadoPokemons("1", "3");

		pages = new PageImpl<Pokemon>(pokemons.getPokemons(),  PageRequest.of(pokemons.getCurrentPage(), pokemons.getNumberOfElements()), Long.valueOf(pokemons.getTotalElements()).longValue());
		
		
		return pages;
	}

}
