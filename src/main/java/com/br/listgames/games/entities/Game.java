package com.br.listgames.games.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "tb_game")
public class Game implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8521246996830218306L;

	
	/*Para os @Getter e @Setter funcionar, tive que baixar para instalar o jar do lombok no eclipse: 
	 * 		https://projectlombok.org/downloads/lombok.jar*
	 * Quando o instalador abrir, basta apontar o diretório que está o executável, inclusive com
	 * o arquivo .exe, da IDE e instalar
	 * OU por powerShell, dentro do diretório em que estiver o jar do lombok para instalação:
	 * 		java -jar lombok.jar
	 * */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private Long id;
	
	@Getter @Setter	
	private String title;
	
	@Getter @Setter	
	@Column(name="game_year")
	private Integer year;
	
	@Getter @Setter	
	private String genre;

	@Getter @Setter
	private String platforms;
	
	@Getter @Setter	
	private Double score;

	@Getter @Setter
	private String imgUrl;
	
	@Getter @Setter	
	private String shortDescription;

	@Getter @Setter
	@Lob
	private String longDescription;
	
	
	
}
