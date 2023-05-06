package br.com.streetfighter.characters;

import br.com.streetfighter.Fighter;
import br.com.streetfighter.Special;

public class Ryu extends Fighter {

	public Ryu(String name, Double life, Double power, Special special) {
		super(name, life, power, special);
	}

	@Override
	public void takeLife(Fighter fighter) {
		fighter.setLife(fighter.getLife() - getPower());
	}

	@Override
	public void attack(Fighter fighter) {
		this.takeLife(fighter);
	}

	@Override
	public void useSpecialPower(Fighter fighter) {
		fighter.setLife(fighter.getLife() - (getSpecial().getValueSpecial()));
	}

}
