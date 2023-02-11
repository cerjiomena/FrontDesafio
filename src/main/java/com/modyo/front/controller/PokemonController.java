package com.modyo.front.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import com.modyo.front.modelo.Pokemon;
import com.modyo.front.service.PokemonService;

@Controller
public class PokemonController {
	
	@Autowired
	private PokemonService pokemonService;
	
	 
	@GetMapping("/")
	public String obtenerTickets(WebRequest request, Model model) {
		
		
		Page<Pokemon> paginas = pokemonService.obtenerPaginaPokemons();
		
		model.addAttribute("data", paginas);
		
		int totalPages = paginas.getTotalPages();

		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}

		
		return "index.html";
	}

}
