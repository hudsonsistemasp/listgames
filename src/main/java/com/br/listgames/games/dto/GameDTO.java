package com.br.listgames.games.dto;

import com.br.listgames.games.entities.Game;

public class GameDTO {

	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;

	public GameDTO() {
	}
	
	public GameDTO(Game gameEntity) {
		this.id = gameEntity.getId();
		this.title = gameEntity.getTitle();
		this.year = gameEntity.getYear();
		this.imgUrl = gameEntity.getImgUrl();
		this.shortDescription = gameEntity.getShortDescription();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public String getShortDescription() {
		return shortDescription;
	}
	
	
}
