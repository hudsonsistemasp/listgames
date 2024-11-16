package com.br.listgames.games.dto;

import com.br.listgames.games.entities.Game;
import com.br.listgames.games.projections.GameSmallProjections;

public class GameSmallViewDTO {

	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;

	public GameSmallViewDTO() {
	}
	
	public GameSmallViewDTO(Game gameEntity) {
		this.id = gameEntity.getId();
		this.title = gameEntity.getTitle();
		this.year = gameEntity.getYear();
		this.imgUrl = gameEntity.getImgUrl();
		this.shortDescription = gameEntity.getShortDescription();
	}
	
	public GameSmallViewDTO(GameSmallProjections projectionSql) {
		this.id = projectionSql.getId();
		this.title = projectionSql.getTitle();
		this.year = projectionSql.getYear();
		this.imgUrl = projectionSql.getImgUrl();
		this.shortDescription = projectionSql.getShortDescription();
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
