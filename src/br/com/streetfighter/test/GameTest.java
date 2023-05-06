package br.com.streetfighter.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.streetfighter.*;
import br.com.streetfighter.characters.*;

public class GameTest {

	@Test
	public void testStartGameForTwoPlayers() {
		// criação dos jogadores e lutadores
		Fighter fighter1 = new Ryu("Ryu", 100.0, 10.0, new Special("Hadouken", 50.0));
		Fighter fighter2 = new Guile("Guile", 100.0, 20.0, new Special("Sonic Boom", 40.0));
		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");
		player1.selectFighter(fighter1);
		player2.selectFighter(fighter2);
		
		// criação do jogo e criação da partida através do método startGameForTwoPlayers
		Game game = new Game();
		game.startGameForTwoPlayers(player1, player2);
		
		// teste se ambos os jogadores têm um lutador selecionado
		assertNotNull(player1.getFighter());
		assertNotNull(player2.getFighter());
	}

	@Test
	public void testBothAlive() {
		// criação dos jogadores e lutadores
		Fighter fighter1 = new Zangief("Zangief", 100.0, 10.0, new Special("Spinning Piledriver", 50.0));
		Fighter fighter2 = new Blanka("Blanka", 100.0, 20.0, new Special("Electric Thunder", 40.0));
		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");
		player1.selectFighter(fighter1);
		player2.selectFighter(fighter2);

		// criação do jogo e criação da partida através do método startGameForTwoPlayers
		Game game = new Game();
		game.startGameForTwoPlayers(player1, player2);

		// checa se ao menos um dos lutadores está sem pontos de vida ao final da luta
		assertFalse(game.bothAlive());
	}

	@Test
	void testAttackShouldReduceLifePointsWhenAttackerHitsDefender() {
		// criação dos jogadores e lutadores
		Fighter fighter1 = new Zangief("Zangief", 100.0, 10.0, new Special("Spinning Piledriver", 50.0));
		Fighter fighter2 = new Guile("Guile", 100.0, 10.0, new Special("Sonic Boom", 50.0));
		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");
		player1.selectFighter(fighter1);
		player2.selectFighter(fighter2);

		// criação do jogo e chamada do método attack
		Game game = new Game();
		game.attack(player1, player2);

		// checa se o lutador 2 perdeu vida após o ataque do lutador 1
		assertTrue(fighter2.getLife() < 100);
	}

	@Test
	public void testSpecial() {
		// criação dos jogadores e lutadores
		Fighter fighter1 = new Ryu("Ryu", 100.0, 20.0, new Special("Hadouken", 40.0));
		Fighter fighter2 = new Blanka("Blanka", 100.0, 20.0, new Special("Electric Thunder", 40.0));
		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");
		player1.selectFighter(fighter1);
		player2.selectFighter(fighter2);

		// criação do jogo e chamada do método special
		Game game = new Game();
		game.special(player1, player2);

		// checa se o lutador 2 perdeu vida após o uso do special pelo lutador 1
		assertTrue(fighter2.getLife() < 100);
	}

}
