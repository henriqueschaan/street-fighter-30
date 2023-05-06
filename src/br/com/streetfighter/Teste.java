package br.com.streetfighter;

import br.com.streetfighter.characters.*;

public class Teste {

	public static void main(String[] args) {
		
		Special hadouken = new Special("Hadouken", 40.0);
		Ryu ryuplayer1 = new Ryu("Ryu", 100.0, 20.0, hadouken);
		Player player1 = new Player("Fulano");
		player1.selectFighter(ryuplayer1);
		
		Special shock = new Special("Electric Shock", 40.0);
		Blanka blankaplayer2 = new Blanka("Blanka", 100.0, 20.0, shock);
		Player player2 = new Player("Beltrano");
		player2.selectFighter(blankaplayer2);
		
		Game game = new Game();
		game.startGameForTwoPlayers(player1, player2);
		
	}

}
