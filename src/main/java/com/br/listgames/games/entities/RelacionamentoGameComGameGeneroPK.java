package com.br.listgames.games.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class RelacionamentoGameComGameGeneroPK {
	
	/*Referência às classes para eu puxar as primaryKey de cada classe.
	 * Então preciso ter os 2 objetos aqui e fazer as notações da JPA abaixo:*/
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;
	@ManyToOne
	@JoinColumn(name = "game_genero_id")
	private GameGenero gameList;
	
	public RelacionamentoGameComGameGeneroPK() {
	}
	
	public RelacionamentoGameComGameGeneroPK(Game game, GameGenero gameList) {
		this.game = game;
		this.gameList = gameList;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	public Game getGame() {
		return game;
	}
	
	public void setGameList(GameGenero gameList) {
		this.gameList = gameList;
	}
	public GameGenero getGameList() {
		return gameList;
	}
	/*Como é uma chave composta, o equalsAndHashCode precisa comparar a união das chaves e garantir que seja única*/
	@Override
	public int hashCode() {
		return Objects.hash(game, gameList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RelacionamentoGameComGameGeneroPK other = (RelacionamentoGameComGameGeneroPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(gameList, other.gameList);
	}
	
	
	
	
}
