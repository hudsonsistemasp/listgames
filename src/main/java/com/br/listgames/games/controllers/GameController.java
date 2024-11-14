package com.br.listgames.games.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.listgames.games.dto.GameDTO;
import com.br.listgames.games.service.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	
	/*Fazer a injeção de dependência com a camada service*/
	
	/*GameService gameService;
	
	public GameController(GameService gameSerive) {
		this.gameService = gameService;
	}
	*/
	
	/*Fazer a injeção de dependência com a camada service*/
	@Autowired
	GameService gameService;
	
	@GetMapping
	public List<GameDTO> findAll(){
		List<GameDTO> games = gameService.findAll();
		return games;
	}
}
