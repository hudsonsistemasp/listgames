package com.br.listgames.games.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.listgames.games.dto.GameGeneroDTO;
import com.br.listgames.games.service.GameGeneroService;

@RestController
@RequestMapping(value = "/gamesGenero")
public class GameGeneroController {
	
	@Autowired
	GameGeneroService gameGeneroService; 
	
	@GetMapping
	public List<GameGeneroDTO> findAll(){
		List<GameGeneroDTO> gamesGeneroDto = gameGeneroService.findAll();
		return gamesGeneroDto;
	}
}
