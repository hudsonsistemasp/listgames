package com.br.listgames.games.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.listgames.games.dto.GameGeneroDTO;
import com.br.listgames.games.entities.GameGenero;
import com.br.listgames.games.projections.GameSmallProjections;
import com.br.listgames.games.repository.GameGeneroRepository;
import com.br.listgames.games.repository.GameRepository;

@Service
public class GameGeneroService {
	
	// Fazendo injeção de dependência com a camada Repository
	private GameGeneroRepository gameGeneroRepository;
	
	public GameGeneroService(GameGeneroRepository gameGeneroRepository) {
		this.gameGeneroRepository = gameGeneroRepository;
	}
	
	
	/*Fazendo a injeção de dependência com a anotação do frame*/
	@Autowired
	private GameRepository gameRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameGeneroDTO> findAll() {
		List<GameGenero> games = gameGeneroRepository.findAll();
		List<GameGeneroDTO> gamesGeneroDTO = games.stream().map(dados -> new GameGeneroDTO(dados)).toList();
		return gamesGeneroDTO;
	}
	
	
	@Transactional(readOnly = true)
	/*Este método é responsável pela movimentação das colocações dos jogos que o usuário fizer na listagem do front*/
	public void updateIndexListaDeGenero(Long generoId, int sourceIndex, int destinationIndex) {
		//Trago a lista de jogo por gênero, pois no front será exibida assim
		List<GameSmallProjections> listGeneroGamesById = gameRepository.searchListGeneroById(generoId);
		
		//Agora vou aplicar a técnica de movimentação dos indexs dos jogos feitos no front
		GameSmallProjections gameMovimentadoNoFront = listGeneroGamesById.remove(sourceIndex);
		
		//Inserir o objeto acima na posição destination
		listGeneroGamesById.add(destinationIndex, gameMovimentadoNoFront);
		
		/*Agora tenho que atualizar a position destes jogos na tabela RelacionamentoGameComGameGenero: 
		Dado ID do jogo e ID do gênero, atualizo:*/
		int positionMin = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int positionMax = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = positionMin; i <= positionMax; i++) {
			String valueListGeneroById = listGeneroGamesById.get(i).getTitle();
			gameGeneroRepository.updateRelacionamentoGameComGameGeneroPosition(generoId, listGeneroGamesById.get(i).getId(), i);
		}
	}
	
	
}












