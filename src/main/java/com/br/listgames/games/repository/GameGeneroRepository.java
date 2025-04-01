package com.br.listgames.games.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.listgames.games.entities.GameGenero;

@Repository
public interface GameGeneroRepository extends JpaRepository<GameGenero, Long>{

	//Se não for um SELECT, que usa somente @Query, usa-se o Modifying também.
	@Modifying
	@Query(nativeQuery = true, 
	value = "UPDATE tb_relacionamento_Game_Com_Game_Genero SET position = :newPosition WHERE game_genero_id = :generoId AND game_id = :gameId")
	
	void updateRelacionamentoGameComGameGeneroPosition(Long generoId, Long gameId, Integer newPosition);
	
}
