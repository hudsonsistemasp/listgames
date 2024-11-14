package com.br.listgames.games.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.listgames.games.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

}
