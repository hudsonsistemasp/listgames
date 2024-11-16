package com.br.listgames.games.dto;

import com.br.listgames.games.entities.GameGenero;

public class GameGeneroDTO {
	
	private Long id;
	private String name;
	
	public GameGeneroDTO(GameGenero gameGenero) {
		this.id = gameGenero.getId();
		this.name = gameGenero.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}
