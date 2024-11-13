package com.br.listgames.games.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_game")
public class Game implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8521246996830218306L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_game" )
	private Long id;
	
	private String title;
	
	@Column(name="game_year")
	private Integer year;
	
	private String genre;
	
	private String platforms;
	
	private Double score;
	
	private String imgUrl;
	
	private String shortDescription;
	
	private String longDescription;
	
	
	
	
}
