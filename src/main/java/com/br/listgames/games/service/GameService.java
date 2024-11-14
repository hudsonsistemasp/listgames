package com.br.listgames.games.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.listgames.games.dto.GameDTO;
import com.br.listgames.games.entities.Game;
import com.br.listgames.games.repository.GameRepository;

@Service
public class GameService {
	
	/* Fazendo injeção de dependência com a camada Repository*/ 
	/*private GameRepository gameRepository;
	
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	*/
	
	/* Fazendo injeção de dependência com a anotação do framework*/
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameDTO> findAll(){
		List<Game> games = gameRepository.findAll();
		List<GameDTO> dto = games.stream().map(dados -> new GameDTO(dados)).toList();
		return dto;
	} 
}
