package com.br.listgames.games.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Relacionamento_Game_Com_Game_Genero")
public class RelacionamentoGameComGameGenero {
/*
 * Como é um um relacionamento 1...N e N...1, muitos para muitos, preciso dessa classe 
 * para representar, no modelo relacional do banco de dados, uma tabela de associação(intermediadora)
 * entre GAME e GAMELIST, como manda a teoria relacional: Duas chaves estrangeiras, onde
 * cada chave primária das classes GAME e GAMELIST, estarão contidas nesta classe intermediária.
 * Então para achar o Game na GameList, a chave primária dentro desta entidade é a ForeignKGAME + FKGAMELIST,
 * Resumindo: a chave primária desta classe é múltipla. Composição de 2 foreignKey: ForeignKGAME + FKGAMELIST 
 * 
 * Por estar num modelo de classe(objetos) e tenho a classe de Repository, no parâmetro pede-se 1 objeto e 1 ID e não 2...3,
 *temos que unificar as chaves para apontar no tipo do ID. Dai a necessidade de criar uma classe auxiliar para unificar as chaves;)
 *
 * Solução: cria mais 1 classe com as classes referidas acima GAME e GAMELIST, pois existe um relacionamento entre elas N...N. 
 * Depois eu as referencio aqui com a união das primary, abstraindo em um objeto da RelacionamentoGameComGameListPK da seguinte forma:
 */
	@EmbeddedId
	/*Como este objeto vai receber a união das das chaves, instanciar para não dar NullPointerException e ter acesso às chaves ID.*/
	private RelacionamentoGameComGameGeneroPK id = new RelacionamentoGameComGameGeneroPK();
	
	
/*No front, o usuário vai poder mudar a sequência de amostra do jogo na lista, arrastando com o mouse, como exemplo,
	 * e isto vai ter que ser atualizado no backend, ex: 1-SONIC e 2-Mário. User inverteu e os index terão que ser mudado
	 * e numa nova requisição no endpoint isto terá que ser refletido no backEnd, óbvio, dentro do Banco de dados.
*/
	private Integer position;

/*Por estar num modelo de classe(objetos) e tenho a classe de Repository, no parâmetro pede-se 1 objeto e 1 ID e não 2...3,
 *temos que unificar as chaves para apontar no tipo do ID. Dai a necessidade de criar uma classe auxiliar para unificar as chaves;)*/
	
	
	public RelacionamentoGameComGameGenero() {
	}
	
	public RelacionamentoGameComGameGenero(Game game, GameGenero gameList) {
		this.id.setGame(game);
		this.id.setGameList(gameList);
	}

	public RelacionamentoGameComGameGeneroPK getId() {
		return id;
	}

	public void setId(RelacionamentoGameComGameGeneroPK id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RelacionamentoGameComGameGenero other = (RelacionamentoGameComGameGenero) obj;
		return Objects.equals(id, other.id);
	}
	
	
}











