package com.br.listgames.games.dto;

import org.springframework.beans.BeanUtils;

import com.br.listgames.games.entities.Game;

public class GameLargeDTO {
	
	private Long id;
	private String title;
	private Integer year;
	private String genre;
	private String platforms;
	private Double score;	
	private String imgUrl;
	private String shortDescription;
	private String longDescription;
	
	public GameLargeDTO() {
		
	}
	
	
	/* 1° Forma mais verbosa:
	 * Este construtor pode ser substituido por uma classe utilitária do framework: 
	 * BeanUtils, mas para isso os nomes dos atributos das classes de origem e de destino 
	 * tem que ser iguais para ele preencher tudo automaticamente economizando sintaxe. 
	public GameLargeDTO(Game game) {
		this.id = game.getId();
		this.title = game.getTitle();
		this.year = game.getYear();
		this.genre = game.getGenre();
		this.platforms = game.getPlatforms();
		this.score = game.getScore();
		this.imgUrl = game.getImgUrl();
		this.shortDescription = game.getShortDescription();
		this.longDescription = game.getLongDescription();
	}
	*/
	
	/* 2° Forma menos verbosa: os nomes dos atributos das classes de origem e de destino 
	 * tem que ser iguais para ele preencher tudo automaticamente economizando sintaxe.
	 * Mas esse BeanUtils necessita de ter GET e SET para todos atributos, o que não precisaria
	 * com a 1° forma ou como foi feito no GameSmallDTO. */
	public GameLargeDTO(Game game) {
		BeanUtils.copyProperties(game, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
	
}
