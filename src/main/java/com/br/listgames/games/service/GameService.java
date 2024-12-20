package com.br.listgames.games.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.listgames.games.dto.GameLargeViewDTO;
import com.br.listgames.games.dto.GameSmallViewDTO;
import com.br.listgames.games.entities.Game;
import com.br.listgames.games.projections.GameSmallProjections;
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
	
	
	//@Transactional: Garantir que o service seja transacional no banco de dados, ACID: Atômica, consistente, isolada e durável
	@Transactional(readOnly = true)
	public List<GameSmallViewDTO> findAll(){
		List<Game> games = gameRepository.findAll();
		List<GameSmallViewDTO> dto = games.stream().map(dados -> new GameSmallViewDTO(dados)).toList();
		return dto;
	} 
	
	@Transactional(readOnly = true)
	public GameLargeViewDTO findById(Long id) {
		Game gameById = gameRepository.findById(id).get();
		//Converter o objeto GAME acima em GameLargeDTO
		GameLargeViewDTO gameLargeDto = new GameLargeViewDTO(gameById);
		return gameLargeDto;
	}
	
	//Por semântica de retorno de dados, usarei este endpoint no GameGeneroController
	@Transactional(readOnly = true)
	public List<GameSmallViewDTO> findListGeneroById(Long generoId){
		List<GameSmallProjections> generoGamesById = gameRepository.searchListGeneroById(generoId);
		return generoGamesById.stream().map(dados -> new GameSmallViewDTO(dados)).toList();
	}
	
}
