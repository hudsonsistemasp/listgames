package com.br.listgames.games.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.listgames.games.dto.GameGeneroDTO;
import com.br.listgames.games.dto.GameSmallViewDTO;
import com.br.listgames.games.service.GameGeneroService;
import com.br.listgames.games.service.GameService;

@RestController
@RequestMapping(value = "/gamesGenero")
public class GameGeneroController {
	
	@Autowired
	GameGeneroService gameGeneroService; 
	
	@Autowired
	GameService gameService;
	
	
	@GetMapping
	public List<GameGeneroDTO> findAll(){
		List<GameGeneroDTO> gamesGeneroDto = gameGeneroService.findAll();
		return gamesGeneroDto;
	}
	
	@GetMapping(value = "/{generoId}/games")
	public List<GameSmallViewDTO> findListGeneroById(@PathVariable Long generoId){
		List<GameSmallViewDTO> gamesGenero = gameService.findListGeneroById(generoId);
		return gamesGenero;
	}	
}
