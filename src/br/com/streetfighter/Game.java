package br.com.streetfighter;

import java.util.Random;

public class Game {

	private Player player1;
	private Player player2;

	public void startGameForTwoPlayers(Player p1, Player p2) {
		
		player1 = p1;
		player2 = p2;

		Random random = new Random();
		
		System.out.println("Game started!\n");
		
		while (bothAlive()) {
			attack(player1, player2);
			if (bothAlive())
				attack(player2, player1);
			if (bothAlive() && random.nextBoolean())
				special(player1, player2);
			if (bothAlive() && random.nextBoolean())
				special(player2, player1);
		}
		
		System.out.println("\n\nGame ended!\n\n-----\n");
		
	}

	public boolean bothAlive() {
		return player1.getFighter().getLife() > 0 && player2.getFighter().getLife() > 0;
	}

	public void attack(Player p1, Player p2) {
		p1.getFighter().attack(p2.getFighter());
		if (p2.getFighter().getLife() > 0) {
			System.out.printf("%s's %s attacked %s's %s for %.0f damage. %s's %s still has %.0f life points left.\n",
					p1.getName(), p1.getFighter().getName(), p2.getName(),
					p2.getFighter().getName(), p1.getFighter().getPower(), p2.getName(),
					p2.getFighter().getName(), p2.getFighter().getLife());
		} else {
			System.out.printf("%s's %s attacked %s's %s for %.0f damage. %s's %s has no more life points left!\n",
					p1.getName(), p1.getFighter().getName(), p2.getName(),
					p2.getFighter().getName(), p1.getFighter().getPower(), p2.getName(),
					p2.getFighter().getName());
			System.out.printf("\n%s wins! %s's %s was left with %.0f life points.", p1.getName(),
					p1.getName(), p1.getFighter().getName(), p1.getFighter().getLife());
		}
	}

	public void special(Player p1, Player p2) {
		p1.getFighter().useSpecialPower(p2.getFighter());
		if (p2.getFighter().getLife() > 0) {
			System.out.printf(
					"SPECIAL! %s's %s used %s on %s's %s for %.0f damage! %s's %s still has %.0f life points left.\n",
					p1.getName(), p1.getFighter().getName(), p1.getFighter().getSpecial().getName(),
					p2.getName(), p2.getFighter().getName(),
					p1.getFighter().getSpecial().getValueSpecial(), p2.getName(),
					p2.getFighter().getName(), p2.getFighter().getLife());
		} else {
			System.out.printf(
					"SPECIAL! %s's %s used %s on %s's %s for %.0f damage! %s's %s has no more life points left!\n",
					p1.getName(), p1.getFighter().getName(), p1.getFighter().getSpecial().getName(),
					p2.getName(), p2.getFighter().getName(),
					p1.getFighter().getSpecial().getValueSpecial(), p2.getName(),
					p2.getFighter().getName());
			System.out.printf("\n%s wins! %s's %s was left with %.0f life points.", p1.getName(),
					p1.getName(), p1.getFighter().getName(), p1.getFighter().getLife());
		}
	}

}