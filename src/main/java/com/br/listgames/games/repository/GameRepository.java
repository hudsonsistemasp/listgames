package com.br.listgames.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.listgames.games.entities.Game;
import com.br.listgames.games.projections.GameSmallProjections;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_relacionamento_game_com_game_genero.position
			FROM tb_game
			INNER JOIN tb_relacionamento_game_com_game_genero 
			ON tb_game.id = tb_relacionamento_game_com_game_genero.game_id
			WHERE tb_relacionamento_game_com_game_genero.game_genero_id = :GeneroId
			ORDER BY tb_relacionamento_game_com_game_genero.position
				""")
	List<GameSmallProjections> searchListGeneroById(Long GeneroId);
	/*Quando se usa uma nativeQuery, ou seja SQL, e não uma JPQL, o resultado dessa consulta tem que ser
	 * uma interface, ao qual se chama PROJECTION, é o que está na IGameSmallProjections.*/
}
