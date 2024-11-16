package com.br.listgames.games.projections;

public interface GameSmallProjections {
	
	//Aqui dentro coloca-se os métodos GET correspondente à consulta e aos nomes ou alias dela.
	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
	
}
