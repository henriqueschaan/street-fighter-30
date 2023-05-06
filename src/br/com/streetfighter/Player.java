package br.com.streetfighter;

public class Player {

	private String name;
	private Fighter fighter;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Fighter getFighter() {
		return fighter;
	}

	public void selectFighter(Fighter fighter) {
		this.fighter = fighter;
	}

}
