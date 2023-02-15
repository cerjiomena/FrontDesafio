package com.modyo.front.controller;

import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.modyo.front.error.AplicacionExcepcion;
import com.modyo.front.modelo.PokemonDetalle;
import com.modyo.front.modelo.Pokemons;
import com.modyo.front.service.PokemonService;
import com.modyo.front.util.Constantes;

@Controller
public class PokemonController {
	
	@Autowired
	private PokemonService pokemonService;
	
	@Autowired
	private MessageSource messages;
	
	 
	@GetMapping("/")
	public String obtenerPokemons(WebRequest request, Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		
		Locale local = request.getLocale();
		final int currentPage = page.orElse(1);
		final int pageSize = size.orElse(3);
		
		Pokemons pokemons;
		try {
			pokemons = pokemonService.obtenerPaginaPokemons(currentPage, pageSize);
			
			model.addAttribute(Constantes.DATA, pokemons);
			model.addAttribute(Constantes.PAGE_SIZE, pageSize);
			
			int totalPages = pokemons.getTotalPages();
			
			if (totalPages > 0) {
				
				model.addAttribute(Constantes.PAGES_NUMBERS, totalPages);
			}

		} catch (AplicacionExcepcion e) {
			if (e.getCodigoError() != null) {
				model.addAttribute(Constantes.MESSAGE_ERROR,
						messages.getMessage(e.getCodigoError().getLLaveMensaje(), null, local));
			} else {
				model.addAttribute(Constantes.MESSAGE_ERROR, e.getMessage());
			}
			
		}
		
		

		return "index.html";
	}
	
	@PostMapping("/")
	public String obtenerPokemons(WebRequest request, Model model, @RequestParam("size") Optional<Integer> size) {
		
		Optional<Integer> currentPage = Optional.of(1);
		Locale local = request.getLocale();
		
		Pokemons pokemons;
		try {
			pokemons = pokemonService.obtenerPaginaPokemons(currentPage.get(), size.get());
			model.addAttribute(Constantes.DATA, pokemons);
			model.addAttribute(Constantes.PAGE_SIZE, size.get());
			
			int totalPages = pokemons.getTotalPages();

			if (totalPages > 0) {
				
				model.addAttribute(Constantes.PAGES_NUMBERS, totalPages);
			}
		} catch (AplicacionExcepcion e) {
			
			if (e.getCodigoError() != null) {
				model.addAttribute(Constantes.MESSAGE_ERROR,
						messages.getMessage(e.getCodigoError().getLLaveMensaje(), null, local));
			} else {
				model.addAttribute(Constantes.MESSAGE_ERROR, e.getMessage());
			}
		}
		
		

		return "index :: #pokemonsLista";
		
	}
	
	@PostMapping("/obtenerDetalle")
	public String obtenerDetallePokemon(WebRequest request, Model model, @RequestParam("urlDetalle") Optional<String> url) {
		
		PokemonDetalle detalle;
		Locale local = request.getLocale();
		
		try {
			detalle = pokemonService.obtenerDetallePokemon(url.get());
			model.addAttribute(Constantes.DATA, detalle);
			
		} catch (AplicacionExcepcion e) {
			
			if (e.getCodigoError() != null) {
				model.addAttribute(Constantes.MESSAGE_ERROR,
						messages.getMessage(e.getCodigoError().getLLaveMensaje(), null, local));
			} else {
				model.addAttribute(Constantes.MESSAGE_ERROR, e.getMessage());
			}
		}
		
		
		return "index :: #pokemonDetalle";
		
	}

}
