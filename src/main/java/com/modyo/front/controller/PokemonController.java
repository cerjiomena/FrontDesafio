package com.modyo.front.controller;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.modyo.front.modelo.Pokemon;
import com.modyo.front.service.PokemonService;

@Controller
public class PokemonController {
	
	@Autowired
	private PokemonService pokemonService;
	
	 
	@GetMapping("/")
	public String obtenerPokemons(WebRequest request, Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		
		Locale local = request.getLocale();
		final int currentPage = page.orElse(1);
		final int pageSize = size.orElse(3);
		
		Page<Pokemon> paginas = pokemonService.obtenerPaginaPokemons(currentPage, pageSize);
		
		model.addAttribute("data", paginas);
		
		int totalPages = paginas.getTotalPages();

		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}

		
		return "index.html";
	}
	
	@PostMapping("/")
	public String obtenerPokemons(WebRequest request, Model model, @RequestParam("size") Optional<Integer> size) {
		
		Optional<Integer> currentPage = Optional.of(1);
		
		Page<Pokemon> paginas = pokemonService.obtenerPaginaPokemons(currentPage.get(), size.get());
		
		model.addAttribute("data", paginas);
		
		int totalPages = paginas.getTotalPages();

		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}

		
		//return this.obtenerPokemons(request, model, currentPage, size);
		
		return "index :: #pokemonsLista";
		
	}

}
