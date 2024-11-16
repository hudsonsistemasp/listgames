package com.br.listgames.games.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.listgames.games.dto.GameLargeViewDTO;
import com.br.listgames.games.dto.GameSmallViewDTO;
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
	public List<GameSmallViewDTO> findAll(){
		List<GameSmallViewDTO> games = gameService.findAll();
		return games;
	}
	
	@GetMapping(value = "/{id}")
	public GameLargeViewDTO findById(@PathVariable Long id) {
		GameLargeViewDTO gameLargeDto = gameService.findById(id);
		return gameLargeDto;
	}
	
	
}
