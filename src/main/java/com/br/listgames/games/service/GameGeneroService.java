package com.br.listgames.games.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.listgames.games.dto.GameGeneroDTO;
import com.br.listgames.games.entities.GameGenero;
import com.br.listgames.games.repository.GameGeneroRepository;

@Service
public class GameGeneroService {
	
	/* Fazendo injeção de dependência com a camada Repository*/
	private GameGeneroRepository gameGeneroRepository;
	
	public GameGeneroService(GameGeneroRepository gameGeneroRepository) {
		this.gameGeneroRepository = gameGeneroRepository;
	}
	
	
	/*Fazendo a injeção de dependência com a anotação do frame*/
	/*@Autowired
	private GameGeneroRepository gameRepository;*/
	
	
	
	@Transactional(readOnly = true)
	public List<GameGeneroDTO> findAll() {
		List<GameGenero> games = gameGeneroRepository.findAll();
		List<GameGeneroDTO> gamesGeneroDTO = games.stream().map(dados -> new GameGeneroDTO(dados)).toList();
		return gamesGeneroDTO;
	}
}
